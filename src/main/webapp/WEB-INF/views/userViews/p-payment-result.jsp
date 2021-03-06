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
	
	<section id="select-reward" class="container w-50">
		<form id="goProjectPage" action="projectDetailsFromProjectBoard.udo" method="GET">
		    <article class="back-story">
		            <i class="fas fa-chevron-left"></i>
		            <input type="hidden" name="currentProjectNo" value="${projectNo }">
		            <a href="javaScript: return(0);" onclick="document.getElementById('goProjectPage').submit()" >프로젝트로 돌아가기</a>
	        </article>
	    </form>    
		<article class="select-order">
            <div class="row d-flex justify-content-center ml-2 mr-2 mt-4 pb-4">
                <div class="order-circle d-flex d-flex justify-content-center " style="background: white; border-style:dotted; border-color: whitesmoke; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-0" style="color: #000000;" >
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
                <div class="order-circle d-flex d-flex justify-content-center " style="background: white; border-style:dotted; border-color: whitesmoke; border-width: 3px;">
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
                <div class="order-circle d-flex d-flex justify-content-center " style="background: #009DFF;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-3" style="color: whitesmoke;" >
                      	 결제 확인
                    </div>
                </div>
            </div>
        </article>

        <hr>

        <article class="pb-4">

            <div class="card mb-3" style="border: 0px">
                <div class="card-body">
                
					<c:set var="totalAmount" value="${paymentReserve.additionalFundingMoney }"/>
					<c:set var="shippingFee" value="0"/>
					
					<c:forEach var="rewardSelection" items="${paymentReserve.rewardSelectionList }" varStatus="cnt">
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
					</c:forEach>
                    <hr>
                    

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 추가 펀딩금액</div>
                        <div class="p-2 bd-highlight"> ${paymentReserve.additionalFundingMoney }원</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 총 펀딩금액 [리워드 + 추가 펀딩금액]</div>
                        <div class="p-2 bd-highlight"> ${totalAmount }원</div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 배송비</div>
                        <div class="p-2 bd-highlight">  ${paymentReserve.shippingFee }원</div>
                    </div>
                    <hr>

                    <div class="d-flex justify-content-start">
                        <div class="p-2 bd-highlight h4"> 배송 정보</div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 주문번호</div>
                        <div class="p-2 bd-highlight"> ${paymentReserve.orderNo }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 주문자</div>
                        <div class="p-2 bd-highlight"> ${deliveryAddress.name }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 배송지</div>
                        <div class="p-2 bd-highlight"> ${deliveryAddress.roadAddress }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 상세주소</div>
                        <div class="p-2 bd-highlight"> ${deliveryAddress.detailedAddress }</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 요청 사항</div>
                        <div class="p-2 bd-highlight"> ${deliveryAddress.shippingNote }</div>
                    </div>
                    <hr>
                    <div class="d-flex justify-content-end">
                        <div class="p-2 bd-highlight h3"> 총 결제 금액</div>
                        <div class="p-2 bd-highlight h3"> ${totalAmount + paymentReserve.shippingFee } 원</div>
                    </div>
                </div>
            </div>
        </article>
        <form id="goProjectDetailPage" action="projectDetailsFromProjectBoard.udo" method="GET">
        	<input type="hidden" name="currentProjectNo" value="${projectNo }">
	        <article class="p-2 d-flex justify-content-center">
	            <div class="d-inline-flex p-2 bd-highlight">
	                <a href="javaScript: return(0);"  onclick="document.getElementById('goProjectDetailPage').submit()" class="btn btn-primary">확인 [스토리로 돌아가기]</a>
	            </div>
	        </article>
	    </form>  

    </section>
	
	<!-- -------------------- -->




    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>