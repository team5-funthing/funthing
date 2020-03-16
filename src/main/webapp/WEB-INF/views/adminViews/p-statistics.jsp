<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>

    <title>Funthing Admin</title>

    <!--  chartjs  -->
   <jsp:include page="include/i-header-setting.jsp" />
   
   
</head>

<body>
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <div id="main-wrapper">
        <jsp:include page="include/i-topbar-header.jsp"/> 
        <jsp:include page="include/i-left-sidebar.jsp"/>
        <div class="page-wrapper">
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                     <h4 class="page-title">카테고리 관리</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="admindex.ado">Home</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>



            <div style = "background-color: white;">
               <div class="row p-5">
                  <div class="col-9 mt-2">
                     <nav>
                        <div class="nav nav-tabs" id="nav-tab" role="tablist">
                           <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Home</a>
                           <a class="nav-item nav-link" id="nav-project-tab" data-toggle="tab" href="#nav-project" role="tab" aria-controls="nav-project" aria-selected="false">프로젝트 통계</a>
                           <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">후원내역 통계</a>
                        </div>
                     </nav>
                  </div>
                  
                  
                  
                  <div class="tab-content p-5 col-12" id="nav-tabContent">
                     
                     <!-- 홈 통계 탭 -->
                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                        
                           <div class="col-8">
                           </div>
                           <div class="col-4">
                           </div>
                        
                        </div>
                        
                        <!-- 프로젝트 통계 탭 -->
                        <div class="tab-pane fade" id="nav-project" role="tabpanel" aria-labelledby="nav-project-tab">
                           
                           <div class="row">
                              <div class="col-8">
								
                              	  <div class="col-9">
                              	  	  <div class="row">
	                              	  	  <form id="searchProjectStatisticsForm">
		 									  <div class="input-group row">
	 									  			<input type="text" class="form-control statisticsStartDate" name="statisticsStartDate" placeholder="시작날짜">
			                                    	<div class="input-group-append datepicker">
			                                        	<span class="input-group-text"><i class="fa fa-calendar "></i></span>
			                                        </div>
			                                    	<div style="color:gray;"><h3>-</h3></div>
				                                    <input type="text" class="form-control statisticsEndDate" name="statisticsEndDate" placeholder="마지막날짜">
				                                    <div class="input-group-append">
				                                        <span class="input-group-text "><i class="fa fa-calendar"></i></span>
				                                    </div>
				                                </div>
				                                   
				                                <div class="row mt-2">
													<select name='funding' class="select2 form-control custom-select select2-hidden-accessible mb-1" style="width: 100%; height:36px;" data-select2-id="1" tabindex="-1" aria-hidden="true">
			                                            <option value='all' data-select2-id="3">진행 모두</option>
			                                            <option value='ing' data-select2-id="3">펀딩 진행중</option>
			                                            <option value='end' data-select2-id="3">펀딩 마감</option>
			                                            
		                                        	</select> 
		                                        	
		                                        	<select name="status" class="select2 form-control custom-select select2-hidden-accessible mb-1" style="width: 100%; height:36px;" data-select2-id="1" tabindex="-1" aria-hidden="true">
			                                            <option value='all' data-select2-id="3">펀딩 결과 모두</option>
			                                            <option value="success" data-select2-id="3">펀딩 성공</option>
			                                            <option value="fail" data-select2-id="3">펀딩 실패</option>
		                                        	</select> 				                                
				                                
				                                </div>
		                                    	
			                                    <div class="col d-flex justify-content-end mt-3">
				                              		<button type="button" id="searchProjectStatistics"  class="btn btn-info btn">검색</button>
				                              	</div>
			                              </form>       
                              	  	  </div>
                              	  </div>
	                              <div class="col-12 mt-5">
	                              	  	<canvas id="barChart"></canvas>
	                              </div>    
                              </div>

                              <div class="col-4">
                                 <canvas id="pieChart" style="width: 300px; height: 300px;"></canvas>
                              </div>                     
                           </div>

                                                
                        </div>
                     <!-- 후원금 통계 -->
                     <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                           
                           <div class="row">
                              <div class="col-8">
                              	   <div class="col-9">
                              	  	  <div class="row">
	                              	  	  <form id="searchSupportStatisticsForm">
		 									  <div class="input-group row mr-4">
	 									  			<input type="text" class="form-control statisticsStartDate" name="statisticsStartDate" placeholder="시작날짜">
			                                    	<div class="input-group-append datepicker">
			                                        	<span class="input-group-text"><i class="fa fa-calendar "></i></span>
			                                        </div>
			                                    	<div style="color:gray;"><h3>-</h3></div>
				                                    <input type="text" class="form-control statisticsEndDate" name="statisticsEndDate" placeholder="마지막날짜">
				                                    <div class="input-group-append">
				                                        <span class="input-group-text "><i class="fa fa-calendar"></i></span>
				                                    </div>
				                                </div>
				                                   
				                                <div class="row mt-2 mr-2">
													<select name='paymentStatus' class="select2 form-control custom-select select2-hidden-accessible mb-1" style="width: 100%; height:36px;" data-select2-id="1" tabindex="-1" aria-hidden="true">
			                                            <option value='all' data-select2-id="3">진행 모두</option>
			                                            <option value='결제예약' data-select2-id="3">결제예약건</option>
			                                            <option value='결제취소' data-select2-id="3">결제취소건</option>
			                                            <option value='후원확정' data-select2-id="3">결제확정건</option>
		                                        	</select> 				                                
				                                
				                                </div>
		                                    	
			                                    <div class="col d-flex justify-content-end mt-3">
				                              		<button type="button" id="searchSupportStatistics"  class="btn btn-info btn">검색</button>
				                              	</div>
			                              </form>

                              	  	  </div>
                             	  	  	
                              	    </div>
                              	    
                              	  
                              	  
	                              <div class="col-12 mt-5">
	                              	  	<canvas id="supportBarChart"></canvas>
	                              </div>                              	  
                              	  
                              </div>

                              <div class="col-4">
                                 <canvas id="supportPieChart" style="width: 300px; height: 300px;"></canvas>
                              </div>                     
                           </div>

                                                
                        </div>
                     
                  </div>
               </div>
            </div>
  
            </div>
        </div>
     </div>
     
     <jsp:include page="include/i-footer.jsp" />
     
      <script>
      
      
      
	      /*datepicker*/
		$('.statisticsStartDate').datepicker({
			format: "yyyy-mm-dd",
			endDate: '0d',
	        language : "ko"	
			
	    });
	      
		$('.statisticsEndDate').datepicker({
			format: "yyyy-mm-dd",
			endDate: '0d',
	        language : "ko"
			
	    });
		
		
		
		
  	  var barLabelList = new Array();
	  var barValueList = new Array();
	  var pieLabelList = new Array();
	  var pieValueList = new Array();

	  
      var barCtx = document.getElementById("barChart").getContext('2d');
      var pieCtx = document.getElementById("pieChart").getContext('2d'); 

      var barChart = new Chart(barCtx, {
          type: 'bar',
          autoclose: true,
          data: {
        	  
              labels: barLabelList,
              datasets: [{
                  label: '등록된 프로젝트 현황',
                  data: barValueList,
                	  
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ],
                  borderColor: [
                      'rgba(255,99,132,1)',
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
        	  title : {
        		  display: true,
          		  text : "프로젝트 등록 현황"
        	  },
              maintainAspectRatio: true,
              scales: {
                  yAxes: [{
                      ticks: {
                          beginAtZero:true
                      }
                  }]
              }
          }
      });
      var pieChart = new Chart(pieCtx, {
         type: 'pie',
         data: {
            datasets: [{
               data: pieValueList,
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ]
            }],
            labels: pieLabelList
         },
         options: {
            responsive: true
            
         }
      });
      
 /* ================================================================================================== */     
 
      var supportBarCtx = document.getElementById("supportBarChart").getContext('2d');
      var supportPieCtx = document.getElementById("supportPieChart").getContext('2d'); 
           
      var supportBarChart = new Chart(supportBarCtx, {

    	  type: 'bar',
    	  autoclose: true,
          data: {
        	  
              labels: barLabelList,
              datasets: [{
                  label: '후원 금액 현황',
                  data: barValueList,
                	  
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ],
                  borderColor: [
                      'rgba(255,99,132,1)',
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
        	  title : {
        		  display: true,
          		  text : "후원 현황"
        	  },
              maintainAspectRatio: true, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
              scales: {
                  yAxes: [{
                      ticks: {
                          beginAtZero:true
                      }
                  }]
              }
          }
      });
      var supportPieChart = new Chart(supportPieCtx, {
         type: 'pie',
         data: {
            datasets: [{
               data: pieValueList,
                  backgroundColor: [
                      'rgba(255, 99, 132, 0.2)',
                      'rgba(54, 162, 235, 0.2)',
                      'rgba(255, 206, 86, 0.2)',
                      'rgba(75, 192, 192, 0.2)',
                      'rgba(153, 102, 255, 0.2)',
                      'rgba(255, 159, 64, 0.2)'
                  ]
            }],
            labels: pieLabelList
         },
         options: {
            responsive: true
            
         }
      });
      
 /* ================================================================================================== */     
      
      
      
		$(document).on("click", "#searchProjectStatistics", function(){
			

	      	var jsonData = $("form[id='searchProjectStatisticsForm'").serializeObject();
			console.log(jsonData);
			
			$.ajax({
	            url: "searchProjectStatistics.ado",
	            type: "POST",
	            data: JSON.stringify(jsonData),
	            contentType: "application/json;",
	            success: function(data) {
	            	
	            	pieValueList.splice(0, pieValueList.length);
					pieLabelList.splice(0, pieLabelList.length);
	            	barValueList.splice(0, barValueList.length);
					barLabelList.splice(0, barLabelList.length);
	            	
	            	
	            	
					var dataList = JSON.parse(data);
					
					var projectStatistics = dataList.projectRegStatistics;
					var projectCategryStatistics = dataList.projectRegCategryStatistics;
	                 
	                 console.log(projectStatistics);
	                 console.log(projectCategryStatistics);
	                 
	                 
						for (var i = 0; i < projectStatistics.length; i++) {
							var d = projectStatistics[i];
							barValueList.push(d.projectRegCount);
							barLabelList.push(d.statisticsDate);
						}
						for (var i = 0; i < projectCategryStatistics.length; i++) {
							var d = projectCategryStatistics[i];
							pieValueList.push(d.projectRegCount);
							pieLabelList.push(d.category);
						}
	
	                 	console.log(barValueList);
	                 	console.log(barLabelList);
	                 	
	                 	barChart.update();
	                 	pieChart.update();
  	 

	                 
	                 
	            },
	            error: function(errorThrown) {
	                console.log(errorThrown.statusText);
	            }
	        });			
			
		})  
		
		
		$(document).on("click", "#searchSupportStatistics", function(){
			

	      	var jsonData = $("form[id='searchSupportStatisticsForm'").serializeObject();
			console.log(jsonData);
			
			$.ajax({
	            url: "searchSupportStatistics.ado",
	            type: "POST",
	            data: JSON.stringify(jsonData),
	            contentType: "application/json;",
	            success: function(data) {
	            	
 	            	pieValueList.splice(0, pieValueList.length);
					pieLabelList.splice(0, pieLabelList.length);
 	            	barValueList.splice(0, barValueList.length);
					barLabelList.splice(0, barLabelList.length);
	            	
	            	
	            	
					var dataList = JSON.parse(data);
					
					var supportStatisticsList = dataList.supportStatisticsList;
					var getSupportCategoryStatisticsList = dataList.getSupportCategoryStatisticsList;
	                 
	                 console.log(supportStatisticsList);
 	                 console.log(getSupportCategoryStatisticsList);
	                 
	                 
						for (var i = 0; i < supportStatisticsList.length; i++) {
							var d = supportStatisticsList[i];
							barValueList.push(d.fundingMoney);
							barLabelList.push(d.statisticsDate);
						}
 						for (var i = 0; i < getSupportCategoryStatisticsList.length; i++) {
							var d = getSupportCategoryStatisticsList[i];
							pieValueList.push(d.fundingMoney);
							pieLabelList.push(d.category);
						}
	
	                 	console.log(barValueList);
	                 	console.log(barLabelList);
	                 	
	                 	supportBarChart.update();
	                 	supportPieChart.update();
  	 
	                 
	            },
	            error: function(errorThrown) {
	                console.log(errorThrown.statusText);
	            }
	        });			
			
		})  
   </script>
   


	    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<script>
$.fn.serializeObject = function() {
	  "use strict";
	   var result = {}
	   var extend = function(i, element) {
		  var node = result[element.name];
		  if ("undefined" !== typeof node && node !== null) {
		      if ($.isArray(node)) {
		        node.push(element.value);
		      	} else {
		        result[element.name] = [node, element.value];
		    	}
		   } else {
		      result[element.name] = element.value;
		   }
		}

	$.each(this.serializeArray(), extend);
	return result;
}
</script>    
    
    
</body>

</html>