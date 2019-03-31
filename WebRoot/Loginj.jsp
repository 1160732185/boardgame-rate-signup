<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
   <html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    }) 
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎来到boardgame桌游社区</span>    
    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
    <br/> 
    <%
    //声明错误提示语校验代码
    Object obj=request.getAttribute("error");
    if(obj!=null){
     %>
    <div style="text-align:center">
    <span style="font-size:15px;color:green;font-weight:bold">用户名或密码错误</span>
    </div>   
    <% } %>
    <div class="loginbox loginbox1">
    <form action="judger"method="post">
    <input type="hidden" name="oper" value="login" /> 
    <ul>
    <li><input name="jid" type="text" placeholder="用户名" class="loginuser" value="" /></li>
    <li><input name="jpassword" type="password" placeholder="密码" class="loginpwd" value="" /></li>
    <li class="yzm">
  
    </li>
    <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><a href="user/register.jsp">注册</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    <div class="loginbm">  10161851 干子雄    &nbsp &nbsp &nbsp &nbsp   仅供学习交流</div>
	
    
</body>

</html>