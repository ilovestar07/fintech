/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统登录业务类
 * 类   名  称: LogonAction.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.logon.action;

import java.io.IOException;
import java.util.List;

import com.fintech.base.action.BaseAction;
import com.fintech.json.MenuJson;
import com.fintech.logon.service.imp.LogonServiceImp;
import com.fintech.menu.bean.MenuBean;
import com.fintech.user.bean.UserBean;
import com.fintech.user.bean.UserStatusBean;
import com.fintech.util.common.StringUtil;
import com.fintech.util.constant.SysConstant;

public class LogonAction extends BaseAction {

	public static final String VERSION = "@version 1.0.0.1";

	private LogonServiceImp logonServiceImp;

	public LogonServiceImp getLogonServiceImp() {
		return logonServiceImp;
	}

	public void setLogonServiceImp(LogonServiceImp logonServiceImp) {
		this.logonServiceImp = logonServiceImp;
	}

	@Override
	public void doAction() throws Exception {
	}

	/**
	 * 校验返回信息
	 * 
	 * @param msg
	 * @param code
	 * @throws Exception
	 */
	private void res(String msg, String flag) throws Exception {
		try {
			response.setContentType("text/xml; charset=gb2312");
			response.getWriter().println("<?xml version='1.0' encoding='gb2312' standalone='yes'?>");
			response.getWriter().println("<result>");
			response.getWriter().println("<msg>" + msg + "</msg>");
			response.getWriter().println("<flag>" + flag + "</flag>");
			response.getWriter().println("</result>");
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			throw new Exception("登录转向出错");
		}

	}

	/**
	 * 用户密码校验
	 * 
	 * @throws Exception
	 */
	public void chk() throws Exception {
		String user_code = request.getParameter("user_code");
		String password = request.getParameter("password");
		UserStatusBean userStatusBean = new UserStatusBean();
		userStatusBean.setUser_code(user_code);
		userStatusBean = logonServiceImp.selectUserStatus(userStatusBean);
		if (userStatusBean != null) {
			if (StringUtil.encrypt(user_code, password).equals(
					userStatusBean.getPassword())) {
				if (SysConstant.LOGON_STATUS_ONLINE.equals(userStatusBean.getLogon_status())) {
					res("用户已在其他地方登录!", SysConstant.YESORNO_NO);
				} else {
					UserStatusBean userStatusTemp = new UserStatusBean();
					userStatusTemp.setUser_code(user_code);
					userStatusTemp.setLogon_status(SysConstant.LOGON_STATUS_ONLINE);
					userStatusTemp.setLogon_num(0.00);
//					logonServiceImp.updateUserStatus(userStatusTemp);
					List<MenuBean> menuBeans = logonServiceImp.getSysMenuByRight(user_code);
					request.getSession().setAttribute(SysConstant.SYS_MENU_TREE, MenuJson.listToJson(menuBeans));
					res("用户登录成功!", SysConstant.YESORNO_YES);
				}
			} else {
				Double num = userStatusBean.getLogon_num() + 1;
				UserStatusBean userStatusTemp = new UserStatusBean();
				userStatusTemp.setUser_code(user_code);
				userStatusTemp.setLogon_num(num);
				logonServiceImp.updateUserStatus(userStatusTemp);
				res("用户名或密码错误!", SysConstant.YESORNO_NO);
			}
		} else {
			res("用户名或密码错误!", SysConstant.YESORNO_NO);
		}
	}

	/**
	 * 登录
	 * 
	 * @throws Exception
	 */
	public void logon() throws Exception {
		String user_code = request.getParameter("user_code");
		UserBean userBean = new UserBean();
		userBean.setUser_code(user_code);
		userBean = logonServiceImp.getUserBean(userBean);
		request.getSession().setAttribute(SysConstant.SYS_LOGON_USER, userBean);
	}
}
