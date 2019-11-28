package cn.mafangui.hotel.response;


/**
 * 消息类型描述
 */
public enum MsgType {
    SUCCESS(1000,"SUCCESS"),
    FAILED(1001,"FAILURE"),

    PARAM_IS_INVALID(1001,"PARAM_IS_INVALID"),
    PERMISSION_DENIED(1002,"PERMISSION_DENIED"),
    NOT_LOGIN(1100,"NOT LOGIN");

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
