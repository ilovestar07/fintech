package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class basic_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>Basic DataGrid - jQuery EasyUI Demo</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h2>Basic DataGrid</h2>\r\n");
      out.write("\t<p>The DataGrid is created from markup, no JavaScript code needed.</p>\r\n");
      out.write("\t<form action=\"test.do\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\" name=\"提交\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div style=\"margin:20px 0;\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<table class=\"easyui-datagrid\" title=\"Basic DataGrid\" style=\"width:700px;height:250px\"\r\n");
      out.write("\t\t\tdata-options=\"singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'itemid',width:80\">Item ID</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'productid',width:100\">Product</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'listprice',width:80,align:'right'\">List Price</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'unitcost',width:80,align:'right'\">Unit Cost</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'attr1',width:250\">Attribute</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'status',width:60,align:'center'\">Status</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
