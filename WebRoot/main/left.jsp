<%@ page language="java" import="java.util.*,bg.pojo.*" pageEncoding="UTF-8"%>
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
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#fff3e1;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>我能做的事儿
    </div>
    	<ul class="menuson">
         <% if(session.getAttribute("player")!=null){ %>
        <li><cite></cite><a href="user/userinfo.jsp" target="rightFrame">查看个人信息</a><i></i></li>
        <li><cite></cite><a href="player?oper=showrate" target="rightFrame">查看我的评价</a><i></i></li>
        <li><cite></cite><a href="player?oper=show" target="rightFrame">为桌游评分</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">选购新桌游</a><i></i></li>
        <li><cite></cite><a href="player?oper=sign" target="rightFrame">报名参赛</a><i></i></li>
        <li><cite></cite><a href="player?oper=sit" target="rightFrame">加入比赛桌</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">查看我的战绩</a><i></i></li>
         <% } %>
          <% if(session.getAttribute("judger")!=null){ %>
        <li><cite></cite><a href="judger?oper=supervise" target="rightFrame">监管比赛桌</a><i></i></li>
        <li><cite></cite><a href="judger?oper=score" target="rightFrame">为玩家结算分数</a><i></i></li>
          <% } %>
        </ul>    
    </dd>
            
    </dl>
    
</body>
</html>
