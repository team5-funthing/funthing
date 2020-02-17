<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>




<div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <div class="col align-self-center">
                    
                        <form action="successjoin.udo" method="post">
                            <div class="mt-10">
                                <h2>회원가입</h2>
                            </div>
                       
                            <div class="mt-10">
                                <h5>이메일 </h5>
                                <input type="email" id="email" name ="email" placeholder="이메일 입력" value="" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = '이메일 입력'" required class="single-input">
                            </div>
                            <div class="col-xl-12 mt-10">
                                <button type="button" onclick="" class="boxed-btn3">이메일 중복확인 </button>
                            </div>
							     <div class="mt-10">
                                <h5>이름</h5>
                                <input type="text" id="name" name ="name" placeholder="이름" value="" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = '이름'" required class="single-input">
                            </div>
                                <input type="hidden" id="password" name="password" value="">
                        
                         
                            <div class="col-xl-12 mt-10">
                                <button type="submit" class="boxed-btn3"> 회원가입 </button>
                                <button type="submit" class="boxed-btn3" formaction="socialLoginSuccess.udo" > 이미 회원가입을 하셨던 분들은 여기를 눌러주세요</button>
                            </div>
                            <div class="mt-10">
                                <a class="btn btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                    href="joinselect.udo">뒤로가기</a>
                            </div>
                            <hr>
                        </form>
                     
                    </div>
                </div>
                <div class="col">
                </div>
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
    var naverName = naver_id_login.getProfileData('name')
    document.getElementById("name").value = naverName;
 
    var naverId = naver_id_login.getProfileData('id');
    document.getElementById("password").value = naverId;
	 }

	
	
	
  }
</script> 
    
    
    
    
    
</body>
</html>