//枚举类的写法

public enum ResultMessage {
    SUCCESS(0, "成功"),

    EXCEPTION(-1, "IP格式错误"),
    NOTFOUND(-2, "没有查询到结果"),
    UNKNOWN(-3, "未知地区"),
    RESERVE(-4, "保留地址");




    public final int code;
    public final String message;

    ResultMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultMessage getResult(int code) {
        for (ResultMessage resultMessage : ResultMessage.values()) {
            if (resultMessage.code == code) {
                return resultMessage;
            }
        }
        return null;
    }
}
