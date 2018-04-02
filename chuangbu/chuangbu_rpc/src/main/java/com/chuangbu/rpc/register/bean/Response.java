package com.chuangbu.rpc.register.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月30日 下午2:50:04
 */
@XStreamAlias("Response") 
public class Response {
	
	private Header Header;
	private Body Body;
	
	public Header getHeader() {
		return Header;
	}
	public void setHeader(Header header) {
		Header = header;
	}
	public Body getBody() {
		return Body;
	}
	public void setBody(Body body) {
		Body = body;
	}

}
