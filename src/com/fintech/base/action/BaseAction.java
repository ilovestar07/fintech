/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 控制类
 * 类   名  称: BaseAction.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.base.action;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseAction {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 返回JSON ：SUCCESS
	 */
	protected static final String SUCCESS = "{\"success\":\"true\"}";

	/**
	 * 返回JSON ：FAILURE
	 */
	protected static final String FAILURE = "{\"success\":\"false\"}";

	/**
	 * 客户端请求,由主控servlet传入
	 */
	protected HttpServletRequest request = null;

	/**
	 * 服务端应答,由主控servlet传入
	 */
	protected HttpServletResponse response = null;

	/**
	 * servlet配置,由主控servlet传入
	 */
	protected ServletConfig config = null;

	/**
	 * 系统请求属性
	 */
	protected Map<String, Object> sysReqMap = null;

	/**
	 * 初始化
	 * 
	 * @throws Exception
	 */
	public void init(ServletConfig config, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map)
			throws Exception {
		this.config = config;
		this.request = request;
		this.response = response;
		this.sysReqMap = map;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void doBefore() throws Exception {

	}

	/**
	 * 
	 * @throws Exception
	 */
	public abstract void doAction() throws Exception;

	/**
	 * 
	 * @throws Exception
	 */
	public void doAfter() throws Exception {

	}
}
