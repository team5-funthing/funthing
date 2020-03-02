<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <article class="back-story">
            <i class="fas fa-chevron-left"></i>
            <a href="#">메인으로 돌아가기</a>
        </article>
        <article class="select-order">
            <div class="row d-flex justify-content-center ml-2 mr-2 mt-4 pb-4">
                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke; border-style:dotted; border-color: gray; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-3" style="color: #000000;" >
                        리워드<br>
                        선택
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                </div>
                <div class="order-circle d-flex d-flex justify-content-center " style="background: whitesmoke; border-style:dotted; border-color: gray; border-width: 3px;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-0" style="color: #000000;" >
                        결제 예약
                    </div>
                </div>
                <div class="d-flex align-items-center">
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                    <i class="fas fa-ellipsis-h" style="color:gray;"></i>
                </div>
                <div class="order-circle d-flex d-flex justify-content-center " style="background: #009DFF;">
                    <div class="d-inline-flex p-2 bd-highlight align-self-center h5 p-0" style="color: whitesmoke;" >
                        결제 확인
                    </div>
                </div>
            </div>
        </article>

        <hr>

        <article class="pb-4">

            <div class="card mb-3" style="border: 0px">
                <div class="card-body">
                    <div class="row">
                        <div class="col-8">
                            <h5 class="card-title">[결제한 리워드 품목 이름]</h5>
                            <p class="card-text">리워드 제품 품목 설명</p>
                            <p class="card-text">옵션: [선택]</p>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end">
                        <p class="card-text mr-3" style="font-weight: bold;">수량:1개[수량]</p>
                        <p class="card-text" style="font-weight: bold;">25,000원[수량에 따른 금액]</p>
                    </div>
                    <hr>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 추가 펀딩금액</div>
                        <div class="p-2 bd-highlight"> 0원</div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 배송비</div>
                        <div class="p-2 bd-highlight"> 0원</div>
                    </div>
                    <hr>

                    <div class="d-flex justify-content-start">
                        <div class="p-2 bd-highlight h4"> 배송 정보</div>
                    </div>

                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 주문번호</div>
                        <div class="p-2 bd-highlight"> --------</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 주문자</div>
                        <div class="p-2 bd-highlight"> --------</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 배송지</div>
                        <div class="p-2 bd-highlight"> [서울시 종로구 ------ ]</div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <div class="p-2 bd-highlight"> 요청 사항</div>
                        <div class="p-2 bd-highlight"> [부재 시 전화주세요!]</div>
                    </div>
                    <hr>
                    <div class="d-flex justify-content-end">
                        <div class="p-2 bd-highlight h3"> 총 결제 금액</div>
                        <div class="p-2 bd-highlight h3"> ------- 원</div>
                    </div>
                </div>
            </div>
        </article>
        
        <article class="p-2 d-flex justify-content-center">
            <div class="d-inline-flex p-2 bd-highlight">
                <a href="#" class="btn btn-primary">확인 [스토리로 돌아가기]</a>
            </div>
        </article>

        

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