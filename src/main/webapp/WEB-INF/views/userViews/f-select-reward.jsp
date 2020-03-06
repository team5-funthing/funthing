<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html class="no-js">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
  
<style>
table{
	border-collapse: collapse;
	width: 550px;
	margin:10px auto;
}
table, tr, td{
	border: gray 1px solid;
}
.explaneReward{
	text-align: left;
	color:black;
}
.checkBox{
	float:left;
	margin:5px 0 0 8px;
}
#confirmButton{
	background-color: black;
	border: none;
	color: white;
	padding: 14px 270px;
	text-align: center;
	text-decoration:none;
}
#warning-popup{
	padding: 40px 10px 10px 10px;
}
.white-popup {
  position: relative;
  background: #FFF;
  padding: 40px;
  width: 650px;
  margin: 20px auto;
  text-align: center;
}
</style>  
<script>
	function checkboxFunction(){
		var explane1 = document.getElementById('explane1');
		var explane2 = document.getElementById('explane2');
		var explane3 = document.getElementById('explane3');
		
		if((explane1.checked==true)&&(explane2.checked==true)&&(explane3.checked==true)){
			$("#confirmButton").show();
			$("#confirmButton").attr("disabled",false);
		}else{
			$("#confirmButton").hide();
			$("#confirmButton").attr("disabled",true);
		}
	}
	
	$(document).ready(function(){
		$("#confirmButton").hide();
		$("#confirmButton").attr("disabled",true);
		$("#getDetailPolicy").hide();
		
		$.magnificPopup.open({
			items:[
				{
					src:"#warning-popup",
					type:'inline'
				}
			],
			closeOnBgClick:false,
			showCloseBtn:false,
			closeBtnInside:false
		});
		
		$("#detailPolicy").click(function(){
			$("#getDetailPolicy").toggle("slow");
			$.ajax({
				type:"post",
				url:"getServiceTos.udo",
				success:function(data){
					$("#getDetailPolicy").html(data);
				},
				error:function(){
					alert('실패');
				}
			});
		});
		
		$('#confirmButton').on( "click", function() {
			  $.magnificPopup.close();
			});
	});
</script>

</head>

<body>
  	
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    
    
    <c:if test="${ msg ne null }">
    	<script>
    		alert("${msg }");
    	</script>
    </c:if>
  
    <script>
		$( document ).ready(function() {
			
			$('input:checkbox').prop("checked", false);
			
		});
    </script>
  
    <!-- 팝업 시작 -->
    <div id="warning-popup" class="mfp-hide white-popup">
    	<div style="color:black;"><h3>잠깐! 결제하기가 아닌 펀딩하기인 이유를 확인하고,펀딩하세요.</h3></div>
    	<div>
    		<form action="#">
    			<table>
    				<tr>
    					<td>
    						<label class="checkBox">
    							<input type="checkbox" id="explane1" onclick="checkboxFunction()">
    							펀딩한 리워드는 새롭게 준비하고 있는 제품 · 서비스입니다.
    						</label>
    					</td>
    				</tr>
    				<tr>
    					<td>
    						<div class="explaneReward">
    							펀딩 후, 리워드를 제작 · 준비하는 크라우드펀딩 특성상, 품질 이슈가 발생할 수 있습니다.<br>
    							리워드 품질 이슈 발생 시 펀딩 안내 - 상세 정책을 꼭 확인해주세요.
		    				</div>	
    					</td>
    				</tr>
    				<tr>
    					<td>
    						<a id="detailPolicy">프로젝트 상세 정책</a>
    						<div id="getDetailPolicy" style="overflow:auto;height:130px;"></div>
    					</td>
    				</tr>
    			</table>
    			<table>
    				<tr>
    					<td>
    						<label class="checkBox">
    							<input type="checkbox" id="explane2" onclick="checkboxFunction()">  						
    							바로 결제되지 않으며, 펀딩 종료 후에는 결제를 취소할 수 없습니다.
       						</label>
    					</td>
    				</tr>
    				<tr>
    					<td>
    						<div class="explaneReward">
    							펀딩이 동료되고 목표금액이 달성될경우 결제가 진행됩니다.<br>
    							펀딩 종료 이후에는 메이커의 프로젝트 수행을 위해 결제 취소가 불가합니다.
    						</div>
    					</td>
    				</tr>
    			</table>
    			<table>
    				<tr>
    					<td>
    						<label class="checkBox">
    							<input type="checkbox" id="explane3" onclick="checkboxFunction()">
    							펀딩한 리워드는 즉시 배송되지 않습니다.
    						</label>
    					</td>
    				</tr>
    				<tr>
    					<td>
    						<div class="explaneReward">
    							메이커가 약속한 리워드 발송 시작일을 확인했나요? 메이커는 펀딩이 성공해야 리워드 제작 · 준비를 진행합니다.<br>
    							리워드 펀딩 특성상 발송이 지연되거나 불가할 수 있으니, 펀딩 안내 - 상세 정책을 꼭 확인해주세요.
    						</div>
    					</td>
    				</tr>
    			</table>
    		</form>
    	</div>
    	<div>
    		<button id="confirmButton">확인</button>
    	</div>
    </div>
	<!-- 팝업 종료 -->
  
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
						<input type='hidden' name='rewardOptionValueList' value=''>
						
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
		
		                            
		                            
		                            <div id="checkTrue${cnt.count }" class="row">
		                            </div>
		                        </aside>
		                    </div>
		                </div>
		            </div>
	           	</form>
	           	
                <script>
                	
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
	                
					$(document).on("change keyup input ", "input[id='orderAmount${cnt.count }']", function(){
						
						var elements = $('#selectBox${cnt.count }').children();
						var elementsLength = elements.length-1;
						
						var currentVal = parseInt($('#orderAmount${cnt.count }').val());
						
						if(currentVal == elementsLength){}
						else if(currentVal > elementsLength) {
							for(i = elementsLength ; i < currentVal; i++){
								$('#selectBox${cnt.count }').append(	"<c:if test='${reward.rewardOptionList[0].rewardOptionKey eq null}'>"
									                            	+		"<div class='form-group'>"
									                                +			"<input type='text' name='rewardOptionValueList' class='form-control reward${cnt.count }' placeholder=''>"
									                              	+		"</div>"
									                            	+	"</c:if>"
									                            	
									                            	+	"<c:if test='${reward.rewardOptionList[0].rewardOptionKey ne null}'>"
									                            	+		"<div class='form-group'>"
									                            	+			"<select class='form-control reward${cnt.count }' name='rewardOptionValueList'>"
									                                +				"<c:forEach var='option' items='${reward.rewardOptionList }' varStatus='opCnt'>"
									                                +					"<option value='${option.rewardOptionValue }'> ${option.rewardOptionValue }</option>"
									                                +				"</c:forEach>"
									                            	+			"</select>"
															        +       "</div>"
									                            	+	"</c:if>");
							}
						}else{
							for(i = elementsLength; i > currentVal; i--){
								$('#selectBox${cnt.count }').children().last().remove();
							}
						}
	                });
	                
                	$(document).on("click", "input[id='select-reward${cnt.count }']", function(){
                		
                		var jsonData = $("#reward${cnt.count }").serializeObject();
                		
                		
						if($("#select-reward${cnt.count }").is(":checked")){
                			$("#reward-cardBox${cnt.count }").css('background-color', '#d9e6f2');
                			$("#checkTrue${cnt.count }").append("<div class='col-2 to-remove-tag mt-2'>"
                					
							                						+"<p class='card-text m-auto'>수량 [${reward.rewardAmount }개 남음]</p>"
									                            	+	"<div class='row align-items-md-center mb-4'>"
									                               	+	"<a id='minus${cnt.count }' href='#'> <i class='fas fa-minus ml-3'></i></a>"
									                                +	"<input class='form-control ml-2 mr-2' style='width:50px; reward${cnt.count }' value='1' id='orderAmount${cnt.count }' type='text' name='orderAmount' placeholder=''>"
									                                +	"<a id='plus${cnt.count }' href='#'> <i class='fas fa-plus'></i></a>"
									                            	+	"</div>" 
									                        		+"</div>"
									                        		
									                        		+"<div id='selectBox${cnt.count }' class='col-5 to-remove-tag mt-2'>"
									                            	+	"<p class='card-text m-auto'>옵션</p>"
									                            	+	"<c:if test='${reward.rewardOptionList[0].rewardOptionKey eq null}'>"
									                            	+		"<div class='form-group'>"
									                                +			"<label for='inputOption'>${reward.rewardOptionList[0].rewardOptionValue }</label>"
									                                +			"<input type='text' name='rewardOptionValueList' value='' class='form-control reward${cnt.count }' placeholder=''>"

									                              	+		"</div>"
									                            	+	"</c:if>"
									                            	
									                            	+	"<c:if test='${reward.rewardOptionList[0].rewardOptionKey ne null}'>"
									                            	+		"<div class='form-group'>"
									                            	+			"<label for='rewardOptionSelectBox'>${reward.rewardOptionList[0].rewardOptionKey }</label>"
									                            	+			"<select class='form-control reward${cnt.count }' name='rewardOptionValueList'>"
									                                +				"<c:forEach var='option' items='${reward.rewardOptionList }' varStatus='opCnt'>"
									                                +					"<option value='${option.rewardOptionValue }'> ${option.rewardOptionValue }</option>"
									                                +				"</c:forEach>"
									                            	+			"</select>"
															        +       "</div>"
									                            	+	"</c:if>"
									                        		+"</div>");
                		}else{
                			
                			console.log(jsonData);
                			
                			$.ajax({
    						    url: "removeSelectReward.udo",
    						    type: "post",
    						    data:  JSON.stringify(jsonData),
    						    contentType: "application/json",
    						    success: function(data) {
    						    	
       								var rewardSelection = JSON.parse(data);
       								
       								var paymentAmount = 0;
         							$.each(rewardSelection, function(index, value){
       									paymentAmount += value.paymentAmount;
         							});
         							
         							$("#reward-cardBox${cnt.count }").css('background-color', '');
                        			$("#checkTrue${cnt.count }").empty();
                        			
         							$('#totalAmount').empty();
         							$('#totalAmount').append( paymentAmount + "원을 후원합니다.(배송비 제외)");
         							
    						    },
    						    error: function(errorThrown) {
    						    	alert(errorThrown.statusText);
    						    }
    						});		
                		}
                	});
                	
                	
                	
                	$(document).on("propertychange change keyup paste input","input.reward${cnt.count }", function(){

                		var jsonData = $("#reward${cnt.count }").serializeObject();
               			$.ajax({
   						    url: "addSelectReward.udo",
   						    type: "post",
   						    data: JSON.stringify(jsonData),
   						    contentType: "application/json",
   						    success: function(data) {
   						    	
   								var rewardSelection = JSON.parse(data);
   								
   								
   								var paymentAmount = 0;
     							$.each(rewardSelection, function(index, value ){
     								
   									paymentAmount += value.paymentAmount;
	
     							});
     							
     							$('#totalAmount').empty();
     							$('#totalAmount').append( paymentAmount + "원을 후원합니다.(배송비 제외)");
   						    },
   						    error: function(errorThrown) {
   						        alert(errorThrown.statusText);
   						    }
   						});	
                		
                	});
                	
                	
                	
                	$(document).on("change", "input[id='orderAmount${cnt.count }']", function(){
                		
                		var jsonData = $("form[name='reward${cnt.count }']").serializeObject();
                		
                		console.log(jsonData);
                		
                		
               			$.ajax({
   						    url: "addSelectReward.udo",
   						    type: "post",
   						    data: JSON.stringify(jsonData),
   						    contentType: "application/json",
   						    success: function(data) {
   						    	
   								var rewardSelection = JSON.parse(data);
   								
   								
   								var paymentAmount = 0;
     							$.each(rewardSelection, function(index, value ){
     								
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
        
        
		<!-- --------------------------------------------------- -->
		<form id="paymentReservationForm" action="insertselectedReward.udo" method="post">
			<input type="hidden" name="projectNo" value="${projectNoOfRewardList }">
			
			<article>  
	            <div class="row">
	                <div class="col-3">
	                    <div class="h5">배송비</div>
	                </div>
	                <div class="col-9">
                    	<c:choose>
                    		<c:when test="${getRewardList[0].shippingFee ne 0 }">
                    			<p>수량과 지역에 따라 배송비가 달라질 수 있습니다.</p>
                    			<div class="row">
                    				<input type="text" name="shippingFee" 
                    						value="${getRewardList[0].shippingFee }" 
                    						class="form-control ml-2 mr-2" 
                    						style="width:200px;" readonly>
                    				<span>원</span>
                    			</div>
                    		</c:when>
                    		<c:otherwise>
                    			<div class="row">
                    				<span>배송이 필요없는 리워드 펀딩입니다.</span>
                    			</div>
                    		</c:otherwise>
                    	</c:choose>  
	                </div>
	            </div>
	        </article>
			<hr>
			
	        <article>  
	            <div class="row">
	                <div class="col-3">
	                    <div class="h5">후원금 더하기 (선택)</div>
	                </div>
	                <div class="col-9">
	                    <p>후원금을 더하여 펀딩할 수 있습니다. 추가 후원금을 입력하시겠습니까?</p>
	                    <div class="row">
	                        <input type="text" name="additionalFundingMoney" value="0" class="form-control ml-2 mr-2" style="width:200px;" placeholder="0">
	                        <span>원을 추가로 후원합니다.</span>
	                    </div>
	                </div>
	            </div>
	        </article>
			<hr>
	        <article>
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
	                                    <input type="checkbox" name="privateName" class="custom-control-input" id="private-name-check">
	                                    <label class="custom-control-label" for="private-name-check">이름 비공개</label>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-4">
	                            <div class="private-funding">
	                                <div class="custom-control custom-checkbox">
	                                    <input type="checkbox" name="privateFundingMoney" class="custom-control-input" id="private-funding-check">
	                                    <label class="custom-control-label" for="private-funding-check">펀딩금액 비공개</label>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </article>
			<hr>
			
			<div class="row">
	                <div class="col-3">
	                    <div class="h4" style="color:black;">펀딩 금액 : </div>
	                </div>
	                <div class="col-9">
                    	<div class="row">
                        	<div id="totalAmount" class="h4">
                        </div>
                    </div>
                </div>
            </div>
			
	
	        <article class="p-5 d-flex justify-content-end">
	            <div class="d-inline-flex p-2 bd-highlight">
            		<input type="hidden" name="projectNo" value="${projectNoOfRewardList }">
                	<a href="javaScript: return(0);" onclick="document.getElementById('paymentReservationForm').submit();" class="btn btn-primary"> 다음 단계로 <i class="fas fa-angle-right"></i></a>
	            </div>
	        </article>
        </form>
    </section>	


    <jsp:include page="./include/i-footer.jsp"></jsp:include>
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>













