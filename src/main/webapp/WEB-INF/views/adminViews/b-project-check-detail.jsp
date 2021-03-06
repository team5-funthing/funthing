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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/magnific-popup.css">
<link href="${pageContext.request.contextPath }/resources/admin/assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/css/float-chart.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath }/resources/admin/dist/css/style.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style>
.popup-design {
	background-color: #FFF;
	width: 700px;
	height: 700px;
	text-align: center;
	margin: 20px auto;
}
</style>
<script>
$(window).resize(function() {
	   resizeYoutube();
	});

	$(function() {
	   resizeYoutube();
	});

	$(document).ready(function(){
	   
	   $("iframe").css("height", "420px");
	   
	});

	function resizeYoutube() {

	   $("iframe").each(function() {
	      if (/^https?:\/\/www.youtube.com\/embed\//g.test($(this).attr("src"))) {
	         $(this).css("width", "100%");
	         $(this).css("height", Math.ceil(parseInt($(this).css("width")) * 480 / 854) + "px");
	      }
	   });
	}  
</script>
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
		<jsp:include page="include/i-topbar-header.jsp" />
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="include/i-left-sidebar.jsp" />
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
						<h4 class="page-title">projectCheckList</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"></li>
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
													<div>
														업체명
														<h2>${projectCheck.creator}</h2>
													</div>
													<article class="row d-flex justify-content-center">
														<aside id="project-main-img" class="col-7">
															<div>${projectCheck.projectIntroduceVideo}</div>
														</aside>
														<aside id="project-details-info" class="col-5 align-items-start d-flex flex-column bd-highlight">
															<div class="p-2 bd-highlight">
																<div class="h4">목표 금액</div>
																<div class="h2" style="color: #000000">
																	<span>${projectCheck.goalMoney}</span>원[목표금액]
																	<!-- <div class="h5" style="color: #000000">50% [달성율]</div> -->
																</div>
															</div>
															<div class="p-2 bd-highlight">
																<div class="h4">종료 날짜</div>
																<div class="h2" style="color: #000000">
																	<div>${projectCheck.endDate}</div>
																	<div class="h5" style="color: #000000"></div>
																</div>
															</div>
															<div class="p-2 bd-highlight mt-auto ml-0">
																<a
																	class="btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
																	href="#"> 프로젝트 밀어주기 </a>
															</div>
															<div class="row d-flex justify-content-around m-0 ">
																<a
																	class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
																	href="#">좋아요</a> <a
																	class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
																	href="#">문의하기</a> <a
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
																			<h2>${projectCheck.projectSubTitle}</h2>
																			<ul class="project-info-link mt-3 mb-4">
																				<li><i class="fa fa-user"></i>
																					${projectCheck.category}</li>
																			</ul>
																			<div>${projectCheck.projectStory}</div>
																		</div>
																	</div>
																	
																	<hr>
																	<form action="updateProjectCheckApproval.ado" method="POST">
																		<div align="center">
																			<div style="width: 500px;">
																				<textarea rows="10" cols="70" name="statusReplyMessage" placeholder="거부/보류 사유 기재하는 곳"></textarea>
																			</div>
																			<input type="hidden" name="fm" id="pn" value="">
																			<input type="hidden" name="projectTitle" value="${projectCheck.projectTitle }">
																			<input type="hidden" name="projectNo" value="${projectCheck.projectNo}"> 
																			<input type="hidden" name="email" value="${projectCheck.email}">
																			<c:if test="${projectCheck.status ne 'f'.charAt(0)}">
																				<input type="submit" value="승인"> 
																			</c:if>
																			<input type="submit" formaction="updateProjectCheckDeny.ado" value="거부">
																			<!-- <a href="javaScript: return(0);" onclick="document.getElementById('statusReplyMessageform').submit()">
																			<input type="button" value="거부"></a> -->
																			<!-- 보류 버튼 아직 미완료 상태 -->
																			<input type="submit" formaction="updateProjectCheckDefer.ado" value="보류">
																			<a href="getProjectCheckList.ado"><input type="button" value="뒤로"></a>

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
																					<div
																						class="single-comment justify-content-between d-flex">
																						<div class="user justify-content-between d-flex">
																							<div class="thumb">
																								<img src="${pageContext.request.contextPath}/resources/admin/img/project_check/comment_1.png"
																									alt="">
																							</div>
																							<div class="desc" style="width: 600px;">
																								<p class="comment">
																									${b1.projectBoardContents}</p>
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
																												<a type="submit"
																													href="getProjectBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																													class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																													수정 </a> <a type="submit"
																													href="deleteProjectBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																													class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																													삭제 </a>

																											</div>

																										</c:when>


																										<c:when
																											test="${sessionScope.memberSessionEmail eq 'shn807@naver.com' }">

																											<div class="reply-btn">
																												<a type="submit"
																													href="replyBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																													class="button button-contactForm btn_1 boxed-btn pt-1 pl-3 pr-3 pb-1">
																													Reply </a>
																											</div>
																										</c:when>
																									</c:choose>
																								</div>

																								<!-- projectBoard Reply 시작 -->
																								<c:forEach var="b2" items="${getProjectBoard}">
																									<c:if
																										test="${b1.ref eq b2.ref && b1.step ne b2.step}">
																										<div
																											class="d-flex justify-content-around mt-3">
																											<div class="d-flex align-items-center">
																												<div
																													class="single-comment justify-content-between d-flex">
																													<div
																														class="user justify-content-between d-flex p-3"
																														style="background-color: whitesmoke;">
																														<div class="thumb">
																															<img
																																src="${pageContext.request.contextPath}/resources/admin/img/project_check/comment_2.png"
																																alt="">
																														</div>
																														<div class="desc" style="width: 500px;">
																															<p class="comment">
																																${b2.projectBoardContents}</p>
																															<div
																																class="d-flex justify-content-between">
																																<div class="d-flex align-items-center">
																																	<h5>
																																		<a href="#">${b2.member.name}</a>
																																	</h5>
																																	<p class="date">${b2.projectBoardDate}</p>
																																</div>
																																<c:if
																																	test="${ b2.email eq sessionScope.memberSessionEmail }">
																																	<form action="getProjectBoardReply.udo"
																																		method="post">
																																		<div class="reply-btn">
																																			<input type="submit"
																																				class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0"
																																				value="수정"> <input
																																				type="submit"
																																				formaction="deleteProjectBoardReply.udo"
																																				class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0"
																																				value="삭제"> <input
																																				type="hidden" name="step" id="step"
																																				value="${b2.step}"> <input
																																				type="hidden" name="ref" id="ref"
																																				value="${b2.ref}">

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
																	<c:forEach var="rewards" items="${projectCheck.reward}">
																		<div class="card mb-3" style="width: 18rem;">
																			<div class="card-body">
																				<h5 class="card-title">${rewards.rewardPrice}</h5>
																				<h6 class="card-subtitle mb-2 text-muted">${rewards.rewardName}</h6>
																				<p class="card-text">${rewards.rewardContent}</p>
																				<a href="#rewardPopup" class="openRewardPopup card-link"
																					id="${rewards.rewardNo}">선택하기</a>
																			</div>
																		</div>
																	</c:forEach>
																</div>
																<!-- 리워드 반복 끝-->
																	
																<script>
																	$(document).ready(function() {
																		$(".openRewardPopup").magnificPopup({
																				src : "#rewardPopup",
																				type : 'inline'																						
																		});
													
																		$("a.card-link").click(function(){
																			var index = { indexData : $(this).attr('id')};
																			$.ajax({
																				type:"post",
																				url:"getReward.udo",
																				data:index,
																				success:function(data){
																					console.log(data);
																					var rewardObject = JSON.parse(data);
																					for(var key in rewardObject){
																						console.log('key : ' + key + ', value : ' + rewardObject[key]);
																					}
																					$("input[name='rewardPrice']").val(rewardObject.rewardPrice);
																					$("input[name='rewardName']").val(rewardObject.rewardName);
																					$("textarea[name='rewardContent']").val(rewardObject.rewardContent);
																					$("#categorySelectBox").val(rewardObject.rewardOption).prop("selected",true);
																					$("input[name='shippingFee']").val(rewardObject.shippingFee);
																					$("input[name='rewardAmount']").val(rewardObject.rewardAmount);
																					$("select[name='rewardDay']").val(rewardObject.rewardDay).prop("selected",true);
																					$("select[name='rewardMonth']").val(rewardObject.rewardMonth).prop("selected",true);
																					
																					$("#appendTag").empty();
																					$("#appendBtn").empty();
																			
																					//입력시에 설정한 선택 옵션들을 보여주는 부분이다.
																					if(rewardObject.rewardOption=='옵션 없음'){
																						$("#addOptionIndex").empty();
																						$("#appendTag").empty();
																						$("#appendBtn").empty();
																					}else if(rewardObject.rewardOption=='선택 옵션'){
																						$("#addOptionIndex").empty();
																						$("#appendTag").empty();
																						$("#appendBtn").empty();
																						console.log(rewardObject.rewardOptionList.length);
																						for(var i = 0;i<rewardObject.rewardOptionList.length;i++){
																							$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum"+i+"' name='rewardOptionNo' size='3px' readonly>");
																							$("#appendTag").append("<br> 항목  : <input type='text' id='optionkey"+i+"' name='rewardoptionkey' size='4px'>&nbsp;&nbsp;&nbsp; 값 : <input type='text' id='optionvalue"+i+"' name='rewardoptionvalue' size='4px'>");
																							$("#rewardOptionNum"+i+"").val(rewardObject.rewardOptionList[i].rewardOptionNo);
																							$("#optionkey"+i+"").val(rewardObject.rewardOptionList[i].rewardOptionKey);
																							$("#optionvalue"+i+"").val(rewardObject.rewardOptionList[i].rewardOptionValue);
																						}
																					}else if(rewardObject.rewardOption=='직접 입력 옵션'){
																						$("#appendTag").empty();
																						$("#appendBtn").empty();
																						$("#addOptionIndex").empty();
																						$("#appendTag").append("<textarea name='rewardoptionvalue' rows='4' cols='40'></textarea>");
																						$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum' name='rewardOptionNo' size='3px' readonly>");
																						$("#rewardOptionNum").val(rewardObject.rewardOptionList[0].rewardOptionNo);
																						$("textarea[name=rewardoptionvalue]").val(rewardObject.rewardOptionList[0].rewardOptionValue);
																					}
																					
																					//입력당시의 '배송조건'에 대한 입력값을 입력폼에 설정해주는 부분이다.
																					if(rewardObject.shippingNeed=="배송 필요"){
																						$("#primary-radio1").prop("checked", true);
																						$("input[name=shippingFee]").show();
																						$("input[name=shippingFee]").removeAttr("disabled");
																						$(".aa").show();
																					}else if(rewardObject.shippingNeed=="배송 불필요"){
																						$("#primary-radio3").prop("checked", true);
																						$("input[name=shippingFee]").hide();
																						$("input[name=shippingFee]").attr("disabled",true);
																						$(".aa").hide();
																					}
																				},
																				error:function(){
																					console.log('뭔가 안나옴');
																				}
																			});
																		});
																	});
																</script>


																<!-- 리워드 항목 팝업 시작 -->
																<div id="rewardPopup" class="mfp-hide popup-design">
																	<form>
																		<div class="addReward_popup_box">
																			<div class="popup_inner">
																				<div class="container">
																					<div class="row p-2">
																						<div class="col-1"></div>
																						<div class="col-3"></div>
																						<div class="col-1"></div>
																					</div>

																					<div class="row p-3">
																						<div class="col-4" style="font-weight: bold; color: darkslateblue">금액</div>
																						<div class="col-5">
																							<input type="text" name="rewardPrice" class="form-control">
																						</div>
																						<div class="col-2">원</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4" style="font-weight: bold; color: darkslateblue">리워드이름</div>
																						<div class="col-7">
																							<input type="text" name="rewardName" class="form-control" id="formGroupExampleInput" placeholder="Example input placeholder">
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4" style="font-weight: bold; color: darkslateblue">상세설명</div>
																						<div class="col-7">
																							<textarea class="form-control" name="rewardContent" id="exampleFormControlTextarea1" rows="3"></textarea>
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">옵션조건</div>
																						<div class="col-7">
																							<div id="addOptionIndex"></div>
																							<select id="categorySelectBox" name="rewardOption" class="custom-select">
																								<option value="옵션 선택" selected="selected">옵션 선택</option>
																								<option value="옵션 없음">옵션 없음</option>
																								<option value="선택 옵션">선택 옵션(사이즈, 색상 등)</option>
																								<option value="직접 입력 옵션">직접 입력 옵션(각인, 메시지 등)</option>
																							</select>
																							<div id="appendTag"></div>
																							<div id="appendBtn"></div>
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<!-- 배송조건 -->
																					<div class="row p-3">
																						<div class="col-4" style="font-weight: bold; color: darkslateblue;">배송조건</div>
																						<div class="col-7">
																							<div class="row d-flex align-items-center">
																								<div class="p-2 bd-highlight">
																									<div class="form-check primary-radio ">
																										<input class="form-check-input primary-radio checkbox" type="radio" name="shippingNeed" id="primary-radio1" value="배송 필요" checked>
																										<label for="primary-radio1"></label>
																									</div>
																								</div>
																								<div class="d-flex p-2 bd-highlight">배송이 필요한 리워드입니다.</div>
																							</div>
																							<div class="row d-flex align-items-center" id="shipping">
																								<div class="col-3 aa">
																									<label for="formGroupExampleInput">배송료</label>
																								</div>
																								<!-- String인 shippingFee를 number로 바꾸어주는 코드 -->
																								<div class="col-7 p-1 aa">
																									<input type="text" name="shippingFee" class="form-control">
																								</div>
																								<div class="col-2 aa">원</div>
																							</div>
																							<div class="row d-flex align-items-center">
																								<div class="p-2 bd-highlight">
																									<div class="form-check primary-radio ">
																										<input class="form-check-input primary-radio checkbox" type="radio" name="shippingNeed" id="primary-radio3" value="배송 불필요"> 
																										<label for="primary-radio3"></label>
																									</div>
																								</div>
																								<div class="d-flex p-2 bd-highlight">배송이 필요 없는 리워드입니다.</div>
																							</div>
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<!-- 배송조건 끝 -->
																					<div class="row p-3">
																						<div class="col-4" style="font-weight: bold; color: darkslateblue">제한수량</div>
																						<div class="col-5">
																							<input type="text" name="rewardAmount" class="form-control">
																						</div>
																						<div class="col-2">개</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4" style="font-weight: bold; color: darkslateblue">발송시작일</div>
																						<div class="col-4 pr-1">
																							<select class="rewardSendDate" name="rewardMonth" class="custom-select">
																								<option selected="selected">월별 선택</option>
																								<c:forEach var="i" begin="1" end="12" step="1">
																									<option value="${i}월">${i}월</option>
																								</c:forEach>
																							</select>
																						</div>
																						<div class="col-4">
																							<select class="rewardSendTime" name="rewardDay" class="custom-select">
																								<option selected="selected">일자 선택</option>
																								<c:forEach var="i" begin="1" end="31" step="1">
																									<option value="${i}일">${i}일</option>
																								</c:forEach>
																							</select>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																	</form>
																</div>
																<!-- 리워드 항목 팝업 종료 -->
															</div>
														</article>
													</div>
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
				 <script src="${pageContext.request.contextPath}/resources/user/js/jquery.magnific-popup.min.js"></script>
				<jsp:include page="include/i-footer.jsp" />
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
	<script>
            /****************************************
             *       Basic Table                   *
             ****************************************/
            $('#zero_config').DataTable();
        </script>
</body>

</html>