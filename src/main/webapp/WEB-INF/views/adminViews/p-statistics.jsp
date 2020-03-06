<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Funthing 통계관리</title>


<jsp:include page="include/i-header-setting.jsp" />
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
						<h4 class="page-title">statistics</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="#C:\Users\pjh\Desktop\5jo\matrix-admin-master\index.html">Home</a></li>
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



				<!--           쓸모 하나도 없어서 버림.
				Nav tabs -->
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item">
						<a class="nav-link active" data-toggle="tab" href="#home" role="tab">
							<span class="hidden-sm-up"></span> 
							<span class="hidden-xs-down">펀딩 모금액 통계</span></a></li>
						<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#home2" role="tab">
						<span class="hidden-sm-up"></span> 
						<span class="hidden-xs-down">프로젝트 성공률 통계</span></a></li>
					</ul>


					<div class="tab-content tabcontent-border">

						<div class="tab-pane active" id="home" role="tabpanel">
							<div class="p-20">
								<div class="row">
									<div class="col-12">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title m-b-0">펀딩 모금액 통계</h5>
												<form style="float: right;">
													<select>
														<option value="">월별</option>
														<option value="">연도별</option>
													</select>
												</form>
											</div>
										</div>
										 
										<canvas id="myChart2" style="height:auto;width:auto;"></canvas>
									</div>
								
								</div>
							</div>
						</div>
<script>
	var ctx = document.getElementById('myChart2').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['1월', '2월', '3월 ', '4월 ', '5월', '6월 ','7월', '8월 ', '9월 ', '10월', '11월', '12월 '],
	        datasets: [{
	            label: '월 별 펀딩모금액',
	            data: [12, 19, 3, 5, 2, 3, 12, 19, 3, 5, 2, 3],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)',
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)',
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});


</script>




						<div class="tab-pane  p-20" id="home2" role="tabpanel">
							<div class="p-20">
								<div class="row" style="height:400px" >
									<div class="col-12" >
										<div  class="card">
											<div  class="card-body">
												<h5 class="card-title m-b-0">프로젝트 성공률 통계</h5>
												<form style="float: right;">
													<select>
														<option value="">월별</option>
														<option value="">연도별</option>
													</select>
												</form>
											</div>
										</div>
									<div style="display:flex;">
											<!--  그래프 구역   -->
									<div id="left" style="height:225px;width:49%;">
									<canvas id="myChart" style="height:auto;width:auto;"></canvas>
									<!--  표 구역   -->
									
									
									<input type="hidden" name="projectSuccess">   <!--  END DATE 기준 연 /월  구분     성공 실패 구분   -->
									<input type="hidden" name="projectFail">
									</div>
									<!--  표 구역   -->
									<div id="rightdiv" style="width:49%">
									<table border="1"  >
									<thead> N월 프로젝트 성공률</thead>
									<tr>
									<td>구분</td>
									<td>1월</td>
									<td>2월</td>
									<td>3월</td>
									<td>4월</td>
									<td>5월</td>
									<td>6월</td>
									<td>7월</td>
									<td>8월</td>
									<td>9월</td>
									<td>10월</td>
									<td>11월</td>
									<td>12월</td>
									</tr>
									<tr>
									<td>성공</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									</tr>
									<tr>
									<td>실패</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									</tr>
									</table>
									</div>
									</div>
									
<script>
	var ctx = document.getElementById('myChart').getContext('2d');
	var myDoughnutChart = new Chart(ctx, {
	    type: 'doughnut',
	    data: {
	    	 labels: [ '성공','실패'],
		     datasets: [{
		    	label:'piechart',
		        data: [ 30, 20,],    // 여기에    성공 / 실패 월별 수량 집어넣어! 
		        backgroundColor:  [ 'rgba(54, 162, 235, 1)','rgba(255, 99, 132, 1)' ],
	            borderColor:  [ 'rgba(54, 162, 235, 1)','rgba(255, 99, 132, 1)' ],
		    }],
		    // These labels appear in the legend and in the tooltips when hovering different arcs	   
		},
		options: {
	  	responsive: true
	  }
	});

		Chart.pluginService.register({
		  beforeDraw: function(chart) {
		    var width = chart.chart.width,
		        height = chart.chart.height,
		        ctx = chart.chart.ctx;

		    ctx.restore();
		    var fontSize = (height / 114).toFixed(2);
		    ctx.font = fontSize + "em sans-serif";
		    ctx.textBaseline = "middle";
  
		    
		    var value = (30/(30+20))*100;
		    var text = value+'%',
		        textX = Math.round((width - ctx.measureText(text).width) / 2),
		        textY = (height / 1.8);

		    ctx.fillText(text, textX, textY);
		    ctx.save();
		  }
		});
</script>


									</div>
								
								</div>
							</div>
						</div>

					</div>

					


   <!-- <div class="pie" style="height: 400px;"></div> 
 -->

				</div>



				<!-- ============================================================== -->
				<!-- End Container fluid  -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- footer -->
				<!-- ============================================================== -->
				<jsp:include page="include/i-footer.jsp" />
				<!-- ============================================================== -->
				<!-- End footer -->
				<!-- ============================================================== -->
			</div>
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
	

</body>

</html>