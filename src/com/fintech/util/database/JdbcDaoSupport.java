/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 数据库持久层
 * 类   名  称: JdbcDaoSupport.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-15
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.database;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fintech.log.Log;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcDaoSupport extends JdbcTemplate {

	public static final String VERSION = "@version 1.0.0.1";

	protected ComboPooledDataSource dataSource;

	private JdbcTemplate jt;

	public ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(ComboPooledDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 查询对象集合
	 * 
	 * @param sql
	 *            SQL语句
	 * @param obj
	 *            封装对象
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<?> findMulti(String sql, Object obj) throws Exception {
		List<?> list = null;
		try {
			jt = new JdbcTemplate(dataSource);
			list = (List<?>) jt.query(sql, new ObjectRowMapper((Class<Object>) obj.getClass()));
			Log.getInstance().info(String.valueOf(this.getClass().hashCode()), sql);
		} catch (Exception e) {
			Log.getInstance().error(String.valueOf(this.getClass().hashCode()), sql, e);
		}
		return list;
	}

	/**
	 * 查询单个对象
	 * 
	 * @param sql
	 *            SQL语句
	 * @param obj
	 *            封装对象
	 * @return
	 * @throws Exception
	 */
	public Object findSingle(String sql, Object obj) throws Exception {
		List<?> list = findMulti(sql, obj);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 执行语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @throws Exception
	 */
	public void excuteSql(String sql) throws Exception {
		try {
			jt = new JdbcTemplate(dataSource);
			jt.execute(sql);
			Log.getInstance().info(String.valueOf(this.getClass().hashCode()), sql);
		} catch (Exception e) {
			Log.getInstance().error(String.valueOf(this.getClass().hashCode()), sql, e);
		}
	}

	/**
	 * 批量执行语句
	 * 
	 * @param array
	 *            语句数组
	 * @throws Exception
	 */
	public void batchExcuteSql(String[] sql) throws Exception {
		try {
			jt = new JdbcTemplate(dataSource);
			jt.batchUpdate(sql);
			Log.getInstance().info(String.valueOf(this.getClass().hashCode()), sql);
		} catch (Exception e) {
			Log.getInstance().error(String.valueOf(this.getClass().hashCode()), sql, e);
		}
	}

	// public List find(String sql) throws Exception {
	// jt = new JdbcTemplate(dataSource);
	// return jt.queryForList(sql);
	// // return (List) jt.query(sql, new RowMapperResultSetExtractor(new
	// MapRowMapper()));
	// }
}
