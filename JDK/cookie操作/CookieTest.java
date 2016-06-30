import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cookieTest")
public class CookieTest {
	
	@RequestMapping(value="/test1", method = RequestMethod.GET)
	public Map<?,?> cookieTest(HttpServletResponse response, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Map<String, Object> map = new HashMap<>();
		for(Cookie cookie : cookies) {
			map.put(cookie.getName(), cookie.getPath());
		}
		
		Map<String, String[]> paramMap = request.getParameterMap();
		
		for(Entry<String, String[]> entry : paramMap.entrySet()) {
			System.out.println(entry.getKey() + "---" +  entry.getValue());
		}
		return map;
	}
}
