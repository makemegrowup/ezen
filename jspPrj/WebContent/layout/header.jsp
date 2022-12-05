<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header>

	<nav class="navbar navbar-expand-lg navbar-light bg-warning static-top">

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="index.jsp"><i class="far fa-smile-wink"></i> KSH-pack</a>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item active"><a class="nav-link" href="index.jsp"><i class="fa-solid fa-house"></i>Home<span class="sr-only">(current)</span></a></li>
				<c:choose>
					<c:when test="${!empty sessionScope.memberId}">
						<li class="nav-item"><a class="nav-link" href="./BoardList.do">게시판</a></li>
						<li class="nav-item dropdown">
					        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown">
					          ${sessionScope.memberName}님
					        </a>
					        <div class="dropdown-menu">
					        <c:if test="${!empty sessionScope.memberId}">
					          <a class="dropdown-item" href="./MemberListDetail.me?memberId=${sessionScope.memberId}">회원정보</a>
					        </c:if>
					          <div class="dropdown-divider"></div>
					        <c:choose>
					        	<c:when test="${empty sessionScope.memberId}">
						          	<a class="dropdown-item" href="./LoginView.me">로그인</a>
					        	</c:when>
					        	<c:otherwise>
					        		<a class="dropdown-item" href="./Logout.me">로그아웃</a>
					        	</c:otherwise>
					        </c:choose>
					        </div>
					      </li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="./LoginView.me">게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="./MemberRegisterView.me">회원가입</a></li>
						<li class="nav-item"><a class="nav-link" href="./LoginView.me">로그인</a></li>
					</c:otherwise>
				</c:choose>
			</ul>


<!-- 			<form class="form-inline">
				<input class="form-control mr-sm-2" type="text" />
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form> -->

		</div>
	</nav>
	
</header>

</body>
</html>