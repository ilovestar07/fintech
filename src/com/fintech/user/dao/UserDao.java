/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 用户信息数据库交互类
 * 类   名  称: UserDao.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.user.dao;

import java.util.List;

import com.fintech.base.bean.PageBean;
import com.fintech.base.dao.CommDaoImpl;
import com.fintech.user.bean.UserBean;
import com.fintech.util.common.BeanUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDao extends CommDaoImpl {

	public static final String VERSION = "@version 1.0.0.1";

	private static final String TABLENAME = "sys_users";

	public UserDao() {
		super.tableName = TABLENAME;
	}

	public UserDao(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 分页获取所有用户信息
	 * 
	 * @param userBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAll(UserBean userBean, PageBean pageBean) throws Exception {
		UserBean bean = new UserBean();
		String sql = BeanUtil.makeSelectSql(dataSource, TABLENAME, userBean);
		sql = "select * from (select page_sql.*,rownum rn from (" + sql + ") page_sql) where rn >" + pageBean.getStartNum() + " and rn <=" + pageBean.getEndNum();
		return this.findMulti(sql, bean);
	}
}
