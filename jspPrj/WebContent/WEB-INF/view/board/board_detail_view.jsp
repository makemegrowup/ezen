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
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
</head>
<body>
<!-- Header -->

<%@ include file="/layout/header.jsp" %>

<!-- Header -->

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
				<hr/>
					<div class="col-12">
					${boardDTO.content}
					</div>
					<div class="row">
						<div class="col-12 text-right">
							<input type="button" value="글수정" class="btn btn-success" onclick="location.href='./BoardUpdateView.do?boardNum=${boardDTO.boardNum}&memberId=${boardDTO.memberId}'"> 
							<input type="button" value="글삭제" class="btn btn-warning" onclick="location.href='./BoardDeleteConfirm.do?boardNum=${boardDTO.boardNum}&memberId=${boardDTO.memberId}'">
							<button type="button" class="btn btn-primary" onclick="location.href='./BoardList.do'">전체 게시글보기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Footer -->

<%@ include file="/layout/footer.jsp" %>

<!-- Footer -->
</body>
</html>