/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 日志初始化类
 * 类   名  称: Logger.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Logger {

	public static final String VERSION = "@version 1.0.0.1";

	protected static Logger obj;

	/**
	 * 日志配置文件
	 */
	public static final String FILE_LOG = "/log.xml";

	/**
	 * log4j变量
	 */
	protected static org.apache.log4j.Logger log4j;

	/**
	 * 控制台日志级别
	 */
	protected String conLevel;

	/**
	 * 文件日志级别
	 */
	protected String fileLevel;

	/**
	 * 日志输出格式
	 */
	protected String logFormat;

	/**
	 * 日志输出文件名
	 */
	protected String logFile;

	/**
	 * 文件后缀名
	 */
	protected String logFileDate;

	/**
	 * 是否输出控制台日志
	 */
	protected boolean isConsoleLog;

	/**
	 * 是否输出文件日志
	 */
	protected boolean isFileLog;

	/**
	 * 是否输出数据库日志
	 */
	protected boolean isDataLog;

	/**
	 * 是否以同步方式输出日志
	 */
	protected boolean isSyn;

	/**
	 * 是否以缓存日志方式输出日志文件
	 */
	protected boolean isBuffer;

	/**
	 * 缓存大小
	 */
	protected String bufferSize;

	protected StringBuffer strProper = new StringBuffer("");

	/**
	 * 得到控制台日志级别,分为DEBUG、INFO、ERROR、FATAL
	 * 
	 * @return
	 */
	public String getConLevel() {
		return conLevel;
	}

	/**
	 * 得到文件日志级别,分为DEBUG、INFO、ERROR、FATAL
	 * 
	 * @return
	 */
	public String getFileLevel() {
		return fileLevel;
	}

	/**
	 * 得到控制台日志输出选项,为true时为输出,false时为不输出
	 * 
	 * @return
	 */
	public boolean getIsConsoleLog() {
		return isConsoleLog;
	}

	/**
	 * 得到文件日志输出选项,为true时为输出,false时为不输出
	 * 
	 * @return
	 */
	public boolean getIsFileLog() {
		return isFileLog;
	}

	/**
	 * 日志输出是否以同步方式输出，以保证多线程同步输出时日志的交易原子性
	 * 
	 * @return
	 */
	public boolean getIsSyn() {
		return isSyn;
	}

	/**
	 * 是否输出数据库日志
	 * 
	 * @return
	 */
	public boolean getIsDataLog() {
		return isDataLog;
	}

	protected Logger() {
		try {
			init();
		} catch (LoggerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始配置信息,此方法同步,保证线程安全
	 * 
	 * @throws LoggerException
	 */
	public synchronized void init() throws LoggerException {
		this.readXmlLog();
		this.writeProperties();
		this.readProperties();
	}

	/**
	 * 读取配置文件,获取日志配置相关信息
	 */
	public void readXmlLog() throws LoggerException {
		SAXBuilder sb = new SAXBuilder();
		Document doc;
		try {
			InputStream stream = null;
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			if (classLoader != null) {
				stream = getClass().getResourceAsStream(FILE_LOG);
			}
			doc = sb.build(stream);
			Element elem = doc.getRootElement().getChild("logger");

			isConsoleLog = elem.getChildTextTrim("isConsoleLog") == null ? false : elem.getChildTextTrim("isConsoleLog").equals(
					"true") ? true : false;
			isFileLog = elem.getChildTextTrim("isFileLog") == null ? false
					: elem.getChildTextTrim("isFileLog").equals("true") ? true : false;
			isDataLog = elem.getChildTextTrim("isFileLog") == null ? false
					: elem.getChildTextTrim("isFileLog").equals("true") ? true : false;
			isSyn = elem.getChildTextTrim("isSyn") == null ? false : elem.getChildTextTrim("isSyn").equals("true") ? true : false;
			isBuffer = elem.getChildTextTrim("isBuffer") == null ? false
					: elem.getChildTextTrim("isBuffer").equals("true") ? true : false;

			conLevel = elem.getChildTextTrim("conLevel");
			fileLevel = elem.getChildTextTrim("fileLevel");
			logFile = elem.getChildTextTrim("logFileName");
			bufferSize = elem.getChildTextTrim("bufferSize");
			logFormat = "[%-5p]%m%n";
			logFileDate = "yyyyMMdd";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LoggerException("初始化日志配置@读取XML文件没找到异常", e);
		} catch (JDOMException e) {
			e.printStackTrace();
			throw new LoggerException("初始化日志配置@读取XML文件解析异常", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new LoggerException("初始化日志配置@读取XML文件IO异常", e);
		}
	}

	/**
	 * 将"base.xml"的日志基本配置信息转换为log4j识别的日志配置文件,并生成临时文件
	 */
	public void writeProperties() throws LoggerException {
		strProper.append("log4j.logger.Syslog=");
		strProper.append("DEBUG");
		if (isConsoleLog) {
			strProper.append(",console");
		}
		if (isFileLog) {
			strProper.append(",file");
		}
		strProper.append("\n");
		if (isConsoleLog) {
			strProper.append("log4j.appender.console=org.apache.log4j.ConsoleAppender\n");
			strProper.append("log4j.appender.console.Threshold=");
			strProper.append(conLevel);
			strProper.append("\n");
			strProper.append("log4j.appender.console.layout=org.apache.log4j.PatternLayout\n");
			if (logFormat != null) {
				strProper.append("log4j.appender.console.layout.ConversionPattern=");
				strProper.append(logFormat);
				strProper.append("\n");
			}
		}
		if (isFileLog) {
			strProper.append("log4j.appender.file=org.apache.log4j.DailyRollingFileAppender\n");
			strProper.append("log4j.appender.file.Threshold=");
			strProper.append(fileLevel);
			strProper.append("\n");
			if (isBuffer) {
				strProper.append("log4j.appender.file.BufferedIO=true");
				strProper.append("\n");
				strProper.append("log4j.appender.file.BufferSize=" + bufferSize);
				strProper.append("\n");
			}
			if (StringUtils.isEmpty(logFile)) {
				strProper.append("log4j.appender.file.File=log/trace");
			} else {
				if (logFile.startsWith("/") || logFile.indexOf(":") != -1) {
					strProper.append("log4j.appender.file.File=" + logFile);
				} else {
					strProper.append("log4j.appender.file.File=log/" + logFile);
				}
			}
			strProper.append("\n");
			strProper.append("log4j.appender.file.layout=org.apache.log4j.PatternLayout\n");
			strProper.append("log4j.appender.file.DatePattern=");
			if (logFileDate != null) {
				strProper.append(logFileDate);
			} else {
				strProper.append("'-'yyyy-MM-dd");
			}
			strProper.append("\n");
			if (logFormat != null) {
				strProper.append("log4j.appender.file.layout.ConversionPattern=");
				strProper.append(logFormat);
				strProper.append("\n");
			}
		}
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream("log4j.properties"));
			out.write(strProper.toString().getBytes(), 0, strProper.toString().getBytes().length);
			out.flush();
		} catch (FileNotFoundException e) {
			throw new LoggerException("初始化日志配置@读取log4j配置文件没找到异常", e);
		} catch (IOException e) {
			throw new LoggerException("初始化日志配置@读取log4j文件IO异常", e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new LoggerException("初始化日志配置@关闭文件异常", e);
				}
			}
		}
	}

	/**
	 * 读取临时log4j配置文件里的配置信息,完成对log4j的初始化
	 */
	public void readProperties() throws LoggerException {
		try {
			File logFile = new File("log");
			if (!logFile.isDirectory()) {
				logFile.mkdir();
			}
			PropertyConfigurator.configure("log4j.properties");
			log4j = org.apache.log4j.Logger.getLogger("Syslog");
			File logConfig = new File("log4j.properties");
			if (logConfig.exists()) {
				logConfig.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoggerException("初始化日志配置@读日志配置文件异常", e);
		}
	}

	/**
	 * 刷新日志配置信息
	 */
	public void refresh() throws LoggerException {
		obj = new Logger();
	}
}
