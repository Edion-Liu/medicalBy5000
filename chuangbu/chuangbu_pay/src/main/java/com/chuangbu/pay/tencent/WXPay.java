package com.chuangbu.pay.tencent;

import com.chuangbu.pay.tencent.bean.PagePayReqData;
import com.chuangbu.pay.tencent.service.PagePayService;

/**
 * SDK总入口
 */
public class WXPay {

    

    /**
     * 请求支付服务
     * @param PagePayReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public static String requestPagePayService(PagePayReqData pagePayReqData) throws Exception{
        return new PagePayService().request(pagePayReqData);
    }

    /**
     * 请求支付查询服务
     * @param scanPayQueryReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
	/*public static String requestScanPayQueryService(ScanPayQueryReqData scanPayQueryReqData) throws Exception{
		return new ScanPayQueryService().request(scanPayQueryReqData);
	}*/

}
