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

		<div class="row">
			<div class="col-2"></div>
			<div class="col-6">

				<div class="col mt-5 ">

					<div class="mt-10">
						<div class="h4">프로필 변경 [프로필 설정]</div>
						<hr>
					</div>
				<form id="saveimage" action="saveimage2.udo" method="post" enctype="multipart/form-data">
					<div class="d-flex justify-content-start mt-5">
						<div class="col-3 mr-4">프로필 사진
							<p></p>
							<br>
							<p></p>
							<div>				
								<input type="button"  class="genric-btn success medium" style="width: 110px;"	onclick="clickedBtn()" value="저장" />
							</div>
							<div class="mt-2">
								<input type="submit" formaction="deleteimage.udo" class="genric-btn success medium" style="width: 110px;" value="삭제">
							</div>
						
						
						 </div>
						<div class="col-10">
							<div class="row">
								<div class="col-5 align-self-center">
									<label for="image2"> 
										<input  type="file"  id="image2" name="imgname" accept="image/*" style="display: none;">
										<!-- accept속성은 서버로 업로드 할 수있는 파일의 타입을 명시 --> 
                 						<img class="profile" id="gogoimage4" src="${sessionScope.memberSession.myImage}">
                 						<!-- src에 선언되어진 주소를 통해서 이미지를 불러오게 된다. -->
									</label>
								</div>
								<div class="col align-self-center">
								</div>
							</div>
						</div>
					</div>
				</form>
				<hr>
				<input type="hidden" id="ok123" value="${ok }">
			 	<script>
			 		$(document).ready(function(){
			 		  	var ok=	document.getElementById("ok123").value;
			 		   	if(ok==1){
			 				alert('회원정보 가 수정되었습니다.');
			 		  	}
			 		});
			 		//change메소드는 선택된 요소의 value가 변화되는 경우 callback함수를 실행하는 메소드이다.
			 		$("#image2").change(function(){
		            	if(this.files[0]){
		            		var reader = new FileReader;							//비동기로 파일을 읽어올 수 있는 FileReader
		            		reader.onload = function(data){							//이미지 읽기가 완료(성공)되면
		            			$("#gogoimage4").attr("src", data.target.result);	//읽어온 내용을 반환한다. src 속성에 읽어온 내용을 입력
		            		}
		            		reader.readAsDataURL(this.files[0]); 
		            	}
		            });																//해당 input tag에 value값이 변동하게 되면 
			 		
			 		
		            function clickedBtn(){
					   var form = new FormData(document.getElementById("saveimage"));
                       $.ajax({
                    	   url:"saveimage.udo",
                    	   data:form,
                    	   type:"POST",
                    	   cache:false,
                    	   processData:false,
                    	   contentType:false,
                    	   success:function(data){
                    		 alert("프로필 이미지가 변경됐습니다.");
                    	   },
                    	   error : function() {
                   			alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                   		}
                       });
					  }
                       </script> 

					<form id ="updateForm" name="updateForm" action="updateMember.udo" method="post">
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">이메일</label> 
								<input type="text" class="form-control" id="email"  onfocus="this.placeholder = ''"	onblur="this.placeholder = '현재 비밀번호를 입력하세요'"
									name="email" value="${member.email}" style="width:250px;" required readonly>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">현재 비밀번호</label> 
								<input type="password" class="form-control" id="nowPassword" 
								placeholder="현재 비밀번호를 입력하세요" onfocus="this.placeholder = ''"	onblur="this.placeholder = '현재 비밀번호를 입력하세요'"
								name="nowPassword" style="width:250px;" required>
							</div>
						</div>
						<div id="nowPasswordCheck"></div>
						<div class="form-row">
							<div class="col-md-4 mb-3">						
								<label for="validationDefault01">비밀번호 변경하기</label> 
								<input type="password" class="form-control" id="password"  placeholder="8자리이상 입력하세요" onfocus="this.placeholder = ''"	onblur="this.placeholder = '8자리이상 입력하세요'"
									name="password" style="width:250px;" required>
							</div>
						</div>


						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">비밀번호 확인</label> <input
									type="password" class="form-control" id="passwordcheck"
									placeholder="8자리이상 입력하세요" style="width:250px;" onfocus="this.placeholder = ''"	onblur="this.placeholder = '8자리이상 입력하세요'"
									required>
							</div>
						</div>
						<div id="encodedPasswordCheck"></div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">이름</label> <input
									type="text" class="form-control" id="name" 
									placeholder="이름을 입력해주세요" onfocus="this.placeholder = ''"	onblur="this.placeholder = '현재 비밀번호를 입력하세요'"
									name="name" style="width:250px;" value="${member.name}" required >
							</div>
						</div>
						<div id="nameInputCheck"></div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="validationDefault01">연락처</label> 
								<input type="text" placeholder=" - 없이 입력해주세요" onfocus="this.placeholder = ''"	onblur="this.placeholder = ' - 없이 입력해주세요'"
								class="form-control" style="width:250px;" id="phone" name="phone" value="${member.phone}" required>
							</div>
						</div>
						<div id="phoneInputCheck"></div>

						<div class="form-row">
							<div class="form-group mb-3 w-100">
								<label for="exampleFormControlTextarea1" class="mr-1">소개</label>
								<textarea class="form-control" id="introduce" name="introduce" form="updateForm"
									rows="3">${member.introduce}</textarea>
							</div>
						</div>

						<hr>
						<div class="form-inline pb-5 justify-content-center">
							<div class="mt-10">
								<input type="button" value="회원탈퇴"
									class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									onclick="delMember()">
							</div>
							<div class="mt-10">
								<input type="button" value="취소"
									class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									onclick="cancel()">
							</div>
							<div class="mt-10">
								<button
									class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
									onclick="updateMember()">저장</button>
							</div>
						</div>
					</form>
				</div>
			</div>
	</div>




<script>
	
function cancel(){
	location.href="mypage.udo";
}	
//회원정보 삭제
function delMember(){
	var pwData = {"pw":document.getElementById("nowPassword").value};
  $.ajax({
	  type : "POST",
		url : "updateCheck.udo",
		data : pwData,
		success : function(data) {
			if (data == '1') {
				location.href="deleteMember.udo"
				
			} else {
				alert("정보 수정을 위해서는 현재 비밀번호를 정확히 입력해 주세요.");
			}
		},
		error : function() {
			alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
		}
	  
  });
}

//회원정보 가져오기
function updateMember(){
	var pwData = {"pw":document.getElementById("nowPassword").value};
  $.ajax({
	  type : "POST",
		url : "updateCheck.udo",
		data : pwData,
		success : function(data) {
			if (data == '1') {
				$("#nowPasswordCheck").empty();
				$("#nowPasswordCheck").append("비밀번호가 일치합니다.").css('color','MediumSeaGreen').css('font-size','80%');
				if(document.getElementById("password").value==document.getElementById("passwordcheck").value){
					$("#encodedPasswordCheck").empty();
					$("#encodedPasswordCheck").append("변경할 비밀번호가 일치합니다.").css('color','MediumSeaGreen').css('font-size','80%');
					if(document.getElementById("password").value.length >= 8){
						if(!document.getElementById("phone").value.test("-")){
							document.updateForm.submit();
						}else{
							$("#phoneInputCheck").empty();
							$("#phoneInputCheck").append("전화번호를 입력하실 때  '-'을 제외하고 입력해 주세요.").css('color','Tomato').css('font-size','80%');
							$("phone").focus();
							return;
						}
					}else{
						$("#encodedPasswordCheck").empty();
						$("#encodedPasswordCheck").append("비밀번호는 8자리 이상 입력해 주세요.").css('color','Tomato').css('font-size','80%');
						$("#passwordcheck").focus();
						return;
					}
				}else{
					$("#encodedPasswordCheck").empty();
					$("#encodedPasswordCheck").append("변경할 비밀번호가 일치하지 않습니다.").css('color','Tomato').css('font-size','80%');
					$("#passwordcheck").focus();
					return;
				}
				
			} else {
				$("#nowPasswordCheck").empty();
				$("#nowPasswordCheck").append("정보 수정을 위해서는 현재 비밀번호를 정확히 입력해 주세요.").css('color','Tomato').css('font-size','80%');
				$("#nowPassword").focus();
				return;
			}
		},
		error : function() {
			alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
		}
	  
  });
}





</script>

   <jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>

</html>