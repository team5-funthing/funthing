<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩현황페이지</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

</head>
<body>
	<h1>펀딩현황</h1>
	<h4>기본정보</h4>
	<hr>
	
	<div>${projectInformation.projectTitle }</div>
	<div>프로젝트 번호 : ${projectInformation.projectNo }</div>
	<div>프로젝트 카테고리 : ${projectInformation.category }</div>
	<div>중계수수료 10% (VAT별도)</div>

	<fmt:formatNumber type="number" var="goalMoney" maxFractionDigits="3"
		value="${projectInformation.goalMoney }" />
	<div>${goalMoney }원목표</div>
	<div>${projectInformation.startDate }~${projectInformation.endDate }자정마감</div>
	<div>결과 : (여기들어오기 진행중인지 실패인지 등등 )</div>
	
	<hr>
	<h4>펀딩결제예약현황</h4>

	<div>
		펀딩결제예약금액 :
		<fmt:formatNumber type="number" var="fundingMoney"
			maxFractionDigits="3" value="${projectInformation.fundingMoney }" />
		${fundingMoney }원
	</div>
	<div>
		순 이익금액 (중계수수료10% 제외) :
		<fmt:formatNumber type="number" var="netProfit" maxFractionDigits="3"
			value="${(projectInformation.fundingMoney) * 0.9 }" />
		${netProfit }원
	</div>
	<div>
		펀딩달성률
		<fmt:formatNumber type="number" var="fundingMoneyPercent"
			value="${(projectInformation.fundingMoney / projectInformation.goalMoney)*100}"
			pattern=".00" />
		${fundingMoneyPercent }%
	</div>
	<div>
	<a href="getAllProjectAndPayment.udo?currentProjectNo=${currentProjectNo}">펀딩건수 ${count}회</a>
	</div>
	
	<div class="container">
		<canvas id="myChart"></canvas>
	</div>
	
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
		
	<!-- 차트 -->
	<script>
		var jsonData = ${json}
		var jsonObject = JSON.stringify(jsonData);
		var jData = JSON.parse(jsonObject);
		
		var labelList = new Array();
		var valueList = new Array();
		var colorList = new Array();
		
		for(var i =0; i <jData.length; i++){
			var d = jData[i];
			labelList.push(d.labelDate);
			valueList.push(d.dataFundingMoney);
			
		}
		
		
		
		var data = {
				labels: labelList,
				datasets: [{
					backgroundColor:colorList,
					data : valueList
				}],
				options :{
					title :{
						display : true,
						text:'펀딩현황'
					}
				}
		};
		
		var ctx = document.getElementById('myChart');
		new Chart(ctx,{
					type : 'bar',
					data : data
		});
	</script>















</body>
</html>