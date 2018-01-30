/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 菜单JSON
 * 类   名  称: MenuJson.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2015-1-22
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.json;

import java.util.List;

import com.fintech.menu.bean.MenuBean;

public class MenuJson {
	
	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 将菜单列表转换成JSON格式
	 * 
	 * @param menus
	 * @return
	 * @throws Exception
	 */
	public static String listToJson(List<MenuBean> menus) throws Exception {
		String jsonString = "";
		MenuBean menuBean;
		if (menus != null && menus.size() > 0) {
			jsonString += "[";
			for (int i = 0; i < menus.size(); i++) {
				menuBean = menus.get(i);
				jsonString += "{id:'" + menuBean.getMenu_code() + "'";
				jsonString += ",text:'" + menuBean.getMenu_name() + "'";
				jsonString += ",iconCls:'" + menuBean.getMenu_icon() + "'";
				jsonString += ",url:'" + menuBean.getTrans_code() + ".do?subTransCode="+menuBean.getSubtrans_code()+"'";
				if (menuBean.getChildren() != null && menuBean.getChildren().size() > 0) {
					jsonString += ",state:'closed'";
					jsonString += ",children:" + listToJson(menuBean.getChildren());
				}
				jsonString += "}";
				if (i != menus.size()-1) {
					jsonString += ",";
				}
			}
			jsonString += "]";
		}
		return jsonString;
	}
}
