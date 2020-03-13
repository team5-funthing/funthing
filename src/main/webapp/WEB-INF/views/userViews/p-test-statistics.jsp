<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="UTF-8">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<!-- 부트스트랩 -->
					<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
						integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
						crossorigin="anonymous"></script>
					<script
						src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
						integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
						crossorigin="anonymous"></script>
					<script
						src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
						integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
						crossorigin="anonymous"></script>
						

<jsp:include page="./include/i-head-setting.jsp" />

</head>
<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />

	<section class="main-wrapper pt-xl-5 ">
		<div class="main-content">
			<div class="container">
				<div class="h4 mt-5 pb-3"><strong>펀딩현황</strong></div>
				<div style="color:gray;">기본정보</div>
				<hr>

				
				
				<div class="h5 mt-5 pb-3" style="color:black;">
					<strong>[${projectInformation.projectTitle }]</strong>
				</div>
				<div style="color:gray;" >프로젝트 번호 : ${projectInformation.projectNo }</div>
				<div style="color:gray;">프로젝트 카테고리 : ${projectInformation.category }</div>
				<div style="color:gray;">중계수수료 10% (VAT별도)</div>


				<fmt:formatNumber type="number" var="goalMoney"
					maxFractionDigits="3" value="${projectInformation.goalMoney }" />
				<div style="color:gray;">${goalMoney }원목표</div>
				<div style="color:gray;">${projectInformation.startDate }~${projectInformation.endDate } 자정마감</div>

			<!-- 펀딩 결과 확인하기 -->
				<c:choose>
					<c:when test="${projectInformation.funding eq 'y'.charAt(0) }">
						<div style="color:red;">결과 : 진행중</div>
					</c:when>
					<c:when test="${projectInformation.funding eq 'e'.charAt(0) }">
					<c:choose>
						<c:when test="${projectInformation.fundingMoney ge projectInformation.goalMoney }">
						<div>결과 : 성공</div>
						</c:when>
						<c:when test="${projectInformation.fundingMoney lt projectInformation.goalMoney }">
						<div>결과 : 실패</div>
						</c:when>
					</c:choose>
					</c:when>
				</c:choose>
			<!-- 펀딩 결과 끝 -->					
					<hr>
					<div class="h4 mt-5 pb-3"><strong>펀딩결제예약현황</strong></div>
					<div style="color:gray;">결제정보</div>
					<hr>
					<br>


				<div class="container">
					<div class="row justify-content-md-center">
						<div class="col">
							<div class="card" style="width: 27rem; height: 10rem;">
								<div class="card-body" >
									<h6 class="card-title" style="color:gray;">펀딩결제예약금액</h6>
									<fmt:formatNumber type="number" var="fundingMoney"
										maxFractionDigits="3"
										value="${projectInformation.fundingMoney }" />

									<p class="card-text">
									<h3>${fundingMoney }원</h3>
									</p>
									<p>
										순 이익금액 (중계수수료10% 제외) :
										<fmt:formatNumber type="number" var="netProfit"
											maxFractionDigits="3"
											value="${(projectInformation.fundingMoney) * 0.9 }" />
										${netProfit }원
									</p>

								</div>
							</div>
						</div>
						<div class="col">
							<div class="card" style="width: 18rem; height: 10rem;">
								<div class="card-body">
									<h6 class="card-title" style="color:gray;">펀딩달성률</h6>
									<fmt:formatNumber type="number" var="fundingMoneyPercent"
										value="${(projectInformation.fundingMoney / projectInformation.goalMoney)*100}"
										pattern=".00" />

									<p class="card-text">
									<h3>${fundingMoneyPercent }%</h3>
									</p>

								</div>
							</div>
						</div>
						<div class="col">
							<div class="card" style="width: 18rem; height: 10rem;">
								<div class="card-body">
									<h6 class="card-title" style="color:gray;">펀딩건수</h6>
									<p class="card-text">
									<h3>${count}회</h3>
									</p>
									<a
										href="getAllProjectAndPayment.udo?currentProjectNo=${currentProjectNo}"
										class="card-link" style="color:gray;"><ins>자세히보기</ins></a>

								</div>
							</div>
						</div>
					</div>
				</div>


	
				<br>
				<br>
				<div >날짜별 펀딩된 정보</div>
				<hr>
				
				<div class="container">
						<canvas id="myChart"></canvas>
					</div>


					

					<!-- 차트 -->
					<script>
					//최종펀딩금액
					var jsonData = ${json};
					var jsonObject = JSON.stringify(jsonData);
					var jData = JSON.parse(jsonObject);

					var labelList = new Array();
					var valueList = new Array();

					for (var i = 0; i < jData.length; i++) {
						var d = jData[i];
						labelList.push(d.labelDate);
						valueList.push(d.dataFundingMoney);

					}

					var data = {

						labels : labelList,
						datasets : [ {
							backgroundColor : "#FF9999",
							label : '펀딩금액',
							data : valueList
						} ],
						options : {
							title : {
								display : true,
								text : '펀딩현황'
							}
						}
					};

					var ctx = document.getElementById('myChart');
					new Chart(ctx, {
						type : 'bar',
						data : data
					});
				</script>
			</div>
		</div>
	</section>
	<br>
	<br><br><br><br>



	<jsp:include page="./include/i-footer.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>