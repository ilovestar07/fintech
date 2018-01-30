/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: Servlet控制类
 * 类   名  称: MainServlet.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2013-7-13
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fintech.base.action.BaseAction;
import com.fintech.base.bean.SubTransBean;
import com.fintech.base.bean.TransBean;
import com.fintech.listen.Initiator;
import com.fintech.log.Log;
import com.fintech.util.common.BeanUtil;
import com.fintech.util.constant.SysConstant;

public class MainServlet extends HttpServlet {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = 5637796610608617336L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseAction baseAction = null;
		String transCode = "";
		String subTransCode = SysConstant.DEF_SUB_CODE;

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			response.setDateHeader("Expires", 0);

			String fullURL = request.getRequestURI();
			transCode = fullURL.substring(fullURL.lastIndexOf("/") + 1, fullURL.length());
			if (transCode.indexOf(SysConstant.ACTION_SUFFIX) > 0) {
				transCode = transCode.substring(0, transCode.length() - 3);
			}
			subTransCode = request.getParameter("subTransCode");
			if (subTransCode == null || "".equals(subTransCode)) {
				subTransCode = SysConstant.DEF_SUB_CODE;
			}
			TransBean transBean = Initiator.transBeans.get(transCode);
			Map<String, Object> sysReqMap = formatMap(request.getParameterMap());
			if (transBean == null) {
				Log.getInstance().error("<主交易：" + transCode + ">", "主交易不存在！");
				return;
			}
			try {
				baseAction = (BaseAction) BeanUtil.getBean(transBean.getControl_class());
				baseAction.init(getServletConfig(), request, response, sysReqMap);
			} catch (Exception e1) {
				Log.getInstance().error("<主交易：" + transCode + ">", "控制类不存在！", e1);
			}
			Log.getInstance().info("<主交易：" + transCode + ">|<子交易：" + subTransCode + ">", "开始！");
			SubTransBean subTransBean = transBean.getSubTransCode(subTransCode);
			if (subTransBean == null) {
				Log.getInstance().error("<主交易：" + transCode + ">|<子交易：" + subTransCode + ">", "子交易不存在！");
				return;
			}
			baseAction.doBefore();
			Method m = baseAction.getClass().getDeclaredMethod(subTransCode);
			if (m != null) {
				m.invoke(baseAction);
			}
			baseAction.doAfter();
			if (!response.isCommitted()) {
				getServletContext().getRequestDispatcher("/" + subTransBean.getRepage()).forward(request, response);
			}
		} catch (Exception e) {
			Log.getInstance().error(this.getClass().getName(), e.getMessage(), e);
		} finally {
			Log.getInstance().info("<主交易：" + transCode + ">|<子交易：" + subTransCode + ">", "结束！");
		}
	}

	/**
	 * 界面接收的值整理
	 * 
	 * @param map
	 * @return
	 */
	private Map<String, Object> formatMap(Map<?, ?> map) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		Iterator<?> ite = map.keySet().iterator();
		String key;
		String[] value;
		if (map != null && map.size() > 0) {
			while (ite.hasNext()) {
				key = (String) ite.next();
				value = (String[]) map.get(key);
				if (value.length == 1) {
					reMap.put(key, value[0]);
				} else {
					reMap.put(key, value);
				}
			}
		}
		return reMap;
	}
}
