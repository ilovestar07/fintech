package org.apache.jsp.system.sysUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function searchUser() {\r\n");
      out.write("\t$(\"#userList\").datagrid({\r\n");
      out.write("\turl:\"user.do?subTransCode=search\",\r\n");
      out.write("    ajaxGridOptions: {type:\"POST\"},\r\n");
      out.write("\ttitle:\"用户信息\",\r\n");
      out.write("    fitColumns: true, //列自适应\r\n");
      out.write("    nowrap: false,//禁止文字自动换行\r\n");
      out.write("    loadMsg: '正在加载信息...',//当数据没有加载出来时显示的文字\r\n");
      out.write("    pagination: true,//是否有分页\r\n");
      out.write("    singleSelect: true,//是否单行选择\r\n");
      out.write("    pagePosition: 'bottom',//分页符在底部,可选参数为top，bottom，both\r\n");
      out.write("    pageSize: 10,//页大小，一页多少条数据\r\n");
      out.write("    pageNumber: 1,//默认当前的页码\r\n");
      out.write("    rownumbers:true,\r\n");
      out.write("    pageList: [10, 20, 30],//一页可显示数据的条目\r\n");
      out.write("\tcolumns: [[\r\n");
      out.write("\t\t{ title:'用户代码',field:'user_code',width:100,halign:'center' },\r\n");
      out.write("\t\t{ title:'用户名称',field:'user_name',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'性别',field:'sex',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'年龄',field:'degree',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'证件类型',field:'id_type',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'证件号',field:'id',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'电话号码',field:'tel',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'邮箱',field:'email',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'传真',field:'fax',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'QQ',field:'qq',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'邮编',field:'postcode',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'地址',field:'adress',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'用户状态',field:'user_status',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'登录状态',field:'logon_status',width:80,align:'right',halign:'center'},\r\n");
      out.write("\t\t{ title:'最后修改时间',field:'pass_modify_date',width:80,align:'right',halign:'center'}\r\n");
      out.write("\t]]\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("function addUser() {\r\n");
      out.write("\t$(\"#insert\").dialog({\r\n");
      out.write("\t\ttitle:'新增',\r\n");
      out.write("\t\tbgiframe: true,\r\n");
      out.write("\t\tautoOpen: false,\r\n");
      out.write("\t\twidth: 780,\r\n");
      out.write("\t\tresizable: false,\r\n");
      out.write("\t\tmodal: true,\r\n");
      out.write("\t\tposition:[\"center\",\"top\"],\r\n");
      out.write("\t\tbuttons: {\r\n");
      out.write("\t\t\t\"取消\": function() {\r\n");
      out.write("\t    \t\t$(this).dialog('close');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-panel\" title=\"用户查询\" style=\"width: 100%;padding:3px;background:#F8F8FF;\">\r\n");
      out.write("\t\t<form id=\"userSearchForm\" action=\"user.do\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>用户代码：<input class=\"easyui-textbox\" type=\"text\" name=\"planNumber\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td>用户名称：<input class=\"easyui-textbox\" type=\"text\" name=\"planName\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td>性别：<select class=\"easyui-combobox\" name=\"state\" style=\"width:80px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"AL\">男</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"AK\">女</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"searchUser\" onclick=\"searchUser();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\" style=\"width:80px\">查询</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a id=\"addUser\" onclick=\"addUser();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" style=\"width:80px\">新增</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">Remove</a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-save'\">Save</a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-cut',disabled:true\">Cut</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tfoot>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"margin:20px 0;\"></div>\r\n");
      out.write("\t<table id=\"userList\" style=\"width: 120%;\"></table>\r\n");
      out.write("\t\r\n");
      out.write("\t<div align=\"center\" id=\"insert\">\r\n");
      out.write("\t\t\t<form id=\"insert\">\r\n");
      out.write("\t\t\t\t<table class=\"commonTable\" width=\"823\" height=\"178\">\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
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
