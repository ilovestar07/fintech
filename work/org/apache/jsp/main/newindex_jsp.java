package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.idlerframework.util.date.DateUtil;

public final class newindex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>Basic Layout - jQuery EasyUI Demo</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath());
      out.write("/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath());
      out.write("/easyui/themes/icon.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print( request.getContextPath());
      out.write("/demo.css\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print( request.getContextPath());
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print( request.getContextPath());
      out.write("/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction startTime(){\r\n");
      out.write("\t\t\tvar sysDate = '");
      out.print(DateUtil.getSysDateTime());
      out.write("'.split(' ');\r\n");
      out.write("\t\t    var today=new Date(); \r\n");
      out.write("\t\t    var h=today.getHours() ;\r\n");
      out.write("\t\t    var m=today.getMinutes();\r\n");
      out.write("\t\t    var s=today.getSeconds();\r\n");
      out.write("\t\t    h=checkTime(h); \r\n");
      out.write("\t\t    m=checkTime(m); \r\n");
      out.write("\t\t    s=checkTime(s); \r\n");
      out.write("\t\t    document.getElementById('time').innerHTML=sysDate[0]+\" \"+sysDate[1]+\" \"+h+\":\"+m+\":\"+s+\" \";\r\n");
      out.write("\t\t    t=setTimeout('startTime()',500); \r\n");
      out.write("\t\t } \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t function checkTime(i){ \r\n");
      out.write("\t\t    if (i<10) {\r\n");
      out.write("\t\t    \ti=\"0\" + i\r\n");
      out.write("\t\t    } \r\n");
      out.write("\t\t    return i; \r\n");
      out.write("\t\t } \r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body class=\"easyui-layout\" onload=\"startTime();\">\r\n");
      out.write("\t\t<div data-options=\"region:'north',border:false\" style=\"height:60px;background:#B3DFDA;padding:10px\"></div>\r\n");
      out.write("\t\t<div data-options=\"region:'west',split:true,title:'West'\" style=\"width:150px;padding:10px;\">west content</div>\r\n");
      out.write("\t\t<div data-options=\"region:'east',split:true,collapsed:true,title:'East'\" style=\"width:100px;padding:10px;\">east region</div>\r\n");
      out.write("\t\t<div data-options=\"region:'south',border:false\" style=\"height:30px;background:#A9FACD;padding:8px;\">\r\n");
      out.write("\t\t\t<span id=\"username\">欢迎您：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userBean}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("        \t<span id=\"time\"></span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'center',title:'首页'\">\r\n");
      out.write("\t\t\t<iframe src=\"");
      out.print( request.getContextPath());
      out.write("/main/newspace.html\" width=\"100%\" height=\"100%\" frameborder=\"0\"></iframe>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
