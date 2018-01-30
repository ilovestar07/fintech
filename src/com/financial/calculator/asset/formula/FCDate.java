/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCDate.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2015-01-06
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.asset.formula;

import com.financial.calculator.util.constant.FCDict;
import com.fintech.util.date.DateUtil;

public class FCDate {

	public static final String VERSION = "@version 1.0.0.1";

	private static final String DATE_DIR = "F";

	/**
	 * 计算下一个付息日
	 * 
	 * @param startDate
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	public static String getNextPayDate(String startDate, String date, String freq, String endMonthRule) {
		if (DATE_DIR.equals(FCDict.DATE_DIR_B)) {
			return getNextPayDateBack(startDate, date, freq, endMonthRule);
		} else {
			return getNextPayDateForward(startDate, date, freq, endMonthRule);
		}
	}

	/**
	 * 计算上一个付息日
	 * 
	 * @param startDate
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	public static String getLastPayDate(String startDate, String date, String freq, String endMonthRule) {
		if (DATE_DIR.equals(FCDict.DATE_DIR_B)) {
			return getLastPayDateBack(startDate, date, freq, endMonthRule);
		} else {
			return getLastPayDateForward(startDate, date, freq, endMonthRule);
		}
	}

	/**
	 * 从前向后计算下一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getNextPayDateForward(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		if (DateUtil.isDateBefore(date, startDate) == FCDict.DATA_BEFORE) {
			return startDate;
		}
		Object[] obj = parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = fcDate(startDate, step, unit, i);
		while (DateUtil.isDateBefore(nextDate, date) == FCDict.DATA_BEFORE
				|| DateUtil.isDateBefore(nextDate, date) == FCDict.DATA_THEN) {
			i++;
			nextDate = fcDate(startDate, step, unit, i);
		}
		return nextDate;
	}

	/**
	 * 从后向前计算下一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getNextPayDateBack(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		String tempNextDate = "";
		if (DateUtil.isDateBefore(startDate, date) == FCDict.DATA_BEFORE) {
			return startDate;
		}
		Object[] obj = parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = startDate;
		tempNextDate = fcDate(startDate, step, unit, -i);
		while (DateUtil.isDateBefore(tempNextDate, date) == FCDict.DATA_AFTER) {
			nextDate = tempNextDate;
			i++;
			tempNextDate = fcDate(startDate, step, unit, -i);
		}
		return nextDate;
	}

	/**
	 * 从前向后计算上一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getLastPayDateForward(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		String tempNextDate = "";
		if (DateUtil.isDateBefore(startDate, date) == FCDict.DATA_AFTER) {
			return startDate;
		}
		Object[] obj = parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = startDate;
		tempNextDate = fcDate(startDate, step, unit, i);
		while (DateUtil.isDateBefore(tempNextDate, date) == FCDict.DATA_BEFORE
				|| DateUtil.isDateBefore(tempNextDate, date) == FCDict.DATA_THEN) {
			nextDate = tempNextDate;
			i++;
			tempNextDate = fcDate(startDate, step, unit, i);
		}
		return nextDate;
	}

	/**
	 * 从后向前计算上一个付息日
	 * 
	 * @param startDate
	 * @param order
	 * @param date
	 * @param freq
	 * @param endMonthRule
	 * @return
	 */
	private static String getLastPayDateBack(String startDate, String date, String freq, String endMonthRule) {
		String nextDate = "";
		if (DateUtil.isDateBefore(startDate, date) == FCDict.DATA_BEFORE) {
			return startDate;
		}
		Object[] obj = parseFreq(freq);
		Integer step = (Integer) obj[0];
		char unit = ((String) obj[1]).charAt(0);
		int i = 1;
		nextDate = fcDate(startDate, step, unit, -i);
		while (DateUtil.isDateBefore(nextDate, date) == FCDict.DATA_AFTER) {
			i++;
			nextDate = fcDate(startDate, step, unit, -i);
		}
		return nextDate;
	}

	/**
	 * 计算日期
	 * 
	 * @param date
	 * @param step
	 * @param unit
	 * @param num
	 * @return
	 */
	private static String fcDate(String date, Integer step, char unit, Integer num) {
		String retDate = date;
		switch (unit) {
		case FCDict.BASIS_UNIT_D:
			retDate = DateUtil.addDate(date, step * num);
			break;
		case FCDict.BASIS_UNIT_W:
			retDate = DateUtil.addDate(date, 7 * step * num);
			break;
		case FCDict.BASIS_UNIT_M:
			retDate = DateUtil.addMonth(date, step * num);
			break;
		case FCDict.BASIS_UNIT_Y:
			retDate = DateUtil.addYears(date, step * num);
			break;
		}
		return retDate;
	}

	/**
	 * 解析付息频率
	 * 
	 * @param freq
	 * @return
	 */
	private static Object[] parseFreq(String freq) {
		Object[] ret = new Object[2];
		if (freq != null && freq.matches("[tT]|[0-9]+[dwmyDWMY]{1}")) {
			Integer setp = 0;
			if (freq.length() > 1) {
				setp = Integer.parseInt(freq.substring(0, freq.length() - 1));
			}
			String unit = freq.toLowerCase().substring(freq.length() - 1);
			ret[0] = setp;
			ret[1] = unit;
			return ret;
		} else {
			throw new java.lang.RuntimeException("频率格式错误！");
		}
	}
}
