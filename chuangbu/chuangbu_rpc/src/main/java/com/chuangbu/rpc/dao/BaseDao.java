package com.chuangbu.rpc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.chuangbu.rpc.dao.sql.DBQuerySql;

/**   
* @Title: BaseDao.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 361cjx@163.com   
* @date 2017年2月4日 下午3:56:53 
* @version V1.0   
*/
public class BaseDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected DBQuerySql dBQuerySql;
	
}
