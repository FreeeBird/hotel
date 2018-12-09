package cn.mafangui.hotel.entity;

import java.util.Date;

public class CheckIn {
    private Integer checkInId;

    private Integer orderId;

    private Integer roomId;

    private String roomNumber;

    private Integer peoCount;

    private String persons;

    private String ids;

    private Date checkInTime;

    private Date checkOutTime;

    private Date createTime;

    private Date updateTime;

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getPeoCount() {
        return peoCount;
    }

    public void setPeoCount(Integer peoCount) {
        this.peoCount = peoCount;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons == null ? null : persons.trim();
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
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

    public CheckIn() {
    }

    public CheckIn(Integer roomId,String roomNumber, Integer peoCount, String persons, String ids, Date checkInTime) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.peoCount = peoCount;
        this.persons = persons;
        this.ids = ids;
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "checkInId=" + checkInId +
                ", orderId=" + orderId +
                ", roomNumber='" + roomNumber + '\'' +
                ", peoCount=" + peoCount +
                ", persons='" + persons + '\'' +
                ", ids='" + ids + '\'' +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
