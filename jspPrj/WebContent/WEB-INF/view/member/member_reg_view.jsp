<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KSH-pack 회원가입</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="js/kakao-addressAPI.js" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/58abbffa46.js" crossorigin="anonymous"></script>
<script src="js/validity.js"></script>
</head>
<body>
<!-- Header -->

<%@ include file="/layout/header.jsp" %>

<!-- Header -->

	<!-- 회원가입 폼 -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<main class="regForm">
					<div class="cotainer">
						<div class="row justify-content-center">
							<div class="col-md-8">
								<div class="card">
									<div class="card-header">
										<h3>회원가입</h3>
										<p align="right">
											<span class="text-danger">*</span>표시는 필수입력 항목입니다.
									</div>
									<div class="card-body">
										<form name="regForm" id="join" action="./MemberRegister.me" method="POST">
											<div class="form-group row">
												<label for="memberName" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>이름</label>
												<div class="col-md-6">
													<input type="text" id="memberName" class="form-control" name="memberName" placeholder="Name">
												</div>
											</div>

											<div class="form-group row">
												<label for="memberId" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>아이디</label>
												<div class="col-md-6">
													<input type="text" id="memberId" class="form-control" name="memberId" placeholder="ID">
												</div>
											</div>

											<div class="form-group row">
												<label for="memberPwd" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>비밀번호</label>
												<div class="col-md-6">
													<input type="password" id="memberPwd" class="form-control" name="memberPwd" placeholder="Password">
												</div>
											</div>

											<div class="form-group row">
												<label for="memberPwdConfirm" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>비밀번호
													확인</label>
												<div class="col-md-6">
													<input type="password" id="memberPwdConfirm" class="form-control" name="memberPwdConfirm" placeholder="Password">
												</div>
											</div>

											<div class="form-group row">
												<label for="birth" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>생년월일</label>
												<div class="col-md-6">
													<input type="date" id="birth" name="birth" class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="gender" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>성별</label>
												<label class="col-md-2 mt-2 radio-inline text-md-center"> <input type="radio" id="gender"
													name="gender" value="M">남자
												</label> <label class="col-md-2 mt-2 radio-inline text-md-center"> <input type="radio" id="gender"
													name="gender" value="F">여자
												</label>
											</div>

											<div class="form-group row">
												<label for="address" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>주소</label>
												<div class="col-md-2">
													<input type="text" id="postalcode" name="postalcode" placeholder="우편번호" class="form-control input-md"
														readonly>
												</div>
												<div>
													<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" id="findPostalcode">
												</div>
											</div>
											<div class="form-group row">
												<label for="address" class="col-md-4 col-form-label text-md-right"></label>
												<div class="col-sm-5">
													<input type="text" id="address" name="address" placeholder="주소" class="form-control input-md" readonly>
													<input type="text" id="addressDetail" name="addressDetail" placeholder="상세주소" class="form-control input-md"> 
													<input type="text" id="addressExtra" name="addressExtra" placeholder="참고항목" class="form-control input-md">
												</div>
											</div>
											
											<div class="form-group row">
												<label for="cellphone" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>휴대폰</label>
												<div class="col-md-6">
													<input type="text" name="cellphone" id="cellphone" class="form-control" placeholder="'-'을 제외한 숫자 10~11자리">
												</div>
											</div>

											<div class="form-group row">
												<label for="email" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>이메일</label>
												<div class="col-md-6">
													<input type="text" id="email" name="email" class="form-control" name="permanent-address" placeholder="Email">
												</div>
											</div>

											<div class="form-group row">
												<label for="subCellphone" class="col-md-4 col-form-label text-md-right">연락처</label>
												<div class="col-md-6">
													<input type="text" name="subCellphone" id="subCellphone" class="form-control" placeholder="(선택입력)">
												</div>
											</div>
											
											<div class="form-group row">
												<label for="companyNumber" class="col-md-4 col-form-label text-md-right">회사전화</label>
												<div class="col-md-6">
													<input type="text" name="companyNumber" id="companyNumber" class="form-control" placeholder="(선택입력)">
												</div>
											</div>

											<div class="col-md-6 offset-md-4">
												<button type="submit" class="btn btn-primary">가입</button>
												<button type="reset" onclick="resetCheck()" class="btn btn-primary">취소</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</main>
			</div>


		</div>
	</div>


<!-- Footer -->

<%@ include file="/layout/footer.jsp" %>

<!-- Footer -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>