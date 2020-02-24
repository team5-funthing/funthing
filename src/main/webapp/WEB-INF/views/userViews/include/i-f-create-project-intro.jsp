<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
<div class="h4" style="color: black; font-weight: bolder;">프로젝트 소개</div>
<div class="d-flex flex-column bd-highlight mb-3">

	
	<div class="p-2 bd-highlight">
		<span>펀딩 목표 금액</span>
		<c:choose>
			<c:when test="${writingProject.goalMoney eq null}">
				<input type="text" name="goalMoney" value="0" placeholder="펀딩 목표 금액을 입력하세요."
					onfocus="this.placeholder = ''"
					onblur="this.placeholder = '펀딩 목표 금액을 입력하세요.'" class="single-input">
			</c:when>
			<c:when test="${writingProject.goalMoney ne null}">
				<input type="text" name="goalMoney"
					value="${writingProject.goalMoney }" placeholder="펀딩 목표 금액을 입력하세요."
					onfocus="this.placeholder = ''"
					onblur="this.placeholder = '펀딩 목표 금액을 입력하세요.'" class="single-input">
			</c:when>
		</c:choose>

	</div>
	
	<div class="p-2 bd-highlight">
		<span>프로젝트 제목</span>
		<c:choose>
			<c:when test="${writingProject.projectTitle eq null}">
				<input type="text" name="projectTitle"
					placeholder="프로젝트 제목을 입력해주세요!" onfocus="this.placeholder = ''"
					onblur="this.placeholder = '프로젝트 제목을 입력해주세요!'" class="single-input">
			</c:when>
			<c:when test="${writingProject.projectTitle ne null}">
				<input type="text" name="projectTitle"
					value="${writingProject.projectTitle }"
					placeholder="프로젝트 제목을 입력해주세요!" onfocus="this.placeholder = ''"
					onblur="this.placeholder = '프로젝트 제목을 입력해주세요!'" class="single-input">
			</c:when>
		</c:choose>
	</div>
	
	<div class="p-2 bd-highlight">
		<span>프로젝트 소제목</span>
		<c:choose>
			<c:when test="${writingProject.projectSubTitle eq null}">
				<input type="text" name="projectSubTitle" placeholder="소제목을 입력해주세요!"
					onfocus="this.placeholder = ''" class="single-input">
			</c:when>
			<c:when test="${writingProject.projectSubTitle ne null}">
				<input type="text" name="projectSubTitle"
					value="${writingProject.projectSubTitle }"
					placeholder="소제목을 입력해주세요!" onfocus="this.placeholder = ''"
					class="single-input">
			</c:when>
		</c:choose>
	</div>
	
	<div class="p-2 bd-highlight">
		<span>프로젝트 대표 이미지</span>
		<div class="input-group mb-3">
			<div class="form-group">
				<label for="projectMainImageFile">대표 이미지 선택하기</label>
				<c:choose>
					<c:when test="${writingProject.projectMainImage eq ''}">
						<input type="file" name="uploadImage"
							class="form-control-file select-project-image"
							id="projectMainImageFile">
                        <hr>
                        <div class="select_img"><img src="" /></div>
					</c:when>
					<c:when test="${writingProject.projectMainImage ne ''}">
						<h4>이미지 바꾸기</h4>
						<input type="hidden" name="projectMainImage" value="${writingProject.projectMainImage }">
						<input type="file" name="uploadImage"
							class="form-control-file select-project-image"
							id="projectMainImageFile">
						<div class="select_img m-3"><img style="width: 500px; height: auto;" src="${writingProject.projectMainImage }" /></div>					
					</c:when>
				</c:choose>
				
				<script>
	            	$("#projectMainImageFile").change(function(){
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
		</div>
	</div>
	<div class="p-2 bd-highlight">
		<span>프로젝트 분류[카테고리]</span>
			
			<script>
				$(document).ready(function(){		
					$("#categorySelectBox").val("${writingProject.category }").prop("selected", true);
				});
			</script>
			<select id="categorySelectBox" name="category" class="custom-select" >
				<option value="book">도서</option>
				<option value="publish">출판</option>
				<option value="performance">공연</option>
				<option value="art">예술</option>
			</select>
	</div>
	<div class="p-2 bd-highlight">
		<span>프로젝트 기간 설정</span>
		<div class="row">
			<div class="col-xl-6">
	            <!-- <input name="startDate" id="start" placeholder="펀딩 시작 날짜"> -->
	        </div>
	        <div class="col-xl-6">
	            <!-- <input name="endDate" id="end" placeholder="펀딩 종료 날짜"> -->
	        </div>
        </div>
	</div>
	<div class="p-2 bd-highlight">
	
		 <script>
		 
		        $(function (){
		        	const no = 1;
		        	$("#addKeywordBtn").removeAttr("href");
		        	$("#addKeywordBtn").click(function(){
			        	var toAddKeyword = $("input[name=projectKeyword]").val();
			        	if(toAddKeyword != ""){
			        		$("#addedKeywords").append(
			        				"<li id='keyword" + no + "' class='btn-lg btn-bd-keyword d-none d-lg-inline-block m-1' onclick='$('li').remove('#keyword" + no + "')'>" + '#' + toAddKeyword + "<input type='hidden' name='keywords' value='" + '#' + toAddKeyword + "'></li>");
							no++
			        	}
		        	})
		        })
	         
		        $(function (){
		        	$(".addedKeyword").removeAttr("href")
		      
			    })
			    
		</script>
	
	
		<span>검색용 태그* </span>
		<div class="row d-flex align-items-center mb-5">
		
			<div class="col-xl-6">
				<input type="text" id="keyword" name="projectKeyword" placeholder="#검색 키워드를 입력해주세요." onfocus="this.placeholder = ''" class="single-input">
			</div>
			
			<a href="#" id="addKeywordBtn"><i class="fas fa-plus fa-2x"></i></a>
			
		</div>
		

																									<!--     	${fn:length(list) }		    -->
		<div class="row d-flex align-content-between flex-wrap">
			<div class="col-xl-12 d-flex bd-highlight mb-3">
				<ul id="addedKeywords">
				
					<c:set var="tag" value="#"/>
					<c:set var="keywordId" value="keyword"/>
					
					<c:choose>
					
						<c:when test="${addedKeywordList eq null }">
						</c:when>
						<c:when test="${addedKeywordList ne null }">
						
							<c:forEach var="addedKeyword" items="${addedKeywordList }" varStatus="step">
							
								<li id="${keywordId }${step.count}" class="btn-lg btn-bd-keyword d-none d-lg-inline-block m-1" onclick=" $('li').remove('#${keywordId }${step.count}')">
									<a href="#" class="addedKeyword">${tag }${addedKeyword.keyword }</a>
									<input type="hidden" name="keywords" value="${tag }${addedKeyword.keyword }">
								</li>
								
							</c:forEach>
							
						</c:when>
					</c:choose>

				</ul>
			</div>
		</div>
		
	</div>
</div>