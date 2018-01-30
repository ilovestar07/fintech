<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.fintech.util.constant.SysConstant"%>
<%
	String tree = (String) request.getSession().getAttribute(SysConstant.SYS_MENU_TREE);
%>
<!DOCTYPE html>
<html>
	<script src="system/logon/ace/sysMenu.js"></script>
	<script type="text/javascript">
		$(window).on('load', function () {
			$('#menuTree').sidebarMenu({
				data : <%=tree%>
			});
		})
	</script>
	<body>
		<div class="sidebar" id="sidebar">
			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="icon-signal"></i>
					</button>
		
					<button class="btn btn-info">
						<i class="icon-pencil"></i>
					</button>
		
					<button class="btn btn-warning">
						<i class="icon-group"></i>
					</button>
		
					<button class="btn btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>
		
				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span>
		
					<span class="btn btn-info"></span>
		
					<span class="btn btn-warning"></span>
		
					<span class="btn btn-danger"></span>
				</div>
			</div><!-- #sidebar-shortcuts -->
	
			<ul class="nav nav-list" id="menuTree">
			</ul><!-- /.nav-list -->
	
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
			</div>
		</div>
	</body>
</html>