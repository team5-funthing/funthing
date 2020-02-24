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

				<div class="row">
					<div class="col"></div>
					<div class="col-10">

						<div class="d-flex justify-content-start mb-3">
							<h3>메시지 확인</h3>
						</div>

						<div class="d-flex justify-content-start">
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active"
										id="nav-created-prj-questions-tab" data-toggle="tab"
										href="#nav-created-prj-questions" role="tab"
										aria-controls="nav-created-prj-questions" aria-selected="true">만든
										프로젝트</a> <a class="nav-item nav-link"
										id="nav-sponsored-prj-questions-tab" data-toggle="tab"
										href="#nav-sponsored-prj-questions" role="tab"
										aria-controls="nav-sponsored-prj-questions"
										aria-selected="false">문의/후원 프로젝트</a>
								</div>
							</nav>
						</div>

						<br>

						<div class="tab-content" id="nav-check-msg-tab">
							<div class="tab-pane fade show active"
								id="nav-created-prj-questions" role="tabpanel"
								aria-labelledby="nav-created-prj-questions-tab">
								<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
									<li class="nav-item"><c:choose>
											<c:when test="${vo2.creator ne null }">
												<table id="myTable" class="display">
													<thead>
														<tr>
															<th>창작자</th>
															<th>작성자</th>
															<th style="width: 250px">메시지 제목</th>
															<th>작성날짜</th>
															<th>답변여부</th>
														</tr>
													</thead>
													<tbody>

														<c:forEach var="messagelist" items="${messagelist}">
															<tr>
																<td>${vo2.creator}</td>
																<td>${messagelist.email }</td>
																<td><a
																	href="getChoiceProjectAskMessageC.udo?projectAskNo=${messagelist.projectAskNo }">${messagelist.projectAskContentsTitle}</td>
																<td>${messagelist.projectAskDate}</td>
																<td>${messagelist.projectAskReplyStatus}</td>
															</tr>

														</c:forEach>
														</c:when>
														<c:when test="${vo2.creator eq null }">
															<div class="row">
																<div class="col"></div>
																<div class="col-8 d-flex justify-content-center ">
																	<div class="pt-5 pb-5 ">
																		<div>
																			<svg xmlns="http://www.w3.org/2000/svg" width="60"
																				height="60" viewBox="0 0 24 24" fill="none"
																				stroke="currentColor" stroke-width="1.5"
																				stroke-linecap="round" stroke-linejoin="round"
																				class="feather feather-mail">
																			<path
																					d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
																			<polyline points="22,6 12,13 2,6" /></svg>
																		</div>

																		<div class="h3">현재 만든 프로젝트가 없습니다</div>
																		<div class="h5">프로젝트 페이지에서 '프로젝트올리기' 로 프로젝트를 생성
																			할 수 있습니다.</div>

																	</div>
																</div>
																<div class="col"></div>
															</div>
														</c:when>
														</c:choose>
													</tbody>
												</table>

												<script>
													$(document)
															.ready(
																	function() {
																		$(
																				'#myTable')
																				.DataTable();
																	});
												</script></li>
								</ul>
							</div>



							<div class="tab-pane fade" id="nav-sponsored-prj-questions"
								role="tabpanel"
								aria-labelledby="nav-sponsored-prj-questions-tab">


								<!-- 보낸 메세지 있을 경우 -->
								<c:choose>
									<c:when test="${getMessageList ne null }">
										<table id="myTable" class="display">
											<thead>
												<tr>
													<th>창작자</th>
													<th>작성자</th>
													<th style="width: 250px">메시지 제목</th>
													<th>작성날짜</th>
													<th>답변여부</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="getMessageList" items="${getMessageList}">
													<tr>
														<td>${getMessageList.creator}</td>
														<td>${getMessageList.email }</td>
														<td><a
															href="getChoiceProjectAskMessage.udo?projectAskNo=${getMessageList.projectAskNo }">${getMessageList.projectAskContentsTitle}</td>
														<td>${getMessageList.projectAskDate}</td>
														<td>${getMessageList.projectAskReplyStatus}</td>
													</tr>

												</c:forEach>
												</c:when>
												<c:when test="${getMessageList eq null }">

													<div class="row">
														<div class="col"></div>
														<div class="col-8 d-flex justify-content-center ">
															<div class="pt-5 pb-5 ">
																<div>
																	<svg xmlns="http://www.w3.org/2000/svg" width="60"
																		height="60" viewBox="0 0 24 24" fill="none"
																		stroke="currentColor" stroke-width="1.5"
																		stroke-linecap="round" stroke-linejoin="round"
																		class="feather feather-mail">
													<path
																			d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
													<polyline points="22,6 12,13 2,6" /></svg>
																</div>
																<div class="h3">보낸 메시지가 없습니다</div>
																<div class="h5">프로젝트 페이지에서 '문의하기' 버튼을 눌러 메시지를 보낼 수
																	있습니다.</div>
															</div>
														</div>
														<div class="col"></div>
													</div>





												</c:when>
												</c:choose>
											</tbody>
										</table>


										</li>
										</ul>
							</div>

						</div>

					</div>
					<div class="col"></div>
				</div>
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