package com.faculty.bean;

import java.sql.Date;

public class FacultyBean {

	private int fid;
	private String ffname;
	private String flname;
	private String femail;
	private String fpassword;
	private int sub_id;
	private String sub_name;
	private long fphone;
	private Date fdob;
	private String fgender;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFfname() {
		return ffname;
	}

	public void setFfname(String ffname) {
		this.ffname = ffname;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public String getFemail() {
		return femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

	public String getFpassword() {
		return fpassword;
	}

	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public long getFphone() {
		return fphone;
	}

	public void setFphone(long fphone) {
		this.fphone = fphone;
	}

	public Date getFdob() {
		return fdob;
	}

	public void setFdob(Date fdob) {
		this.fdob = fdob;
	}

	public String getFgender() {
		return fgender;
	}

	public void setFgender(String fgender) {
		this.fgender = fgender;
	}

}
