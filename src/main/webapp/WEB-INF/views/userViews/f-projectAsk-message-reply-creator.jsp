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
                                    ${choiceProjectAskMessage.projectAskContents }
                                 </p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          <a href="#">${choiceProjectAskMessage.email}
                                          </a>
                                       </h5>
                                       <p class="date">${choiceProjectAskMessage.projectAskDate} </p>
                                    </div>
                                 </div>
                                 <div class="d-flex justify-content-around mt-3">
                                 </div>
                              </div>
                           </div>
                        </div>
                        
                     </div>
                     
                        <form class="form-contact comment_form" action="updateProjectAskReplyContentsStatus.udo" id="commentForm" method="post">
   
                        <div class="row d-flex align-items-center">
                         
                         <div class="col-12">
                           <div class="form-group">
                              <input class="form-control" name="projectAskReplyContentsTitle" id="projectAskReplyContentsTitle" 
                              type="text"  placeholder="Title" value="${choiceProjectAskMessage.projectAskReplyContentsTitle}">
                              
                              <input type="hidden" name="projectAskNo" value="${choiceProjectAskMessage.projectAskNo }">
                              
                              </div>
                        </div>
                         
                        <div class="col-12">
                           <div class="form-group">
                              <textarea class="form-control w-100" name="projectAskReplyContents" id="projectAskReplyContents" cols="30" rows="9"
                                 placeholder="Write Comment">${choiceProjectAskMessage.projectAskReplyContents}</textarea>
                           </div>
                        </div>
                         <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="creator" id="creator" type="text" value="${vo3.creator }" placeholder="창작자명">
                              </div>
                           </div>
                           <div class="col-sm-6">
                              <div class="form-group">
                                 <input class="form-control" name="email" id="email" type="email" value="${sessionScope.memberSessionEmail}" placeholder="Email">
                              </div>
                           </div>
                        </div>
                        
                  </div>
                 <!-- 미답변일때 나오는 버튼  (단!,크리에이터일때만 )-->        
                  <c:if test="${choiceProjectAskMessage.projectAskReplyStatus eq '미답변' }">
                  <div class="form-group">
                     <input type="submit" class="button button-contactForm btn_1 boxed-btn" value="작성하기">
                     <input type="hidden" name="projectAskReplyStatus" value="답변완료">  
                  </div>
                  </c:if>
                 
                  </form>
                  
				<!-- 계속 나와야 하는 버튼  -->                  
                  <form class="form-group" action="showDetailMyPage.udo" method="get">
                  <div class="form-group"> 
                  <input type="submit" class="button button-contactForm btn_1 boxed-btn" value="목록으로 돌아가기 "> 
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