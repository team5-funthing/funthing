<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>

<html class="no-js" lang="zxx">


<head>

<jsp:include page="./include/i-head-setting.jsp"/>

</head>

<body>

   <jsp:include page="./include/i-popupover-mypage.jsp"/>
   <jsp:include page="./include/i-header.jsp"/>

   <div class="wrap p-5" style="background-color: whitesmoke;">
      <div class="container">
         <div class="row">
            <div class="col-1">
            </div>
            <div class="col-10">
            
            	<div class="card mb-3 js-slidein block" style=" border-style: none;">
			    	<div class="card-header" style="background: white; color: gray; font-weight: 500;">
			        	펀딩 마감일  ${project.endDate }
			  		</div>
			  		<div class="row no-gutters">
					  	<div class="col-md-2 mt-2">
					    	<div class="project">
 								<div class="thumbnail-wrap">
		                            <div class="thumbnail" style="border-radius: 10px;">
		                                <div class="centered">
                                      			<img src="${project.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                </div>
		                            </div>
	                            </div>
						    </div>
						    <div class="percentage mb-3">
								<fmt:formatNumber type="number" var="progressPercent"
									value="${(project.fundingMoney / project.goalMoney)*100}" pattern=".00" />
								
								<div class="progress">
									<div class="progress-bar color-7" role="progressbar"
										style="width: ${progressPercent }%" aria-valuenow="30"
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						    
					    </div>
					   	<div class="col-md-10">
					  		<div class="card-body ml-3">
					  			<c:choose>
					  				<c:when test="${project.funding eq 'y'.charAt(0) }">
					  					<button type="button" class="btn btn-sm btn-outline-primary mb-1">펀딩 진행중</button>
					  				</c:when>
					  				<c:when test="${project.funding eq 'e'.charAt(0) }">
					  					<button type="button" class="btn btn-sm btn-outline-secondary">펀딩 마감</button>
					  				
						  				<c:if test="${project.fundingMoney < project.goalMoney }">
						  					<button type="button" class="btn btn-sm btn-outline-danger">실패</button>
						  				</c:if>
					  				</c:when>
					  			</c:choose>
					  			
					  			<c:choose>
					  				<c:when test="${project.fundingMoney >= project.goalMoney }">
					  					<button type="button" class="btn btn-sm btn-outline-success">성공</button>
					  				</c:when>
					  			</c:choose>
					  			
					  			<div class="card-text" style="color: black; font-weight: 500;">${project.projectTitle }</div>
						    	<p class="card-text" style="color: black;">${project.projectSubTitle }</p>
						    	<p class="card-text" style="color: black;">${project.projectSummary }</p>
						        <div class="card-text" style="color: black; font-weight: 500;">
						        	<fmt:formatNumber type="number" var="progressGoalMoney"
										maxFractionDigits="3" value="${project.goalMoney}" />
									<fmt:formatNumber type="number" var="progressFundingMoney"
										maxFractionDigits="3" value="${project.fundingMoney}" />
									${progressFundingMoney}원 ${progressPercent }% 달성
									<p>[${progressGoalMoney }원]</p>
						        </div>
						    </div>
					    </div>
				    </div>
			   	</div>  
	            <div class="table-responsive-md sponsorship">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">후원자</th>
								<th scope="col">후원금액</th>
								<th scope="col">결제상태</th>
								<th scope="col">결제방법</th>
								<th scope="col">배송주소</th>
								<th scope="col">배송처리</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="payment" items="${paymentReserveList }" varStatus="cnt">
							
								<c:set var="paymentItems" value="" />
								<c:set var="quentity" value="0"/>
								<c:forEach var="rewardSelection" items="${payment.rewardSelectionList}" varStatus="rsCnt">
									<c:if test="${rsCnt.count eq 1 }">
										<c:set var="paymentItems" value="${rewardSelection.reward.rewardName }"/>
									</c:if>
									<c:if test="${rsCnt.count > 1 &&  rsCnt.last }">
										<c:set var="paymentItems" value="${paymentItems} 외  ${rsCnt.count -1 }개"/>
									</c:if>
									<c:set var="quentity" value="${ quentity + rewardSelection.orderAmount}"/>
								</c:forEach>
							
								<tr class="js-slidein block">
									<th scope="row" class="align-self-center">${cnt.count }</th>
									<td scope="col" class="align-self-center">
										<c:choose>
											<c:when test="${payment.privateName eq 'off' }">
												<img id="suppoterProfile" class="profile mr-2" src="${payment.member.myImage}">
												${payment.member.name }
											</c:when>
											<c:otherwise>
												<button type="button" onclick="javaScript: return(0);" class="btn btn-sm btn-outline-secondary">비공개</button>
											</c:otherwise>
										</c:choose>
									</td>
									<td scope="col" class="align-self-center">
										<c:choose>
											<c:when test="${payment.privateFundingMoney eq 'off' }">
											<fmt:formatNumber type="number" var="fundingMoney"
												maxFractionDigits="3" value="${payment.fundingMoney}" />
											
												${fundingMoney }원
											</c:when>
											<c:otherwise>
												<a type="button" class="btn btn-sm btn-outline-secondary">비공개</a>
											</c:otherwise>
										</c:choose>
									</td>
									<td scope="col" class="align-self-center">
										${payment.paymentStatus }
								    	<fmt:formatDate var="paymentReserveDate" value="${payment.paymentReserveDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
								    	<fmt:formatDate var="paymentCanceledDate" value="${payment.canceledDate }" pattern="yyyy-MM-dd HH:mm:ss"/>    	
				        				<p>${paymentReserveDate }
				        					<c:if test="${payment.canceledDate ne null }">
				        					(취소날짜 : ${paymentCanceledDate})
				        				</c:if>
				        				</p>
									</td>
									<td scope="col" class="align-self-center">${payment.paymentOption }</td>
									<td scope="col" class="align-self-center">
										<c:if test="${payment.deliveryAddressNo ne -1 }">
											입력됨
										</c:if>
										
										<p>
											<input type="hidden" name="deliveryAddressNo" value="${payment.deliveryAddressNo}">
											<a class="address" href="#" >배송주소 보기</a>
										</p>
									</td>
									<td scope="col" class="align-self-center">
										<c:if test="${payment.shippingFee ne 0 || payment.canceledDate eq null }">
											<c:choose>
												<c:when test="${payment.shipmentComplete eq 'y'.charAt(0) }">
													<a href="javaScript: return(0);" class="btn-sm btn-bd-purple d-none d-lg-inline-block m-1">발송완료</a>
												</c:when>
												<c:otherwise>
													<form id="updateShipmentComplete${cnt.count }" action="updateShipmentComplete.udo" method="POST">
														<input type="hidden" name="projectNo" value="${payment.projectNo }">
														<input type="hidden" name="orderNo" value="${payment.orderNo }">
														<a href="#" class="deliveryBtn btn-sm btn-bd-purple d-none d-lg-inline-block m-1">미발송</a>
													</form>
												</c:otherwise>
											</c:choose>
										</c:if>

									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>            
	            </div>
            </div>
            <div class="col-1">
            </div>
         </div>
      </div>
   </div>

   <c:if test="${payment.deliveryAddressNo ne -1 }">
   
       <!-- 배송지 또는 리워드 옵션보기 선택 시 나오는 팝업 -->
       <form action ="#" method="POST" id="showDeliveryAddress" class="white-popup-block mfp-hide" >
           <div class="popup_box">
               <div class="popup_inner">
					<div class="table-responsive-md sponsorship">
						<table class="table table-hover">
							<thead>
								<tr>
									<th colspan="2" scope="col" class="text-center">배송정보</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="col">배송지명</th>
									<td scope="col" id="deliveryAddressName"></td>
								</tr>
								<tr>
									<th  scope="col">주문자</th>
									<td scope="col" id="name"></td>
								</tr>
								<tr>
									<th  scope="col">연락처</th>
									<td scope="col" id="phone"></td>
								</tr>
								<tr>
									<th  scope="col">우편번호</th>
									<td scope="col" id="zipcode"></td>
								</tr>
								<tr>
									<th  scope="col">도로명 주소</th>
									<td scope="col" id="roadAddress"></td>
								</tr>					
								<tr>
									<th  scope="col">상세 주소</th>
									<td scope="col" id="detailedAddress"></td>
								</tr>			
								<tr>
									<th  scope="col">요청 사항</th>
									<td scope="col" id="shippingNote"></td>
								</tr>										
							</tbody>
						</table>            
		            </div>

                    <div class="d-flex justify-content-around">
                        <a href="#" class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss">확인</a>
                    </div>
               </div>
           </div>
       </form>
    
    	<form action ="#" method="POST" id="updateShipmentComplete" class="white-popup-block mfp-hide" >
           <div class="popup_box">
               <div class="popup_inner">
              		<p>정말 리워드 발송을 하셨습니까?</p>
                    <div class="d-flex justify-content-center mt-3">
                        <a href="#" class="deliveryOKBtn btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">확인</a>
                        <a href="javaScript:return(0);" class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">취소</a>
                    </div>
               </div>
           </div>
       </form>
    
    
	   <script>
	   
	   
	   		 $(document).on("click", ".deliveryBtn", function(){
	   			 
	   			 var okBtn = $(this);
	   			 
		   			$.magnificPopup.open({
			            items: {
			                src: '#updateShipmentComplete' 
			            },
			            type: 'inline',
			            preloader: false,
			            modal: true
			            
			        });
			        
			        $(document).on('click', '.popup-modal-dismiss', function (e) {
			           e.preventDefault();
			           $.magnificPopup.close();
			        });
			        
			  	    $(document).on("click", ".deliveryOKBtn", function(){
 			  	    	okBtn.closest("form").submit();
			  	    	alert(okBtn);
				  	});
	   			 
	   		 });
	   
		     
		     $(document).on("click", ".address", function () {
		    	 
			        $.magnificPopup.open({
			            items: {
			                src: '#showDeliveryAddress' 
			            },
			            type: 'inline',
			            preloader: false,
			            modal: true
			            
			        });
			        
			        $(document).on('click', '.popup-modal-dismiss', function (e) {
			           e.preventDefault();
			           $.magnificPopup.close();
			        });
		        
					var jsonData = $(this).siblings("input").serializeObject();
					console.log(jsonData);
					
					$.ajax({
                        url: "selectDeliveryAddressCheck.udo",
                        type: "POST",
                        data: JSON.stringify(jsonData),
                        contentType: "application/json;",
                        success: function(data) {
                        	
                             var selectedDeliveryAddress = JSON.parse(data);
                             console.log(selectedDeliveryAddress);
                             	$("#deliveryAddressName").text(selectedDeliveryAddress.deliveryAddressName);
                             	$("#name").text(selectedDeliveryAddress.name);
                             	$("#phone").text(selectedDeliveryAddress.phone);
                             	$("#zipcode").text(selectedDeliveryAddress.zipcode);
                             	$("#roadAddress").text(selectedDeliveryAddress.roadAddress);
                             	$("#detailedAddress").text(selectedDeliveryAddress.detailedAddress);
                             	$("#shippingNote").text(selectedDeliveryAddress.shippingNote);
							
                        },
                        error: function(errorThrown) {
                            console.log(errorThrown.statusText);
                        }
                    });   
		     });   
	   </script>
      

      
   </c:if>  

   <jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>