/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: xiejiuchun[xie_jc@suixingpay.com] 
 * @date: 2017年4月25日 下午3:35:47   
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.chuangbu.common.exception;

/**  
 * TODO
 * @author: xiejiuchun[xie_jc@suixingpay.com]
 * @date: 2017年4月25日 下午3:35:47
 * @version: V1.0
 * @review: TODO xiejiuchun[xie_jc@suixingpay.com]/2017年4月25日 下午3:35:47
 */
@SuppressWarnings("serial")
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
        super();
    }

    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRuntimeException(Throwable cause) {
        super(cause);
    }

    protected MyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}