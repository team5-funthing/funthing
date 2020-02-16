<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">스토리 작성</div>
<div class="p-2 bd-highlight">
	<span>소개 컨텐츠 [영상]</span>
	<!-- 
	<div class="input-group mb-3">
		<div class="form-group">
			<label for="exampleFormControlFile1">소개 컨텐츠를 선택하세요.(영상)</label> <input
				type="file" name="" class="form-control-file select-project-image"
				id="exampleFormControlFile1">
		</div>
	</div>
	-->
</div>
<div class="p-2 bd-highlight">
	<span>프로젝트 요약</span>
	<div class="form-group">
		<label for="projectSummaryTextarea">프로젝트에 대해 간략하게 설명해주세요.</label>
		<textarea name="projectSummary" class="form-control" id="projectSummaryTextarea"
			rows="3"></textarea>
	</div>
</div>
<div class="p-2 bd-highlight">
	<span>스토리 광고 심의 동의*</span>
	<div class="form-group">
		<label for="projectAgreeField">동의를 진행해야 스토리작성이 가능합니다.</label>
		<div class="row">
			<div class="col">
				<p>공통 표시 광고 가이드라인</p>
				<p>식품 표시 광고 가이드라인</p>
				<p>화장품 표시 광고 가이드라인</p>
				<p>건강보조기구 표시 광고 가이드 라인</p>
				
				<p>//체크 동의 완료시</p>
				<p>[동의 완료] [동의 날짜 시간 ]</p>
				<p>[동의한 회원 정보]</p>
			</div>
			</div>
	</div>
</div>
<div class="p-2 bd-highlight">
	

	<span>프로젝트 스토리*</span>
	
	<textarea class="form-control" id="editor">테스트 내용</textarea>
	<script type="text/javascript">
	 	CKEDITOR.replace('editor', { height: 500 });
	</script>
</div>

<!-- <script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script> -->











