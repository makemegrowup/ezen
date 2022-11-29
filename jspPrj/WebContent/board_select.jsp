<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:if test="${empty sessionScope.id}">
 <script type="text/javascript">
		location.href = "./LoginView.me"
	</script>
</c:if> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning static-top">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="index.jsp">Brand</a>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
				<li class="nav-item active"><a class="nav-link" href="board_select">게시판<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="user_reg.jsp">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">로그인</a></li>

			</ul>
		</div>
	</nav>
	<!-- Board -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header">
					<h3>글목록</h3>
					<p align="right">전체 글 : 
						<strong>${listcount}</strong>
					</p>
					</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>test</td>
									<td>aaa111</td>
									<td>2022-03-11</td>
									<td>3</td>
								</tr>
							</tbody>
						</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="page-footer font-small teal pt-4">

		<!-- Footer Text -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">

					<!-- Content -->
					<h5 class="text-uppercase font-weight-bold">Footer text 1</h5>
					<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.
						Expedita sapiente sint, nulla, nihil repudiandae commodi
						voluptatibus corrupti animi sequi aliquid magnam debitis, maxime
						quam recusandae harum esse fugiat. Itaque, culpa?</p>

				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none pb-3">

				<!-- Grid column -->
				<div class="col-md-6 mb-md-0 mb-3">

					<!-- Content -->
					<h5 class="text-uppercase font-weight-bold">Footer text 2</h5>
					<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
						Optio deserunt fuga perferendis modi earum commodi aperiam
						temporibus quod nulla nesciunt aliquid debitis ullam omnis quos
						ipsam, aspernatur id excepturi hic.</p>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Text -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2020 Copyright: <a href="/"> MDBootstrap.com</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</body>
</html>