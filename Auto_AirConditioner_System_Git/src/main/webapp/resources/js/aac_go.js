function goMemberJoin() {
	location.href = "member.join.go";
}
function goDataSet() {
	var answer = confirm("AAC 서비스를 시작하시겠습니까?");
	if (answer == true) {
		location.href = "temp.data.set";
	}
}

function goTempShow() {
	alert("로그인 또는 회원가입 후 서비스를 시작할 수 있습니다.");
}

function goInfo() {
	location.href = "member.info.go";
}

function goLogout() {
	location.href = "member.logout.go";
}
function goDropOut() {
	var answer = confirm("탈퇴하시겠습니까?");
	var answer3 = prompt("탈퇴를 입력바랍니다.", "탈퇴");
	if (answer == true) {
		if (answer3 == "탈퇴") {
			location.href = "member.dropout?aac_email=";
		}
	}
	//location.href = "member.dropOut.go";
}
// 정보수정 : 시리얼 체크
// 속성변경부터 작동 안함
function goSerialChange() {
	var answer = confirm("사용하시는 에어컨 모델이 바뀌셨습니까?");
	if (answer == true) {
		var answer2 = confirm("시리얼 넘버를 변경하시겠습니까?");
		if (answer2 == true) {
			var answer3 = prompt("변경할 시리얼 넘버를 입력하세요.", "예) F3F8D7");
			// value 속성만 변경
			$("#serialID").setAttribute("value", answer3);
			
			location.href = "member.info.upadate?aac_member_serial_number=" + answer3;
		}
	}
}
