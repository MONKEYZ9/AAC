<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/nowStatue.css">
<link rel="stylesheet" href="resources/css/nowStatueAfterJoin.css">
<link rel="stylesheet" href="resources/css/nowStatueWhileUserSet.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/showInfoLogout.css">
<link rel="stylesheet" href="resources/css/join.css">
<link rel="stylesheet" href="resources/css/info.css">
<script	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/aac_go.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/aac_jQuery.js"></script>
<script type="text/javascript" src="resources/js/lsmValidChecker.js"></script>
<script type="text/javascript" src="resources/js/aac_ValidCheck.js"></script>
</head>
<body>

	<div id="header">
		<a href="index.do"><img src="resources/img/aac_logo.png"></a>
	</div>

	<div id="siteTitleArea">
		<jsp:include page="${logoPage }"></jsp:include>
	</div>
	<div id="siteContentArea">
		<jsp:include page="${contentPage }"></jsp:include>
	</div>
	<div id="siteLoginArea">
		<jsp:include page="${loginPage }"></jsp:include>
	</div>
</body>
</html>