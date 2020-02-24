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
	
	<section class="container">

      <div class="w-100">

         <div class="w-75">

            <article>
            <form class="form-contact comment_form" action="insertProjectAskContents.udo" id="commentForm" method="post">
               <div class="col-lg-10 posts-list">
                  <div class="h2">Project Title " ${vo.projectTitle} "</div>
                  <div class="comment-form pt-2">
                     
                     <h4>프로젝트 문의하기</h4>
                     <div class="comment-list p-0">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="thumb mr-2">
                                 <img src="img/comment/comment_1.png" alt="">
                              </div>
                              <div class="desc">
                                 <p class="comment h3">
                                    <input type="text" name="projectAskContentsTitle" placeholder="Title">
                                 </p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          	작성자 
                                          <a href="#" name="name">${sessionScope.memberSessionName }</a>
                                          <input type="hidden" name="email" value="${sessionScope.memberSessionEmail}">
                                          <input type="hidden" name="creator" value="${vo.creator}">
                                          
                                       </h5>
                                    </div>
                                 </div>
                                 <div class="d-flex justify-content-around mt-3">
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>

                     
                        <div class="row">
                           <div class="col-12">
                              <div class="form-group">
                                 <textarea class="form-control w-100" name="projectAskContents" id="projectAskContents" cols="30" rows="9"
                                    placeholder="Write Comment"></textarea>
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <button type="submit" class="button button-contactForm btn_1 boxed-btn"> 작성하기</button>
                           <button type="submit" formaction="projectDetails.udo" class="button button-contactForm btn_1 boxed-btn"> 취소하기</button>
                        </div>
                     </form>
                  </div>

                       
            </article>

            <hr>

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