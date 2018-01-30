/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCBasisDict.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.util.constant;

public class FCBasisDict {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 计息基础:ACT/365
	 */
	public static final String BASIS_ACT_365 = "01";
	/**
	 * 计息基础:ACT/360
	 */
	public static final String BASIS_ACT_360 = "02";
	/**
	 * 计息基础:ACT/ACT ;
	 * 计算公式:ACT/ACT与ACT/ACTISMA一致
	 */
	public static final String BASIS_ACT_ACT = "03";
	/**
	 * 计息基础:ACT/ACTISMA
	 */
	public static final String BASIS_ACT_ACTISMA = "04";
	/**
	 * 计息基础:ACT/365ISDA ;
	 * 计算公式:天数计算分数=(落在闰年的计息天数/366)+（落在平年的计息天数/365);与外汇交易中心产品指引ACT/ACTISDA公式计算方法一致
	 */
	public static final String BASIS_ACT_365ISDA = "05";
	/**
	 * 计息基础:ACT/365JANPAN ;
	 * 说明:如果 计息日 为闰年，并且>=3月1号则分子需要+1天,如果 到息日 为闰年，并且到息日为2月29号之前则分子需要+1天
	 * 计算公式:(计息区间 天数-区间包含的闰年数)/365 
	 */
	public static final String BASIS_ACT_365JANPAN = "06";
	/**
	 * 计息基础:ACT/360ISDA ;
	 * 说明:如果起息日为31调正为30,到息日为31调整为30,
	 * startYear,startMonth,startDay,endYear,endMonth,endDay,分别表示 起息日年、月、日,到息日的年、月、日
	 * 计算公式:days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);calAD=(double) days / 360;
	 */
	public static final String BASIS_ACT_360ISDA = "07";
	/**
	 * 计息基础:30/360PSA ;
	 * 说明:起息日startDay为31号或者startDay为2月末 ， 则起息日startDay改为30号,到期日为31号且起息日为30日,则到期日调整为30号,
	 * startYear,startMonth,startDay,endYear,endMonth,endDay,分别表示 起息日年、月、日,到息日的年、月、日
	 * 计算公式:days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);calAD=(double) days / 360;
	 */
	public static final String BASIS_30_360PSA = "08";
	/**
	 * 计息基础:30/360SIA ;
	 * 说明:先计算 endDateTemp , 其年、月、日为endYearT, endMonthT, endDayT
	 * 如果payFreq为MT ， 则endDateTemp为到息日 ,否则endDateTemp为(起息日+payFreq)
	 * 如果 起息日为 31 ， 或者 (起 息日为月底并且endDateTemp为月底 )则 起 息日调整为 30
	 * 如果到期日的天数是月底且起息日的天数大于到期日,则让起息日=到期日
	 * 如果起息日为 月底 ，并且 到期日 所在日>起 息日所在 日 则到期日调整为 起息日
	 * 计算公式:days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);calAD=(double) days / 360;
	 */
	public static final String BASIS_30_360SIA = "09";
	/**
	 * 计息基础:30E/360 ;
	 * 说明:如果起息日为31好则直接调整为30号，如果到利日为31号则直接调整为30号
	 * 计算公式:days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);calAD= (double) days / 360;
	 */
	public static final String BASISE_30E_360 = "10";
	/**
	 * 计息基础:30/360CMO ;
	 * 说明:起息日和到息日为31或者2月末则调整为30号
	 * 计算公式:days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) + (endDay - startDay)+1;calAD = (double) days/360;
	 */
	public static final String BASIS_30_360CMO = "11";
	/**
	 * 计息基础:30/360FIX ;
	 * 说明:如果 起息日 为 所在月的最后一天， 且endDay>=startDay ,则 endDay = startDay;
	 * 如果 startDay 为 31号，则startDay变更为30
	 * 如果 endyDay 为 31号，则endDay变更为 30
	 * 计算公式:days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay)+1;calAD = (double) days/360;
	 */
	public static final String BASIS_30_360FIX = "12";
}
