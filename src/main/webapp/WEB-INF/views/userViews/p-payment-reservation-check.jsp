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
	
	<hr>
    <section class="main-wrapper pt-xl-5 ">
        <div class="main-content">
            <div class="container">
                
                <div class="row">
                    <div class="col">
                    </div>
                    <div class="col-8">
                        <div class="d-flex justify-content-between">
                            <div class="h4">결제예약 내역 확인</div>
                            <div class="p-2 bd-highlight">
                                <select class="custom-select custom-select">
                                    <option selected>ALL</option>
                                    <option value="1">금액 높은순</option>
                                    <option value="2">금액 낮은순</option>
                                    <option value="3">최근 순서</option>
                                    <option value="4">오래된 순서</option>
                                  </select>
                            </div>
                        </div>



                        <div class="d-flex justify-content-start">
                            <table class="table table-hover border">
                                <thead>
                                  <tr class="bg-info text-white">
                                    <th scope="col">no.</th>
                                    <th scope="col">카테고리</th>
                                    <th scope="col">프로젝트</th>
                                    <th scope="col">결제 상황</th>
                                    <th scope="col">금액</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                    <th scope="row">1</th>
                                    <td>예술</td>
                                    <td>테스트 제목</td>
                                    <td>2020-02-07</td>
                                    <td>94,000원</td>
                                  </tr>
                                  <tr>
                                    <th scope="row">2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                    <td>24,000원</td>
                                  </tr>
                                  <tr>
                                    <th scope="row">3</th>
                                    <td colspan="2">Larry the Bird</td>
                                    <td>@twitter</td>
                                    <td>53,000원</td>
                                  </tr>
                                </tbody>
                              </table>

                        </div>


                    </div>
                    <div class="col">
                    </div>
                </div>
            </div>
        </div>
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