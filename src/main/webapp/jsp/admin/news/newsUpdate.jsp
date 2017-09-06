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

  </head>
  
  <body>
    <h3>修改新闻:</h3>
    <s:form action="user_updatedNews.action"  namespace="/admin" method="post">
      <table border="1" width="860" cellspacing="0" cellpadding="6">
       <s:hidden name="news.id"  value="%{news.id}"/>
    <tr >
         <s:textfield name="news.title"  value="%{news.title}" label="标题"/>
         </tr>
         <tr>
          <s:select  name="news.category.id"  list="%{#session.categorys}"   listKey="id" listValue="categoryName"  value="%{news.categoryName}" label="类型" />
         </tr> 
         <tr>
         <s:textarea  rows="10"  cols="100" name="news.content"  value="%{news.content}" label="内容"/>
         </tr>
         <tr>
          <s:textfield name="news.author"  value="%{news.author}" label="来源"/>
         </tr>
         <tr >
       <s:submit value="更新"/>
       </tr>
                </table>
    </s:form>
  </body>
</html>
