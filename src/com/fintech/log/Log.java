/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 日志
 * 类   名  称: Log.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fintech.util.common.Utils;
import com.fintech.util.constant.SysConstant;
import com.fintech.util.date.DateUtil;

public class Log {

	public static final String VERSION = "@version 1.0.0.1";

	private static Log obj;

	private static HashMap<String, List<LogBean>> logBuf = new HashMap<String, List<LogBean>>();

	private static boolean isDebug = false;

	private static boolean isInfo = false;

	private static boolean isError = false;

	private static boolean isFatal = false;

	private static boolean isSyn = false;

	static {
		obj = new Log();
		boolean isFileLog = SysLogger.getInstance().getIsFileLog();
		boolean isConsoleLog = SysLogger.getInstance().getIsConsoleLog();
		String fileLogLevel = SysLogger.getInstance().getFileLevel();
		String conLogLevel = SysLogger.getInstance().getConLevel();
		isSyn = SysLogger.getInstance().getIsSyn();

		if (isFileLog) {
			if (SysConstant.LOGTYPE_DEBUG.equals(fileLogLevel)) {
				isDebug = true;
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (SysConstant.LOGTYPE_INFO.equals(fileLogLevel)) {
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (SysConstant.LOGTYPE_ERROR.equals(fileLogLevel)) {
				isError = true;
				isFatal = true;
			} else if (SysConstant.LOGTYPE_FATAL.equals(fileLogLevel)) {
				isFatal = true;
			}
		}
		if (isConsoleLog) {
			if (SysConstant.LOGTYPE_DEBUG.equals(conLogLevel)) {
				isDebug = true;
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (SysConstant.LOGTYPE_INFO.equals(conLogLevel)) {
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (SysConstant.LOGTYPE_ERROR.equals(conLogLevel)) {
				isError = true;
				isFatal = true;
			} else if (SysConstant.LOGTYPE_FATAL.equals(conLogLevel)) {
				isFatal = true;
			}
		}
	}

	public static Log getInstance() {
		if (obj == null) {
			obj = new Log();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			boolean isFileLog = SysLogger.getInstance().getIsFileLog();
			boolean isConsoleLog = SysLogger.getInstance().getIsConsoleLog();
			String fileLogLevel = SysLogger.getInstance().getFileLevel();
			String conLogLevel = SysLogger.getInstance().getConLevel();
			if (isFileLog) {
				if (fileLogLevel.equals("DEBUG")) {
					isDebug = true;
					isInfo = true;
					isError = true;
					isFatal = true;
				} else if (fileLogLevel.equals("INFO")) {
					isInfo = true;
					isError = true;
					isFatal = true;
				} else if (fileLogLevel.equals("ERROR")) {
					isError = true;
					isFatal = true;
				} else if (fileLogLevel.equals("FATAL")) {
					isFatal = true;
				}
			}
			if (isConsoleLog) {
				if (conLogLevel.equals("DEBUG")) {
					isDebug = true;
					isInfo = true;
					isError = true;
					isFatal = true;
				} else if (conLogLevel.equals("INFO")) {
					isInfo = true;
					isError = true;
					isFatal = true;
				} else if (conLogLevel.equals("ERROR")) {
					isError = true;
					isFatal = true;
				} else if (conLogLevel.equals("FATAL")) {
					isFatal = true;
				}
			}
		}
		return (Log) obj;
	}

	public void debug(String logId, String message) {
		if (isDebug && isSyn) {
			LogBean logBean = new LogBean();
			logBean.setLogId(logId);
			logBean.setLogLev(0);
			logBean.setLogContent("[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]")
					+ message);
			putBuf(logId, logBean);
		} else if (isDebug) {
			SysLogger.getInstance().writeDebug(
					"[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]") + message);
		}
	}

	public void debug(String logId, String[] message) {
		String msg = "";
		if (message.length > 0) {
			for (int i = 0; i < message.length; i++) {
				msg += "\r\n" + message[i];
			}
		}
		this.debug(logId, msg);
	}

	public void info(String logId, String message) {
		if (isInfo && isSyn) {
			LogBean logBean = new LogBean();
			logBean.setLogId(logId);
			logBean.setLogLev(1);
			logBean.setLogContent("[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]")
					+ message);
			putBuf(logId, logBean);
		} else if (isInfo) {
			SysLogger.getInstance().writeInfo(
					"[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]") + message);
		}
	}

	public void info(String logId, String[] message) {
		String msg = "";
		if (message.length > 0) {
			for (int i = 0; i < message.length; i++) {
				msg += "\r\n" + message[i];
			}
		}
		this.info(logId, msg);
	}

	public void error(String logId, String message) {
		if (isError && isSyn) {
			LogBean logBean = new LogBean();
			logBean.setLogId(logId);
			logBean.setLogLev(2);
			logBean.setLogContent("[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]")
					+ message);
			putBuf(logId, logBean);
		} else if (isError) {
			SysLogger.getInstance().writeError(
					"[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]") + message);
		}
	}

	public void error(String logId, String[] message) {
		String msg = "";
		if (message.length > 0) {
			for (int i = 0; i < message.length; i++) {
				msg += "\r\n" + message[i];
			}
		}
		this.error(logId, msg);
	}

	public void error(String logId, String message, Throwable e) {
		if (isError && isSyn) {
			LogBean logBean = new LogBean();
			logBean.setLogId(logId);
			logBean.setLogLev(2);
			logBean.setException(e);
			logBean.setLogContent("[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]")
					+ message);
			putBuf(logId, logBean);
		} else if (isError) {
			SysLogger.getInstance().writeError(
					"[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]") + message, e);
		}
	}

	public void error(String logId, String[] message, Throwable e) {
		String msg = "";
		if (message.length > 0) {
			for (int i = 0; i < message.length; i++) {
				msg += "\r\n" + message[i];
			}
		}
		this.error(logId, msg, e);
	}

	public void fatal(String logId, String message) {
		if (isFatal && isSyn) {
			LogBean logBean = new LogBean();
			logBean.setLogId(logId);
			logBean.setLogLev(3);
			logBean.setLogContent("[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]")
					+ message);
			putBuf(logId, logBean);
		} else if (isFatal) {
			SysLogger.getInstance().writeFatal(
					"[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]") + message);
		}
	}

	public void fatal(String logId, String[] message) {
		String msg = "";
		if (message.length > 0) {
			for (int i = 0; i < message.length; i++) {
				msg += "\r\n" + message[i];
			}
		}
		this.fatal(logId, msg);
	}

	public void fatal(String logId, String message, Throwable e) {
		if (isFatal && isSyn) {
			LogBean logBean = new LogBean();
			logBean.setLogId(logId);
			logBean.setLogLev(3);
			logBean.setException(e);
			logBean.setLogContent("[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]")
					+ message);
			putBuf(logId, logBean);
		} else if (isFatal) {
			SysLogger.getInstance().writeFatal(
					"[" + logId + "]" + "[" + Utils.getLocalIP() + "]" + DateUtil.getServerTime("[HH:mm:ss,SSS]") + message, e);
		}
	}

	public void fatal(String logId, String[] message, Throwable e) {
		String msg = "";
		if (message.length > 0) {
			for (int i = 0; i < message.length; i++) {
				msg += "\r\n" + message[i];
			}
		}
		this.fatal(logId, msg, e);
	}

	public void flush(String logId) {
		if (isSyn) {
			flushSyn(logId);
		} else {
			flushNotSyn(logId);
		}
	}

	public synchronized void flushSyn(String logId) {
		try {
			ArrayList<LogBean> list = (ArrayList<LogBean>) getBuf(logId);
			for (int i = 0; list != null && i < list.size(); i++) {
				LogBean logBean = (LogBean) list.get(i);
				int level = logBean.getLogLev();
				if (level == 0) {
					SysLogger.getInstance().writeDebug(logBean.getLogContent());
				} else if (level == 1) {
					SysLogger.getInstance().writeInfo(logBean.getLogContent());
				} else if (level == 2) {
					SysLogger.getInstance().writeError(logBean.getLogContent(), logBean.getException());
				} else if (level == 3) {
					SysLogger.getInstance().writeFatal(logBean.getLogContent(), logBean.getException());
				}
			}
		} finally {
			removeBuf(logId);
		}
	}

	public void flushNotSyn(String logId) {
		try {
			ArrayList<LogBean> list = (ArrayList<LogBean>) getBuf(logId);
			for (int i = 0; list != null && i < list.size(); i++) {
				LogBean logBean = (LogBean) list.get(i);
				int level = logBean.getLogLev();
				if (level == 0) {
					SysLogger.getInstance().writeDebug(logBean.getLogContent());
				} else if (level == 1) {
					SysLogger.getInstance().writeInfo(logBean.getLogContent());
				} else if (level == 2) {
					SysLogger.getInstance().writeError(logBean.getLogContent(), logBean.getException());
				} else if (level == 3) {
					SysLogger.getInstance().writeFatal(logBean.getLogContent(), logBean.getException());
				}
			}
		} finally {
			removeBuf(logId);
		}
	}

	public void putBuf(String logId, LogBean logBean) {
		synchronized (logBuf) {
			ArrayList<LogBean> logList = (ArrayList<LogBean>) logBuf.get(logId);
			if (logList == null) {
				logList = new ArrayList<LogBean>();
				logList.add(logBean);
				logBuf.put(logId, logList);
			} else {
				logList.add(logBean);
				logBuf.put(logId, logList);
				if (logList.size() >= 100) {
					flush(logId);
				}
			}
		}
	}

	public List<LogBean> getBuf(String logId) {
		List<LogBean> list = null;
		synchronized (logBuf) {
			list = (ArrayList<LogBean>) logBuf.get(logId);
		}
		return list;
	}

	public void removeBuf(String logId) {
		synchronized (logBuf) {
			logBuf.remove(logId);
		}
	}

	public void refresh() throws LoggerException {
		obj = new Log();
		SysLogger.getInstance().refresh();
		boolean isFileLog = SysLogger.getInstance().getIsFileLog();
		boolean isConsoleLog = SysLogger.getInstance().getIsConsoleLog();
		String fileLogLevel = SysLogger.getInstance().getFileLevel();
		String conLogLevel = SysLogger.getInstance().getConLevel();
		isSyn = SysLogger.getInstance().getIsSyn();

		if (isFileLog) {
			if (fileLogLevel.equals("DEBUG")) {
				isDebug = true;
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (fileLogLevel.equals("INFO")) {
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (fileLogLevel.equals("ERROR")) {
				isError = true;
				isFatal = true;
			} else if (fileLogLevel.equals("FATAL")) {
				isFatal = true;
			}
		}
		if (isConsoleLog) {
			if (conLogLevel.equals("DEBUG")) {
				isDebug = true;
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (conLogLevel.equals("INFO")) {
				isInfo = true;
				isError = true;
				isFatal = true;
			} else if (conLogLevel.equals("ERROR")) {
				isError = true;
				isFatal = true;
			} else if (conLogLevel.equals("FATAL")) {
				isFatal = true;
			}
		}
	}
}
