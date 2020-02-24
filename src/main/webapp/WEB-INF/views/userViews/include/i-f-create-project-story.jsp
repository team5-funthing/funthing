<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="h4" style="color: black; font-weight: bolder;">스토리 작성</div>
<div class="p-2 bd-highlight">
	<span>소개 컨텐츠 [영상]</span>

	<!-- ProjectVideo Youtube 영상 올리기 -->
	<div class="input-group mb-3">
		
		<c:choose>
			<c:when test="${writingProject.projectIntroduceVideo eq null || writingProject.projectIntroduceVideo eq ''}">
			
				<input type="text" id="urlVideo" class="form-control" placeholder="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-label="소개 영상으로 올리려는 영상 URL 주소를 입력하세요." aria-describedby="urlBtn">
				<div class="input-group-append urlBtn-registry">
				  <button class="btn btn-outline-secondary" type="button" id="urlBtn">등록</button>
				</div>
				<div class="m-4">
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
	
	<script>
		$(document).on("click","#urlBtn",function(){	
       		console.log("실행")
       		var sourceCode = $('#urlVideo').val();
       		
       		function replaceAll(sourceCode, oldChar, newChar){
       			return sourceCode.split(oldChar).join(newChar);
       		}
       	
       		sourceCode = replaceAll(sourceCode, '\"', "\'");
       		console.log(sourceCode);
       		
       		if(sourceCode != ""){
       			$("#toAppendIframeDiv").append(sourceCode);
       			$("#projectIntroduceVideoInput").attr("value", sourceCode);
       			
       			var removeUrlBtn = "<div class='input-group-append urlBtn-remove'><a class='btn fas fa-times fa-2x' type='button' id='urlBtn'></a></div>";
       			
       			$(".urlBtn-registry").after(removeUrlBtn);
       			$("#urlBtn").attr("disabled", true);
       			$("#urlVideo").attr("disabled", true);
       			
       			$("iframe").attr("width", "640");
        		$("iframe").attr("heith", "360");
       			
       		}
       	});
       	
		
       	$(document).on("click",".urlBtn-remove",function(){
       		$("#urlVideo").attr("value", "");
       		$("#projectIntroduceVideoInput").removeAttr("value");
       		$("#urlBtn").attr("disabled", false);
   			$("#urlVideo").attr("disabled", false);
   			$("#toAppendIframeDiv").empty();
   			$("div").remove(".urlBtn-remove"); // X 버튼 지우기
       	 });
       	
       	
       	$(function(){
       		$("iframe").load(function(){ //iframe 컨텐츠가 로드 된 후에 호출됩니다.
       			$("iframe").attr("width", "640");
        		$("iframe").attr("heith", "360");
       		});
       	});
       	
    </script>
	
	
	
	
	<!-- projectIntroduceImage -->
	<c:choose>
		<c:when test="${projectIntroduceImage.projectIntroduceImage eq ''}">
			<input type="file" name="projectIntroduceImageUpload"
				class="form-control-file select-project-image"
				id="projectIntroduceImage">
                    <hr>
                    <div class="select_img"><img src="" /></div>
		</c:when>
		<c:when test="${projectIntroduceImage.projectIntroduceImage ne ''}">
			<input type="hidden" name="projectIntroduceImageUpload" value="${projectIntroduceImage.projectIntroduceImage }">
			
			<input type="file" name="projectIntroduceImageUpload"
				class="form-control-file select-project-image"
				id="projectIntroduceImage">
			<div class="select_introduce_img m-3"><img style="width: 250px; height: auto;" src="${projectIntroduceImage.projectIntroduceImage }" /></div>					
		</c:when>
	</c:choose>
	
	
	<script>
       	$("#projectIntroduceImage").change(function(){
       		if(this.files && this.files[0]){
       			var reader = new FileReader;
       			reader.onload = function(data){
       				$(".select_introduce_img img").attr("src", data.target.result).width(500);
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
		
		CKEDITOR.replace('editor')
		
	});
	
</script>











