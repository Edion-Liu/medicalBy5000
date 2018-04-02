package com.chuangbu.core.service.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月30日 下午11:25:36
 */
@Service
public class PayService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PayService.class);

	@Value("${chuangbu.pay.tencent.redirectUri:null}")
	private String redirectUri = null;
	
	public String payOrder(String url){
		//1、获取配置信息
		//2、生成订单
		//3、本地保存数据
		//4、生成微信订单
		//5、修改本地订单状态
		
		return null;
	}

}
