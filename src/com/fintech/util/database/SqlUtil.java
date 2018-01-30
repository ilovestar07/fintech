/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: SQL工具类
 * 类   名  称: SqlUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.database;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.fintech.util.common.BeanUtil;
import com.fintech.util.constant.SysConstant;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SqlUtil {

	public static final String VERSION = "@version 1.0.0.1";

	private String type = SysConstant.TYPE_SELECT;
	private String tableName = "";
	private String values = "";
	private String columns = "*";
	private boolean isExistWhere = false;
	private String condition = "";
	private String setColumns = "";

	/**
	 * 初始化
	 * 
	 * @param tn
	 *            表名
	 * @param type
	 *            操作类型(SELECT,INSERT,UPDATE,DELETE)
	 */
	public SqlUtil(String tn, String type) {
		this.tableName = tn;
		this.type = type;
	}

	/**
	 * 设置插入字段和值
	 * 
	 * @param column
	 * @param value
	 */
	public void setInsert(String column, String value) {
		if (column != null && !"".equals(column) && value != null && !"".equals(value)) {
			setColumn(column);
			setValue(value);
		}
	}

	/**
	 * 设置字段
	 * 
	 * @param column
	 */
	public void setColumn(String column) {
		if ("*".equals(columns)) {
			columns = column;
		} else {
			columns += "," + column;
		}
	}

	/**
	 * 设置值
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		if ("".equals(values)) {
			values += "'" + value + "'";
		} else {
			values += ",'" + value + "'";
		}
	}

	/**
	 * 查询条件的拼装
	 * 
	 * @param column
	 *            字段
	 * @param obj
	 *            对象
	 */
	public void setWhere(String column, Object obj) {
		setWhere(column, obj, "=");
	}

	/**
	 * 查询条件的拼装
	 * 
	 * @param column
	 *            字段名
	 * @param obj
	 *            值
	 * @param mark
	 *            条件符号，缺省为空
	 */
	public void setWhere(String column, Object obj, String mark) {
		if (null != obj) {
			if (!isExistWhere) {
				condition += " where ";
				isExistWhere = true;
			} else {
				condition += " and ";
			}
			condition += column + mark;
			if (obj instanceof Integer) {
				condition += Integer.valueOf(obj.toString().trim());
			} else if (obj instanceof Double) {
				condition += Double.valueOf(obj.toString().trim());
			} else if (obj instanceof BigDecimal) {
				condition += new BigDecimal(Double.valueOf(obj.toString().trim()));
			} else if (obj instanceof Date) {
				condition += "'" + Date.valueOf(obj.toString().trim()) + "'";
			} else {
				condition += "'" + obj.toString().trim() + "'";
			}
		}
	}

	/**
	 * 更新条件的拼装
	 * 
	 * @param column
	 *            字段名
	 * @param obj
	 *            值
	 */
	public void setUpdate(String column, Object obj) {
		if (!"".equals(setColumns)) {
			setColumns += ", ";
		}
		setColumns += column + "=";
		if (obj instanceof Integer) {
			setColumns += Integer.valueOf(obj.toString().trim());
		} else if (obj instanceof Double) {
			setColumns += Double.valueOf(obj.toString().trim());
		} else if (obj instanceof BigDecimal) {
			setColumns += new BigDecimal(Double.valueOf(obj.toString().trim()));
		} else if (obj instanceof Date) {
			setColumns += "'" + Date.valueOf(obj.toString().trim()) + "'";
		} else {
			setColumns += "'" + obj.toString().trim() + "'";
		}
	}

	/**
	 * 查询字段的拼装
	 * 
	 * @param dataSource
	 * @param beanObj
	 * @param tableName
	 */
	public void setSelectedCol(ComboPooledDataSource dataSource, Object beanObj, String tableName) throws Exception {
		List<String> columnList = BeanUtil.getTableColumnList(dataSource, tableName);
		try {
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();
			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					for (int j = 0; j < columnList.size(); j++) {
						if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
							setColumn(pd.getName().toLowerCase());
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * SQL的组成
	 */
	public String toString() {
		String sql = "";
		if (SysConstant.TYPE_INSERT.equals(type)) {
			sql = type + " into " + tableName + " (" + columns + ") values (" + values + ")";
		} else if (SysConstant.TYPE_SELECT.equals(type)) {
			sql = type + " " + columns + " from " + tableName + " " + condition;
		} else if (SysConstant.TYPE_DELETE.equals(type)) {
			sql = type + " from " + tableName + " " + condition;
		} else if (SysConstant.TYPE_UPDATE.equals(type)) {
			sql = type + " " + tableName + " set " + setColumns + " " + condition;
		}
		return sql;
	}
}
