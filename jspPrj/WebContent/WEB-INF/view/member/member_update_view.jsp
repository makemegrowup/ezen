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
<title>${memberDTO.memberId}님의회원정보 수정페이지</title>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet"">
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/kakao-addressAPI.js" type="text/javascript"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js"></script>
</head>
<body>
	<!-- Header -->

	<%@ include file="/layout/header.jsp"%>

	<!-- Header -->

	<!-- Board Insert Form -->

	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-8 mt-3 mb-3">
				<div class="card">
					<div class="card-header">
						<h2 class="text-center mt-4 mb-4">회원정보</h2>
					</div>
					<div class="card-body">
						<form action="./MemberUpdate.me" method="post" name="memberUpdateForm">
							<div class="form-group row">
								<label for="memberId" class="col-md-4 col-form-label text-md-right">회원ID</label>
								<div class="col-sm-5">
									<input type="text" id="memberId" class="form-control" name="memberId" value="${memberDTO.memberId}" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label for="memberName" class="col-md-4 col-form-label text-md-right">이름</label>
								<div class="col-sm-5">
									<input type="text" id="memberName" class="form-control" name="memberName" value="${memberDTO.memberName}">
								</div>
							</div>
							<div class="form-group row">
								<label for="birth" class="col-md-4 col-form-label text-md-right">생년월일</label>
								<div class="col-sm-5">
									<input type="date" id="birth" class="form-control" name="birth" value="${memberDTO.birth}">
								</div>
							</div>
							<div class="form-group row">
								<label for="address" class="col-md-4 col-form-label text-md-right">주소</label>
								<div class="col-md-2">
									<input type="text" id="postalcode" name="postalcode" placeholder="우편번호" class="form-control input-md" value="${memberDTO.postalcode}" readonly>
								</div>
								<div>
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="findPostalcode">
								</div>
							</div>
							<div class="form-group row">
								<label for="address" class="col-md-4 col-form-label text-md-right"></label>
								<div class="col-sm-5">
									<input type="text" id="address" name="address" placeholder="주소" class="form-control input-md" value="${memberDTO.address}" readonly>
									<input type="text" id="addressDetail" name="addressDetail" placeholder="상세주소" class="form-control input-md" value="${memberDTO.addressDetail}">
									<input type="text" id="addressExtra" name="addressExtra" placeholder="참고항목" class="form-control input-md" value="${memberDTO.addressExtra}" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label for="cellphone" class="col-md-4 col-form-label text-md-right">휴대폰</label>
								<div class="col-sm-5">
									<input type="text" id="cellphone" class="form-control" name="cellphone" value="${memberDTO.cellphone}">
								</div>
							</div>
							<div class="form-group row">
								<label for="email" class="col-md-4 col-form-label text-md-right">이메일</label>
								<div class="col-sm-5">
									<input type="email" id="email" class="form-control" name="email" value="${memberDTO.email}">
								</div>
							</div>
							<div class="form-group row">
								<label for="subCellphone" class="col-md-4 col-form-label text-md-right">연락처</label>
								<div class="col-sm-5">
									<input type="text" id="subCellphone" class="form-control" name="subCellphone" value="${memberDTO.subCellphone}">
								</div>
							</div>
							<div class="form-group row">
								<label for="companyNumber" class="col-md-4 col-form-label text-md-right">회사번호</label>
								<div class="col-sm-5">
									<input type="text" id="companyNumber" class="form-control" name="companyNumber" value="${memberDTO.companyNumber}">
								</div>
							</div>
							<div class="form-group row">
								<label for="memberRegdate" class="col-md-4 col-form-label text-md-right">가입일</label>
								<div class="col-sm-5">
									<input type="text" id="memberRegdate" class="form-control" name="memberRegdate" value="${memberDTO.memberRegdate}" readonly>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 ml-5 text-center">
									<input type="submit" value="수정완료" class="btn btn-success"> 
									<input type="reset" value="다시작성" class="btn btn-warning">
									<button type="button" class="btn btn-primary" onclick="location.href='./MemberListDetail.me?memberId=${memberDTO.memberId}'">수정취소</button>
									<c:if test="${sessionScope.memberId == 'admin'}">
										<button type="button" class="btn btn-primary" onclick="location.href='./MemberList.me}'">회원목록</button>
									</c:if>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->

	<%@ include file="/layout/footer.jsp"%>

	<!-- Footer -->
</body>
</html>