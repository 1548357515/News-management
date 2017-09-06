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
    
    <title>My JSP 'categosyList.jsp' starting page</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  <h1>查看新闻类型</h1>
    <table class="table table-hover" >
    <thead>
        <tr  align="center">
            <th>序号</th>
            <th>类型名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="categorys" var="category" status="stu">
          　<tr align="center">
                   <td width="60"><s:property value="#stu.count"/></td>
                   <td width="120"><s:property value="#category.categoryName"/></td>
                   <td><s:a href="admin/user_updateCategory.action?cid=%{#category.id}">修改</s:a>
                   <s:a href="admin/user_deleteCategory.action?cid=%{#category.id}">删除</s:a></td>
              </tr>
        </s:iterator>
        </tbody>
    </table>
  </body>
</html>
