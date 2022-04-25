package com.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.admin.bean.AdminBean;
import com.admin.bean.SubjectBean;
import com.faculty.bean.FacultyBean;

@Repository
public class AdminDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	private final static class AdminMapper implements RowMapper<AdminBean> {

		@Override
		public AdminBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			AdminBean bean = new AdminBean();

			bean.setAid(rs.getInt("aid"));
			bean.setAfname(rs.getString("afname"));
			bean.setAlname(rs.getString("alname"));
			bean.setAemail(rs.getString("aemail"));
			bean.setApassword(rs.getString("apassword"));
			bean.setAphone(rs.getLong("aphone"));
			bean.setAdob(rs.getDate("adob"));
			bean.setAgender(rs.getString("agender"));

			return bean;
		}

	}

	public AdminBean checkLogin(String email, String password) {

		ArrayList<AdminBean> adminList = (ArrayList<AdminBean>) jdbcTemplate.query("select * from admin",
				new AdminMapper());

		for (int i = 0; i < adminList.size(); i++) {
			AdminBean bean = adminList.get(i);
			System.out.println("Email : " + email + " = " + bean.getAemail());

			if (email.equals(bean.getAemail()) && password.equals(bean.getApassword())) {
				System.out.println("Email : " + email + " = " + bean.getAemail());
				return bean;
			}
		}
		return null;
	}

	public int insertSub(SubjectBean bean) {
		return jdbcTemplate.update("insert into Subject(sub_id,sub_name) values(?,?)", bean.getSub_id(),
				bean.getSub_name());
	}

	public List<SubjectBean> subjects() {
		return jdbcTemplate.query("select * from Subject", new BeanPropertyRowMapper<SubjectBean>(SubjectBean.class));
	}

	public int deleteSubject(int sub_id) {
		return jdbcTemplate.update("delete from Subject where sub_id = ?", sub_id);
	}

	public SubjectBean subjectsByID(int sub_id) {
		return (SubjectBean) jdbcTemplate.queryForObject("select * from Subject where sub_id = ?",
				new BeanPropertyRowMapper<SubjectBean>(SubjectBean.class), new Object[] { sub_id });
	}

	public int updateSub(SubjectBean bean) {
		return jdbcTemplate.update("update Subject set sub_name = ? where sub_id = ?", bean.getSub_name(),
				bean.getSub_id());
	}

	public int insertFaculty(FacultyBean bean) {
		return jdbcTemplate.update(
				"insert into faculty(sub_id,fid,ffname,flname,femail,fpassword,fphone,fdob,fgender) values(?,?,?,?,?,?,?,?,?)",
				bean.getSub_id(), bean.getFid(), bean.getFfname(), bean.getFlname(), bean.getFemail(),
				bean.getFpassword(), bean.getFphone(), bean.getFdob(), bean.getFgender());
	}

	public List<FacultyBean> getAllFaculty() {
		return jdbcTemplate.query("select * from faculty natural join subject",
				new BeanPropertyRowMapper<FacultyBean>(FacultyBean.class));
	}

	public int deleteFaculty(int fid) {
		return jdbcTemplate.update("delete from Faculty where fid = ?", fid);
	}

	public int updateFaculty(FacultyBean bean) {
		return jdbcTemplate.update(
				"update Faculty set ffname = ?, flname = ?, femail = ?, fphone = ?, fdob = ?, fgender = ?, sub_id = ? where fid = ?",
				bean.getFfname(), bean.getFlname(), bean.getFemail(), bean.getFphone(), bean.getFdob(),
				bean.getFgender(), bean.getSub_id(), bean.getFid());
	}

	public FacultyBean facultyByID(int fid) {
		return (FacultyBean) jdbcTemplate.queryForObject("select * from faculty natural join subject where fid = ?",
				new BeanPropertyRowMapper<FacultyBean>(FacultyBean.class), new Object[] { fid });
	}

}
