public class Check {
    /**
     * 判断一个字符串是否全为数字
     * @param s
     * @return
     */
    public static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    
}