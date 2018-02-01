/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 权限实体类
 * 类   名  称: RightBean.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2015-1-22
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.right.bean;

import java.io.Serializable;

public class RightBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 2931580635404639213L;

	private String type;

	private String code;

	private String trans_code;

	private String subtrans_code;

	private String right_type;

	private String remark;

	private String bak_field1;

	private String bak_field2;

	private String bak_field3;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTrans_code() {
		return trans_code;
	}

	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}

	public String getSubtrans_code() {
		return subtrans_code;
	}

	public void setSubtrans_code(String subtrans_code) {
		this.subtrans_code = subtrans_code;
	}

	public String getRight_type() {
		return right_type;
	}

	public void setRight_type(String right_type) {
		this.right_type = right_type;
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
