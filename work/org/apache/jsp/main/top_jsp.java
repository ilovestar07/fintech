package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-panel\" style=\"padding:5px;\">\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\" data-options=\"plain:true\">Home</a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-menubutton\" data-options=\"menu:'#mm1',iconCls:'icon-edit'\">Edit</a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-menubutton\" data-options=\"menu:'#mm2',iconCls:'icon-help'\">Help</a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-menubutton\" data-options=\"menu:'#mm3'\">About</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"mm1\" style=\"width:150px;\">\r\n");
      out.write("\t\t<div data-options=\"iconCls:'icon-undo'\">Undo</div>\r\n");
      out.write("\t\t<div data-options=\"iconCls:'icon-redo'\">Redo</div>\r\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t<div>Cut</div>\r\n");
      out.write("\t\t<div>Copy</div>\r\n");
      out.write("\t\t<div>Paste</div>\r\n");
      out.write("\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<span>Toolbar</span>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<div>Address</div>\r\n");
      out.write("\t\t\t\t<div>Link</div>\r\n");
      out.write("\t\t\t\t<div>Navigation Toolbar</div>\r\n");
      out.write("\t\t\t\t<div>Bookmark Toolbar</div>\r\n");
      out.write("\t\t\t\t<div class=\"menu-sep\"></div>\r\n");
      out.write("\t\t\t\t<div>New Toolbar...</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"iconCls:'icon-remove'\">Delete</div>\r\n");
      out.write("\t\t<div>Select All</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"mm2\" style=\"width:100px;\">\r\n");
      out.write("\t\t<div>Help</div>\r\n");
      out.write("\t\t<div>Update</div>\r\n");
      out.write("\t\t<div>About</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"mm3\" class=\"menu-content\" style=\"background:#f0f0f0;padding:10px;text-align:left\">\r\n");
      out.write("\t\t<img src=\"http://www.jeasyui.com/images/logo1.png\" style=\"width:150px;height:50px\">\r\n");
      out.write("\t\t<p style=\"font-size:14px;color:#444;\">Try jQuery EasyUI to build your modern, interactive, javascript applications.</p>\r\n");
      out.write("\t</div>\r\n");
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
