<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>用户注册</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.min.js" language="javascript" charset="utf-8"></script>
      <script type="text/javascript">
    $(document).ready(function(){
     var text="";
    text=$('#warn').val();
    if(text!=""){
    alert(text);
    }
    
    });
      function checkForm() {
         //判断两次密码输入是相同
    var username=""; 
    var password1="";
    var password2="";
    username=$('#username').val();
    password1=$('#password').val();
    password2=$('#password2').val();
    if(username==""){
    alert("用户名不能为空");
    return false;
    }
    if(password1==""){
    alert("密码不能为空");
    return false;
    }
    if(password2==""){
    alert("确认密码不能为空");
    return false;
    }
    if(password1!=password2){
    alert("两次密码输入不一致");
    	return false;
    } 
      }
    </script>
    <style>
.col-center-block {  
    float: none;  
    display: block;  
    margin-top:13%;
    margin-left: 50%;  
}  
</style>
  
    </head>
    <body background="${pageContext.request.contextPath}/img/bgImg.jpg">
<div class="container">  
  <div class="row myCenter">  
    <div class="col-xs-6 col-md-4 col-center-block">  
<div class="panel panel-default">
    <div class="panel-body">
      <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/login_userRegister.action"  method="post" onsubmit="return checkForm(); ">
            <br/>
        <h2 class="form-signin-heading" align="center">用户注册</h2>  
              <br/>
        <input type="hidden" id="warn" value="${requestScope.msg}"/>
        <label for="username" class="sr-only">用户名</label>  
        <input type="text" id="username" name="username" class="form-control" placeholder="用户名" >    
        <br/>
        <label for="inputPassword" class="sr-only">密码</label>  
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" >  
         <br/>
          <label for="inputPassword" class="sr-only">确认密码</label>  
        <input type="password2" id="password2" name="password2" class="form-control" placeholder="确认密码" >  
         <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>  
      </form>  
      </div>
      </div>
    </div>  
  </div>  
</div>  

    </body>

</html>
