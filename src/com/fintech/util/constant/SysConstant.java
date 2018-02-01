/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 常量类
 * 类   名  称: SysConstant.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-4-25
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.constant;

public class SysConstant {

	public static final String VERSION = "@version 1.0.0.1";

	/************************* 系统时区 *******************************/
	/**
	 * 系统时区
	 */
	public static final String TIMEZONE = "Asia/Shanghai";

	/************************* 日志级别 *******************************/
	/**
	 * 日志级别:DEBUG
	 */
	public static final String LOGTYPE_DEBUG = "DEBUG";

	/**
	 * 日志级别:INFO
	 */
	public static final String LOGTYPE_INFO = "INFO";

	/**
	 * 日志级别:ERROR
	 */
	public static final String LOGTYPE_ERROR = "ERROR";

	/**
	 * 日志级别:FATAL
	 */
	public static final String LOGTYPE_FATAL = "FATAL";

	/************************* 数据库字段类型 *****************************/
	/**
	 * 数据库字段类型:char
	 */
	public static final String TYPE_CHAR = "CHAR";

	/**
	 * 数据库字段类型:varchar
	 */
	public static final String TYPE_VARCHAR2 = "VARCHAR";

	/**
	 * 数据库字段类型:integer
	 */
	public static final String TYPE_INTEGER = "INTEGER";

	/**
	 * 数据库字段类型:number
	 */
	public static final String TYPE_NUMBER = "NUMBER";

	/**
	 * 数据库字段类型:date
	 */
	public static final String TYPE_DATE = "DATE";

	/************************* SQL类型 ********************************/
	/**
	 * SQL类型:select
	 */
	public static final String TYPE_SELECT = "SELECT";

	/**
	 * SQL类型:insert
	 */
	public static final String TYPE_INSERT = "INSERT";

	/**
	 * SQL类型:delete
	 */
	public static final String TYPE_DELETE = "DELETE";

	/**
	 * SQL类型:update
	 */
	public static final String TYPE_UPDATE = "UPDATE";
	
	/************************* 是否开关 **********************************/
	/**
	 * 是否开关：是/成功
	 */
	public static final String YESORNO_YES = "1";
	
	/**
	 * 是否开关：否/失败
	 */
	public static final String YESORNO_NO = "0";
	
	/************************* 登录状态 **********************************/
	/**
	 * 登录状态：在线
	 */
	public static final String LOGON_STATUS_ONLINE = "1";
	
	/**
	 * 登录状态：离线
	 */
	public static final String LOGON_STATUS_OFFLINE = "0";
	
	/************************* 权限类型**********************************/
	/**
	 * 权限类型：操作
	 */
	public static final String USER_RIGHT_USE = "1";
	
	/**
	 * 权限类型：授权
	 */
	public static final String USER_RIGHT_GRANT = "2";
	
	/************************* 权限对象**********************************/
	/**
	 * 权限对象：用户
	 */
	public static final String RIGHT_OBJECT_USER = "1";
	
	/**
	 * 权限对象：角色
	 */
	public static final String RIGHT_OBJECT_ROLE = "2";


	/************************* 配置文件名 ********************************/
	/**
	 * 配置文件名:/applicationContext.xml
	 */
	public static final String XMLNAME = "/applicationContext.xml";

	/************************* 交易后缀 **********************************/
	/**
	 * 交易后缀：.do
	 */
	public static final String ACTION_SUFFIX = ".do";
	
	/************************* 默认交易 **********************************/
	/**
	 * 默认交易 ：def
	 */
	public static final String DEF_SUB_CODE = "doAction";
	
	/************************* 系统菜单树 **********************************/
	/**
	 * 系统菜单树：sysMenuTree
	 */
	public static final String SYS_MENU_TREE = "sysMenuTree";
	
	/************************* 当前登录用户 **********************************/
	/**
	 * 当前登录用户：sysLogonUser
	 */
	public static final String SYS_LOGON_USER = "sysLogonUser";
}
