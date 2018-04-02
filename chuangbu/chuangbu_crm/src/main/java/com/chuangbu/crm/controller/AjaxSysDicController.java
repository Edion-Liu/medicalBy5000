package com.chuangbu.crm.controller;

import java.util.List;

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
import com.chuangbu.core.orm.sys.domain.SysDictItem;
import com.chuangbu.core.orm.sys.domain.SysDictType;
import com.chuangbu.core.service.sys.SysDictItemService;
import com.chuangbu.core.service.sys.SysDictTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping(value = "/ajax/")
public class AjaxSysDicController extends AdstractController{
	private static final Logger logger = LoggerFactory.getLogger(AjaxSysDicController.class);
	
	@Autowired
	SysDictTypeService sysDictTypeService;
	@Autowired
	SysDictItemService sysDictItemService;

	@RequestMapping(value = "/sysDictType/getData")
	@ResponseBody
	public String getData(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex) {
		PageHelper.startPage(pageIndex,pageSize);
		
		List<SysDictType> lists = sysDictTypeService.findAll();
		PageInfo<SysDictType> pageInfo = new PageInfo<SysDictType>(lists);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("rows", JSONArray.fromObject(lists));//JSONArray
        jsonObject.put("total",pageInfo.getTotal());//总记录数
		return jsonObject.toString();
	}
	@RequestMapping(value = "/sysDictType/getData/{id}")
	@ResponseBody
	public String getData(@PathVariable String id) {
		JSONObject jsonObject=new JSONObject();
		try {
			SysDictType dic = sysDictTypeService.findOne(id);
			jsonObject.put("data", JSONObject.fromObject(dic));//JSONArray
			jsonObject.put("status", "ok");//JSONArray
			jsonObject.put("msg","获取数据成功！");
		} catch (Exception e) {
			logger.error("操作失败",e);
			jsonObject.put("status", "no");//JSONArray
			jsonObject.put("msg","获取数据失败！");
		}
		return jsonObject.toString();
	}
	@RequestMapping(value = "/sysDictType/save")
	@ResponseBody
	public String saveDictType(@ModelAttribute("dictType") SysDictType dictType) {
		JSONObject jsonObject=new JSONObject();
		try {
			SysDictType dictype = new SysDictType();
			dictype.setTypesign(dictType.getTypesign());
			List<SysDictType> lists = sysDictTypeService.find(dictype);
			for(SysDictType type : lists){
				if(type.getId().equals(dictType.getId())){
					lists.remove(type);
					break;
				}
			}
			
			if(lists.isEmpty()){
				if(StringUtils.isBlank(dictType.getId())){
					dictType.setId(new RandomGUID().toString());
					sysDictTypeService.save(dictType);
				}else{
					sysDictTypeService.update(dictType);
				}
				jsonObject.put("status", "ok");//JSONArray
				jsonObject.put("msg","操作成功！");
			}else{
				jsonObject.put("status", "no");//JSONArray
				jsonObject.put("msg","字典类型编码已存在，请修改后再进行操作！");
			}
		} catch (Exception e) {
			logger.error("操作失败",e);
			jsonObject.put("status", "no");//JSONArray
			jsonObject.put("msg","操作失败！");
		}
		return jsonObject.toString();
	}
	@RequestMapping(value = "/sysDictType/remove")
	@ResponseBody
	public String removeDictType(@RequestParam("ids") String ids) {
		JSONObject jsonObject=new JSONObject();
		try {
			if(StringUtils.isNotBlank(ids)){
				for(String id : ids.split(",")){
					 sysDictTypeService.delete(id);
				}
			}
			jsonObject.put("status", "ok");//JSONArray
			jsonObject.put("msg","删除成功！");
		} catch (Exception e) {
			logger.error("操作失败",e);
			jsonObject.put("status", "no");//JSONArray
			jsonObject.put("msg","删除失败！");
		}
		return jsonObject.toString();
	}
	
//	字典数据	
	@RequestMapping(value = "/sysDictItem/getData")
	@ResponseBody
	public String getDictItemData(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageIndex") Integer pageIndex) {
		PageHelper.startPage(pageIndex,pageSize);
		
		List<SysDictItem> lists = sysDictItemService.findAll();
		PageInfo<SysDictItem> pageInfo = new PageInfo<SysDictItem>(lists);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", JSONArray.fromObject(lists));//JSONArray
		jsonObject.put("total",pageInfo.getTotal());//总记录数
		return jsonObject.toString();
	}
	@RequestMapping(value = "/sysDictItem/getData/{id}")
	@ResponseBody
	public String getDictItemData(@PathVariable String id) {
		JSONObject jsonObject=new JSONObject();
		try {
			SysDictItem dic = sysDictItemService.findOne(id);
			jsonObject.put("data", JSONObject.fromObject(dic));//JSONArray
			jsonObject.put("status", "ok");//JSONArray
			jsonObject.put("msg","获取数据成功！");
		} catch (Exception e) {
			logger.error("操作失败",e);
			jsonObject.put("status", "no");//JSONArray
			jsonObject.put("msg","获取数据失败！");
		}
		return jsonObject.toString();
	}
	@RequestMapping(value = "/sysDictItem/save")
	@ResponseBody
	public String saveDictItem(@ModelAttribute("DictItem") SysDictItem dictItem) {
		JSONObject jsonObject=new JSONObject();
		try {
			/*SysDictItem dictype = new SysDictItem();
			dictype.setTypesign(dictItem.getTypesign());
			List<SysDictItem> lists = sysDictItemService.find(dictype);
			for(SysDictItem type : lists){
				if(type.getId().equals(dictItem.getId())){
					lists.remove(type);
					break;
				}
			}
			
			if(lists.isEmpty()){*/
				if(StringUtils.isBlank(dictItem.getId())){
					dictItem.setId(new RandomGUID().toString());
					sysDictItemService.save(dictItem);
				}else{
					sysDictItemService.update(dictItem);
				}
				jsonObject.put("status", "ok");//JSONArray
				jsonObject.put("msg","操作成功！");
//			}else{
//				jsonObject.put("status", "no");//JSONArray
//				jsonObject.put("msg","字典类型编码已存在，请修改后再进行操作！");
//			}
		} catch (Exception e) {
			logger.error("操作失败",e);
			jsonObject.put("status", "no");//JSONArray
			jsonObject.put("msg","操作失败！");
		}
		return jsonObject.toString();
	}
	@RequestMapping(value = "/sysDictItem/remove")
	@ResponseBody
	public String removeDictItem(@RequestParam("ids") String ids) {
		JSONObject jsonObject=new JSONObject();
		try {
			if(StringUtils.isNotBlank(ids)){
				for(String id : ids.split(",")){
					sysDictItemService.delete(id);
				}
			}
			jsonObject.put("status", "ok");//JSONArray
			jsonObject.put("msg","删除成功！");
		} catch (Exception e) {
			logger.error("操作失败",e);
			jsonObject.put("status", "no");//JSONArray
			jsonObject.put("msg","删除失败！");
		}
		return jsonObject.toString();
	}
	
}
