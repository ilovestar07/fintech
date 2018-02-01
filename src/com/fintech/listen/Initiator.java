/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 初始化
 * 类   名  称: Initiator.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-8-1
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.listen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fintech.base.bean.Parameter;
import com.fintech.base.bean.SubTransBean;
import com.fintech.base.bean.TransBean;
import com.fintech.log.Log;
import com.fintech.menu.bean.MenuBean;
import com.fintech.menu.dao.MenuDao;
import com.fintech.util.common.BeanUtil;

public class Initiator {

	public static final String VERSION = "@version 1.0.0.1";

	private static Initiator obj;

	private MenuDao menuDao = (MenuDao) BeanUtil.getBean("menuDao");

	public static HashMap<String, TransBean> transBeans = new HashMap<String, TransBean>();

	public static Parameter parameter = new Parameter();

	public static List<MenuBean> sysMenus = new ArrayList<MenuBean>();

	public static String sysMenusJson = "";

	private Initiator() {
		try {
			initTrans();
			initParameter();
//			initMenu();
		} catch (Exception e) {
			Log.getInstance().error(String.valueOf(this.getClass().hashCode()), "初始化失败！", e);
		}
	}

	/**
	 * 初始化交易
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void initTrans() throws Exception {
		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "交易信息初始化开始！");
		TransBean transBean = new TransBean();
		SubTransBean subTransBean = new SubTransBean();
		String transSql = "select * from sys_trans";
		String subTransSql = "";
		List<TransBean> transList = (List<TransBean>) menuDao.findMulti(transSql, transBean);
		if (transList != null && transList.size() > 0) {
			for (int i = 0; i < transList.size(); i++) {
				TransBean bean = transList.get(i);
				subTransSql = "select * from sys_subtrans where trans_code='" + bean.getTrans_code() + "'";
				List<SubTransBean> subTransList = (List<SubTransBean>) menuDao.findMulti(subTransSql, subTransBean);
				if (subTransList != null && subTransList.size() > 0) {
					bean.setSubTransCode(subTransList);
					transBeans.put(bean.getTrans_code(), bean);
				}
			}
		}
		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "交易信息初始化结束！");
	}

	/**
	 * 初始化系统参数
	 * 
	 * @throws Exception
	 */
	private void initParameter() throws Exception {
		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "系统参数初始化开始！");
		String parameterSql = "select * from sys_parameter";
		parameter = (Parameter) menuDao.findSingle(parameterSql, parameter);
		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "系统参数初始化结束！");
	}

//	/**
//	 * 初始化菜单
//	 * 
//	 * @throws Exception
//	 */
//	private void initMenu() throws Exception {
//		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "菜单初始化开始！");
//		sysMenus = menuDao.getAllMenus();
//		sysMenusJson = MenuJson.listToJson(sysMenus);
//		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "菜单初始化结束！");
//	}

	/**
	 * 系统初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Initiator init() throws Exception {
		if (obj == null) {
			obj = new Initiator();
		}
		return obj;
	}
}
