<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'content.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  <body style="background-color:#e9e9e9">
  <table align="center"  width="50%"> 
   <s:iterator value="newses" var="news" status="stu">
  <tr>
  <td>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">
	 <s:a href="index/dispalyDetailNews.action?nid=%{#news.id}" target="_blank"><s:property value="#news.title"/></s:a> 
		</h3>
	</div>
	<div class="panel-body">
	 <s:date name="#news.issueTime" format="yyyy-MM-dd HH:mm:ss" nice="false"/>
	</div>
</div>
</td>
</tr>
</s:iterator>

</table>
  </body>
</html>
