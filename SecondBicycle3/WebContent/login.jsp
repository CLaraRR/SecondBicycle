<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page session="false"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
    <jsp:include page="Header-top.jsp" />
	<jsp:include page="Header-bottom.jsp" />
        <div class="login">
          	<div class="wrap">
				<div class="col_1_of_login span_1_of_login">
					<h4 class="title">那么问题来了...</h4>
					<p>没有账户？在这里创建一个属于你的账户吧~</p>
					<div class="button1">
					   <a href="register.html"><input type="submit" name="Submit" value="创建账户"></a>
					 </div>
					 <div class="clear"></div>
				</div>
				<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
	           		<h4 class="title">已注册用户</h4>
					<div id="loginbox" class="loginbox">
						<form action="Login.do" method="POST" name="login" id="login-form">
						  <fieldset class="input">
						    <p id="login-form-username">
						      <label for="modlgn_username">用户名</label>
						      <input id="modlgn_username" type="text" name="Name" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <p id="login-form-password">
						      <label for="modlgn_passwd">密码</label>
						      <input id="modlgn_passwd" type="password" name="Password" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <div class="remember">
							    <p id="login-form-remember">
							      <label for="modlgn_remember"><a href="#">忘记密码 ? </a></label>
							   </p>
							    <input type="submit" name="Submit" class="button" value="登录"><div class="clear"></div>
							    
							 </div>
						  </fieldset>
						 </form>
					</div>
			    </div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
    <jsp:include page="Footer.jsp" />
<div style="display:none"></div>
</body>
</html>