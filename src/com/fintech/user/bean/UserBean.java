/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 用户信息实体类
 * 类   名  称: UserBean.java
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

public class UserBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = -9127333392116496762L;

	private String user_code;

	private String user_name;

	private String sex;

	private String degree;

	private String id_type;

	private String id;

	private String tel;

	private String email;

	private String fax;

	private String qq;

	private String postcode;

	private String adress;

	private String remark;

	private String bak_field1;

	private String bak_field2;

	private String bak_field3;

	private UserStatusBean userStatusBean;

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public UserStatusBean getUserStatusBean() {
		return userStatusBean;
	}

	public void setUserStatusBean(UserStatusBean userStatusBean) {
		this.userStatusBean = userStatusBean;
	}

}
