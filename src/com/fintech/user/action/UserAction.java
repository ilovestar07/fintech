/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统用户管理业务类
 * 类   名  称: UserAction.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.user.action;

import java.util.List;

import com.fintech.base.action.BaseAction;
import com.fintech.base.bean.PageBean;
import com.fintech.json.ListToJson;
import com.fintech.user.bean.UserBean;
import com.fintech.user.service.imp.UserServiceImp;
import com.fintech.util.common.BeanUtil;

public class UserAction extends BaseAction {

	public static final String VERSION = "@version 1.0.0.1";

	private UserServiceImp userServiceImp;

	public UserServiceImp getUserServiceImp() {
		return userServiceImp;
	}

	public void setUserServiceImp(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	@Override
	public void doAction() throws Exception {
	}

	/**
	 * 查询用户信息
	 * 
	 * @throws Exception
	 */
	public void search() throws Exception {
		UserBean userBean = new UserBean();
		BeanUtil.setBeanProperty(userBean, super.sysReqMap);
		PageBean pageBean = new PageBean();
		BeanUtil.setBeanProperty(pageBean, super.sysReqMap);
		pageBean.setTotalCount(12);
		List<Object> list = userServiceImp.searchUsers(userBean, pageBean);
		response.getWriter().write(new ListToJson().objectToJsonForSearch(list, pageBean));
		response.getWriter().flush();
	}

	/**
	 * 新增用户信息
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		UserBean userBean = new UserBean();
		BeanUtil.setBeanProperty(userBean, super.sysReqMap);
		userServiceImp.addUser(userBean);
		response.getWriter().write(SUCCESS);
		response.getWriter().flush();
	}

	/**
	 * 删除用户信息
	 * 
	 * @throws Exception
	 */
	public void del() throws Exception {
		UserBean userBean = new UserBean();
		BeanUtil.setBeanProperty(userBean, super.sysReqMap);
		userServiceImp.delUser(userBean);
		response.getWriter().write(SUCCESS);
		response.getWriter().flush();
	}
}