package com.lsm.aacs.temp;

import java.math.BigDecimal;

public class Temp {
	private BigDecimal aac_no;
	private String aac_serial_number;
	private BigDecimal aac_temp;
	private BigDecimal aac_humidity;
	private String aac_statue;

	public Temp() {
		// TODO Auto-generated constructor stub
	}

	public Temp(BigDecimal aac_no, String aac_serial_number, BigDecimal aac_temp, BigDecimal aac_humidity,
			String aac_statue) {
		super();
		this.aac_no = aac_no;
		this.aac_serial_number = aac_serial_number;
		this.aac_temp = aac_temp;
		this.aac_humidity = aac_humidity;
		this.aac_statue = aac_statue;
	}

	public BigDecimal getAac_no() {
		return aac_no;
	}

	public void setAac_no(BigDecimal aac_no) {
		this.aac_no = aac_no;
	}

	public String getAac_serial_number() {
		return aac_serial_number;
	}

	public void setAac_serial_number(String aac_serial_number) {
		this.aac_serial_number = aac_serial_number;
	}

	public BigDecimal getAac_temp() {
		return aac_temp;
	}

	public void setAac_temp(BigDecimal aac_temp) {
		this.aac_temp = aac_temp;
	}

	public BigDecimal getAac_humidity() {
		return aac_humidity;
	}

	public void setAac_humidity(BigDecimal aac_humidity) {
		this.aac_humidity = aac_humidity;
	}

	public String getAac_statue() {
		return aac_statue;
	}

	public void setAac_statue(String aac_statue) {
		this.aac_statue = aac_statue;
	}

}
