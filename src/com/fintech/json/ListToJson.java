/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 查询列表JSON
 * 类   名  称: ListToJson.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2015-1-22
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.json;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fintech.base.bean.PageBean;

public class ListToJson {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 将Map的List转换成JSON
	 * 
	 * @param list
	 * @param pageSize
	 * @param pageNum
	 * @param totalRecord
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String listToJosnForSearch(List<?> list, PageBean pageBean) throws Exception {
		String jsonString = "";
		if (list != null && list.size() > 0) {
			jsonString += "{\"total\":" + pageBean.getTotalCount();
			jsonString += ",\"rows\":[";
			for (int i = 0; i < list.size(); i++) {
				Map<?, ?> map = (Map<?, ?>) list.get(i);
				jsonString += "{";
				Iterator<?> ite = map.entrySet().iterator();
				while (ite.hasNext()) {
					Map.Entry e = (Map.Entry) ite.next();
					if (e.getValue() != null) {
						jsonString += "\"" + (e.getKey()).toString().toLowerCase() + "\":\"" + e.getValue() + "\",";
					}
				}
				jsonString = jsonString.substring(0, jsonString.lastIndexOf(","));
				jsonString += "}";
				if (i != list.size() - 1) {
					jsonString += ",";
				}
			}
			jsonString += "]}";
		} else {
			jsonString += "{\"total\":" + 0 + ",\"rows\":[]}";
		}
		return jsonString;
	}

	/**
	 * 将实体对象的List转换成JSON
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public String objectToJsonForSearch(List<Object> list, PageBean pageBean) throws Exception {
		String jsonString = "";
		if (list != null && list.size() > 0) {
			jsonString += "{\"total\":" + pageBean.getTotalCount();
			jsonString += ",\"rows\":[";
			for (int i = 0; i < list.size(); i++) {
				jsonString += "{";
				jsonString += rowsJson(list.get(i));
				jsonString += "}";
				if (i != list.size() - 1) {
					jsonString += ",";
				}
			}
			jsonString += "]}";
		} else {
			jsonString += "{\"total\":" + 0 + ",\"rows\":[]}";
		}
		return jsonString;
	}

	/**
	 * 循环拼装实体的JSON
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	private String rowsJson(Object obj) throws Exception {
		String rowsJson = "";
		String fieldName = "";
		Object fieldValue = "";
		if (obj != null) {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				f.setAccessible(true);
				fieldName = f.getName().toLowerCase();
				fieldValue = f.get(obj);
				Class<?> cls = fields[i].getType();
				if (fieldValue != null) {
					if (cls.isPrimitive() || fieldValue instanceof String || fieldValue instanceof Double 
							|| fieldValue instanceof Integer || fieldValue instanceof Short || fieldValue instanceof Long 
							|| fieldValue instanceof Float || fieldValue instanceof Byte) {
						rowsJson += "\""
								+ obj.getClass().getName().substring(obj.getClass().getName().lastIndexOf(".") + 1).toLowerCase()
								+ "." + fieldName + "\":\"" + fieldValue.toString() + "\"";
						rowsJson += ",";
					} else {
						rowsJson += rowsJson(fieldValue);
					}
				}
			}
			if (rowsJson.lastIndexOf(",") == rowsJson.length() - 1) {
				rowsJson = rowsJson.substring(0, rowsJson.lastIndexOf(","));
			}
		}
		return rowsJson;
	}
}
