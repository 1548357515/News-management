<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新闻管理系统主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lanrenzhijia.css" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.min.js" language="javascript" charset="utf-8"></script>

  </head>
  <script type="text/javascript">
jQuery(document).ready(function($) {
	$('.theme-login').click(function(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	});
	$('.theme-poptit .close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	});

});
</script>
<style>
body {
    overflow-x : hidden;   去掉横条
     overflow-y : hidden;   去掉竖条
   background-color:#e9e9e9;
}
</style>
  <body   >
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header center-block" >
      <h1 style="position:relative; float:left;left:260px;">新闻大爆炸</h1>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${pageContext.request.contextPath}/jsp/register.jsp"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
      <li><a href="${pageContext.request.contextPath}/admin/login_loginUserPage.action"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
    </ul>
  </div>
  <div class="row">
  <ul class="nav nav-pills col-md-6 col-md-offset-3"  >
  <li><s:a href="index/listNewNews.action"  target="mainframe">首页</s:a></li>
    <s:iterator value="categorys" var="category" status="stu">
	<li><s:a href="index/listNewsByCid.action?cid=%{#category.id}"  target="mainframe"><s:property value="#category.categoryName"/></s:a></li>
  </s:iterator>
</ul>
<div>
<div style="position:relative; float:left;left:0px;top:5px;">
<a class="btn btn-default btn-large theme-login" href="javascript:;">时间范围查询</a>
</div>
<div>
		<form class="navbar-form navbar-left"  action="index/likeTitle.action"  method="post">
			<div class="form-group">
				<input type="text"  name="title"  class="form-control"  placeholder="Search"/>
                	</div>
			<button type="submit" class="btn btn-default">提交</button>
		</form>
	</div>
	</div>
	</div>
</nav>
<div class="theme-popover">
     <div class="theme-poptit">
          <a href="javascript:;" title="关闭" class="close">×</a>
     </div>
     <div class="theme-popbod dform">
           <form class="theme-signin"  action="index/selectByTime.action" method="post">
                <ol>           
                <li><h2>按时间查询</h2></li>   
        <li><input id="startTime"  name="startTime" type="datetime-local" /></li>
        <li><input id="endTime"   name="endTime" type="datetime-local" /></li>
                     <li ><button class="btn btn-primary " type="submit"  style="width:170px;" name="submit" >查询 </button></li>
                </ol>
           </form>
     </div>
</div>
<div class="theme-popover-mask"></div>
  <div id="content" style="height:1000px;width:100%; overflow-y : hidden;">
            <iframe src="index/listNewNews.action" name="mainframe" style="position:relative;width:100%;height:100% ;border:0 ;"  ></iframe>
            </div>
</body>
</html>