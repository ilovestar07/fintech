package org.apache.jsp.system.logon.ace;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.idlerframework.util.constant.SysConstant;

public final class aceindex3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/system/logon/ace/acepublic.jsp");
    _jspx_dependants.add("/system/logon/ace/aceheader.jsp");
    _jspx_dependants.add("/system/logon/ace/acemenu.jsp");
  }

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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"utf-8\" />\n");
      out.write("\t\t<title>控制台 </title>\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("\t\t");
      out.write('\r');
      out.write('\n');

String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head> \r\n");
      out.write("\t<base href=");
      out.print( path);
      out.write("/>\r\n");
      out.write("    \t<!-- basic styles -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"ace/css/bootstrap.min.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"ace/css/font-awesome.min.css\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if IE 7]>\r\n");
      out.write("\t\t  <link rel=\"stylesheet\" href=\"ace/css/font-awesome-ie7.min.css\" />\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- page specific plugin styles -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- ace styles -->\r\n");
      out.write("\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"ace/css/ace.min.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"ace/css/ace-rtl.min.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"ace/css/ace-skins.min.css\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if lte IE 8]>\r\n");
      out.write("\t\t  <link rel=\"stylesheet\" href=\"ace/css/ace-ie.min.css\" />\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- inline styles related to this page -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- ace settings handler -->\r\n");
      out.write("\r\n");
      out.write("\t\t<script src=\"ace/js/ace-extra.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if lt IE 9]>\r\n");
      out.write("\t\t<script src=\"ace/js/html5shiv.js\"></script>\r\n");
      out.write("\t\t<script src=\"ace/js/respond.min.js\"></script>\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<!-- basic scripts -->\r\n");
      out.write("<!--[if !IE]> -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\twindow.jQuery || document.write(\"<script src='ace/js/jquery-2.0.3.min.js'>\"+\"<\"+\"script>\");\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- <![endif]-->\r\n");
      out.write("\r\n");
      out.write("<!--[if IE]>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t window.jQuery || document.write(\"<script src='ace/js/jquery-1.10.2.min.js'>\"+\"<\"+\"script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tif(\"ontouchend\" in document) document.write(\"<script src='ace/js/jquery.mobile.custom.min.js'>\"+\"<\"+\"script>\");\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"ace/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"ace/js/typeahead-bs2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- page specific plugin scripts -->\r\n");
      out.write("\r\n");
      out.write("<!--[if lte IE 8]>\r\n");
      out.write("  <script src=\"ace/js/excanvas.min.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<!-- ace scripts -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"ace/js/ace-elements.min.js\"></script>\r\n");
      out.write("<script src=\"ace/js/ace.min.js\"></script>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("\t\t<style>\n");
      out.write("\t\t    body, html{ height:100%; width:100%; overflow: hidden }\n");
      out.write("\t\t</style>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<table id=\"frametable\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" height=\"100%\">\n");
      out.write("\t\t    <tr>\n");
      out.write("\t\t        <td colspan=\"2\" height=\"45\">\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"navbar navbar-default\" id=\"navbar\">\r\n");
      out.write("\t\t<div class=\"navbar-container\" id=\"navbar-container\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header pull-left\">\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\">\r\n");
      out.write("\t\t\t\t\t<small>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-leaf\"></i>\r\n");
      out.write("\t\t\t\t\t\tACE后台管理系统\r\n");
      out.write("\t\t\t\t\t</small>\r\n");
      out.write("\t\t\t\t</a><!-- /.brand -->\r\n");
      out.write("\t\t\t</div><!-- /.navbar-header -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"navbar-header pull-right\" role=\"navigation\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav ace-nav\">\r\n");
      out.write("\t\t\t\t\t<li class=\"grey\">\r\n");
      out.write("\t\t\t\t\t\t<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-tasks\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"badge badge-grey\">4</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"dropdown-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-ok\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t还有4个任务完成\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看任务详情\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-arrow-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"purple\">\r\n");
      out.write("\t\t\t\t\t\t<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-bell-alt icon-animated-bell\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"badge badge-important\">8</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"dropdown-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-warning-sign\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t8条通知\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看所有通知\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-arrow-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"green\">\r\n");
      out.write("\t\t\t\t\t\t<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-envelope icon-animated-vertical\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"badge badge-success\">5</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"dropdown-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-envelope-alt\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t5条消息\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"inbox.html\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t查看所有消息\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-arrow-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"light-blue\">\r\n");
      out.write("\t\t\t\t\t\t<a data-toggle=\"dropdown\" href=\"#\" class=\"dropdown-toggle\">\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"nav-user-photo\" />\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"user-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<small>欢迎光临,</small>\r\n");
      out.write("\t\t\t\t\t\t\t\tJason\r\n");
      out.write("\t\t\t\t\t\t\t</span>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"icon-caret-down\"></i>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close\">\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-cog\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t设置\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t个人资料\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"icon-off\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t退出\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul><!-- /.ace-nav -->\r\n");
      out.write("\t\t\t</div><!-- /.navbar-header -->\r\n");
      out.write("\t\t</div><!-- /.container -->\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t        <td valign=\"top\" width=\"190\" height=\"100%\">\n");
      out.write("\t\t            <div class=\"left\">\n");
      out.write("\t\t            \t");
      out.write("\r\n");
      out.write("\r\n");

	String tree = (String) request.getSession().getAttribute(SysConstant.SYS_MENU_TREE);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<script src=\"system/logon/ace/aceTab.js\"></script>\r\n");
      out.write("\t<script src=\"system/logon/ace/aceSidebarMenu.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(window).on('load', function () {\r\n");
      out.write("\t\t\t$('#menuTree').sidebarMenu({\r\n");
      out.write("\t\t\t\tdata : ");
      out.print(tree);
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"sidebar\" id=\"sidebar\">\r\n");
      out.write("\t\t\t<div class=\"sidebar-shortcuts\" id=\"sidebar-shortcuts\">\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-shortcuts-large\" id=\"sidebar-shortcuts-large\">\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-success\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-signal\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-info\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-pencil\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-warning\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-group\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-danger\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"icon-cogs\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-shortcuts-mini\" id=\"sidebar-shortcuts-mini\">\r\n");
      out.write("\t\t\t\t\t<span class=\"btn btn-success\"></span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<span class=\"btn btn-info\"></span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<span class=\"btn btn-warning\"></span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<span class=\"btn btn-danger\"></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div><!-- #sidebar-shortcuts -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<ul class=\"nav nav-list\" id=\"menuTree\">\r\n");
      out.write("\t\t\t</ul><!-- /.nav-list -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<div class=\"sidebar-collapse\" id=\"sidebar-collapse\">\r\n");
      out.write("\t\t\t\t<i class=\"icon-double-angle-left\" data-icon1=\"icon-double-angle-left\" data-icon2=\"icon-double-angle-right\"></i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("\t\t            </div>\n");
      out.write("\t\t        </td>\n");
      out.write("\t\t        <td valign=\"top\" width=\"100%\" height=\"100%\">\n");
      out.write("\t\t        \t<iframe id=\"iframe\" name=\"main\" src=\"AceMod/right.html\" width=\"100%\" \n");
      out.write("                    height=\"100%\" frameborder=\"0\" scrolling=\"no\"></iframe>\n");
      out.write("\t\t        </td>\n");
      out.write("\t      \t</tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\t\t<a href=\"#\" id=\"btn-scroll-up\" class=\"btn-scroll-up btn btn-sm btn-inverse\">\n");
      out.write("\t\t\t<i class=\"icon-double-angle-up icon-only bigger-110\"></i>\n");
      out.write("\t\t</a>\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
