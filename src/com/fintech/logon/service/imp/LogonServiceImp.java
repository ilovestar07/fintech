/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统登录业务接口
 * 类   名  称: LogonServiceImp.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.logon.service.imp;

import java.util.List;

import com.fintech.menu.bean.MenuBean;
import com.fintech.user.bean.UserBean;
import com.fintech.user.bean.UserStatusBean;

public interface LogonServiceImp {
	
	public static final String VERSION = "@version 1.0.0.1";
	
	/**
	 * 查询用户状态信息
	 * 
	 * @param userStatusBean
	 * @return
	 * @throws Exception
	 */
	public UserStatusBean selectUserStatus(UserStatusBean userStatusBean) throws Exception;

	/**
	 * 获取用户信息
	 * 
	 * @param userBean
	 * @return
	 * @throws Exception
	 */
	public UserBean getUserBean(UserBean userBean) throws Exception;

	/**
	 * 获取系统菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<MenuBean> getSysMenu() throws Exception;

	/**
	 * 获取系统菜单的JSON串
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSysMenuByJson() throws Exception;

	/**
	 * 更新用户登录状态
	 * 
	 * @param userStatusBean
	 * @throws Exception
	 */
	public void updateUserStatus(UserStatusBean userStatusBean) throws Exception;
}
