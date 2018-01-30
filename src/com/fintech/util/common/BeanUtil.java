/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 实体工具类
 * 类   名  称: BeanUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-11
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fintech.util.constant.SysConstant;
import com.fintech.util.database.SqlUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BeanUtil {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 拼装查询语句
	 * 
	 * @param dataSource
	 * @param tableName
	 * @param beanObj
	 * @return
	 * @throws Exception
	 */
	public static String makeSelectSql(ComboPooledDataSource dataSource, String tableName, Object beanObj) throws Exception {
		SqlUtil sql = new SqlUtil(tableName, SysConstant.TYPE_SELECT);
		sql.setSelectedCol(dataSource, beanObj, tableName);
		List<String> columnList = getTableColumnList(dataSource, tableName);
		try {
			Method method = null;
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();

			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnList.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
								sql.setWhere(columnList.get(j), obj.toString().trim());
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	/**
	 * 拼装删除语句(根据主键）
	 * 
	 * @param dataSource
	 * @param tableName
	 * @param beanObj
	 * @return
	 * @throws Exception
	 */
	public static String makeSelectSqlByPK(ComboPooledDataSource dataSource, String tableName, Object beanObj) throws Exception {
		SqlUtil sql = new SqlUtil(tableName, SysConstant.TYPE_SELECT);
		sql.setSelectedCol(dataSource, beanObj, tableName);
		List<String> columnList = getTableColumnListPK(dataSource, tableName);
		try {
			Method method = null;
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();

			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnList.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
								sql.setWhere(columnList.get(j), obj.toString().trim());
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	/**
	 * 拼装删除语句
	 * 
	 * @param dataSource
	 * @param tableName
	 * @param beanObj
	 * @return
	 * @throws Exception
	 */
	public static String makeDeleteSql(ComboPooledDataSource dataSource, String tableName, Object beanObj) throws Exception {
		SqlUtil sql = new SqlUtil(tableName, SysConstant.TYPE_DELETE);
		List<String> columnList = getTableColumnList(dataSource, tableName);
		try {
			Method method = null;
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();
			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnList.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
								sql.setWhere(columnList.get(j), obj.toString().trim());
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	/**
	 * 拼装删除语句(根据主键）
	 * 
	 * @param dataSource
	 * @param tableName
	 * @param beanObj
	 * @return
	 * @throws Exception
	 */
	public static String makeDeleteSqlByPK(ComboPooledDataSource dataSource, String tableName, Object beanObj) throws Exception {
		SqlUtil sql = new SqlUtil(tableName, SysConstant.TYPE_DELETE);
		List<String> columnList = getTableColumnListPK(dataSource, tableName);
		try {
			Method method = null;
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();
			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnList.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
								sql.setWhere(columnList.get(j), obj.toString().trim());
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	/**
	 * 拼装插入语句
	 * 
	 * @param dataSource
	 * @param tableName
	 * @param beanObj
	 * @return
	 * @throws Exception
	 */
	public static String makeInsertSql(ComboPooledDataSource dataSource, String tableName, Object beanObj) throws Exception {
		SqlUtil sql = new SqlUtil(tableName, SysConstant.TYPE_INSERT);
		List<String> columnList = getTableColumnList(dataSource, tableName);
		try {
			Method method = null;
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();
			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnList.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
								sql.setInsert(columnList.get(j), obj.toString().trim());
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	/**
	 * 拼装更新语句
	 * 
	 * @param dataSource
	 * @param tableName
	 * @param beanObj
	 * @return
	 * @throws Exception
	 */
	public static String makeUpdateSql(ComboPooledDataSource dataSource, String tableName, Object beanObj) throws Exception {
		SqlUtil sql = new SqlUtil(tableName, SysConstant.TYPE_UPDATE);
		List<String> columnList = getTableColumnList(dataSource, tableName);
		List<String> columnListPK = getTableColumnListPK(dataSource, tableName);
		try {
			Method method = null;
			PropertyDescriptor[] pdArray = Introspector.getBeanInfo(beanObj.getClass()).getPropertyDescriptors();
			if (pdArray != null && pdArray.length > 0) {
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnList.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnList.get(j).toLowerCase())) {
								sql.setUpdate(columnList.get(j), obj.toString().trim());
							}
						}
					}
				}
				for (int i = 0; i < pdArray.length; i++) {
					PropertyDescriptor pd = pdArray[i];
					method = pd.getReadMethod();
					Object obj = method.invoke(beanObj, new Object[0]);
					if (obj != null) {
						for (int j = 0; j < columnListPK.size(); j++) {
							if (pd.getName().toLowerCase().equals(columnListPK.get(j).toLowerCase())) {
								sql.setWhere(columnListPK.get(j), obj.toString().trim());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql.toString();
	}

	/**
	 * 获取数据库表字段
	 * 
	 * @param dataSource
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public static List<String> getTableColumnList(ComboPooledDataSource dataSource, String tableName) throws Exception {
		HashMap<String, List<String>> tableColumnMap = new HashMap<String, List<String>>();
		List<String> columnList = null;
		if (tableColumnMap.containsKey(tableName)) {
			columnList = tableColumnMap.get(tableName);
		} else {
			columnList = getTableNameColumn(dataSource, tableName);
			tableColumnMap.put(tableName, columnList);
		}
		return columnList;
	}

	/**
	 * 获取数据库表主键字段
	 * 
	 * @param dataSource
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public static List<String> getTableColumnListPK(ComboPooledDataSource dataSource, String tableName) throws Exception {
		HashMap<String, List<String>> tableColumnMap = new HashMap<String, List<String>>();
		List<String> columnList = null;
		if (tableColumnMap.containsKey(tableName)) {
			columnList = tableColumnMap.get(tableName);
		} else {
			columnList = getTableNameColumnPK(dataSource, tableName);
			tableColumnMap.put(tableName, columnList);
		}
		return columnList;
	}

	/**
	 * 数据库字段获得
	 * 
	 * @param tableName
	 *            表名
	 * @return 字段名 list
	 * @throws Exception
	 */
	private static List<String> getTableNameColumn(ComboPooledDataSource dataSource, String tableName) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = dataSource.getConnection();
			rs = conn.createStatement().executeQuery("select * from " + tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				list.add(rsmd.getColumnName(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 数据库主键字段获得
	 * 
	 * @param tableName
	 *            表名
	 * @return 字段名 list
	 * @throws Exception
	 */
	private static List<String> getTableNameColumnPK(ComboPooledDataSource dataSource, String tableName) throws Exception {
		Connection conn = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = dataSource.getConnection();
			rs = conn.getMetaData().getPrimaryKeys(null, null, tableName.toUpperCase());
			while (rs.next()) {
				list.add(rs.getString("COLUMN_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	/**
	 * 设置BEAN对象属性
	 * 
	 * @param obj
	 * @param map
	 */
	public static void setBeanProperty(Object obj, Map<?, ?> map) {
		Iterator<?> ite = map.keySet().iterator();
		String key;
		Object value;
		if (obj != null) {
			while (ite.hasNext()) {
				key = ((String) ite.next());
				value = map.get(key);
				if (value != null && !"".equals(value)) {
					setBeanProperty(obj, key, value);
				}
			}
		}
	}

	/**
	 * 根据key,value设置值
	 * 
	 * @param obj
	 * @param s
	 * @param value
	 */
	public static void setBeanProperty(Object obj, String s, Object value) {
		Method method = null;
		try {
			BeanInfo beaninfo = Introspector.getBeanInfo(obj.getClass());
			if (beaninfo != null) {
				PropertyDescriptor apropertydescriptor[] = beaninfo.getPropertyDescriptors();
				MethodDescriptor pro[] = beaninfo.getMethodDescriptors();
				pro[0].getName();
				for (int i = 0; i < apropertydescriptor.length; i++) {
					PropertyDescriptor propertydescriptor = apropertydescriptor[i];
					if (!propertydescriptor.getName().equalsIgnoreCase(s)) {
						continue;
					}
					method = propertydescriptor.getWriteMethod();
					break;
				}
			}
			Class<?> cls = null;
			if (method != null) {
				cls = method.getParameterTypes()[method.getParameterTypes().length - 1];
				if (cls.getName().equals("long") || cls.getName().equals("java.lang.Long")) {
					if (value == null || "".equals(value)) {
						value = "0";
					}
					value = Long.valueOf((String) value);
				} else if (cls.getName().equals("double") || cls.getName().equals("java.lang.Double")) {
					if (value == null || "".equals(value)) {
						value = "0";
					}
					value = Double.valueOf((String) value);
				} else if (cls.getName().equals("int") || cls.getName().equals("java.lang.Integer")) {
					if (value == null || "".equals(value)) {
						value = "0";
					}
					value = Integer.valueOf((String) value);
				}
				method.invoke(obj, new Object[] { value });
			}
		} catch (Exception exception) {
			System.err.println("in BeanUtil.getBeanProperty(): Exception " + exception);
		}
	}

	/**
	 * 获取实体对象
	 * 
	 * @param beanName
	 *            实体名称
	 * @return
	 */
	public static Object getBean(String beanName) {
		BeanFactory factory = new ClassPathXmlApplicationContext(SysConstant.XMLNAME);
		return factory.getBean(beanName);
	}

	/**
	 * 获取Bean类属性
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static PropertyDescriptor[] getPropertyDescriptors(Class<Object> clazz) throws Exception {
		return Introspector.getBeanInfo(clazz).getPropertyDescriptors();
	}

	/**
	 * 获取Set方法
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public static Method getWriteMethod(PropertyDescriptor pd) throws Exception {
		return pd.getWriteMethod();
	}
}
