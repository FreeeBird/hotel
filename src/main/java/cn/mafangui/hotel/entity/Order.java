package cn.mafangui.hotel.entity;

import java.util.Date;

public class Order {
    private Integer orderId;

    private String orderType;

    private int userId;

    private String phone;

    private String roomType;


    private Date orderDate;

    private Integer orderDays;

    private Integer orderStatus;

    private Double orderCost;

    private Date createTime;

    private Date updateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderDays() {
        return orderDays;
    }

    public void setOrderDays(Integer orderDays) {
        this.orderDays = orderDays;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Double orderCost) {
        this.orderCost = orderCost;
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

    public Order() {
    }

    public Order(String orderType, int userId, String phone, String roomType, Date orderDate, Integer orderDays, Integer orderStatus, Double orderCost) {
        this.orderType = orderType;
        this.userId = userId;
        this.phone = phone;
        this.roomType = roomType;
        this.orderDate = orderDate;
        this.orderDays = orderDays;
        this.orderStatus = orderStatus;
        this.orderCost = orderCost;
    }

    public Order(String orderType, String roomType, Date orderDate, Integer orderDays, Integer orderStatus, Double orderCost) {
        this.orderType = orderType;
        this.roomType = roomType;
        this.orderDate = orderDate;
        this.orderDays = orderDays;
        this.orderStatus = orderStatus;
        this.orderCost = orderCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderType='" + orderType + '\'' +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", roomType='" + roomType + '\'' +
                ", orderDate=" + orderDate +
                ", orderDays=" + orderDays +
                ", orderStatus=" + orderStatus +
                ", orderCost=" + orderCost +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}