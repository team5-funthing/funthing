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
	

        <div class="container ">
            <div class="container">
                <div class="row mx-lg-n5">
                
                <form id="getProgressSelectList" action="getShowCategoryList.udo" method="GET">
                    <div class="col py-3 d-flex justify-content-start">
                        <div class="input-group ">
                        
                        
                            <div class="input-group-btn">
                            
                            <script>
			               	$(document).ready(function(){    
			                    $("#category").val().prop("selected", true);
			                });
	            		  </script>

	            			<!-- category고르는곳 -->
						    <select class="form-control" id="category" name="category" >
						      <option value="no">카테고리</option>
						      <option value="태크/가전">태크/가전</option>
						      <option value="패션/잡화">패션/잡화</option>
						      <option value="뷰티">뷰티</option>
						      <option value="식품">식품</option>
						      <option value="도서/출판">도서/출판</option>
						      <option value="예술/공연">예술/공연</option>
						    </select>
				
                            </div><!-- /btn-group -->
                            
                           
                            <div class="input-group-btn">
                            
							<!-- funding 진행상태 고르는곳 -->
						    <select class="form-control" id="funding" name="funding">
						      <option value="z">진행상태</option> <!-- 기본값셋팅 -->
						      <option value="y">진행중인 펀딩</option>
						      <option value="n">성공한 펀딩</option>
						      <option value="n">실패한 펀딩</option>
						      <option value="n">진행예정인 펀딩</option>
						    </select>
                            </div><!-- /btn-group -->
                           
                            <div class="input-group-btn">
                            
                       		<!-- fundingMoney 모인금액 범위 고르는곳 -->
                                 <select class="form-control" id="fundingMoney" name="fundingMoney">
						      <option value=1>모인금액</option> <!-- 기본값셋팅 -->
						      <option value=0>0원~500만원미만</option>
						      <option value=5000000>500만원~1000만원미만</option>
						      <option value=10000000>1000만원~1500만원미만</option>
						      <option value=15000000>1500만원이상</option>
						    </select>
                                
                                
                                
                            </div><!-- /btn-group -->
                            <!-- 달성률 fundingmoney/goalmoney *100 %율 고르는곳 -->
                            <div class="input-group-btn ">
                            
                              <select class="form-control" id="percent" name="percent">
						      <option value=1>프로젝트 달성률</option> <!-- 기본값셋팅 -->
						      <option value="0">0~25%</option>
						      <option value="25">26%~50%</option>
						      <option value="50">51%~75%</option>
						      <option value="75">76%~100%</option>
						      
						    </select>
						    
                            </div><!-- /btn-group -->
                            
                             <div class="col py-3">
                        <div class="d-flex justify-content-end">
 
                            <button type="submit" class="btn btn-outline-secondary">검색</button>
          
                        </div>
                    	</div>
                            
                        </div><!-- /input-group -->
                         
                       
                    
                    </div><!-- <div class="row mx-lg-n5"> -->
                    
                    </form>
                </div>
            </div>
        </div>
        <hr />
		
        <div class="container ">
            <div class="btn-group d-flex justify-content-end">
                <!-- <button type="button" class="btn btn-outline-secondary">인기순</button>
                <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="sr-only">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#"></a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Separated link</a>
                </div>
                 -->
            </div>
        </div>
		<hr>

        <div class="container">
        
        
        
           
            <section class="tiles">
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->

	<!-- --------------------------------------------------전체보기------------------------------------------------------------------ -->
                <c:forEach var="fundingProject" items="${getAllFundingProjectList }" varStatus="step">
                
	                <article>
	                    <div class="project">
	                        <div class="thumbnail-wrap">
	                            <div class="thumbnail">
	                                <div class="centered">
										<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
										    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
                                       			<c:choose>
	                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
	                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
	                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
	                                         		</c:when>
	                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
	                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
	                                         		</c:when>
                                       			</c:choose>  
                                       		</a>
                                        </form>
	                                </div>
	                            </div>
	                        </div>
	                        <h5>${fundingProject.projectTitle }</h5>
	                        <ul>
	                            <li>${fundingProject.projectSummary }</li>
	                            <li>by ${fundingProject.creator }</li>
	                        </ul>
	                        <div class="mt-10">
								<div class="percentage">
									<fmt:formatNumber type="number" var="progressPercent"
										value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
										pattern=".00" />
									<fmt:formatNumber type="number" var="progress"
										maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
									<p>${progress}원${progressPercent}%진행중</p>

									<div class="progress">
										<div class="progress-bar color-7" role="progressbar"
											style="width: ${progressPercent}%" aria-valuenow="30"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
								</div>
							</div>
	                    </div>
	                </article>
                </c:forEach>
	<!-- ----------------------------------------------------------------------------------------------------------------------- -->
                
            </section>
        </div>




    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>