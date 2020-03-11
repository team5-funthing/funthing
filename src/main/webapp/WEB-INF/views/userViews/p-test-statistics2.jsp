<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="./include/i-head-setting.jsp" />

</head>
<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />

	<section class="main-wrapper pt-xl-5 ">
		<div class="main-content">
			<div class="container">
				<div class="h4 mt-5 pb-3"><strong>펀딩결제리스트</strong></div>
				<hr>



				<table class="table">
					<thead>
						<tr class="table-primary" style="color:black;">
							<th scope="col">주문번호</th>
							<th scope="col">주문자ID</th>
							<th scope="col">주문날짜</th>
							<th scope="col">주문금액</th>
						</tr>
					</thead>
					<c:forEach var="b1" items="${getAllProjectAndPayment}">
						<tbody>
							<tr style="color:gray;">
								<td>${b1.orderNo}</td>
								<td>${b1.email}</td>
								<td>${b1.paymentReserveDate}</td>
								<td>${b1.fundingMoney}</td>
							</tr>
						</tbody>
					</c:forEach>

				</table>



			</div>
		</div>
	</section>
	<br>
	<br>



	<jsp:include page="./include/i-footer.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>
</body>
</html>