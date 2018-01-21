<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath }/images/favicon1.ico"/>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon1.ico">
    	<title>用户登录</title>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath }/bootstrap/css/login.css" rel="stylesheet">
	</head>

	<body>
		<div class="container">
    		<div class="box">
        		<div class="login-box">
            		<div class="login-title text-center">
                		<h1>
                    		<small>欢迎登录</small>
                		</h1>
            		</div>

            		<div class="login-content" >
                		<form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post" class="form" id="logform">
                    		<div class="form-group">
                        		<div class="col-xs-12">
                            		<div class="input-group">
                                		<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                		<input  class="form-control" placeholder="用户名" name="username" id="user" >
                            		</div>
                        		</div>
                    		</div>
                    		<div class="form-group">
                        		<div class="col-xs-12  ">
                            		<div class="input-group">
                                		<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                		<input type="password" class="form-control" placeholder="密码" name="password" id="password" >
                            		</div>
                        		</div>
                    		</div>

                    		<div class="col-xs-12 text-center">
                    			<button class="btn btn-sm btn-info col-xs-4"  style="margin-right:70px;margin-left:40px;margin-top:10px" type="submit">登 录</button>
                        		<button class="btn btn-sm btn-info col-xs-4"  style="margin-top:10px"  type="button" onclick="javascript:window.location.href='${pageContext.request.contextPath }/servlet/RegisterUIServlet'">注 册</button>	
                    		</div>
                		</form>
            		</div>
        		</div>
    		</div>
		</div>
	</body>
</html>