<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="h4" style="color: black; font-weight: bolder;">리워드 설계</div>
<div class="p-2 bd-highlight">
	<span>리워드 설계 조건</span>
	
</div>
<div class="p-2 bd-highlight">

	<a id="addBtn" class="popup-with-form btn btn-lg btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
		href="#reward-popup">추가하기</a>
			
	<ul id="">
		<c:choose>
			<c:when test="${rewardList eq null }">
			</c:when>
			<c:when test="${rewardList ne null }">
				<c:forEach var="addedReward" items="${rewardList}">
					<li id="${addedReward.rewardNo}">
						<input type="hidden" name="rewardNo" value="${addedReward.rewardNo}">
						<input type="hidden" name="projectNo" value="${addedReward.projectNo}">
						<div class="card m-4" style="width: 25rem;">
							<div class="card-body">
								<h5 class="price">${addedReward.rewardPrice}</h5>
								<h6 class="rewardname">${addedReward.rewardName}</h6>
								<p class="rewardContent">${addedReward.rewardContent}</p>
								<a href="#reward-popup" class="popup-with-form editReward">편집</a>
								<a href="deleteReward.udo?projectNo=${writingProject.projectNo}&rewardNo=${addedReward.rewardNo}">삭제</a>
							</div>
						</div>
					</li>
				</c:forEach>
			</c:when>
		</c:choose>
	</ul>
	
</div>