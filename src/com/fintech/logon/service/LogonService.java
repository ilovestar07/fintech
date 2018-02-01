/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统登录业务类
 * 类   名  称: LogonService.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.logon.service;

import java.util.List;

import com.fintech.json.MenuJson;
import com.fintech.logon.service.imp.LogonServiceImp;
import com.fintech.menu.bean.MenuBean;
import com.fintech.menu.dao.MenuDao;
import com.fintech.user.bean.UserBean;
import com.fintech.user.bean.UserStatusBean;
import com.fintech.user.dao.UserDao;
import com.fintech.user.dao.UserStatusDao;

public class LogonService implements LogonServiceImp {

	public static final String VERSION = "@version 1.0.0.1";

	private UserStatusDao userStatusDao;
	private UserDao userDao;
	private MenuDao menuDao;

	public UserStatusDao getUserStatusDao() {
		return userStatusDao;
	}

	public void setUserStatusDao(UserStatusDao userStatusDao) {
		this.userStatusDao = userStatusDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	/**
	 * 查询用户状态信息
	 */
	@Override
	public UserStatusBean selectUserStatus(UserStatusBean userStatusBean) throws Exception {
		return (UserStatusBean) userStatusDao.selectByPK(userStatusBean, UserStatusBean.class);
	}
	
	/**
	 * 更新用户登录状态
	 */
	@Override
	public void updateUserStatus(UserStatusBean userStatusBean) throws Exception {
		userStatusDao.updateByPK(userStatusBean);
	}

	/**
	 * 获取用户信息
	 */
	@Override
	public UserBean getUserBean(UserBean userBean) throws Exception {
		return (UserBean) userDao.selectByPK(userBean, UserBean.class);
	}

	/**
	 * 获取系统菜单
	 */
	@Override
	public List<MenuBean> getSysMenu() throws Exception {
		return menuDao.getAllMenus();
	}
	
	/**
	 * 根据用户编号获取有权限的系统菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<MenuBean> getSysMenuByRight(String user_code) throws Exception {
		return menuDao.getAllMenusByRight(user_code);
	}

	/**
	 * 获取系统菜单的JSON串
	 */
	@Override
	public String getSysMenuByJson() throws Exception {
		return MenuJson.listToJson(getSysMenu());
	}
}
