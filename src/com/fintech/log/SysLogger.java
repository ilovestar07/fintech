/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统日志
 * 类   名  称: SysLogger.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.log;

public class SysLogger extends Logger {

	public static final String VERSION = "@version 1.0.0.1";

	private static SysLogger obj;

	/**
	 * 保证初始化类一次
	 * 
	 * @return
	 */
	public static SysLogger getInstance() {
		if (obj == null) {
			obj = new SysLogger();
		}
		return (SysLogger) obj;
	}

	/**
	 * 写debug日志
	 * 
	 * @param message
	 *            日志内容
	 */
	public void writeDebug(String message) {
		log4j.debug(message);
	}

	/**
	 * 写info日志
	 * 
	 * @param message
	 *            日志内容
	 */
	public void writeInfo(String message) {
		log4j.info(message);
	}

	/**
	 * 写error日志
	 * 
	 * @param message
	 *            日志内容
	 */
	public void writeError(String message) {
		log4j.error(message);
	}

	/**
	 * 写error日志
	 * 
	 * @param message
	 *            日志内容
	 * @param e
	 *            异常类
	 */
	public void writeError(String message, Throwable e) {
		log4j.error(message, e);
	}

	/**
	 * 写fatal日志
	 * 
	 * @param message
	 *            日志内容
	 */
	public void writeFatal(String message) {
		log4j.fatal(message);
	}

	/**
	 * 写fatal日志
	 * 
	 * @param message
	 *            日志内容
	 * @param e
	 *            异常类
	 */
	public void writeFatal(String message, Throwable e) {
		log4j.fatal(message, e);
	}

	/**
	 * 刷新日志配置信息
	 */
	public void refresh() throws LoggerException {
		obj = new SysLogger();
	}
}
