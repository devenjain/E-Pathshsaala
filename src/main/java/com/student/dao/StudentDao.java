package com.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.student.bean.StudentBean;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final static class StudentMapper implements RowMapper<StudentBean> {

		@Override
		public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			StudentBean bean = new StudentBean();

			bean.setSid(rs.getInt("sid"));
			bean.setSfname(rs.getString("sfname"));
			bean.setSmname(rs.getString("smname"));
			bean.setSlname(rs.getString("slname"));
			bean.setSemail(rs.getString("semail"));
			bean.setSpassword(rs.getString("spassword"));
			bean.setSdob(rs.getDate("sdob"));
			bean.setSgender(rs.getString("sgender"));
			bean.setSphone(rs.getLong("sphone"));

			return bean;
		}
	}

	public StudentBean checkLogin(String email, String password) {

		ArrayList<StudentBean> studentList = (ArrayList<StudentBean>) jdbcTemplate
				.query("select * from student natural join subject", new StudentMapper());

		for (int i = 0; i < studentList.size(); i++) {

			StudentBean bean = studentList.get(i);

			if (email.equals(bean.getSemail()) && password.equals(bean.getSpassword())) {
				return bean;
			}
		}
		return null;
	}

}
