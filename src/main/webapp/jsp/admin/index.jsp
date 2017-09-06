<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath}/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- /. WRAPPER  -->
        
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	 
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath}/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/morris/morris.js"></script>
	
	
	<script src="${pageContext.request.contextPath}/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/easypiechart-data.js"></script>
	
	
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath}/assets/js/custom-scripts.js"></script>
    
</head>
<script>
  	function setCategoryList() {
		$.post(
			"${pageContext.request.contextPath}/admin/user_setCategoryList.action",
			{},
			function(data) {
		
		});
	}
  </script>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><i class="fa fa-comments"></i> <strong>MASTER </strong></a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
            	
                <!-- 
         
                -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <!--<i class="fa fa-user fa-fw"></i>--> 
           
                        <%=session.getAttribute("username") %> <i class="fa fa-caret-down"></i>
                        
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="${pageContext.request.contextPath}/admin/login_loginUserPage.action" id="quit"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
		<!--<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>-->
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    
					<!--
                    	描述：类型管理
                    -->
                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i>类型管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/user_listCategoryAdmin.action" target="mainframe">类型查看</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/user_categoryAdd.action" target="mainframe">类型发布</a>
                            </li>
                        </ul>
                        
                    </li>
                    
                    <!--
                    	描述：新闻管理
                    -->
                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> 新闻管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/user_listNews.action"    onClick="setCategoryList()" target="mainframe">新闻查看</a>
                            </li>
                             <li>
                            <a href="${pageContext.request.contextPath}/admin/user_newsAdd.action"  target="mainframe">新闻发布</a>
                            </li>
                        </ul>
                        
                    </li>
         
                </ul>

            </div>

        </nav>                
        <div id="page-wrapper">
        	     
            <div id="page-inner">
		
				<!--
                	作者：447235746@qq.com
                	时间：2016-07-05
                	描述：表格行
                -->
              <div >
            <iframe  src="${pageContext.request.contextPath}/admin/user_listCategoryAdmin.action"  name="mainframe"  style="width:100%;height:100%;border:0 ;"></iframe>
              </div>
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>

   
</body>

</html>