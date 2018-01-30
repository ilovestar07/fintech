/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 字符串工具类
 * 类   名  称: StringUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-4-25
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.common;

import com.fintech.util.encryption.PassEncryp;

public class StringUtil {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 文本加密
	 * 
	 * @param key
	 *            密钥
	 * @param str
	 *            密文
	 * @return
	 */
	public static String encrypt(String key, String str) throws Exception {
		return new PassEncryp(key).passEncrytor(str);
	}
}
