package com.chuangbu.rpc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chuangbu.rpc.pojo.Bar;
import com.chuangbu.rpc.pojo.Pie;

/**
 * @Title: DrugDao.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月2日 下午6:15:26
 * @version V1.0
 */
@Repository
public class StatisticalDao extends BaseDao{

	@Transactional(readOnly = true)
	public List<Pie> getIncomeData() {
		return jdbcTemplate.query(dBQuerySql.getIncomeData(), new PieRowMapper());
	}
	@Transactional(readOnly = true)
	public List<Bar> getInoutData() {
		return jdbcTemplate.query(dBQuerySql.getInoutData(), new BarRowMapper());
	}
	@Transactional(readOnly = true)
	public List<Bar> getWeekIncomeData() {
		return jdbcTemplate.query(dBQuerySql.getWeekIncomeData(), new BarRowMapper());
	}

	class PieRowMapper implements RowMapper<Pie> {
		@Override
		public Pie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pie pie = new Pie();
			pie.setName(rs.getString("_name"));
			pie.setValue(rs.getBigDecimal("_value"));
			return pie;
		}
	}
	
	class BarRowMapper implements RowMapper<Bar> {
		@Override
		public Bar mapRow(ResultSet rs, int rowNum) throws SQLException {
			Bar bar = new Bar();
			bar.setName(rs.getString("_name"));
			bar.setValue(rs.getBigDecimal("_value"));
			bar.setGroup(rs.getString("_group"));
			return bar;
		}
	}
}
