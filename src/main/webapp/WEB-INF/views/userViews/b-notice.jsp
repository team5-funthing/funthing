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
    <jsp:include page="./include/i-header.jsp"/>
    
	<script>
	$(document).ready(function(){
		$("#nav-notice-all-tab").click(function(){
			$.ajax({
				type:"POST",
				url:"getAllNoticeBoardList.udo",
				success:function(data){
					$("#allNoticeArea").html(data);
				},
				error:function(){
					alert('실패');
				}
			});
		});
		$("#nav-notice-tab").click(function(){
			var sendData = {category:"공지"};
			$.ajax({
				type:"POST",
				url:"getRealNoticeBoardList.udo",
				data:sendData,
				success:function(data){
					$("#noticeArea").html(data);
				},
				error:function(){
					alert('실패');
				}
			});
		});
		$("#nav-event-tab").click(function(){
			var sendData = {category:"이벤트"};
			$.ajax({
				type:"POST",
				url:"getEventNoticeBoardList.udo",
				data:sendData,
				success:function(data){
					$("#eventArea").html(data);
				},
				error:function(){
					alert('실패');
				}
			});
		});	
	});//document.ready 종료
	</script>
	<hr>
	<section class="">
		<article class="d-flex justify-content-center">
			<div class="h2 p-5">공지 사항</div>
		</article>
		<article>
			<nav>
				<div class="nav nav-tabs d-flex justify-content-center" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-notice-all-tab" data-toggle="tab" href="#nav-notice-all" role="tab" aria-controls="nav-notice-all" aria-selected="true">모든 소식</a> 
					<a class="nav-item nav-link" id="nav-notice-tab" data-toggle="tab" href="#nav-notice" role="tab" aria-controls="nav-notice" aria-selected="false">공지 | 알림</a> 
					<a class="nav-item nav-link" id="nav-event-tab" data-toggle="tab" href="#nav-event" role="tab" aria-controls="nav-event" aria-selected="false" >이벤트</a>
				</div>
			</nav>	
		</article>

		<article>
			<div class="row p-4">
				<div class="col-3"></div>
				<div class="col-6">
					<div class="">
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-notice-all" role="tabpanel" aria-labelledby="nav-notice-all-tab">
								<div id="allNoticeArea">
									<c:forEach var="list" items="${getNoticeList}">
										<div class="h4">
											<p>공지 알림 [뱃지 형식]</p>
											<a href="getNoticeBoard.udo?noticeNo=${list.noticeNo}">${list.noticeTitle}</a>
											<p>${list.adminId}</p>
											<p>${list.noticeDate}</p>
										</div>
										<hr>
									</c:forEach>
								</div>
							</div>

							<div class="tab-pane fade" id="nav-notice" role="tabpanel" aria-labelledby="nav-notice-tab">
								<div id="noticeArea">
								</div>
							</div>
							<div class="tab-pane fade" id="nav-event" role="tabpanel" aria-labelledby="nav-event-tab">
								<div id="eventArea">
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
				<div id="paging">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="getNoticeBoardEachPageList.udo?currentPage=${startPageCount - 5}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<c:forEach var="i" begin="${startPageCount}" end="${endPageCount}">
							<li class="page-item"><a class="page-link" href="getNoticeBoardEachPageList.udo?currentPage=${i}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="getNoticeBoardEachPageList.udo?currentPage=${startPageCount + 5}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</div>
			</nav>
		</article>

		<article class="d-flex justify-content-center">
			<form class="form-inline my-2 my-lg-0" action="getSearchTitleBoardList.udo" method="post">
				<div class="form-group p-2">
					<label for="exampleFormControlSelect1"></label>
					<select class="form-control" id="exampleFormControlSelect1" name="noticeSearchCondition">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
				</div>
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="noticeSearchContent">
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