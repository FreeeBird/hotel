package cn.mafangui.hotel.response;

import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.MsgType;

/**
 *  接口数据返回工具类
 *  成功则调用success
 *  失败则调用failed
 */
public class ResponseUtil {

    /**
     * 请求成功
     * @param object 数据
     * @return
     */
    public static AjaxResult<Object> success(Object object){
        return new AjaxResult<>(object);
    }

    /**
     * 请求失败
     * @param msgType 消息描述
     * @return
     */
    public static AjaxResult failed(MsgType msgType){
        return new AjaxResult(msgType.getCode(),msgType.getMessage());
    }

    public static AjaxResult failed(String  msg){
        return new AjaxResult(MsgType.FAILED.getCode(),msg);
    }
}
