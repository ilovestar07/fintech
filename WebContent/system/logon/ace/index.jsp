<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>控制台 </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@ include file="/system/logon/ace/public.jsp" %>
		<style>
		    body, html{ height:100%; width:100%; overflow: hidden }
		</style>
	</head>
	<body>
		<table id="frametable" cellpadding="0" cellspacing="0" width="100%" height="100%">
		    <tr>
		        <td colspan="2" height="45">
					<%@ include file="/system/logon/ace/header.jsp" %>
				</td>
			</tr>
			<tr>
		        <td valign="top" width="190" height="100%">
		            <div class="left">
		            	<%@ include file="/system/logon/ace/sysMenu.jsp" %>
		            </div>
		        </td>
		        <td valign="top" width="100%" height="100%">
		        	<iframe id="iframe" name="main" src="system/logon/ace/sysTab.jsp" width="100%" 
                    height="100%" frameborder="0" scrolling="no"></iframe>
		        </td>
	      	</tr>
        </table>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</body>
</html>