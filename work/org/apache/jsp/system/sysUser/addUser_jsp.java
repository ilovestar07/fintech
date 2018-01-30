package org.apache.jsp.system.sysUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<form id=\"insertUserForm\" action=\"user.do\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">用户代码：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"user_code\" data-options=\"required:true,validType:'length[6,32]'\"/></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">用户名称：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"user_name\" data-options=\"required:true,validType:'length[2,64]'\"/></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">性别：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"sex\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">学历：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"degree\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">证件类型：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"id_type\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">证件号：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"id\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">邮箱：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"email\" data-options=\"validType:'email'\"/></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">传真：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"fax\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">QQ：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"qq\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">邮编：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"postcode\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"right\">地址：</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input class=\"easyui-validatebox textbox\" name=\"adress\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"8\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"saveUser\" onclick=\"insertUser();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-save'\" style=\"width:80px\">保存</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tfoot>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
