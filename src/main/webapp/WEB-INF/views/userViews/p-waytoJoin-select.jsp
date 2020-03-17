<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>

<html class="no-js" lang="zxx">


<head>

<jsp:include page="./include/i-head-setting.jsp" />

</head>

<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />
	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col">
				</div>
				<form action="#">
					<div class="col">
						<div class="col align-self-center">
							<div class=" col d-flex justify-content-center">
								<h2 style="color: black;">회원가입</h2>
							</div>


							<div class="mt-30 d-flex justify-content-center">
								<a href="emailJoin.udo" 
									class="deliveryOKBtn btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss">
									이메일로 가입하기 </a>
							</div>

							<hr>
							<script type="text/javascript"
								src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
								charset="utf-8"></script>

							<div style="width: 15px;"></div>
							<div id="naver_id_login"
								style="width: 277.5; align: center; text-align: center;"></div>

							<script type="text/javascript">
							var naver_id_login = new naver_id_login(
									"T6JggIUb0xG2LBu9Q7Pf",
									"http://localhost:8080/funthing/socialLogin.udo");
							var state = naver_id_login.getUniqState();
							naver_id_login.setButton("green", 3, 60,
									"style='align:center'");
							naver_id_login
									.setDomain("http://localhost:8080/funthing");
							naver_id_login.setState(state);
							naver_id_login.init_naver_id_login();
						</script>

							<div class="col-xl-12 kakao_login_btn-wrapper mt-3"
								style="align: center; text-align: center;">
								<a class="kakao_login_btn" href="javascript:loginWithKakao()">
									<img class="landscape"
									src="${pageContext.request.contextPath}/resources/user/img/apiBtn/kakaoLoginBtn/kakao_account_login_btn_large_wide.png"
									style="height: 55px; width: 277.5px;" />
								</a>
							</div>
							<div class="row mt-1 d-flex justify-content-center mb-5">
								<div class="col-xl-5">
								</div>
								<div class="col-xl-5">
								</div>
							</div>
							<div class="mt-10">
								이미 회원가입을 하셨나요?
								<p class="registry-p">
									<a class="popup-with-form" id="login-popup-btn" href="javascript: return(0);">로그인 하러가기</a>
								</p>
							</div>
						</div>
					</div>
				</form>
				<div class="col">
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		var naver_id_login = new naver_id_login(
				"T6JggIUb0xG2LBu9Q7Pf",
				"http://localhost:8080/funthing/socialLogin.udo");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("green", 3, 60,
				"style='align:center'");
		naver_id_login
				.setDomain("http://localhost:8080/funthing");
		naver_id_login.setState(state);
		naver_id_login.init_naver_id_login();
	</script>


	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type='text/javascript'>
		var id;
		var name;
		var email;
		var url = 'http://localhost:8080/funthing/socialjoin.udo';

		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('05602e69457875d5bc6718b74ef34eb9');
		function loginWithKakao() {

			// 로그인 창을 띄웁니다.
			Kakao.Auth
					.login({
						success : function(json) {
							//alert(json.access_token);
							Kakao.API
									.request({
										url : '/v2/user/me',
										success : function(
												res) {
											//alert(JSON.stringify(res));

											id = res.id;
											name = res.properties.nickname;
											email = res.kakao_account.email;
											location.href = url
													+ '?email='
													+ email
													+ '&password='
													+ id
													+ '&name='
													+ name
													+ '&check=1';

										},
										fail : function(
												error) {
											alert(JSON
													.stringify(error));
										}
									});

						},
						fail : function(err) {
							alert(JSON.stringify(err));
						}
					});
		};
	</script>
	
	
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>
   
</body>

</html>
