<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KSH-pack 로그인</title>
</head>
<c:choose>
	<c:when test="${memberDTO.memberId == ''}">
		<script type="text/javascript">
			alert("가입되지 않은 회원입니다.")
			history.back();
		</script>
	</c:when>
	<c:when test="${memberDTO.memberPwd == ''}">
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다.")
			history.back();
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			location.href="index.jsp"
		</script>
	</c:otherwise>
</c:choose>
<body>

</body>
</html>