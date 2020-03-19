<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- mypage popupOver -->
       <div id="popover-mypage-menu" class="gpopover">
           <div class="container">
               <div>
					<div>
						<form action = "paymentReservationCheckList.udo" method = "post" id ="paymentReservationCheckListForm">
							<input type="hidden" name="email" value="${memberSession.email }">
						</form>
						<form id="imgform" action="saveimage.udo" method="post"
							enctype="multipart/form-data">
							<div class="row ml-2 mr-2 mt-4 pb-4">
							
								<div class="col-5">
									<label for="image">
										<div id="profile-img" style="background: #BDBDBD;">
											<input type="file" id="image" name="imgname" accept="image/*"
												style="display: none;"> <img id="gogoimage"
												class="profile" src="${sessionScope.memberSession.myImage }">
										</div>
									</label>
								</div>
								<div class="col-7 d-flex align-items-center">
									<div class="d-flex flex-column bd-highlight mb-3">
										<div class="row">
											<input type="button" onclick="clickedBtn()" value="저장"
												class="genric-btn success small">
										</div>
										<div class="row">
											<p>${sessionScope.memberSession.name}님 환영합니다.</p>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>

					<script>
                        $("#image").change(function(){
                            if(this==$('#image')[0]){    }
                            
                        if(this.files && this.files[0]){
                            var reader = new FileReader;
                            reader.onload = function(data){
                                $("#gogoimage").attr("src", data.target.result);
                                $("#gogoimage2").attr("src", data.target.result);
                                $("#gogoimage3").attr("src", data.target.result);
                            }
                            reader.readAsDataURL(this.files[0]);
                        }
                    }) 
                    
                      function clickedBtn(){
                            
                       var form = new FormData(document.getElementById("imgform"));
                       $.ajax({
                           url:"saveimage.udo",
                           data:form,
                           type:"POST",
                           cache:false,
                           processData:false,
                           contentType:false,
                           success:function(data){
                            if(data=="1"){
                                alert("이미지가 저장되었습니다.");
                            }
                           },
                           error : function() {
                               alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                           }
                       });
                      }
                       </script> 
                   <div class="d-flex flex-column bd-highlight mb-3">
                       <ul class="list-group list-group-flush">
                           <li class="list-group-item"><a href="mypage.udo">
                                   <div class="h5">마이페이지</div>
                               </a></li>
                           
                           <li class="list-group-item"><a href="javaScript: return(0);" onclick="document.getElementById('paymentReservationCheckListForm').submit()">
                                   <div class="h5">후원 결제내역</div>
                               </a></li>
                               </a></li>
                           <li class="list-group-item"><a href="logout.udo">
                                   <div class="h5">로그아웃 하기</div>
                               </a>
                           </li>
                       </ul>
                   </div>
               </div>
           </div>
       </div>
       <!-- mypage popupOver end -->