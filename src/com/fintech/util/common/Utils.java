/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 通用工具类
 * 类   名  称: Utils.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-4-25
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.util.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.fintech.log.Log;

public class Utils {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 获取服务器ip
	 * 
	 * @return 服务器ip
	 */
	public static String getLocalIP() {
		String ip = "";
		try {
			byte[] ch = InetAddress.getLocalHost().getAddress();
			if (ch != null && ch.length > 0) {
				int temp;
				for (int i = 0; i < ch.length; i++) {
					temp = Integer.parseInt(String.valueOf(ch[i]));
					if (temp < 0) {
						temp += 256;
					}
					ip += String.valueOf(temp);
					if (i != ch.length - 1) {
						ip += ".";
					}
				}
			} else {
				ip = "000.000.0.0";
			}
		} catch (UnknownHostException e) {
			Log.getInstance().error("000.000.0.0", "获取服务器ip失败！", e);
		}
		return ip;
	}
}
