package ksh.member.dto;

public class MemDTO {
	
	int no;
	String name;
	String identity;
	String passWd;
	String birth;
	String gender;
	String postalCode;
	String address;
	String secondAddress;
	String phoneNum;
	String email;
	String phoneNum2;
	String companyNum;
	String comPostalCode;
	String companyAddress;
	String allTermsConditions;
	String termsConditions;
	String collectingPersonalInformation;
	String marketingReception;
	String permitSMS;
	String permitEmail;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSecondAddress() {
		return secondAddress;
	}
	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum2() {
		return phoneNum2;
	}
	public void setPhoneNum2(String phoneNum2) {
		this.phoneNum2 = phoneNum2;
	}
	public String getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(String companyNum) {
		this.companyNum = companyNum;
	}
	public String getComPostalCode() {
		return comPostalCode;
	}
	public void setComPostalCode(String comPostalCode) {
		this.comPostalCode = comPostalCode;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getAllTermsConditions() {
		return allTermsConditions;
	}
	public void setAllTermsConditions(String allTermsConditions) {
		this.allTermsConditions = allTermsConditions;
	}
	public String getTermsConditions() {
		return termsConditions;
	}
	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}
	public String getCollectingPersonalInformation() {
		return collectingPersonalInformation;
	}
	public void setCollectingPersonalInformation(String collectingPersonalInformation) {
		this.collectingPersonalInformation = collectingPersonalInformation;
	}
	public String getMarketingReception() {
		return marketingReception;
	}
	public void setMarketingReception(String marketingReception) {
		this.marketingReception = marketingReception;
	}
	public String getPermitSMS() {
		return permitSMS;
	}
	public void setPermitSMS(String permitSMS) {
		this.permitSMS = permitSMS;
	}
	public String getPermitEmail() {
		return permitEmail;
	}
	public void setPermitEmail(String permitEmail) {
		this.permitEmail = permitEmail;
	}
	@Override
	public String toString() {
		return "MemDTO [no=" + no + ", name=" + name + ", identity=" + identity + ", passWd=" + passWd + ", birth="
				+ birth + ", gender=" + gender + ", postalCode=" + postalCode + ", address=" + address
				+ ", secondAddress=" + secondAddress + ", phoneNum=" + phoneNum + ", email=" + email + ", phoneNum2="
				+ phoneNum2 + ", companyNum=" + companyNum + ", comPostalCode=" + comPostalCode + ", companyAddress="
				+ companyAddress + ", allTermsConditions=" + allTermsConditions + ", termsConditions=" + termsConditions
				+ ", collectingPersonalInformation=" + collectingPersonalInformation + ", marketingReception="
				+ marketingReception + ", permitSMS=" + permitSMS + ", permitEmail=" + permitEmail + "]";
	}
	
	
}
