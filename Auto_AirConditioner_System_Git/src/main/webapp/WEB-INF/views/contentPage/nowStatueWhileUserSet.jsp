<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="weatherTodayAfterJoin">
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
		<div class="showCurrentSettingsImg">
			<img src="resources/img/bubble.png">
		</div>
		<div class="showCurrentSettings">
		<c:choose>
			<c:when test="${sessionScope.userSagiz == null}">
				AI<br>
				<span>${sessionScope.sagiZ }</span>
			</c:when>
			<c:when test="${sessionScope.userSagiz != null}">
				사용자<br>
				<span>${sessionScope.userSagiz }</span>
			</c:when>
		</c:choose>
		</div> 
		<form action="temp.userData.get">
			<div class="chooseSettings">
				<input id="rec_option1" name="rec_option1" type="radio" checked="checked" value=${sessionScope.sagiZ }>
				추천 설정 : ${sessionScope.sagiZ }<br>
	 		</div>
			<div class="chooseSettings">
				<input id="rec_option2" name="rec_option2" type="radio"
					readonly="readonly" placeholder="사용자 설정" >사용자 설정
	 		</div>
			<div id="div2"></div>
			<div class="chooseSettingsEnd">
				<button class="accBtn">에어컨 설정하기</button>
	 		</div>
		</form>
	</div>


</body>













