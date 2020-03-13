<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./include/i-head-setting.jsp" />
<meta charset="UTF-8">
<title>소셜로그인</title>
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

</script>
</head>
<body>
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />



	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<div class="col align-self-center">

						<form action="getMember.udo" method="post" name="joinform">
							<div class="mt-10">
								<h2>회원가입</h2>
							</div>
							<div id="loginTos">
								<!-- href 값 : popup을 띄울 영역에 대한 값 -->
								<!-- class 속성 : javascript의 이벤트 처리 -->
								<input type="checkbox" id="finalAgree" onclick="checkFunction()">&nbsp;&nbsp;&nbsp;약관 동의<a href="#showTosAgree" class="tosAgree" id="tostos">>>></a>
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
								<h5>이메일</h5>
								<input type="email" id="email2" name="email" placeholder="이메일 입력"
									onfocus="this.placeholder = ''" value="${param.email }"
									onblur="this.placeholder = '이메일 입력'" required
									class="single-input"> 
									<!-- <input type="hidden" name="email2" id="email2"> -->
							</div>
							<div id="duplicateResult"></div>
							<div class="col-xl-12 mt-10">
								<button id="duplButton" type="button" onclick="duplicateCheck()"
									class="boxed-btn3">이메일 중복확인</button>
								
							</div>
							<div class="mt-10">
								<h5>이름</h5>
								<input type="text" id="name" name="name" placeholder="이름"
									value="" onfocus="this.placeholder = ''" 
									onblur="this.placeholder = '이름'" required class="single-input">
							</div>
							<input type="hidden" id="password2" name="password" placeholder="비밀번호"
									value="" onfocus="this.placeholder = ''" 
									onblur="this.placeholder = '비밀번호'" required class="single-input">
							<div id="checkRegisterException"></div>
							<div class="col-xl-12 mt-10">
								<button id="registerButton" type="button" onclick="join()" class="boxed-btn3">
									회원가입</button>

							</div>
							<!-- <div class="col-xl-12 mt-10">
								<button id="loginButton" type="button" onclick="login()" class="boxed-btn3">
									회원 로그인</button>
							</div> -->
							<div class="mt-10">
								<a
									class="btn btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
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


	<script type="text/javascript">
	function checkFunction(){
		var finalAgree=document.getElementById("finalAgree");
		var firstAgree=document.getElementById("firstAgree");
		if(firstAgree.checked==true){
			$("#finalAgree").attr("checked",true);
		}
		if(finalAgree.checked==true){
			$("#email2").removeAttr("disabled");
			$("#duplButton").removeAttr("disabled");
			$("#name").removeAttr("disabled");
			$("#password2").removeAttr("disabled");
			$("#registerButton").removeAttr("disabled");
			$("#loginButton").removeAttr("disabled");
		}else{
			$("#email2").attr("disabled",true);
			$("#duplButton").attr("disabled",true);
			$("#name").attr("disabled",true);
			$("#password2").attr("disabled",true);
			$("#registerButton").attr("disabled",true);
			$("#loginButton").attr("disabled",true);
		}
	}
	$(document).ready(function(){
		$("#duplButton").attr("disabled",true);
		$("#registerButton").attr("disabled",true);
		$("#loginButton").attr("disabled",true);
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
	
	
	
	   var checking = false;

    
		function duplicateCheck(){
              var typedEmail = {"typedEmail":document.getElementById("email2").value};  
              //이메일 형식이 맞는지 확인하기 위한 정규 표현식
              var emailExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
              if(!emailExp.test($("input[id='email2']").val())){
           	   $("#duplicateResult").append("맞지 않는 이메일 표현식 입니다.").css('color','MediumSeaGreen').css('font-size','75%');
           	   $("input[id='email2']").val();
           	   return;
              } 
              
              	$.ajax({ type:"GET",
                 url:"emailCheck.udo",
                 data:typedEmail,
                 success:function(data){   
                    if(data=='1'){
                   	$("#duplicateResult").empty();
                      	$("#duplicateResult").append("사용 가능한 이메일입니다.").css('color','MediumSeaGreen').css('font-size','75%');
                      	document.getElementById('email2').disabled=true;
                         checking=true;
                    }else{
                   	$("#duplicateResult").empty();
                       $("#duplicateResult").append("이미 가입된 메일입니다.").css('color','Tomato').css('font-size','75%');
                       document.getElementById('email2').value="";
                    }
                 },error:function(){
                    alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                 }
              });   
           }

       	function join(){
       		
       		var loginData  ={"email":document.getElementById("email2").value,"password":document.getElementById("password2").value,"name":document.getElementById("name").value}; 
               
       		console.log(loginData.email);
       		
       		if(loginData.email==""){
       			$("#checkRegisterException").empty();
       			$("#checkRegisterException").append("이메일을 입력해주세요").css('color','Tomato').css('font-size','75%');
       			return;
       		}else if(checking==false){
       			$("#checkRegisterException").empty();
       			$("#checkRegisterException").append("이메일 중복확인을 해주세요").css('color','Tomato').css('font-size','75%');
       			return;
       		}else if(loginData.name ==""){
       			$("#checkRegisterException").empty();
       			$("#checkRegisterException").append("이름을 입력 해주세요").css('color','Tomato').css('font-size','75%');
       			return;
       		}else if(loginData.password ==""){
       			$("#checkRegisterException").empty();
       			$("#checkRegisterException").append("비밀번호를 입력 해주세요").css('color','Tomato').css('font-size','75%');
       			return;
       		}
       		
       		if(checking){
       		 $.ajax({ type:"POST",
                    url:"successSocialjoin.udo",
                    data:loginData,
                    success:function(data){   
                       if(data=='1'){
                   		alert("회원가입에 성공했습니다");
                      		location.href="member.udo";
                       }else{
                          alert("가입되지 않은 이메일 입니다. 회원가입을 먼저 해 주세요.");
                       }
                    },error:function(){
                       alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                    }
                 });   
       		}else{
   				alert("이메일 중복확인을 해 주세요.");
   			}
       	}

	
	
	
	
	
	
   function getParam(sname) {
	    var params = location.search.substr(location.search.indexOf("?") + 1);
	    var sval = "";
	    params = params.split("&");
	    for (var i = 0; i < params.length; i++) {
	        temp = params[i].split("=");
	        if ([temp[0]] == sname) { sval = temp[1]; }
	    }
	    return sval;
	} 
   

   
   var naver_id_login = new naver_id_login("bm_Jr_lzbfVgnsh6sEyX", "http://localhost:8080/funthing/.udo");
  // 접근 토큰 값 출력
 // alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
	 
	 if(naver_id_login.getProfileData('email')!=null){
    var naverEmail = naver_id_login.getProfileData('email');
    document.getElementById("email2").value = naverEmail;
    var naverName = naver_id_login.getProfileData('name')
    document.getElementById("name").value = naverName;
 
    var naverId = naver_id_login.getProfileData('id');
    document.getElementById("password2").value = naverId;
	 }
	 
	 
	 var typedEmail = {"typedEmail":document.getElementById("email2").value}; 
	  $.ajax({type:"GET",
	        url:"emailCheck.udo",
	        data:typedEmail,
	        success:function(data){   
	           if(data=='2'){
	        	   
	        	   var loginsubmit = document.createElement("form");
	        		var obj1;
	        		obj1 = document.createElement('input');
	        		obj1.setAttribute('type', 'hidden');
	        		obj1.setAttribute('name', 'name');
	        		obj1.setAttribute('value', naverName);
	        		loginsubmit.appendChild(obj1);
	        		
	        		var obj2;
	        		obj2 = document.createElement('input');
	        		obj2.setAttribute('type', 'hidden');
	        		obj2.setAttribute('name', 'email');
	        		obj2.setAttribute('value', naverEmail);
	        		loginsubmit.appendChild(obj2);
	        		
	        		var obj3;
	        		obj3 = document.createElement('input');
	        		obj3.setAttribute('type', 'hidden');
	        		obj3.setAttribute('name', 'password');
	        		obj3.setAttribute('value', naverId);
	        		loginsubmit.appendChild(obj3);
	        		
	        		loginsubmit.setAttribute('method', 'post');
	        		loginsubmit.setAttribute('action', "getMember.udo");

	        		document.body.appendChild(loginsubmit);
					
	        		loginsubmit.submit();

	           }else{
	              alert("가입되지 않은 이메일 입니다. 회원가입을 먼저 해 주세요.");
	           }
	        },error:function(){
	        	alert("서버와 통신이 실패했습니다. 인터넷상태를 다시 확인해주세요.");
	        }
	  		
	  	});  
	 
	
  }
  
   
   
	$(document).ready(function(){

		if(getParam('check')==1){
           
			var daumEmail = getParam('email');
			document.getElementById('email2').value = daumEmail;
			var daumPassword = getParam('password');
			document.getElementById('password2').value = daumPassword;
			var daumName = decodeURIComponent(getParam('name'));
			document.getElementById('name').value = daumName;	
			var typedEmail = {"typedEmail":document.getElementById("email2").value}; 
			
			  $.ajax({type:"GET",
			        url:"emailCheck.udo",
			        data:typedEmail,
			        success:function(data){   
			           if(data=='2'){
			        	   
			        	   
			        	   var loginsubmit = document.createElement("form");
			        		var obj1;
			        		obj1 = document.createElement('input');
			        		obj1.setAttribute('type', 'hidden');
			        		obj1.setAttribute('name', 'name');
			        		obj1.setAttribute('value', daumName);
			        		loginsubmit.appendChild(obj1);
			        		
			        		var obj2;
			        		obj2 = document.createElement('input');
			        		obj2.setAttribute('type', 'hidden');
			        		obj2.setAttribute('name', 'email');
			        		obj2.setAttribute('value', daumEmail);
			        		loginsubmit.appendChild(obj2);
			        		
			        		var obj3;
			        		obj3 = document.createElement('input');
			        		obj3.setAttribute('type', 'hidden');
			        		obj3.setAttribute('name', 'password');
			        		obj3.setAttribute('value', daumPassword);
			        		loginsubmit.appendChild(obj3);
			        		
			        		loginsubmit.setAttribute('method', 'post');
			        		loginsubmit.setAttribute('action', "getMember.udo");

			        		document.body.appendChild(loginsubmit);
							
			        		loginsubmit.submit();
			        		

			           }else{
			              alert("가입되지 않은 이메일 입니다. 회원가입을 먼저 해 주세요.");
			           }
			        },error:function(){
			        	alert("서버와 통신이 실패했습니다. 인터넷상태를 다시 확인해주세요.");
			        }
			  		
			  	});    
		}
	});
 

 
</script>


	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>




</body>
</html>