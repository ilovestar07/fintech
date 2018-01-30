/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: RateInfo.java
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

public class RateInfo implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = -5690141739965718489L;

	/**
	 * 类型
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
	 * 计算方式
	 */
	private String c_cal_mode;

	/**
	 * 开始日期
	 */
	private String d_start_date;

	/**
	 * 结束日期
	 */
	private String d_end_date;

	/**
	 * 利率
	 */
	private String f_rate;

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

	public String getC_cal_mode() {
		return c_cal_mode;
	}

	public void setC_cal_mode(String c_cal_mode) {
		this.c_cal_mode = c_cal_mode;
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

	public String getF_rate() {
		return f_rate;
	}

	public void setF_rate(String f_rate) {
		this.f_rate = f_rate;
	}
}
