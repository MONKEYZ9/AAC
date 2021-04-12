// 로그인시 검사
function loginBoxCheck() {
	var emailBox = document.loginBox.aac_email;
	var pwBox = document.loginBox.aac_password;
	if (checkInputContent(emailBox) || notContains(emailBox, "@.")) {
		alert("이메일을 입력하세요.");
		emailBox.value = "";
		emailBox.focus();
		return false;
	} else if (checkInputContent(pwBox)) {
		alert("비밀번호를 입력하세요.");
		pwBox.focus();
		return false;
	} 
	return true;
}

// 회원가입 검사
function joinBoxCheck() {
	var serialNumber = document.joinForm.aac_member_serial_number; // 시리얼넘버
	var email1 = document.joinForm.aac_email1; // 이메일주소
	var password = document.joinForm.aac_password; // 비밀번호
	var pwCheck = document.joinForm.aac_pwCheck; // 비밀번호확인
	var addr1 = document.joinForm.aac_join_addr1; // 우편번호
	var addr2 = document.joinForm.aac_join_addr2; // 주소
	var addr3 = document.joinForm.aac_join_addr3; // 상세주소
	var age = document.joinForm.aac_age; // 나이

	if (checkInputContent(serialNumber)) {
		alert("시리얼넘버를 입력하세요.");
		serialNumber.focus();
		return false;
	} else if (checkInputContent(email1)) {
		alert("이메일주소를 입력하세요.");
		email1.focus();
		return false;
	} else if (checkInputContent(password)) {
		alert("비밀번호를 입력하세요.");
		password.focus();
		return false;
	} else if (password.value != pwCheck.value) {
		alert("비밀번호를 확인해주세요.");
		password.focus();
		return false;
	} else if (checkInputContent(addr1) || checkInputContent(addr2) || checkInputContent(addr3)) {
		alert("주소를 입력하세요.");
		addr1.focus();
		return false;
	} else if (checkInputContent(age) || onlyNum(age)) {
		alert("나이를 입력하세요.");
		age.focus();
		return false;
	} 
	return true;
}
