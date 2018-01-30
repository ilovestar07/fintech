/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 数学工具类
 * 类   名  称: MathUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-12-29
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.common;

import java.math.BigDecimal;

public class MathUtil {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 默认除法运算精度
	 */
	private static final int DEF_DIV_SCALE = 16;
	
	/**
	 * Object类型转化成Integer，过滤空指针异常
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer convObjToInt(Object obj) {
		return obj == null || "".equals(obj.toString()) ? 0 : Integer.parseInt(obj.toString());
	}

	/**
	 * Object类型转化成Double，过滤空指针异常
	 * 
	 * @param obj
	 * @param ret
	 * @return
	 */
	public static Double convObjToDou(Object obj, Double ret) {
		return obj == null || "".equals(obj.toString()) ? ret : Double.parseDouble(obj.toString());
	}

	/**
	 * Object类型转化成Double，过滤空指针异常
	 * 
	 * @param obj
	 * @return
	 */
	public static Double convObjToDou(Object obj) {
		return obj == null || "".equals(obj.toString()) ? 0.00 : Double.parseDouble(obj.toString());
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static Double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static Double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static Double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static Double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            精度
	 * @return
	 */
	public static Double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("精度必须是一个正整数!");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            数值
	 * @param scale
	 *            精度
	 * @return 四舍五入后的结果
	 */
	public static Double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("精度必须是一个正整数!");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
