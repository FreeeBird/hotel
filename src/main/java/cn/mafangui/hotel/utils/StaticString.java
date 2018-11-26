package cn.mafangui.hotel.utils;

public class StaticString {
    public static final String CODE = "code";
    public static final String STATUS = "status";
    public static final String DATA = "data";

    /**
     * 工作人员角色
     */
    public static final String ADMIN = "admin";
    public static final String OPERATOR = "operator";

    /**
     * 房间状态
     * 不可用
     * 空闲可用
     * 已被预订
     * 已被入住
     */
    public static final int UNAVAILABLE = 0;
    public static final int AVAILABLE = 1;
    public static final int OCCUPIED = 2;
    public static final int IN_USE = 3;
    /**
     * 订单状态
     * 被用户删除-3
     * 超时 -2
     * 被取消-1
     * 未付款0
     * 已付款1
     * 已入住2
     *
     */
    public static final int WAS_DELETE = -3;
    public static final int OVERTIME = -2;
    public static final int WAS_CANCELED = -1;
    public static final int UNPAID = 0;
    public static final int PAID = 1;
    public static final int WAS_USED = 2;


}
