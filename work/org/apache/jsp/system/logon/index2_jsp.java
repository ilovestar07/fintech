package org.apache.jsp.system.logon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.idlerframework.util.constant.SysConstant;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/system/public.jsp");
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

      out.write('\n');
      out.write('\n');

	String tree = (String) request.getSession().getAttribute(SysConstant.SYS_MENU_TREE);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t");
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
      out.write("    <!-- Tell the browser to be responsive to screen width -->\r\n");
      out.write("\t<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("\t<!-- Bootstrap 3.3.7 -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css\">\r\n");
      out.write("\t<!-- Font Awesome -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("\t<!-- Ionicons -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/Ionicons/css/ionicons.min.css\">\r\n");
      out.write("\t<!-- Theme style -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/dist/css/AdminLTE.min.css\">\r\n");
      out.write("\t<!-- AdminLTE Skins. Choose a skin from the css/skins\r\n");
      out.write("\t     folder instead of downloading all of them to reduce the load. -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/dist/css/skins/_all-skins.min.css\">\r\n");
      out.write("\t<!-- Morris chart -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/morris.js/morris.css\">\r\n");
      out.write("\t<!-- jvectormap -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/jvectormap/jquery-jvectormap.css\">\r\n");
      out.write("\t<!-- Date Picker -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css\">\r\n");
      out.write("\t<!-- Daterange picker -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/bower_components/bootstrap-daterangepicker/daterangepicker.css\">\r\n");
      out.write("\t<!-- bootstrap wysihtml5 - text editor -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("\t<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("\t<!--[if lt IE 9]>\r\n");
      out.write("\t<script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<!-- jQuery 3 -->\r\n");
      out.write("<script src=\"adminlte/bower_components/jquery/dist/jquery.min.js\"></script>\r\n");
      out.write("<!-- jQuery UI 1.11.4 -->\r\n");
      out.write("<script src=\"adminlte/bower_components/jquery-ui/jquery-ui.min.js\"></script>\r\n");
      out.write("<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->\r\n");
      out.write("<script>\r\n");
      out.write("  $.widget.bridge('uibutton', $.ui.button);\r\n");
      out.write("</script>\r\n");
      out.write("<!-- Bootstrap 3.3.7 -->\r\n");
      out.write("<script src=\"adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- Morris.js charts -->\r\n");
      out.write("<script src=\"adminlte/bower_components/raphael/raphael.min.js\"></script>\r\n");
      out.write("<script src=\"adminlte/bower_components/morris.js/morris.min.js\"></script>\r\n");
      out.write("<!-- Sparkline -->\r\n");
      out.write("<script src=\"adminlte/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js\"></script>\r\n");
      out.write("<!-- jvectormap -->\r\n");
      out.write("<script src=\"adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>\r\n");
      out.write("<script src=\"adminlte/plugins/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\r\n");
      out.write("<!-- jQuery Knob Chart -->\r\n");
      out.write("<script src=\"adminlte/bower_components/jquery-knob/dist/jquery.knob.min.js\"></script>\r\n");
      out.write("<!-- daterangepicker -->\r\n");
      out.write("<script src=\"adminlte/bower_components/moment/min/moment.min.js\"></script>\r\n");
      out.write("<script src=\"adminlte/bower_components/bootstrap-daterangepicker/daterangepicker.js\"></script>\r\n");
      out.write("<!-- datepicker -->\r\n");
      out.write("<script src=\"adminlte/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap WYSIHTML5 -->\r\n");
      out.write("<script src=\"adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\r\n");
      out.write("<!-- Slimscroll -->\r\n");
      out.write("<script src=\"adminlte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\r\n");
      out.write("<!-- FastClick -->\r\n");
      out.write("<script src=\"adminlte/bower_components/fastclick/lib/fastclick.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"adminlte/dist/js/adminlte.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE dashboard demo (This is only for demo purposes) -->\r\n");
      out.write("<script src=\"adminlte/dist/js/pages/dashboard.js\"></script>\r\n");
      out.write("<!-- AdminLTE for demo purposes -->\r\n");
      out.write("<script src=\"adminlte/dist/js/demo.js\"></script>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function parentMenu(menu) {\n");
      out.write("\tvar html = $('<li class=\"treeview\">'\n");
      out.write("\t\t\t   + '<a href=\"'+menu.url+'\">'\n");
      out.write("\t\t\t   + '<i class=\"fa fa-dashboard\"></i>'\n");
      out.write("\t\t\t   + '<span>'+menu.text+'</span>'\n");
      out.write("\t\t\t   + '<span class=\"pull-right-container\">'\n");
      out.write("\t\t\t   + '<i class=\"fa fa-angle-left pull-right\"></i>'\n");
      out.write("\t\t\t   + '</span>'\n");
      out.write("\t\t\t   + '</a>'\n");
      out.write("\t\t\t   + '<ul menuUl-id=\"'+menu.id+'\" class=\"treeview-menu\"> </ul>'\n");
      out.write("\t\t\t   + '<li>');\n");
      out.write("\treturn html;\n");
      out.write("}\n");
      out.write("\n");
      out.write("function leafMenu(menu) {\n");
      out.write("\tvar html = $('<li class=\"\"><a href=\"\" menu-controller=\"'+menu.url+'\"><i class=\"fa fa-circle-o\"></i>'+menu.text+'</a></li>');\n");
      out.write("\treturn html;\n");
      out.write("}\n");
      out.write("\n");
      out.write("function menuInit() {\n");
      out.write("\tvar menuJson = ");
      out.print(tree);
      out.write(";\n");
      out.write("    var html = null;\n");
      out.write("    var chidLen = null;\n");
      out.write("    var child = null;\n");
      out.write("    for (var i = 0; i < menuJson.length; i++) {\n");
      out.write("        menu = menuJson[i];\n");
      out.write("        \n");
      out.write("        html = parentMenu(menu);\n");
      out.write("        $(\".sidebar .sidebar-menu\").append(html);\n");
      out.write("\t\t\n");
      out.write("        if (menu.child!=null) {\n");
      out.write("        \tchidLen = menu.child.length;\n");
      out.write("        }\n");
      out.write("        for (var j=0;j<chidLen;j++){\n");
      out.write("            child = menu.child[j];\n");
      out.write("\t\t\t\n");
      out.write("            html = leafMenu(child);\n");
      out.write("            $('[menuUl-id=\"'+menu.id+'\"]').append(html);\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    $(Selector.data).each(function () {\n");
      out.write("        Plugin.call($(this))\n");
      out.write("    })\n");
      out.write("    $(\".sidebar-menu li:first ul li:first a\").click();\n");
      out.write("}\n");
      out.write("\n");
      out.write("$(window).on('load', function () {\n");
      out.write("\tmenuInit();\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("<body class=\"hold-transition skin-blue sidebar-mini fixed\">\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("\t<header class=\"main-header\">\n");
      out.write("\t\t<!-- Logo -->\n");
      out.write("\t\t<a href=\"#\" class=\"logo\">\n");
      out.write("\t\t\t<!-- mini logo for sidebar mini 50x50 pixels -->\n");
      out.write("\t\t\t<span class=\"logo-mini\"><b>A</b>LT</span>\n");
      out.write("\t\t\t<!-- logo for regular state and mobile devices -->\n");
      out.write("\t\t\t<span class=\"logo-lg\"><b>Admin</b>LTE</span>\n");
      out.write("\t\t</a>\n");
      out.write("\t\t<!-- Header Navbar: style can be found in header.less -->\n");
      out.write("\t\t<nav class=\"navbar navbar-static-top\">\n");
      out.write("\t\t\t<!-- Sidebar toggle button-->\n");
      out.write("\t\t\t<a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">\n");
      out.write("\t\t\t\t<span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("\t\t\t</a>\n");
      out.write("\t\t\t<div class=\"navbar-custom-menu\">\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("  \t\t\t\t\t<!-- Messages: style can be found in dropdown.less-->\n");
      out.write("\t\t\t\t\t<li class=\"dropdown messages-menu\">\n");
      out.write("  \t\t\t\t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("\t    \t\t\t\t\t<i class=\"fa fa-envelope-o\"></i>\n");
      out.write("\t    \t\t\t\t\t<span class=\"label label-success\">4</span>\n");
      out.write("  \t\t\t\t\t\t</a>\n");
      out.write("  \t\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t    \t\t\t\t\t<li class=\"header\">You have 4 messages</li>\n");
      out.write("\t    \t\t\t\t\t\n");
      out.write("\t    \t\t\t\t\t<li class=\"footer\"><a href=\"#\">See All Messages</a></li>\n");
      out.write("  \t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<!-- Notifications: style can be found in dropdown.less -->\n");
      out.write("\t\t\t\t\t<li class=\"dropdown notifications-menu\">\n");
      out.write("\t\t\t            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("\t\t\t\t            <i class=\"fa fa-bell-o\"></i>\n");
      out.write("\t\t\t\t            <span class=\"label label-warning\">10</span>\n");
      out.write("\t\t\t            </a>\n");
      out.write("            \t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("              \t\t\t\t<li class=\"header\">You have 10 notifications</li>\n");
      out.write("              \n");
      out.write("              \t\t\t\t<li class=\"footer\"><a href=\"#\">View all</a></li>\n");
      out.write("            \t\t\t</ul>\n");
      out.write("          \t\t\t</li>\n");
      out.write("          \t\t\t<!-- Tasks: style can be found in dropdown.less -->\n");
      out.write("          \t\t\t<li class=\"dropdown tasks-menu\">\n");
      out.write("            \t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("              \t\t\t\t<i class=\"fa fa-flag-o\"></i>\n");
      out.write("              \t\t\t\t<span class=\"label label-danger\">9</span>\n");
      out.write("            \t\t\t</a>\n");
      out.write("            \t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("              \t\t\t\t<li class=\"header\">You have 9 tasks</li>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<li class=\"footer\"><a href=\"#\">View all</a></li>\n");
      out.write("            \t\t\t</ul>\n");
      out.write("          \t\t\t</li>\n");
      out.write("          \t\t\t<!-- User Account: style can be found in dropdown.less -->\n");
      out.write("          \t\t\t<li class=\"dropdown user user-menu\">\n");
      out.write("            \t\t\t<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("              \t\t\t\t<img src=\"mirrors-adminlte-master/adminlte/dist/img/user2-160x160.jpg\" class=\"user-image\" alt=\"User Image\">\n");
      out.write("              \t\t\t\t<span class=\"hidden-xs\">Alexander Pierce</span>\n");
      out.write("            \t\t\t</a>\n");
      out.write("            \t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t              \t\t\t<!-- User image -->\n");
      out.write("\t              \t\t\t<li class=\"user-header\">\n");
      out.write("\t                \t\t\t<img src=\"mirrors-adminlte-master/adminlte/dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>Alexander Pierce - Web Developer<small>Member since Nov. 2012</small></p>\n");
      out.write("\t              \t\t\t</li>\n");
      out.write("\t              \t\t\t<!-- Menu Body -->\n");
      out.write("\t              \t\t\t<li class=\"user-body\">\n");
      out.write("\t                \t\t\t<div class=\"row\">\n");
      out.write("\t\t                  \t\t\t<div class=\"col-xs-4 text-center\">\n");
      out.write("\t\t                    \t\t\t<a href=\"#\">Followers</a>\n");
      out.write("\t\t                  \t\t\t</div>\n");
      out.write("\t\t                  \t\t\t<div class=\"col-xs-4 text-center\">\n");
      out.write("\t\t                    \t\t\t<a href=\"#\">Sales</a>\n");
      out.write("\t\t                  \t\t\t</div>\n");
      out.write("\t\t                  \t\t\t<div class=\"col-xs-4 text-center\">\n");
      out.write("\t\t                    \t\t\t<a href=\"#\">Friends</a>\n");
      out.write("\t\t                  \t\t\t</div>\n");
      out.write("\t                \t\t\t</div>\n");
      out.write("\t                \t\t\t<!-- /.row -->\n");
      out.write("\t              \t\t\t</li>\n");
      out.write("\t              \t\t\t<!-- Menu Footer-->\n");
      out.write("\t              \t\t\t<li class=\"user-footer\">\n");
      out.write("\t                \t\t\t<div class=\"pull-left\">\n");
      out.write("\t                  \t\t\t\t<a href=\"#\" class=\"btn btn-default btn-flat\">Profile</a>\n");
      out.write("\t                \t\t\t</div>\n");
      out.write("\t                \t\t\t<div class=\"pull-right\">\n");
      out.write("\t                  \t\t\t\t<a href=\"#\" class=\"btn btn-default btn-flat\">Sign out</a>\n");
      out.write("\t                \t\t\t</div>\n");
      out.write("              \t\t\t\t</li>\n");
      out.write("            \t\t\t</ul>\n");
      out.write("          \t\t\t</li>\n");
      out.write("            \t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("\t<aside class=\"main-sidebar\">\n");
      out.write("\t\t<!-- sidebar: style can be found in sidebar.less -->\n");
      out.write("    \t<section class=\"sidebar\">\n");
      out.write("      \t\t<!-- Sidebar user panel -->\n");
      out.write("      \t\t<div class=\"user-panel\">\n");
      out.write("        \t\t<div class=\"pull-left image\">\n");
      out.write("          \t\t\t<img src=\"mirrors-adminlte-master/adminlte/dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("        \t\t</div>\n");
      out.write("        \t\t<div class=\"pull-left info\">\n");
      out.write("          \t\t\t<p>Alexander Pierce</p>\n");
      out.write("          \t\t\t<a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n");
      out.write("        \t\t</div>\n");
      out.write("      \t\t</div>\n");
      out.write("      \t\t<!-- search form -->\n");
      out.write("      \t\t<form action=\"#\" method=\"get\" class=\"sidebar-form\">\n");
      out.write("        \t\t<div class=\"input-group\">\n");
      out.write("          \t\t\t<input type=\"text\" name=\"q\" class=\"form-control\" placeholder=\"Search...\">\n");
      out.write("              \t\t<span class=\"input-group-btn\">\n");
      out.write("                \t\t<button type=\"submit\" name=\"search\" id=\"search-btn\" class=\"btn btn-flat\"><i class=\"fa fa-search\"></i>\n");
      out.write("                \t\t</button>\n");
      out.write("              \t\t</span>\n");
      out.write("        \t\t</div>\n");
      out.write("      \t\t</form>\n");
      out.write("      \t\t<!-- /.search form -->\n");
      out.write("      \t\t<!-- sidebar menu: : style can be found in sidebar.less -->\n");
      out.write("      \t\t<ul class=\"sidebar-menu\" data-widget=\"tree\">\n");
      out.write("      \t\t</ul>\n");
      out.write("    \t</section>\n");
      out.write("    \t<!-- /.sidebar -->\n");
      out.write("\t</aside>\n");
      out.write("\t<div class=\"content-wrapper\">\n");
      out.write("\t\t<div id=\"Hui-tabNav\" class=\"Hui-tabNav \">\n");
      out.write("        <div class=\"Hui-tabNav-wp\">\n");
      out.write("        <ul id=\"min_title_list\" class=\"acrossTab cl\" style=\"padding-left: 6px;\">\n");
      out.write("            <li class=\"active\">\n");
      out.write("                <span title=\"首页\" data-href=\"\">首页</span><em></em>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"iframe_box\" class=\"Hui-article\">\n");
      out.write("        <div class=\"show_iframe\">\n");
      out.write("           <div style=\"display: none\" class=\"loading\"></div>\n");
      out.write("           <iframe scrolling=\"yes\" frameborder=\"0\" src=\"\"></iframe>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<footer class=\"main-footer\">\n");
      out.write("\t\n");
      out.write("\t</footer>\n");
      out.write("\t\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
