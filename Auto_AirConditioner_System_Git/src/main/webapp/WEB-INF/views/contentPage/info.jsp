<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="infoBox">
		<div class="infoTitle">정보 수정</div>
		<input id="serialID" value="${m.aac_member_serial_number }"
			name="aac_member_serial_number" readonly="readonly" autofocus="autofocus">
		<div class="serialChange" onclick="goSerialChange();">시리얼 넘버 변경</div>
		<input id="serialID" value="${m.aac_email }"
			name="aac_member_serial_number" readonly="readonly" autofocus="autofocus">
		<div class="serialChange" onclick="goSerialChange();">이메일 변경</div>
		
	</div>
</body>
</html>