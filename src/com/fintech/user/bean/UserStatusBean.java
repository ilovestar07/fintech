/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 用户状态信息实体类
 * 类   名  称: UserStatusBean.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.user.bean;

import java.io.Serializable;

public class UserStatusBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = -658190963481245922L;

	private String user_type;

	private String user_code;

	private String password;

	private String user_status;
	
	private double logon_num;

	private String logon_status;

	private String old_password;

	private String pass_modify_date;

	private String remark;

	private String bak_field1;

	private String bak_field2;

	private String bak_field3;

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getLogon_num() {
		return logon_num;
	}

	public void setLogon_num(double logon_num) {
		this.logon_num = logon_num;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getLogon_status() {
		return logon_status;
	}

	public void setLogon_status(String logon_status) {
		this.logon_status = logon_status;
	}

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getPass_modify_date() {
		return pass_modify_date;
	}

	public void setPass_modify_date(String pass_modify_date) {
		this.pass_modify_date = pass_modify_date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
