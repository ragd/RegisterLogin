<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <link rel="bookmark" type="image/x-icon" href="${pageContext.request.contextPath }/images/favicon1.ico"/>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon1.ico">
    	<title>用户注册</title>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath }/bootstrap/css/register.css" rel="stylesheet">
	</head>

	<body>
		<div class="container">
    		<div class="box">
        		<div class="register-box">
            		<div class="register-title text-center">
                		<h1>
                    		<small>用 户 注 册</small>
                		</h1>
            		</div>

            		<div class="register-content" >
                		<form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post" class="form" 
                        id="logform">

                            <div class="form-group">
                                <div class="col-xs-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input  type="text" class="form-control" placeholder="登录账号" name="username" 
                                        value="${form.username }" id="user">
                                    </div>                                    
                                </div>
                                <div class="col-xs-3">
                                    <span class="message">${form.errors.username }</span>
                                </div>
                            </div>

                    		<div class="form-group">
                        		<div class="col-xs-9">
                            		<div class="input-group">
                                		<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                		<input type="password" class="form-control" placeholder="输入密码" name="password" 
                                        id="password" >
                            		</div>
                        		</div>
                                <div class="col-xs-3">
                                    <span class="message">${form.errors.password }</span>
                                </div>
                    		</div>
                            
                            <div class="form-group">
                                <div class="col-xs-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" class="form-control" placeholder="确认密码" name="password2" 
                                        id="password2" >
                                    </div>
                                </div>
                                <div class="col-xs-3">
                                    <span class="message">${form.errors.password2 }</span>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                                        <input type="text" class="form-control" placeholder="电子邮箱" name="email" 
                                        value="${form.email }" id="email" >
                                    </div>
                                </div>
                                <div class="col-xs-3">
                                    <span class="message">${form.errors.email }</span>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                                        <input type="text" class="form-control" placeholder="手机号码" name="phonenumber" 
                                        value="${form.phonenumber }" id="phonenumber" >
                                    </div>
                                </div>
                                <div class="col-xs-3">
                                    <span class="message">${form.errors.phonenumber }</span>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-xs-7">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-check"></span></span>
                                        <input class="form-control" placeholder="图片认证" name="verifycode" id="verifyCode">
                                    </div>
                                </div>
                                <div class="col-xs-2">
                                    <a href="javascript:change()"><img src="${pageContext.request.contextPath }/servlet/VcodeServlet" id="vcodeImg" /></a>
                                </div>
                                <div class="col-xs-3">
                                    <span class="message">${form.errors.verifycode }</span>
                                </div>
                            </div>

                    		<div class="col-xs-12 text-center">
                    			<button class="btn btn-sm btn-info col-xs-3"  type="submit" name="submit">注 册</button>
                        		<button class="btn btn-sm btn-info col-xs-3"  style="margin-right:20px;margin-left:45px" type="reset" name="reset">重 置</button>
                    		</div>
                		</form>
            		</div>
        		</div>
    		</div>
		</div>
		
		<script type="text/javascript">
			function change() {
        		var vcodeImg = document.getElementById("vcodeImg");
        		vcodeImg.src = "${pageContext.request.contextPath }/servlet/VcodeServlet?a=" + new Date().getTime();
    		}
		</script>
	</body>
</html>