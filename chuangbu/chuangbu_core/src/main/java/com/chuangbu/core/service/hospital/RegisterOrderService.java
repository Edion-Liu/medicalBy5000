package com.chuangbu.core.service.hospital;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuangbu.common.core.orm.dao.GenericDao;
import com.chuangbu.common.core.service.AbstractService;
import com.chuangbu.common.util.Arith;
import com.chuangbu.common.util.RandomGUID;
import com.chuangbu.core.orm.hospital.domain.RegisterOrder;
import com.chuangbu.core.orm.hospital.mapper.RegisterOrderMapper;

/**
 * Description: t_register_order Service
 * Copyright: ©2017 chuangbu. All rights reserved.
 * @author xjc
 * Created on: 2017-06-11 23:28:43
 */
@Service
public class RegisterOrderService extends AbstractService<RegisterOrder,Serializable>{

	@Autowired
	RegisterOrderMapper mapper;
	
	@Override
	protected GenericDao<RegisterOrder, Serializable> getDao() {
		return mapper;
	}
	
	public void saveOrderInfo(String CardID, String CustomerName, String CertificateNo, String PhoneCode,
			String DeptCode, String DocterCode, String charge, String spBillCreateIP, String openId, String ChargeNo,
			String body,String prepayId ,String appId,String mchId, String deptName, String doctorName) {
		RegisterOrder po = new RegisterOrder();
		po.setId(RandomGUID.getGUID());
		po.setAppid(appId);
		po.setMchId(mchId);
		po.setBody(body);
		po.setOutTradeNo(ChargeNo);
		double total = Arith.mul(Double.valueOf(charge), 100d);
		po.setTotalFee((int) total);
		po.setSpbillCreateIp(spBillCreateIP);
		po.setOpenid(openId);
		po.setStatus(RegisterOrder.ORDER_INIT);//预付款状态
		po.setCardId(CardID);
		po.setCustomerName(CustomerName);
		po.setCertificateNo(CertificateNo);
		po.setPhoneCode(PhoneCode);
		po.setDeptCode(DeptCode);
		po.setDeptName(deptName);
		po.setDocterCode(DocterCode);
		po.setDoctorName(doctorName);
		po.setPrepayId(prepayId);
		po.setCt(new Timestamp(System.currentTimeMillis()));
		mapper.save(po);
	}

	/**
	 * 修改订单状态
	 * @param visitDate 
	 * @param out_trade_no
	 * @param string
	 */
	public void updateOrderStatus(String outTradeNo,String transactionId, String status,String outpatientNo,String serialNo,String indexNo,String deptPosition, String visitDate,String appId) {
		RegisterOrder po = new RegisterOrder();
		po.setOutTradeNo(outTradeNo);
		po.setStatus(status);
		po.setTransactionId(transactionId);
		po.setOutpatientNo(outpatientNo);
		po.setSerialNo(serialNo);
		po.setIndexNo(indexNo);
		po.setDeptPosition(deptPosition);
		po.setVisitDate(visitDate);
		po.setAppid(appId);
		mapper.updateByOutTradeNo(po);
	}
	
	public RegisterOrder findByOutTradeNo(String appId, String outTradeNo){
		RegisterOrder po = new RegisterOrder();
		po.setAppid(appId);
		po.setOutTradeNo(outTradeNo);
		List<RegisterOrder> pos =  mapper.find(po);
		return pos!=null && pos.size()>0 ? pos.get(0):null;
	}
	
	public int findByOpenIdAndDayCount(RegisterOrder po){
		
		int count =  mapper.findByOpenIdAndDayCount(po);
		return count;
		
	}
}