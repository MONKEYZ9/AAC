$(function() {
	connectSearchAddrEvent();
	changeEmailSelectToInput();
	changeUserTempSelectToInput();
	checkSerialCheckEvent();
	checkEmailCheckEvent();
});

function connectSearchAddrEvent() {
	$("#aac_join_addr1, #aac_join_addr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#aac_join_addr1").val(data.zonecode);
				$("#aac_join_addr2").val(data.address);
			}
		}).open();
	});
}
// 사용자 설정 온도에서 내가 사용자 설정을 누르면 추천설정을 누르지 못하게끔
function changeUserTempSelectToInput() {
	// 사용자 설정 클릭 이벤트 발생
	$("input[name='rec_option2']:radio").click(
			function() {
				if (confirm("변경하시겠습니까?") == true) {

					// 추천 설정 체크 해제
					$("input[name='rec_option1']:radio").prop('checked', false);

					// 바꾸는 값 미리 설정
					var option2 = $("<input>").attr("name", "rec_option3")
							.attr("id", "rec_option3").attr("placeholder",
									"희망 온도 입력").attr("maxlength", "3");
					// 체크하자마자 인풋으로 바꿔주는걸 해보자
					$("#div2").append(option2);
				} else {
					// 사용자 설정 체크 해제
					$("input[name='rec_option2']:radio").prop('checked', false);
				}
			});
	$("input[name='rec_option1']:radio").click(function() {
		if (confirm("변경하시겠습니까?") == true) {
			// 체크 해제
			$("input[name='rec_option2']:radio").prop('checked', false);

			// 체크하자마자 인풋을 없애자
			$("#div2").empty();
		}
	});
}

function changeEmailSelectToInput() {
	$("select").change(
			function() {
				var t = $(this).val();
				if (t == "직접입력") {
					// 아래 인풋으로 줄거니까 기본껄 없애야 해
					$(this).removeAttr("name");
					var eaddr2 = $("<input>").attr("class", "ei2").attr("name",
							"aac_email2").attr("id", "aac_email2").attr(
							"placeholder", "직접입력").attr("maxlength", "23");
					$("select").remove();
					$("#aac_emailIN").append(eaddr2);
				} else {
					$("#aac_emailIN").empty();
					$(this).attr("name", "aac_email2");
				}
			});
}
// 이메일 확인하기
function checkEmailCheckEvent() {
	var aac_email1Input = document.joinForm.aac_email1;
	var aac_email2Input = document.joinForm.aac_email2;
	$("#aac_emailBT").click(function() {
		var aac_email1 = $("#aac_email1").val();
		var aac_email2 = $("#aac_email2").val();
		$.getJSON("member.email.check?aac_email=" + aac_email1
				+ aac_email2, function(email) {
			if (email.member[0] == null) {
				alert(aac_email1 + aac_email2 + "은 사용 가능합니다.");
			} else {
				alert("사용할 수 없는 이메일입니다.");
				aac_email1Input.value = "";
				aac_email2Input.value = "";
			}
		});
	});
}

// 시리얼 넘버가 실제로 있는지를 Temp에서 가져와서 비교
// else부분이 작동 안함
function checkSerialCheckEvent() {
	var sNumberInput = document.joinForm.aac_member_serial_number;
	$("#aac_serialBT").click(function() {
		var sNumber = $("#aac_member_serial_number").val();
		$.getJSON("member.serial.check?aac_serial_number=" 
			+ sNumber, function(serial) {
				var ar = serial.temp;
				alert(ar[0].aac_serial_number);
				
			if (ar[0].aac_serial_number != null) {
				alert("사용가능한 시리얼번호입니다.");
			} else {
				alert(sNumber + "은 등록되지 않은 시리얼번호입니다.");
				sNumberInput.value = "";
			}
		});
	});
}
