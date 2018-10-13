package cn.mafangui.hotel.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RoomType {
    private Integer typeId;

    private Integer roomType;

    private String typeName;

    private BigDecimal bookingPrice;

    private Float bookingDiscount;

    private Date createTime;

    private Date updateTime;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public BigDecimal getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(BigDecimal bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public Float getBookingDiscount() {
        return bookingDiscount;
    }

    public void setBookingDiscount(Float bookingDiscount) {
        this.bookingDiscount = bookingDiscount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}