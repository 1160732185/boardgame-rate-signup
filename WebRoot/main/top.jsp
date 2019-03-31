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
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
	//退出功能
	$("#out").click(function(){
		var flag=window.confirm("你真的要退出嘛？");
		if(flag){
	//确认退出的话	
		window.top.location.href="player?oper=out";
		}
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
            
    <div class="topright">    
    <ul>
    <li><a href="javascript:void(0)" id="out">退出</a></li>
    </ul>
    <% if(session.getAttribute("player")!=null){ %>
    <div class="user">
    <span>玩家:<%=((Player)session.getAttribute("player")).getPid()%></span>
    </div> <%} %>   
    
    <% if(session.getAttribute("judger")!=null){ %>
    <div class="user">
    <span>裁判:<%=((Judger)session.getAttribute("judger")).getJid()%></span>
    </div> <%} %>   
    
    </div>

</body>
</html>