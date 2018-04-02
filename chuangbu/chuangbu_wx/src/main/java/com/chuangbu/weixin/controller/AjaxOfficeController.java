package com.chuangbu.weixin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chuangbu.common.util.RandomGUID;
import com.chuangbu.core.orm.hospital.domain.FollowUpRecordLog;
import com.chuangbu.core.service.hospital.FollowUpRecordLogService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/ajax/office/")
public class AjaxOfficeController extends AdstractController{
	private static final Logger logger = LoggerFactory.getLogger(AjaxOfficeController.class);
	
	@Value("${chuangbu.hosp.follow-up.record.path:null}")
	private String recordPath = null;
	
	@Autowired
	FollowUpRecordLogService followUpRecordLogService;

	@RequestMapping(value = "/followUp/record/list")
	@ResponseBody
	public String getFollowUpRecordList(@RequestParam("pageSize") String pageSize,
			@RequestParam("pageIndex") String pageIndex,@RequestParam("patientId") String patientId) {
		
		String result ;
		if(StringUtils.isNotBlank(patientId)){

			FollowUpRecordLog log = new FollowUpRecordLog();
			log.setPatientId(patientId);
			JSONArray arvert = JSONArray.fromObject(followUpRecordLogService.find(log));  
			SECCESS.put("data", arvert.toString());
			return JSONObject.fromObject(SECCESS).toString();
		}else{
			result = JSONObject.fromObject(FAIL).toString();
		}
		return result;
	}
	@RequestMapping(value = "/followUp/record/upload")
	@ResponseBody
	public String handleFollowUpRecordUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				
				FollowUpRecordLog log = new FollowUpRecordLog();
				log.setId(RandomGUID.getGUID());
				log.setName(file.getOriginalFilename());
				log.setPath(file.getOriginalFilename());
				log.setCt( new Timestamp(System.currentTimeMillis()));
				followUpRecordLogService.save(log);
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(new File(recordPath+file.getOriginalFilename())));
				out.write(file.getBytes());
				out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				logger.error("上传失败",e);
				return "上传失败," + e.getMessage();
			} catch (IOException e) {
				logger.error("上传失败",e);
				return "上传失败," + e.getMessage();
			}
			
			return "上传成功";
		} else {
			return "上传失败，因为文件是空的.";
		}
	}

}
