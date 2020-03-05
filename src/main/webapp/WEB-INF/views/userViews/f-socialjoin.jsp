<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./include/i-head-setting.jsp" />
<meta charset="UTF-8">
<title>소셜로그인</title>
</head>
<body>
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
		charset="utf-8"></script>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />



	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<div class="col align-self-center">

						<form action="#" method="post" name="joinform">
							<div class="mt-10">
								<h2>회원가입</h2>
							</div>

							<div class="mt-10">
								<h5>이메일</h5>
								<input type="email" id="email" name="email" placeholder="이메일 입력"
									value="" onfocus="this.placeholder = ''"
									onblur="this.placeholder = '이메일 입력'" required
									class="single-input"> 
									<input type="hidden" name="email2" id="email2">
							</div>
							<div class="col-xl-12 mt-10">
								<button type="button" onclick="duplicateCheck()"
									class="boxed-btn3">이메일 중복확인</button>
								<script>
                                var checking = false;
                                var joinform = document.joinform;
                             
								function duplicateCheck(){
     								  alert("중복확인 실행");
                                       var typedEmail = {"typedEmail":document.getElementById("email").value};  
                               
                                         $.ajax({ type:"GET",
                                          url:"emailCheck.udo",
                                          data:typedEmail,
                                          success:function(data){   
                                             if(data=='1'){
                                               alert("사용 가능한 이메일 입니다.");
                                               document.getElementById('email').disabled=true;
                                                  checking=true;
                                             }else{
                                                document.getElementById('email').value="";
                                                alert("이미 가입된 메일 입니다.");
                                             }
                                          },error:function(){
                                             alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                                          }
                                       });   
                                    }

                                	function join(){
                                		var loginData  ={"email":document.getElementById("email").value,"password":document.getElementById("password").value,"name":document.getElementById("name").value}; 
                                        
                                		if(checking){
                                		 $.ajax({ type:"POST",
                                             url:"successjoin.udo",
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

   
                                	function login(){
                                		 alert("로그인 실행");
                                         var loginData  ={"email":document.getElementById("email2").value,"password":document.getElementById("password").value,"name":document.getElementById("name").value}; 
                                		 $.ajax({ type:"POST",
                                             url:"socialLoginSuccess.udo",
                                             data:loginData,
                                             success:function(data){   
                                                if(data=='1'){
                                                 location.href="member.udo";
                                                }else{
                                                   alert("가입되지 않은 이메일 입니다. 회원가입을 먼저 해 주세요.");
                                                }
                                             },error:function(){
                                                alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                                             }
                                          });   
                                	}
                                	
                                </script>
							</div>
							<div class="mt-10">
								<h5>이름</h5>
								<input type="text" id="name" name="name" placeholder="이름"
									value="" onfocus="this.placeholder = ''"
									onblur="this.placeholder = '이름'" required class="single-input">
							</div>
							<input type="password" id="password" name="password" value="">


							<div class="col-xl-12 mt-10">
								<button type="button" onclick="join()" class="boxed-btn3">
									회원가입</button>

							</div>
							<div class="col-xl-12 mt-10">
								<button type="button" onclick="login()" class="boxed-btn3">
									회원 로그인</button>
							</div>
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
   
	$(document).ready(function(){
		if(getParam('eamil')!=null){
			var daumEmail = getParam('email');
			document.getElementById('email').value = daumEmail;
			document.getElementById('email2')=daumEmail;
			var daumPassword = getParam('password');
			document.getElementById('password').value = daumPassword;
			var daumName = decodeURIComponent(getParam('name'));
			document.getElementById('name').value = daumName;		
		}
	});
   
   var naver_id_login = new naver_id_login("bm_Jr_lzbfVgnsh6sEyX", "http://localhost:8080/funthing/.udo");
  // 접근 토큰 값 출력
 // alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
	 if(naver_id_login.getProfileData('email')!=null){
    var naverEemail = naver_id_login.getProfileData('email');
    document.getElementById("email").value = naverEemail;
    document.getElementById("email2").value = naverEemail;
    var naverName = naver_id_login.getProfileData('name')
    document.getElementById("name").value = naverName;
 
    var naverId = naver_id_login.getProfileData('id');
    document.getElementById("password").value = naverId;
	 }

	
	
	
  }
</script>


	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>




</body>
</html>