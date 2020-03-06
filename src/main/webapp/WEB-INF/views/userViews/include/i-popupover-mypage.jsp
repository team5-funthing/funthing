<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- mypage popupOver -->
       <div id="popover-mypage-menu" class="gpopover">
           <div class="container">
               <div>
					<div>
						<form action = "paymentReservationCheckList.udo" method = "post" id = "paymentReservationCheckListForm"></form>
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

					<!-- 
                    <div>
                       <div class="d-flex justify-content-around bd-highlight">
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight ">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="fas fa-shapes fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">창작한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight ">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="fas fa-hand-holding-usd fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">후원한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="far fa-surprise fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">반응한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight ">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="fas fa-heart fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">좋아한[미구현]</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </div>
                   </div>
                   -->
                   <div class="d-flex flex-column bd-highlight mb-3">
                       <ul class="list-group list-group-flush">
                           <li class="list-group-item"><a href="mypage.udo">
                                   <div class="h6">마이페이지</div>
                               </a></li>
                           
                           <li class="list-group-item"><a href="javaScript: return(0);" onclick="document.getElementById('paymentReservationCheckListForm').submit()">
                                   <div class="h6">후원 결제내역</div>
                               </a></li>
                           <li class="list-group-item"><a href="#">
                                   <div class="h6">수입내역[미구현]</div>
                               </a></li>
                           <li class="list-group-item"><a href="logout.udo">
                                   <div class="h6">로그아웃 하기</div>
                               </a>
                           </li>
                       </ul>
                   </div>
               </div>
           </div>
       </div>
       <!-- mypage popupOver end -->