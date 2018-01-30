/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 菜单实体类
 * 类   名  称: MenuBean.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2015-1-22
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.menu.bean;

import java.io.Serializable;
import java.util.List;

public class MenuBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";
	
	private static final long serialVersionUID = 4004943866786830248L;
	
	private String menu_type;
	
	private String menu_code;
	
	private String menu_name;
	
	private String trans_code;
	
	private String subtrans_code;
	
	private String parent_code;
	
	private Double order_no;
	
	private String menu_icon;
	
	private String shortcut_key;
	
	private String menu_status;
	
	private String remark;
	
	private String bak_field1;
	
	private String bak_field2;

	private String bak_field3;
	
	private List<MenuBean> children;

	public String getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getTrans_code() {
		return trans_code;
	}

	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}

	public String getSubtrans_code() {
		return subtrans_code;
	}

	public void setSubtrans_code(String subtrans_code) {
		this.subtrans_code = subtrans_code;
	}

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public Double getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Double order_no) {
		this.order_no = order_no;
	}

	public String getMenu_icon() {
		return menu_icon;
	}

	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}

	public String getShortcut_key() {
		return shortcut_key;
	}

	public void setShortcut_key(String shortcut_key) {
		this.shortcut_key = shortcut_key;
	}

	public String getMenu_status() {
		return menu_status;
	}

	public void setMenu_status(String menu_status) {
		this.menu_status = menu_status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBak_field1() {
		return bak_field1;
	}

	public void setBak_field1(String bak_field1) {
		this.bak_field1 = bak_field1;
	}

	public String getBak_field2() {
		return bak_field2;
	}

	public void setBak_field2(String bak_field2) {
		this.bak_field2 = bak_field2;
	}

	public String getBak_field3() {
		return bak_field3;
	}

	public void setBak_field3(String bak_field3) {
		this.bak_field3 = bak_field3;
	}

	public List<MenuBean> getChildren() {
		return children;
	}

	public void setChildren(List<MenuBean> children) {
		this.children = children;
	}
}
