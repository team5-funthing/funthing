<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
                        <img class="profile" src="${pageContext.request.contextPath}/resources/user/img/test/${sessionScope.myprofile}">
                     </div>
                     <div class="h2 login-id align-self-center ml-4">${sessionScope.memberSessionName} </div>
                  </div>

                  <div class="d-flex justify-content-start mb-3">
                     <div class="d-inline-flex p-2 bd-highlight">
                        <a
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                           href="#">프로필 변경</a>
                     </div>
                     <div class="d-inline-flex p-2 bd-highlight">
                        <a
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                           href="#">메세지</a>
                     </div>
                     <div class="d-inline-flex p-2 bd-highlight">
                        <a
                           class="btn btn-lg btn-detail-mypage d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                           href="#">결제내역 변경</a>
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
                              프로젝트</a> <a class="nav-item nav-link" id="nav-like-prj-list-tab"
                              data-toggle="tab" href="#nav-like-prj-list" role="tab"
                              aria-controls="nav-like-prj-list" aria-selected="false">좋아요
                              프로젝트</a>
                        </div>
                     </nav>
                  </div>

                  <br>

                  <div class="tab-content" id="nav-active-prj-tab">
                     <div class="tab-pane fade show active" id="nav-created-prj-list"
                        role="tabpane" aria-labelledby="nav-created-prj-list-tab">

                        <div class="container">
                           <section class="tiles">
                              <!----------------만든 프로젝트 양식 -------------------->
                              <article>
                                 <div class="project">
                                    <div class="card">
                                       <div class="thumbnail-wrap">
                                          <div class="thumbnail ">
                                             <div class="centered">
                                                <img src="./img/test/7.jpg"
                                                   class="card-img-top landscape" alt="1.jpg">
                                             </div>
                                          </div>
                                       </div>

                                       <div class="card-body">
                                          <h5 class="card-title">만든 프로젝트 제목1</h5>
                                          <ul>
                                             <li>요약 설명 :</li>
                                             <li>목표 금액 :</li>
                                             <li>기간 :</li>
                                          </ul>

                                          <p>현재 후원받은 금액 : -----원 --- %</p>
                                          <div class="progress">
                                             <div class="progress-bar color-7" role="progressbar"
                                                style="width: 50%" aria-valuenow="30" aria-valuemin="0"
                                                aria-valuemax="100"></div>
                                          </div>
                                       </div>

                                       <div class="card-footer">
                                          <a href="#">스튜디오 가기</a>
                                       </div>
                                    </div>
                                 </div>
                              </article>
                              <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>
                        </div>
                     </div>

                     <div class="tab-pane fade" id="nav-sponsored-prj-list"
                        role="tabpane" aria-labelledby="nav-sponsored-prj-list-tab">
                     </div>
                     <div class="tab-pane fade" id="nav-like-prj-list" role="tabpane"
                        aria-labelledby="nav-like-prj-list-tab">

                        <div class="container">
                           <section class="tiles">
                              <!----------------만든 프로젝트 양식 -------------------->
                              <article>
                                 <div class="project">
                                    <div class="card">
                                       <div class="thumbnail-wrap">
                                          <div class="thumbnail ">
                                             <div class="centered">
                                                <img src="./img/test/1.jpg"
                                                   class="card-img-top landscape" alt="1.jpg">
                                             </div>
                                          </div>
                                       </div>

                                       <div class="card-body">
                                          <h5 class="card-title">만든 프로젝트 제목1</h5>
                                          <ul>
                                             <li>요약 설명 :</li>
                                             <li>목표 금액 :</li>
                                             <li>기간 :</li>
                                          </ul>

                                          <p>현재 후원받은 금액 : -----원 --- %</p>
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
                              <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
                           </section>


                        </div>

                     </div>

                  </div>
               </div>

            </div>
         </div>
      </div>
   </section>

   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>

</html>