/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统参数实体类
 * 类   名  称: Parameter.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.base.bean;

import java.io.Serializable;

public class Parameter implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 2754328050142077749L;

	private String Sys_code;

	private String Sys_name;

	private String Sys_version;
	
	private String User_code;
	
	private String User_name;

	private String Sys_date;
	
	private String bak_field1;

	private String bak_field2;

	private String bak_field3;

	public String getSys_code() {
		return Sys_code;
	}

	public void setSys_code(String sys_code) {
		Sys_code = sys_code;
	}

	public String getSys_name() {
		return Sys_name;
	}

	public void setSys_name(String sys_name) {
		Sys_name = sys_name;
	}

	public String getSys_version() {
		return Sys_version;
	}

	public void setSys_version(String sys_version) {
		Sys_version = sys_version;
	}

	public String getUser_code() {
		return User_code;
	}

	public void setUser_code(String user_code) {
		User_code = user_code;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getSys_date() {
		return Sys_date;
	}

	public void setSys_date(String sys_date) {
		Sys_date = sys_date;
	}

	public String getBak_field1() {
		return bak_field1;
	}

	public void setBak_field1(String bak_field1) {
		this.bak_field1 = bak_field1;
	}

	public String getBak_field2() {
		return bak_field2;
	}

	public void setBak_field2(String bak_field2) {
		this.bak_field2 = bak_field2;
	}

	public String getBak_field3() {
		return bak_field3;
	}

	public void setBak_field3(String bak_field3) {
		this.bak_field3 = bak_field3;
	}
	
}
