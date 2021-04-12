<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="loginBox"><span class="loginTitle">login</span>
		<form action="member.login" method="post" name="loginBox" onsubmit="return loginBoxCheck();">
			<input id="loginInput" name="aac_email" placeholder="xxx@example.com">
			<input id="loginInput" name="aac_password" type="password" placeholder="password">
			<button class="loginBtn">로그인</button>
		</form>
			<button class="loginJoinBtn" onclick="goMemberJoin();">회원가입</button>
	</div>
</body>
</html>