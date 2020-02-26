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
		<!-- 
		<div class="p-2 bd-highlight">
			<span>창작자 프로필 사진</span> 
			
			<div class="input-group mb-1">
				<div class="form-group">
					<label for="creatorProfileImage">대표 이미지 선택하기</label>
					<c:choose>
						<c:when test="${writingCreator.creatorProfileImage eq ''}">
							<input type="file" name="creatorUploadImage"
								class="form-control-file select-project-image"
								id="creatorUploadImage">
	                        <div class="select_img"><img src="" /></div>
						</c:when>
						<c:when test="${writingCreator.creatorUploadImage ne ''}">
							<input type="hidden" name="creatorProfileImage" value="${writingCreator.creatorUploadImage }">
							<input type="file" name="creatorUploadImage"
								class="form-control-file select-project-image"
								id="creatorProfileImage">
							<div class="select_img m-3"><img style="width: 200px; height: auto;" src="${writingCreator.creatorUploadImage }" /></div>					
						</c:when>
					</c:choose>
					
					<script>
		            	$("#creatorProfileImage").change(function(){
		            		if(this.files && this.files[0]){
		            			var reader = new FileReader;
		            			reader.onload = function(data){
		            				$(".select_img img").attr("src", data.target.result).width(200);
		            			}
		            			reader.readAsDataURL(this.files[0]);
		            		}
		            	})
				    </script>
				</div>
			</div>			
		
		</div>
		<div class="p-2 bd-highlight">
			<span>문의 전화번호*</span> 
			<input type="text" name="makerPhone" class="single-input">
		</div>
		<div class="p-2 bd-highlight">
			<span>사업자번호</span> 
			<input type="text" name="businessNumber" class="single-input">
		</div>
		<div class="p-2 bd-highlight">
			<span>소재지</span> 
			<input type="text" name="businessAddress" class="single-input">
		</div>
		<div class="p-2 bd-highlight">
			<span>통장 사본*</span> 
			<div class="input-group mb-1">
				<div class="form-group">
					<label for="businessFileLink">대표 이미지 선택하기</label>
					<c:choose>
						<c:when test="${writingCreator.businessFileLink eq ''}">
							<input type="file" name="businessUploadFile"
								class="form-control-file select-project-image"
								id="businessUploadFile">
	                        <div class="select_img"><img src="" /></div>
						</c:when>
						<c:when test="${writingCreator.creatorUploadImage ne ''}">
							<input type="hidden" name="businessFileLink" value="${writingCreator.businessFileLink }">
							<input type="file" name="businessFileLink"
								class="form-control-file select-project-image"
								id="businessUploadFile">
							<div class="select_img m-3"><img style="width: 200px; height: auto;" src="${writingCreator.businessFileLink }" /></div>					
						</c:when>
					</c:choose>
					
					<script>
		            	$("#businessUploadFile").change(function(){
		            		if(this.files && this.files[0]){
		            			var reader = new FileReader;
		            			reader.onload = function(data){
		            				$(".select_img img").attr("src", data.target.result).width(200);
		            			}
		            			reader.readAsDataURL(this.files[0]);
		            		}
		            	})
				    </script>
				</div>
			</div>	
		</div>
		-->

</div>

