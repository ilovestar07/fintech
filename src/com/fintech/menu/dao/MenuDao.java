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
import com.fintech.util.constant.SysConstant;
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
	
	/**
	 * 根据用户编号和父菜单代码获取有权限的子菜单信息语句
	 * 
	 * @param user_code
	 * @param parent_code
	 * @return
	 * @throws Exception
	 */
	public String getSqlByRight(String user_code, String parent_code) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct t2.* from sys_right t1, sys_menu t2"
				+ " where t1.trans_code = t2.trans_code and t1.subtrans_code = t2. subtrans_code "
				+ "   and parent_code = '"+parent_code+"' and t1.right_type = '"+SysConstant.USER_RIGHT_USE+"' "
				+ "   and (exists (select 1 from sys_user_role a where a.role_code = t1.code "
				+ "   and t1.type = '"+SysConstant.RIGHT_OBJECT_ROLE+"' and a.user_code = '"+user_code+"') "
				+ "    or t1.code = '"+user_code+"' and t1.type = '"+SysConstant.RIGHT_OBJECT_USER+"')");
		return sb.toString();
	}
	
	/**
	 * 根据权限获取单个菜单信息
	 * 
	 * @param menuBean
	 * @param user_code
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public MenuBean selectSingleMenuByRight(MenuBean menuBean, String user_code) throws Exception {
		MenuBean bean = new MenuBean();
		MenuBean childBean = new MenuBean();
		String sql = BeanUtil.makeSelectSqlByPK(dataSource, TABLENAME, menuBean);
		bean = (MenuBean) this.findSingle(sql, menuBean);
		List<MenuBean> childrens = (List<MenuBean>) this.findMulti(this.getSqlByRight(user_code, bean.getMenu_code()), childBean);
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
	 * 根据用户编号获取有权限的菜单信息
	 * 
	 * @param user_code
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MenuBean> getAllMenusByRight(String user_code) throws Exception {
		List<MenuBean> resultList = new ArrayList<MenuBean>();
		MenuBean menuBean = new MenuBean();
		String sql = this.getSqlByRight(user_code, "/");
		List<MenuBean> list = (List<MenuBean>) this.findMulti(sql, menuBean);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				resultList.add(selectSingleMenuByRight(list.get(i), user_code));
			}
		}
		return resultList;
	}
	
}
