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
	
	<section class="main-wrapper pt-xl-5 ">
		<div class="main-content">
			<div class="container">
			
			
			<form class="form-contact comment_form" action="insertProjectAskContents.udo" id="commentForm" method="post">
			  
                  <div class="h4 mt-5 pb-3"><strong>[ ${vo.projectTitle} ] 프로젝트 문의하기</strong></div>
                 
                     <hr><br><br>
                    
                    
                    
                     <div class="comment-list p-0">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
	
								<div class="card m-auto p-2 bd-highlight" style="width: 68rem;">
							<div class="card-header d-flex flex-row-reverse bd-highlight">
							<a href="#" name="name">작성자  : ${sessionScope.memberSession.name }</a></div>
							<div class="card-body">
							 <input type="hidden" name="email" value="${sessionScope.memberSession.email}">
                                          <input type="hidden" name="creator" value="${vo.creator}">
                                          <input type="hidden" name="projectNo" value="${vo.projectNo}">
								<blockquote class="blockquote mb-1">
									<div style="color: black;">
									
									 <input class="form-control" name="projectAskContentsTitle" id="projectAskContentsTitle" 
                              type="text"  placeholder="제목을 입력하세요" >
                              
                              <input type="hidden" name="projectAskReplyStatus" value="답변완료"> 
										<br>
										<textarea class="form-control w-100"
											name="projectAskContents" id="projectAskContents"
											cols="30" rows="18" placeholder="내용을 입력하세요"></textarea>


									</div>
									<br>
									<div class="form-group d-flex flex-row-reverse bd-highlight">
					
                  <input type="submit" class="button button-contactForm btn_1 boxed-btn" value="작성하기 "> 
                <a type="button" href="projectDetails.udo?projectNo=${vo.projectNo}" class="button button-contactForm btn_1 boxed-btn mr-3">취소하기</a>
                          

									</div>
								</blockquote>
							</div>
						</div>
								<br><br><br>  
                                     
                                    
                                 <div class="d-flex justify-content-around mt-3">
                                 </div>
                              </div>
                           </div>
                        </div>
                        
                        </form>
                        
                     </div>

			</div>
<br><br><br>
	</section>
	
	<!-- -------------------- -->
	

   <jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>