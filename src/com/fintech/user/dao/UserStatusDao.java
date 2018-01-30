/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 用户状态信息数据库交互类
 * 类   名  称: UserStatusDao.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.user.dao;

import com.fintech.base.dao.CommDaoImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserStatusDao extends CommDaoImpl {

	public static final String VERSION = "@version 1.0.0.1";

	private static final String TABLENAME = "sys_user_status";

	public UserStatusDao() {
		super.tableName = TABLENAME;
	}

	public UserStatusDao(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}
}
