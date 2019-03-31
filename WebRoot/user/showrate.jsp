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
    <%
    //声明错误提示语校验代码
    Object obj=request.getAttribute("error");
    if(obj!=null){
     %>
    <div style="text-align:center">
    <span style="font-size:15px;color:green;font-weight:bold">你已经评价过这个桌游了！</span>
    </div>   
    <% } %>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>桌游编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>我的评分</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
        	List<Rate> lr=(ArrayList<Rate>)request.getAttribute("lr");
                        for(Rate r:lr){ 
        %>
        <tr>
        <td><%=r.getGno() %></td>
        <td><%=r.getRate() %></td>
            <td> <form action="player" method="post">
		<input type="hidden" name="oper" value="deleterate"/>
		<input type="hidden" name="gno" value="<%=r.getGno()%>"/>
		<input type="submit" class="ibtn" value="删除~"/> 
	
		 </td>

        <% } %> 
           </tr> 
        </tbody>
    </table>
    
   
   
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
