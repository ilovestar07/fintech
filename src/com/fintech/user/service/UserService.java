/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统用户管理业务类
 * 类   名  称: UserService.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.user.service;

import java.util.ArrayList;
import java.util.List;

import com.fintech.base.bean.PageBean;
import com.fintech.user.bean.UserBean;
import com.fintech.user.bean.UserStatusBean;
import com.fintech.user.dao.UserDao;
import com.fintech.user.dao.UserStatusDao;
import com.fintech.user.service.imp.UserServiceImp;

public class UserService implements UserServiceImp {

	private UserDao userDao;
	private UserStatusDao userStatusDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserStatusDao getUserStatusDao() {
		return userStatusDao;
	}

	public void setUserStatusDao(UserStatusDao userStatusDao) {
		this.userStatusDao = userStatusDao;
	}

	/**
	 * 查所有用户信息
	 */
	@Override
	public List<Object> searchUsers(UserBean userBean, PageBean pageBean) throws Exception {
		List<?> list = userDao.selectAll(userBean, pageBean);
		List<Object> reList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				UserBean bean = (UserBean) list.get(i);
				UserStatusBean userStatusBean = new UserStatusBean();
				userStatusBean.setUser_code(bean.getUser_code());
				userStatusBean = (UserStatusBean) userStatusDao.selectByPK(userStatusBean, UserStatusBean.class);
				bean.setUserStatusBean(userStatusBean);
				reList.add(bean);
			}
		}
		return reList;
	}

	/**
	 * 查询用户信息
	 */
	@Override
	public UserBean searchUser(UserBean userBean) throws Exception {
		return (UserBean) userDao.selectByPK(userBean, UserBean.class);
	}

	/**
	 * 新增用户信息
	 */
	@Override
	public void addUser(UserBean userBean) throws Exception {
		userDao.insert(userBean);
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public void delUser(UserBean userBean) throws Exception {
		userDao.deleteByPK(userBean);
	}
}
