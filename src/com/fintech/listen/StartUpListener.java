/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 系统启动监听
 * 类   名  称: StartUpListener.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2012-4-25
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.listen;

import javax.servlet.*;
import javax.servlet.http.*;

import com.fintech.log.Log;

public class StartUpListener extends HttpServlet implements ServletContextListener, HttpSessionListener {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 347911661699583015L;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			Initiator.init();
		} catch (Exception e) {
			Log.getInstance().error(String.valueOf(this.getClass().hashCode()), "初始化失败！", e);
		}
		Log.getInstance().info(String.valueOf(this.getClass().hashCode()), "初始化成功！");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		// TODO Auto-generated method stub
		// HttpSession session = httpSessionEvent.getSession();
		// UserInfo userInfo = (UserInfo)
		// session.getAttribute(Constant.USERINFO);
		// try{
		// String
		// sql="update t_user set status='1' where user_id='"+userInfo.getUserId()+"'";
		// JdbcBaseDao dao=DataBaseFactory.getJdbcBseDao();
		// dao.exeSql(sql);
		// } catch (Exception e) {
		// Log.getInstance().error(String.valueOf(serialVersionUID),
		// "用户:"+userInfo.getUserName()+" session 销毁失败",e);
		// }
		// session.removeAttribute(Constant.USERINFO);
		// Log.getInstance().info(String.valueOf(serialVersionUID),
		// "用户:"+userInfo.getUserName()+" session 销毁成功");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		// TODO Auto-generated method stub

	}
}
