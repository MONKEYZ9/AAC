<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="joinBox">
		<div class="joinTitle">회원가입</div>
		<form action="member.join" method="post" name="joinForm" onsubmit="return joinBoxCheck();">
			<input id="aac_member_serial_number" class=""
				name="aac_member_serial_number" autofocus="autofocus"
				autocomplete="off" maxlength="9" placeholder="시리얼넘버">
			<!-- 나중에 있는지 확인해야 하는 용도로 중복검사를 해야해  -->
			<div id="aac_serialBT">시리얼 넘버 확인</div>
			<input id="aac_email1" class="ei1" name="aac_email1"
				autofocus="autofocus" autocomplete="off" maxlength="40"
				placeholder="이메일주소"> 
			<select id="aac_email2" name="aac_email2" class="es1">
				<option value="">직접 입력</option>
				<option value="@gmail.com">gmail.com</option>
				<option value="@naver.com">naver.com</option>
			</select>
			<div id="aac_emailIN"></div>
			<!-- 이거는 직접입력한거를 js로 바꿔서 받을 수 있게 js파일로 append할 수 있게 바꿔놨다. -->
			<div id="aac_emailBT">이메일 중복검사</div>
			<input class="" name="aac_password" autocomplete="off" type="password"
				placeholder="비밀번호" maxlength="18"> 
			<input class="" name="aac_pwCheck" autocomplete="off" type="password"
				placeholder="비번 재확인" maxlength="18"> 
			<fieldset>
				<legend>성별</legend>
				<input id="radio1" name="aac_sex" type="radio" value="male" checked="checked">
				<label for="radio1">남자</label>
				<input id="radio2" name="aac_sex" type="radio" value="fem">
				<label for="radio2">여자</label>
				<input id="radio3" name="aac_sex" type="radio" value="none">
				<label for="radio3">안알려줌</label>
			</fieldset>
			<input id="aac_join_addr1" class="" name="aac_join_addr1"
				autofocus="autofocus" autocomplete="off" maxlength="10"
				placeholder="우편번호" readonly="readonly"> 
			<input id="aac_join_addr2" class="" name="aac_join_addr2"
				autofocus="autofocus" autocomplete="off" maxlength="40"
				placeholder="주소" readonly="readonly">
			<input id="aac_join_addr3" class="" name="aac_join_addr3"
				autofocus="autofocus" autocomplete="off" maxlength="40"
				placeholder="상세주소"> 
			<input id="aac_age" class="" name="aac_age"
				autofocus="autofocus" autocomplete="off" maxlength="2"
				placeholder="나이">
			<button>AAC 회원 가입</button>
		</form>
	</div>
</body>
</html>