/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: PayPlanInfo.java
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

public class PayPlanInfo implements Serializable {
	
	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 4521065013789058213L;
	
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
	 * 数据类型
	 */
	private String c_data_type;
	
	/**
	 * 腿号
	 */
	private String l_leg_no;
	
	/**
	 * 序号
	 */
	private String l_no;
	
	/**
	 * 币种
	 */
	private String c_curr_type;

	/**
	 * 支付方向
	 */
	private String c_pay_dir;
	
	/**
	 * 开始日期
	 */
	private String d_start_date;
	
	/**
	 * 结束日期
	 */
	private String d_end_date;
	
	/**
	 * 支付日期
	 */
	private String d_pay_date;
	
	/**
	 * 付息频率
	 */
	private String c_pay_freq;
	
	/**
	 * 计息基础
	 */
	private String c_cal_basis;
	
	/**
	 * 付息方式
	 */
	private String c_pay_type;

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

	public String getC_data_type() {
		return c_data_type;
	}

	public void setC_data_type(String c_data_type) {
		this.c_data_type = c_data_type;
	}

	public String getL_leg_no() {
		return l_leg_no;
	}

	public void setL_leg_no(String l_leg_no) {
		this.l_leg_no = l_leg_no;
	}

	public String getL_no() {
		return l_no;
	}

	public void setL_no(String l_no) {
		this.l_no = l_no;
	}

	public String getC_curr_type() {
		return c_curr_type;
	}

	public void setC_curr_type(String c_curr_type) {
		this.c_curr_type = c_curr_type;
	}

	public String getC_pay_dir() {
		return c_pay_dir;
	}

	public void setC_pay_dir(String c_pay_dir) {
		this.c_pay_dir = c_pay_dir;
	}

	public String getD_start_date() {
		return d_start_date;
	}

	public void setD_start_date(String d_start_date) {
		this.d_start_date = d_start_date;
	}

	public String getD_end_date() {
		return d_end_date;
	}

	public void setD_end_date(String d_end_date) {
		this.d_end_date = d_end_date;
	}

	public String getD_pay_date() {
		return d_pay_date;
	}

	public void setD_pay_date(String d_pay_date) {
		this.d_pay_date = d_pay_date;
	}

	public String getC_pay_freq() {
		return c_pay_freq;
	}

	public void setC_pay_freq(String c_pay_freq) {
		this.c_pay_freq = c_pay_freq;
	}

	public String getC_cal_basis() {
		return c_cal_basis;
	}

	public void setC_cal_basis(String c_cal_basis) {
		this.c_cal_basis = c_cal_basis;
	}

	public String getC_pay_type() {
		return c_pay_type;
	}

	public void setC_pay_type(String c_pay_type) {
		this.c_pay_type = c_pay_type;
	}
	
}
