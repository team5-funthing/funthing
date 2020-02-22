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
               <div class="col-lg-10 posts-list">
   
                  <div class="comment-form pt-2">
                     <h4>문의 메시지 답변하기</h4>
                     <div class="comment-list p-0">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="thumb mr-2">
                                 <img src="img/comment/comment_1.png" alt="">
                              </div>
                              <div class="desc">
                                 <p class="comment">
                                    Multiply sea night grass fourth day sea lesser rule open subdue female fill which
                                    them
                                    Blessed, give fill lesser bearing multiply sea night grass fourth day sea lesser
                                    Multiply sea night grass fourth day sea lesser rule open subdue female fill which
                                    them
                                    Blessed, give fill lesser bearing multiply sea night grass fourth day sea lesser
                                    Multiply sea night grass fourth day sea lesser rule open subdue female fill which
                                    them
                                 </p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          <a href="#">송하늘</a>
                                       </h5>
                                       <p class="date">December 4, 2017 at 3:12 pm </p>
                                    </div>
                                 </div>
                                 <div class="d-flex justify-content-around mt-3">
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
   
                     <form class="form-contact comment_form" action="#" id="commentForm">
                        <div class="row d-flex align-items-center">
                           <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="name" id="name" type="text" placeholder="창작자명">
                              </div>
                           </div>
                           <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="email" id="email" type="email" placeholder="Email">
                              </div>
                           </div>
                        </div>
                        <div class="col-12">
                           <div class="form-group">
                              <textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="9"
                                 placeholder="Write Comment"></textarea>
                           </div>
                        </div>
                  </div>
                  <div class="form-group">
                     <button type="submit" class="button button-contactForm btn_1 boxed-btn"> 작성하기</button>
                     <button type="submit" class="button button-contactForm btn_1 boxed-btn"> 취소하기</button>
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