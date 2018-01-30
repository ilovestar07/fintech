/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统用户管理业务接口
 * 类   名  称: UserServiceImp.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.user.service.imp;

import java.util.List;

import com.fintech.base.bean.PageBean;
import com.fintech.user.bean.UserBean;

public interface UserServiceImp {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 查询用户信息
	 * 
	 * @param userBean
	 * @return
	 * @throws Exception
	 */
	public List<Object> searchUsers(UserBean userBean, PageBean pageBean) throws Exception;

	/**
	 * 查询用户信息
	 * 
	 * @param userBean
	 * @return
	 * @throws Exception
	 */
	public UserBean searchUser(UserBean userBean) throws Exception;

	/**
	 * 新增用户信息
	 * 
	 * @param userBean
	 * @throws Exception
	 */
	public void addUser(UserBean userBean) throws Exception;

	/**
	 * 删除用户信息
	 * 
	 * @param userBean
	 * @throws Exception
	 */
	public void delUser(UserBean userBean) throws Exception;
}
