<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head> 
		<base href=<%= path%>/>
	    	<!-- basic styles -->
			<link rel="stylesheet" href="ace/css/bootstrap.min.css" />
			<link rel="stylesheet" href="ace/css/font-awesome.min.css" />
	
			<!--[if IE 7]>
			  <link rel="stylesheet" href="ace/css/font-awesome-ie7.min.css" />
			<![endif]-->
	
			<!-- page specific plugin styles -->
	
	
			<!-- ace styles -->
	
			<link rel="stylesheet" href="ace/css/ace.min.css" />
			<link rel="stylesheet" href="ace/css/ace-rtl.min.css" />
			<link rel="stylesheet" href="ace/css/ace-skins.min.css" />
	
			<!--[if lte IE 8]>
			  <link rel="stylesheet" href="ace/css/ace-ie.min.css" />
			<![endif]-->
	
			<!-- inline styles related to this page -->
	
			<!-- ace settings handler -->
	
			<script src="ace/js/ace-extra.min.js"></script>
	
			<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	
			<!--[if lt IE 9]>
			<script src="ace/js/html5shiv.js"></script>
			<script src="ace/js/respond.min.js"></script>
			<![endif]-->
			
			<!-- 多页签插件 -->
			<link rel="stylesheet" href="ace/plugins/yui/tabview.css" />
			<link rel="stylesheet" href="ace/plugins/yui/ace.css" />
	</head>
	<!-- basic scripts -->
	<!--[if !IE]> -->
	
	<script type="text/javascript">
		window.jQuery || document.write("<script src='ace/js/jquery-2.0.3.min.js'>"+"<"+"script>");
	</script>
	
	<!-- <![endif]-->
	
	<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='ace/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
	<![endif]-->
	
	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='ace/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
	</script>
	<script src="ace/js/bootstrap.min.js"></script>
	<script src="ace/js/typeahead-bs2.min.js"></script>
	
	<!-- page specific plugin scripts -->
	
	<!--[if lte IE 8]>
	  <script src="ace/js/excanvas.min.js"></script>
	<![endif]-->
	
	<!-- ace scripts -->
	
	<script src="ace/js/ace-elements.min.js"></script>
	<script src="ace/js/ace.min.js"></script>
	
	<!-- 多页签插件 -->
	<script src="ace/js/jquery-1.10.2.min.js"></script>
	<script src="ace/plugins/yui/yahoo-dom-event.js"></script>
	<script src="ace/plugins/yui/connection-min.js"></script>
	<script src="ace/plugins/yui/element-beta-min.js"></script>
	<script src="ace/plugins/yui/tabview-min.js"></script>
</html>