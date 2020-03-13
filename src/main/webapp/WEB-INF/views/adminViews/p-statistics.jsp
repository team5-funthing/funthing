<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
								<div class="row" style="height:800px">
									<div class="col-12">
										<div class="card">
											<div class="card-body">
												<center><h4 class="card-title m-b-0">펀딩 모금액 통계</h4></center>
											</div>
										</div>
									
								    <input class="btn btn-outline-dark" type="button" value="2020" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2021" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2022" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2023" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2024" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2025" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2026" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2027" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2028" name="yearbtn2" style="width:60px;">
									<input class="btn btn-outline-dark" type="button" value="2029" name="yearbtn2" style="width:60px;">
										 <center>
										 <input type="text" disabled="disabled" id="chart2title" class="form-control" style="text-align:center;background-color:white;">
										 </center>
										<canvas id="myChart2" style="height:auto;width:400px;"></canvas>
										<br><br>
									<table class="table">
									<tr>
									<td style="width:7.5%;text-align:center;"> 1월 </td>
									<td style="width:7.5%;text-align:center;"> 2월 </td>
									<td style="width:7.5%;text-align:center;"> 3월 </td>
									<td style="width:7.5%;text-align:center;"> 4월 </td>
									<td style="width:7.5%;text-align:center;"> 5월 </td>
									<td style="width:7.5%;text-align:center;"> 6월 </td>
									<td style="width:7.5%;text-align:center;"> 7월 </td>
									<td style="width:7.5%;text-align:center;"> 8월 </td>
									<td style="width:7.5%;text-align:center;"> 9월 </td>
									<td style="width:7.5%;text-align:center;"> 10월 </td>
									<td style="width:7.5%;text-align:center;"> 11월 </td>
									<td style="width:7.5%;text-align:center;"> 12월 </td>
									<td style="width:7.5%;text-align:center;"> 합계</td>
									</tr>
									<tr>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m1 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m2 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m3 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m4 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m5 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m6 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m7 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m8 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m9 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m10 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m11 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.m12 } 원</td>
									<td style="width:7.5%;text-align:center;font-size:10px;"> ${fundingMoneyPerMonth.sumfunding } 원</td>
									</tr>
									</table>
									</div>
								
								</div>
							</div>
						</div>
						
<script>



	var ctx2 = document.getElementById('myChart2').getContext('2d');
	var config2 = {
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
		};
	
	var myChart2 = new Chart(ctx2,config2 );    //그리기

	
	$(document).ready(function(){
		var thisyear = new Date().getFullYear();
		var use = thisyear-2000;
		$("#chart2title").val(thisyear+"년 펀딩모금액");
	   
		
	    
	    config2.data.datasets[0].data[0]=${fundingMoneyPerMonth.m1};
	    config2.data.datasets[0].data[1]=${fundingMoneyPerMonth.m2};
	    config2.data.datasets[0].data[2]=${fundingMoneyPerMonth.m3};
	    config2.data.datasets[0].data[3]=${fundingMoneyPerMonth.m4};
	    config2.data.datasets[0].data[4]=${fundingMoneyPerMonth.m5};
	    config2.data.datasets[0].data[5]=${fundingMoneyPerMonth.m6};
	    config2.data.datasets[0].data[6]=${fundingMoneyPerMonth.m7};
	    config2.data.datasets[0].data[7]=${fundingMoneyPerMonth.m8};
	    config2.data.datasets[0].data[8]=${fundingMoneyPerMonth.m9};
	    config2.data.datasets[0].data[9]=${fundingMoneyPerMonth.m10};
	    config2.data.datasets[0].data[10]=${fundingMoneyPerMonth.m11};
	    config2.data.datasets[0].data[11]=${fundingMoneyPerMonth.m12};
	    $("#fundingMoneySum").val('${fundingMoneyPerMonth.sumfunding}'); 
		myChart2.update();
		
	});


	$("input[name=yearbtn2]").click(function(){    //연도 클릭
		
		var thisyear = new Date().getFullYear();
		if(thisyear < $(this).val()){
			alert("아직 해당 연도가 시작되지 않았습니다!");	
		}else{
			var using = thisyear-2000;
			var data ={"year":using};
			$.ajax({
				type : "post",
				url : "statisticsManagement.ado",
				data : data,
				success : function(data) {
					document.getElementById("chart2title").value="20"+using+"년 펀딩모금액";
					
				    config2.data.datasets[0].data[0]=${fundingMoneyPerMonth.m1};
				    config2.data.datasets[0].data[1]=${fundingMoneyPerMonth.m2};
				    config2.data.datasets[0].data[2]=${fundingMoneyPerMonth.m3};
				    config2.data.datasets[0].data[3]=${fundingMoneyPerMonth.m4};
				    config2.data.datasets[0].data[4]=${fundingMoneyPerMonth.m5};
				    config2.data.datasets[0].data[5]=${fundingMoneyPerMonth.m6};
				    config2.data.datasets[0].data[6]=${fundingMoneyPerMonth.m7};
				    config2.data.datasets[0].data[7]=${fundingMoneyPerMonth.m8};
				    config2.data.datasets[0].data[8]=${fundingMoneyPerMonth.m9};
				    config2.data.datasets[0].data[9]=${fundingMoneyPerMonth.m10};
				    config2.data.datasets[0].data[10]=${fundingMoneyPerMonth.m11};
				    config2.data.datasets[0].data[11]=${fundingMoneyPerMonth.m12};
				    $("#fundingMoneySum").val('${fundingMoneyPerMonth.sumfunding}'); 
					myChart2.update();
				},
				error : function() {
					
				}
			});
		}
		
	});

</script>




						<div class="tab-pane  p-20" id="home2" role="tabpanel">
							<div class="p-20">
								<div class="row" style="height:auto" >
									<div class="col-12" >
										<div  class="card">
											<div  class="card-body">
												<center><h4 class="card-title m-b-0">프로젝트 성공률 통계</h4></center>
											</div>
										</div>
									<div style="display:flex;">
											<!--  그래프 구역   -->
									<div id="left" style="height:225px;width:39%;">
									<div id="refresh">
									<canvas id="myChart" style="height:auto;width:auto;"></canvas>
                                    </div>
									<input type="hidden" id="inputSuccess" >
									<input type="hidden" id="inputFail" >
									<center><input type="text" id="canvaslabel" readonly class="form-control" style="width:250px;text-align:center;background-color:white;font-weight:bold"></center>
									
   
  
	
	

									</div>
									<div id="rightdiv" style="width:59%">
								    <input class="btn btn-outline-info" type="button" value="2020" name="yearbtn"  style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2021" name="yearbtn"  style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2022" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2023" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2024" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2025" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2026" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2027" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2028" name="yearbtn" style="width:64px;">
									<input class="btn btn-outline-info" type="button" value="2029" name="yearbtn" style="width:64px;">
									<p></p>
								 
								    <input  type="text" readonly id="headname2" class="form-control" style="text-align:center;background-color:white;">
									<table "table">
									<tr>
									<td><input class="btn btn-outline-success" type="button" value="구분" disabled="disabled"></td> 
									<td><input class="btn btn-outline-success" type="button" value="1월" id="btn1" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="2월" id="btn2" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="3월" id="btn3" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="4월" id="btn4" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="5월" id="btn5" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="6월" id="btn6" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="7월" id="btn7" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="8월" id="btn8" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="9월" id="btn9" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="10월" id="btn10" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="11월" id="btn11" style="width:50px;"></td>
									<td><input class="btn btn-outline-success" type="button" value="12월" id="btn12" style="width:50px;"></td>
									</tr>
									<tr>
									<td><input class="btn btn-outline-info" type="button" value="성공" disabled="disabled"></td>
									<td ><button id="s1" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success1 }</button></td>
									<td ><button id="s2" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success2 }</button></td>
									<td ><button id="s3" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success3 }</button></td>
									<td ><button id="s4" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success4 }</button></td>
									<td ><button id="s5" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success5 }</button></td>
									<td ><button id="s6" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success6 }</button></td>
									<td ><button id="s7" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success7 }</button></td>
									<td ><button id="s8" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success8 }</button></td>
									<td ><button id="s9" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success9 }</button></td>
									<td ><button id="s10" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success10 }</button></td>
									<td ><button id="s11" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success11 }</button></td>
									<td ><button id="s12" class="btn btn-outline-success" disabled="disabled" style="width:50px;">${successRatioMonth.success12 }</button></td>
									</tr>
									<tr>
									<td><input class="btn btn-outline-danger" type="button" value="실패" disabled="disabled"></td>
									<td ><button id="f1" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail1 }</button></td>
									<td><button  id="f2" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail2 }</button></td>
									<td ><button id="f3" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail3 }</button></td>
									<td ><button id="f4" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail4 }</button></td>
									<td ><button id="f5" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail5 }</button></td>
									<td ><button id="f6" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail6 }</button></td>
									<td ><button id="f7" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail7 }</button></td>
									<td ><button id="f8" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail8 }</button></td>
									<td ><button id="f9" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail9 }</button></td>
									<td ><button id="f10" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail10 }</button></td>
									<td ><button id="f11" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail11 }</button></td>
									<td ><button id="f12" class="btn btn-outline-danger" disabled="disabled" style="width:50px;">${successRatioMonth.fail12 }</button></td>
									</tr>
									</table>
									
									
									
									
									</div>
									</div>

							
<script>

//차트 셋팅 
var ctx = document.getElementById('myChart').getContext('2d');
var config = {
	    type: 'doughnut',
	    data: {
	    	 labels: [ '성공','실패'],
		     datasets: [{
		    	label:'piechart',
		        data: [ 0,0 ],    // 여기에    성공 / 실패 월별 수량 집어넣어! 
		        backgroundColor:  [ 'rgba(54, 162, 235, 1)','rgba(255, 99, 132, 1)' ],
	            borderColor:  [ 'rgba(54, 162, 235, 1)','rgba(255, 99, 132, 1)' ],
		    }],
		    // These labels appear in the legend and in the tooltips when hovering different arcs	   
		},
		options: {
	  	responsive: true
	  }
	};
	

//차트셋팅 끝 

var myDoughnutChart = new Chart(ctx, config);   //차트 그리기 


	/* Chart.pluginService.register({
	  beforeDraw: function(chart) {
	    var width = chart.chart.width,
	        height = chart.chart.height,
	        ctx = chart.chart.ctx;

	    ctx.restore();
	    var fontSize = (height / 114).toFixed(2);
	    ctx.font = fontSize + "em sans-serif";
	    ctx.textBaseline = "middle";

	    //
	    var value = ($("#inputSuccess").val()/ (parseInt($("#inputSuccess").val())+parseInt($("#inputFail").val()))*10000 );
	    var round = Math.round(value)/100;
	    var text = round+'%',
	        textX = Math.round((width - ctx.measureText(text).width) / 2),
	        textY = (height / 1.8);

	    ctx.fillText(text, textX, textY);
	    ctx.save();
	  }
	}); */
//////////////////////////// 파이차트 끝 	
	
$(document).ready(function() {
	
	var thisyear = new Date().getFullYear();
	var use = thisyear-2000;
	var thismonth = new Date().getMonth();
	var use2 = thismonth +1;
	if(use2==1){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success1}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail1}';
	}else if(use2==2){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success2}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail2}';
	}else if(use2==3){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success3}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail3}';
	}else if(use2==4){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success4}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail4}';
	}else if(use2==5){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success5}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail5}';
	}else if(use2==6){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success6}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail6}';
	}else if(use2==7){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success7}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail7}';
	}else if(use2==8){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success8}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail8}';
	}else if(use2==9){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success9}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail9}';
	}else if(use2==10){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success10}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail10}';
	}else if(use2==11){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success11}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail11}';
	}else if(use2==12){
		document.getElementById("inputSuccess").value = '${successRatioMonth.success12}';
		document.getElementById("inputFail").value = '${successRatioMonth.fail12}';
	}
	
	
	/// 파이차트에 데이터 넣기
	var dataset = config.data.datasets;
	for(var i=0; i<dataset.length; i++){
		console.log(dataset);
		//데이터 갯수 만큼 반복
		var data = dataset[i].data;
		data[0] = document.getElementById("inputSuccess").value ;
		data[1] = document.getElementById("inputFail").value;
	}
	
	myDoughnutChart.update();

	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+use+"년 "+use2+"월 성공률  :"+ratio+"%";
	document.getElementById("headname2").value="20"+use+"년 성공률";
	
	});  	
	

$("input[name=yearbtn]").click(function(){    //연도 클릭

	var thisyear = new Date().getFullYear();
	if(thisyear < $(this).val()){
		alert("아직 해당 연도가 시작되지 않았습니다!");	
	}else{
		var using = thisyear-2000;
		var data ={"year":using};
		$.ajax({
			type : "post",
			url : "statisticsManagement.ado",
			data : data,
			success : function(data) {
				document.getElementById("canvaslabel").value="20"+using+"년 성공률";
				document.getElementById("headname2").value="20"+using+"년 성공률";
				
				/// 나만 안되는건지 확인 필요!
				document.getElementById("inputSuccess").value='${successRatio.successyear}';
				document.getElementById("inputFail").value='${successRatio.failyear}';
				config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
				config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
				myDoughnutChart.update();
			},
			error : function() {
				
			}
		});
	}
	
});




$("#btn1").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn1").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success1 };
	document.getElementById("inputFail").value=${successRatioMonth.fail1};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
});

$("#btn2").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn2").value;

	document.getElementById("inputSuccess").value =${successRatioMonth.success2 };
	document.getElementById("inputFail").value=${successRatioMonth.fail2};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn3").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn3").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success3 };
	document.getElementById("inputFail").value=${successRatioMonth.fail3};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn4").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn4").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success4 };
	document.getElementById("inputFail").value=${successRatioMonth.fail4};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn5").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn5").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success5 };
	document.getElementById("inputFail").value=${successRatioMonth.fail5};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn6").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn6").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success6 };
	document.getElementById("inputFail").value=${successRatioMonth.fail6};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn7").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn7").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success7 };
	document.getElementById("inputFail").value=${successRatioMonth.fail7};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn8").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn8").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success8 };
	document.getElementById("inputFail").value=${successRatioMonth.fail8};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn9").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn9").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success9 };
	document.getElementById("inputFail").value=${successRatioMonth.fail9};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn10").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn10").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success10 };
	document.getElementById("inputFail").value=${successRatioMonth.fail10};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn11").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn11").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success11 };
	document.getElementById("inputFail").value=${successRatioMonth.fail11};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
	});
$("#btn12").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn12").value;
	
	document.getElementById("inputSuccess").value =${successRatioMonth.success12 };
	document.getElementById("inputFail").value=${successRatioMonth.fail12};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myDoughnutChart.update();
	var succ = parseInt(document.getElementById("inputSuccess").value);
	var fail =  parseInt(document.getElementById("inputFail").value);
	var realratio = Math.round(succ/(succ+fail)*10000);
	var ratio = realratio/100;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률 :"+ratio+"%";
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