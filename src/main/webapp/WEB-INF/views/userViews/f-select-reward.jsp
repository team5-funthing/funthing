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

	<section id="select-reward" class="container">
        <article class="back-story">
            <i class="fas fa-chevron-left"></i>
            <a href="javaScript: history.go(-1);">스토리로 돌아가기</a>
        </article>
        <article class="select-order">
            <div class="row d-flex justify-content-center ml-2 mr-2 mt-4 pb-4">
                <div class="order-circle d-flex d-flex justify-content-center " style="background: #009DFF; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-3" style="color: whitesmoke;" >
                        	리워드<br>
                        	선택
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                </div>
                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke; border-style:dotted; border-color: whitesmoke; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-0" style="color: #000000;" >
                        	결제 예약
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                    <i class="fas fa-ellipsis-h" style="color: whitesmoke;"></i>
                </div>
                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke;">
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
       			
       			<form id="reward${cnt.count }" action="addSelectReword.udo" method="POST">
       			
		            <div class="card wd-100 mb-2">
		            
		            	<input type="hidden" name="rewardNo" value="${reward.rewardNo }">
						<input type="hidden" name="email" value="${sessionScope.memberSession.email }">
						<input type="hidden" name="paymentAmount" value="${reward.rewardPrice}">
						<input type="hidden" name="shippingFee" value="${reward.shippingFee }"> 
		
		                <!-- 리워드 선택 박스 1 [ 리워드 품목 등록 수 만큼 반복 ]-->
		                <!-- !!! 선택 체크박스 클릭시 수량 및 옵션항목이 나오는 부분에 대한 문제점 처리 해야한다 -->
		                <div class="row no-gutters">
		                    <div class="card-body">
		                        <aside>
		                            <h6 class="card-title">${reward.rewardPrice }원 펀딩합니다.</h6>
		                            <p class="card-text">${reward.rewardName }</p>
		
		                            <p class="card-text">${reward.rewardContent }</p>
		
		                            <p class="card-text to-add-place">배송비 ${reward.shippingFee }원 | 예상 배송일 추가안내</p>
		                            
		                            <div class="row">
		                                <div class="col-2 to-remove-tag mt-2">
		                                    <p class="card-text m-auto">수량 [${reward.rewardAmount }개 남음]</p>
		                                    <div class="row align-items-md-center mb-4">
		                                        <a href="javaScript: return(0);"> <i class="fas fa-minus ml-3"></i></a>
		                                        <input class="form-control ml-2 mr-2" style="width:50px;" type="text" name="orderAmount" placeholder="">
		                                        <a href="javaScript: return(0);"> <i class="fas fa-plus"></i></a>
		                                    </div>
		                                </div>
		                                
		                                <div class="col-2 to-remove-tag mt-2">
		                                    <p class="card-text m-auto">옵션</p>
		                                    <select class="custom-select" style="width: 300px;">
		                                        <option selected>선택하세요</option>
		                                        <c:forEach var="option" items="${reward.rewardOptionList }" varStatus="opCnt">
		                                        	<option name="rewardOptionValue" value="${option.rewardOptionValue }">${option.rewardOptionKey } : ${option.rewardOptionValue }</option>
		                                        </c:forEach>
		                                    </select>
		                                </div>
		                            </div>
		                            <div class="row justify-content-end">
							            <div class="d-inline-flex p-2 bd-highlight">
							                <a href="javaScript: return(0);" onclick="document.ElementById('reward${cnt.count }')" class="btn btn-primary"> 추가하기 </a>
							            </div>
		                            </div>
		                        </aside>
		                    </div>
		                </div>
		                
		            </div>
	           	</form>
            </c:forEach>
        </article> 
        
        
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
		
		<h3> 총금액 : </h3>

        <article class="p-5 d-flex justify-content-end">
            <div class="d-inline-flex p-2 bd-highlight">
                <a href="javaScript: return(0);" class="btn btn-primary"> 다음 단계로 <i class="fas fa-angle-right"></i> </a>
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