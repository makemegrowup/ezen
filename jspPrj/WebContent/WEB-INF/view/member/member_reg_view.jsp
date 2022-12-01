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

<script>
			<!-- 유효성 검사 -->
$(function() {
	$("#join").submit(function() {
		<!-- 이름 유효성 검사 -->
		if(!$("input[name='memberName']").val()) {
			alert("이름을 입력하세요.");
			$("input[name='memberName']").focus();
			return false;
		}
		var regexp_name = /^[가-힣]{2,14}$/;
		var name_check = $("input[name='memberName']").val();
		
		if (!regexp_name.test(name_check)) {
			alert("이름은 공백을 제외한 한글 2~14자만 입력할 수 있습니다.")
			$("input[name='memberName']").focus();
			return false;
		}
		<!-- ID 유효성 검사 -->
		if(!$("input[name='memberId']").val()){
			alert("아이디를 입력하세요.");
			$("input[name='memberId']").focus();
			return false;
		}
		
		var regexp_id = /^[a-zA-Z0-9]{3,20}$/;
		var id_check = $("input[name='memberId']").val();
		
		if(!regexp_id.test(id_check)) {
			alert("아이디는 공백을 제외한 영문이나 숫자의 형태의 3~20자리만 입력할 수 있습니다.")
			$("input[name='memberId']").focus();
			return false;
		}
		<!-- 비밀번호 유효성 검사 -->
		if (!$("input[name='memberPwd']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='memberPwd']").focus();
			return false;
		}
		var regexp_passwd = /^[A-Za-z0-9]{8,16}$/;
		var passwd_check = $("input[name='memberPwd']").val();
		if (!regexp_passwd.test(passwd_check)) {
			alert("비밀번호는 공백을 제외한 영문이나 숫자 형태의 8~16자리만 입력할 수 있습니다.");
			$("input[name='memberPwd']").focus();
			return false;
		}
		<!-- 비밀번호 일치 검사 -->
		if($("input[name='memberPwd']").val() != $("input[name='memberPwdConfirm']").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("input[name='memberPwdConfirm']").focus();
			return false;
		}
		<!-- 생년월일 유효성 검사 -->
		if(!$("input[name='birth']").val()) {
			alert("생년월일을 입력해주세요.");
			$("input[name='birth']").focus();
			return false;
		}
		<!-- 성별 유효성 검사 -->
		if($(":radio[name='gender']:checked").length < 1) {
			alert("성별을 선택해주세요.");
			return false;
		}
		/* if(!$("#male").is(":checked") && !$("#female").is(":checked")){
			alert("성별을 선택해 주세요.");
			return false;
		} */
		
		<!-- 주소 유효성검사-->
		if(!$("#postalcode").val()) {
			alert("주소를 입력해주세요.");
			return false;
		}
		
		<!-- 휴대폰 번호 유효성 검사 -->
		if(!$("input[name='cellphone']").val()) {
			alert("휴대폰 번호를 입력하세요.");
			$("input[name='cellphone']").focus();
			return false;
		}
		var regexp_phoneNum = /^[0-9]{10,11}$/;
		var phoneNum_check = $("input[name='cellphone']").val();
		
		if(!regexp_phoneNum.test(phoneNum_check)) {
			alert("연락처는 공백과 \'-\'을 제외한 숫자 10~11자리만 입력할 수 있습니다.");
			$("input[name='cellphone']").focus();
			return false;
		}
		<!-- 이메일 유효성 검사 -->
		if(!$("input[name='email']").val()){
			alert("이메일을 입력하세요.");
			$("input[name='email']").focus();
			return false;
		}
		var regexp_email = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		var email_check = $("input[name='email']").val();
		
		if(!regexp_email.test(email_check)) {
			alert("이메일을 형식에 맞게 작성하세요.")
			$("input[name='email']").focus();
			return false;
		}
		<!-- 연락처 유효성 검사(선택-입력시) -->
		if($("input[name='subCellphone']").val()){
			var regexp_phoneNum2 = /^[0-9]{10,11}$/;
			var phoneNum2_check2 = $("input[name='subCellphone']").val();
			
			if(!regexp_phoneNum2.test(phoneNum2_check2)) {
				alert("휴대폰 번호는 공백과 \'-\'을 제외한 숫자 10~11자리만 입력할 수 있습니다.");
				$("input[name='subCellphone']").focus();
				return false;
			}
		}
		<!-- 회사전화 유효성 검사(선택-입력시) -->
		if($("input[name='companyNum']").val()){
			var regexp_companyNum = /^[0-9]{8,11}$/;
			var companyNum_check2 = $("input[name='companyNum']").val();
			
			if(!regexp_companyNum.test(companyNum_check2)) {
				alert("회사번호는 공백과 \'-\'을 제외한 숫자 8~11자리만 입력할 수 있습니다.");
				$("input[name='companyNum']").focus();
				return false;
			}
		}
		
	});
});

function resetEvent() {
	if(confirm("가입을 취소하시겠습니까?")){
		$("#join")[0].reset();
	}
}
</script>
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
						<li class="nav-item"><a class="nav-link" href="./BoardList.do">게시판</a></li>				
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="./LoginView.me">게시판</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item active"><a class="nav-link" href="./MemberRegisterView.me">회원가입<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="./LoginView.me">로그인</a></li>

			</ul>
		</div>
	</nav>

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
												<button type="reset" class="btn btn-primary">취소</button>
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
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>