package com.student.bean;

import java.sql.Date;

public class StudentBean {

	private int sid;
	private String sfname;
	private String smname;
	private String slname;
	private String semail;
	private String spassword;
	private long sphone;
	private Date sdob;
	private String sgender;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSfname() {
		return sfname;
	}

	public void setSfname(String sfname) {
		this.sfname = sfname;
	}

	public String getSmname() {
		return smname;
	}

	public void setSmname(String smname) {
		this.smname = smname;
	}

	public String getSlname() {
		return slname;
	}

	public void setSlname(String slname) {
		this.slname = slname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public long getSphone() {
		return sphone;
	}

	public void setSphone(long sphone) {
		this.sphone = sphone;
	}

	public Date getSdob() {
		return sdob;
	}

	public void setSdob(Date sdob) {
		this.sdob = sdob;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

}
