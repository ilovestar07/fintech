/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 日志异常类
 * 类   名  称: LoggerException.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.log;

import java.io.PrintStream;

public class LoggerException extends Exception {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 7131072986120240189L;

	private Throwable thrLog;

	private String message;

	private int errcode;

	public LoggerException() {
		LoggerExceptionInit("logger worke error", 1013, null);
	}

	public LoggerException(String strMessage) {
		LoggerExceptionInit(strMessage, 1013, null);
	}

	public LoggerException(String strMessage, int intErrcode) {
		LoggerExceptionInit(strMessage, intErrcode, null);
	}

	public LoggerException(Throwable thrErr) {
		LoggerExceptionInit("logger worke error", 1031, null);
	}

	public LoggerException(String strMessage, Throwable thrErr) {
		LoggerExceptionInit(strMessage, 1031, thrErr);
	}

	private final void LoggerExceptionInit(String strMessage, int intErrcode, Throwable thrErr) {
		message = strMessage;
		errcode = intErrcode;
		thrLog = thrErr;
	}

	public void printStackTrace(PrintStream e) {
		synchronized (e) {
			if (thrLog != null) {
				e.println(getClass().toString() + ":" + message);
				thrLog.printStackTrace(e);
			} else {
				super.printStackTrace(e);
			}
		}
	}

	public String getMessage() {
		return message;
	}

	public int getErrcode() {
		return errcode;
	}
}
