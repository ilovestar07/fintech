package org.apache.jsp.system.sysUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/icon.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction searchUser() {\r\n");
      out.write("\t\t$(\"#userList\").datagrid({\r\n");
      out.write("\t\t\turl : \"user.do?subTransCode=search&\"+$(\"#userSearchForm\").serialize(),\r\n");
      out.write("\t\t\tajaxGridOptions : {\r\n");
      out.write("\t\t\t\ttype : \"POST\"\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ttitle : \"用户信息\",\r\n");
      out.write("\t\t\tfitColumns : true, //列自适应\r\n");
      out.write("\t\t\tnowrap : false,//禁止文字自动换行\r\n");
      out.write("\t\t\tloadMsg : '正在加载信息...',//当数据没有加载出来时显示的文字\r\n");
      out.write("\t\t\tpagination : true,//是否有分页\r\n");
      out.write("\t\t\tsingleSelect : true,//是否单行选择\r\n");
      out.write("\t\t\tpagePosition : 'bottom',//分页符在底部,可选参数为top，bottom，both\r\n");
      out.write("\t\t\tpageSize : 10,//页大小，一页多少条数据\r\n");
      out.write("\t\t\trownumbers : true,\r\n");
      out.write("\t\t\tpageList : [ 10, 20, 30 ],//一页可显示数据的条目\r\n");
      out.write("\t\t\tfrozenColumns : [ [ {\r\n");
      out.write("\t\t\t\tfield : 'ck',\r\n");
      out.write("\t\t\t\tcheckbox : true\r\n");
      out.write("\t\t\t} ] ]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addUser() {\r\n");
      out.write("\t\t$(\"#insertDialog\").dialog({\r\n");
      out.write("\t\t\ttitle : '新增',\r\n");
      out.write("\t\t\tbgiframe : true,\r\n");
      out.write("\t\t\tautoOpen : false,\r\n");
      out.write("\t\t\twidth : 780,\r\n");
      out.write("\t\t\tresizable : false,\r\n");
      out.write("\t\t\thref : \"system/sysUser/addUser.jsp\",\r\n");
      out.write("\t\t\tmodal : true,\r\n");
      out.write("\t\t\tposition : [ \"center\", \"top\" ],\r\n");
      out.write("\t\t\tbuttons : {\r\n");
      out.write("\t\t\t\t\"取消\" : function() {\r\n");
      out.write("\t\t\t\t\t$(this).dialog('close');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction insertUser() {\r\n");
      out.write("\t\tif ($(\"#insertUserForm\").form('validate')) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\turl : \"user.do?subTransCode=add\",\r\n");
      out.write("\t\t\t\tdata : $(\"#insertUserForm\").serialize(),\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\tsearchUser();\r\n");
      out.write("\t\t\t\t\talert(\"用户添加成功!\");\r\n");
      out.write("\t\t\t\t\t$(\"#insertDialog\").dialog('close');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction delUser() {\r\n");
      out.write("\t\tvar selected = $(\"#userList\").datagrid(\"getSelected\");\r\n");
      out.write("\t\tif (selected!=null && selected!='null') {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\turl : \"user.do?subTransCode=del\",\r\n");
      out.write("\t\t\t\tdata : \"user_code=\" + selected[\"userbean.user_code\"],\r\n");
      out.write("\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\tsearchUser();\r\n");
      out.write("\t\t\t\t\talert(\"用户删除成功!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-panel\" title=\"用户查询\" style=\"width: 100%; padding: 3px; background: #F8F8FF;\">\r\n");
      out.write("\t\t<form id=\"userSearchForm\" action=\"user.do\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>用户代码：</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"user_code\" /></td>\r\n");
      out.write("\t\t\t\t\t<td>用户名称：</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"user_name\" /></td>\r\n");
      out.write("\t\t\t\t\t<td>性别：</td>\r\n");
      out.write("\t\t\t\t\t<td><select class=\"easyui-combobox\" name=\"state\" style=\"width: 80px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AL\">男</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"AK\">女</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>日期：</td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-datebox\" type=\"text\" name=\"date\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"margin: 20px 0;\"></div>\r\n");
      out.write("\t<div id=\"toolbar\" style=\"padding: 3px; height: auto\">\r\n");
      out.write("\t\t<a onclick=\"searchUser();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\" plain=\"true\"></a> \r\n");
      out.write("\t\t<a onclick=\"addUser();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" plain=\"true\"></a> \r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\" plain=\"true\"></a> \r\n");
      out.write("\t\t<a onclick=\"delUser();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\" plain=\"true\"></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table id=\"userList\" class=\"easyui-datagrid\" title=\"用户信息\" toolbar=\"#toolbar\" style=\"width: 120%;\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.user_code',width:80\" width=\"100\">用户代码</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.user_name',width:80\" width=\"100\">用户名称</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.sex',width:80\" width=\"100\">性别</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.degree',width:80\" width=\"100\">学历</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.id_type',width:80\" width=\"100\">证件类型</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.id',width:80\" width=\"100\">证件号</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.tel',width:80\" width=\"100\">电话号码</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.email',width:80\" width=\"100\">邮箱</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.fax',width:80\" width=\"100\">传真</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.qq',width:80\" width=\"100\">QQ</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.postcode',width:80\" width=\"100\">邮编</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userbean.adress',width:80\" width=\"100\">地址</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userstatusbean.user_status',width:80\" width=\"100\">用户状态</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userstatusbean.logon_status',width:80\" width=\"100\">登录状态</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'userstatusbean.pass_modify_date',width:80\" width=\"100\">最后修改时间</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"insertDialog\"></div>\r\n");
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
