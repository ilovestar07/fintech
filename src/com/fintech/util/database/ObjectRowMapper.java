/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: RowMapper单实体类的实现
 * 类   名  称: DaoRowMapperSingle.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.database;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSetMetaData;

import com.fintech.util.common.BeanUtil;
import com.fintech.util.constant.SysConstant;

public class ObjectRowMapper implements RowMapper {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 实体类
	 */
	private Class<Object> classObj;

	/**
	 * 单体实体类设定
	 * 
	 * @param classObj
	 */
	public ObjectRowMapper(Class<Object> classObj) {
		this.classObj = classObj;
	}

	/**
	 * 实现实体类的设定
	 * 
	 * @param rs
	 * @param index
	 * @return
	 * @throws SQLException
	 */
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		synchronized (rs) {
			Object obj = null;
			try {
				if (classObj != null) {
					obj = classObj.newInstance();
				}
				ResultSetWrappingSqlRowSetMetaData metaData = new ResultSetWrappingSqlRowSetMetaData(rs.getMetaData());
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String name = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					String type = metaData.getColumnTypeName(i);

					if (type.toUpperCase().equals(SysConstant.TYPE_CHAR) || type.toUpperCase().equals(SysConstant.TYPE_VARCHAR2)) {
						value = value == null ? null : value.toString().trim();
					} else if (type.toUpperCase().equals(SysConstant.TYPE_INTEGER)) {
						value = value == null ? 0 : Integer.parseInt(value.toString().trim());
					} else if (type.toUpperCase().equals(SysConstant.TYPE_NUMBER)) {
						value = value == null ? 0.00 :Double.valueOf(value.toString().trim());
					} else if (type.toUpperCase().equals(SysConstant.TYPE_DATE)) {
						value = value == null ? null : Date.valueOf(value.toString().trim());
					}

					PropertyDescriptor[] array = BeanUtil.getPropertyDescriptors(classObj);
					for (int j = 0; j < array.length; j++) {
						Method method = BeanUtil.getWriteMethod(array[j]);
						if (method != null) {
							if (name.toUpperCase().equals(array[j].getName().toUpperCase())) {
								method.invoke(obj, value);
							}
						}
					}
				}
			} catch (Exception e) {
				throw new SQLException(e.getLocalizedMessage());
			}
			return obj;
		}
	}
}
