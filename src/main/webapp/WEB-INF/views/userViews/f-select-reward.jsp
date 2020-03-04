<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html class="no-js">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
</head>

<body>
  	
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    
    
    <c:if test="${ msg ne null }">
    	<script>
    		alert("${msg }");
    	</script>
    </c:if>
    
    

	<section id="select-reward" class="container">
        <article class="back-story">
            <i class="fas fa-chevron-left"></i>
            <a href="javaScript: history.go(-1);">스토리로 돌아가기</a>
        </article>
		<article class="select-order">
            <div class="row d-flex justify-content-center ml-2 mr-2 mt-4 pb-4">
                <div class="order-circle d-flex d-flex justify-content-center " style="background: #009DFF;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-3" style="color: whitesmoke;" >
                        리워드<br>
                        선택
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                </div>
                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke; border-style:dotted; border-color: whitesmoke; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-0" style="color: #000000;" >
                        결제 예약
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color:whitesmoke;"></i>
                </div>
                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke; border-style:dotted; border-color: whitesmoke; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-0" style="color: #000000;" >
                        결제 확인
                    </div>
                </div>
            </div>
        </article>



        <article class="mt-5 pb-3">
            <div class="d-flex justify-content-between">
                <div>
                    <div class="h5">리워드 선택</div>
                    <p class="card-text">펀딩 금액에 따라 리워드가 달라 집니다.</p>
                </div>
                <div class="">
                    <div class="align-self-center">
                        <p class="card-text">펀딩하기는 쇼핑하기가 아닙니다!자세히 알아보세요.</p>
                    </div>
                </div>
            </div>
        </article>

        
        <article class="pb-5">
        
        
       		<c:forEach var="reward" items="${getRewardList }" varStatus="cnt">
       			<form id="reward${cnt.count }" name="reward${cnt.count }" action="addSelectReword.udo" method="POST">
       			
		            <div id="reward-cardBox${cnt.count }" class="card wd-100 mb-2 ">
		            
		            	<input type="hidden" name="rewardNo" value="${reward.rewardNo }">
						<input type="hidden" name="email" value="${sessionScope.memberSession.email }">
						<input type="hidden" name="paymentAmount" value="${reward.rewardPrice }">
						<input type="hidden" name="shippingFee" value="${reward.shippingFee }">
						
						
		                <!-- 리워드 선택 박스 1 [ 리워드 품목 등록 수 만큼 반복 ]-->
		                <!-- !!! 선택 체크박스 클릭시 수량 및 옵션항목이 나오는 부분에 대한 문제점 처리 해야한다 -->
		                <div class="row no-gutters">
		                    <div class="col-md-auto align-self-start mt-5 mr-4">
		                        <div class="select-checkbox">
		                            <input type="checkbox" id="select-reward${cnt.count }">
		                            <label for="select-reward${cnt.count }" class="select-reward"></label>
		                        </div>
		                    </div>      
		                    <div class="card-body">
		                        <aside>
		                            <h6 class="card-title">${reward.rewardPrice }원 펀딩합니다.</h6>
		                            <p class="card-text">${reward.rewardName }</p>
		                            <p class="card-text">${reward.rewardContent }</p>
		
		                            <p class="card-text to-add-place">배송비 ${reward.shippingFee }원 | 예상 배송일 추가안내</p>
		                            
		                            <div id="checkTrue${cnt.count }" class="row">
		                            </div>
		                        </aside>
		                    </div>
		                </div>
		            </div>
	           	</form>
	           	
                <script>
                
	                jQuery.fn.serializeObject = function() { 
	                    var obj = null; 
	                    try { 
	                        if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
	                            var arr = this.serializeArray(); 
	                            if(arr){ obj = {}; 
	                            jQuery.each(arr, function() { 
	                                obj[this.name] = this.value; }); 
	                            } 
	                        } 
	                    }catch(e) { 
	                        alert(e.message); 
	                    }finally {} 
	                    return obj; 
	                }
                
                	$(document).on("click", "input[id=select-reward${cnt.count }]", function(){
                		
                		if($("#select-reward${cnt.count }").is(":checked")){
                			
                			$("#reward-cardBox${cnt.count }").css('background-color', '#d9e6f2');
                			
                			$("#checkTrue${cnt.count }").append("<div class='col-2 to-remove-tag mt-2'>"
                						+"<p class='card-text m-auto'>수량 [${reward.rewardAmount }개 남음]</p>"
		                            +"<div class='row align-items-md-center mb-4'>"
		                               +"<a id='minus${cnt.count }' href='#'> <i class='fas fa-minus ml-3'></i></a>"
		                                +"<input class='form-control ml-2 mr-2' style='width:50px;' value='1' id='orderAmount${cnt.count }' type='text' name='orderAmount' placeholder=''>"
		                                +"<a id='plus${cnt.count }' href='#'> <i class='fas fa-plus'></i></a>"
		                            +"</div>" 
		                        +"</div>"
		                        +"<div id='selectBox${cnt.count }' class='col-2 to-remove-tag mt-2'>"
		                            +"<p class='card-text m-auto'>옵션</p>"
		                            +"<select id='rewardOptionSelectBox'  class='custom-select' >" //name='rewardOptionValue'
		                                +"<c:forEach var='option' items='${reward.rewardOptionList }' varStatus='opCnt'>"
		                                	+"<option value='${option.rewardOptionValue }'> ${option.rewardOptionKey } : ${option.rewardOptionValue }</option>"
		                                +"</c:forEach>"
		                            +"</select>"
		                        +"</div>");
		                        
                		}else{
                			$("#reward-cardBox${cnt.count }").css('background-color', '');
                			$("#checkTrue${cnt.count }").empty();
                		}
                		
                	});	
                	
	                $(document).on("click", "a[id='plus${cnt.count }']", function(e){
	                	e.preventDefault();
	                	var currentVal = parseInt($('#orderAmount${cnt.count }').val());
	                	$('#orderAmount${cnt.count }').val(++currentVal);
	                });
	                
	                $(document).on("click", "a[id='minus${cnt.count }']", function(e){
	                	
	                	e.preventDefault();
	               
	                	var currentVal = parseInt($('#orderAmount${cnt.count }').val());
	                	if(currentVal > 1){
	                		$('#orderAmount${cnt.count }').val(--currentVal);
	                	}
	                });
	                
					$(document).on("change", "input[id='orderAmount${cnt.count }']", function(){
						
						var elements = $('#selectBox${cnt.count }').children();
						var elementsLength = elements.length-1;
						
						var currentVal = parseInt($('#orderAmount${cnt.count }').val());
						
						if(currentVal == elementsLength){}
						else if(currentVal > elementsLength) {
							for(i = elementsLength ; i < currentVal; i++){
								$('#selectBox${cnt.count }').append("<select id='rewardOptionSelectBox${cnt.count }' name='rewardOptionValue' class='custom-select mt-1' >"
												                        +"<c:forEach var='option' items='${reward.rewardOptionList }' varStatus='opCnt'>"
												                        	+"<option value='${option.rewardOptionValue }'> ${option.rewardOptionKey } : ${option.rewardOptionValue }</option>"
												                        +"</c:forEach>"
												                    +"</select>");
							}
						}else{
							for(i = elementsLength; i > currentVal; i--){
								$('#selectBox${cnt.count }').children().last().remove();
							}
						}
	                });
	                
                	$(document).on("click", "input[id='select-reward${cnt.count }']", function(){
                		
                		var jsonData = $("form[name='reward${cnt.count }']").serializeObject();
                		
                		if($("#select-reward${cnt.count }").is(":checked")){
                			
                			$.ajax({
       						    url: "addSelectReward.udo",
       						    type: "post",
       						    data: JSON.stringify(jsonData),
       						    contentType: "application/json",
       						    success: function(data) { 
       						    	
       								var rewardSelection = JSON.parse(data);
       								
       								var paymentAmount = 0;
         							$.each(rewardSelection, function(index, value ){
         								
       									//$('#selectedCompleteReward').append("<input type='text' name='rewardNo' value='" + ${rewardSelection.rewardNo } +"'>"
    							   		//									+"<input type='text' name='email' value='" + ${rewardSelection.email } +"'>"
    							   		//									+"<input type='text' name='paymentAmount' value='" + rewardSelection.paymentAmount +"'>"
    							   		//									+"<input type='text' name='orderAmount' value='" + rewardSelection.orderAmount +"'>"
    							   		//									+"<input type='text' name='shippingFee' value='" + rewardSelection.shippingFee +"'>");
       									
         								paymentAmount += value.paymentAmount;

         							});
         							$('#totalAmount').empty();
         							$('#totalAmount').append("총 " + paymentAmount + "원을 후원합니다.");
       						    },
       						    error: function(errorThrown) {
       						        alert(errorThrown.statusText);
       						    }
        					});	                			
                			
                			
                		}else{
                			
                			$.ajax({
    						    url: "removeSelectReward.udo",
    						    type: "post",
    						    data:  JSON.stringify(jsonData),
    						    contentType: "application/json",
    						    success: function(data) {
    						    	
       								var rewardSelection = JSON.parse(data);
       								
       								var paymentAmount = 0;
         							$.each(rewardSelection, function(index, value ){
         								
       									//$('#selectedCompleteReward').append("<input type='text' name='rewardNo' value='" + ${rewardSelection.rewardNo } +"'>"
    							   		//									+"<input type='text' name='email' value='" + ${rewardSelection.email } +"'>"
    							   		//									+"<input type='text' name='paymentAmount' value='" + rewardSelection.paymentAmount +"'>"
    							   		//									+"<input type='text' name='orderAmount' value='" + rewardSelection.orderAmount +"'>"
    							   		//									+"<input type='text' name='shippingFee' value='" + rewardSelection.shippingFee +"'>");
       									
       									paymentAmount += value.paymentAmount;
         							});
         							
         							$('#totalAmount').empty();
         							$('#totalAmount').append("총 " + paymentAmount + "원을 후원합니다.");
         							
    						    },
    						    error: function(errorThrown) {
    						    	alert(errorThrown.statusText);
    						    }
    						});		
                			
                		}
                		
                	});
                	
                	
                	$(document).on("change", "input[id='orderAmount${cnt.count }']", function(){
                		
                		var jsonData = $("form[name='reward${cnt.count }']").serializeObject();
                		
	               			$.ajax({
	   						    url: "addSelectReward.udo",
	   						    type: "post",
	   						    data: JSON.stringify(jsonData),
	   						    contentType: "application/json",
	   						    success: function(data) {
	   						    	
	   								var rewardSelection = JSON.parse(data);
	   								
	   								
	   								var paymentAmount = 0;
	     							$.each(rewardSelection, function(index, value ){
	     								
	   									//$('#selectedCompleteReward').append("<input type='text' name='rewardNo' value='" + ${rewardSelection.rewardNo } +"'>"
								   		//									+"<input type='text' name='email' value='" + ${rewardSelection.email } +"'>"
								   		//									+"<input type='text' name='paymentAmount' value='" + rewardSelection.paymentAmount +"'>"
								   		//									+"<input type='text' name='orderAmount' value='" + rewardSelection.orderAmount +"'>"
								   		//									+"<input type='text' name='shippingFee' value='" + rewardSelection.shippingFee +"'>");
	   									
	   									paymentAmount += value.paymentAmount;
		
	     							});
	     							
	     							$('#totalAmount').empty();
	     							$('#totalAmount').append("총 " + paymentAmount + "원을 후원합니다.");
	   						    },
	   						    error: function(errorThrown) {
	   						        alert(errorThrown.statusText);
	   						    }
    					});		
              
                	});
                	
                </script>
                
				<script>
					$(document).ready(function(){		
						$("#rewardOptionSelectBox").val("${selectedRewardOption.rewardOptionValue }").prop("selected", true);
					});
				</script>                   
                
                
            </c:forEach>
            

            
            
        </article> 
        
		<form id="selectedCompleteReward" action="" method="POST">
		
		
		</form>
        
        
		<!-- --------------------------------------------------- -->
	
        <article class="">
            <div class="row">
                <div class="col-3">
                    <div class="h5">후원금 더하기 (선택)</div>
                </div>
                <div class="col-9">
                    <p>후원금을 더하여 펀딩할 수 있습니다. 추가 후원금을 입력하시겠습니까?</p>
                    <div class="row">
                        <input class="form-control ml-2 mr-2" style="width:200px;" type="text" placeholder="0">
                        <span>원을 추가로 후원합니다.</span>
                    </div>
                </div>
            </div>
        </article>

        <article class="pb-5">
            <div class="row">
                <div class="col-3">
                    <div class="h5">공개여부 (선택)</div>
                </div>
                <div class="col-9">
                    <p>서포터 목록에 서포터 이름과 펀딩 금액이 공개됩니다. 조용히 펀딩하고 싶으시다면, 비공개로 선택해주세요.<br>
                        	커뮤니티, 새소식 댓글 작성 시에는 비공개 여부와 상관없이 펀딩 참여자 표시가 노출됩니다.</p>
                    <div class="row">
                        <div class="col-4">
                            <div class="private-name">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="private-name-check">
                                    <label class="custom-control-label" for="private-name-check">이름 비공개</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="private-funding">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="private-funding-check">
                                    <label class="custom-control-label" for="private-funding-check">펀딩금액 비공개</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
		
		<h4> 총금액 : </h4> <div id="totalAmount" class="h4"></div>

        <article class="p-5 d-flex justify-content-end">
            <div class="d-inline-flex p-2 bd-highlight">
            	<form id="paymentReservationForm" action="insertselectedReward.udo" method="post">
            		<input type="hidden" name="projectNo" value="${projectNoOfRewardList }">
                	<a href="javaScript: return(0);" onclick="document.getElementById('paymentReservationForm').submit();" class="btn btn-primary"> 다음 단계로 <i class="fas fa-angle-right"></i></a>
                </form>
            </div>
        </article>
        
    </section>	

    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>









<script>

	jQuery.fn.serializeObject = function() {
		var obj = null;
		try {
			if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
				var arr = this.serializeArray();
				if (arr) {
					obj = {};
					jQuery.each(arr, function() {
						obj[this.name] = this.value;
					});
				}
			}
		} catch (e) {
			alert(e.message);
		} finally {
		}
		return obj;
	}

	$(document).on("change", "input[id='orderAmount${cnt.count }']",function() {

		var jsonData = $("form[name='reward${cnt.count }']").serializeObject();

		$.ajax({
			url : "addSelectReward.udo",
			type : "post",
			data : JSON.stringify(jsonData),
			contentType : "application/json",
			success : function(data) {
				alert("성공");
			},
			error : function(errorThrown) {
				alert(errorThrown.statusText);
			}
		});

	});
</script>
















