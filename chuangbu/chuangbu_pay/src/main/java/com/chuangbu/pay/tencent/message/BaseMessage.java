package com.chuangbu.pay.tencent.message;

/**
 *  说 明 :消息基类（公众帐号 -> 普通用户） 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月2日 上午11:44:51
 */

public class BaseMessage {
	// 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/music/news）
    private String MsgType;
    // 位0x0001被标志时，星标刚收到的消息
    private int FuncFlag;
 
    public String getToUserName() {
        return ToUserName;
    }
 
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }
 
    public String getFromUserName() {
        return FromUserName;
    }
 
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }
 
    public long getCreateTime() {
        return CreateTime;
    }
 
    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }
 
    public String getMsgType() {
        return MsgType;
    }
 
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
 
    public int getFuncFlag() {
        return FuncFlag;
    }
 
    public void setFuncFlag(int funcFlag) {
        FuncFlag = funcFlag;
    }
}
