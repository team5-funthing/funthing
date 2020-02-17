<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<img src="${pageContext.request.contextPath}/resources/user/img/test/testinggw.png">
<button id="requestBtn">${param.test } ${test }</button>



<div id="includepage"></div>


<script>

document.getElementById('includepage').innerHTML='<b>asdfasdf</b>';
$(function() {

    $("#requestBtn").on("click", function() {

        // URL 주소에 존재하는 HTML 코드에서 <li>요소를 읽은 후에 id가 "list"인 요소에 배치함.

        $("#list").load("/funthing/src/main/webapp/WEB-INF/views/userViews/p-index.jsp");

    });
});
</script>
</head>
<body>

<p>If you click on me, I will disappear.</p>
<p>Click me away!</p>
<p>Click me too!</p>

<!-- 
<div id="div1">여기는 div</div>
<button id="btn-text">text()</button>
<button id="btn-html">html()</button>

<hr>
<input type="text" id="input1" value="여기는 input" />
<button id="btn-val">val()</button>
 -->
</body>
</html>