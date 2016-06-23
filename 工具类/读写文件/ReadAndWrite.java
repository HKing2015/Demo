package com.lecloud.ipregion.common.util;

import java.io.*;

/**
 * Created by huangjin on 2016/4/18.
 */
public class ReadAndWrite {
    public static void writeFile(String filePath, String sets)
            throws IOException {
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(sets);
        out.println();
        fw.close();
        out.close();
    }

    public static String ReadFile(String path) {
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }
}



//读写的文件路径要注意,如果在web项目里,要用如下方法获取classpath路径
String classPath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
//再在后面拼上对应的文件路径.

