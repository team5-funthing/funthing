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
				        				<p>${paymentReserveDate }</p>
									</td>
									<td scope="col" class="align-self-center">${payment.paymentOption }</td>
									<td scope="col" class="align-self-center">
										<c:if test="${payment.deliveryAddressNo ne -1 }">
											입력됨
										</c:if>
										<p><a class="address" href="javaScript: return(0);">배송주소 보기</a></p>
									</td>
									<td scope="col" class="align-self-center">
										<button type="button" class="btn btn-light">미발송</button>
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
              		 현재 작성 중인 프로젝트가 있습니다.
                    <p>작성 중인 프로젝트를 수정하거나 새로운 프로젝트를 시작할 수 있습니다.</p>
					<div class="table-responsive-md sponsorship">
						<table class="table table-hover">
							<thead>
								<tr>
									<th span scope="col">배송지</th>
									<th scope="col">이름 </th>
								</tr>
							</thead>
							<tbody>
									
							</tbody>
						</table>            
		            </div>

                    <div class="d-flex justify-content-around">
                        <a href="#" class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss">확인</a>
                    </div>
               </div>
           </div>
       </form>
    
     <script>
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
	     });   
   </script>
      
   </c:if>  

   <jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>