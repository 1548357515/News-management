<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newsDetail.jsp' starting page</title>
 <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="page-header">
    <h1 align="center">
        <s:property value="%{news.title}"/>
    </h1>
     <h1 align="center">
       <small> 来源:<s:property value="%{news.author}"/>&nbsp;&nbsp;发布时间: <s:date name="news.issueTime"  format="yyyy-MM-dd HH:mm:ss" nice="false"/></small>
    </h1>
</div>
<p class="lead" >&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="%{news.content}"/></p>
  </body>
</html>
