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
  </head>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <body>
<div class="panel panel-default">
    <div class="panel-body" align="center">
    <s:form action="user_findSameNewsByCategory.action"  namesapce="/admin" method="post">
      <table>
      <tr>
       <td><s:select  name="news.category.id"  list="%{#session.categorys}"   listKey="id" listValue="categoryName"  label="类型"  theme ="simple"/></td>
       <td><button type="submit" class="btn btn-default">查看新闻</button></td>
       </tr>
       </table> 
    </s:form>
    </div>
    <table border="1" width="100%" cellspacing="0" cellpadding="6">
        <tr  align="center">
            <td >序号</td>
            <td>标题</td>
            <td>发布时间</td>
            <td>类型</td>
             <td>操作</td>
        </tr>
        <s:iterator value="newses" var="news" status="stu">
          　<tr align="center">
                   <td width="60"><s:property value="#stu.count"/></td>
                   <td width="400"><s:a href="admin/user_findNewsDetails.action?nid=%{#news.id}"><s:property value="#news.title"/></s:a></td>
                   <td width="200"><s:date name="#news.issueTime"  format="yyyy-MM-dd HH:mm:ss" nice="false" /></td>
                    <td width="100"><s:property value="#news.category.categoryName"/></td>
                   <td width="100"><s:a href="admin/user_updateNews.action?nid=%{#news.id}" >修改</s:a>
                   <s:a href="admin/user_deleteNews.action?nid=%{#news.id}">删除</s:a></td>
              </tr>
        </s:iterator>
    </table>
</div>
 <div style="width:400px;height:100px;margin:0 auto">
     <ul class="pagination pagination-lg " style="width:100%;">
    <li>
    <s:a href="admin/user_listNews.action?currentPage=%{#session.currentPage-1}">&laquo;</s:a>
    </li>
       <s:iterator value="pages"  status="stu">
    <li><s:a href="admin/user_listNews.action?currentPage=%{#stu.count}"><s:property value="#stu.count"/></s:a></li>
    </s:iterator>
    <li>
    <s:a href="admin/user_listNews.action?currentPage=%{#session.currentPage+1}">&raquo;</s:a>
    </li>  
</ul><br>
</div>
  </body>
</html>
