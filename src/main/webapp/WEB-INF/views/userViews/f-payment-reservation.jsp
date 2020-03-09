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
    <!--  <jsp:include page="./include/i-header.jsp"/>

	<!-- ------------------ -->

	<section class="container w-50 pb-5">
		
		<article class="back-story">
			<i class="fas fa-chevron-left"></i> <a href="javaScript: history.go(-1);">스토리로 돌아가기</a>
		</article>
		
		<form id="paymentReserveForm" action="paymentReserve.udo" method="POST">
			<c:set var="totalAmount" value="${paymentReserve.additionalFundingMoney}"/>
			
			<input type="hidden" name="additionalFundingMoney" value="${paymentReserve.additionalFundingMoney }">
			<input type="hidden" name="shippingFee" value="${paymentReserve.shippingFee }">
			<input type="hidden" name="privateName" value="${paymentReserve.privateName }">
			<input type="hidden" name="privateFundingMoney" value="${paymentReserve.privateFundingMoney }">
			
			
			<article class="select-order">
	            <div class="row d-flex justify-content-center ml-2 mr-2 mt-4 pb-4">
	                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke; border-style:dotted; border-color: whitesmoke; border-width: 3px;">
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
	                <div class="order-circle d-flex d-flex justify-content-center " style="background: #009DFF;">
	                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-3" style="color: whitesmoke;" >
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
	
			<hr class="w-75 pb-5">
	
			<article class="pb-4">
				
				<div class="card mb-3" style="border: 0px">
					<div class="card-body">
						<c:forEach var="rewardSelection" items="${rewardSelectionJoinList}" varStatus="cnt">
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
	
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">추가 펀딩금액</div>
							<div class="p-2 bd-highlight">${paymentReserve.additionalFundingMoney }원</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">이름 비공개</div>
							<div class="p-2 bd-highlight">
								<c:choose>
									<c:when test="${paymentReserve.privateName eq null }">
										비공개
									</c:when>
									<c:otherwise>
										공개
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">펀딩금액 비공개</div>
							<div class="p-2 bd-highlight">
								<c:choose>
									<c:when test="${paymentReserve.privateFundingMoney eq null }">
										비공개
									</c:when>
									<c:otherwise>
										공개
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<hr>
	
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">배송비</div>
							<div class="p-2 bd-highlight"> ${paymentReserve.shippingFee }원</div>
						</div>
						<hr>
						
					<!-- 
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">쿠폰 사용</div>
							<div class="p-2 bd-highlight">사용가능한 쿠폰이 없습니다.</div>
						</div>
	
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">포인트 사용</div>
							<div class="p-2 bd-highlight">[포인트]</div>
						</div>  
					-->
					
					</div>
				</div>
	
	
				<div class="card" style="border: 0px; background-color: whitesmoke;">
					<div class="card-body">
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight ">
								<p class="card-text" style="font-weight: bold;">펀딩금액</p>
							</div>
							<div class="p-2 bd-highlight">
								<p class="card-text " >${totalAmount }원</p>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<p class="card-text" style="font-weight: bold;">쿠폰 차감금액</p>
							</div>
							<div class="p-2 bd-highlight">
								<p class="card-text">-</p>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<p class="card-text" style="font-weight: bold;">포인트 차감금액</p>
							</div>
							<div class="p-2 bd-highlight">
								<p class="card-text">추가 후원금</p>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<p class="card-text" style="font-weight: bold;">배송비</p>
							</div>
							<div class="p-2 bd-highlight">
								<p class="card-text">${paymentReserve.shippingFee }원</p>
							</div>
						</div>
						<div class="d-flex justify-content-between">
							<div class="p-2 bd-highlight">
								<p class="card-text h6" style="font-weight: bold;">최종결제 금액</p>
							</div>
							<div class="p-2 bd-highlight">
								<p class="card-text h5">${totalAmount + paymentReserve.shippingFee }원</p>
							</div>
						</div>
					</div>
				</div>
			</article>
	
			<article>
				<div class="row">
					<div class="col-6">
						<h3>펀딩 서포터</h3>
						<div class="card"
							style="border: 0px; background-color: whitesmoke;">
	
							<div class="card-body">
								<div class="form-group">
									<label for="formGroupExampleInput">이름</label> 
									<input type="text" class="form-control" id="formGroupExampleInput" 
										name="name" value="${memberSession.name }"
										placeholder="">
								</div>
								<div class="form-group">
									<label for="formGroupExampleInput">이메일</label> 
									<input type="text" class="form-control" id="formGroupExampleInput" 
										name="email" value="${memberSession.email }"
										placeholder="">
								</div>
								<div class="form-group">
									<label for="formGroupExampleInput">연락처</label> 
									<input type="text" class="form-control" id="formGroupExampleInput" 
										name="phone" value="${memberSession.phone }"
										placeholder="">
								</div>
								<hr>
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input"
										id="customCheck1"> <label class="custom-control-label"
										for="customCheck1">
										<p class="card-text" style="font-weight: bolder;">(필수) 펀딩
											진행에 대한 새소식 및 결제 관련 안내를 받습니다.</p>
									</label>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-6">
						<h3>리워드 배송지</h3>
						<hr class="" style="color: whitesmoke;">
						<div class="card" style="border: 0px;">
						
							<div class="card-body">
								<div class="custom-control custom-radio">
									<input type="radio" name="radioDisabled"
										id="customRadioDisabled2" class="custom-control-input" checked
										disabled> <label class="custom-control-label"
										for="customRadioDisabled2">새로입력
									</label>
								</div>
							</div>
	
								<div class="form-group">
									<label for="formGroupExampleInput">이름</label> 
									<input type="text" class="form-control" id="formGroupExampleInput" 
										name="name" value="${memberSession.name }"
										placeholder="">
								</div>
								
								<div class="form-group">
									<label for="formGroupExampleInput">연락처</label> 
									<input type="text" class="form-control" id="formGroupExampleInput" 
										name="phone" value="${memberSession.phone }"
										placeholder="">
								</div>
								
								<div class="form-group">
									<label for="address">주소</label>
									<script
										src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js">
									</script>
	                                <div class="form-row">
	                                    <a class="btn btn-sm btn-find-zipcode d-none d-lg-inline-block ml-1 mb-2"
	                                        href="javaScript:return(0);" onclick="findPostcode()">우편번호 검색</a>
	                                </div>
		                            <div class="form-group">
										<input type="text" class="form-control" id="postcode" 
											name="zipcode" placeholder="우편번호">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="roadAddress" 
											name="roadAddress" placeholder="도로명주소">
									</div>
										<span id="guide" style="color: #999; display: none"></span> 
									<div class="form-group">
										<input type="text" class="form-control" id="detailAddress" 
											name="detailedAddress" placeholder="상세주소">
									</div>
	
								</div>
								<hr>
								<div class="form-group">
									<label for="shippingNote">배송요청사항</label> 
									<input type="text" class="form-control" id="shippingNote" name="shippingNote" placeholder="ex) 부재시 경비실에 보관해주세요."> 
									<small class="form-text text-muted">해당 요청사항은 배송에 관련된 내용만 적어주세요.</small>
								</div>
						</div>
					</div>
				</div>
			</article>
	
			<hr>
	
			<article class="pb-4">
				<div class="row">
					<div class="col">
	
						<div class="h4 mb-3">결제 정보</div>
						<div class="h5" style="font-weight: bolder;">결제 정보 입력</div>
	
						<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item"><a class="nav-link active "
								id="easy-pay-tab" data-toggle="pill" href="#easy-pay" role="tab"
								aria-controls="easy-pay" aria-selected="true">간편결제</a></li>
							<li class="nav-item"><a class="nav-link"
								id="#direct-input-tab" data-toggle="pill" href="#direct-input"
								role="tab" aria-controls="direct-input" aria-selected="false">직접
									입력</a></li>
						</ul>
	
	
						<div class="tab-content" id="pills-tabContent">
							<div class="tab-pane fade show active" id="easy-pay"
								role="tabpanel" aria-labelledby="easy-pay-tab">
								<div class="row">
									<div class="col-6">
										<aside class="mt-5">
											<div class="h6" style="font-weight: bolder;">결제 카드</div>

											<div class="p-5">등록된 결제 정보가 없습니다. [팝업으로 카드 등록 폼]</div>
											<a href="#" class="genric-btn info-border radius w-100">간편결제
												등록하기</a>
										</aside>
									</div>
									<div class="col-4 d-flex align-items-end">
										<small class="form-text text-muted">
											<div class="h6" style="font-weight: bolder;">결제 예약시
												유의사항</div>
											<p class="card-text">결제자 귀책사유(한도초과, 이용정지 등)로 인하여 결제가 실패할
												수 있으니, 결제수단이 유효한지 한번 확인하세요. 1차 결제 실패 시 실패일로부터 3 영업일 동안 재 결제를
												실행합니다. 결제 예약 이후, 결제할 카드를 변경하려면 마이페이지 > 나의 리워드의 결제정보에서 카드정보를
												변경해주세요.</p>
										</small>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="direct-input" role="tabpanel"
								aria-labelledby="direct-input-tab">
								<div class="row mt-3">
									<div class="col-6">
										<div class="row">
											<div class="h6">신용(체크)카드번호</div>
										</div>
										<div class="row pb-3">

											<div class="col-3 p-1 ">
												<input type="text" class="form-control" placeholder="">
											</div>
											<div class="col-3 p-1 ">
												<input type="text" class="form-control" placeholder="">
											</div>
											<div class="col-3 p-1 ">
												<input type="text" class="form-control" placeholder="">
											</div>
											<div class="col-3 p-1 ">
												<input type="text" class="form-control" placeholder="">
											</div>
										</div>
										<div class="row pb-3">
											<div class="col-6">
												<div class="h6">유효기간</div>
												<input type="text" class="form-control" placeholder="">
											</div>
											<div class="col-6">
												<div class="h6">카드 비밀번호</div>
												<input type="text" class="form-control" placeholder="">
											</div>
										</div>

										<div class="row">
											<div class="h6">생년월일</div>
										</div>
										<div class="row p-2">
											<div class="w-100">
												<input type="text" class="form-control" placeholder="">
											</div>
										</div>
									</div>
									<div class="col-4 d-flex align-items-end">
										<small class="form-text text-muted">
										<div class="h6" style="font-weight: bolder;">
											결제 예약시 유의사항
										</div>
										<p class="card-text">결제자 귀책사유(한도초과, 이용정지 등)로 인하여 결제가 실패할
											수 있으니, 결제수단이 유효한지 한번 확인하세요. 1차 결제 실패 시 실패일로부터 3 영업일 동안 재 결제를
											실행합니다. 결제 예약 이후, 결제할 카드를 변경하려면 마이페이지 > 나의 리워드의 결제정보에서 카드정보를
											변경해주세요.
										</p>
										</small>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</article>
	
			<hr>
	
			<article>
	
				<div class="h5 pt-3">약관 동의</div>
				<div class="card w-100"></div>
	
			</article>
	
			<article class="p-5 d-flex justify-content-center">
				<div class="d-inline-flex p-2 bd-highlight">
					<a href="javaScript: return(0);" onclick="document.getElementById('paymentReserveForm').submit();" class="btn btn-primary">결제 예약하기</a>
				</div>
			</article>
			<input type="hidden" name="fundingMoney" value="${totalAmount }">
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