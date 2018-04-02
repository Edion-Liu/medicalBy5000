package com.chuangbu.core.service.hospital;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.common.util.Arith;
import com.chuangbu.core.orm.hospital.domain.OutpatientOrder;
import com.chuangbu.core.orm.hospital.mapper.OutpatientOrderMapper;

/**
 * Description: t_outpatient_order Service Copyright: ©2017 chuangbu. All rights
 * reserved.
 * 
 * @author xjc Created on: 2017-08-27 20:29:23
 */
@Service
public class OutpatientOrderService extends AbstractService<OutpatientOrder, Serializable> {

	@Autowired
	OutpatientOrderMapper mapper;

	@Override
	protected GenericDao<OutpatientOrder, Serializable> getDao() {
		return mapper;
	}

	public void saveOrderInfo(String id ,String outpatientNo, String certificateNo, String charge, String spBillCreateIP,
			String openId, String outTradeNo, String body, String prepayId, String appId, String mchId,
			String prescNoAll, String serialNo, String customerName, String doctorName, String deptName, boolean flag) {
		OutpatientOrder po = new OutpatientOrder();
		po.setId(id);
		po.setOutpatientNo(outpatientNo);
		po.setCertificateNo(certificateNo);
		po.setPrepayId(prepayId);
		po.setAppid(appId);
		po.setMchId(mchId);
		po.setBody(body);
		po.setOutTradeNo(outTradeNo);
		double total = Arith.mul(Double.valueOf(charge), 100d);
		po.setTotalFee((int) total);
		po.setSpbillCreateIp(spBillCreateIP);
		po.setOpenid(openId);
		po.setStatus(OutpatientOrder.ORDER_INIT);// 预付款状态
		po.setPrescNo(prescNoAll);
		po.setCt(new Timestamp(System.currentTimeMillis()));
		po.setSerialNo(serialNo);
		po.setCustomerName(customerName);
		po.setDeptName(deptName);
		po.setDoctorName(doctorName);
		if(flag){
			mapper.save(po);
		}else{
			mapper.update(po);
		}
	}

	/**
	 * 修改订单状态
	 * @param outTradeNo
	 * @param transactionId
	 * @param status
	 * @param outpatientNo
	 * @param appId 
	 */
	public void updateOrderStatus(String outTradeNo, String transactionId, String status, String outpatientNo, String id) {
		OutpatientOrder po = new OutpatientOrder();
		po.setStatus(status);
		po.setTransactionId(transactionId);
		po.setOutpatientNo(outpatientNo);
		po.setId(id);
		mapper.update(po);
//		mapper.updateByOutpatientNo(po);
	}

	public OutpatientOrder findByOutTradeNo(String appId,String outTradeNo) {
		OutpatientOrder po = new OutpatientOrder();
		po.setAppid(appId);
		po.setOutTradeNo(outTradeNo);
		List<OutpatientOrder> list = mapper.find(po);
		return list != null && list.size()>0? list.get(0) : null;
	}
}