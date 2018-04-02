package com.chuangbu.crm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuangbu.common.util.RandomGUID;
import com.chuangbu.common.util.security.Digests;
import com.chuangbu.common.util.security.Encodes;
import com.chuangbu.core.orm.sys.domain.SsUser;
import com.chuangbu.core.service.sys.SsUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping(value = "/ajax/")
public class AjaxSsUserController extends AdstractController{
	private static final Logger logger = LoggerFactory.getLogger(AjaxSsUserController.class);
	
	/** 加密方法 */
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	SsUserService ssUserService;

	@RequestMapping(value = "/ssUser/getData")
	@ResponseBody
	public Map<String, Object> getData(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex) {
		PageHelper.startPage(pageIndex,pageSize);
		
		List<SsUser> lists = ssUserService.findAll();
		PageInfo<SsUser> pageInfo = new PageInfo<SsUser>(lists);
        SECCESS.put("rows", JSONArray.fromObject(lists));//JSONArray
        SECCESS.put("total",pageInfo.getTotal());//总记录数
		return SECCESS;
	}
	
	@RequestMapping(value = "/ssUser/getData/{id}")
	@ResponseBody
	public Map<String, Object> getData(@PathVariable String id) {
		try {
			SsUser user = ssUserService.findOne(id);
			SECCESS.put("data", JSONObject.fromObject(user));//JSONArray
			SECCESS.put("msg","获取数据成功！");
		} catch (Exception e) {
			logger.error("操作失败",e);
			return FAIL;
		}
		return SECCESS;
	}
	
	@RequestMapping(value = "/ssUser/save")
	@ResponseBody
	public Map<String, Object> saveUser(@ModelAttribute("ssUser") SsUser ssUser) {
		try {
			SsUser user = new SsUser();
			user.setLoginName(ssUser.getLoginName());
			List<SsUser> lists = ssUserService.find(user);
			for(SsUser u : lists){
				if(u.getId().equals(ssUser.getId())){
					lists.remove(u);
					break;
				}
			}
			
			if(lists.isEmpty()){
				if(StringUtils.isBlank(ssUser.getId())){
					ssUser.setId(new RandomGUID().toString());
					entryptPassword(ssUser);
					ssUser.setCreatetime(new Date());
					ssUserService.save(ssUser);
				}else{
					entryptPassword(ssUser);
					ssUserService.update(ssUser);
				}
			}else{
				FAIL.put("msg","登录名已存在，请修改后再进行操作！");
				return FAIL;
			}
		} catch (Exception e) {
			logger.error("操作失败",e);
			return FAIL;
		}
		return SECCESS;
	}
	
	@RequestMapping(value = "/ssUser/remove")
	@ResponseBody
	public Map<String, Object> remove(@RequestParam("ids") String ids) {
		try {
			if(StringUtils.isNotBlank(ids)){
				for(String id : ids.split(",")){
					ssUserService.delete(id);
				}
			}
		} catch (Exception e) {
			logger.error("操作失败",e);
			return FAIL;
		}
		return SECCESS;
	}
	
	private static void entryptPassword(SsUser ssUser) {
		String pass = "123456";
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		ssUser.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(pass.getBytes(), salt, HASH_INTERATIONS);
		ssUser.setPassword(Encodes.encodeHex(hashPassword));
	}
}
