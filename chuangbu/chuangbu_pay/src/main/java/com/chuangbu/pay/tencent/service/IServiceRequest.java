package com.chuangbu.pay.tencent.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 *  说 明 : 这里定义服务层需要请求器标准接口
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月3日 上午12:13:01
 */

public interface IServiceRequest {
	
	//Service依赖的底层https请求器必须实现这么一个接口
    public String sendPost(String api_url,Object xmlObj) throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException;

}
