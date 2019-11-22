package cn.mafangui.hotel.response;


/**
 * 消息类型描述
 */
public enum MsgType {
    SUCCESS(1000,"success"),
    FAILED(1001,"Failure"),

    PARAM_IS_INVALID(1100,"参数非法")

    ;
    private Integer code;
    private String message;
    MsgType() {
    }
    MsgType(Integer code) {
        this.code = code;
    }
    MsgType(Integer code, String message) {
        this.code = code;
        this.message = message;
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
}
