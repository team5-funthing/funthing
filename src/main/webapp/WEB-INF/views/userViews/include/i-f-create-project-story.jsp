<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">스토리 작성</div>
<div class="p-2 bd-highlight">
	<span>소개 컨텐츠 [영상]</span>

	<!-- ProjectVideo Youtube 영상 올리기 -->
	<div class="input-group mb-3">
	
		<c:if test="${projectStory eq null}">
			<input type="text" id="urlVideo" name="projectStoryVideo" class="form-control" placeholder="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-label="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-describedby="urlBtn">
			<div class="input-group-append urlBtn-registry">
			  <button class="btn btn-outline-secondary" type="button" id="urlBtn">등록</button>
			</div>
			<div class="m-4">
				<div id="toAppendIframeDiv" class="form-group">
			</div>
		</div>
		</c:if>
		
		<c:if test="${projectStory ne null}">
			<div class='input-group-append urlBtn-remove'>
				<a class='btn fas fa-times fa-2x' type='button' id='urlBtn'></a>
			</div>
			<div class="m-4">
				<div id="toAppendIframeDiv" class="form-group">
					${projectStory.projectStoryVideo }
				</div>
			</div>
		
		</c:if>
	</div>
	
	<script>
       	$("#urlBtn").on("click", function(){
       		console.log("실행")
       		var sourceCode = $('#urlVideo').val();
       		
       		//var url = url.substring(url.lastIndexOf('/')+1);
       		//console.log("수정 후 :" + url);
       		if(sourceCode != ""){
       			$("#toAppendIframeDiv").append(sourceCode);
       			var removeUrlBtn = "<div class='input-group-append urlBtn-remove'><a class='btn fas fa-times fa-2x' type='button' id='urlBtn'></a></div>";
       			$(".urlBtn-registry").after(removeUrlBtn);
       			$("#urlBtn").attr("disabled", true);
       			$("#urlVideo").attr("disabled", true);
       		}
       	});
    </script>
	
	
	
	
	
	<c:choose>
		<c:when test="${projectStory.projectStoryImagePath eq ''}">
			<input type="file" name="uploadImage"
				class="form-control-file select-project-image"
				id="projectStoryImagePath">
                     <hr>
                     <div class="select_img"><img src="" /></div>
		</c:when>
		<c:when test="${projectStory.projectStoryImagePath ne ''}">
			<input type="hidden" name="projectStoryImagePath" value="${projectStory.projectStoryImagePath }">
			<input type="file" name="projectStoryImageUpload"
				class="form-control-file select-project-image"
				id="projectStoryImagePath">
			<div class="select_img m-3"><img style="width: 500px; height: auto;" src="${projectStory.projectStoryImagePath }" /></div>					
		</c:when>
	</c:choose>
	
	
	<script>
       	$("#projectStoryImagePath").change(function(){
       		if(this.files && this.files[0]){
       			var reader = new FileReader;
       			reader.onload = function(data){
       				$(".select_img img").attr("src", data.target.result).width(500);
       			}
       			reader.readAsDataURL(this.files[0]);
       		}
       	})
    </script>	
	
	
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
	
	<c:choose>
		<c:when test="${projectStory.projectStory eq null }">
			<textarea class="mt-1" name="projectStory" class="form-control" id="editor" rows="20">
				자기만의 프로젝트 스토리를 만들어주세요!
			</textarea>
		</c:when>
		<c:when test="${projectStory.projectStory ne null }">
			<textarea class="mt-1" name="projectStory" class="form-control" id="editor" rows="20">${writingProject.projectStory}</textarea>
		</c:when>
	</c:choose>
	
	

</div>

<script>
	
	
	$(function(){
		
		CKEDITOR.replace('editor')
		
	});
	
</script>











