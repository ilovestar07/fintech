<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript">
</script>
</head>
<body>
	<div>
		<form id="insertUserForm" action="user.do">
			<table>
				<tbody>
					<tr>
						<td align="right">用户代码：</td>
						<td><input class="easyui-validatebox textbox" name="user_code" data-options="required:true,validType:'length[6,32]'"/></td>
						<td align="right">用户名称：</td>
						<td><input class="easyui-validatebox textbox" name="user_name" data-options="required:true,validType:'length[2,64]'"/></td>
						<td align="right">性别：</td>
						<td><input class="easyui-validatebox textbox" name="sex" /></td>
						<td align="right">学历：</td>
						<td><input class="easyui-validatebox textbox" name="degree" /></td>
					</tr>
					<tr>
						<td align="right">证件类型：</td>
						<td><input class="easyui-validatebox textbox" name="id_type" /></td>
						<td align="right">证件号：</td>
						<td><input class="easyui-validatebox textbox" name="id" /></td>
						<td align="right">邮箱：</td>
						<td><input class="easyui-validatebox textbox" name="email" data-options="validType:'email'"/></td>
						<td align="right">传真：</td>
						<td><input class="easyui-validatebox textbox" name="fax" /></td>
					</tr>
					<tr>
						<td align="right">QQ：</td>
						<td><input class="easyui-validatebox textbox" name="qq" /></td>
						<td align="right">邮编：</td>
						<td><input class="easyui-validatebox textbox" name="postcode" /></td>
						<td align="right">地址：</td>
						<td><input class="easyui-validatebox textbox" name="adress" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="8" align="center">
							<a id="saveUser" onclick="insertUser();" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="width:80px">保存</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>