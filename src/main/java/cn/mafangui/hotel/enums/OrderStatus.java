package cn.mafangui.hotel.enums;

public enum OrderStatus {
    WAS_DELETED(-3,"已删除"),
    OVERTIME(-2,"支付超时"),
    WAS_CANCELED(-1,"已取消"),
    UNPAID(0,"未付款"),
    PAID(1,"待入住"),
    CHECK_IN(2,"已入住")
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

    OrderStatus(int code, String status) {
        this.code = code;
        this.status = status;
    }
}
