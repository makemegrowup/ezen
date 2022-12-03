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
<title>KSH-pack 게시판</title>
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
		<a class="navbar-brand" href="index.jsp"><i class="far fa-smile-wink"></i> KSH-pack</a>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp"><i class="fa-solid fa-house"></i>Home</a></li>
				<c:choose>
					<c:when test="${!empty sessionScope.memberId }">
						<li class="nav-item active"><a class="nav-link" href="./BoardList.do">게시판<span class="sr-only">(current)</span></a></li>				
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="./LoginView.me">게시판</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="./MemberRegisterView.me">회원가입</a></li>
				<li class="nav-item"><a class="nav-link" href="./LoginView.me">로그인</a></li>

			</ul>
		</div>
	</nav>
	<!-- Board -->
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-8">
				<div class="card">
					<div class="card-header">
						<h3>글목록</h3>
						<p align="right">
							전체 글 : <strong>${boardListCount}</strong>
						</p>
					</div>
					<div class="card-body">
						<div class="d-flex justify-content-end">
								<a class="btn btn-warning float-end" href="./BoardInsertView.do">
									<i class="fas fa-edit"></i> 글 작성
								</a>
						</div>
						<table class="table table-hover table-striped text-center">
							<thead class="thead-dark">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="board" items="${boardList}">
								<tr>
									<th>${board.boardNum}</th>
									<td><a href="./BoardListDetail.do?boardNum=${board.boardNum}">${board.title}</a></td>
									<td>${board.memberId}</td>
									<td>${board.boardRegdate}</td>
									<td>${board.readCount}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					
					<!-- Pagination -->
					
					<nav>
					  <ul class="pagination justify-content-center">
					  
					  <!-- Previous Button -->
					  
					  	<c:choose>
							<c:when test="${startPage <= 1}">
							    <li class="page-item disabled">
							      <a class="page-link" href="#" aria-label="Previous-PageBlock">
							        <span aria-hidden="true">&laquo;</span>
							        <span class="sr-only">페이지 이전블럭 이동</span>
							      </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
							      <a class="page-link" href="./BoardList.do?page=${startPage-1}" aria-label="Previous-PageBlock">
							        <span aria-hidden="true">&laquo;</span>
							        <span class="sr-only">페이지 이전블럭 이동</span>
							      </a>
							    </li>
							</c:otherwise>					  	
					  	</c:choose>
					  	
					  	<c:choose>
							<c:when test="${page <= 1}">
							    <li class="page-item disabled">
							      <a class="page-link" href="#" aria-label="Previous-Page">
							        <span aria-hidden="true">&lt;</span>
							        <span class="sr-only">이전 페이지 한칸 이동</span>
							      </a>
							    </li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
							      <a class="page-link" href="./BoardList.do?page=${page-1}" aria-label="Previous-Page">
							        <span aria-hidden="true">&lt;</span>
							        <span class="sr-only">이전 페이지 한칸 이동</span>
							      </a>
							    </li>
							</c:otherwise>					  	
					  	</c:choose>
					  	
					  	 <!-- Previous Button -->
					  	 
					  	
					  	 <!-- Page Number -->
					  	
					  	<c:forEach var="start" begin="${startPage}" end="${endPage}" step="1">
					  		<c:choose>
					  			<c:when test="${start==page}">
					    			<li class="page-item active"><a class="page-link">${start}</a></li>					  				
					  			</c:when>
					  			<c:otherwise>
					  				<li class="page-item"><a class="page-link" href="./BoardList.do?page=${start}">${start}</a></li>
					  			</c:otherwise>
					  		</c:choose>
					  	</c:forEach>
					  	
					  	<!-- Page Number -->
					  	
					  	<!-- Next Button -->
					  	
					  	<c:choose>
						  	<c:when test="${page == endPage}">
							    <li class="page-item disabled">
							      <a class="page-link" href="#" aria-label="Next">
							        <span aria-hidden="true">&gt;</span>
							        <span class="sr-only">다음 페이지 한칸 이동</span>
							      </a>
							    </li>
						  	</c:when>
						  	<c:otherwise>
						  		<li class="page-item">
							      <a class="page-link" href="./BoardList.do?page=${page+1}" aria-label="Next">
							        <span aria-hidden="true">&gt;</span>
							        <span class="sr-only">다음 페이지 한칸 이동</span>
							      </a>
							    </li>
						  	</c:otherwise>
					  	</c:choose>
					  	
					  	<c:choose>
						  	<c:when test="${endPage >= maxPage}">
							    <li class="page-item disabled">
							      <a class="page-link" href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							        <span class="sr-only">페이지 다음블럭 이동</span>
							      </a>
							    </li>
						  	</c:when>
						  	<c:otherwise>
						  		<li class="page-item">
							      <a class="page-link" href="./BoardList.do?page=${endPage+1}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							        <span class="sr-only">페이지 다음블럭 이동</span>
							      </a>
							    </li>
						  	</c:otherwise>
					  	</c:choose>
					  	
					  	<!-- Next Button -->
					  	
					  </ul>
					</nav>
					
					<!-- Pagination -->
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