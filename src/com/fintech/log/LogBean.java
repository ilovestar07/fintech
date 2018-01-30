/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 日志实体类
 * 类   名  称: LogBean.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.log;

public class LogBean {

	public static final String VERSION = "@version 1.0.0.1";

	private String logId;

	private int logLev;

	private String logContent;

	private Throwable exception;

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogLev(int logLev) {
		this.logLev = logLev;
	}

	public int getLogLev() {
		return logLev;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setException(Throwable e) {
		this.exception = e;
	}

	public Throwable getException() {
		return exception;
	}
}
