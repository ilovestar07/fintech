/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 主交易实体类
 * 类   名  称: TransBean.java
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
import java.util.HashMap;
import java.util.List;

public class TransBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 5035417337408303084L;

	private String trans_code;

	private String trans_name;

	private String model_code;

	private String control_class;

	private String remark;

	private String bak_field1;

	private String bak_field2;

	private String bak_field3;

	private HashMap<String, SubTransBean> subTransCode = new HashMap<String, SubTransBean>();

	public String getTrans_code() {
		return trans_code;
	}

	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}

	public String getTrans_name() {
		return trans_name;
	}

	public void setTrans_name(String trans_name) {
		this.trans_name = trans_name;
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public String getControl_class() {
		return control_class;
	}

	public void setControl_class(String control_class) {
		this.control_class = control_class;
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

	public SubTransBean getSubTransCode(String subTrans_code) {
		return this.subTransCode.get(subTrans_code);
	}

	public void setSubTransCode(List<SubTransBean> subTransCodes) {
		this.subTransCode.clear();
		if (subTransCodes != null && subTransCodes.size() > 0) {
			for (int i = 0; i < subTransCodes.size(); i++) {
				if (subTransCodes.get(i) != null) {
					this.subTransCode.put(subTransCodes.get(i).getSubTrans_code(), subTransCodes.get(i));
				}
			}
		}
	}
}
