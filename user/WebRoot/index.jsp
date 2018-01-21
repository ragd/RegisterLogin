<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath }/images/favicon.ico"/>
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.ico">
    <title>首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/bootstrap/css/index.css" rel="stylesheet">
  </head>
  
  <body>
 	
  	<div class="navbar navbar-default" id="navigation">
	  		<ul class="nav navbar-nav" id="nav_font">
	  			<li><img src="${pageContext.request.contextPath }/images/logo.svg" id="logo" /></li>
	    		<li><a href="##">首页</a></li>
	    		<li><a href="##">导入</a></li>
				<li><a href="##">查询</a></li>
				<li><a href="##">月度统计</a></li>
				<li><a href="##">年度报表</a></li>
				<li><a href="##">分析预测</a></li>
				<li><a href="##">计算增值税</a></li>
				<li><a href="##">帮助</a></li>
	  		</ul>
	  		<div class="navbar-right" id="nav_child">
	  		<c:if test="${user!=null }">
  				欢迎您：${user.username }		
  				<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
  			</c:if>
  			<c:if test="${user==null }">
	  			<button type="button" class="btn btn-default navbar-btn" onclick="window.open('${pageContext.request.contextPath }/servlet/RegisterUIServlet','_self')">注册</button>
	  			|
	      		<button type="button" class="btn btn-default navbar-btn" onclick="window.open('${pageContext.request.contextPath }/servlet/LoginUIServlet','_self')">登录</button>
	   		</c:if>
	   		</div>
		</div>
		<div id="text">
			<h1><b>企业增值税发票数据分析系统</b></h1>
			<small id="design"><i>Design By Pirates</i></small>
		</div>  
    
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.2.1.min.js"></script>
  	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
