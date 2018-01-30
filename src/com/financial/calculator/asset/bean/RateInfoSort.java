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

import java.util.Comparator;

import com.fintech.util.date.DateUtil;

public class RateInfoSort implements Comparator<RateInfo> {

	public static final String VERSION = "@version 1.0.0.1";

	@Override
	public int compare(RateInfo rateInfo1, RateInfo rateInfo2) {
		return DateUtil.isDateBefore(rateInfo1.getD_start_date(), rateInfo2.getD_start_date());
	}
}
