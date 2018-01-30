/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 数据库数据字典
 * 类   名  称: DataBaseDict.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-4-25
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.constant;

public class DataBaseDict {

	public static final String VERSION = "@version 1.0.0.1";

	private static DataBaseDict instance = null;

	private DataBaseDict() {
		init();
	}

	/**
	 * 初始化数据库数据字典类
	 */
	private void init() {

	}

	/**
	 * 获取数据库数据字典实例
	 * 
	 * @return
	 */
	public static DataBaseDict getInstance() {
		if (instance == null) {
			instance = new DataBaseDict();
		}
		return instance;
	}

	/**
	 * 刷新数据库数据字典实例
	 */
	public static void refresh() {
		instance = new DataBaseDict();
	}
}
