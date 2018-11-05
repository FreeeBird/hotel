package cn.mafangui.hotel.entity;


import cn.mafangui.hotel.utils.MyDateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomType {
    private Integer typeId;

    private Integer roomType;

    private String typeName;

    private Double bookingPrice;

    private Double bookingDiscount;

    private String remark;

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

    public Double getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(Double bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public Double getBookingDiscount() {
        return bookingDiscount;
    }

    public void setBookingDiscount(Double bookingDiscount) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public RoomType(Integer roomType, String typeName, Double bookingPrice, Double bookingDiscount,String remark) {
        this.roomType = roomType;
        this.typeName = typeName;
        this.bookingPrice = bookingPrice;
        this.bookingDiscount = bookingDiscount;
        this.remark = remark;
    }
    public RoomType(){}

    @Override
    public String toString() {
        return "RoomType{" +
                "typeId=" + typeId +
                ", roomType=" + roomType +
                ", typeName='" + typeName + '\'' +
                ", bookingPrice=" + bookingPrice +
                ", bookingDiscount=" + bookingDiscount +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}