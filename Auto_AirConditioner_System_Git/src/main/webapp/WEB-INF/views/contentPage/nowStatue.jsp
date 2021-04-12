<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="weatherToday">
		<div class="title">오늘의 날씨</div>
		<div class="middle">
			<div class="weatherValue">${nowTemp }<span class="mark">℃</span></div>
			<div class="weatherWord">체감 온도</div>
			<div class="line"></div>
		</div> 
		<div class="middle">
			<div class="weatherValue">${nowHumidity }<span class="mark">%</span></div>
			<div class="weatherWord">상대 습도</div>
		</div> 
		<div class="end">
			<button onclick="goTempShow();">AAC 서비스 시작하기</button>
		</div>		  

	</div>
</body>