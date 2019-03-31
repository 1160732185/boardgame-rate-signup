<%@ page language="java" import="java.util.*,bg.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dorate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% System.out.println("88"+request.getAttribute("gno")); %>
  目前正在评分的桌游: <%= request.getAttribute("gname") %>
  <form action="player" method="post">
  <ul class="forminfo">
<li>
<select name="score">
<option>-请选择-</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
</li>
	<li><input type="submit" value="确认提交~"/>
	 <input type="hidden" name="oper" value="dorate"/>
	 <input type="hidden" name="gno" value="<%=request.getAttribute("gno")%>"/>
	  </li> </ul> </form>
  </body>
</html>
