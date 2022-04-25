package com.faculty.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.faculty.bean.FacultyBean;
import com.faculty.bean.SubjectFileBean;
import com.student.bean.StudentBean;

@Repository
public class FacultyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}

	public void setTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

	private final static class FacultyMapper implements RowMapper<FacultyBean> {

		@Override
		public FacultyBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			FacultyBean bean = new FacultyBean();

			bean.setFid(rs.getInt("fid"));
			bean.setFfname(rs.getString("ffname"));
			bean.setFlname(rs.getString("flname"));
			bean.setFemail(rs.getString("femail"));
			bean.setFpassword(rs.getString("fpassword"));
			bean.setFdob(rs.getDate("fdob"));
			bean.setFgender(rs.getString("fgender"));
			bean.setFphone(rs.getLong("fphone"));
			bean.setSub_id(rs.getInt("sub_id"));
			bean.setSub_name(rs.getString("sub_name"));

			return bean;
		}
	}

	public FacultyBean checkLogin(String email, String password) {

		ArrayList<FacultyBean> facultyList = (ArrayList<FacultyBean>) jdbcTemplate
				.query("select * from faculty natural join subject", new FacultyMapper());

		for (int i = 0; i < facultyList.size(); i++) {

			FacultyBean bean = facultyList.get(i);

			if (email.equals(bean.getFemail()) && password.equals(bean.getFpassword())) {
//				System.out.println("Email : " + email + " = " + bean.getAemail());
				return bean;
			}
		}
		return null;
	}

	public int insertStudent(StudentBean bean) {
		return jdbcTemplate.update(
				"insert into student(sid,sfname,smname,slname,semail,spassword,sphone,sdob,sgender) values(?,?,?,?,?,?,?,?,?)",
				bean.getSid(), bean.getSfname(), bean.getSmname(), bean.getSlname(), bean.getSemail(),
				bean.getSpassword(), bean.getSphone(), bean.getSdob(), bean.getSgender());
	}

	public List<StudentBean> getAllStudents() {
		return jdbcTemplate.query("select * from Student", new BeanPropertyRowMapper<StudentBean>(StudentBean.class));
	}

	public List<FacultyBean> getAllFaculty() {
		return jdbcTemplate.query("select * from faculty", new BeanPropertyRowMapper<FacultyBean>(FacultyBean.class));
	}

	public int deleteStudent(int sid) {
		return jdbcTemplate.update("delete from Student where sid = ?", sid);
	}

	public StudentBean studentByID(int sid) {
		return (StudentBean) jdbcTemplate.queryForObject("select * from Student where sid = ?",
				new BeanPropertyRowMapper<StudentBean>(StudentBean.class), new Object[] { sid });
	}

	public int updatStudent(StudentBean bean) {
		return jdbcTemplate.update(
				"update Student set sfname = ?, slname = ?, smname = ? , semail = ?, sphone = ?, sdob = ?, sgender = ? where sid = ?",
				bean.getSfname(), bean.getSlname(), bean.getSmname(), bean.getSemail(), bean.getSphone(),
				bean.getSdob(), bean.getSgender(), bean.getSid());
	}

	public int insertFileBean(SubjectFileBean bean) {

		return jdbcTemplate.update(
				"insert into SubjectFile(file_name,file_type,file_desc,fid,sub_id) values (?,?,?,?,?)",
				bean.getFile_name(), bean.getFile_type(), bean.getFile_desc(), bean.getFid(), bean.getSub_id());
	}

	public List<SubjectFileBean> getAllSubjectFile(int sub_id) {
		return jdbcTemplate.query(
				"select file_id,file_name,file_desc,file_type,sub_name,ffname from SubjectFile file inner join faculty fac on file.fid = fac.fid inner join subject sub on sub.sub_id = fac.sub_id where file.sub_id = ?",
				new BeanPropertyRowMapper<SubjectFileBean>(SubjectFileBean.class), new Object[] { sub_id });
	}

	public int getStudentCount() {
		String sql = "select count(*) from student";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getFacultyCount() {
		String sql = "select count(*) from faculty";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getFilesCount(int sub_id) {
		String sql = "select count(*) from subjectfile where sub_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { sub_id }, Integer.class);
	}

	public int deleteFile(int fid) {
		return jdbcTemplate.update("delete from subjectfile where file_id = ?", fid);
	}

}
