package cn.mafangui.hotel.response;

import java.io.Serializable;

/**
 * 统一返回格式
 * Example:
 * {
 * code:100,
 * message: "NOT FOUND",
 * data:{}
 * }
 */
public class AjaxResult<T> implements Serializable {

    // 状态码
    private Integer code;
    // 信息
    private String message;
    // 数据
    private T data;

    public AjaxResult() {
    }

    public AjaxResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public AjaxResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(T data) {
        this.code = MsgType.SUCCESS.getCode();
        this.message = MsgType.SUCCESS.getMessage();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
