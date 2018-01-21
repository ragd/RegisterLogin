<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath }/images/favicon.ico"/>
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.ico">
    <title>网站全局消息显示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body background=http://image2.sina.com.cn/home/images/tz-001.gif>
    
    <table border=0 cellpadding=0 cellspacing=0 >
 		<tr><td height=134></td></tr>
	</table>
	<table width=544 height=157 border=0 cellpadding=0 cellspacing=0 align=center>
  		<tr valign=middle align=middle>
			<td>
	    		<table border=0 cellpadding=0 cellspacing=0 >
		 			<tr>
		 			    <a href="${pageContext.request.contextPath }/index.jsp">
		    				<img src="${pageContext.request.contextPath }/images/Pirate.png"/>
		    			</a>
		    			<td  style=padding-left:60px;padding-top:10px><strong>${message }</strong></td>
                 	</tr>
                 	<tr>
		    			<td  style=padding-left:100px;padding-top:10px><strong>（点击图片即可返回首页 ^_^）</strong></td>
                 	</tr>
            	</table>
			</td>
  		</tr>
	</table>
	<br>
    
    <script src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.2.1.min.js"></script>
  	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
