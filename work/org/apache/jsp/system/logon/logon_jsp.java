package org.apache.jsp.system.logon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase
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

response.setHeader("Cache-Control", "no-store"); //HTTP 1.1 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //保证每次对页面的访问都是最新的
String path = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>登录</title>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/icon.css\">\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\t\t<!--[if IE 6]>  \r\n");
      out.write("\t\t\t<script type=\"text/javascript\" src=\"images/DD_belatedPNG.js\" ></script>   \r\n");
      out.write("\t\t\t<script type=\"text/javascript\">   \r\n");
      out.write("\t\t\t\tDD_belatedPNG.fix('.bank_logo,.sys_name,.loginbox,.btnbox .btn_login,.btnbox .btn_clear,.btnbox .btn_login:hover,.btnbox .btn_clear:hover');   \r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t<style type=\"text/css\">\r\n");
      out.write("            .loginbox .inputbox{ margin:22px 0 0 33px;}\r\n");
      out.write("        \t</style>\r\n");
      out.write("\t\t<![endif]-->\r\n");
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
      out.write("\t<body onload=\"\" >\r\n");
      out.write("\t\t<div align=\"center\" style=\"width: 100%;height: 100%;margin-top: 15%;\">\r\n");
      out.write("\t\t\t<form name=\"logonForm\" method=\"post\" action=\"logon.do\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"subTransCode\" value=\"logon\">\r\n");
      out.write("\t\t\t\t<div class=\"easyui-panel\" title=\"Login to system\" align=\"center\" style=\"width:400px;padding:30px 70px 20px 70px;\">\r\n");
      out.write("\t\t\t\t\t<div style=\"margin-bottom:10px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" value=\"admin\" id=\"user_code\" name=\"user_code\" style=\"width:100%;height:40px;padding:12px\" data-options=\"prompt:'Username',iconCls:'icon-man',iconWidth:38\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" value=\"123456\" id=\"password\" name=\"password\" type=\"password\" style=\"width:100%;height:40px;padding:12px\" data-options=\"prompt:'Password',iconCls:'icon-lock',iconWidth:38\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"checkbox\" checked=\"checked\">\r\n");
      out.write("\t\t\t\t\t\t<span>Remember me</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" onclick=\"doSubmit();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-ok'\" style=\"padding:5px 0px;width:100%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span style=\"font-size:14px;\">Login</span>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
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
