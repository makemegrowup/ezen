<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KSH-pack 로그인</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
</head>
<body>
<!-- Header -->

<%@ include file="/layout/header.jsp" %>

<!-- Header -->

<!-- Login Form -->
	<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row" class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="loginForm" class="form" action="./Login.me" method="post">
							<h3 class="text-center text-info">Login</h3>
							<div class="form-group">
								<label for="username" class="text-info">ID:</label><br> <input type="text" name="memberId" id="memberId"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br> <input type="password" name="memberPwd"
									id="memberPwd" class="form-control">
							</div>
							<div class="form-group">
								<label for="save" class="text-info"><span>Remember me</span> <span><input id="save"
										name="save" type="checkbox"></span></label><br>
								<button type="submit" class="btn btn-info btn-md">로그인</button>
							</div>
							<div id="register-link" class="text-right">
								<a href="./MemberRegisterView.me" class="text-info">회원가입</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<!-- Login Form -->

<!-- Footer -->

<%@ include file="/layout/footer.jsp" %>

<!-- Footer -->
</body>
</html>