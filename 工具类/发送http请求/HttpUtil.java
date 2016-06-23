package com.lecloud.ipregion.common.util;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/**
 * Created by huangjin on 2016/4/14.
 */
public class HttpUtil {
    /**
     * 获取到客户端ip地址的方法
     *
     * @param request 请求对象
     * @return ip地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        final String[] split = StringUtils.split(ip, ",");
        if (ArrayUtils.getLength(split) > 1) {
            ip = StringUtils.trim(split[0]);
        }
        return ip;
    }


    /**
     * 输出到页面
     *
     * @param response servlet内置对象
     * @param data     输出内容
     */
    public static void write(HttpServletResponse response, String data) {
        if (Objects.isNull(response) || StringUtils.isBlank(data)) {
            return;
        }
        try {
            response.getWriter().write(data.toCharArray());
        } catch (IOException ignore) {
        }
    }

    public static String get(String url, Map<String, Object> param) {
        Preconditions.checkNotNull(url, "url不能为空");
        Preconditions.checkNotNull(param, "传参不能为空");

        StringBuilder queryParams = new StringBuilder(url);
        int length = queryParams.length();
        param.forEach((x, y) -> {
            if (queryParams.length() == length) {
                queryParams.append("?");
            } else {
                queryParams.append("&");
            }
            queryParams.append(x).append("=").append(y);
        });
        HttpGet httpget = new HttpGet(queryParams.toString());
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpClient.execute(httpget)) {
            HttpEntity entity = response.getEntity();
            if (Objects.nonNull(entity)) {
                return EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException ignore) {
            }
        }

        return "";
    }

    public static String urlEncodeWithNoException(String source) {
        try {
            return URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException ignore) {
        }

        return null;
    }

    public static String getCookieValue(HttpServletRequest httpRequest, String cookieName) {
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


    public static Boolean isAjax(HttpServletRequest httpServletRequest) {
        String requestType = httpServletRequest.getHeader("X-Requested-With");
        return StringUtils.equalsIgnoreCase("XMLHttpRequest", requestType);
    }
}