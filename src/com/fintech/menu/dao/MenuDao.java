/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 菜单数据库交互类
 * 类   名  称: MenuBean.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2015-1-22
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.menu.dao;

import java.util.ArrayList;
import java.util.List;

import com.fintech.base.dao.CommDaoImpl;
import com.fintech.menu.bean.MenuBean;
import com.fintech.util.common.BeanUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MenuDao extends CommDaoImpl {

	public static final String VERSION = "@version 1.0.0.1";

	private static final String TABLENAME = "sys_menu";

	public MenuDao() {
		super.tableName = TABLENAME;
	}

	public MenuDao(ComboPooledDataSource dataSource) {
		super.dataSource = dataSource;
	}

	/**
	 * 获取菜单信息
	 * 
	 * @param menuBean
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public MenuBean selectByPK(MenuBean menuBean) throws Exception {
		MenuBean bean = new MenuBean();
		String sql = BeanUtil.makeSelectSqlByPK(dataSource, TABLENAME, menuBean);
		bean = (MenuBean) this.findSingle(sql, menuBean);
		MenuBean children = new MenuBean();
		children.setParent_code(bean.getMenu_code());
		List<MenuBean> childrens = (List<MenuBean>) this.selectAllByPK(children, MenuBean.class);
		List<MenuBean> c = new ArrayList<MenuBean>();
		if (childrens != null && childrens.size() > 0) {
			for (int i = 0; i < childrens.size(); i++) {
				MenuBean mb = selectByPK(childrens.get(i));
				c.add(mb);
			}
		}
		if (c != null && c.size() > 0) {
			bean.setChildren(c);
		}
		return bean;
	}

	/**
	 * 获取所有菜单信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MenuBean> getAllMenus() throws Exception {
		List<MenuBean> resultList = new ArrayList<MenuBean>();
		MenuBean topMenu = new MenuBean();
		topMenu.setParent_code("/");
		List<MenuBean> list = (List<MenuBean>) this.selectAllByPK(topMenu, MenuBean.class);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				resultList.add(selectByPK(list.get(i)));
			}
		}
		return resultList;
	}

}
