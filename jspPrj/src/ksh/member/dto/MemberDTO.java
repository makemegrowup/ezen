package ksh.member.dto;

import java.util.Date;

public class MemberDTO {

	    // 아이디 
	    private String memberId;

	    // 패스워드 
	    private String memberPwd;

	    // 이름 
	    private String memberName;

	    // 생년월일 
	    private String birth;

	    // 우편번호 
	    private String postalcode;

	    // 주소 
	    private String address;

	    // 상세주소 
	    private String addressDetail;

	    // 주소참고항목 
	    private String addressExtra;

	    // 휴대폰 
	    private String cellphone;

	    // 이메일 
	    private String email;

	    // 연락처 
	    private String subCellphone;

	    // 회사전화 
	    private String companyNumber;

	    // 가입일 
	    private String memberRegdate;

	    public String getMemberId() {
	        return memberId;
	    }

	    public void setMemberId(String memberId) {
	        this.memberId = memberId;
	    }

	    public String getMemberPwd() {
	        return memberPwd;
	    }

	    public void setMemberPwd(String memberPwd) {
	        this.memberPwd = memberPwd;
	    }

	    public String getMemberName() {
	        return memberName;
	    }

	    public void setMemberName(String memberName) {
	        this.memberName = memberName;
	    }

	    public String getBirth() {
	        return birth;
	    }

	    public void setBirth(String birth) {
	        this.birth = birth;
	    }

	    public String getPostalcode() {
	        return postalcode;
	    }

	    public void setPostalcode(String postalcode) {
	        this.postalcode = postalcode;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getAddressDetail() {
	        return addressDetail;
	    }

	    public void setAddressDetail(String addressDetail) {
	        this.addressDetail = addressDetail;
	    }

	    public String getAddressExtra() {
	        return addressExtra;
	    }

	    public void setAddressExtra(String addressExtra) {
	        this.addressExtra = addressExtra;
	    }

	    public String getCellphone() {
	        return cellphone;
	    }

	    public void setCellphone(String cellphone) {
	        this.cellphone = cellphone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getSubCellphone() {
	        return subCellphone;
	    }

	    public void setSubCellphone(String subCellphone) {
	        this.subCellphone = subCellphone;
	    }

	    public String getCompanyNumber() {
	        return companyNumber;
	    }

	    public void setCompanyNumber(String companyNumber) {
	        this.companyNumber = companyNumber;
	    }

	    public String getMemberRegdate() {
	        return memberRegdate;
	    }

	    public void setMemberRegdate(String memberRegdate) {
	        this.memberRegdate = memberRegdate;
	    }

		@Override
		public String toString() {
			return "MemberDTO [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
					+ ", birth=" + birth + ", postalcode=" + postalcode + ", address=" + address + ", addressDetail="
					+ addressDetail + ", addressExtra=" + addressExtra + ", cellphone=" + cellphone + ", email=" + email
					+ ", subcellphone=" + subCellphone + ", companyNumber=" + companyNumber + ", memberRegdate="
					+ memberRegdate + "]";
		}

	    
}
