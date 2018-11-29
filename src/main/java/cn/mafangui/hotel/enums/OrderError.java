package cn.mafangui.hotel.enums;

public enum OrderError {
    NONE(0,"没有空房"),
    ;
    private int code;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    OrderError(int code, String status) {
        this.code = code;
        this.status = status;
    }
}
