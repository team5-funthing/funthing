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
	
    <section id="select-reward" class="container w-50">
		    <article class="back-story">
		            <i class="fas fa-chevron-left" style="color: gray;"></i>
		            <a href="javaScript: return(0);" style="color: gray; font-weight: 500;" 
		            onclick="document.getElementById('paymentReservationCheckListForm').submit()">결제내역으로 돌아가기</a>
	        </article>
        <hr>

        <article class="pb-4">

            <div class="card mb-3" style="border: 0px">
                <div class="card-body">
                
					<c:set var="totalAmount" value="${paymentReserve.additionalFundingMoney }"  />
					<c:set var="shippingFee" value="0"/>
					
					<c:forEach var="rewardSelection" items="${paymentReserve.rewardSelectionList }" varStatus="cnt">
						<c:set var="totalAmount" value="${ totalAmount + rewardSelection.paymentAmount }"/>
						<div class="row">
							<div class="col-8">
								<h5 class="card-title" style="color: black; font-weight: 500;">${rewardSelection.reward.rewardName }</h5>
								<p class="card-text">${rewardSelection.reward.rewardContent }</p>
								<p class="card-text">옵션: <br>
								
								<c:forEach var="option" items="${rewardSelection.rewardOptionValueList}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${option }<br>
								</c:forEach>
								
								</p>
							</div>
						</div>                    

                        <fmt:formatNumber type="number" var="paymentAmount" maxFractionDigits="3" value="${rewardSelection.paymentAmount }" />
						<div class="d-flex justify-content-end">
							<p class="card-text mr-3" style="color:#464059; font-weight: 500;">수량:${rewardSelection.orderAmount }개</p>
							<p class="card-text" style="color:#464059; font-weight: 500;">${paymentAmount }원</p>
						</div>
						<hr>
					</c:forEach>
                    <hr>
                    
	
                    <div class="d-flex justify-content-between">
                    
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> 추가 펀딩금액</div>
                        <fmt:formatNumber type="number" var="additionalFundingMoney" maxFractionDigits="3" value="${paymentReserve.additionalFundingMoney }" />     
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> ${additionalFundingMoney }원</div>
                    </div>
                    <div class="d-flex justify-content-between">
                    	<fmt:formatNumber type="number" var="totalAmountDigited" maxFractionDigits="3" value="${totalAmount }" />
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> 총 펀딩금액 [리워드 + 추가 펀딩금액]</div>
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> ${totalAmountDigited }원</div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> 배송비</div>
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;">  ${paymentReserve.shippingFee }원</div>
                    </div>
                    <hr>

                    <div class="d-flex justify-content-start">
                        <div class="p-2 bd-highlight h4" style="color: black; font-weight: 500;"> 배송 정보</div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight" style="color: gray; font-weight: 500;"> 주문번호</div>
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> ${paymentReserve.orderNo }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight" style="color: gray; font-weight: 500;"> 주문자</div>
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> ${memberSession.name }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight" style="color: gray; font-weight: 500;"> 배송지</div>
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> ${deliveryAddress.roadAddress }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight" style="color: gray; font-weight: 500;"> 요청 사항</div>
                        <div class="p-2 bd-highlight" style="color: black; font-weight: 500;"> ${deliveryAddress.shippingNote }</div>
                    </div>
                    <hr>
                    <fmt:formatNumber type="number" var="fundingMoney"
                                    maxFractionDigits="3" value="${totalAmount + paymentReserve.shippingFee }" />
                    <div class="d-flex justify-content-end">
                        <div class="p-2 bd-highlight h3" style="color: gray; font-weight: 500;"> 총 결제 금액</div>
                        <div class="p-2 bd-highlight h3" style="color: black; font-weight: 500;"> ${fundingMoney } 원</div>
                    </div>
                </div>
            </div>
        </article>
        <form id="paymentCancelForm" action="paymentCancel.udo" method="POST">
        	<input type="hidden" name="orderNo" value="${paymentReserve.orderNo }">
	        <article class="p-2 d-flex justify-content-center">
	            <div class="d-inline-flex p-2 bd-highlight">
	                <a href="javaScript: return(0);" onclick="document.getElementById('paymentReservationCheckListForm').submit()" 
	                	class="deliveryOKBtn btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">뒤로가기</a>
	            </div>
	            <div class="d-inline-flex p-2 bd-highlight">
					<c:choose>
		  				<c:when test="${paymentReserve.paymentStatus eq '결제예약'}">
							<a href="javaScript:return(0);" onclick="document.getElementById('paymentCancelForm').submit()" 
			                	class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">결제 취소하기</a>
		  				</c:when>
	  				</c:choose>	            
	            </div>
	        </article>
	    </form>  

    </section>


    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>