<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">기본설정</div>
<div class="d-flex flex-column bd-highlight mb-3">
		<div class="p-2 bd-highlight">
			<span>창작자 | 업체명</span>
			<input type="text" name="creator" value="${writingProject.creator }" class="single-input" readonly>

		</div>
		<div class="p-2 bd-highlight">
			<span>이메일</span> 
				<input type="text" name="email" value="${writingProject.email }" class="single-input" readonly>
		</div>
</div>
