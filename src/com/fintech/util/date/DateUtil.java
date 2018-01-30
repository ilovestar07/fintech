/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 时间工具类
 * 类   名  称: DateUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-4-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.fintech.listen.Initiator;
import com.fintech.util.constant.SysConstant;

public class DateUtil {

	public static final String VERSION = "@version 1.0.0.1";

	private static TimeZone tz = TimeZone.getTimeZone(SysConstant.TIMEZONE);

	private static String[] week = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

	/**
	 * 获取系统日期、星期、时间
	 * 
	 * @return
	 */
	public static String getSysDateTime() {
		String sysDate = null;
		if (Initiator.parameter != null) {
			sysDate = Initiator.parameter.getSys_date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(tz);
		if (sysDate != null && !"".equals(sysDate)) {
			calendar.set(Integer.valueOf(sysDate.substring(0, 4)), Integer.valueOf(sysDate.substring(4, 6)) - 1,
					Integer.valueOf(sysDate.substring(6, 8)));
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(tz);
		timeFormat.setTimeZone(tz);
		return dateFormat.format(calendar.getTime()) + " " + week[calendar.get(Calendar.DAY_OF_WEEK) - 1] + " "
				+ timeFormat.format(calendar.getTime());
	}

	/**
	 * 获取服务器日期时间
	 * 
	 * @return 服务器日期时间
	 */
	public static String getServerDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取服务器年
	 * 
	 * @return 服务器年
	 */
	public static String getServerYear() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取服务器月
	 * 
	 * @return 服务器月
	 */
	public static String getServerMonth() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取服务器日期
	 * 
	 * @return 服务器日期
	 */
	public static String getServerDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取服务器时间
	 * 
	 * @return 服务器时间
	 */
	public static String getServerTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取自定义格式服务器时间
	 * 
	 * @param formate
	 *            时间格式,如：yyyy-MM-dd HH:mm:ss
	 * @return 自定义格式服务器时间
	 */
	public static String getServerTime(String formate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取指定时区和自定义格式的服务器时间
	 * 
	 * @param tz
	 *            时区
	 * @param formate
	 *            时间格式,如：yyyy-MM-dd HH:mm:ss
	 * @return 指定时区和自定义格式的服务器时间
	 */
	public static String getServerTime(TimeZone tz, String formate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * 获取服务器季度
	 * 
	 * @return 服务器当期季度
	 */
	public static int getServerSeason() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		dateFormat.setTimeZone(tz);
		int season = 1;
		Calendar calendar = Calendar.getInstance();
		int month = Integer.parseInt(dateFormat.format(calendar.getTime()));
		if (month == 1 || month == 2 || month == 3) {
			season = 1;
		} else if (month == 4 || month == 5 || month == 6) {
			season = 2;
		} else if (month == 7 || month == 8 || month == 9) {
			season = 3;
		} else {
			season = 4;
		}
		return season;
	}

	/**
	 * 获取服务器上当月的最后一天
	 * 
	 * @return 服务器当月最后一天
	 */
	public static String getLastDateOfMonth() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(tz);
		Calendar calendar = Calendar.getInstance();
		String day = dateFormat.format(calendar.getTime()).substring(8, 10);
		int month = Integer.parseInt(dateFormat.format(calendar.getTime()).substring(5, 7));
		int year = Integer.parseInt(dateFormat.format(calendar.getTime()).substring(0, 4));
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = "30";
		} else if (month == 2) {
			if (year % 4 == 0 && year % 100 != 0) {
				day = "29";
			} else {
				day = "28";
			}
		} else {
			day = "31";
		}
		return dateFormat.format(calendar.getTime()).substring(0, 8) + day;
	}

	/**
	 * 比较两个日期大小
	 * 
	 * @param date
	 * @param compareDate
	 * @return
	 */
	public static int isDateBefore(String date, String compareDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date d1 = dateFormat.parse(date);
			Date d2 = dateFormat.parse(compareDate);
			if (d1.before(d2)) {
				return -1;
			} else if (d2.before(d1)) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 计算两个日期相隔天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Double subDate(String date1, String date2) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date d1 = dateFormat.parse(date1);
			Date d2 = dateFormat.parse(date2);

			long tmp = d1.getTime() - d2.getTime();
			if (tmp < 0) {
				tmp = -tmp;
			}
			double diff = (double) (tmp / (24.00 * 60.00 * 60.00 * 1000.00));
			return diff;
		} catch (Exception e) {
			return Double.NaN;
		}
	}

	/**
	 * 计算两个日期相隔年数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Double subYear(String date1, String date2) {
		Double year1 = Double.parseDouble(getYear(date1));
		Double year2 = Double.parseDouble(getYear(date2));
		return Math.abs(year1 - year2);
	}

	/**
	 * 获取自然年天数
	 * 
	 * @param year
	 * @return
	 */
	public static Double getNaturalYearDays(String year) {
		return subDate(year + "1231", year + "0101");
	}

	/**
	 * 获取日期年份
	 * 
	 * @param date
	 * @return
	 */
	public static String getYear(String date) {
		String year = date.substring(0, 4);
		return year;
	}

	/**
	 * 计算某个日期之后/之前几天的日期
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static String addDate(String date, int days) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		calendar.add(Calendar.DATE, days);
		long newDate = calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100
				+ calendar.get(Calendar.DAY_OF_MONTH);
		return String.valueOf(newDate);
	}

	/**
	 * 计算某个日期之后/之前几个月的日期
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static String addMonth(String date, int months) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		try {
			if (date != null && !"".equals(date)) {
				c.setTime(dateFormat.parse(date));
				c.add(Calendar.MONTH, months);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateFormat.format(c.getTime());
	}

	/**
	 * 计算某个日期之后/之前几个月年的日期
	 * 
	 * @param date
	 * @param years
	 * @return
	 */
	public static String addYears(String date, int years) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		try {
			if (date != null && !"".equals(date)) {
				c.setTime(dateFormat.parse(date));
				c.add(Calendar.YEAR, years);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateFormat.format(c.getTime());

	}
}
