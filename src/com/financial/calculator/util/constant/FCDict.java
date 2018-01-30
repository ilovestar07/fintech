/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCDict.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.util.constant;

public class FCDict {

	public static final String VERSION = "@version 1.0.0.1";

	/*********************** 资产性质 ***********************/
	/**
	 * 资产性质:期间付息
	 */
	public static final String ASSET_NATURE_01 = "01";
	/**
	 * 资产性质:到期付息
	 */
	public static final String ASSET_NATURE_02 = "02";
	/**
	 * 资产性质:贴现
	 */
	public static final String ASSET_NATURE_03 = "03";

	/*********************** 数据大小 ***********************/
	/**
	 * 数据大小:大于
	 */
	public static final Integer DATA_AFTER = 1;
	/**
	 * 数据大小:等于
	 */
	public static final Integer DATA_THEN = 0;
	/**
	 * 数据大小:小于
	 */
	public static final Integer DATA_BEFORE = -1;

	/*********************** 资产性质 ***********************/
	/**
	 * 资产数据类型:利息
	 */
	public static final String DATA_COUPON = "00";
	/**
	 * 资产数据类型:费用
	 */
	public static final String DATA_FEE = "02";

	/*********************** 付息方式 ***********************/
	/**
	 * 付息方式:实际天数
	 */
	public static final String PAY_TYPE_ACT = "01";
	/**
	 * 付息方式:平均值
	 */
	public static final String PAY_TYPE_AVE = "02";

	/*********************** 付息单位 ***********************/
	/**
	 * 付息单位:天
	 */
	public static final char BASIS_UNIT_D = 'd';
	/**
	 * 付息单位:周
	 */
	public static final char BASIS_UNIT_W = 'w';
	/**
	 * 付息单位:月
	 */
	public static final char BASIS_UNIT_M = 'm';
	/**
	 * 付息单位:年
	 */
	public static final char BASIS_UNIT_Y = 'y';

	/*********************** 日期方向 ***********************/
	/**
	 * 日期方向:向后
	 */
	public static final String DATE_DIR_F = "F";
	/**
	 * 日期方向:向前
	 */
	public static final String DATE_DIR_B = "B";
}
