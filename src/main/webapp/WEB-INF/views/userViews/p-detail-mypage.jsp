<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

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
                        <img class="profile" src="${sessionScope.memberSession.myImage }">
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
                        <a
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                           href="#">결제내역 확인</a>
                     </div>
                  </div>

                  <hr>
                  <div class="h4 mt-5 pb-3">프로젝트 현황</div>
                  <div class="d-flex justify-content-start">
                     <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                           <a class="nav-item nav-link active"
                              id="nav-created-prj-list-tab" data-toggle="tab"
                              href="#nav-created-prj-list" role="tab"
                              aria-controls="nav-created-prj-list" aria-selected="true">만든
                              프로젝트</a> <a class="nav-item nav-link"
                              id="nav-sponsored-prj-list-tab" data-toggle="tab"
                              href="#nav-sponsored-prj-list" role="tab"
                              aria-controls="nav-sponsored-prj-list" aria-selected="false">후원한
                              프로젝트</a> <a class="nav-item nav-link"
                              id="nav-like-prj-list-tab" data-toggle="tab" 
                              href="#nav-like-prj-list" role="tab"
                              aria-controls="nav-like-prj-list" aria-selected="false">좋아요
                              프로젝트</a><a class="nav-item nav-link" 
                              id="nav-like-prj-list-tab"
                              data-toggle="tab" href="#nav-reserved-prj-list" role="tab"
                              aria-controls="nav-like-prj-list" aria-selected="false">예정중인 관심
                              프로젝트</a><a class="nav-item nav-link" 
                              id="nav-like-prj-list-tab"
                              data-toggle="tab" href="#nav-report-prj-list" role="tab"
                              aria-controls="nav-report-prj-list" aria-selected="false">신고한 프로젝트</a>
                        </div>
                     </nav>
                  </div>

                  <br>
          
                  <div class="tab-content" id="nav-active-prj-tab">
                  
                  
                     <!-- 카드 시작 -->
                     <div class="tab-pane fade show active " id="nav-created-prj-list"
                        role="tabpane" aria-labelledby="nav-created-prj-list-tab">
						
                        <div class="container">
                           <section class="tiles">
                           
                              <!----------------만든 프로젝트 양식 -------------------->
                              <c:if test="${not empty myProjectList }">
	                              <c:forEach var="myProject" items="${myProjectList }" varStatus="step" >
		                              <article>
		                                 <div class="project">
		                                 	<aside class="row ml-1">
		                                 	
		                                 		<c:choose>
		                                 			<c:when test="${myProject.funding eq 'n'.charAt(0) }"> <!-- 펀징 진행 확인 -->
		                                 			
			                                 			<c:choose>
				                                 			<c:when test="${myProject.status eq 'n'.charAt(0) }">  <!-- 제출 및 심사 확인 -->
				                                 				
					                                 			<c:choose>
						                                 			<c:when test="${myProject.writeStatus eq 'n'.charAt(0) }"> <!-- 작성 완료 확인 -->
						                                 				<h5><a href="javascript: return(0);" class="badge badge-info m-1">작성중</a></h5>	
						                                 			</c:when>
						                                 			<c:when test="${myProject.writeStatus eq 'y'.charAt(0) }">
					                                 					<h5><a href="javascript: return(0);" class="badge badge-dark m-1">미제출</a></h5>
						                                 				<h5><a href="javascript: return(0);" class="badge badge-success m-1">작성완료</a></h5>
						                                 			</c:when>
					                                 			</c:choose>		
				                                 			</c:when>                              			
				                                 			<c:when test="${myProject.status eq 'w'.charAt(0) }">
				                                 				<h5><a href="javascript: return(0);" class="badge badge-light m-1">심사중</a></h5>
				                                 			</c:when>
				                                 			<c:when test="${myProject.status eq 'm'.charAt(0) }">
					                                 			<h5><a href="javascript: return(0);" class="badge badge-warning m-1">수정 필요</a></h5>
				                                 			</c:when>
				                                 			<c:when test="${myProject.status eq 'f'.charAt(0) }">
					                                 			<h5><a href="javascript: return(0);" class="badge badge-danger m-1">승인 실패</a></h5>
				                                 			</c:when>

			                                 			</c:choose>
		                                 			
		                                 				
		                                 			
		                                 			</c:when>
		                                 			
		                                 			<c:when test="${myProject.funding eq 'y'.charAt(0) }">
		                                 			
		                                 				<h5><a href="javascript: return(0);" class="badge badge-primary m-1">펀딩중</a></h5>
		                                 			
		                                 			</c:when>
		                                 		</c:choose>
			                                 	
		                                 	</aside>
		                                    <div class="card">
		                                       <div class="thumbnail-wrap">
		                                          <div class="thumbnail ">
		                                             <div class="centered">
		                                             	<form id="previewForm${step.count }" action="showPreviewProject.udo?projectNo=${myProject.projectNo}" method="POST">
		                                             		<a href="#" onclick="document.getElementById('previewForm${step.count }').submit()">
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
		                                             </div>
		                                          </div>
		                                       </div>
		
		                                       <div class="card-body">
		                                          <h5 class="card-title">${myProject.projectTitle }</h5>
		                                          <ul>
		                                             <li>요약 설명 : ${myProject.projectSummary }</li>
		                                             <li>목표 금액 : ${myProject.goalMoney }</li>
		                                             <li>기간 :${project.startDate } ~ ${project.endDate }</li>
		                                          </ul>
		
		                                          <p>현재 후원받은 금액 : ${myProject.fundingMoney }원   ${(project.fundingMoney div myProject.goalMoney)*100 }%</p>
		                                          <div class="progress">
		                                             <div class="progress-bar color-7" role="progressbar"
		                                                style="width: 50%" aria-valuenow="30" aria-valuemin="0"
		                                                aria-valuemax="100"></div>
		                                          </div>
		                                       </div>
		                                       <div class="card-footer">
		                                          <a href="getWritingProject.udo?currentProjectNo=${myProject.projectNo }">수정</a>
		                                          <a href="deleteProject.udo?currentProjectNo=${myProject.projectNo }">삭제</a>
		                                       </div>
		                                    </div>
		                                 </div>
		                              </article>
	                              </c:forEach>
                              </c:if>
                              <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                           <c:if test="${empty myProjectList }">
                                <div class="row">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                            <div >
                                                <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"/><polyline points="22,6 12,13 2,6"/></svg>
                                            </div>
                                            <div class="h3">보낸 메시지가 없습니다</div>
                                            <div class="h5">

					                                                프로젝트 페이지에서 '문의하기' 버튼을 눌러
					                                                메시지를 보낼 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                           </c:if>
                        </div>
                     </div>
               <!--  카드모듈 끝    그대로 가져다  id 값만 변경해서 써 일단. -->
               
               
                     <div class="tab-pane fade" id="nav-sponsored-prj-list"
                        role="tabpane" aria-labelledby="nav-sponsored-prj-list-tab">
                         <div class="container">
                           <section class="tiles">
                                  <!----------------만든 프로젝트 양식 -------------------->
                              <c:if test="${not empty projectList }">
                              <c:forEach var="project2" items="${projectList }">
                              <article>
                                 <div class="project">
                                    <div class="card">
                                       <div class="thumbnail-wrap">
                                          <div class="thumbnail ">
                                             <div class="centered">
                                                  <%/*  <img src="${myProjectList.projectMainImage}"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">  */ %>
                                        <!-- 테스트용 -->            <img src="${pageContext.request.contextPath}/resources/user/img/test/2.jpg"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                             </div>
                                          </div>
                                       </div>

                                       <div class="card-body">
                                          <h5 class="card-title">${project2.projectTitle }</h5>
                                          <ul>
                                             <li>요약 설명 : ${project2.projectSummary }</li>
                                             <li>목표 금액 : ${project2.goalMoney }</li>
                                             <li>기간 : ${project2.startDate } ~ ${project2.endDate }</li>
                                          </ul>

                                          <p>현재 후원받은 금액 : ${project2.fundingMoney }원 ${(project2.fundingMoney div project2.goalMoney)*100 } %</p>
                                          <div class="progress">
                                             <div class="progress-bar color-3" role="progressbar"
                                                style="width: 50%" aria-valuenow="30" aria-valuemin="0"
                                                aria-valuemax="100"></div>
                                          </div>
                                       </div>

                                       <div class="card-footer">
                                          <a href="#">보러가기</a>
                                       </div>
                                    </div>
                                 </div>
                              </article>
                              </c:forEach>
                              </c:if>
                           
                            <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                              <c:if test="${empty projectList }">
                                <div class="row">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                            <div >
                                                <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"/><polyline points="22,6 12,13 2,6"/></svg>
                                            </div>
                                            <div class="h3">보낸 메시지가 없습니다</div>
                                            <div class="h5">

					                                                프로젝트 페이지에서 '문의하기' 버튼을 눌러
					                                                메시지를 보낼 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                              </c:if>

                        </div>
                        
                     </div>           
                     <div class="tab-pane fade " id="nav-like-prj-list" role="tabpane"
                        aria-labelledby="nav-like-prj-list-tab">
                        <div class="container">
                           <section class="tiles">
                           
                              <c:if test="${not empty projectLikeList }">
                              <c:forEach var="project3" items="${projectLikeList }">
                              <article>
                                 <div class="project">
                                    <div class="card">
                                       <div class="thumbnail-wrap">
                                          <div class="thumbnail ">
                                             <div class="centered">
                                                 <%/*  <img src="${myProjectList.projectMainImage}"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">  */ %>
                                        <!-- 테스트용 -->            <img src="${pageContext.request.contextPath}/resources/user/img/test/2.jpg"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                             </div>
                                          </div>
                                       </div>

                                       <div class="card-body">
                                          <h5 class="card-title">${project3.projectTitle }</h5>
                                          <ul>
                                             <li>요약 설명 : ${project3.projectSummary }</li>
                                             <li>목표 금액 : ${project3.goalMoney }</li>
                                             <li>기간 : ${project3.startDate } ~ ${project3.endDate }</li>
                                          </ul>

                                          <p>현재 후원받은 금액 : ${project3.fundingMoney }원 ${(project3.fundingMoney div project3.goalMoney)*100 } %</p>
                                          <div class="progress">
                                             <div class="progress-bar color-3" role="progressbar"
                                                style="width: 50%" aria-valuenow="30" aria-valuemin="0"
                                                aria-valuemax="100"></div>
                                          </div>
                                       </div>

                                       <div class="card-footer">
                                          <a href="#">보러가기</a>
                                       </div>
                                    </div>
                                 </div>
                              </article>
                              </c:forEach>
                              </c:if>
                         
                           <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                              <c:if test="${empty projectLikeList }">
                                <div class="row">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                            <div >
                                                <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"/><polyline points="22,6 12,13 2,6"/></svg>
                                            </div>
                                            <div class="h3">보낸 메시지가 없습니다</div>
                                            <div class="h5">

					                                                프로젝트 페이지에서 '문의하기' 버튼을 눌러
					                                                메시지를 보낼 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                              </c:if>
                        </div>
                     </div>
  
  
    				<!-- 카드 시작 -->
          
                     <div class="tab-pane fade" id="nav-reserved-prj-list"
                        role="tabpane" aria-labelledby="nav-reserved-prj-list-tab">

                        <div class="container">
                           <section class="tiles">
                              <!----------------만든 프로젝트 양식 -------------------->
                             <c:if test="${not empty projectReservationList }">
                              <c:forEach var="project4" items="${projectReservationList }">
                              <article>
                                 <div class="project">
                                    <div class="card">
                                       <div class="thumbnail-wrap">
                                          <div class="thumbnail ">
                                             <div class="centered">
                                              <%/*  <img src="${myProjectList.projectMainImage}"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">  */ %>
                                        <!-- 테스트용 -->            <img src="${pageContext.request.contextPath}/resources/user/img/test/2.jpg"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                             </div>
                                          </div>
                                       </div>

                                       <div class="card-body">
                                          <h5 class="card-title">${project4.projectTitle }</h5>
                                          <ul>
                                             <li>요약 설명 : ${project4.projectSummary }</li>
                                             <li>목표 금액 : ${project4.goalMoney }</li>
                                             <li>기간 : ${project4.startDate } ~ ${project4.endDate }</li>
                                          </ul>

                                          <p>현재 후원받은 금액 : ${project4.fundingMoney }원 ${(project4.fundingMoney div project4.goalMoney)*100 } %</p>
                                          <div class="progress">
                                             <div class="progress-bar color-3" role="progressbar"
                                                style="width: 50%" aria-valuenow="30" aria-valuemin="0"
                                                aria-valuemax="100"></div>
                                          </div>
                                       </div>

                                       <div class="card-footer">
                                          <a href="#">보러가기</a>
                                       </div>
                                    </div>
                                 </div>
                              </article>
                              </c:forEach>
                              </c:if>
                          
                              <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                               <c:if test="${empty projectReservationList }">
                                <div class="row">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                            <div >
                                                <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"/><polyline points="22,6 12,13 2,6"/></svg>
                                            </div>
                                            <div class="h3">보낸 메시지가 없습니다</div>
                                            <div class="h5">

					                                                프로젝트 페이지에서 '문의하기' 버튼을 눌러
					                                                메시지를 보낼 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                              </c:if> 
                        </div>
                     </div>
               <!--  카드모듈 끝    그대로 가져다  id 값만 변경해서 써 일단. -->
   
   
   
   
   
   
   
    				<!-- 카드 시작 -->
                     <div class="tab-pane fade" id="nav-report-prj-list"
                        role="tabpane" aria-labelledby="nav-report-prj-list-tab">

                        <div class="container">
                           <section class="tiles">
                              <!----------------만든 프로젝트 양식 -------------------->
                             <c:if test="${not empty projectReportList }">
                              <c:forEach var="project" items="${projectReportList }">
                              <article>
                                 <div class="project">
                                    <div class="card">
                                       <div class="thumbnail-wrap">
                                          <div class="thumbnail ">
                                             <div class="centered">
                                              <%/*  <img src="${myProjectList.projectMainImage}"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">  */ %>
                                        <!-- 테스트용 -->            <img src="${pageContext.request.contextPath}/resources/user/img/test/2.jpg"
                                                   class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                             </div>
                                          </div>
                                       </div>

                                       <div class="card-body">
                                          <h5 class="card-title">${project.projectTitle }</h5>
                                          <ul>
                                             <li>요약 설명 : ${project.projectSummary }</li>
                                             <li>목표 금액 : ${project.goalMoney }</li>
                                             <li>기간 : ${project.startDate } ~ ${project.endDate }</li>
                                          </ul>

                                          <p>현재 후원받은 금액 : ${project.fundingMoney }원 ${(project.fundingMoney div project.goalMoney)*100 } %</p>
                                          <div class="progress">
                                             <div class="progress-bar color-3" role="progressbar"
                                                style="width: 50%" aria-valuenow="30" aria-valuemin="0"
                                                aria-valuemax="100"></div>
                                          </div>
                                       </div>

                                       <div class="card-footer">
                                          <a href="#">보러가기</a>
                                       </div>
                                    </div>
                                 </div>
                              </article>
                              </c:forEach>
                              </c:if>
                          
                              <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                               <c:if test="${empty projectReportList }">
                                <div class="row">
                                    <div class="col">
                                    </div>
                                    <div class="col-8 d-flex justify-content-center ">
                                        <div class="pt-5 pb-5 ">
                                            <div >
                                                <svg xmlns="http://www.w3.org/2000/svg" width="60" height="60" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round" class="feather feather-mail"><path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"/><polyline points="22,6 12,13 2,6"/></svg>
                                            </div>
                                            <div class="h3">보낸 메시지가 없습니다</div>
                                            <div class="h5">

					                                                프로젝트 페이지에서 '문의하기' 버튼을 눌러
					                                                메시지를 보낼 수 있습니다.
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                    </div>
                                </div>
                              </c:if> 
                        </div>
                     </div>
               <!--  카드모듈 끝    그대로 가져다  id 값만 변경해서 써 일단. -->
               
                  </div>
               </div>

            </div>
         </div>
      </div>
   </section>

   <jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>

</html>