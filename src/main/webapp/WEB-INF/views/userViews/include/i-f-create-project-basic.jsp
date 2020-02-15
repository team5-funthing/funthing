<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<div class="h4" style="color: black; font-weight: bolder;">기본설정</div>
<div class="d-flex flex-column bd-highlight mb-3">
		<div class="p-2 bd-highlight">
			<span>창작자 | 업체명</span>
			<c:choose>
				<c:when test="${writingProject.creator eq null}">
					<input type="text" name="creator" class="single-input"
						placeholder="창작자 또는 업체명을 입력해주세요." onfocus="this.placeholder = ''"
						onblur="this.placeholder = '창작자 또는 업체명을 입력해주세요.'">
				</c:when>
				<c:when test="${writingProject.creator ne null}">
					<input type="text" name="creator" value="${writingProject.creator }"
						class="single-input" placeholder="창작자 또는 업체명을 입력해주세요."
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = '창작자 또는 업체명을 입력해주세요.'">
				</c:when>
			</c:choose>
	
		</div>
		<div class="p-2 bd-highlight">
			<span>이메일</span> 
			<c:choose>
				<c:when test="${writingProject.email eq null }">
					<input type="text" name="email" value="${member.email }" readonly="readonly" "single-input">
				</c:when>
				<c:when test="${writingProject.email ne null }">
					<input type="text" name="email" value="${writingProject.email }" readonly="readonly" class="single-input">
				</c:when>
			</c:choose>
		</div>
</div>
