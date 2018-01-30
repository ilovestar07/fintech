/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCConstant.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-12-31
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.util.constant;

public class FCConstant {

	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 默认腿号
	 */
	public static final Integer DEF_LEG = 1;
	
	/**
	 * 默认收益计算类型
	 */
	public static final String DEF_COUPON_DATA = FCDict.DATA_COUPON+"_"+DEF_LEG.toString();

}
