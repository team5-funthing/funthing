<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">스토리 작성</div>
<div class="p-2 bd-highlight">
	<span>소개 컨텐츠 [영상]</span>

	<div class="input-group mb-3">
		<div class="form-group">
		
		<!-- 	<label for="exampleFormControlFile1">소개 컨텐츠를 선택하세요.(영상)</label> 
			<input type="file" name="projectVideo" class="form-control-file select-project-image" id="exampleFormControlFile1"> -->
		</div>
	</div>
	
</div>
<div class="p-2 bd-highlight">
	<span>프로젝트 요약</span>
	<div class="form-group">
		<label for="projectSummaryTextarea">프로젝트에 대해 간략하게 설명해주세요.</label>
		<c:choose>
			<c:when test="${writingProject.projectSummary eq null }">
					<textarea name="projectSummary" class="form-control" id="projectSummaryTextarea" rows="3"></textarea>
			</c:when>
			<c:when test="${writingProject.projectSummary ne null }">
					<textarea name="projectSummary" class="form-control" id="projectSummaryTextarea" rows="3">${writingProject.projectSummary }</textarea>
			</c:when>
		</c:choose>

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
	
	<textarea class="mt-1" name="projectStory" class="form-control" id="editor" rows="10">
		<h2>TEST 글이에요.</h2>
		<p>
			This may be the first time you hear about this made-up disorder but
			it actually isn’t so far from the truth. Even the studies that were conducted almost half a century show that
			<strong>the language you speak has more effects on you than you realise</strong>.
		</p>
		<p>
			One of the very first experiments conducted on this topic dates back to 1964.
			<a href="https://www.researchgate.net/publication/9440038_Language_and_TAT_content_in_bilinguals">In the experiment</a>
			designed by linguist Ervin-Tripp who is an authority expert in psycholinguistic and sociolinguistic studies,
			adults who are bilingual in English in French were showed series of pictures and were asked to create 3-minute stories.
			In the end participants emphasized drastically different dynamics for stories in English and French.
		</p>
		<p>
			Another ground-breaking experiment which included bilingual Japanese women married to American men in San Francisco were
			asked to complete sentences. The goal of the experiment was to investigate whether or not human feelings and thoughts
			are expressed differently in <strong>different language mindsets</strong>.
			<Here>is a sample from the the experiment:</Here>
		</p>
		<p>
			More recent <a href="https://books.google.pl/books?id=1LMhWGHGkRUC">studies</a> show, the language a person speaks affects
			their cognition, behaviour, emotions and hence <strong>their personality</strong>.
			This shouldn’t come as a surprise
			<a href="https://en.wikipedia.org/wiki/Lateralization_of_brain_function">since we already know</a> that different regions
			of the brain become more active depending on the person’s activity at hand. Since structure, information and especially
			<strong>the culture</strong> of languages varies substantially and the language a person speaks is an essential element of daily life.
		</p>
	</textarea>

</div>

<script src="${pageContext.request.contextPath}/resources/common/js/ckeditor.js"></script>











