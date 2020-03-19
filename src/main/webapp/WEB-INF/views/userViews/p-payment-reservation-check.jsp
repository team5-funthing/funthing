<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!doctype html>

<html class="no-js">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
</head>

<body>
  	
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>

	<!-- ------------------ -->
	
	<hr>
	
	<div class="container">
     	
     	<div class="row mt-5 mb-1">
		   <div class="col-3">
		   </div>
		   <div class="col-6 d-flex justify-content-center">
				<div id="detail-mypage-profile-img" style="background: #BDBDBD;">
					<img class="profile" src="${memberSession.myImage}">
		        </div>
		   </div>
		   <div class="col-3">
		   </div>
        </div>
        
        <div class="row mb-5">
		   <div class="col-3">
		   </div>
		   <div class="col-6 d-flex justify-content-center">
				<div style=" color: gray; font-weight: 600" >${memberSession.name }님의 후원 현황</div>
		   </div>
		   <div class="col-3">
		   </div>
        </div>
        
   	<div class="wrap p-5" style="background-color: whitesmoke;">
         <div class="row">
            <div class="col-1">
            </div>
            <div class="col-10">

					<c:forEach var="payment" items="${paymentReserveList }" varStatus="cnt" >
            	
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
	            	
	            	
		            	<div class="card mb-3 js-slidein block" style="border-style: none;">
					    	<div class="card-header" style="background: white; color: gray; font-weight: 500;">
					        	<fmt:formatDate var="paymentReserveDate" value="${payment.paymentReserveDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					        	${paymentReserveDate }
					  		</div>
					  		<div class="row no-gutters">
							  	<div class="col-md-2 mt-3">
							    	<div class="project">
		 								<div class="thumbnail-wrap">
				                            <div class="thumbnail" style="border-radius: 10px;">
				                                <div class="centered">
													<form id="payment${cnt.count }" action="paymentReservationDetail.udo" method="POST">
													    <input type="hidden" name="orderNo" value="${payment.orderNo}">
			                                       		<a href="#" onclick="document.getElementById('payment${cnt.count }').submit()">
			                                       			<img src="${payment.project.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
			                                       		</a>
			                                        </form>
				                                </div>
				                            </div>
			                            </div>
								    </div>
							    </div>
							   	<div class="col-md-9">
							  		<div class="card-body ml-3">
							  			<c:choose>
							  				<c:when test="${payment.project.funding eq 'y'.charAt(0) }">
							  					<button type="button" class="btn btn-sm btn-outline-primary mb-1">펀딩 진행중</button>
							  					<c:choose>
									  				<c:when test="${payment.paymentStatus eq '결제예약'}">
									  					<button type="button" class="btn btn-sm btn-outline-warning mb-1">후원중</button>
									  				</c:when>
									  				<c:when test="${payment.paymentStatus eq '결제취소'}">
									  					<button type="button" class="btn btn-sm btn-outline-secondary mb-1">후원금 취소</button>
									  				</c:when>
									  				<c:when test="${payment.paymentStatus eq '결제확정'}">
									  					<button type="button" class="btn btn-sm btn-outline-success mb-1">후원 확정</button>
									  				</c:when>
								  				</c:choose>
							  					
							  				</c:when>
							  				<c:when test="${payment.project.funding eq 'e'.charAt(0) }">
							  					<button type="button" class="btn btn-sm btn-outline-secondary  mb-1">펀딩 마감</button>
							  					<c:choose>
									  				<c:when test="${payment.paymentStatus eq '결제예약'}">
									  					<button type="button" class="btn btn-sm btn-outline-warning mb-1">후원중</button>
									  				</c:when>
									  				<c:when test="${payment.paymentStatus eq '결제취소'}">
									  					<button type="button" class="btn btn-sm btn-outline-secondary mb-1">후원금 취소</button>
									  				</c:when>
									  				<c:when test="${payment.paymentStatus eq '결제확정'}">
									  					<button type="button" class="btn btn-sm btn-outline-success mb-1">후원 확정</button>
									  				</c:when>
								  				</c:choose>
							  					
							  					
							  				</c:when>
							  			</c:choose>
							  			
							  			<c:choose>
							  				<c:when test="${payment.project.fundingMoney >= payment.project.goalMoney }">
							  					<button type="button" class="btn btn-sm btn-outline-success">성공</button>
							  				</c:when>
							  			</c:choose>
							  			
							  			<fmt:formatNumber type="number" var="fundingMoney"
											maxFractionDigits="3" value="${payment.fundingMoney}" />
							  			
							  			<div class="card-text" style="color: black; font-weight: 500;">${payment.project.projectTitle }</div>
								    	<p class="card-text" style="color: black;">${paymentItems }</p>
								        <p class="card-text"><strong>${fundingMoney }</strong>원을 후원하였습니다.</p>
								    </div>
							    </div>
							    <div class="col-md-1 d-flex align-items-center">
								    <a href="#" onclick="document.getElementById('payment${cnt.count }').submit()">
									    	<i class="fas fa-chevron-right fa-2x" style="color: gray; opacity: 0.6;"></i>
								    </a>
							    </div>
						    </div>
					    </div>            	
            		</c:forEach>
	            </div>
	            <div class="col-1">
	            </div>
	         </div>
	      </div>
	   </div>
		
		

    <jsp:include page="./include/i-footer.jsp"></jsp:include>
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>