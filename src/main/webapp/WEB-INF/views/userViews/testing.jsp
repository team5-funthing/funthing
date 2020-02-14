<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="inputeamil" name="inputemail" class="form-control form-control-lg" type="text">
<a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="javascript:popup()">인증번호 보내기</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>>
<script>
  $(function() {
    $("#btn-val").click(function() {
      
    var txt = $('#input1').val();
     $("#div1").text(txt);
      
    });
  
 
  });
</script>

<div id="div1">여기는 div</div>
<button id="btn-text">text()</button>
<button id="btn-html">html()</button>

<hr>
<input type="text" id="input1" value="여기는 input" />
<button id="btn-val">val()</button>

</body>
</html>