/* 회원가입 유효성 검사 */
			
$(function() {
	$("#join").submit(function() {
		/* 이름 유효성 검사 */
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
		/* ID 유효성 검사 */
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
		/* 비밀번호 유효성 검사 */
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
		/* 비밀번호 일치 검사 */
		if($("input[name='memberPwd']").val() != $("input[name='memberPwdConfirm']").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("input[name='memberPwdConfirm']").focus();
			return false;
		}
		/* 생년월일 유효성 검사 */
		if(!$("input[name='birth']").val()) {
			alert("생년월일을 입력해주세요.");
			$("input[name='birth']").focus();
			return false;
		}
		/* 성별 유효성 검사 */
		if($(":radio[name='gender']:checked").length < 1) {
			alert("성별을 선택해주세요.");
			return false;
		}

		/* 주소 유효성검사 */
		if(!$("#postalcode").val()) {
			alert("주소를 입력해주세요.");
			return false;
		}
		
		/* 휴대폰 번호 유효성 검사 */
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
		/* 이메일 유효성 검사 */
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
		/* 연락처 유효성 검사(선택-입력시) */
		if($("input[name='subCellphone']").val()){
			var regexp_phoneNum2 = /^[0-9]{10,11}$/;
			var phoneNum2_check2 = $("input[name='subCellphone']").val();
			
			if(!regexp_phoneNum2.test(phoneNum2_check2)) {
				alert("휴대폰 번호는 공백과 \'-\'을 제외한 숫자 10~11자리만 입력할 수 있습니다.");
				$("input[name='subCellphone']").focus();
				return false;
			}
		}
		/* 회사전화 유효성 검사(선택-입력시) */
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
/* 회원가입 폼 취소버튼 이벤트 */
function resetCheck() {
	if(confirm("회원가입을 취소하시겠습니까?")){
		location.href="index.jsp"
	}
}