<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布新闻</title> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script  type="text/javascript"   src="${pageContext.request.contextPath}/js/jquery-1.10.2.js" ></script>
  <script>
  function checkForm() {
		// 校验新闻标题:
		// 获得新闻标题文本框的值:
		var title = $("#title").val();
		if (title == null || title == '') {
			alert("标题不能为空!");
			return false;
		}
       //校验新闻内容
       //获得新闻标题文本框的值
       var content=$("#content").val();
       if(content==null||content==''){
       alert("内容不能为空");
       return false;
       }
       //校验新闻来源
       //获取新闻来源文本框的值
       var author=$("#author").val();
       if(author==null||author==''){
       alert("新闻来源不能为空");
       return false;
       }
	}
  
  </script>
  <body>
  <div class="panel panel-default">
    <div class="panel-body">
    <h3>发布新闻:</h3>
    <s:form action="user_addNews.action"  namesapce="/admin" method="post" onsubmit="return checkForm();">
    <table border="1" width="860" cellspacing="0" cellpadding="6">
    <tr>
         <s:textfield  id="title"  name="news.title"  label="标题" />
         </tr>
          <tr>
          <s:select  name="news.category.id" list="categorys"   listKey="id" listValue="categoryName"  label="类型" />
         </tr> 
         <tr>
         <s:textarea  id="content"  name="news.content"    rows="10"  cols ="50" label="内容"/>
         </tr>
         <tr>
          <s:textfield  id="author"  name="news.author"  label="来源"/>
         </tr>
         <tr >
         <s:submit value="添加"/></tr>
         </table>
    </s:form>
   </div>
   </div>
  </body>
</html>
