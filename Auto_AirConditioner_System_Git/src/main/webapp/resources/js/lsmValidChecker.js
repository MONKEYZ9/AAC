/**
 * 어떤 사이트든지 유효성 검사하기 편한 한글 쓸 일 없음 euc-kr을 쓰고 있지만 최종은 utf-8로 가야해
 */

// 유효성 검사를 하면 하는게
// 필수검사(여기를 부정적으로 작업할 것인지 긍정적으로 할 것인지)
// ==> 잘못했으면 true 값을 뱉을 것인가
// ==> 잘했을때 true 값을 뱉을 것인가
// <input>을 넣으면 아무것도 쓰지 않았다면 true, 뭐라도 적었다면 false
// <input>을 넣었는데 뭐라도 쓰여있다면 true, 아무것도 적혀있지 않다면 false
// 부정으로 간다
// 자바스크립트에서는 변수명만 안에 넣어도 된다
function checkInputContent(inputField) {
	return (!inputField.value);
}

// 최소글자수, <input> 글자수 넣었을때 글자수보다 적으면 true, 그 글자수 이상이면 false
function contentLength(content, len) {
	return (content.value.length < len);
}

// 한글/특수문자 제외시키기, <input> 넣었을때 두개가 들어있다면 true, 없다면 false
function onlyEngNum(content) {
	// ok에 있는 것만 쓸 수 있게
	var ok = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._";
	
	var cv = content.value;
	for (var i = 0; i < cv.length; i++) {
		if (ok.indexOf(cv[i]) == -1) {
			return true;
		}
	}
	return false;
}

// 키 적을때 쓰게 한글/특수문자(.)/영어 제외시키기, <input> 넣었을때 두개가 들어있다면 true, 없다면 false
function onlyNum(content) {
	// ok에 있는 것만 쓸 수 있게
	var ok = "1234567890.";
	
	var cv = content.value;
	for (var i = 0; i < cv.length; i++) {
		if (ok.indexOf(cv[i]) == -1) {
			return true;
		}
	}
	return false;
}

// 패스워드 재확인 하는 거, <input> 2개를 넣었을때 내용이 다르면 true
function pwCheck(firstPw, secondPw) {
	return (firstPw.value != secondPw.value);
}


// 비번 조합하는 거, <input>하고 써도 되는 문자열 세트를 넣었을때, 없으면 true 있다면 false
// okSet에 들어가야할 배열을 넣어줘야 한다는 거야
function notContains(content, okSet) {
	var iv = content.value;
	for (var i = 0; i < okSet.length; i++) {
		if (iv.indexOf(okSet[i]) != -1) {
			return false;
		}
	}
	return true;
}

// 숫자만 있는거, <input> 넣었을때 숫자 아닌거 있으면 true
function onlyNum(content) {
	return isNaN(content.value);
}


// 사진 및 파일 넣는거, <input> 확장자 넣었을때 그거 아니면 true
function isNotType(input, type) {
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}










