<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html class="no-js" lang="zxx">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
</head>

<body>
  
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header-login.jsp"/>
	

	<hr>

	<section class="">

		<article class="d-flex justify-content-center">
			<div class="h2 p-5">공지 사항</div>
		</article>

		<article>

			<nav>

					<div class="nav nav-tabs d-flex justify-content-center"
						id="nav-tab" role="tablist">
						<a class="nav-item nav-link active" id="nav-notice-all-tab"
							data-toggle="tab" href="#nav-notice-all" role="tab"
							aria-controls="nav-notice-all" aria-selected="true">모든 소식</a> 
							<a class="nav-item nav-link" id="nav-notice-tab" data-toggle="tab"
							href="#nav-notice" role="tab" aria-controls="nav-notice"
							aria-selected="false">공지 | 알림</a> 
							<a class="nav-item nav-link" id="nav-event-tab" data-toggle="tab"
							href="#nav-event" role="tab" aria-controls="nav-event"
							aria-selected="false" >이벤트</a>
					</div>

			</nav>
			
		</article>

		<article>

			<div class="row p-4">
				<div class="col-3"></div>
				<div class="col-6">
					<div class="">

						<div class="tab-content" id="nav-tabContent">

							<div class="tab-pane fade show active" id="nav-notice-all"
								role="tabpanel" aria-labelledby="nav-notice-all-tab">
								<c:forEach var="list" items="${EntireNoticeList}">
									<div class="h4">
										<p>공지 알림 [뱃지 형식]</p>
										<a href="selectNotice.udo?no=${list.noticeNo}">${list.noticeTitle }</a>
										<p>${list.adminId }</p>
										<p>${list.noticeDate }</p>
									</div>
									<hr>
								</c:forEach>
							</div>

							<div class="tab-pane fade" id="nav-notice" role="tabpanel"
								aria-labelledby="nav-notice-tab">

								<div class="tab-pane fade show active" id="nav-notice"
									role="tabpanel" aria-labelledby="nav-notice-tab">
									
									<c:forEach var="list" items="${noticeList}">
										<div class="h4">
											<p>공지 알림 [뱃지 형식]</p>
											<a href="selectNotice.udo?no=${list.noticeNo}">${list.noticeTitle }</a>
											<p>${list.adminId }</p>
											<p>${list.noticeDate }</p>
										</div>
										<hr>
									</c:forEach>

								</div>

							</div>
							<div class="tab-pane fade" id="nav-event" role="tabpanel"
								aria-labelledby="nav-event-tab">

								<div class="tab-pane fade show active" id="nav-event"
									role="tabpanel" aria-labelledby="nav-event-tab">
									<c:forEach var="list" items="${EventNoticeList}">
										<div class="h4">
											<p>공지 알림 [뱃지 형식]</p>
											<a href="selectNotice.udo?no=${list.noticeNo}">${list.noticeTitle }</a>
											<p>${list.adminId }</p>
											<p>${list.noticeDate }</p>
										</div>
										<hr>
									</c:forEach>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<div class="col-3"></div>
			</div>


		</article>

		<article class="d-flex justify-content-center">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</article>

		<article class="d-flex justify-content-center">
			<form class="form-inline my-2 my-lg-0">
				<div class="form-group p-2">
					<label for="exampleFormControlSelect1"></label> <select
						class="form-control" id="exampleFormControlSelect1">
						<option>제목+내용</option>
						<option>제목</option>
						<option>내용</option>
					</select>
				</div>
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
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