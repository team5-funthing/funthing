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
			
			
			<div class="w-50">
				<div class="paymentDate">
					${payment.paymentReserveDate }
				</div>
				
	            <div class="card mb-3" style="max-width: 1140px;">
				  	<div class="row no-gutters">
				    <div class="col-md-4">
					    <div class="project">
 							<div class="thumbnail-wrap">
	                            <div class="thumbnail">
	                                <div class="centered">
										<form id="payment${cnt.count }" action="paymentReservationDetail.udo" method="POST">
										    <input type="hidden" name="orderNo" value="${payment.orderNo}">
                                       		<a href="#" onclick="document.getElementById('payment${cnt.count }').submit()">
                                       			<img src="${payment.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                       		</a>
                                        </form>
	                                </div>
	                            </div>
	                        </div>
					    </div>
				    </div>
				    <div class="col-md-8">
				    		
				     	<div class="card-body">
				     		<c:choose>
				     			<c:when test="${payment.paymentStatus eq '결제취소' }">
				     				<a href="javaScript: return(0);" class="badge badge-primary mb-2">결제취소</a>
				     			</c:when>
				     			<c:otherwise>
				     				<a href="javaScript: return(0);" class="badge badge-primary mb-2">결제완료</a>
				     			</c:otherwise>
				     		</c:choose>
					        <h5 class="card-title">${paymentItems }</h5>
					        <p class="card-text">주문수량 ${quentity }개</p>
					        <p class="card-text">${payment.fundingMoney }원을 후원하였습니다.</p>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</c:forEach>
	</div>		
		
		
<!-- 				<c:forEach var="rewardSelection" items="${paymentReserve.rewardSelectionList }" varStatus="cnt">
						<c:set var="totalAmount" value="${ totalAmount + rewardSelection.paymentAmount }"/>
						<div class="row">
							<div class="col-8">
								<h5 class="card-title">${rewardSelection.reward.rewardName }</h5>
								<p class="card-text">${rewardSelection.reward.rewardContent }</p>
								<p class="card-text">옵션: <br>
								
								<c:forEach var="option" items="${rewardSelection.rewardOptionValueList}">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${option }<br>
								</c:forEach>
								
								</p>
							</div>
						</div>
						<div class="d-flex justify-content-end">
							<p class="card-text mr-3" style="font-weight: bold;">수량:${rewardSelection.orderAmount }개</p>
							<p class="card-text" style="font-weight: bold;">${rewardSelection.paymentAmount }원</p>
						</div>
						<hr>
					</c:forEach> -->
					
	<!-- -------------------- -->




    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>