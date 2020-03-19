<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/magnific-popup.css">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/resources/admin/dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
                        <h4 class="page-title">유저메인 프로젝트 상세</h4>
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
										<h5 class="card-title m-b-0">유저메인 프로젝트 상세</h5>
										<div class="table-responsive">
										
										
										<!-- 중간 내용 들어가는 부분 -->

											<section class="container">

												<div class="w-100">
													<div>
														업체명
														<h2>${focusProject.creator}</h2>
													</div>
													<article class="row d-flex justify-content-center">
														<aside id="project-main-img" class="col-7">
															<div>${focusProject.projectIntroduceVideo}</div>
														</aside>
														<aside id="project-details-info" class="col-5 align-items-start d-flex flex-column bd-highlight">
 															<div class="p-2 bd-highlight">
																<div class="h4">모인 금액</div>
																<div class="h2" style="color: #000000">
																	${focusProject.fundingMoney}원
																	<div class="h5" style="color: #000000">${(focusProject.fundingMoney /focusProject.goalMoney) * 100}%
																		[달성율]</div>
																</div>
															</div>

															<jsp:useBean id="now" class="java.util.Date" />
															<fmt:formatDate var="today" value="${now}" pattern="yyyyMMdd" />
															<fmt:formatDate var="endDate" value="${focusProject.endDate}" pattern="yyyyMMdd" />

															<div class="p-2 bd-highlight">
																<div class="h4">남은 날짜</div>
																<div class="h2" style="color: #000000">
																	${endDate - today}일
																	<div class="h5" style="color: #000000"></div>
																</div>
															</div>
															<div class="p-2 bd-highlight mt-auto ml-0">
																<a
																	class="btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
																	href="#">프로젝트 밀어주기</a>
															</div>
															<div class="row d-flex justify-content-around m-0 ">
																<a class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
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
																			<h3>${focusProject.projectSubTitle }</h3>
																			<ul class="project-info-link mt-3 mb-4">
																				<li><i class="fa fa-user"></i>${focusProject.category }</li>
																			</ul>
																			<div>${focusProject.projectStory}</div>
																		</div>
																	</div>
																	<hr>
																	<form action="insertFocusProject.ado" method="POST">
																		<div align="center">
																			<input type="hidden" name="projectNo" value="${focusProject.projectNo}"> 
																			
																			
																			
																			<a href="deleteFocusProject.ado?projectNo=${focusProject.projectNo}"><input type="button" value="주목 프로젝트에서 제외하기"></a>
																			
																			<a href="getFocusProjectList.ado"><input type="button" value="목록"></a>
																		</div>
																	</form>

																</div>
																<!-- 프로젝트 디테일 페이지 스토리 및 게시글 끝 [왼쪽] -->

																<!-- 리워드 추가되는 부분 시작 -->
																<div class="col-2">
																	<!-- 리워드 품목 들어가기 -->
																	<c:forEach var="rewards" items="${focusProject.reward}">
																		<div class="card mb-3" style="width: 18rem;">
																			<div class="card-body">
																				<h5 class="card-title">${rewards.rewardPrice}</h5>
																				<h6 class="card-subtitle mb-2 text-muted">${rewards.rewardName}</h6>
																				<p class="card-text">${rewards.rewardContent}</p>
																				<a href="#rewardPopup"
																					class="openRewardPopup card-link"
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
																		$("a.card-link").click(function() {
																			var index = {indexData : $(this).attr('id')};
																			$.ajax({
																				type : "post",
																				url : "getReward.udo",
																				data : index,
																				success : function(data) {
																					console.log(data);
																					var rewardObject = JSON.parse(data);
																					for ( var key in rewardObject) {
																						console.log('key : '+ key+ ', value : '+ rewardObject[key]);
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
																					if (rewardObject.rewardOption == '옵션 없음') {
																						$("#addOptionIndex").empty();
																						$("#appendTag").empty();
																						$("#appendBtn").empty();
																					} else if (rewardObject.rewardOption == '선택 옵션') {
																						$("#addOptionIndex").empty();
																						$("#appendTag").empty();
																						$("#appendBtn").empty();
																						console.log(rewardObject.rewardOptionList.length);
																						for (var i = 0; i < rewardObject.rewardOptionList.length; i++) {
																							$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum"+i+"' name='rewardOptionNo' size='3px' readonly>");
																							$("#appendTag").append(	"<br> 항목  : <input type='text' id='optionkey"+i+"' name='rewardoptionkey' size='4px'>&nbsp;&nbsp;&nbsp; 값 : <input type='text' id='optionvalue"+i+"' name='rewardoptionvalue' size='4px'>");
																							$("#rewardOptionNum"+ i+ "").val(rewardObject.rewardOptionList[i].rewardOptionNo);
																							$("#optionkey"+ i+ "").val(rewardObject.rewardOptionList[i].rewardOptionKey);
																							$("#optionvalue"+ i+ "").val(rewardObject.rewardOptionList[i].rewardOptionValue);
																						}
																					} else if (rewardObject.rewardOption == '직접 입력 옵션') {
																						$("#appendTag").empty();
																						$("#appendBtn").empty();
																						$("#addOptionIndex").empty();
																						$("#appendTag").append("<textarea name='rewardoptionvalue' rows='4' cols='40'></textarea>");
																						$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum' name='rewardOptionNo' size='3px' readonly>");
																						$("#rewardOptionNum").val(rewardObject.rewardOptionList[0].rewardOptionNo);
																						$("textarea[name=rewardoptionvalue]").val(rewardObject.rewardOptionList[0].rewardOptionValue);
																					}
																					//입력당시의 '배송조건'에 대한 입력값을 입력폼에 설정해주는 부분이다.
																					if (rewardObject.shippingNeed == "배송 필요") {
																						$("#primary-radio1").prop("checked",true);
																						$("input[name=shippingFee]").show();
																						$("input[name=shippingFee]").removeAttr("disabled");
																						$(".aa").show();
																					} else if (rewardObject.shippingNeed == "배송 불필요") {
																						$("#primary-radio3").prop("checked",true);
																						$("input[name=shippingFee]").hide();
																						$("input[name=shippingFee]").attr("disabled",true);
																						$(".aa").hide();
																					}
																				},
																				error : function() {
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
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">금액</div>
																						<div class="col-5">
																							<input type="text" name="rewardPrice"
																								class="form-control">
																						</div>
																						<div class="col-2">원</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">리워드이름</div>
																						<div class="col-7">
																							<input type="text" name="rewardName"
																								class="form-control" id="formGroupExampleInput"
																								placeholder="Example input placeholder">
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">상세설명</div>
																						<div class="col-7">
																							<textarea class="form-control"
																								name="rewardContent"
																								id="exampleFormControlTextarea1" rows="3"></textarea>
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">옵션조건</div>
																						<div class="col-7">
																							<div id="addOptionIndex"></div>
																							<select id="categorySelectBox"
																								name="rewardOption" class="custom-select">
																								<option value="옵션 선택" selected="selected">옵션
																									선택</option>
																								<option value="옵션 없음">옵션 없음</option>
																								<option value="선택 옵션">선택 옵션(사이즈, 색상 등)</option>
																								<option value="직접 입력 옵션">직접 입력 옵션(각인,
																									메시지 등)</option>
																							</select>
																							<div id="appendTag"></div>
																							<div id="appendBtn"></div>
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<!-- 배송조건 -->
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue;">배송조건</div>
																						<div class="col-7">
																							<div class="row d-flex align-items-center">
																								<div class="p-2 bd-highlight">
																									<div class="form-check primary-radio ">
																										<input
																											class="form-check-input primary-radio checkbox"
																											type="radio" name="shippingNeed"
																											id="primary-radio1" value="배송 필요" checked>
																										<label for="primary-radio1"></label>
																									</div>
																								</div>
																								<div class="d-flex p-2 bd-highlight">배송이 필요한 리워드입니다.</div>
																							</div>
																							<div class="row d-flex align-items-center"
																								id="shipping">
																								<div class="col-3 aa">
																									<label for="formGroupExampleInput">배송료</label>
																								</div>
																								<!-- String인 shippingFee를 number로 바꾸어주는 코드 -->
																								<div class="col-7 p-1 aa">
																									<input type="text" name="shippingFee"
																										class="form-control">
																								</div>
																								<div class="col-2 aa">원</div>
																							</div>
																							<div class="row d-flex align-items-center">
																								<div class="p-2 bd-highlight">
																									<div class="form-check primary-radio ">
																										<input
																											class="form-check-input primary-radio checkbox"
																											type="radio" name="shippingNeed"
																											id="primary-radio3" value="배송 불필요"> <label
																											for="primary-radio3"></label>
																									</div>
																								</div>
																								<div class="d-flex p-2 bd-highlight">배송이
																									필요 없는 리워드입니다.</div>
																							</div>
																						</div>
																						<div class="col-1"></div>
																					</div>
																					<!-- 배송조건 끝 -->
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">제한수량</div>
																						<div class="col-5">
																							<input type="text" name="rewardAmount"
																								class="form-control">
																						</div>
																						<div class="col-2">개</div>
																						<div class="col-1"></div>
																					</div>
																					<div class="row p-3">
																						<div class="col-4"
																							style="font-weight: bold; color: darkslateblue">발송시작일</div>
																						<div class="col-4 pr-1">
																							<select class="rewardSendDate" name="rewardMonth"
																								class="custom-select">
																								<option selected="selected">월별 선택</option>
																								<c:forEach var="i" begin="1" end="12" step="1">
																									<option value="${i}월">${i}월</option>
																								</c:forEach>
																							</select>
																						</div>
																						<div class="col-4">
																							<select class="rewardSendTime" name="rewardDay"
																								class="custom-select">
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
											</section>



										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery/dist/jquery.min.js"></script>
				<script src="magnific-popup/jquery.magnific-popup.js"></script>
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
        <script>
            /****************************************
             *       Basic Table                   *
             ****************************************/
            $('#zero_config').DataTable();
        </script>
</body>

</html>