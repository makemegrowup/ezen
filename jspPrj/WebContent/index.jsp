<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js" crossorigin="anonymous"></script>
<title>KSH-pack</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning static-top">

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="index.jsp"><i class="far fa-smile-wink"></i> KSH-pack</a>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item active"><a class="nav-link" href="index.jsp"><i class="fa-solid fa-house"></i>Home<span class="sr-only">(current)</span></a></li>
				<c:choose>
					<c:when test="${!empty sessionScope.memberId }">
						<li class="nav-item"><a class="nav-link" href="./BoardList.do">게시판</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="./LoginView.me">게시판</a></li>

					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="./MemberRegisterView.me">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="./LoginView.me">로그인</a></li>
			</ul>

<!-- 			<form class="form-inline">
				<input class="form-control mr-sm-2" type="text" />
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form> -->

		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row align-items-center">
					<div class="col-md-2">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
							<li class="nav-item"><a class="nav-link disabled" href="#">Messages</a></li>
							<li class="nav-item"><a class="nav-link disabled" href="#">Messages</a></li>
							<li class="nav-item"><a class="nav-link disabled" href="#">Messages</a></li>

						</ul>
					</div>
					<div class="col-md-10">
						<div class="jumbotron">
							<h2>Hello, world!</h2>
							<p>This is a template for a simple marketing or informational website. It includes a large callout called the
								hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
							<p>
								<a class="btn btn-primary btn-large" href="#">Learn more</a>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<a><img alt="" src="img/cloth.png"></a>
						</div>
						<div class="col-md-4">
							<a><img alt="" src="img/cloth.png"></a>
						</div>
						<div class="col-md-4">
							<a><img alt="" src="img/cloth.png"></a>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Footer -->
	<hr>
	<footer class="page-footer font-small teal pt-2">

		<!-- Footer Text -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-5 mx-auto">

					<!-- Content -->
					<h5 class="text-uppercase font-weight-bold">Enjoy Shopping</h5>
					<p>
						<small> business name : KSH-pack<br> 25, Sinheung-ro 258beon-gil, Uijeongbu-si, Gyeonggi-do, Republic
							of Korea<br> business license number : 111-00-22222<br> day off : <font color="red">SAT,SUN</font><br>
							tel : 031-0000-0000<br> CEO : SiHyeong Kim
						</small>
					</p>

				</div>
			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Text -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2020 Copyright: <font color="blue"><b>KSH</b></font>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</body>
</html>