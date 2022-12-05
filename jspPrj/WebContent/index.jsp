<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js" ></script>
<title>KSH-pack</title>
</head>
<body>

<!-- Header -->

<%@ include file="layout/header.jsp" %>

<!-- Header -->

<section>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row align-items-center">
					<div class="col-md-2">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link" href="#">아우터</a></li>
							<li class="nav-item"><a class="nav-link" href="#">상의</a></li>
							<li class="nav-item"><a class="nav-link" href="#">하의</a></li>
							<li class="nav-item"><a class="nav-link" href="#">악세사리</a></li>

						</ul>
					</div>
					<div class="col-md-10">
						<div class="jumbotron">
							<h2>KSH-pack에 오신걸 환영합니다.</h2>
							<p>서비스 준비중...</p>
<!-- 							<p>
								<a class="btn btn-primary btn-large" href="#">Learn more</a>
							</p> -->
						</div>
					</div>
				</div>
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
</section>
<!-- Footer -->

<%@ include file="layout/footer.jsp" %>

<!-- Footer -->
</body>
</html>