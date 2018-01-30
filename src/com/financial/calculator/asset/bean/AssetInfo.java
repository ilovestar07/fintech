/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: AssetInfo.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.asset.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class AssetInfo implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 4207424268309964849L;

	/**
	 * 资产类型
	 */
	private String c_asset_type;

	/**
	 * 资产子类型
	 */
	private String c_asset_subtype;

	/**
	 * 资产内码
	 */
	private String c_asset_code;

	/**
	 * 资产名称
	 */
	private String c_asset_name;

	/**
	 * 起息日
	 */
	private String d_value_date;

	/**
	 * 到期日
	 */
	private String d_end_date;

	/**
	 * 币种
	 */
	private String c_curr_type;

	/**
	 * 性质
	 */
	private String c_asset_nature;

	/**
	 * 还本方式
	 */
	private String c_repay_type;

	/**
	 * 面额
	 */
	private String f_face_value;

	/**
	 * 发行价
	 */
	private String f_issue_price;

	/**
	 * 付息计划信息
	 */
	private HashMap<String, ArrayList<PayPlanInfo>> payPlanMap;

	/**
	 * 利率信息
	 */
	private HashMap<String, ArrayList<RateInfo>> rateMap;

	public String getC_asset_type() {
		return c_asset_type;
	}

	public void setC_asset_type(String c_asset_type) {
		this.c_asset_type = c_asset_type;
	}

	public String getC_asset_subtype() {
		return c_asset_subtype;
	}

	public void setC_asset_subtype(String c_asset_subtype) {
		this.c_asset_subtype = c_asset_subtype;
	}

	public String getC_asset_code() {
		return c_asset_code;
	}

	public void setC_asset_code(String c_asset_code) {
		this.c_asset_code = c_asset_code;
	}

	public String getC_asset_name() {
		return c_asset_name;
	}

	public void setC_asset_name(String c_asset_name) {
		this.c_asset_name = c_asset_name;
	}

	public String getD_value_date() {
		return d_value_date;
	}

	public void setD_value_date(String d_value_date) {
		this.d_value_date = d_value_date;
	}

	public String getD_end_date() {
		return d_end_date;
	}

	public void setD_end_date(String d_end_date) {
		this.d_end_date = d_end_date;
	}

	public String getC_curr_type() {
		return c_curr_type;
	}

	public void setC_curr_type(String c_curr_type) {
		this.c_curr_type = c_curr_type;
	}

	public String getC_asset_nature() {
		return c_asset_nature;
	}

	public void setC_asset_nature(String c_asset_nature) {
		this.c_asset_nature = c_asset_nature;
	}

	public String getC_repay_type() {
		return c_repay_type;
	}

	public void setC_repay_type(String c_repay_type) {
		this.c_repay_type = c_repay_type;
	}

	public String getF_face_value() {
		return f_face_value;
	}

	public void setF_face_value(String f_face_value) {
		this.f_face_value = f_face_value;
	}

	public String getF_issue_price() {
		return f_issue_price;
	}

	public void setF_issue_price(String f_issue_price) {
		this.f_issue_price = f_issue_price;
	}

	public HashMap<String, ArrayList<PayPlanInfo>> getPayPlanMap() {
		return payPlanMap;
	}

	public void setPayPlanMap(HashMap<String, ArrayList<PayPlanInfo>> payPlanMap) {
		this.payPlanMap = payPlanMap;
	}

	public HashMap<String, ArrayList<RateInfo>> getRateMap() {
		return rateMap;
	}

	public void setRateMap(HashMap<String, ArrayList<RateInfo>> rateMap) {
		this.rateMap = rateMap;
	}
}
