package com.chuangbu.pay.tencent.message;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月2日 上午11:44:20
 */

public class NewsMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;
 
    public String getContent() {
        return Content;
    }
 
    public void setContent(String content) {
        Content = content;
    }
}