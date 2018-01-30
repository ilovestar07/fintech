package org.apache.jsp.system.logon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t<title>System</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/icon.css\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body class=\"easyui-layout\" onload=\"startTime();\">\r\n");
      out.write("\t\t<div data-options=\"region:'north',border:false,href:'");
      out.print(path);
      out.write("/system/logon/head.jsp'\" style=\"height:35px;background:#B3DFDA; overflow:hidden;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div data-options=\"region:'west',split:true,title:'功能导航'\" style=\"width:150px;\">\r\n");
      out.write("\t\t\t<iframe src=\"");
      out.print(path);
      out.write("/system/logon/tree.jsp\" style=\"width:100%;height:100%;\" frameborder=\"0\"></iframe>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- <div data-options=\"region:'east',split:true,collapsed:true,title:'East'\" style=\"width:100px;padding:10px;\">east region</div> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div data-options=\"region:'south',border:false,href:'");
      out.print(path);
      out.write("/system/logon/foot.jsp'\" style=\"height:30px;background:#A9FACD;padding:8px; overflow:hidden;\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div data-options=\"region:'center',title:''\" style=\"width:100%;height:100%;\">\r\n");
      out.write("\t\t\t<div id=\"indexTab\" class=\"easyui-tabs\" data-options=\"fit:true,border:false,plain:true\">\r\n");
      out.write("\t\t\t\t<div title=\"首页\" data-options=\"href:'");
      out.print(path);
      out.write("/system/logon/main.jsp'\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
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
