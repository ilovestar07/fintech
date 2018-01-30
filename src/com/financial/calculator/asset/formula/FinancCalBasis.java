package com.financial.calculator.asset.formula;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hundsun.app.util.HsDate;
//import com.hundsun.bfm.constant.IDict;
import com.hundsun.tamcx.util.HsException;

/********************************************
 * 文件名称: FinancCalBasis.java 
 * 系统名称: 资金交易系统
 * 模块名称: 工具类
 * 软件版权: 恒生电子股份有限公司 
 * 功能说明: 
 * 系统版本: 1.0.0.1 
 * 开发人员: daijy
 * 开发时间: 
 * 审核人员: 
 * 相关文档: 
 * 修改记录: 修改日期 修改人员 修改说明
 *          20130105 daijy   调整频率为1d格式
 *          20130114 daijy   调整计算规则：如果第一个期间结束日存在，按此进行正序计算；如果仅倒数第二个期间结束日存在，按此进行倒序计算
 *          20130202 daijy   修正顺延死循环问题，逻辑上支持节假日调用（判断未取消）
 *          20131019 qianxm  增加前残段和后残段方法
 *          20140425 daijy   取下一付息/计息日方法，支持后残段，如果日期大于到期日时，取到期日
 *          20140730 daijy   支持一年以上ACT/ACT利随本清非整年计息因子计算
 *********************************************/
public class FinancCalBasis {
 
    public static final String HUNDSUN_VERSION="@system 银行资金管理系统V2.0  @version 2.0.0.2  @lastModiDate  2014-07-30  @describe 支持一年以上ACT/ACT利随本清非整年计息因子计算";
	public static final String BASIS_ACT_360 = "1"; // 计算公式 ：(计息区间天数)/360
	public static final String BASIS_ACT_365 = "2"; // 计算公式： (计息区间天数)/365	

	public static final String BASIS_ACT_ACT = "3"; // ACT/ACT与ACT/ACTISMA一致

	// 区间中含2月29号的不计
	public static final String BASIS_ACT_365JANPAN = "6";

	// 计算公式：天数计算分数=(落在闰年的计息天数/366)+（落在平年的计息天数/365)
	public static final String BASIS_ACT_365ISDA = "5";//与外汇交易中心产品指引ACT/ACTISDA公式计算方法一致

	// 如果起息日为31调正为30，到息日为31调整为30，
	// startYear,startMonth,startDay , endYear,endMonth,endDay,分别表示 起息日年、月、日，
	// 到息日的年、月、日
	// 计算公式 ： days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) +
	// (endDay - startDay);
	// calAD=(double) days / 360;
	public static final String BASIS_30_360ISDA = "4";

	// 起息日startDay为31号或者startDay为2月末 ， 则起息日startDay改为30号
	// 到期日为31号且起息日为30日,则到期日调整为30号
	// 计算公式 ： days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) +
	// (endDay - startDay);
	// calAD=(double) days / 360;
	public static final String BASIS_30_360PSA = "7";

	// 先计算 endDateTemp , 其年、月、日为endYearT, endMonthT, endDayT
	// 如果payFreq为MT ， 则endDateTemp为到息日 ,否则endDateTemp为(起息日+payFreq)
	// 如果 起息日为 31 ， 或者 (起 息日为月底并且endDateTemp为月底 )则 起 息日调整为 30
	// 如果到期日的天数是月底且起息日的天数大于到期日,则让起息日=到期日
	// 如果起息日为 月底 ，并且 到期日 所在日>起 息日所在 日 则到期日调整为 起息日
	// 计算公式 ： days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) +
	// (endDay - startDay);
	// calAD=(double) days / 360;
	public static final String BASIS_30_360SIA = "8"; //暂时没有 同ISDA

	// 如果起息日为31好则直接调整为30号，如果到利日为31号则直接调整为30号
	// 计算公式 ： days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) +
	// (endDay - startDay);
	// calAD= (double) days / 360;
	public static final String BASISE_30E_360 = "9";

	// 起息日和到息日为31或者2月末则调整为30号
	// days = 360 * (endYear - startYear) + 30* (endMonth - startMonth) +
	// (endDay - startDay)+1;
	// calAD = (double) days/360 ;
	public static final String BASIS_30_360CMO = "10"; //暂时没有 同ISDA

	// 如果 起息日 为 所在月的最后一天， 且endDay>=startDay ,则 endDay = startDay;
	// 如果 startDay 为 31号，则startDay变更为30
	// 如果 endyDay 为 31号，则endDay变更为 30
	// 计算公式：days = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) +
	// (endDay - startDay)+1;
	// calAD = (double) days/360;
	public static final String BASIS_30_360FIX = "11"; //暂时没有 同ISDA

	// 付息/计息单位
	public static final char BASIS_UNIT_D = 'd'; // 天
	public static final char BASIS_UNIT_W = 'w'; // 周
	public static final char BASIS_UNIT_M = 'm'; // 月
	public static final char BASIS_UNIT_Y = 'y'; // 年
	public static final char BASIS_UNIT_T = 't'; // 到期
	
	public static final String FREQ_1Y = "12m"; //理论年频率
	
	// 顺延方法 目前按估值的数据字典
	public static final String SCHED_RULE_0 = "0";//不调整
	public static final String SCHED_RULE_1 = "1";//下一工作日
    public static final String SCHED_RULE_2 = "2";//上一工作日
	public static final String SCHED_RULE_3 = "3";//下一工作日，跨月往前一工作日调
	public static final String SCHED_RULE_4 = "4";//上一工作日，跨月往下一工作日调
	
	//月末法则
	public static final String ENDMONTH_RULE_0 = "0";//月末不对齐
	public static final String ENDMONTH_RULE_1 = "1";//月末对齐
	
	//默认最大结束日
	public static final String END_DATE_MAX = "20991231";
	
	/**
	 * 计算息票支付次数/计息次数(不顺延)
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @return
	 * @throws ParseException 
	 */
	public static int cpncount(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate) throws ParseException {
		if(DateUtil.afterDate(settle+" 000000", maturity+" 000000")){
			return 0;
		}
		Object[] f = parseFreq(freq);
		byte period = (Byte)f[0];
		char basis_unit = ((String)f[1]).charAt(0);
		if (0 == period)
			return 1;
		boolean isEndMonthDeal = isEndMonthDeal(maturity, valueDate, endMonthRule, basis_unit);
		int flag = -1;//默认从后往前算
		Calendar ref = DateUtil.parseCalendar(maturity);//默认从到期日开始计算
		Calendar refSettle = DateUtil.parseCalendar(settle);
		if(!DataUtil.isNullStr(firstCouponDate)){
			flag = 1;//当第一个期间结束日存在时，从前往后算
			ref = DateUtil.parseCalendar(firstCouponDate);
			if(DateUtil.beforeDate(settle+" 000000", firstCouponDate+" 000000")){
				//在第一期间结束日之前，多加一次，与第一期间结束日比较
				refSettle = DateUtil.parseCalendar(firstCouponDate);
			}
		}
		if(flag==-1&&!DataUtil.isNullStr(lastCouponDate)){
			//如果第一个期间结束日不存在，倒数第二个期间结束日存在，从此日期开始计算
			ref = DateUtil.parseCalendar(lastCouponDate);
			if(!DateUtil.beforeDate(settle+" 000000", lastCouponDate+" 000000")){
				return 1;//如果计算日不在倒数第二个期间之前
			}
		}		
		Calendar newRefEnd = null;
		//从后往前算，计算日>=结束日跳出，上一计息日=结束日；从前往后算，计算日<结束日跳出，上一计息日=开始日
		int i = -1;
		do {
			i++;
			newRefEnd = (Calendar) ref.clone();
			add(newRefEnd, period, basis_unit, i, flag);//20130202 daijy 调用公共日历运算
			if(isEndMonthDeal){
				newRefEnd = endMonthDeal(newRefEnd);
			}
		} while ((flag==-1&&newRefEnd.after(refSettle))||(flag==1&&!newRefEnd.after(refSettle)));
		if(flag==-1){//倒序位置直接是次数
			if(!DataUtil.isNullStr(lastCouponDate)){
				i++;
			}
			return i;
		}else{//正序在上一付息日位置之后，一直推到到期日
			i--;
			int count = 0;
			do {
				i++;
				count++;
				newRefEnd = (Calendar) ref.clone();
				add(newRefEnd, period, basis_unit, i, flag);//20130202 daijy 调用公共日历运算
				if(isEndMonthDeal){
					newRefEnd = endMonthDeal(newRefEnd);
				}
			} while (newRefEnd.before(DateUtil.parseCalendar(maturity)));
			//正序从上一付息日位置后开始处理
			if(!DataUtil.isNullStr(firstCouponDate)&&DateUtil.beforeDate(settle+" 000000", firstCouponDate+" 000000")){
				count++;//当第一个期间结束日存在，并且计算日在第一个期间结束日之前
			}
			return count;
		}
	}
	
	/**
	 * 计算息票支付次数/计息次数(顺延)
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 */
	public static int cpncount(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		List list = FinancCalBasis.cfdates(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate, sched_rule, dateTypes, allHolidays);
		return list.size();
	}
	
	/**
	 * 计算前一个计息/付息日/起息日（不顺延）
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @return
	 * @throws ParseException 
	 */
	public static String cpndatep(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate) throws ParseException {
		if(DateUtil.afterDate(settle+" 000000", maturity+" 000000")){
			throw new java.lang.RuntimeException("计算日大于到期日！");
		}
		if(!DataUtil.isNullStr(valueDate)&&DateUtil.beforeDate(settle+" 000000", valueDate+" 000000")){
			throw new java.lang.RuntimeException("计算日小于起息日！");
		}
		Object[] f = parseFreq(freq);
		byte period = (Byte)f[0];
		char basis_unit = ((String)f[1]).charAt(0);
		String ret = null;
		if (0 == period)
			return valueDate;
		boolean isEndMonthDeal = isEndMonthDeal(maturity, valueDate, endMonthRule, basis_unit);
		int flag = -1;//默认从后往前算
		Calendar ref = DateUtil.parseCalendar(maturity);//默认从到期日开始计算
		if(!DataUtil.isNullStr(firstCouponDate)){
			flag = 1;//当第一个期间结束日存在时，从前往后算
			ref = DateUtil.parseCalendar(firstCouponDate);
			if(DateUtil.beforeDate(settle+" 000000", firstCouponDate+" 000000")){
				return valueDate;
			}
		}
		if(flag==-1&&!DataUtil.isNullStr(lastCouponDate)){
			//如果第一个期间结束日不存在，倒数第二个期间结束日存在，从此日期开始计算
			ref = DateUtil.parseCalendar(lastCouponDate);
			if(!DateUtil.beforeDate(settle+" 000000", lastCouponDate+" 000000")){
				return lastCouponDate;
			}
		}
		Calendar refSettle = DateUtil.parseCalendar(settle);
		Calendar newRefEnd = null;
		Calendar newRefStart = null;
		//从后往前算，计算日>=结束日跳出，上一计息日=结束日；从前往后算，计算日<结束日跳出，上一计息日=开始日
		int i = -1;
		do {
			i++;
			if(newRefEnd!=null){
				newRefStart = (Calendar) newRefEnd.clone();//上一结束日，即当期开始日
			}
			newRefEnd = (Calendar) ref.clone();
			add(newRefEnd, period, basis_unit, i, flag);//20130202 daijy 调用公共日历运算
			if(isEndMonthDeal){
				newRefEnd = endMonthDeal(newRefEnd);
			}
		} while ((flag==-1&&newRefEnd.after(refSettle))||(flag==1&&!newRefEnd.after(refSettle)));
		if(flag==-1){
			ret = DateUtil.getNumDateStr(newRefEnd);
		}else{
			ret = DateUtil.getNumDateStr(newRefStart);
		}
		return ret;
	}
	
	/**
	 * 计算前一个计息/付息日（顺延）
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 * @throws HsException 
	 */
	public static String cpndatep(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		checkDate(settle,sched_rule,dateTypes,allHolidays);
		String date = cpndatep(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate);
		String dateAdj = cpndatepCell(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
		//按理论值取下一个计息/付息日
		String datenAdj = cpndatenCell(date, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
		if(datenAdj!=null){
			if(!DateUtil.afterDate(datenAdj+" 000000", settle+" 000000")){
				dateAdj = datenAdj;
			}
		}
		return dateAdj;
	}
	
	/**
	 * 计算前一个计息/付息日（理论顺延，一直到无逻辑错误）
	 */
	public static String cpndatepCell(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		String date = cpndatep(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate);
		String dateAdj = getChangedDate(date,sched_rule,dateTypes,allHolidays);
		if(DateUtil.beforeDate(settle+" 000000", dateAdj+" 000000")){
			if(settle.equals(date)){//如果与计算日同一天，取前一天
				date = DateUtil.addDate(date, -1);
			}
			dateAdj = cpndatepCell(date, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
		}
		return dateAdj;
	}

	/**
	 * 计算下一个计息/付息日（不顺延）
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @return
	 * @throws ParseException 
	 */
	public static String cpndaten(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate) throws ParseException {
		if(DateUtil.afterDate(settle+" 000000", maturity+" 000000")){
			throw new java.lang.RuntimeException("计算日大于到期日！");
		}
		if(settle.equals(maturity)){
			return null;
		}
		String ret = null;
		Object[] f = parseFreq(freq);
		byte period = (Byte)f[0];
		char basis_unit = ((String)f[1]).charAt(0);
		if (0 == period)
			return maturity;
		boolean isEndMonthDeal = isEndMonthDeal(maturity, valueDate, endMonthRule, basis_unit);
		//20130110 daijy 下一计息/付息日重新开始计算
		int flag = -1;//默认从后往前算
		Calendar ref = DateUtil.parseCalendar(maturity);//默认从到期日开始计算
		if(!DataUtil.isNullStr(firstCouponDate)){
			flag = 1;//当第一个期间结束日存在时，从前往后算
			ref = DateUtil.parseCalendar(firstCouponDate);
			if(DateUtil.beforeDate(settle+" 000000", firstCouponDate+" 000000")){
				return firstCouponDate;
			}
		}
		if(flag==-1&&!DataUtil.isNullStr(lastCouponDate)){
			//如果第一个期间结束日不存在，倒数第二个期间结束日存在，从此日期开始计算
			ref = DateUtil.parseCalendar(lastCouponDate);
			if(!DateUtil.beforeDate(settle+" 000000", lastCouponDate+" 000000")){
				return maturity;
			}
		}
		Calendar refSettle = DateUtil.parseCalendar(settle);
		Calendar newRefEnd = null;
		Calendar newRefStart = null;
		//从后往前算，计算日>=结束日跳出，上一计息日=结束日；从前往后算，计算日<结束日跳出，上一计息日=开始日
		int i = -1;//期间个数
		do {
			i++;
			if(newRefEnd!=null){
				newRefStart = (Calendar) newRefEnd.clone();//上一结束日，即当期开始日
			}
			newRefEnd = (Calendar) ref.clone();
			add(newRefEnd, period, basis_unit, i, flag);//20130202 daijy 调用公共日历运算
			if(isEndMonthDeal){
				newRefEnd = endMonthDeal(newRefEnd);
			}
		} while ((flag==-1&&newRefEnd.after(refSettle))||(flag==1&&!newRefEnd.after(refSettle)));
		if(flag==-1){
			ret = DateUtil.getNumDateStr(newRefStart);
		}else{			
			ret = DateUtil.getNumDateStr(newRefEnd);
		}
		//20140425 daijy 如果日期大于到期日，取到期日
		if(DateUtil.afterDate(ret+" 000000", maturity+" 000000")){
			ret = maturity;
		}
		return ret;
	}
	/**
	 * 获取前残段
	 * @param adjust		     是否顺延 1-顺延 0-不顺延
	 * @param settle          计算开始日（必填）  等于起息日
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @throws ParseException
	 * @author qianxm  20131019
	 * 
	 * 如：起息日0101-0405 feq=1m
	 * 	   从前往后推：0201
	 *   从后往前推：0405-0305,0305-0205,0205-0105，所以前残段是0101-0105
	 */
	public static int aheadStub(String adjust, int settle, int maturity, String freq, String basis, String endMonthRule, int valueDate, 
			String schedRule, String[] dateTypes, Map<String,LinkedHashMap<String,String>> allHolidays) throws ParseException{
		String maturityStr = maturity==0?null:String.valueOf(maturity);
		String valueDateStr = valueDate==0?null:String.valueOf(valueDate);
		String date = null;

//		if(IDict.K_YORN.YORN_YES.equals(adjust)){
//			date = FinancCalBasis.cpndaten(valueDateStr, maturityStr, freq, basis, endMonthRule, valueDateStr, valueDateStr, null, schedRule, dateTypes, allHolidays);
//		}else{
//			date = FinancCalBasis.cpndaten(valueDateStr, maturityStr, freq, basis, endMonthRule, valueDateStr, valueDateStr, null);
//		}
//		if(IDict.K_YORN.YORN_YES.equals(adjust)){
//			date = FinancCalBasis.cpndatep(date, maturityStr, freq, basis, endMonthRule, valueDateStr, null, maturityStr, schedRule, dateTypes, allHolidays);
//		}else{
//			date = FinancCalBasis.cpndatep(date, maturityStr, freq, basis, endMonthRule, valueDateStr, null, maturityStr);
//		}
		if(DataUtil.isNullStr(date)){
			return 0;
		}else{
			return Integer.parseInt(date);
		}
	}
	/**
	 * 获取后残段
	 * @param adjust		     是否顺延 1-顺延 0-不顺延
	 * @param settle          计算开始日（必填），计算后残段必须有，并且是到期日-1
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @throws ParseException
	 * @author qianxm 20131019
	 * 如：起息日0101-0405 feq=1m
	 * 	   从后往前推：0304
	 * 	  从前往后推：0101-0201,0201-0301,0301-0401，所以后残段是0401-0405
	 */
	public static int afterStub(String adjust, int settle, int maturity, String freq, String basis, String endMonthRule, int valueDate, 
			String schedRule, String[] dateTypes, Map<String,LinkedHashMap<String,String>> allHolidays) throws ParseException{
//		String date = cpndatep("20130404", "20130405", "1m", "", "0", "20130101", null,null);
//		System.out.println("after date="+date);
//		String date2 = cpndaten(date, "20130405", "1m", "", "0", "20130101", "20130101", null);
		String settleStr = settle==0?null:String.valueOf(settle);
		String maturityStr = maturity==0?null:String.valueOf(maturity);
		String valueDateStr = valueDate==0?null:String.valueOf(valueDate);
		String date = null;
//		if(IDict.K_YORN.YORN_YES.equals(adjust)){
//			date = FinancCalBasis.cpndatep(settleStr, maturityStr, freq, basis, endMonthRule, valueDateStr, null, null, schedRule, dateTypes, allHolidays);
//		}else{
//			date = FinancCalBasis.cpndatep(settleStr, maturityStr, freq, basis, endMonthRule, valueDateStr, null, null);
//		}
//		if(IDict.K_YORN.YORN_YES.equals(adjust)){
//			date = FinancCalBasis.cpndaten(date, maturityStr, freq, basis, endMonthRule, valueDateStr, valueDateStr, null, schedRule, dateTypes, allHolidays);
//		}else{
//			date = FinancCalBasis.cpndaten(date, maturityStr, freq, basis, endMonthRule, valueDateStr, valueDateStr, null);
//		}
		if(DataUtil.isNullStr(date)){
			return 0;
		}else{
			return Integer.parseInt(date);
		}
	}
	
	/**
	 * 计算下一个计息/付息日（顺延）
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 * @throws HsException 
	 */
	public static String cpndaten(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		checkDate(settle,sched_rule,dateTypes,allHolidays);
		String date = cpndaten(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate);
		if(date==null){
			return null;
		}
		String dateAdj = cpndatenCell(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
		//按理论值取上一个计息/付息日
		date = DateUtil.addDate(date, -1);//由于计息日当日返回自己，往前一天
		String datepAdj = cpndatepCell(date, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
		if(DateUtil.afterDate(datepAdj+" 000000", settle+" 000000")){
			dateAdj = datepAdj;
		}
		return dateAdj;
	}
	
	/**
	 * 计算下一个计息/付息日（理论顺延，一直到无逻辑错误）
	 */
	private static String cpndatenCell(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		String date = cpndaten(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate);
		if(date==null){
			return null;
		}
		String dateAdj = getChangedDate(date,sched_rule,dateTypes,allHolidays);
		if(!DateUtil.afterDate(dateAdj+" 000000", settle+" 000000")){
			dateAdj = cpndatenCell(date, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
		}
		return dateAdj;
	}
	
	/**
	 * 计算重置/息票日期（不顺延）
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @return
	 * @throws ParseException 
	 */
	public static List<String> cfdates(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate) throws ParseException {
		if(DateUtil.afterDate(settle+" 000000", maturity+" 000000")){
			throw new java.lang.RuntimeException("计算日大于到期日！");
		}
		List<String> ret = new ArrayList<String>();
		Object[] f = parseFreq(freq);
		byte period = (Byte)f[0];
		char basis_unit = ((String)f[1]).charAt(0);
		if (0 == period){//利随本清
			ret.add(maturity);
		}else{
			boolean isEndMonthDeal = isEndMonthDeal(maturity, valueDate, endMonthRule, basis_unit);
			int flag = -1;//默认从后往前算
			Calendar ref = DateUtil.parseCalendar(maturity);//默认从到期日开始计算
			Calendar refSettle = DateUtil.parseCalendar(settle);
			if(!DataUtil.isNullStr(firstCouponDate)){
				flag = 1;//当第一个期间结束日存在时，从前往后算
				ref = DateUtil.parseCalendar(firstCouponDate);
				if(DateUtil.beforeDate(settle+" 000000", firstCouponDate+" 000000")){
					//在第一期间结束日之前，多加一次，与第一期间结束日比较
					ret.add(firstCouponDate);
					refSettle = DateUtil.parseCalendar(firstCouponDate);
				}
			}
			if(flag==-1&&!DataUtil.isNullStr(lastCouponDate)){
				//如果第一个期间结束日不存在，倒数第二个期间结束日存在，从此日期开始计算
				ref = DateUtil.parseCalendar(lastCouponDate);
				ret.add(maturity);
				if(!DateUtil.beforeDate(settle+" 000000", lastCouponDate+" 000000")){					
					return ret;
				}
			}
			Calendar newRefEnd = (Calendar) ref.clone();			
			int i = -1;
			do {
				i++;
				newRefEnd = (Calendar) ref.clone();
				add(newRefEnd, period, basis_unit, i, flag);//20130202 daijy 调用公共日历运算
				if(isEndMonthDeal){
					newRefEnd = endMonthDeal(newRefEnd);
				}
				if(flag==-1){
					//倒序从到期日开始取息票日期，取到上一付息日退出
					if(!newRefEnd.after(refSettle)){
						break;
					}
					ret.add(DateUtil.getNumDateStr(newRefEnd));
				}else{
					//正序从第一期间开始日开始计算上一付息日，到到期日跳出
					if(newRefEnd.after(DateUtil.parseCalendar(maturity))){
						if(!ret.contains(maturity)){
							ret.add(maturity);
						}
						break;
					}
					if(newRefEnd.after(refSettle)){
						ret.add(DateUtil.getNumDateStr(newRefEnd));
					}
				}
			}while(true);
			if(flag==-1){//倒序反转列表
				Collections.reverse(ret);
			}
		}
		return ret;
	}

	/**
	 * 计算重置/息票日期（顺延）
	 * 
	 * @param settle          计算开始日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础（暂时无用）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 * @throws HsException 
	 */
	public static List<String> cfdates(String settle, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		checkDate(settle,sched_rule,dateTypes,allHolidays);
		List<String> list = cfdates(settle, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate);
		List<String> ret = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			String date = getChangedDate(list.get(i),sched_rule,dateTypes,allHolidays);
			if(i==0){//判断第一日期前是否还有大于计算开始日的数据
				String datep = DateUtil.addDate(list.get(i), -1);
				String datepAdj = cpndatepCell(datep, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate,sched_rule,dateTypes,allHolidays);
				if(DateUtil.afterDate(datepAdj+" 000000", settle+" 000000")){
					ret.add(datepAdj);
				}
			}
			if(!ret.contains(date)){
				//判断日期是否大于计算开始日
				if(DateUtil.afterDate(date+" 000000", settle+" 000000")){
					ret.add(date);
				}
			}
		}
		return ret;
	}
	
	/**
	 * 应计息天数
	 * 
	 * @param startDate
	 *            开始日（必填）
	 * @param Endate
	 *            结束日（必填）
	 * @param basis
	 *            计息基础（必填）
	 * @return
	 */
	public static int daysdif(String startDate, String Enddate, String basis) throws ParseException {
		int ret = 0;
		if (BASIS_30_360ISDA.equals(basis)) {
			ret = days360isda(startDate, Enddate);
		} else if (BASIS_30_360PSA.equals(basis)) {
			ret = days360psa(startDate, Enddate);
		} else if (BASISE_30E_360.equals(basis)) {
			ret = days360e(startDate, Enddate);
		} else if (BASIS_30_360SIA.equals(basis)) {
			ret = days360isda(startDate, Enddate); //TODO
		} else if (BASIS_30_360CMO.equals(basis)) {
			ret = days360isda(startDate, Enddate); //TODO
		} else if (BASIS_30_360FIX.equals(basis)) {
			ret = days360isda(startDate, Enddate); //TODO
		} else if (BASIS_ACT_360.equals(basis) || BASIS_ACT_365.equals(basis) || BASIS_ACT_ACT.equals(basis)
				     || BASIS_ACT_365ISDA.equals(basis)) {
			ret = daysact(startDate, Enddate);
		} else if (BASIS_ACT_365JANPAN.equals(basis) ) {
			ret = days365jap(startDate, Enddate);
		}
		return ret;
	}

	/**
	 * 计算应计息天数因子
	 * 计算开始日至计算截止日不支持大于一整年的情况
	 * 
	 * @param startDate       计算开始日（必填）
	 * @param enddate         计算截止日（必填）
	 * @param maturity        资产到期日（必填）
	 * @param freq            频率               （必填）
	 * @param basis           计息基础     （必填）
	 * @param endMonthRule    月末法则
	 * @param valueDate       资产起息日
	 * @param firstCouponDate 第一个期间结束日
	 * @param lastCouponDate  倒数第二个期间结束日
	 * @param type            付息/计息方式：默认实际天数  2-平均值
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 * @throws HsException 
	 */
	public static double accrfrac(String startDate, String enddate, String maturity, String freq, String basis, String endMonthRule, String valueDate, String firstCouponDate,
			String lastCouponDate, String type, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException {
		double ret = 1d;
		if (BASIS_ACT_360.equals(basis) || BASIS_30_360ISDA.equals(basis) || BASIS_30_360SIA.equals(basis) || BASISE_30E_360.endsWith(basis)
				|| BASIS_30_360CMO.equals(basis) || BASIS_30_360PSA.equals(basis) || BASIS_30_360FIX.equals(basis)) {
			ret = 360;
		} else if (BASIS_ACT_365JANPAN.equals(basis) || BASIS_ACT_365.equals(basis)) {
			ret = 365;
		} else if (BASIS_ACT_365ISDA.equals(basis)){
			//天数计算分数=(落在闰年的计息天数/366)+（落在平年的计息天数/365)
			int startYear = DateUtil.getYear(startDate);//开始日年份
			int endYear = DateUtil.getYear(enddate);
			if(startYear==endYear){//同年，直接两个日期之间的天数/当年实际天数
				ret = getYearDays(startYear);
			}else{
				String middleDate = (startYear+1)+"0101";
				double startFrac = (double)daysdif(startDate, middleDate, basis)/getYearDays(startYear);
				double endFrac = (double)daysdif(middleDate, enddate, basis)/getYearDays(endYear);
				return startFrac + endFrac;
			}
		} else if (BASIS_ACT_ACT.equals(basis)) {//债券的act算法
			Object[] f = parseFreq(freq);
			byte period = (Byte)f[0];
			char basis_unit = ((String)f[1]).charAt(0); 
			//20140730 daijy 支持一年以上ACT/ACT，一年以上只可能是利随本清
			if(BASIS_UNIT_T==basis_unit){
				type = "1";//利随本清无平均值说法
				//取开始日期上一理论年计息日
				String thisStart  = cpndatep(startDate, maturity, FREQ_1Y, basis, endMonthRule, valueDate, valueDate, null);
				String thisEnd = cpndaten(thisStart, END_DATE_MAX, FREQ_1Y, basis, endMonthRule, valueDate, valueDate, null);
				double thisdays = DateUtil.diffDate(thisStart, thisEnd);
				//判断下一理论年计息日是否大于等于截止日期
				if(HsDate.afterDate(enddate+" 000000", thisEnd+" 000000")){
					double thisAccrfrac = daysdif(startDate, thisEnd, basis)/thisdays;
					String lastStart  = cpndatep(enddate, maturity, FREQ_1Y, basis, endMonthRule, valueDate, valueDate, null);
					String lastEnd = cpndaten(lastStart, END_DATE_MAX, FREQ_1Y, basis, endMonthRule, valueDate, valueDate, null);
					double lastdays = DateUtil.diffDate(lastStart, lastEnd);
					int year = HsDate.getYear(lastStart)-HsDate.getYear(thisEnd);
					double lastAccrfrac = year + daysdif(lastStart, enddate, basis)/lastdays;
					return thisAcc rfrac + lastAccrfrac;
				}else{
					double thisAccrfrac = daysdif(startDate, enddate, basis)/thisdays;
					return thisAccrfrac;
				}
			}else if ("2".equals(type)) {//平均值付息/计息
				String start = cpndatep(startDate, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate, sched_rule, dateTypes, allHolidays);
				String end = cpndaten(startDate, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate, sched_rule, dateTypes, allHolidays);
				//20141218 daijy 平均值支持残段
				String startNext = cpndaten(start, END_DATE_MAX, freq, basis, endMonthRule, valueDate, start, null, sched_rule, dateTypes, allHolidays);
				if(!end.equals(startNext)){
					if(start.equals(valueDate)){
						//前残段，开始日期为前残段结束日往前再推一个期间
						start = cpndatep(HsDate.addDate(end, -1), end, freq, basis, endMonthRule, valueDate, null, null, sched_rule, dateTypes, allHolidays);
					}else if(end.equals(maturity)){
						//后残段，结束日期为后残段开始日往后再推一个期间
						end = startNext;
					}
				}
				int days = DateUtil.diffDate(start, end);
				if(period==0){
					ret = days;
				}else{
					if(basis_unit==BASIS_UNIT_M){
						ret = days * 12 / period;
					}else{
						throw new java.lang.RuntimeException("平均值法只能对应频率到月！");
					}
				}
			} else {//理论计息年，不考虑残段
				String start = cpndatep(startDate, maturity, FREQ_1Y, basis, endMonthRule, valueDate, null, null);
				String end = cpndaten(startDate, maturity, FREQ_1Y, basis, endMonthRule, valueDate, null, null);
				int days = DateUtil.diffDate(start, end);
				ret = days;
			}
		}
		int days = daysdif(startDate, enddate, basis);
		ret = days / ret;
		return ret;
	}
	
	/**
	 * 取得该年天数
	 * @param year
	 * @return
	 */
	private static int getYearDays(int year){
		int ret = 0;
		if(DateUtil.isLeapYear(year)){
			ret = 366;
		}else{
			ret = 365;
		}
		return ret;
	}

	/**
	 * 计算应计息
	 * @param Face 面值（份额）
	 * @param CouponRate 票面利率
	 * @param accrfrac 应计息因子
	 * @return
	 */
	public static double accrubond(double face, double couponRate,double accrfrac) {
		double ret = face*couponRate*accrfrac;
		return ret;
	}

	/**
	 * ACT 应计息天数
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws ParseException
	 */
	public static int daysact(String startdate, String enddate) throws ParseException {
		int ret = 1;
		ret = DateUtil.diffDate(startdate, enddate);
		return ret;
	}

	/**
	 * 360E 应计息天数
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws ParseException
	 */
	public static int days360e(String startdate, String enddate) throws ParseException {
		int ret = 1;
		int startYear = 0; // 起息日的年份
		int startMonth = 0; // 起息日的月份
		int startDay = 0; // 起息日的日子
		int endYear = 0; // 计息日的年份
		int endMonth = 0; // 计息日的月份
		int endDay = 0; // 计息日的日子

		startYear = DateUtil.getYear(startdate);
		endYear = DateUtil.getYear(enddate);
		startMonth = DateUtil.getMonth(startdate) + 1;
		endMonth = DateUtil.getMonth(enddate) + 1;
		startDay = DateUtil.getDay(startdate);
		endDay = DateUtil.getDay(enddate);
		if (startDay == 31)
			startDay = 30;

		if (endDay == 31) // 起息日所在日为31直接调整为30
			endDay = 30;

		ret = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);
		return ret;
	}

	/**
	 * 360ISDA 应计息天数
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws ParseException
	 */
	public static int days360isda(String startdate, String enddate) throws ParseException {
		int ret = 1;
		int startYear = 0; // 起息日的年份
		int startMonth = 0; // 起息日的月份
		int startDay = 0; // 起息日的日子
		int endYear = 0; // 计息日的年份
		int endMonth = 0; // 计息日的月份
		int endDay = 0; // 计息日的日子

		startYear = DateUtil.getYear(startdate);
		endYear = DateUtil.getYear(enddate);
		startMonth = DateUtil.getMonth(startdate) + 1;
		endMonth = DateUtil.getMonth(enddate) + 1;
		startDay = DateUtil.getDay(startdate);
		endDay = DateUtil.getDay(enddate);
		if (startDay == 31)
			startDay = 30;
		if (endDay == 31 && startDay == 30)
			endDay = 30;

		ret = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);
		return ret;
	}

	/**
	 * 360PSA 应计息天数
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws ParseException
	 */
	public static int days360psa(String startdate, String enddate) throws ParseException {
		int ret = 1;
		int startYear = 0; // 起息日的年份
		int startMonth = 0; // 起息日的月份
		int startDay = 0; // 起息日的日子
		int endYear = 0; // 计息日的年份
		int endMonth = 0; // 计息日的月份
		int endDay = 0; // 计息日的日子
		byte leap = 0;

		startYear = DateUtil.getYear(startdate);
		endYear = DateUtil.getYear(enddate);
		startMonth = DateUtil.getMonth(startdate) + 1;
		endMonth = DateUtil.getMonth(enddate) + 1;
		startDay = DateUtil.getDay(startdate);
		endDay = DateUtil.getDay(enddate);

		if (startDay == 31)
			startDay = 30;
		if (endDay == 31 && startDay == 30)
			endDay = 30;
		

		// 对于 30_360PSA ,如果起息日所在日为31， 或者 为2月末，则调整到30
		if (0 == leap && 2 == startMonth && 28 == startDay && 2 == endMonth && 28 == endDay) {
			startDay = 30;
			endDay = 30;
		} else if ((1 == leap && 2 == startMonth && 29 == startDay && 2 == endMonth && 29 == endDay)) {
			startDay = 30;
			endDay = 30;
		}

		ret = 360 * (endYear - startYear) + 30 * (endMonth - startMonth) + (endDay - startDay);
		return ret;
	}
	
	/**
	 * 365JAP 应计息天数
	 * 闰年不计2月29日
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws ParseException
	 */
	public static int days365jap(String startdate, String enddate) throws ParseException {
		int ret = daysact(startdate, enddate);
		int startYear = 0; // 起息日的年份
		int startMonth = 0; // 起息日的月份
		int endYear = 0; // 计息日的年份
		int endMonth = 0; // 计息日的月份
		int endDay = 0; // 计息日的日子

		startYear = DateUtil.getYear(startdate);
		endYear = DateUtil.getYear(enddate);
		startMonth = DateUtil.getMonth(startdate) + 1;
		endMonth = DateUtil.getMonth(enddate) + 1;
		endDay = DateUtil.getDay(enddate);
		// 对与开始日期、结束日期 只要是闰年，则总天数减一
		if (DateUtil.isLeapYear(startYear)) {
			ret = ret - 1;
		}
		if (startYear!=endYear && DateUtil.isLeapYear(endYear)) {
			ret = ret - 1;
		}
		// 如果起息日期为闰年且日期大于等于3月1日，则天数补回一天
		if (DateUtil.isLeapYear(startYear) && startMonth >= 3){
			ret += 1;
		}
		// 如果计息日期为闰年且日期为2月底之前，则天数补回一天
		if (DateUtil.isLeapYear(endYear)) {
			if (endMonth == 1 || (endMonth == 2 && endDay < 29))
				ret += 1;
		}
		return ret;
	}
	
	/**
	 * 根据顺延天数进行顺延
	 * @param cal             原始日历日期（必填）
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 */
	public static Calendar getChangedCalendar(Calendar cal, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException{
		String date = DateUtil.getNumDateStr(cal);
		String workDay = getChangedDate(date,sched_rule,dateTypes,allHolidays);
		cal = DateUtil.parseCalendar(workDay);
		return cal;
	}
	
	/**
	 * 根据顺延天数进行顺延
	 * @param date            原始日期（必填）
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 * @return
	 * @throws ParseException 
	 */
	public static String getChangedDate(String date, String sched_rule, String[] dateTypes, Map allHolidays) throws ParseException{
		String workDay = date;
		if(SCHED_RULE_1.equals(sched_rule)){//下个工作日	
			workDay = getWorkDay(date,true,dateTypes,allHolidays);
		}else if(SCHED_RULE_2.equals(sched_rule)){//上个工作日	
			workDay = getWorkDay(date,false,dateTypes,allHolidays);
		}else if(SCHED_RULE_3.equals(sched_rule)){//下一工作日，跨月往前一工作日调	
			workDay = getWorkDay(date,true,dateTypes,allHolidays);
			if(DateUtil.getMonth(date)!=DateUtil.getMonth(workDay)){
				workDay = getWorkDay(date,false,dateTypes,allHolidays);
			}
		}else if(SCHED_RULE_4.equals(sched_rule)){//上个工作日，跨月往下一工作日调	
			workDay = getWorkDay(date,false,dateTypes,allHolidays);
			if(DateUtil.getMonth(date)!=DateUtil.getMonth(workDay)){
				workDay = getWorkDay(date,true,dateTypes,allHolidays);
			}
		}
		return workDay;
	}
	
	/**
	 * 是否节假日
	 * @param date            原始日期
	 * @param holidays        节假日参数
	 * @return
	 */
	public static boolean isHoliday(String date, Map holidays){
		if(holidays == null){
			return false;
		}
		if(holidays.containsKey(date)){//是节假日
			return true;
		}
		return false;
	}
	/**
	 * 是否节假日
	 * @param date            原始日期
	 * @param holidays        节假日参数
	 * @return
	 */
	public static boolean isHoliday(int date, Map holidays){
		return isHoliday(String.valueOf(date), holidays);
	}
	

	/**
	 * 根据当前传入的时间判定是否是工作日  
	 * 根据offset(T+0或T+1)来取下个日期  如果不是工作日  日期不变,区别于getNNextWorkDate,偏移量为0时非工作日也取下一工作日，如为工作日则为指定日期
	 * @param date 指定日期
	 * @param offset 支持正负
	 * @param holidays 指定单一假日类型
	 * @return
	 */
	public static int getNNextWorkDateInvolveZero(int date, int offset,Map holidays) {
		if(offset == 0){
			//偏移量为0时，如果c指定日期为工作日，则返回当前日期；否则为非工作日，则取下一工作日
			if(isHoliday(date,holidays)){
				return getNNextWorkDateInvolveZero(date, 1,holidays);
			}else{
				return date;
			}
		}else if (offset > 0) {
			int tmpTransDay = date;
			for (int i = 0; i < offset;i++) {
				tmpTransDay = DateUtil.addDate(tmpTransDay, 1);
				while(isHoliday(tmpTransDay,holidays)){
					tmpTransDay = DateUtil.addDate(tmpTransDay, 1);
				}
			}
			return tmpTransDay;
		}else{
			int tmpTransDay = date;
			for (int i = 0; i < -offset;i++) {
				tmpTransDay = DateUtil.addDate(tmpTransDay, -1);
				while(isHoliday(tmpTransDay,holidays)){
					tmpTransDay = DateUtil.addDate(tmpTransDay, -1);
				}
			}
			return tmpTransDay;
		}
		
	}
	/**
	 * 同上，仅参数类型和返回值不同
	 * @param date 指定日期
	 * @param offset 支持正负
	 * @param holidays 指定单一假日类型
	 * @return
	 */
	public static String getNNextWorkDateInvolveZero(String date, int offset,Map holidays) {
		return String.valueOf(getNNextWorkDateInvolveZero(Integer.parseInt(date), offset,holidays));
	}
	
	/**
	 * 同上，一般供外部调用，参数为全量节假日
	 * @param dateType
	 * @param date 指定日期
	 * @param offset 支持正负
	 * @param allHolidays 全量节假日
	 * @return
	 */
	public static int getNNextWorkDateInvolveZero(String dateType, int date, int offset,Map allHolidays){
		return getNNextWorkDateInvolveZero(date, offset,(Map)allHolidays.get(dateType));
	}

	/**
	 * 获取offset个工作日后的日期,不包括当天（适用于提前N个工作日算正常到期）
	 * 
	 * @param dateType
	 *            日期类型
	 * @param date
	 *            原日期
	 * @param offset -1 往前调1个工作日 1 往后调1个工作日
	 * @return >0找到指定工作 =0 为找不到指定工作日
	 * @throws SQLException
	 */
	public static int getNNextWorkDateUncludeToday(String[] dateTypes, int date, int offset,Map allHolidays) {
		if (offset == 0){
			return date;
		}
		//modified by qianxm  20130204   dateTypes的数据不能修改，否则会影响产生的数据
		String[] tempDateType = new String[dateTypes.length];
		for(int i=0; i<dateTypes.length; i++){
			tempDateType[i] = dateTypes[i];
			if("CNY".equals(dateTypes[i])){
				tempDateType[i] = "1";
			}
		}
		
		if (offset > 0) {
			int tmpTransDay = date;
			for (int i = 0; i < offset;i++) {
				tmpTransDay = DateUtil.addDate(tmpTransDay, 1);
				//校验0号币种是否为节假日，如果节假日则直接取下一日；如果为工作日则判该日是否为其他币种的假日，如果其他币种为假日，则继续取0号币种的下一日
				boolean flag = true;
				while(flag){
					if(isHoliday(tmpTransDay,(Map)allHolidays.get(tempDateType[0]))){
						tmpTransDay = DateUtil.addDate(tmpTransDay, 1);
					}else{
						boolean enterOtherHolidayFlag=false;  //如果出现其他币种的节假日，该标志为true，则需要进入while继续取0币种的下一日
						for(int j=1; j<tempDateType.length; j++){
							if(isHoliday(tmpTransDay,(Map)allHolidays.get(tempDateType[j]))){
								tmpTransDay = DateUtil.addDate(tmpTransDay, 1);
								enterOtherHolidayFlag=true;
								break;
							}
						}
						if(enterOtherHolidayFlag!=true){
							flag=false; //跳出本轮循环，取下一个偏移量
						}
					}
				}
			}
			return tmpTransDay;
		}else{
			int tmpTransDay = date;
			for (int i = 0; i < -offset;i++) {
				tmpTransDay = DateUtil.addDate(tmpTransDay, -1);
				//校验0号币种是否为节假日，如果节假日则直接取下一日；如果为工作日则判该日是否为其他币种的假日，如果其他币种为假日，则继续取0号币种的下一日
				boolean flag = true;
				while(flag){
					if(isHoliday(tmpTransDay,(Map)allHolidays.get(tempDateType[0]))){
						tmpTransDay = DateUtil.addDate(tmpTransDay, -1);
					}else{
						boolean enterOtherHolidayFlag=false;  //如果出现其他币种的节假日，该标志为true，则需要进入while继续取0币种的下一日
						for(int j=1; j<tempDateType.length; j++){
							if(isHoliday(tmpTransDay,(Map)allHolidays.get(tempDateType[j]))){
								tmpTransDay = DateUtil.addDate(tmpTransDay, -1);
								enterOtherHolidayFlag=true;
								break;
							}
						}
						if(enterOtherHolidayFlag!=true){
							flag=false; //跳出本轮循环，取下一个偏移量
						}
					}
				}
			}
			return tmpTransDay;
		}
	}
	
	/**
	 * 获取offset个工作日后的日期 （若当天是工作日，则不调，否则根据offset往前或往后调一个工作日，用于付息日/到期日节假日调整的方法实现）
	 * 
	 * @param dateType
	 *            日期类型
	 * @param date
	 *            原日期
	 * @param offset -1 往前调1个工作日 1 往后调1个工作日
	 * @return >0找到指定工作 =0 为找不到指定工作日
	 * @throws SQLException
	 */
	public static String getNNextWorkDateIncludeToday(String[] dateTypes, String date, int offset,Map allHolidays) {
		return String.valueOf(getNNextWorkDateIncludeToday(dateTypes,Integer.parseInt(date), offset, allHolidays));
	}
	
	/**
	 * 获取offset个工作日后的日期 （若当天是工作日，则不调，否则根据offset往前或往后调一个工作日，用于付息日/到期日节假日调整的方法实现）
	 * 
	 * @param dateType
	 *            日期类型
	 * @param date
	 *            原日期
	 * @param offset -1 往前调1个工作日 1 往后调1个工作日
	 * @return >0找到指定工作 =0 为找不到指定工作日
	 * @throws SQLException
	 */
	public static int getNNextWorkDateIncludeToday(String[] dateTypes, int date, int offset,Map allHolidays) {
		if (offset == 0){
			return date;
		}
		//modified by qianxm  20130204   dateTypes的数据不能修改，否则会影响产生的数据
		String[] tempDateType = new String[dateTypes.length];
		
		for(int i=0; i<dateTypes.length; i++){
			tempDateType[i] = dateTypes[i];
			if("CNY".equals(dateTypes[i])){
				tempDateType[i] = "1";
			}
		}
		//先判断当日收否为工作日，如果是则取今天并偏移量-1；否则直接取下一工作日
		boolean todayIsTransDay = true;
		for(int i=0; i<tempDateType.length; i++){
			if(isHoliday(date,(Map)allHolidays.get(tempDateType[i]))){
				todayIsTransDay = false;
			}
		}
		if(todayIsTransDay==true){
			return getNNextWorkDateUncludeToday(tempDateType, date, (offset>0) ? offset-1:offset+1,allHolidays);
		}else{
			return getNNextWorkDateUncludeToday(tempDateType, date, offset,allHolidays);
		}
	}
	
	/**
	 * 取得上一个/下一个工作日
	 * @param date         日期
	 * @param next true    下一工作日 false 上一工作日
	 * @param dateTypes    节假日类型
	 * @param allHolidays  节假日参数
	 * @return
	 */
	public static String getWorkDay(String date, boolean next, String[] dateTypes, Map allHolidays){
		int offset=0;
		if(next){
			offset=1;
		}else{
			offset=-1;
		}
		return getNNextWorkDateIncludeToday(dateTypes,date,offset,allHolidays);
	}
	/**
	 * 取得上一个/下一个工作日
	 * @param date         日期
	 * @param next true    下一工作日 false 上一工作日
	 * @param dateTypes    节假日类型
	 * @param allHolidays  节假日参数
	 * @return
	 */
	public static int getWorkDay(int date, boolean next, String[] dateTypes, Map allHolidays){
		return Integer.parseInt(getWorkDay(String.valueOf(date), next, dateTypes, allHolidays));
	}
	/**
	 * 顺延时的重置日判断
	 * @param date            原始日期
	 * @param sched_rule      节假日顺延规则
	 * @param dateTypes       节假日类型
	 * @param allHolidays     节假日参数
	 */
	private static void checkDate(String date,String sched_rule, String[] dateTypes, Map allHolidays){
		if(sched_rule!=null && (SCHED_RULE_1+","+SCHED_RULE_2+","+SCHED_RULE_3+","+SCHED_RULE_4).indexOf(sched_rule)!=-1){
			if(date!=null&&!date.equals(getNNextWorkDateIncludeToday(dateTypes, date, 1, allHolidays))){
				throw  new java.lang.RuntimeException("数据错误，重置日不可能为节假日！");
			}
		}
	}
	
	/**
	 * 根据币种数组取得节假日
	 * @param currency 节假日类型（一般为币种）
	 * @param allHolidays 系统缓存节假日（暂时由参数传入 TODO）
	 * @return
	 */
	/*全链表串接效率偏低，不建议使用
	public Map getHolidays(String[] currency, Map allHolidays){
		Map holidays = null;
		if(currency!=null){
			holidays = new HashMap();
			for(String cur : currency){
				holidays.putAll((Map)allHolidays.get(cur));
			}
		}
		return holidays;
	}
	*/
	/**
	 * 是否需要月末对齐处理
	 * @param maturity      资产到期日（必填）
	 * @param valueDate     资产起息日
	 * @param endMonthRule  月末法则
	 * @return
	 * @throws ParseException
	 */
	private static boolean isEndMonthDeal(String maturity, String valueDate, String endMonthRule, char basis_unit) throws ParseException{
		if(ENDMONTH_RULE_1.equals(endMonthRule)
				&& (BASIS_UNIT_M==basis_unit || BASIS_UNIT_Y==basis_unit)){
			String date = valueDate;//月末判断以起息日为准，如果没传起息日以到期日为准（到期日月末倒推有问题）
			if(date==null||"".equals(date.trim())){
				date = maturity;
			}
			return DateUtil.isEndOfMonth(date);
		}
		return false;
	}
	
	/**
	 * 月末对齐
	 * @param cal
	 * @throws ParseException 
	 */
	private static Calendar endMonthDeal(Calendar cal) throws ParseException{
		String date = DateUtil.getNumDateStr(cal);
		int year = 0; // 计息日的年份
		int month = 0; // 计息日的月份
		int day = 0; // 计息日的日子

		year = DateUtil.getYear(date);
		month = DateUtil.getMonth(date);//20130804 qibb 去掉 "+1"
		day = DateUtil.getDay(date);
		
		int leap = 0;
		if (DateUtil.isLeapYear(year)){
			leap = 1;
		}
		int endOfMonth = DateUtil.day_tbl[leap][month];
		if(day!=endOfMonth){
			day = endOfMonth;
			date = year + DataUtil.fix0BeforeNumber(month, 2)+DataUtil.fix0BeforeNumber(day, 2);
			return DateUtil.parseCalendar(date);
		}
		return cal;
	}
	
	/**
	 * 解析频率
	 * @param freq 格式：1d、1m
	 * @return 
	 */
	public static Object[] parseFreq(String freq){
		Object[] ret = new Object[2];
		if(freq!=null&&freq.matches("[tT]|[0-9]+[dwmyDWMY]{1}")){
			byte period = 0;
			if(freq.length()>1){
				period = Byte.parseByte(freq.substring(0, freq.length() - 1));
				if(period==0){
					throw new java.lang.RuntimeException("频率格式错误！");
				}
			}
			String unit = freq.toLowerCase().substring(freq.length() - 1);
			ret[0] = period;
			ret[1] = unit;
			return ret;
		}else{
			throw new java.lang.RuntimeException("频率格式错误！");
		}
	}
	
	/**
	 * 日历的加减运算
	 * @param cal     计算日历
	 * @param period  频率数值
	 * @param unit    频率单位 d,w,m,y
	 * @param mul     乘数，一般是第mul期
	 * @param flag    加减标志 -1减，+1加
	 */
	private static void add(Calendar cal, byte period, char unit, int mul, int flag){
		switch (unit) {
		case BASIS_UNIT_D:
			cal.add(Calendar.DATE,  period * mul * flag); // 对newRefEnd要多加减1天
			break; 
		case BASIS_UNIT_M:
			cal.add(Calendar.MONTH, period * mul * flag);// 对newRefEnd要多加减1个月份
			break; 
		case BASIS_UNIT_W:
			cal.add(Calendar.DATE,  period * 7 * mul * flag); // 对newRefEnd要多加减7天
			break; 
		case BASIS_UNIT_Y:
			cal.add(Calendar.YEAR,  period  * mul * flag); // 对newRefEnd要多加减1年
			break; 
		}
	}
	

}
