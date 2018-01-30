<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css">
<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function searchUser() {
		$("#userList").datagrid({
			url : "user.do?subTransCode=search&"+$("#userSearchForm").serialize(),
			ajaxGridOptions : {
				type : "POST"
			},
			title : "用户信息",
			fitColumns : true, //列自适应
			nowrap : false,//禁止文字自动换行
			loadMsg : '正在加载信息...',//当数据没有加载出来时显示的文字
			pagination : true,//是否有分页
			singleSelect : true,//是否单行选择
			pagePosition : 'bottom',//分页符在底部,可选参数为top，bottom，both
			pageSize : 10,//页大小，一页多少条数据
			rownumbers : true,
			pageList : [ 10, 20, 30 ],//一页可显示数据的条目
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ]
		});
	}
	function addUser() {
		$("#insertDialog").dialog({
			title : '新增',
			bgiframe : true,
			autoOpen : false,
			width : 780,
			resizable : false,
			href : "system/sysUser/addUser.jsp",
			modal : true,
			position : [ "center", "top" ],
			buttons : {
				"取消" : function() {
					$(this).dialog('close');
				}
			}
		});
	}
	function insertUser() {
		if ($("#insertUserForm").form('validate')) {
			$.ajax({
				type : "POST",
				dataType : 'json',
				url : "user.do?subTransCode=add",
				data : $("#insertUserForm").serialize(),
				success : function(result) {
					searchUser();
					alert("用户添加成功!");
					$("#insertDialog").dialog('close');
				}
			});
		}
	}
	function delUser() {
		var selected = $("#userList").datagrid("getSelected");
		if (selected!=null && selected!='null') {
			$.ajax({
				type : "POST",
				dataType : 'json',
				url : "user.do?subTransCode=del",
				data : "user_code=" + selected["userbean.user_code"],
				success : function(result) {
					searchUser();
					alert("用户删除成功!");
				}
			});
		}
	}
</script>
</head>
<body>
	<div class="easyui-panel" title="用户查询" style="width: 100%; padding: 3px; background: #F8F8FF;">
		<form id="userSearchForm" action="user.do">
			<table>
				<tr>
					<td>用户代码：</td>
					<td><input class="easyui-textbox" type="text" name="user_code" /></td>
					<td>用户名称：</td>
					<td><input class="easyui-textbox" type="text" name="user_name" /></td>
					<td>性别：</td>
					<td><select class="easyui-combobox" name="state" style="width: 80px;">
							<option value="AL">男</option>
							<option value="AK">女</option>
						</select>
					</td>
					<td>日期：</td>
					<td><input class="easyui-datebox" type="text" name="date" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="margin: 20px 0;"></div>
	<div id="toolbar" style="padding: 3px; height: auto">
		<a onclick="searchUser();" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true"></a> 
		<a onclick="addUser();" class="easyui-linkbutton" data-options="iconCls:'icon-add'" plain="true"></a> 
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" plain="true"></a> 
		<a onclick="delUser();" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" plain="true"></a>
	</div>
	<table id="userList" class="easyui-datagrid" title="用户信息" toolbar="#toolbar" style="width: 120%;">
		<thead>
			<tr>
				<th data-options="field:'userbean.user_code',width:80" width="100">用户代码</th>
				<th data-options="field:'userbean.user_name',width:80" width="100">用户名称</th>
				<th data-options="field:'userbean.sex',width:80" width="100">性别</th>
				<th data-options="field:'userbean.degree',width:80" width="100">学历</th>
				<th data-options="field:'userbean.id_type',width:80" width="100">证件类型</th>
				<th data-options="field:'userbean.id',width:80" width="100">证件号</th>
				<th data-options="field:'userbean.tel',width:80" width="100">电话号码</th>
				<th data-options="field:'userbean.email',width:80" width="100">邮箱</th>
				<th data-options="field:'userbean.fax',width:80" width="100">传真</th>
				<th data-options="field:'userbean.qq',width:80" width="100">QQ</th>
				<th data-options="field:'userbean.postcode',width:80" width="100">邮编</th>
				<th data-options="field:'userbean.adress',width:80" width="100">地址</th>
				<th data-options="field:'userstatusbean.user_status',width:80" width="100">用户状态</th>
				<th data-options="field:'userstatusbean.logon_status',width:80" width="100">登录状态</th>
				<th data-options="field:'userstatusbean.pass_modify_date',width:80" width="100">最后修改时间</th>
			</tr>
		</thead>
	</table>
	<div id="insertDialog"></div>
</body>
</html>