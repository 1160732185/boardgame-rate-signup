<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>Basic ValidateBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="用户注册" style="width:800px;padding:10px 60px 20px 60px">
		<form action="player" method="post">
		<input type="hidden" name="oper" value="register"/>
		<table cellpadding="5">
			<tr>
				<td>用户名:</td>
				<td><input name="pid" class="easyui-validatebox textbox" data-options="required:true"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input name="password" class="easyui-validatebox textbox" data-options="required:true"></td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td><input name="realname" class="easyui-validatebox textbox"></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><input name="mobile" class="easyui-validatebox textbox" data-options="required:true"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="注册~"/> 
				</td>
			</tr>
		</table>
		</form>
	</div>
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>

</body>
</html>