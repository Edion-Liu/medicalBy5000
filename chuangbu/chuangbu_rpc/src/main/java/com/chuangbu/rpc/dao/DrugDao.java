package com.chuangbu.rpc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chuangbu.rpc.constants.RPCSqlConstants;
import com.chuangbu.rpc.pojo.Drug;

/**
 * @Title: DrugDao.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月2日 下午6:15:26
 * @version V1.0
 */
@Repository
public class DrugDao extends BaseDao{

	@Transactional(readOnly = true)
	public List<Drug> findAll() {
		return jdbcTemplate.query(RPCSqlConstants.QUERY_TREATMENT_ALL, new DrugRowMapper());
	}
	
	@Transactional(readOnly = true)
	public List<Drug> findByGeneralName(String generalName) {
		return jdbcTemplate.query(dBQuerySql.getDrugData(),new Object[]{"%"+generalName+"%","%"+generalName+"%"}, new DrugRowMapper());
	}

	class DrugRowMapper implements RowMapper<Drug> {

		@Override
		public Drug mapRow(ResultSet rs, int rowNum) throws SQLException {
			Drug drug = new Drug();
			drug.setCode(rs.getString("code"));
			drug.setGeneralName(rs.getString("generalName"));
			drug.setSpec(rs.getString("spec"));

			return drug;
		}

	}
}
