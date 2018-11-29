package cn.mafangui.hotel.enums;

public enum RoomStatus {
    UNAVAILABLE(0,"不可用"),
    AVAILABLE(1,"空闲"),
    ORDERED(2,"被预订"),
    IN_USE(3,"已入住")
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


    RoomStatus(int code,String status) {
        this.code = code;
        this.status = status;
    }
}
