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
								<div class="row" style="height:700px">
									<div class="col-12">
										<div class="card">
											<div class="card-body">
												<h5 class="card-title m-b-0">펀딩 모금액 통계</h5>
											</div>
										</div>
									<table border="1">
								    <tr>
									<td><input type="button" value="2020" name="yearbtn2"></td>
									<td><input type="button" value="2021" name="yearbtn2"></td>
									<td><input type="button" value="2022" name="yearbtn2"></td>
									<td><input type="button" value="2023" name="yearbtn2"></td>
									<td><input type="button" value="2024" name="yearbtn2"></td>
									<td><input type="button" value="2025" name="yearbtn2"></td>
									<td><input type="button" value="2026" name="yearbtn2"></td>
									<td><input type="button" value="2027" name="yearbtn2"></td>
									<td><input type="button" value="2028" name="yearbtn2"></td>
									<td><input type="button" value="2029" name="yearbtn2"></td>
									</tr>
								    </table>
								    
										 <center><input type="text" disabled="disabled" id="chart2title"></center>
										<canvas id="myChart2" style="height:auto;width:400px;"></canvas>
									<table border="1">
									<tr>
									<td> 1월 </td>
									<td> 2월 </td>
									<td> 3월 </td>
									<td> 4월 </td>
									<td> 5월 </td>
									<td> 6월 </td>
									<td> 7월 </td>
									<td> 8월 </td>
									<td> 9월 </td>
									<td> 10월 </td>
									<td> 11월 </td>
									<td> 12월 </td>
									<td> 합계 </td>
									</tr>
									<tr>
									<td> ${fundingMoneyPerMonth.m1 } </td>
									<td> ${fundingMoneyPerMonth.m2 } </td>
									<td> ${fundingMoneyPerMonth.m3 } </td>
									<td> ${fundingMoneyPerMonth.m4 } </td>
									<td> ${fundingMoneyPerMonth.m5 } </td>
									<td> ${fundingMoneyPerMonth.m6 } </td>
									<td> ${fundingMoneyPerMonth.m7 } </td>
									<td> ${fundingMoneyPerMonth.m8 } </td>
									<td> ${fundingMoneyPerMonth.m9 } </td>
									<td> ${fundingMoneyPerMonth.m10 } </td>
									<td> ${fundingMoneyPerMonth.m11 } </td>
									<td> ${fundingMoneyPerMonth.m12 } </td>
									<td> <input type="text" disabled="disabled"	id="fundingMoneySum"> </td>
									</tr>
									</table>
									</div>
								
								</div>
							</div>
						</div>
						
<script>



	var ctx2 = document.getElementById('myChart2').getContext('2d');
	var config = {
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
	
	var myChart2 = new Chart(ctx2,config );    //그리기

	
	$(document).ready(function(){
		var thisyear = new Date().getFullYear();
		var use = thisyear-2000;
		$("#chart2title").val(thisyear+"년 펀딩모금액");
	    $("#fundingMoneySum").val(${fundingMoneyPerMonth.sumfunding});
		
		
		
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
					
					config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
					config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
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
								<div class="row" style="height:600px" >
									<div class="col-12" >
										<div  class="card">
											<div  class="card-body">
												<h5 class="card-title m-b-0">프로젝트 성공률 통계</h5>
											</div>
										</div>
									<div style="display:flex;">
											<!--  그래프 구역   -->
									<div id="left" style="height:225px;width:49%;">
									<center><input type="text" id="canvaslabel" disabled="disabled" style="text-align:center"></center>
									<div id="refresh">
									<canvas id="myChart" style="height:auto;width:auto;"></canvas>
                                    </div>
									<input type="text" id="inputSuccess" >
									<input type="text" id="inputFail" >

   
  
	
	

									</div>
									<div id="rightdiv" style="width:49%">
								
								    <table border="1">
								    <tr>
									<td><input type="button" value="2020" name="yearbtn2"></td>
									<td><input type="button" value="2021" name="yearbtn2"></td>
									<td><input type="button" value="2022" name="yearbtn2"></td>
									<td><input type="button" value="2023" name="yearbtn2"></td>
									<td><input type="button" value="2024" name="yearbtn2"></td>
									<td><input type="button" value="2025" name="yearbtn2"></td>
									<td><input type="button" value="2026" name="yearbtn2"></td>
									<td><input type="button" value="2027" name="yearbtn2"></td>
									<td><input type="button" value="2028" name="yearbtn2"></td>
									<td><input type="button" value="2029" name="yearbtn2"></td>
									
									</tr>
								    </table>
									<table border="1"  >
									<thead ><input type="text" disabled="disabled" id="headname2"> </thead>
									<tr>
									<td>구분</td> 
									<td><input type="button" value="1월" id="btn1"></td>
									<td><input type="button" value="2월" id="btn2"></td>
									<td><input type="button" value="3월" id="btn3"></td>
									<td><input type="button" value="4월" id="btn4"></td>
									<td><input type="button" value="5월" id="btn5"></td>
									<td><input type="button" value="6월" id="btn6"></td>
									<td><input type="button" value="7월" id="btn7"></td>
									<td><input type="button" value="8월" id="btn8"></td>
									<td><input type="button" value="9월" id="btn9"></td>
									<td><input type="button" value="10월" id="btn10"></td>
									<td><input type="button" value="11월" id="btn11"></td>
									<td><input type="button" value="12월" id="btn12"></td>
									</tr>
									<tr>
									<td>성공</td>
									<td id="s1">${successRatioMonth.success1 }</td>
									<td id="s2">${successRatioMonth.success2 }</td>
									<td id="s3">${successRatioMonth.success3 }</td>
									<td id="s4">${successRatioMonth.success4 }</td>
									<td id="s5">${successRatioMonth.success5 }</td>
									<td id="s6">${successRatioMonth.success6 }</td>
									<td id="s7">${successRatioMonth.success7 }</td>
									<td id="s8">${successRatioMonth.success8 }</td>
									<td id="s9">${successRatioMonth.success9 }</td>
									<td id="s10">${successRatioMonth.success10 }</td>
									<td id="s11">${successRatioMonth.success11 }</td>
									<td id="s12">${successRatioMonth.success12 }</td>
									</tr>
									<tr>
									<td>실패</td>
									<td id="f1">${successRatioMonth.fail1 }</td>
									<td id="f2">${successRatioMonth.fail2 }</td>
									<td id="f3">${successRatioMonth.fail3 }</td>
									<td id="f4">${successRatioMonth.fail4 }</td>
									<td id="f5">${successRatioMonth.fail5 }</td>
									<td id="f6">${successRatioMonth.fail6 }</td>
									<td id="f7">${successRatioMonth.fail7 }</td>
									<td id="f8">${successRatioMonth.fail8 }</td>
									<td id="f9">${successRatioMonth.fail9 }</td>
									<td id="f10">${successRatioMonth.fail10 }</td>
									<td id="f11">${successRatioMonth.fail11 }</td>
									<td id="f12">${successRatioMonth.fail12 }</td>
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

	Chart.pluginService.register({
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
	});
//////////////////////////// 파이차트 끝 	
	
$(document).ready(function() {
	
	var thisyear = new Date().getFullYear();
	var use = thisyear-2000;
	var thismonth = new Date().getMonth();
	var use2 = thismonth +1;
	document.getElementById("canvaslabel").value="20"+use+"년 "+use2+"월 성공률";
	document.getElementById("headname2").value="20"+use+"년 성공률";
	

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
	
	myChart.update();
	/// 파이차트에 데이터 넣기 끝
	
	});  	
	

$("input[name=yearbtn]").click(function(){    //연도 클릭
	alert("이게눌려?");
	
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
				myChart.update({duration: 800});
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
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success1 };
	document.getElementById("inputFail").value=${successRatioMonth.fail1};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
});

$("#btn2").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn2").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success2 };
	document.getElementById("inputFail").value=${successRatioMonth.fail2};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn3").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn3").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success3 };
	document.getElementById("inputFail").value=${successRatioMonth.fail3};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn4").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn4").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success4 };
	document.getElementById("inputFail").value=${successRatioMonth.fail4};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn5").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn5").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success5 };
	document.getElementById("inputFail").value=${successRatioMonth.fail5};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn6").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn6").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success6 };
	document.getElementById("inputFail").value=${successRatioMonth.fail6};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn7").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn7").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success7 };
	document.getElementById("inputFail").value=${successRatioMonth.fail7};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn8").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn8").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success8 };
	document.getElementById("inputFail").value=${successRatioMonth.fail8};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn9").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn9").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success9 };
	document.getElementById("inputFail").value=${successRatioMonth.fail9};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn10").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn10").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success10 };
	document.getElementById("inputFail").value=${successRatioMonth.fail10};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn11").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn11").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success11 };
	document.getElementById("inputFail").value=${successRatioMonth.fail11};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
	});
$("#btn12").click(function(){  
	var title = document.getElementById("headname2").value;
	var year = title.substring(2,4);
	var month = document.getElementById("btn12").value;
	document.getElementById("canvaslabel").value="20"+year+"년 "+month+" 성공률";
	document.getElementById("inputSuccess").value =${successRatioMonth.success12 };
	document.getElementById("inputFail").value=${successRatioMonth.fail12};
	config.data.datasets[0].data[0]=document.getElementById("inputSuccess").value;
	config.data.datasets[0].data[1]=document.getElementById("inputFail").value;
	myChart.update();
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