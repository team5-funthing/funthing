<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="h4" style="color: black; font-weight: bolder;">기본설정</div>

<div class="d-flex flex-column bd-highlight mb-3">

	<div class="p-2 bd-highlight">
	
		<div class="p-2 bd-highlight">
			<div class="input-group mb-1">
				<div class="form-group d-flex align-items-start flex-column bd-highlight mb-3">
				
					<div id="detail-mypage-profile-img" class="ml-5" style="background: #BDBDBD;">
	                    <img class="profile" src="${writingCreator.creatorProfileImage}">
	                </div>
	                
					<c:choose>
						<c:when test="${writingCreator.creatorProfileImage eq ''}">
							<input type="file" name="creatorUploadImage" onchange="ValidateSingleInput(this);"
								class="form-control-file select-project-image mt-5"
								id="creatorProfileImageFile">
	                        <div class="select_img"><img src="" /></div>
						</c:when>
						<c:when test="${writingCreator.creatorProfileImage ne ''}">
							<input type="hidden" name="creatorProfileImage" value="${writingCreator.creatorProfileImage}">
							<input type="file" name="creatorUploadImage" onchange="ValidateSingleInput(this);"
								class="form-control-file select-project-image mt-5"
								id="creatorProfileImageFile">
						</c:when>
					</c:choose>
					
					<script>
		            	$("#creatorProfileImageFile").change(function(){
		            		if(this.files && this.files[0]){
		            			var reader = new FileReader;
		            			reader.onload = function(data){
		            				$("#detail-mypage-profile-img img").attr("src", data.target.result).width(150);
		            			}
		            			reader.readAsDataURL(this.files[0]);
		            		}
		            	})
				    </script>
				    
				</div>
			</div>
		</div>


		<span>창작자 | 업체명</span> <input type="text" name="creator"
				value="${writingProject.creator }" class="form-control" readonly>
		</div>
		<div class="p-2 bd-highlight">
			<span>이메일</span> <input type="text" name="email"
				value="${writingProject.email }" class="form-control" readonly>
		</div>
		<div class="p-2 bd-highlight">
			<c:if test="${writingProject.status eq 'm'.charAt(0)}">
				<div>반려사유</div>
				<div style="color: black;">${writingProject.statusReplyMessage}</div>
			</c:if>
			<c:if test="${writingProject.status eq 'f'.charAt(0)}">
				<div>거부사유</div>
				<div style="color: black;">${writingProject.statusReplyMessage}</div>
			</c:if>
		</div>
		<div class="p-2 bd-highlight">
			<span>문의 전화번호</span> <input type="text" name="makerPhone"
				value="${writingCreator.makerPhone}"  class="form-control phone-number-check">
		</div>
		
		
		<div class="p-2 bd-highlight">
			<span>통장 사본*</span> 
			<c:choose>
				<c:when test="${writingCreator.businessFileLink eq ''}">
					<input type="file" name="businessUploadFile" onchange="ValidateSingleDocumentFileInput(this);"
						class="form-control-file select-project-image mt-2"
						id="creatorProfileImageFile">
	                <div id="existBusinessUpload" style="color: gray;">등록하신 통장사본이 없습니다.</div>
				</c:when>
				<c:when test="${writingCreator.businessFileLink ne ''}">
					<input type="hidden" name="businessFileLink" value="${writingCreator.businessFileLink}">
					<input type="file" name="businessUploadFile" onchange="ValidateSingleDocumentFileInput(this);"
						class="form-control-file mt-2"
						id="businessFileLink">
					<div id="existBusinessUpload" style="color: gray;">등록하신 통장사본이 있습니다.</div>
					
					

						
				</c:when>
			</c:choose>
        			<script>
                         $("#businessUpload").change(function(){
                            if(this.files && this.files[0]){
                           	 $("#existBusinessUpload").empty();
                            }
                         })
                   	</script>			
		</div>
		
		<div class="p-2 bd-highlight">
			<span>사업자 번호</span> <input type="text" name="businessNumber"
				value="${writingCreator.businessNumber}" 
				class="form-control">
		</div>
		<div class="p-2 bd-highlight">
			<span>소재지</span> <input type="text" name="businessAddress"
				value="${writingCreator.businessAddress}" class="form-control">
		</div>


</div>

