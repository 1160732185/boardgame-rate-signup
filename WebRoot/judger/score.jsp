<%@ page language="java" import="java.util.*,bg.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">信息管理</a></li>
    <li><a href="#">查看个人信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>比赛桌号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>玩家号</th>
        <th>操作</th>
        </tr>
 </thead>
        <tbody>
        <%
        	List<Scoring> ls=(ArrayList<Scoring>)request.getAttribute("ls");
                        for(Scoring s:ls){ 
        %>
        <tr>
        <td><%=s.getTano() %></td>
        <td><%=s.getPno() %></td>
        <td> <form action="judger" method="post">
		<input type="hidden" name="oper" value="doscore"/>
		<input type="hidden" name="tano" value="<%=s.getTano()%>"/>
		<input type="hidden" name="pno" value="<%=s.getPno()%>"/>
		<input name="score" class="easyui-validatebox textbox">
		<input type="submit" class="ibtn" value="录入分数~"/>
		</form> </td>
        <% } %> 
           </tr> 
        </tbody>
 