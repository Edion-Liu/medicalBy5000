package com.chuangbu.weixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.common.util.HttpRequestUtils;
import com.chuangbu.common.util.JSONUtil;
import com.chuangbu.common.util.RpcUtil;
import com.chuangbu.common.util.des3.Des3Util;
import com.chuangbu.core.orm.hospital.domain.TAppConfig;
import com.chuangbu.core.orm.hospital.domain.TDeptInfo;
import com.chuangbu.core.orm.hospital.domain.TDocterInfo;
import com.chuangbu.core.service.hospital.TAppConfigService;
import com.chuangbu.core.service.hospital.TDeptInfoService;
import com.chuangbu.core.service.hospital.TDocterInfoService;
import com.chuangbu.weixin.constants.Constants;

import net.sf.json.JSONObject;


@Controller
@RequestMapping(value = "/ajax/common/")
public class AjaxController extends AdstractController{
	
	private Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
    private TAppConfigService tAppConfigService;
	
	@Autowired
	private TDeptInfoService tDeptInfoService;
	@Autowired
	private TDocterInfoService tDocterInfoService;

	@RequestMapping(value = "/drug/data")
	@ResponseBody
	public String drugData(HttpServletRequest request,@RequestParam("pageSize") String pageSize,
			@RequestParam("pageIndex") String pageIndex, @RequestParam("generalName") String generalName) {
		String result ;
		if(StringUtils.isNotBlank(generalName)){
			
			String url = String.format(Constants.RPC_DRUG_URL,getRpcUrl(request),getToken(),pageSize,pageIndex,generalName);
			result = HttpRequestUtils.httpPost(url, null);
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		return result;
	}
	
	@RequestMapping(value = "/treatment/data")
	@ResponseBody
	public String treatmentData(HttpServletRequest request,@RequestParam("pageSize") String pageSize,
			@RequestParam("pageIndex") String pageIndex, @RequestParam("generalName") String generalName) {
		String result ;
		if(StringUtils.isNotBlank(generalName)){
			String url = String.format(Constants.RPC_TREATMENT_URL,getRpcUrl(request),getToken(),pageSize,pageIndex,generalName);
			result = HttpRequestUtils.httpPost(url, null);
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		return result;
	}
	
	@RequestMapping(value = "/register/mzghService/dept")
	@ResponseBody
	public String mzghServiceDept(HttpServletRequest request) {
		logger.info("@@调用科室接口开始:{}",getRpcUrl(request));
		String result ;
			String url = String.format(Constants.RPC_MZGHSERVICE_DEPT_URL,getRpcUrl(request),getToken());
			result = HttpRequestUtils.httpPost(url, null);
		logger.info("调用接口结束，结果:{}",result);
		return result;
	}
	@RequestMapping(value = "/register/mzghService/docter")
	@ResponseBody
	public String mzghServiceDocter(HttpServletRequest request,@RequestParam("deptCode") String deptCode) {
		logger.info("##调用医生接口开始:{}",getRpcUrl(request));
		String result ;
		if(StringUtils.isNotBlank(deptCode) ){
			String url = String.format(Constants.RPC_MZGHSERVICE_DOCTER_URL,getRpcUrl(request),RpcUtil.getToken(Constants.RPC_KEY),deptCode);
			result = HttpRequestUtils.httpPost(url, null);
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		
		return result;
	}
	
	@RequestMapping(value = "/register/mzghService/per")
	@ResponseBody
	public String mzghServicePer(HttpServletRequest request,@RequestParam("cardNo") String cardNo) {
		logger.info("调用接口开始参数【{}】,接口路径:{}",cardNo,getRpcUrl(request));
		String result ;
		if(StringUtils.isNotBlank(cardNo) ){
			String url = String.format(Constants.RPC_MZGHSERVICE_PER_URL,getRpcUrl(request),getToken(),cardNo);
			logger.info("调用接口开始--转换后的接口路径:{}",url);
			result = HttpRequestUtils.httpPost(url, null);
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		
		return result;
	}
	
	@RequestMapping(value = "/outpatient/mzsfService/query")
	@ResponseBody
	public String mzghServiceOutpatient(HttpServletRequest request,@RequestParam("OutpatientNo") String OutpatientNo,
			@RequestParam("CertificateNo") String CertificateNo) {
		logger.info("调用门诊信息查询接口开始参数：门诊号【{}】，身份证号【{}】,接口路径:{}",OutpatientNo,CertificateNo,getRpcUrl(request));
		String result ;
		if(StringUtils.isNotBlank(OutpatientNo) || StringUtils.isNotBlank(CertificateNo)){
			String url = String.format(Constants.RPC_MZSFSERVICE_OUTPATIENT_QUERY_URL,getRpcUrl(request),getToken(),OutpatientNo.trim(),CertificateNo.trim());
			logger.info("调用接口开始--转换后的接口路径:{}",url);
			result = HttpRequestUtils.httpPost(url, null);
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		
		return result;
	}
	
	@RequestMapping(value = "/encryption")
	@ResponseBody
	public String treatmentData(@RequestParam("isEncry") String isEncry,
			@RequestParam("content") String content) {
		String result ;
		if(StringUtils.isNotBlank(isEncry) && StringUtils.isNotBlank(content)){
			if("yes".equals(isEncry)){
				content = Des3Util.encode(content);
			}else{
				content = Des3Util.decode(content);
			}
			SECCESS.put("data", content);
			result = JSONObject.fromObject(SECCESS).toString();
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		return result;
	}
	
	@RequestMapping(value = "/getDeptMenu")
	@ResponseBody
	public String getDeptMenu(HttpServletRequest request) {
		String result ;
		String appId = getAppId(request);
        if(StringUtils.isNotBlank(appId)){
        	TDeptInfo dept = new TDeptInfo();
        	dept.setValid((short) 1);
        	dept.setOrderBy(" level , dis_order ");
        	dept.setOrgId(appId);
        	SECCESS.put("data", JSONUtil.toJson(tDeptInfoService.findMainInfo(dept)));
			result = JSONObject.fromObject(SECCESS).toString();
        }else{
        	result = JSONObject.fromObject(FAIL).toString();
        }
		return result;
	}
	@RequestMapping(value = "/getDeptData")
	@ResponseBody
	public String getDeptData(HttpServletRequest request,@RequestParam("deptId") String deptId) {
		String result ;
		String appId = getAppId(request);
		if(StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(deptId)){
			SECCESS.put("data", JSONUtil.toJson(tDeptInfoService.findOne(deptId)));
			result = JSONObject.fromObject(SECCESS).toString();
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		return result;
	}
	
	@RequestMapping(value = "/getDorterMenu")
	@ResponseBody
	public String getDorterMenu(HttpServletRequest request,@RequestParam(value="docterLavel" ,required=false) String docterLavel) {
		String result ;
		String appId = getAppId(request);
		if(StringUtils.isNotBlank(appId)){
			TDocterInfo docter = new TDocterInfo();
			docter.setOrgId(appId);
			docter.setValid((short) 1);
			docter.setOrderBy(" level , dis_order ");
			if(StringUtils.isNotBlank(docterLavel)){
				docter.setLevel(Integer.valueOf(docterLavel));	
			}
			SECCESS.put("data", JSONUtil.toJson(tDocterInfoService.findMainInfo(docter)));
			result = JSONObject.fromObject(SECCESS).toString();
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		
		return result;
	}
	@RequestMapping(value = "/getDorterData")
	@ResponseBody
	public String getDorterData(HttpServletRequest request,@RequestParam("docterId") String docterId) {
		String result ;
		String appId = getAppId(request);
		if(StringUtils.isNotBlank(appId) && StringUtils.isNotBlank(docterId)){
			
			SECCESS.put("data", JSONUtil.toJson(tDocterInfoService.findOne(docterId)));
			result = JSONObject.fromObject(SECCESS).toString();
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		
		return result;
	}
	
	private String getRpcUrl(HttpServletRequest request){
		TAppConfig conf = tAppConfigService.getTAppConfig(getAppId(request));
		return conf.getRpcUrl();
	}
}
