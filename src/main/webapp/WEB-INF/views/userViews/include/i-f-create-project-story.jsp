<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">스토리 작성</div>




	<div class="p-2 bd-highlight">

	<span>소개 컨텐츠 [영상]</span>
	<article class="mt-3">
		<nav class="col">
		  <div class="nav nav-tabs" id="nav-tab" role="tablist">
		    <a class="nav-item nav-link active" id="nav-video-tab" data-toggle="tab" href="#nav-video" role="tab" aria-controls="nav-video" aria-selected="true">동영상</a>
		    <a class="nav-item nav-link" id="nav-images-tab" data-toggle="tab" href="#nav-images" role="tab" aria-controls="nav-images" aria-selected="false">사진</a>
		  </div>
		</nav>
	
		<div class="tab-content" id="nav-tabContent">
		
		  <div class="tab-pane fade show active" id="nav-video" role="tabpanel" aria-labelledby="nav-video-tab">
				<!-- ProjectVideo Youtube 영상 올리기 -->
				<div class="input-group mt-2 mb-3">
					
					<c:choose>
						<c:when test="${writingProject.projectIntroduceVideo eq null || writingProject.projectIntroduceVideo eq ''}">
			
							<input type="text" id="urlVideo" class="form-control" placeholder="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-label="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-describedby="urlBtn">
							<div class="input-group-append urlBtn-registry">
							  <button class="btn btn-outline-secondary" type="button" id="urlBtn">등록</button>
							</div>
							<div class="mt-3">
								<div id="toAppendIframeDiv" class="form-group"></div>
							</div>
							<input type="hidden" id="projectIntroduceVideoInput" name="projectIntroduceVideo">
						</c:when>
						
						<c:when test="${writingProject.projectIntroduceVideo ne null || writingProject.projectIntroduceVideo ne ''}">
							
							<input type="text" id="urlVideo" value="${writingProject.projectIntroduceVideo }" disabled  class="form-control" placeholder="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-label="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-describedby="urlBtn">
							<div class="input-group-append urlBtn-registry">
							  <button class="btn btn-outline-secondary" type="button" id="urlBtn" disabled>등록</button>
							</div>
							<div class='input-group-append urlBtn-remove'>
								<a class='btn fas fa-times fa-2x' type='button' id='urlBtn'></a>
							</div>
							<div class="m-4">
								<div id="toAppendIframeDiv" class="form-group">
									${writingProject.projectIntroduceVideo }
								</div>
								<input type="hidden" id="projectIntroduceVideoInput"   name="projectIntroduceVideo" value="${writingProject.projectIntroduceVideo }">
							</div>
						
						</c:when>
					</c:choose>
				</div>

		  </div>
		  
		  <div class="tab-pane fade mt-2 mb-3" id="nav-images" role="tabpanel" aria-labelledby="nav-images-tab">
		  
				<!-- projectIntroduceImage -->
				<c:choose>
					<c:when test="${projectIntroduceImageList eq null}">
					
					
						<script>
			            	
			            	// 일단 1. 버튼 눌렸을시
			            	// <div class="select_introduce_img"><img src="" /></div> 코드 추가되게 하기
							const no = 1;
			            	$(document).on("change","#projectIntroduceImage", function(){
			            		alert("감지감지");
			            		$("#projectIntroduceImageUl").append(
			            				"<li id='projectIntroduceImage" + no + "'"
			            				+ " onclick='$(" + "'#projectIntroduceImage" + no + "').remove();'>"
			            				+ "<div class='select_introduce_img m-3'><img src='' /></div></li>");

			            	});
			            	$(document).on("change","#projectIntroduceImage", function(){
			            		alert("감지감지2");
								if(this.files && this.files[0]){
				           			var reader = new FileReader;
				           			reader.onload = function(data){
				           				$("#projectIntroduceImage${no} .select_introduce_img img").attr("src", data.target.result).width(400);
				           			}; 
				           			reader.readAsDataURL(this.files[0]);
				           			no++;
				           		}
			            	
					    </script>
					
					
					
						<input type="file" name="projectIntroduceImageUpload"
							class="form-control-file select-project-image"
							id="projectIntroduceImage">
						<hr>
			           	<ul id="projectIntroduceImageUl">
						</ul>
			                
					</c:when>
					
					<c:when test="${projectIntroduceImageList ne null}">
						<input type="file" name="projectIntroduceImageUpload" 
								class="form-control-file select-project-image"
								id="projectIntroduceImage">
						<ul id="projectIntroduceImageUl">
				
							<c:forEach var="projectIntroduceImage" items="${projectIntroduceImageList }" varStatus="step">
							
								<input type="hidden" name="projectIntroduceImageUpload" value="${projectIntroduceImage.projectIntroduceImage }">
								
								<li id="projectIntroduceImageLi" value="">
									<div class="select_introduce_img m-3">
										<img style="width: 400px; height: auto;" src="${projectIntroduceImage.projectIntroduceImage }" />
									</div>
								</li>
								
							</c:forEach>
							
						</ul>
					</c:when>
				</c:choose>
		  </div>
		</div>		
	</article>
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
		<c:when test="${writingProject.projectStory eq null }">
			<textarea class="mt-1" name="projectStory" class="form-control" id="editor" rows="20">
			</textarea>
		</c:when>
		<c:when test="${writingProject.projectStory ne null }">
			<textarea class="mt-1" name="projectStory" class="form-control" id="editor" rows="20">${writingProject.projectStory}</textarea>
		</c:when>
	</c:choose>
	
	

</div>

<script>
	
	
	$(function(){
		
		CKEDITOR.replace('editor');
		
	})
	
</script>











