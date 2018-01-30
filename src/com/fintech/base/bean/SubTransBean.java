/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 子交易实体类
 * 类   名  称: SubTransBean.java
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

public class SubTransBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 439980405634432607L;

	private String trans_code;

	private String subTrans_code;

	private String subTrans_name;

	private String repage;

	private String control_flag;

	private String remark;

	private String bak_field1;

	private String bak_field2;

	private String bak_field3;

	public String getTrans_code() {
		return trans_code;
	}

	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}

	public String getSubTrans_code() {
		return subTrans_code;
	}

	public void setSubTrans_code(String subTrans_code) {
		this.subTrans_code = subTrans_code;
	}

	public String getSubTrans_name() {
		return subTrans_name;
	}

	public void setSubTrans_name(String subTrans_name) {
		this.subTrans_name = subTrans_name;
	}

	public String getRepage() {
		return repage;
	}

	public void setRepage(String repage) {
		this.repage = repage;
	}

	public String getControl_flag() {
		return control_flag;
	}

	public void setControl_flag(String control_flag) {
		this.control_flag = control_flag;
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
