<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script>
			<!-- 유효성 검사 -->
$(function() {
	$("#join").submit(function() {
		<!-- 이름 유효성 검사 -->
		if(!$("input[name='userName']").val()) {
			alert("이름을 입력하세요.");
			$("input[name='userName']").focus();
			return false;
		}
		var regexp_name = /^[가-힣]{2,14}$/;
		var name_check = $("input[name='userName']").val();
		
		if (!regexp_name.test(name_check)) {
			alert("이름은 공백을 제외한 한글 2~14자만 입력할 수 있습니다.")
			$("input[name='userName']").focus();
			return false;
		}
		<!-- ID 유효성 검사 -->
		if(!$("input[name='userId']").val()){
			alert("아이디를 입력하세요.");
			$("input[name='userId']").focus();
			return false;
		}
		
		var regexp_id = /^[a-zA-Z0-9]{3,20}$/;
		var id_check = $("input[name='userId']").val();
		
		if(!regexp_id.test(id_check)) {
			alert("아이디는 공백을 제외한 영문이나 숫자의 형태의 3~20자리만 입력할 수 있습니다.")
			$("input[name='userId']").focus();
			return false;
		}
		<!-- 비밀번호 유효성 검사 -->
		if (!$("input[name='userPwd']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='userPwd']").focus();
			return false;
		}
		var regexp_passwd = /^[A-Za-z0-9]{8,16}$/;
		var passwd_check = $("input[name='userPwd']").val();
		if (!regexp_passwd.test(passwd_check)) {
			alert("비밀번호는 공백을 제외한 영문이나 숫자 형태의 8~16자리만 입력할 수 있습니다.");
			$("input[name='userPwd']").focus();
			return false;
		}
		<!-- 비밀번호 일치 검사 -->
		if($("input[name='userPwd']").val() != $("input[name='userPwdConfirm']").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("input[name='userPwdConfirm']").focus();
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
		
		<!-- 연락처 유효성 검사 -->
		if(!$("input[name='phoneNum']").val()) {
			alert("연락처를 입력하세요.");
			$("input[name='phoneNum']").focus();
			return false;
		}
		var regexp_phoneNum = /^[0-9]{10,11}$/;
		var phoneNum_check = $("input[name='phoneNum']").val();
		
		if(!regexp_phoneNum.test(phoneNum_check)) {
			alert("연락처는 공백과 \'-\'을 제외한 숫자 10~11자리만 입력할 수 있습니다.");
			$("input[name='phoneNum']").focus();
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
		<!-- 휴대폰 유효성 검사(선택-입력시) -->
		if($("input[name='phoneNum2']").val()){
			var regexp_phoneNum2 = /^[0-9]{10,11}$/;
			var phoneNum2_check2 = $("input[name='phoneNum2']").val();
			
			if(!regexp_phoneNum2.test(phoneNum2_check2)) {
				alert("휴대폰 번호는 공백과 \'-\'을 제외한 숫자 10~11자리만 입력할 수 있습니다.");
				$("input[name='phoneNum2']").focus();
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

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="index.jsp">Brand</a>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="board_select.jsp">게시판</a></li>
				<li class="nav-item active"><a class="nav-link" href="user_reg.jsp">회원가입<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">로그인</a></li>

			</ul>
		</div>
	</nav>
	
		<!-- 회원가입 폼 -->
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<main class="reg-form">
					<div class="cotainer">
						<div class="row justify-content-center">
							<div class="col-md-8">
								<div class="card">
									<div class="card-header">
									<h3>회원가입</h3>
									<p align="right"><span class="text-danger">*</span>표시는 필수입력 항목입니다.
									</div>
									<div class="card-body">
										<form name="reg-form" id="join" action="#" method="POST">
											<div class="form-group row">
												<label for="userName"
													class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>이름</label>
												<div class="col-md-6">
													<input type="text" id="userName" class="form-control"
														name="userName">
												</div>
											</div>

											<div class="form-group row">
												<label for="userId"
													class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>아이디</label>
												<div class="col-md-6">
													<input type="text" id="userId" class="form-control"
														name="userId">
												</div>
											</div>

											<div class="form-group row">
												<label for="userPwd"
													class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>비밀번호</label>
												<div class="col-md-6">
													<input type="password" id="userPwd" class="form-control"
														name="userPwd">
												</div>
											</div>
											
											<div class="form-group row">
												<label for="userPwdConfirm"
													class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>비밀번호 확인</label>
												<div class="col-md-6">
													<input type="password" id="userPwdConfirm" class="form-control"
														name="userPwdConfirm">
												</div>
											</div>

											<div class="form-group row">
												<label for="birth"
													class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>생년월일</label>
												<div class="col-md-6">
													<input type="date" id="birth" name="birth" class="form-control">
												</div>
											</div>
											
											<div class="form-group row">
							                    <label for="gender" class="col-md-4 col-form-label text-md-right"><span class="text-danger">*</span>성별</label>
							                        <label class="col-md-2 mt-2 radio-inline text-md-left">
							                            <input type="radio" id="gender" name="gender" value="M">남자
							                        </label>
							                        <label class="col-md-2 mt-2 radio-inline text-md-left">
							                            <input type="radio" id="gender" name="gender" value="F">여자
							                        </label>
							                </div>
							                
											<div class="form-group row">
												<label for="present_address"
													class="col-md-4 col-form-label text-md-right">Present
													Address</label>
												<div class="col-md-6">
													<input type="text" id="present_address"
														class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="permanent_address"
													class="col-md-4 col-form-label text-md-right">Permanent
													Address</label>
												<div class="col-md-6">
													<input type="text" id="permanent_address"
														class="form-control" name="permanent-address">
												</div>
											</div>

											<div class="form-group row">
												<label for="nid_number"
													class="col-md-4 col-form-label text-md-right"><abbr
													title="National Id Card">NID</abbr> Number</label>
												<div class="col-md-6">
													<input type="text" id="nid_number" class="form-control"
														name="nid-number">
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
	<footer class="page-footer font-small teal pt-4">

		<!-- Footer Text -->
		<div class="container-fluid text-center text-md-left">

			<!-- Grid row -->
			<div class="row">

				<!-- Grid column -->
				<div class="col-md-6 mt-md-0 mt-3">

					<!-- Content -->
					<h5 class="text-uppercase font-weight-bold">Footer text 1</h5>
					<p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.
						Expedita sapiente sint, nulla, nihil repudiandae commodi
						voluptatibus corrupti animi sequi aliquid magnam debitis, maxime
						quam recusandae harum esse fugiat. Itaque, culpa?</p>

				</div>
				<!-- Grid column -->

				<hr class="clearfix w-100 d-md-none pb-3">

				<!-- Grid column -->
				<div class="col-md-6 mb-md-0 mb-3">

					<!-- Content -->
					<h5 class="text-uppercase font-weight-bold">Footer text 2</h5>
					<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
						Optio deserunt fuga perferendis modi earum commodi aperiam
						temporibus quod nulla nesciunt aliquid debitis ullam omnis quos
						ipsam, aspernatur id excepturi hic.</p>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row -->

		</div>
		<!-- Footer Text -->

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2020 Copyright: <a href="/"> MDBootstrap.com</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</body>
</html>