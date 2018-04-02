package com.chuangbu.rpc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chuangbu.rpc.constants.RPCSqlConstants;
import com.chuangbu.rpc.pojo.Treatment;

/**
 * @Title: DrugDao.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月2日 下午6:15:26
 * @version V1.0
 */
@Repository
public class TreatmentDao extends BaseDao{

	@Transactional(readOnly = true)
	public List<Treatment> findAll() {
		return jdbcTemplate.query(RPCSqlConstants.QUERY_TREATMENT_ALL, new TreatmentRowMapper());
	}
	
	@Transactional(readOnly = true)
	public List<Treatment> findByGeneralName(String generalName) {
		return jdbcTemplate.query(dBQuerySql.getTreatmentData(),new Object[]{"%"+generalName+"%","%"+generalName+"%"}, new TreatmentRowMapper());
	}

	class TreatmentRowMapper implements RowMapper<Treatment> {

		@Override
		public Treatment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Treatment treatment = new Treatment();
			treatment.setCode(rs.getString("code"));
			treatment.setGeneralName(rs.getString("generalName"));
			treatment.setUnit(rs.getString("unit"));
			treatment.setPrice(rs.getString("price"));

			return treatment;
		}

	}
}
