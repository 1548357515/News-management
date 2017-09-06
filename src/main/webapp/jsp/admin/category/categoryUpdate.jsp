<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'categoryUpdate.jsp' starting page</title>
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
      <div class="panel panel-default">
    <div class="panel-body">
    <h3>更新新闻类型</h3>
    <s:form action="user_updatedCategory.action"  namesapce="/admin" method="post" class="form-inline" role="form">
       <s:hidden name="category.id"  value="%{category.id}"/>
          <div class="form-group">
       <label class="sr-only" for="name">名称</label>
       <input type="text" name="category.categoryName"  class="form-control"  style="width:200px;"/>
          </div>
            <div class="form-group">
       <button type="submit"   class="btn btn-default" >更新</button>
       </div>

    </s:form>
         </div>
       </div>
  </body>
</html>
