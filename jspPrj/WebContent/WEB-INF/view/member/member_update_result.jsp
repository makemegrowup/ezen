<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<script type="text/javascript">
		alert("${memberDTO.memberId}님의 회원 정보가 수정되었습니다.");
		location.href="./MemberListDetail.me?memberId=${memberDTO.memberId}";
</script>

</body>
</html>