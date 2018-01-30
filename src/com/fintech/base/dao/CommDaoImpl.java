/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 通用数据库操作实现类
 * 类   名  称: CommDaoImpl.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-15
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.base.dao;

import com.fintech.util.common.BeanUtil;
import com.fintech.util.database.JdbcDaoSupport;

public class CommDaoImpl extends JdbcDaoSupport {

	public static final String VERSION = "@version 1.0.0.1";

	protected String tableName;

	/**
	 * 根据主键查询
	 * 
	 * @param info
	 *            查询条件
	 * @param bean
	 *            组装对象
	 * @return
	 * @throws Exception
	 */
	public Object selectByPK(Object info, Class<?> bean) throws Exception {
		String sql = BeanUtil.makeSelectSqlByPK(super.dataSource, tableName, info);
		return findSingle(sql, bean.newInstance());
	}

	/**
	 * 根据查询条件查询信息
	 * 
	 * @param info
	 *            查询条件
	 * @param bean
	 *            组装对象
	 * @return
	 * @throws Exception
	 */
	public Object selectAllByPK(Object info, Class<?> bean) throws Exception {
		String sql = BeanUtil.makeSelectSql(dataSource, tableName, info);
		return findMulti(sql, bean.newInstance());
	}

	/**
	 * 插入数据库
	 *
	 * @param info
	 *            插入对象
	 * @return
	 * @throws HsException
	 */
	public void insert(Object info) throws Exception {
		String sql = BeanUtil.makeInsertSql(dataSource, tableName, info);
		excuteSql(sql);
	}

	/**
	 * 根据主键修改
	 *
	 * @param info
	 *            修改对象
	 * @return
	 * @throws HsException
	 */
	public void updateByPK(Object info) throws Exception {
		String sql = BeanUtil.makeUpdateSql(dataSource, tableName, info);
		excuteSql(sql);
	}

	/**
	 * 根据主键删除
	 *
	 * @param info
	 *            删除对象
	 * @return
	 * @throws HsException
	 */
	public void deleteByPK(Object info) throws Exception {
		String sql = BeanUtil.makeDeleteSqlByPK(dataSource, tableName, info);
		excuteSql(sql);
	}

	/**
	 * 根据条件删除
	 *
	 * @param info
	 *            删除对象
	 * @return
	 * @throws HsException
	 */
	public void deleteByInfo(Object info) throws Exception {
		String sql = BeanUtil.makeDeleteSql(dataSource, tableName, info);
		excuteSql(sql);
	}
	
//	public void pageSelect(Map map,String pageSelectSql) throws Exception{
//		PageSelectUtil selectpage = (PageSelectUtil)HelpConfig.getBean(Dict.DB_DEF, "pageSelect");
//		selectpage.pageSelect(pageSelectSql, map);
//	}
}
