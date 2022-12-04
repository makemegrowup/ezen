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
<title>KSH-pack 게시글 수정</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
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
		        <h2 class="text-center mt-4 mb-4"><strong>게시글 수정</strong></h2>
		    	</div>
			    	<div class="card-body">
				        <form action="./BoardUpdate.do" method="post" name="boardInsertForm">
				          <table class="table table-striped">
				            <tr>
				                <th>게시글 번호</th>
				                <td><input type="text"  class="form-control" name="boardNum" value="${boardDTO.boardNum}" readonly></td>
				            </tr>
				            <tr>
				                <th>작성자</th>
				                <td><input type="text"  class="form-control" name="memberId" value="${sessionScope.memberId}" readonly></td>
				            </tr>
				            <tr>
				                <th>제목</th>
				                <td><input type="text"  class="form-control" name="title" value="${boardDTO.title}"></td>
				            </tr>
 				             <tr>
				                <td>글내용</td>
				                <td><textarea rows="10" cols="50" name="content" class="form-control">${boardDTO.content}</textarea></td>
				            </tr>
				            <tr>
				                <td colspan="2"  class="text-right">
				                    <input type="submit" value="글저장" class="btn btn-success">
				                    <input type="reset" value="다시작성" class="btn btn-warning">
				                    <button type="button"  class="btn btn-primary" onclick="location.href='./BoardList.do'">전체 게시글보기</button>
				                </td>
				            </tr>
				             
				          </table>
				        </form>
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