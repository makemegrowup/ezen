<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KSH-pack 게시글 삭제</title>
</head>
<body>
<script type="text/javascript">
	if(confirm("게시글을 삭제하시겠습니까?")){
		location.href="./BoardDelete.do?boardNum=${param.boardNum}&memberId=${sessionScope.memberId}"
	} else {
		location.href="./BoardDetail.do?boardNum=${param.boardNum}"
	}
		
</script>
</body>
</html>