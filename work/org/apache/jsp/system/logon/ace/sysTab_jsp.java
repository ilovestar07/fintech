package org.apache.jsp.system.logon.ace;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sysTab_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/system/logon/ace/public.jsp");
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t    <title></title>\r\n");
      out.write("\t    ");
      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head> \r\n");
      out.write("\t\t<base href=");
      out.print( path);
      out.write("/>\r\n");
      out.write("\t    \t<!-- basic styles -->\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/css/bootstrap.min.css\" />\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/css/font-awesome.min.css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!--[if IE 7]>\r\n");
      out.write("\t\t\t  <link rel=\"stylesheet\" href=\"ace/css/font-awesome-ie7.min.css\" />\r\n");
      out.write("\t\t\t<![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!-- page specific plugin styles -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!-- ace styles -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/css/ace.min.css\" />\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/css/ace-rtl.min.css\" />\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/css/ace-skins.min.css\" />\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!--[if lte IE 8]>\r\n");
      out.write("\t\t\t  <link rel=\"stylesheet\" href=\"ace/css/ace-ie.min.css\" />\r\n");
      out.write("\t\t\t<![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!-- inline styles related to this page -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!-- ace settings handler -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<script src=\"ace/js/ace-extra.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t<!--[if lt IE 9]>\r\n");
      out.write("\t\t\t<script src=\"ace/js/html5shiv.js\"></script>\r\n");
      out.write("\t\t\t<script src=\"ace/js/respond.min.js\"></script>\r\n");
      out.write("\t\t\t<![endif]-->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 多页签插件 -->\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/plugins/yui/tabview.css\" />\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"ace/plugins/yui/ace.css\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<!-- basic scripts -->\r\n");
      out.write("\t<!--[if !IE]> -->\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.jQuery || document.write(\"<script src='ace/js/jquery-2.0.3.min.js'>\"+\"<\"+\"script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- <![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t<!--[if IE]>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t window.jQuery || document.write(\"<script src='ace/js/jquery-1.10.2.min.js'>\"+\"<\"+\"script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tif(\"ontouchend\" in document) document.write(\"<script src='ace/js/jquery.mobile.custom.min.js'>\"+\"<\"+\"script>\");\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script src=\"ace/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"ace/js/typeahead-bs2.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- page specific plugin scripts -->\r\n");
      out.write("\t\r\n");
      out.write("\t<!--[if lte IE 8]>\r\n");
      out.write("\t  <script src=\"ace/js/excanvas.min.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- ace scripts -->\r\n");
      out.write("\t\r\n");
      out.write("\t<script src=\"ace/js/ace-elements.min.js\"></script>\r\n");
      out.write("\t<script src=\"ace/js/ace.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 多页签插件 -->\r\n");
      out.write("\t<script src=\"ace/js/jquery-1.10.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"ace/plugins/yui/yahoo-dom-event.js\"></script>\r\n");
      out.write("\t<script src=\"ace/plugins/yui/connection-min.js\"></script>\r\n");
      out.write("\t<script src=\"ace/plugins/yui/element-beta-min.js\"></script>\r\n");
      out.write("\t<script src=\"ace/plugins/yui/tabview-min.js\"></script>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t    <script type='text/javascript' charset='utf-8'>\r\n");
      out.write("\t        var tabView = new YAHOO.widget.TabView();\r\n");
      out.write("\t        var tabHeight;\r\n");
      out.write("\t        //最多打开tab个数\r\n");
      out.write("\t        var tabNum = 8;\r\n");
      out.write("\t        init = function() {\r\n");
      out.write("\t            tabView.appendTo('yuicontainer');\r\n");
      out.write("\t            addTab('0', '首页', 'system/logon/ace/home.jsp');\r\n");
      out.write("\t        }\r\n");
      out.write("\t\r\n");
      out.write("\t        addTab = function(id,label,src) {\r\n");
      out.write("\t            //同一菜单只允许打开一次,多次打开视为切换tab页\r\n");
      out.write("\t            for(var tabIndex=0;tabIndex<tabView.get(\"tabs\").length;tabIndex++) {\r\n");
      out.write("\t                var tab=tabView.getTab(tabIndex);\r\n");
      out.write("\t                if(tab.get(\"id\")==id){\r\n");
      out.write("\t                    tabView.set('activeTab',tab,true);\r\n");
      out.write("\t                    return;\r\n");
      out.write("\t                }\r\n");
      out.write("\t            }\r\n");
      out.write("\t\r\n");
      out.write("\t            //判断是否tab个数达到限定个数\r\n");
      out.write("\t            if(tabView.get(\"tabs\").length == tabNum) {\r\n");
      out.write("\t                if(!confirm(\"打开窗口个数已经达到\"+tabNum+\"个,新开窗口将会关闭第一个窗口,是否继续?\")) {\r\n");
      out.write("\t                    return;\r\n");
      out.write("\t                }\r\n");
      out.write("\t                //删除第一个窗口\r\n");
      out.write("\t                tabView.removeTab(tabView.getTab(\"0\"));\r\n");
      out.write("\t            }\r\n");
      out.write("\t            var labelText = label;\r\n");
      out.write("\t            var content = '<div class=\"iframe_container\"><div id=\"tobarDiv'+id+'\" class=\"tobarDiv\"></div><iframe class=\"tabFrame\" id=\"iFrame'+id+'\" name=\"iFrame'+id+'\" frameBorder=0 scrolling=\"auto\" width=\"100%\" height=\"100%\" resizeable=\"yes\"  src=\"'+src+'\"></iframe></div>';\r\n");
      out.write("\t            var tab = new YAHOO.widget.Tab({ label: labelText,content:content });\r\n");
      out.write("\t            tabView.addTab(tab);\r\n");
      out.write("\t            tabView.set('activeTab',tab,true);\r\n");
      out.write("\t            tab.set('title',labelText);\r\n");
      out.write("\t            tab.set(\"id\",id);\r\n");
      out.write("\t            tab.addListener('dblclick',dblClickEvent);\r\n");
      out.write("\t        }\r\n");
      out.write("\t        //双击TAB头关闭事件\r\n");
      out.write("\t        function dblClickEvent(e) {\r\n");
      out.write("\t            var tab=tabView.get('activeTab');\r\n");
      out.write("\t            var id=tab.get(\"id\");\r\n");
      out.write("\t            if (id == '0') {\r\n");
      out.write("\t            \treturn;\r\n");
      out.write("\t            }\r\n");
      out.write("\t            document.getElementById(\"iFrame\"+id).src=\"\";\r\n");
      out.write("\t            tabView.removeTab(tab);\r\n");
      out.write("\t        }\r\n");
      out.write("\t\r\n");
      out.write("\t        //获取当前TAB的resource_id\r\n");
      out.write("\t        function getResourceId() {\r\n");
      out.write("\t            if(tabView.get('activeTab')) {\r\n");
      out.write("\t                return tabView.get('activeTab').get(\"id\");\r\n");
      out.write("\t            } else {\r\n");
      out.write("\t                return null;\r\n");
      out.write("\t            }\r\n");
      out.write("\t        }\r\n");
      out.write("\t\r\n");
      out.write("\t        function closeTab(tabId) {\r\n");
      out.write("\t            for(var tabIndex=0;tabIndex<tabView.get(\"tabs\").length;tabIndex++){\r\n");
      out.write("\t                var tab=tabView.getTab(tabIndex);\r\n");
      out.write("\t                if(tab.get(\"id\")==tabId){\r\n");
      out.write("\t                    document.getElementById(\"iFrame\"+tabId).src=\"\";\r\n");
      out.write("\t                    tabView.removeTab(tab);\r\n");
      out.write("\t                    return;\r\n");
      out.write("\t                }\r\n");
      out.write("\t            }\r\n");
      out.write("\t        }\r\n");
      out.write("\t    </script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\" style=\"margin:0;padding:0; background:#fff\">\r\n");
      out.write("\t\t<div id=\"yuicontainer\"></div>\r\n");
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
