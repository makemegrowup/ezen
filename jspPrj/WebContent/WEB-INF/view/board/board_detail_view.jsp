<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope.memberId}">
	<script type="text/javascript">
		location.href = "./LoginView.me"
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KSH-pack 게시글</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js" crossorigin="anonymous"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-warning static-top">

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="index.jsp">KSH-pack</a>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
				<c:choose>
					<c:when test="${!empty sessionScope.memberId }">
						<li class="nav-item active"><a class="nav-link" href="./BoardList.do">게시판<span class="sr-only">(current)</span></a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="./LoginView.me">게시판</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="user_reg.jsp">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">로그인</a></li>

			</ul>
		</div>
	</nav>
	<!-- Board Insert Form -->

	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-8 mt-3 mb-3">
				<div class="card">
					<div class="card-header">
						<h2 class="text-center mt-4 mb-4">게시글</h2>
					</div>
					<div class="card-body">
						<table class="table">
							<tr>
								<th>게시글 번호</th>
								<td>${boardDTO.boardNum}</td>
								<th>조회수</th>
								<td>${boardDTO.readCount}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${boardDTO.memberId}</td>
								<th>작성일</th>
								<td>${boardDTO.boardRegdate}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${boardDTO.title}</td>
							</tr>
						</table>
						<table class="table">
						</table>
					<hr/>
					</div>
						<div class="col-12">
						${boardDTO.content}
						</div>
					<hr/>
					<div class="row">
						<div class="col-12 text-right">
							<input type="button" value="글수정" class="btn btn-success" onclick="location.href='./BoardUpdateView.do?boardNum=${boardDTO.boardNum}'"> 
							<input type="button" value="글삭제" class="btn btn-warning" onclick="location.href='./BoardDeleteConfirm.do?boardNum=${boardDTO.boardNum}'">
							<button type="button" class="btn btn-primary" onclick="location.href='./BoardList.do'">전체 게시글보기</button>
						</div>
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