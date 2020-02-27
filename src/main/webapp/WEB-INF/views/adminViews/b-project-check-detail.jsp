<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath }/resources/admin/assets/images/favicon.png">
    <title>Matrix Template - The Ultimate Multipurpose admin template</title>
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/multicheck/multicheck.css">
    <link href="${pageContext.request.contextPath }/resources/admin/assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/css/float-chart.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/resources/admin/dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body>
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <jsp:include page="include/i-topbar-header.jsp"/>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <jsp:include page="include/i-left-sidebar.jsp"/>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">projectCehckList</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#C:\Users\pjh\Desktop\5jo\matrix-admin-master\index.html">Home</a></li>
                                    <!--
                                    <li class="breadcrumb-item active" aria-current="page"></li>
                                    -->
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->



            <!-- 여기에 들어갈거-->
				<div class="card">
					<div class="p-20">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<div class="card-body">
										<h5 class="card-title m-b-0">심사 프로젝트 목록</h5>
										<div class="table-responsive">
										
										
										<!-- 중간 내용 들어가는 부분 -->
										
										<section class="container">

		<div class="w-100">
			<article class="row d-flex justify-content-center">
				<aside id="project-main-img" class="col-7">
					<img class="project-main" src="img/project_check/5.jpg"></a>
				</aside>
				<aside id="project-details-info"
					class="col-5 align-items-start d-flex flex-column bd-highlight">

					<div class="p-2 bd-highlight">
						<div class="h4">모인 금액</div>
						<div class="h2" style="color: #000000">
							500,000원[모인금액]
							<div class="h5" style="color: #000000">50% [달성율]</div>
						</div>
					</div>
					<div class="p-2 bd-highlight">
						<div class="h4">남은 날짜</div>
						<div class="h2" style="color: #000000">
							[날짜 들어오기]
							<div class="h5" style="color: #000000"></div>
						</div>
					</div>
					<div class="p-2 bd-highlight mt-auto ml-0">
						<a
							class="btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
							href="#">프로젝트 밀어주기</a>
					</div>
					<div class="row d-flex justify-content-around m-0 ">
						<a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="#">좋아요</a> <a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="showInsertwAskMessage.udo?projectNo=${vo.projectNo }">문의하기</a> <a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="#">공유하기</a>

					</div>

				</aside>
			</article>

			<hr>

			<div class="w-75">

				<article>
					<div class="row">
						<div class="col-lg-10 posts-list">
							<div class="single-project-details">
								<div class="feature-img">
									<img class="img-fluid" src="#" alt="">
								</div>
								<div class="blog_details">
									<h2>여기에 상세 내용들 어떻게 올릴지 정해야한다.</h2>
									<ul class="project-info-link mt-3 mb-4">
										<li><a href="#"><i class="fa fa-user"></i> 카테고리</a></li>
										<li><a href="#"><i class="fa fa-comments"></i> 03
												리뷰/문의</a></li>
									</ul>
									<p class="excert">MCSE boot camps have its supporters and
										its detractors. Some people do not understand why you should
										have to spend money on boot camp when you can get the MCSE
										study materials yourself at a fraction of the camp price.
										However, who has the willpower</p>
									<p>MCSE boot camps have its supporters and its detractors.
										Some people do not understand why you should have to spend
										money on boot camp when you can get the MCSE study materials
										yourself at a fraction of the camp price. However, who has the
										willpower to actually sit through a self-imposed MCSE
										training. who has the willpower to actually</p>
									<div class="quote-wrapper">
										<div class="quotes">MCSE boot camps have its supporters
											and its detractors. Some people do not understand why you
											should have to spend money on boot camp when you can get the
											MCSE study materials yourself at a fraction of the camp
											price. However, who has the willpower to actually sit through
											a self-imposed MCSE training.</div>
									</div>
									<p>MCSE boot camps have its supporters and its detractors.
										Some people do not understand why you should have to spend
										money on boot camp when you can get the MCSE study materials
										yourself at a fraction of the camp price. However, who has the
										willpower</p>
									<p>MCSE boot camps have its supporters and its detractors.
										Some people do not understand why you should have to spend
										money on boot camp when you can get the MCSE study materials
										yourself at a fraction of the camp price. However, who has the
										willpower to actually sit through a self-imposed MCSE
										training. who has the willpower to actually</p>
								</div>
							</div>
							<div class="navigation-top">
								<div class="d-sm-flex justify-content-between text-center">
									<p class="like-info">
										<span class="align-middle"><i class="fa fa-heart"></i></span>
										Lily and 4 people like this
									</p>
									<div class="col-sm-4 text-center my-2 my-sm-0">
										<!-- <p class="comment-count"><span class="align-middle"><i class="fa fa-comment"></i></span> 06 Comments</p> -->
									</div>
									<ul class="social-icons row">
										<li class="mr-1"><a href="#"><i
												class="fa fa-facebook-f"></i></a></li>
										<li class="mr-1"><a href="#"><i class="fa fa-twitter"></i></a></li>
										<li class="mr-1"><a href="#"><i
												class="fa fa-dribbble"></i></a></li>
										<li class="mr-1"><a href="#"><i class="fa fa-behance"></i></a></li>
									</ul>
								</div>
								<div class="navigation-area">
									<div class="row">
										<div
											class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-centl-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
											<div class="thumb">
												<a href="#"> <img class="img-fluid"
													src="img/project_check/preview.png" alt="">
												</a>
											</div>
											<div class="arrow">
												<a href="#"> <span class="lnr text-white ti-arrow-left"></span>
												</a>
											</div>
											<div class="detials">
												<p>이전 프로젝트</p>
												<a href="#">
													<h4>[프로젝트 제목]</h4>
												</a>
											</div>
										</div>
										<div
											class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
											<div class="detials">
												<p>다음 프로젝트</p>
												<a href="#">
													<h4>[프로젝트 제목]</h4>
												</a>
											</div>
											<div class="arrow">
												<a href="#"> <span class="lnr text-white ti-arrow-right"></span>
												</a>
											</div>
											<div class="thumb">
												<a href="#"> <img class="img-fluid"
													src="img/project_check/next.png" alt="">
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="project-author">
								<div class="media align-items-center">
									<img src="img/project_check/author.png" alt="">
									<div class="media-body">
										<a href="#">
											<h4></h4>
										</a>
										<p>Second divided from form fish beast made. Every of seas
											all gathered use saying you're, he our dominion twon Second
											divided from</p>
									</div>
								</div>
							</div>
		<hr>
		
		<div align="center">
		<form id="statusReplyMessageform" action="updateProjectCheckDeny.ado" method="POST">
			<textarea rows="20" cols="100" name="statusReplyMessage" placeholder="거부/보류 사유 기재하는 곳" ></textarea>
			<input type="hidden" name="projectNo" value="${projectCheck.projectNo}">
			<input type="hidden" name="fm" id="pn" value="">
		</form>
		</div>
		
		
		<form action="updateProjectCheckApproval.ado" method="POST">					
		<div align="center">
			<input type="hidden" name="projectNo"  value="${projectCheck.projectNo}">			
			
			<input type="submit" value="승인">
			
			
			<a href="javaScript: return(0);" onclick="document.getElementById('statusReplyMessageform').submit()"><input type="button" value="거부"></a>
			<!-- 보류 버튼 아직 미완료 상태 -->
			<a href="#"><input type="button" value="보류(미완임)"></a>
			<a href="http://localhost:8080/funthing/getProjectCheckList.ado"><input type="button" value="뒤로"></a>
		
		</div>
		</form>
							
							<!-- projectBoard form 시작 -->
							
							<!-- projectBoard form 끝 -->
							
							
							<!-- proejctBoardList 시작 -->
							<div class="comments-area">
								
								
								<!-- projectBoard 시작 -->
								<c:forEach var="b1" items="${getProjectBoard}">
									<c:if test="${b1.step eq 0}"> 
										
										<div class="comment-list">
											<div class="single-comment justify-content-between d-flex">
												<div class="user justify-content-between d-flex">
													<div class="thumb">
														<img src="${pageContext.request.contextPath}/resources/admin/img/project_check/comment_1.png" alt="">
													</div>
													<div class="desc" style="width: 600px;">
														<p class="comment">
															${b1.projectBoardContents}
														</p>
														<div class="d-flex justify-content-between">
															<div class="d-flex align-items-center">
																<h5>
																	<a href="#">${b1.member.name }</a>
																</h5>
																<p class="date">${b1.projectBoardDate}</p>
															</div>
															<c:choose>
																<c:when
																	test="${ b1.email eq sessionScope.memberSessionEmail }">

																	<div class="reply-btn">
																		<a type="submit" href="getProjectBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																			class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																			수정 </a> 
																		<a type="submit" href="deleteProjectBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																			class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																			삭제 </a>

																	</div>

																</c:when>


																<c:when
																	test="${sessionScope.memberSessionEmail eq 'shn807@naver.com' }">

																		<div class="reply-btn">
																			<a type="submit" href="replyBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																				class="button button-contactForm btn_1 boxed-btn pt-1 pl-3 pr-3 pb-1">
																				Reply </a>
																		</div>
																	</c:when>
															</c:choose>
														</div>
														
														<!-- projectBoard Reply 시작 -->
														<c:forEach var="b2" items="${getProjectBoard}">
															<c:if test="${b1.ref eq b2.ref && b1.step ne b2.step}">
																<div class="d-flex justify-content-around mt-3">
							                                       <div class="d-flex align-items-center">
							                                          <div class="single-comment justify-content-between d-flex">
							                                             <div class="user justify-content-between d-flex p-3"
							                                                style="background-color: whitesmoke;">
							                                                <div class="thumb">
							                                                   <img src="${pageContext.request.contextPath}/resources/admin/img/project_check/comment_2.png" alt="">
							                                                </div>
							                                                <div class="desc" style="width: 500px;">
							                                                    <p class="comment">
							                                                   		${b2.projectBoardContents}
							                                                    </p>
							                                                    <div class="d-flex justify-content-between">
							                                                       <div class="d-flex align-items-center">
							                                                          <h5>
							                                                             <a href="#">${b2.member.name}</a>
							                                                          </h5>
							                                                          <p class="date">${b2.projectBoardDate}</p>
							                                                       </div>
							                                                       <c:if test="${ b2.email eq sessionScope.memberSessionEmail }">
							                                                       	<form action="getProjectBoardReply.udo" method="post">
																						<div class="reply-btn">
																							<input type="submit" 
																							class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0" value="수정">
																								 <input type="submit" formaction="deleteProjectBoardReply.udo"
																								class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0" value="삭제"> 
																								<input type="hidden" name="step" id="step" value="${b2.step}"> 
																								<input type="hidden" name="ref" id="ref" value="${b2.ref}">

																								</div>
																						</form>
																					</c:if>
																					</div>
							                                                </div>
							                                             </div>
							                                          </div>
							                                       </div>
							                                       <div class="d-flex align-items-center">
							                                       </div>
							                                    </div>
							                                 
							                            	</c:if>
					                                    </c:forEach>
														<!-- projectBoard Reply 끝 -->
														
													</div>
												</div>
											</div>
										</div>
										<!-- projectBoard 끝 -->
										
									</c:if>
								</c:forEach>
							</div>
							<!-- proejctBoardList 끝 -->
							
							
							
							
						</div>
						<!-- 프로젝트 디테일 페이지 스토리 및 게시글 끝 [왼쪽] -->

						<!-- 리워드 추가되는 부분 시작 -->
						<div class="col-2">
							<!-- 리워드 품목 들어가기 -->
							<div class="card mb-3" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">리워드 제목1 [마감임박]</h5>
									<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="card-link">선택하기</a>
								</div>
							</div>
							<!-- 품목 1개 end-->

							<div class="card" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">리워드 제목2 [마감] : 마감 시 비활성화</h5>
									<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="card-link">선택하기</a>
								</div>
							</div>
						</div>
						<!-- 리워드 반복 끝-->



					</div>
				</article>
			</div>
	</section>
										
										
										
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <jsp:include page="include/i-footer.jsp"/>
            </div>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
       
		
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/popper.js/dist/umd/popper.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/sparkline/sparkline.js"></script>
        <!--Wave Effects -->
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/custom.min.js"></script>
        <!--This page JavaScript -->
        <!-- <script src="dist/js/pages/dashboards/dashboard1.js"></script> -->
        <!-- Charts js Files -->
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/excanvas.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.pie.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.time.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.stack.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.crosshair.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/pages/chart/chart-page-init.js"></script>


        <script src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/multicheck/datatable-checkbox-init.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/multicheck/jquery.multicheck.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/DataTables/datatables.min.js"></script>
        <script>
            /****************************************
             *       Basic Table                   *
             ****************************************/
            $('#zero_config').DataTable();
        </script>
</body>

</html>