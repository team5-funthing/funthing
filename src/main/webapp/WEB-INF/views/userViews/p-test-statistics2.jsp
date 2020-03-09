<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제리스트확인</title>


</head>
<body>

<h2>펀딩결제리스트</h2>
<c:forEach var="b1" items="${getAllProjectAndPayment}">
	<p class="date">
		${b1.orderNo}
		${b1.paymentReserveDate}
		${b1.fundingMoney}		
	</p>
</c:forEach>
	







</body>
</html>