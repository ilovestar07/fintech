package org.apache.jsp.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class actions_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/default/easyui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path);
      out.write("/easyui/themes/icon.css\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h2>ComboBox</h2>\r\n");
      out.write("\t<p>Click the buttons below to perform actions.</p>\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"margin:20px 0;\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"setvalue()\">SetValue</a>\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"alert($('#state').combobox('getValue'))\">GetValue</a>\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"$('#state').combobox('disable')\">Disable</a>\r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"$('#state').combobox('enable')\">Enable</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction setvalue(){\r\n");
      out.write("\t\t\t$.messager.prompt('SetValue','Please input the value(CO,NV,UT,etc):',function(v){\r\n");
      out.write("\t\t\t\tif (v){\r\n");
      out.write("\t\t\t\t\t$('#state').combobox('setValue',v);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<select id=\"state\" class=\"easyui-combobox\" name=\"state\" style=\"width:200px;\">\r\n");
      out.write("\t\t<option value=\"AL\">Alabama</option>\r\n");
      out.write("\t\t<option value=\"AK\">Alaska</option>\r\n");
      out.write("\t\t<option value=\"AZ\">Arizona</option>\r\n");
      out.write("\t\t<option value=\"AR\">Arkansas</option>\r\n");
      out.write("\t\t<option value=\"CA\">California</option>\r\n");
      out.write("\t\t<option value=\"CO\">Colorado</option>\r\n");
      out.write("\t\t<option value=\"CT\">Connecticut</option>\r\n");
      out.write("\t\t<option value=\"DE\">Delaware</option>\r\n");
      out.write("\t\t<option value=\"FL\">Florida</option>\r\n");
      out.write("\t\t<option value=\"GA\">Georgia</option>\r\n");
      out.write("\t\t<option value=\"HI\">Hawaii</option>\r\n");
      out.write("\t\t<option value=\"ID\">Idaho</option>\r\n");
      out.write("\t\t<option value=\"IL\">Illinois</option>\r\n");
      out.write("\t\t<option value=\"IN\">Indiana</option>\r\n");
      out.write("\t\t<option value=\"IA\">Iowa</option>\r\n");
      out.write("\t\t<option value=\"KS\">Kansas</option>\r\n");
      out.write("\t\t<option value=\"KY\">Kentucky</option>\r\n");
      out.write("\t\t<option value=\"LA\">Louisiana</option>\r\n");
      out.write("\t\t<option value=\"ME\">Maine</option>\r\n");
      out.write("\t\t<option value=\"MD\">Maryland</option>\r\n");
      out.write("\t\t<option value=\"MA\">Massachusetts</option>\r\n");
      out.write("\t\t<option value=\"MI\">Michigan</option>\r\n");
      out.write("\t\t<option value=\"MN\">Minnesota</option>\r\n");
      out.write("\t\t<option value=\"MS\">Mississippi</option>\r\n");
      out.write("\t\t<option value=\"MO\">Missouri</option>\r\n");
      out.write("\t\t<option value=\"MT\">Montana</option>\r\n");
      out.write("\t\t<option value=\"NE\">Nebraska</option>\r\n");
      out.write("\t\t<option value=\"NV\">Nevada</option>\r\n");
      out.write("\t\t<option value=\"NH\">New Hampshire</option>\r\n");
      out.write("\t\t<option value=\"NJ\">New Jersey</option>\r\n");
      out.write("\t\t<option value=\"NM\">New Mexico</option>\r\n");
      out.write("\t\t<option value=\"NY\">New York</option>\r\n");
      out.write("\t\t<option value=\"NC\">North Carolina</option>\r\n");
      out.write("\t\t<option value=\"ND\">North Dakota</option>\r\n");
      out.write("\t\t<option value=\"OH\" selected>Ohio</option>\r\n");
      out.write("\t\t<option value=\"OK\">Oklahoma</option>\r\n");
      out.write("\t\t<option value=\"OR\">Oregon</option>\r\n");
      out.write("\t\t<option value=\"PA\">Pennsylvania</option>\r\n");
      out.write("\t\t<option value=\"RI\">Rhode Island</option>\r\n");
      out.write("\t\t<option value=\"SC\">South Carolina</option>\r\n");
      out.write("\t\t<option value=\"SD\">South Dakota</option>\r\n");
      out.write("\t\t<option value=\"TN\">Tennessee</option>\r\n");
      out.write("\t\t<option value=\"TX\">Texas</option>\r\n");
      out.write("\t\t<option value=\"UT\">Utah</option>\r\n");
      out.write("\t\t<option value=\"VT\">Vermont</option>\r\n");
      out.write("\t\t<option value=\"VA\">Virginia</option>\r\n");
      out.write("\t\t<option value=\"WA\">Washington</option>\r\n");
      out.write("\t\t<option value=\"WV\">West Virginia</option>\r\n");
      out.write("\t\t<option value=\"WI\">Wisconsin</option>\r\n");
      out.write("\t\t<option value=\"WY\">Wyoming</option>\r\n");
      out.write("\t</select>\r\n");
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
