<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>

<html class="no-js">

<head>

<jsp:include page="./include/i-head-setting.jsp" />

</head>

<body>

   <jsp:include page="./include/i-popupover-mypage.jsp" />
   <jsp:include page="./include/i-header.jsp" />


   <section class="main-wrapper pt-xl-5 ">
      <div class="main-content">
         <div class="container">

            <div class="row">
               <div class="col-12">
                  <div class="d-flex justify-content-start mb-3">
                     <div id="detail-mypage-profile-img" style="background: #BDBDBD;">
                        <img id="gogoimage3" class="profile" src="${sessionScope.memberSession.myImage }">
                     </div>
                     <div class="h2 login-id align-self-center ml-4">${sessionScope.memberSession.name} </div>
                  </div>

                  <div class="d-flex justify-content-start mb-3">
                     <div class="d-inline-flex p-2 bd-highlight">
                        <a
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                           href="updateProfile.udo">프로필 변경</a>
                     </div>
                     <div class="d-inline-flex p-2 bd-highlight">
                        <a
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                           href="showDetailMyPage.udo">메세지</a>
                       <input type="hidden" name="email" value="${sessionScope.memberSession.email}">
                       
 
                     </div>
                     
                     <div class="d-inline-flex p-2 bd-highlight">
                     
                        <a href="javaScript: return(0);" onclick="document.getElementById('paymentReservationCheckListForm').submit()"
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3">
                           	결제내역 확인
                           </a>
                     </div>
                     
                     
                  </div>

                  <hr>
                  <div class="h4 mt-5 pb-3" style="color: black;">프로젝트 현황</div>
                  <div class="d-flex justify-content-start">
                     <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                           <a class="nav-item nav-link active" id="nav-created-prj-list-tab" data-toggle="tab"
                              href="#nav-created-prj-list" role="tab"  aria-controls="nav-created-prj-list" aria-selected="true">만든  프로젝트</a>  
                           <a class="nav-item nav-link" id="nav-like-prj-list-tab" data-toggle="tab" 
                              href="#nav-like-prj-list" role="tab" aria-controls="nav-like-prj-list" aria-selected="false">좋아요  프로젝트</a>

                        </div>
                     </nav>
                  </div>

                  <br>
          
                  <div class="tab-content" id="nav-active-prj-tab">
                  
                  
                     <!-- 카드 시작 -->
                     <div class="tab-pane fade show active " id="nav-created-prj-list"
                        role="tabpane" aria-labelledby="nav-created-prj-list-tab">
						
                        <div class="container pt-5 pb-5">
                           <section class="tiles">
                           
                              <!----------------만든 프로젝트 양식 -------------------->
                              <c:if test="${not empty myProjectList }">
	                              <c:forEach var="myProject" items="${myProjectList }" varStatus="step" >
		                              <article>
		                              		<aside class="row ml-1 mb-0 pb-0">
		                                 		<c:choose>
		                                 			<c:when test="${myProject.funding eq 'n'.charAt(0) }"> <!-- 펀징 진행 확인 -->
		                                 			
			                                 			<c:choose>
				                                 			<c:when test="${myProject.status eq 'n'.charAt(0) }">  <!-- 제출 및 심사 확인 -->
					                                 			<c:choose>
						                                 			<c:when test="${myProject.writeStatus eq 'n'.charAt(0) }"> <!-- 작성 완료 확인 -->
						                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-secondary">작성중</a></h5>	
						                                 			</c:when>
						                                 			<c:when test="${myProject.writeStatus eq 'y'.charAt(0) }">
					                                 					<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-light">미제출</a></h5>
						                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-info">작성완료</a></h5>
						                                 			</c:when>
					                                 			</c:choose>		
				                                 			</c:when>                              			
				                                 			<c:when test="${myProject.status eq 'w'.charAt(0) }">
				                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-secondary">심사중</a></h5>
				                                 			</c:when>
				                                 			<c:when test="${myProject.status eq 'm'.charAt(0) }">
					                                 			<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-warning">수정 요구</a></h5>
				                                 			</c:when>
				                                 			<c:when test="${myProject.status eq 'f'.charAt(0) }">
					                                 			<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-danger">승인 거절</a></h5>
				                                 			</c:when>
			                                 			</c:choose>
		                                 			</c:when>	  
		                                 			                               			
		                                 			<c:when test="${myProject.funding eq 'y'.charAt(0) }">
		                                 			
		                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-primary">펀딩중</a></h5>
		                                 			
		                                 			</c:when>
		                                 			
		                                 			<c:when test="${myProject.funding eq 'e'.charAt(0) }">
		                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-dark mr-2">펀딩마감</a></h5>
		                                 				<c:choose>
											  				<c:when test="${myProject.fundingMoney < myProject.goalMoney }">
											  					<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-danger">실패</a></h5>
											  				</c:when>
											  				<c:otherwise>
											  					<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-success">성공</a></h5>                                
											  				</c:otherwise>
		                                 				</c:choose>
		                                 			</c:when>
		                                 		</c:choose>
		                                 	</aside>
		                                 <div class="project pt-0 mt-0" style="min-width: 265px;">
		                                    <div class="card" style=" border-radius: 10px;">
		                                       <div class="thumbnail-wrap">
		                                          <div class="thumbnail " style="border-top-left-radius: 10px 10px;
																										border-top-right-radius: 10px 10px;">
		                                             <div class="centered">
	                                             		<c:choose>
	                                             			<c:when test="${myProject.funding == 'y'.charAt(0) }">
	                                             				
	                                             				<form id="previewForm${step.count }" action="projectDetails.udo" method="GET">
	                                             					<input type="hidden" name="projectNo" value="${myProject.projectNo}">
		                                             				<a href="javaScript: return(0);" onclick="document.getElementById('previewForm${step.count }').submit()">
				                                             			<c:choose>
						                                             		<c:when test="${myProject.projectMainImage eq '' }">
						                                             				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
						                                             					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
						                                             		<c:when test="${myProject.projectMainImage ne '' }">
						                                             			<img src="${myProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
				                                             			</c:choose>  
			                                             			</a>
				                                             	</form>
	                                             			</c:when>
	                                             			<c:when test="${myProject.funding == 'e'.charAt(0) }">
	                                             				
	                                             				<form id="previewForm${step.count }" action="projectDetails.udo" method="GET">
	                                             					<input type="hidden" name="projectNo" value="${myProject.projectNo}">
		                                             				<a href="javaScript: return(0);" onclick="document.getElementById('previewForm${step.count }').submit()">
				                                             			<c:choose>
						                                             		<c:when test="${myProject.projectMainImage eq '' }">
						                                             				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
						                                             					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
						                                             		<c:when test="${myProject.projectMainImage ne '' }">
						                                             			<img src="${myProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
				                                             			</c:choose>  
			                                             			</a>
				                                             	</form>
	                                             			</c:when>
	                                             			<c:otherwise>
	                                             			
	                                             				<form id="previewForm${step.count }" action="showPreviewProject.udo?projectNo=${myProject.projectNo}" method="POST">
		                                             				<a href="javaScript: return(0);" onclick="document.getElementById('previewForm${step.count }').submit()">
				                                             			<c:choose>
						                                             		<c:when test="${myProject.projectMainImage eq '' }">
						                                             				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
						                                             					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
						                                             		<c:when test="${myProject.projectMainImage ne '' }">
						                                             			<img src="${myProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
				                                             			</c:choose>  
			                                             			</a>
				                                             	</form>
	                                             			</c:otherwise>
	                                             		</c:choose>
		                                             </div>
		                                          </div>
		                                       </div>
												
		                                       <div class="card-body pb-2 flex-column bd-highlight" style="min-height:231px;">
		                                       
													  <c:choose>
		                                          		  <c:when test="${myProject.projectTitle eq '' }">
		                                          			  <div class="card-title h5" style="color: black; font-weight: 450;" >제목을 입력해주세요.</div>
		                                          		  </c:when>
		                                          		  <c:otherwise>
		                                          			  <div class="card-title h5" style="color: black; font-weight: 450;" >${myProject.projectTitle }</div>
		                                          		  </c:otherwise>
		                                          	  </c:choose>
		                                          	
			                                          <ul>
			                                          	<c:choose>
			                                          		<c:when test="${myProject.projectSummary eq '' }">
			                                          			<li style="color: gray; min-height: 50px;" >스토리 요약 입력하세요.</li>
			                                          		</c:when>
			                                          		<c:otherwise>
			                                          			<li style="color: gray; min-height: 50px;"  >${myProject.projectSummary }</li>
			                                          		</c:otherwise>
			                                          	</c:choose>
				                                             <li style="color: gray;">목표 금액 : ${myProject.goalMoney }</li>
			                                          	<c:choose>
			                                          		<c:when test="${myProject.endDate eq null }">
			                                          			<li style="color: gray;" >마감날짜를 정해주세요.</li>
			                                          		</c:when>
			                                          		<c:otherwise>
			                                          			<li style="color: gray;" >마감일 : ${myProject.endDate }</li>
			                                          		</c:otherwise>
			                                          	</c:choose>
			                                          </ul>
			                                          
													<div class="mt-auto bd-highlight">
														<div class="percentage mt-5">
													
															<fmt:formatNumber type="number" var="progressPercent"
																value="${(myProject.fundingMoney / myProject.goalMoney)*100}"
																pattern=".00" />
															<fmt:formatNumber type="number" var="progress"
																maxFractionDigits="3" value="${myProject.fundingMoney}" />

															<div class="progress" style=" height: 7px;">
																<div class="progress-bar" role="progressbar"
																	style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
																	aria-valuemin="0" aria-valuemax="100"></div>
															</div>
																																		
															<c:choose>
																<c:when test="${myProject.fundingMoney eq 0}">
																	<p>${progress}원  0%진행중</p>
																</c:when>
																<c:otherwise>
																	<p>${progress}원 ${progressPercent}%진행중</p>													
																</c:otherwise>
															</c:choose>
															
														</div>
													</div>
		                                       </div>				
		                                       <div class="card-footer p-2" style="border-top : none;">
											   		<div class="d-flex justify-content-center">
				                                          <a class="btn btn-sm btn-outline-secondary m-1" 
				                                          	href="getWritingProject.udo?creator=${myProject.creator}&currentProjectNo=${myProject.projectNo }">수정</a>
				                                          	
				                                          	
				                                          	
				                                          <form action="deleteProject.udo" method="GET" id="deleteProjectForm">	
				                                          	  <input type="hidden" name="currentProjectNo" value="${myProject.projectNo}">	
				                                          	  <a class="btn btn-sm btn-outline-secondary m-1" id="deleteProjectBtn"
					                                          	  href="javascript:return(0);">삭제</a>
					                                      </form>
					                                      
					                                      	
					                                      	
					                                          	             
				                                          <c:choose>
				                                 			<c:when test="${myProject.funding eq 'y'.charAt(0) || myProject.funding eq 'e'.charAt(0) }"> <!-- 펀징 진행중일때 -->
				                                         		<a class="btn btn-sm btn-outline-secondary m-1" 
				                                         			href="getSatistics.udo?currentProjectNo=${myProject.projectNo }">통계</a>
				                                          	</c:when>
				                                          </c:choose>
				                                          <form action="rewardSupportCheck.udo" method="GET" id="rewardSupportCheck${step.count }">
				                                          	<input type="hidden" name="projectNo" value="${myProject.projectNo}">
				                                          	<a class="btn btn-sm btn-outline-secondary m-1"
				                                          		href="javaScript: return(0);" onclick="document.getElementById('rewardSupportCheck${step.count }').submit()">후원내역</a>
				                                          </form>
		                                          	</div>

		                                          
		                                       </div>
		                                    </div>
		                                 </div>
		                              </article>
	                              </c:forEach>
                              </c:if>
                              <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                           <c:if test="${empty myProjectList }">
                                <div class="row pt-5 pb-5 ">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 pt-5 pb-5 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                           
                                            <div class="h3" style="color: gray;">'만든' 프로젝트가 없습니다</div>
                                            <div class="h5" style="color: gray;">

					                                                상단 메뉴바에서 '프로젝트 올리기' 버튼을 눌러
					                                                회원님의 아이디어를 제안할 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                           </c:if>
                        </div>
                     </div>
               
                     <!-- 좋아요 프로젝트 시작 -->
                     <div class="tab-pane fade " id="nav-like-prj-list" role="tabpane" aria-labelledby="nav-like-prj-list-tab">
                        <div class="container pt-5 pb-5">
                           <section class="tiles">
                              <c:if test="${not empty projectLikeList }">
	                              <c:forEach var="likeProject" items="${projectLikeList }" varStatus="step" >
		                              <article>
		                              		<aside class="row ml-1 mb-0 pb-0">
		                                 		<c:choose>
		                                 			<c:when test="${likeProject.funding eq 'n'.charAt(0) }"> <!-- 펀징 진행 확인 -->
		                                 			
		                                 			</c:when>	                                 			
		                                 			<c:when test="${likeProject.funding eq 'y'.charAt(0) }">
		                                 			
		                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-primary">펀딩중</a></h5>
		                                 			
		                                 			</c:when>
		                                 			<c:when test="${likeProject.funding eq 'e'.charAt(0) }">
		                                 			
		                                 				<h5><a href="javascript: return(0);" class="btn btn-sm btn-outline-dark">펀딩마감</a></h5>
		                                 			
		                                 			</c:when>
		                                 		</c:choose>
		                                 	</aside>
		                                 <div class="project pt-0 mt-0" style="min-width: 265px;">
		                                    <div class="card" style=" border-radius: 10px;">
		                                       <div class="thumbnail-wrap">
		                                          <div class="thumbnail " style="border-top-left-radius: 10px 10px;
																										border-top-right-radius: 10px 10px;">
		                                             <div class="centered">
	                                             		<c:choose>
	                                             			<c:when test="${likeProject.funding == 'y'.charAt(0) }">
	                                             				
	                                             				<form id="previewForm${step.count }" action="projectDetails.udo" method="GET">
	                                             					<input type="hidden" name="projectNo" value="${likeProject.projectNo}">
		                                             				<a href="javaScript: return(0);" onclick="document.getElementById('previewForm${step.count }').submit()">
				                                             			<c:choose>
						                                             		<c:when test="${likeProject.projectMainImage eq '' }">
						                                             				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
						                                             					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
						                                             		<c:when test="${likeProject.projectMainImage ne '' }">
						                                             			<img src="${likeProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
				                                             			</c:choose>  
			                                             			</a>
				                                             	</form>
	                                             			</c:when>
	                                             			<c:otherwise>
	                                             			
	                                             				<form id="previewForm${step.count }" action="showPreviewProject.udo?projectNo=${likeProject.projectNo}" method="POST">
		                                             				<a href="javaScript: return(0);" onclick="document.getElementById('previewForm${step.count }').submit()">
				                                             			<c:choose>
						                                             		<c:when test="${likeProject.projectMainImage eq '' }">
						                                             				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
						                                             					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
						                                             		<c:when test="${likeProject.projectMainImage ne '' }">
						                                             			<img src="${likeProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
						                                             		</c:when>
				                                             			</c:choose>  
			                                             			</a>
				                                             	</form>
	                                             			</c:otherwise>
	                                             		</c:choose>
		                                             </div>
		                                          </div>
		                                       </div>
												
		                                       <div class="card-body pb-2 flex-column bd-highlight" style="min-height:231px;">
			                                        <div class="card-title h5" style="color: black; font-weight: 450;" >${likeProject.projectTitle }</div>
			                                          <ul>
			                                             <li style="color: gray; min-height: 50px;" >${likeProject.projectSummary }</li>
			                                             <li style="color: gray;">목표금액 : ${likeProject.goalMoney }</li>
			                                             <li style="color: gray;">마감일 : ${project.endDate }</li>
			                                          </ul>
													<div class="mt-auto bd-highlight">
														<div class="percentage mt-5">
															<fmt:formatNumber type="number" var="progressPercent"
																value="${(likeProject.fundingMoney / likeProject.goalMoney)*100}"
																pattern=".00" />
															<fmt:formatNumber type="number" var="progress"
																maxFractionDigits="3" value="${likeProject.fundingMoney}" />

															<div class="progress" style=" height: 7px;">
																<div class="progress-bar" role="progressbar"
																	style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
																	aria-valuemin="0" aria-valuemax="100"></div>
															</div>
																																		
															<c:choose>
																<c:when test="${likeProject.fundingMoney eq 0}">
																	<p>${progress}원  0%진행중</p>
																</c:when>
																<c:otherwise>
																	<p>${progress}원 ${progressPercent}%진행중</p>													
																</c:otherwise>
															</c:choose>
														</div>
													</div>
		                                       </div>
		                                       <div class="card-footer p-2" style="border-top : none;">
		                                       </div>
		                                    </div>
		                                 </div>
		                              </article>
	                              </c:forEach>
                              </c:if>
                           </section>
                           
                              <c:if test="${empty projectLikeList }">
                                <div class="row pt-5 pb-5">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 pt-5 pb-5 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                            <div class="h3" style="color: gray;">'좋아요' 누른 프로젝트가 없습니다</div>
                                            <div class="h5" style="color: gray;">

					                          	프로젝트 상세페이지로 이동하여 '좋아요' 버튼을 누르면
												선호하는 프로젝트를 확인할 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                              </c:if>
                        </div>
                     </div>
  					<!-- 좋아요 프로젝트 종료 -->
  
                  </div>
               </div>

            </div>
         </div>
      </div>
   </section>
   
   
  	<form action ="#" method="POST" id="deleteProjectConfirmPopup" class="white-popup-block mfp-hide" >
         <div class="popup_box">
             <div class="popup_inner">
            		<p>프로젝트를 정말 삭제하시겠습니까?</p>
                  <div class="d-flex justify-content-center mt-3">
                      <a href="javaScript:return(0);" class="deleteProjectOKBtn btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">확인</a>
                      <a href="javaScript:return(0);" class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">취소</a>
                  </div>
             </div>
         </div>
     </form>

	<script>
		$(document).on("click", "#deleteProjectBtn", function() {

			var okBtn = $(this);

			$.magnificPopup.open({
				items : {
					src : '#deleteProjectConfirmPopup'
				},
				type : 'inline',
				preloader : false,
				modal : true

			});

			$(document).on('click', '.popup-modal-dismiss', function(e) {
				e.preventDefault();
				$.magnificPopup.close();
			});

			$(document).on("click", ".deleteProjectOKBtn", function() {
				okBtn.closest("form").submit();
			});

		})
	</script>






	<jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>

</html>