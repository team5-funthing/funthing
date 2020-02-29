<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js" lang="zxx">

<head>
<script>
    sessionStorage.getItem("memberSession");
    
    </script>
  <jsp:include page="./include/i-head-setting.jsp" />  
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Montana</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">





   <jsp:include page="./include/i-popupover-mypage.jsp" />
   <jsp:include page="./include/i-header.jsp" />

<script>
        $(function () {


            // Use custom options for the right button
            $('#mypage-btn').gpopover({
                width: 360,
                preventHide: true,
                onShow: function () {
                    if (console && console.log) console.log("Popover shown.");
                },
                onHide: function () {
                    if (console && console.log) console.log("Popover hidden.");
                }
            });
        });
    </script>
</head>

<body>

	<hr>

	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-6">

				<div class="col mt-5 ">

					<div class="mt-10">
						<div class="h4">프로필 변경 [프로필 설정]</div>
						<hr>
					</div>

					<div class="d-flex justify-content-start mt-5">
						<div class="col-3 mr-4">프로필 사진 </div>
						<div class="col-10">
							<form id="imageupload" action="saveimage2.udo" method="post"
								enctype="multipart/form-data">
								<div class="row">
									<div class="col-5 align-self-center">
										<label for="image"> 
										<input type="file" name="imgname" accept="image/*" 	id="image" style="display: none; "  />
											<div id="detail-mypage-profile-img" class="">
												<img class="profile"
													src="${sessionScope.memberSession.myImage }">
											</div>
										</label>
									</div>
									<div class="col align-self-center">
										<div>
											<label for="imageButton">
											<input type="submit"  
												class="genric-btn success medium" style="width: 110px;"
												value="저장" />
											</label>
										</div>
										<div class="mt-2">
											<input type="button" formaction=""
												class="genric-btn success medium" style="width: 110px;"
												value="삭제">
										</div>
							
									</div>
								</div>
							</form>
						</div>
					</div>
					<hr>
					<form>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">비밀번호 변경하기</label> <input
									type="password" class="form-control" id="password"
									name="password" required>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">비밀번호 확인</label> <input
									type="password" class="form-control" id="passwordcheck"
									required>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">연락처</label> <input type="text"
									class="form-control" id="phone" name="phone" required>
								<label for="exampleFormControlTextarea1" class="mr-1"> -
									없이 입력해주세요</label>
							</div>
						</div>


						<div class="form-row">
							<div class="form-group mb-3 w-100">
								<label for="exampleFormControlTextarea1" class="mr-1">소개</label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									rows="3"></textarea>
							</div>
						</div>

						<hr>
						<div class="form-inline pb-5 justify-content-center">
							<div class="mt-10">
								<input type="button" value="회원탈퇴"
									class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									formaction="deleteCheckMember.udo">
								<script>
                                
                                    
                                    </script>
							</div>
							<div class="mt-10">
								<input type="button" value="취소"
									class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									formaction="mypage.udo">
							</div>
							<div class="mt-10">
								<button
									class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									formaction="updateMember.udo">완료</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-2"></div>

		</div>

	</div>


   <jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>

</html>