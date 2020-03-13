<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>

<html class="no-js" lang="zxx">


<head>

<jsp:include page="./include/i-head-setting.jsp" />
<style>
#tostos{
	float:right;
}
.showThing{
	margin-bottom:40px;
}
.agree{
	text-align:center;
	position: relative;
  	background: #FFF;
  	padding: 20px;
  	width:auto;
  	height:auto;
  	max-width: 500px;
  	margin: 10px auto;
}
.ItemShow{float:right;margin:5px;}
.ItemName{float:left;margin-left:15px;}
a{text-decoration:none;}
</style>
<script>
function checkFunction(){
	var finalAgree=document.getElementById("finalAgree");
	var firstAgree=document.getElementById("firstAgree");
	if(firstAgree.checked==true){
		$("#finalAgree").attr("checked",true);
	}
	if(finalAgree.checked==true){
		$("#name").removeAttr("readonly");
		$(".hideButton").css({'pointer-events':'auto'});
		$("input[name='email']").removeAttr("readonly");
		$("input[name='emailCheck']").removeAttr("readonly");
		$("input[name='password']").removeAttr("readonly");
		$("input[name='passwordCheck']").removeAttr("readonly");
	}else{
		$("#name").val("");
		$("#email").val("");
		$("input[name='emailCheck']").val("");
		$("input[name='password']").val("");
		$("input[name='passwordCheck']").val("");
		$("#name").attr("readonly",true);
		$(".hideButton").css({'pointer-events':'none'});
		$("input[name='email']").attr("readonly",true);
		$("input[name='emailCheck']").attr("readonly",true);
		$("input[name='password']").attr("readonly",true);
		$("input[name='passwordCheck']").attr("readonly",true);
	}
}
$(document).ready(function(){
	$("#name").attr("readonly",true);
	$("#email").attr("readonly",true);
	$("#emailCheck").attr("readonly",true);
	$("#password").attr("readonly",true);
	$("#passwordCheck").attr("readonly",true);
	$(".hideButton").css({'pointer-events':'none'});
	$("#registerTos1").hide();
	$("#inputRegisterTos").hide();
	$("#inputPersonalInfo").hide();
	
	
	$('.tosAgree').magnificPopup({
		type:'inline',
		midClick:true
	});
	$("#registerTos").click(function(){
		$("#registerTos1").toggle("slow");
		$.ajax({
			type:"post",
			url:"getRegisterTos.udo",
			success:function(data){
				$("#registerTos1").html(data);
			},
			error:function(){
				alert('실패');
			}
		});
	});
	$("#serviceTos").click(function(){
		$("#inputRegisterTos").toggle("slow");
		$.ajax({
			type:"post",
			url:"getServiceTos.udo",
			success:function(data){
				$("#inputRegisterTos").html(data);
			},
			error:function(){
				alert("실패");
			}
		});
	});
	$("#PersonalInfo").click(function(){
		$("#inputPersonalInfo").toggle("slow");
		$.ajax({
			type:"post",
			url:"getPersonalInfo.udo",
			success:function(data){
				$("#inputPersonalInfo").html(data);
			},
			error:function(){
				alert("실패");
			}
		});
	});
	
});
</script>
<style>

</style>
</head>

<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />

	<!-- 회원가입 양식 start -->
	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<div class="col align-self-center">
						<form action="successjoin.udo" method="post" name="memberForm">
							<div class="mt-10">
								<h2>회원가입</h2>
							</div>
							<div id="loginTos">
								<!-- href 값 : popup을 띄울 영역에 대한 값 -->
								<!-- class 속성 : javascript의 이벤트 처리 -->
								<input type="checkbox" id="finalAgree" onclick="checkFunction()">&nbsp;&nbsp;&nbsp;약관 동의(필수)<a href="#showTosAgree" class="tosAgree" id="tostos">>>></a>
							</div>
							<!-- 약관 동의 팝업 시작 -->
							<!-- class 속성 : css처리 부분, 팝업으로 보일 부분이므로 감추어야 한다. -->
							<div id="showTosAgree" class="agree mfp-hide">
								<div class="showThing"><input type="checkbox" id="firstAgree" onclick="checkFunction()"> 서비스 이용약관 동의(필수)</div><br>
								<div class="showThing">
									<span class="ItemName">회원가입 약관</span>
									<span class="ItemShow"><a id="registerTos">내용 보기</a></span>
								</div>
								<div style="overflow:auto;height:150px;" id="registerTos1">
								</div>
								<br>
								<div class="showThing">
									<span class="ItemName">리워드 서비스 이용약관</span>
									<span class="ItemShow"><a id="serviceTos">내용 보기</a></span>
									<div id="rewardTos"></div>
								</div>
								<div style="overflow:auto;height:150px;" id="inputRegisterTos">
								</div>
								<br>
								<div class="showThing">
									<span class="ItemName">리워드 서비스 개인정보취급방침</span>
									<span class="ItemShow"><a id="PersonalInfo">내용 보기</a></span>
									<div id="rewardPersonalInfo"></div>
								</div>
								<div style="overflow:auto;height:150px;" id="inputPersonalInfo">
								</div>
								<br>
							</div>
							<!-- 약관 동의 팝업 종료 -->
							<div class="mt-10">
								<h5>이름</h5>
								<input type="text" name="name" id="name" placeholder="이름"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '이름'" class="single-input">
							</div>
							<div class="mt-10">
								<h5>이메일 입력</h5>
								<input type="email" id="email" name="email" placeholder="이메일 입력"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '이메일 입력'" required
									class="single-input"> 
								<div id="inputEmail"></div>
								<a class="hideButton btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
									href="javascript:duplicateCheck()">이메일 중복확인</a> 
								<input type="hidden" name="email2" id="email2">
							</div>
							<div class="mt-10">
								<a class="hideButton btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
									href="javascript:popup()">인증번호 보내기</a>
								<input type="text" name="emailCheck" id="emailCheck" placeholder="인증번호를 입력하세요"
									onfocus="this.placeholder = ''" onblur="this.placeholder = '인증번호를 입력하세요'" required
									class="single-input">
							</div>

							<script
								src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
							<script>
								
							</script>
							<input id="sessionCode" type="hidden" name="sessionCode" value="">
							<div class="mt-10">
								<h5>비밀번호</h5>
								<input type="password" name="password" id="password"
									placeholder="비밀번호를 입력하세요 (8자 이상)"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '비밀번호를 입력하세요 (8자 이상)'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="password" name="passwordCheck" id="passwordCheck"
									placeholder="비밀번호를 입력하세요 (8자 이상)"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = '비밀번호를 입력하세요 (8자 이상)'" required
									class="single-input">
							</div>
							<div id="loginInputCheck"></div>
							<div class="col-xl-12 mt-10">
								<input class="hideButton btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
									type="button" onclick="joindo()" value="완료">
							</div>
							<div class="mt-10">
								<a class="btn btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									href="joinselect.udo">뒤로가기</a>
							</div>
							<hr>
						</form>

					</div>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</div>
	<!-- 회원가입 폼 end -->

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>
	<script>
		var mform = document.memberForm;
		var checking = false;
		var loginData = {
			"email" : document.getElementById("email2").value,
			"password" : document.getElementById("password").value,
			"name" : mform.name.value
		};

		function duplicateCheck() {
			var typedEmail = {
				"typedEmail" : document.getElementById("email").value
			};
			
			if(typedEmail.typedEmail==""){
				$("#inputEmail").empty();
				$("#inputEmail").append("이메일을 입력하여 주시기 바랍니다.").css('color','Tomato').css('font-size','75%');
				return;
			}
			var emailExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
            if(!emailExp.test($("input[id='email']").val())){
            	$("#inputEmail").empty();
         	   	$("#inputEmail").append("맞지 않는 이메일 표현식 입니다.").css('color','MediumSeaGreen').css('font-size','75%');
         	   	$("input[id='email']").val();
         	   	return;
            } 
			
			$.ajax({
				type : "GET",
				url : "emailCheck.udo",
				data : typedEmail,
				success : function(data) {
					if (data == '1') {
						$("#inputEmail").empty();
						$("#inputEmail").append("사용 가능한 메일입니다.").css('color','MediumSeaGreen').css('font-size','75%');
						document.getElementById('email').disabled = true;
						checking = true;
					} else if(data=='2'){
						$("#inputEmail").empty();
						$("#inputEmail").append("이미 가입된 메일입니다.").css('color','Tomato').css('font-size','75%');
						document.getElementById('email').value = "";
					} else if(data=='3'){
						$("#inputEmail").empty();
						$("#inputEmail").append("탈퇴한 회원입니다. 다른 이메일을 이용하여 주세요.").css('color','Tomato').css('font-size','75%');
						document.getElementById('email').value = "";
					}
				},
				error : function() {
					alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.")
				}
			});
		}

		function popup() {

			
			var emailData = {
				"email" : document.getElementById('email').value
			};
			if(emailData.email==""){
				$("#inputEmail").empty();
				$("#inputEmail").append("이메일을 입력하여 주시기 바랍니다.").css('color','Tomato').css('font-size','75%');
				return;
			}
			var emailExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
            if(!emailExp.test($("input[id='email']").val())){
            	$("#inputEmail").empty();
         	   	$("#inputEmail").append("맞지 않는 이메일 표현식 입니다.").css('color','Tomato').css('font-size','75%');
         	   	$("input[id='email']").val();
         	   	return;
            }
            if(checking==false){
            	$("#inputEmail").empty();
         	   	$("#inputEmail").append("이메일 중복확인을 먼저 해주세요.").css('color','Tomato').css('font-size','75%');
         	   	return;
            }
			
			$.ajax({
				type : "GET",
				url : "certification.udo",
				data : emailData,
				success : function(data) {
					alert("인증코드가 이메일로 발송되었습니다!");
					document.getElementById("sessionCode").value = data;
				},
				error : function() {
					alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.")
				}
			});
		}

		function joindo() {
			var mform = document.memberForm;
			console.log(document.getElementById("name").value);
			if(document.getElementById("name").value!=""){
			if (checking) {
				if (mform.emailCheck.value == mform.sessionCode.value && mform.emailCheck.value.length >= 10) {
					if (mform.password.value == mform.passwordCheck.value && mform.password.value.length >= 8) {
						var loginData = {"email" : document.getElementById("email").value,
								"password" : document.getElementById("password").value,
								"name": document.getElementById("name").value};
						  $.ajax({ type:"POST",
						     url:"successjoin.udo",
						     data:loginData,
						     success:function(data){   
						        if(data=='1'){
						    		alert("회원가입에 성공했습니다");
						       		location.href="member.udo";	
						        }else{
						  
						        }
						     },error:function(){
						        alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
						     }
						 });
					} else {
						$("#loginInputCheck").empty();
						$("#loginInputCheck").append("입력된 비밀번호가 다르거나 비밀번호를 8자 이상으로 입력해 주세요").css('color','Tomato').css('font-size','75%');
					}
				} else {
					$("#loginInputCheck").empty();
					$("#loginInputCheck").append("입력된 인증번호가 다릅니다.").css('color','Tomato').css('font-size','75%');
				}
			} else {			
				$("#loginInputCheck").empty();
				$("#loginInputCheck").append("이메일 중복확인을 먼저 해주세요.").css('color','Tomato').css('font-size','75%');
			}
		}else{
			$("#loginInputCheck").empty();
			$("#loginInputCheck").append("이름을 입력해주세요.").css('color','Tomato').css('font-size','75%');
		}
	}
	</script>
</body>

</html>