package com.lsm.aacs.member;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
	private BigDecimal aac_no;
	private String aac_member_serial_number;
	private String aac_email;
	private String aac_password;
	private String aac_sex;
	private String aac_addr;
	private BigDecimal aac_age;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(BigDecimal aac_no, String aac_member_serial_number, String aac_email, String aac_password,
			String aac_sex, String aac_addr, BigDecimal aac_age) {
		super();
		this.aac_no = aac_no;
		this.aac_member_serial_number = aac_member_serial_number;
		this.aac_email = aac_email;
		this.aac_password = aac_password;
		this.aac_sex = aac_sex;
		this.aac_addr = aac_addr;
		this.aac_age = aac_age;
	}

	public BigDecimal getAac_no() {
		return aac_no;
	}

	public void setAac_no(BigDecimal aac_no) {
		this.aac_no = aac_no;
	}

	public String getAac_member_serial_number() {
		return aac_member_serial_number;
	}

	public void setAac_member_serial_number(String aac_member_serial_number) {
		this.aac_member_serial_number = aac_member_serial_number;
	}

	public String getAac_email() {
		return aac_email;
	}

	public void setAac_email(String aac_email) {
		this.aac_email = aac_email;
	}

	public String getAac_password() {
		return aac_password;
	}

	public void setAac_password(String aac_password) {
		this.aac_password = aac_password;
	}

	public String getAac_sex() {
		return aac_sex;
	}

	public void setAac_sex(String aac_sex) {
		this.aac_sex = aac_sex;
	}

	public String getAac_addr() {
		return aac_addr;
	}

	public void setAac_addr(String aac_addr) {
		this.aac_addr = aac_addr;
	}

	public BigDecimal getAac_age() {
		return aac_age;
	}

	public void setAac_age(BigDecimal aac_age) {
		this.aac_age = aac_age;
	}

}
