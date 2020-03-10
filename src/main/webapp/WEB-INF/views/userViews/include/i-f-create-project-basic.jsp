<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">기본설정</div>

<div class="d-flex flex-column bd-highlight mb-3">

	<div class="p-2 bd-highlight">
		<span>창작자 | 업체명</span>
		<input type="text" name="creator" value="${writingProject.creator }" class="single-input">
		</div>
		<div class="p-2 bd-highlight">
			<span>이메일</span> 
			<input type="text" name="email" value="${writingProject.email }" class="single-input" readonly>
		</div>
		<div class="p-2 bd-highlight">
			<c:if test="${writingProject.status eq 'm'.charAt(0)}">
				<div>반려사유</div>
				<div style="color:black;">${writingProject.statusReplyMessage}</div>
			</c:if>
			<c:if test="${writingProject.status eq 'f'.charAt(0)}">
				<div>거부사유</div>
				<div style="color:black;">${writingProject.statusReplyMessage}</div>
			</c:if>
		</div>
		<div class="p-2 bd-highlight">
		<span>문의 전화번호</span>
		<input type="text" name="makerPhone" value="${writingCreator.makerPhone}" readonly class="single-input">
		</div>
		<div class="p-2 bd-highlight">
		<span>사업자 번호</span>
		<input type="text" name="businessNumber" value="${writingCreator.businessNumber}" readonly class="single-input">
		</div>
		<div class="p-2 bd-highlight">
		<span>소재지</span>
		<input type="text" name="businessAddress" value="${writingCreator.businessAddress}" readonly class="single-input">
		</div>
		

</div>

