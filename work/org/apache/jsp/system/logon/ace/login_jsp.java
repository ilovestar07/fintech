package org.apache.jsp.system.logon.ace;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-store"); //HTTP 1.1 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //保证每次对页面的访问都是最新的

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>控制台 - Bootstrap后台管理系统模版Ace下载</title>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("\t\t");
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
      out.write("\r\n");
      out.write("\t\t<script type=\"text/javascript\" >\r\n");
      out.write("\t\t\tvar XMLHttpReq = false;\r\n");
      out.write("\t\t\t//创建XMLHttpRequest对象\r\n");
      out.write("\t\t\tfunction createXMLHttpRequest() {\r\n");
      out.write("\t\t\t\tif (window.XMLHttpRequest) { //Mozilla 浏览器\r\n");
      out.write("\t\t\t\t\tXMLHttpReq = new XMLHttpRequest();\r\n");
      out.write("\t\t\t\t\tif (XMLHttpReq.overrideMimeType) { //设置MiME类别 \r\n");
      out.write("\t\t\t\t\t\t//有些版本的浏览器(如IE7会,IE6不会)在处理服务器返回的未包含XML mime-type头部信息的内容时会报错，因此，要确保返回的内容包含text/xml信息。 \r\n");
      out.write("\t\t\t\t\t\tXMLHttpReq.overrideMimeType(\"text/xml\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t} else if (window.ActiveXObject) { // IE浏览器\r\n");
      out.write("\t\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\t\tXMLHttpReq = new ActiveXObject(\"Msxml2.XMLHTTP\");\r\n");
      out.write("\t\t\t\t\t} catch (e) {\r\n");
      out.write("\t\t\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\t\t\tXMLHttpReq = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("\t\t\t\t\t\t\tXMLHttpReq.overrideMimeType('text/xml');\r\n");
      out.write("\t\t\t\t\t\t} catch (e) {\r\n");
      out.write("\t\t\t\t\t\t\tXMLHttpReq = new XMLHttpRequest();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//发送请求函数\r\n");
      out.write("\t\t\tfunction sendRequest(url) {\r\n");
      out.write("\t\t\t\tcreateXMLHttpRequest();\r\n");
      out.write("\t\t\t\tXMLHttpReq.open(\"GET\",\r\n");
      out.write("\t\t\t\t\t\turl + \"&refresh=\" + new Date().getMilliseconds(), true);\r\n");
      out.write("\t\t\t\tXMLHttpReq.onreadystatechange = processResponse;//指定响应函数\r\n");
      out.write("\t\t\t\tXMLHttpReq.send(null); // 发送请求\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t// 处理返回信息函数\r\n");
      out.write("\t\t\tfunction processResponse() {\r\n");
      out.write("\t\t\t\tif (XMLHttpReq.readyState == 4) { // 判断对象状态\r\n");
      out.write("\t\t\t\t\tif (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息\r\n");
      out.write("\t\t\t\t\t\tvar data = XMLHttpReq.responseXML;\r\n");
      out.write("\t\t\t\t\t\tvar msg = data.getElementsByTagName(\"msg\")[0].firstChild.data;\r\n");
      out.write("\t\t\t\t\t\tvar flag = data.getElementsByTagName(\"flag\")[0].firstChild.data;\r\n");
      out.write("\t\t\t\t\t\tif (flag == \"1\") {\r\n");
      out.write("\t\t\t\t\t\t\tdocument.logonForm.subTransCode.value = \"logon\";\r\n");
      out.write("\t\t\t\t\t\t\tlogonForm.submit();\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\talert(msg);\r\n");
      out.write("\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} else { //页面不正常\r\n");
      out.write("\t\t\t\t\t\twindow.alert(\"用户信息校验失败!\");\r\n");
      out.write("\t\t\t\t\t\tdocument.logonForm.user_code.focus();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" >\r\n");
      out.write("\t\t\tfunction doSubmit() {\r\n");
      out.write("\t\t\t\tif ($(\"#user_code\").val() == \"\") {\r\n");
      out.write("\t\t\t\t\talert(\"用户名不能为空!\");\r\n");
      out.write("\t\t\t\t\tlogonForm.user_code.focus()\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif ($(\"#password\").val() == \"\") {\r\n");
      out.write("\t\t\t\t\talert(\"密码不能为空!\");\r\n");
      out.write("\t\t\t\t\tlogonForm.password.focus()\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tcreateXMLHttpRequest();\r\n");
      out.write("\t\t\t\tvar url = \"logon.do?subTransCode=chk&useType=chk&user_code=\"\r\n");
      out.write("\t\t\t\t\t\t+$(\"#user_code\").val()+\"&password=\"\r\n");
      out.write("\t\t\t\t\t\t+$(\"#password\").val();\r\n");
      out.write("\t\t\t\tsendRequest(url);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body class=\"login-layout\" onload=\"\" style=\"background: silver;\">\r\n");
      out.write("\t\t<div class=\"login-container\" >\r\n");
      out.write("\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t<i class=\"icon-leaf green\"></i>\r\n");
      out.write("\t\t\t\t\t<span class=\"red\">Ace</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"white\">Application</span>\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t<h4 class=\"blue\">&copy; Company Name</h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"position-relative\">\r\n");
      out.write("\t\t\t\t<div id=\"login-box\" class=\"login-box visible\">\r\n");
      out.write("\t\t\t\t\t<div class=\"widget-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"widget-main\">\r\n");
      out.write("\t\t\t\t\t\t\t<h4 class=\"header blue lighter bigger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"icon-coffee green\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\tPlease Enter Your Information\r\n");
      out.write("\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<form name=\"logonForm\" method=\"post\" action=\"logon.do\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"subTransCode\" value=\"logon\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"Username\" id=\"user_code\" name=\"user_code\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" placeholder=\"Password\" id=\"password\" name=\"password\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-lock\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"space\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"inline\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"ace\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"lbl\"> Remember Me</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button onclick=\"doSubmit();\" type=\"button\" class=\"width-35 pull-right btn btn-sm btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"icon-key\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tLogin\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"space-4\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div><!-- /widget-main -->\r\n");
      out.write("\t\t\t\t\t</div><!-- /widget-body -->\r\n");
      out.write("\t\t\t\t</div><!-- /login-box -->\r\n");
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
