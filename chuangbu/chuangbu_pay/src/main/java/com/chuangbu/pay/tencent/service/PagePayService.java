package com.chuangbu.pay.tencent.service;

import com.chuangbu.pay.tencent.bean.PagePayReqData;
import com.chuangbu.pay.tencent.common.Configure;

/**
 *  说 明 : 
 * @author  作 者：xjc
 * 邮 箱：361cjx@163.com
 * @version 版 本：V1.0
 * 时 间：2017年5月3日 上午12:15:37
 */

public class PagePayService extends BaseService{

	public PagePayService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.PAY_PAGE_API);
    }

    /**
     * 请求支付服务
     * @param scanPayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public String request(PagePayReqData pagePayReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(pagePayReqData);

        return responseString;
        
    }
}
