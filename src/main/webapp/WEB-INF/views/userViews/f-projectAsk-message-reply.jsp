<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html class="no-js">

<head>

<jsp:include page="./include/i-head-setting.jsp" />

</head>

<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />


	<!-- ------------------ -->
	<section class="main-wrapper pt-xl-5 ">
		<div class="main-content">
			<div class="container">

				<div class="h4 mt-5 pb-3"><strong>내가 보낸 문의메시지 확인</strong></div>
				<hr>
				<br><br>

					<!-- 메세지 확인란 -->
						<div class="card p-2 bd-highlight" style="width: 45rem;">
							<div class="card-header">NO.${choiceProjectAskMessage.projectAskNo }) ${choiceProjectAskMessage.projectAskContentsTitle }</div>
							<div class="card-body">
								<blockquote class="blockquote mb-1">
									<div  style="color:black;">${choiceProjectAskMessage.projectAskContents }</div>
									<br>
									<div class="d-flex flex-row-reverse bd-highlight">
									<footer class="blockquote-footer">
										${choiceProjectAskMessage.email} / <cite title="Source Title">${choiceProjectAskMessage.projectAskDate}</cite>
									</footer>
									</div>
								</blockquote>
							</div>
						</div>
						<br><br><br>
						
						<!-- 답변란 -->
						<form action="showDetailMyPage.udo" method="get">
						<c:choose>
						<c:when test="${choiceProjectAskMessage.projectAskReplyContents eq null}">
						<div class="card ml-auto p-2 bd-highlight" style="width: 45rem;" >
						
							<div class="card-header d-flex flex-row-reverse bd-highlight">답변대기중</div>
							<div class="card-body">
								<blockquote class="blockquote mb-1">
									<div  style="color:red;">아직 답변이 등록되어 있지않습니다.</div>
									<br>
									<div class="d-flex flex-row-reverse bd-highlight">
									<footer class="blockquote-footer">
										${choiceProjectAskMessage.creator}
									</footer>
									</div>
								</blockquote>
							</div>
						</div>
							
						</c:when>
						<c:when test="${choiceProjectAskMessage.projectAskReplyContents ne null}">
						
						<div class="card ml-auto p-2 bd-highlight" style="width: 45rem;" >

							<div class="card-header d-flex flex-row-reverse bd-highlight">${choiceProjectAskMessage.projectAskReplyContentsTitle}</div>
							<div class="card-body">
								<blockquote class="blockquote mb-1">
									<div  style="color:black;">${choiceProjectAskMessage.projectAskReplyContents}</div>
									<br>
									<div class="d-flex flex-row-reverse bd-highlight">
									<footer class="blockquote-footer">
										${choiceProjectAskMessage.creator} / <cite title="Source Title">${choiceProjectAskMessage.projectAskReplyDate}</cite>
									</footer>
									</div>
								</blockquote>
							</div>
						</div>
						</c:when>
						</c:choose>
						<br><br><br>

			
<hr>
<br>
				<div class="form-group d-flex flex-row-reverse bd-highlight"> 
                 <input type="submit" class="button button-contactForm btn_1 boxed-btn" value="목록으로 돌아가기 ">
                  </div>
                  </form>
<br><br><br><br>

						
					</div>
				</div>
	</section>


	<!-- -------------------- -->




	<!-- footer -->
	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>