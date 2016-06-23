public class MessageData<T> implements Serializable {
    
    private static final long serialVersionUID = 7422860863328163643L;
    //状态码
    private Integer code;
    //消息
    private String message;
    //数据
    private T data;

    public MessageData() {
        super();
    }

    public static <T> MessageData<T> build(Integer code, String message, T data) {
        MessageData<T> messageData=new MessageData<>();
        messageData.setMessage(message);
        messageData.setCode(code);
        messageData.setData(data);
        return messageData;
    }

    //传递ResultMessage
    public MessageData(ResultMessage resultMessage) {
        this.code = resultMessage.code;
        this.message = resultMessage.message;
        this.data = null;
    }

    public MessageData(ResultMessage resultMessage, T data) {
        this.code = resultMessage.code;
        this.message = resultMessage.message;
        this.data = data;
    }



    //传递UpdateAndAddMsg
    public MessageData(UpdateAndAddMsg updateAndAddMsg) {
        this.code = updateAndAddMsg.code;
        this.message = updateAndAddMsg.message;
        this.data = null;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
