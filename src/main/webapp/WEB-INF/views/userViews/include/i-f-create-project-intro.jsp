<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<div class="h4" style="color: black; font-weight: bolder;">프로젝트 소개</div>
<div class="d-flex flex-column bd-highlight mb-3">
	
	<div class="p-2 bd-highlight">
		<span>펀딩 목표 금액</span>
		<div class="row d-flex align-items-center">
			<div class="col-4">
				<c:choose>
					<c:when test="${writingProject.goalMoney eq null}">
						<input type="text" id="goalMoney" name="goalMoney" value="0" placeholder="펀딩 목표 금액을 입력하세요."
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '펀딩 목표 금액을 입력하세요.'" 
							class="single-input">
						<div id="goalMoneyCheck"></div>
					</c:when>
					<c:when test="${writingProject.goalMoney ne null}">
						<input type="text" id="goalMoney" name="goalMoney"
							value="${writingProject.goalMoney }" placeholder="펀딩 목표 금액을 입력하세요."
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '펀딩 목표 금액을 입력하세요.'" class="single-input">
					</c:when>
				</c:choose>
			</div>
			<div class="col-8">
				<div class="h6">원</div>
			</div>
			
			
			<script>
			
				//goalMoney
				var replaceNotInt = /[^0-9]/gi;
	
				$(document).ready(function(){
					$("#goalMoney").on("focusout", function(){
						var x = $(this).val();
						if(x.length > 0){
							if(x.match(replaceNotInt)){
								x = x.replace(replaceNotInt, "");
							}
							$(this).val(x);
						}
					}).on("keyup", function(){
						$(this).val($(this).val().replace(replaceNotInt, ""));
					});
				});
			</script>
			
		</div>
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
					onblur="this.placeholder = '소제목을 입력해주세요!'" class="single-input">
			</c:when>
			<c:when test="${writingProject.projectSubTitle ne null}">
				<input type="text" name="projectSubTitle"
					value="${writingProject.projectSubTitle }"
					placeholder="소제목을 입력해주세요!" onblur="this.placeholder = '소제목을 입력해주세요!'"
					class="single-input">
			</c:when>
		</c:choose>
	</div>
	
	<div class="p-2 bd-highlight">
		<span>프로젝트 대표 이미지</span>
		<div class="input-group mb-1">
			<div class="form-group">
				<label for="projectMainImageFile">대표 이미지 선택하기</label>
				<c:choose>
					<c:when test="${writingProject.projectMainImage eq ''}">
						<input type="file" name="uploadImage"
							class="form-control-file select-project-image"
							id="projectMainImageFile">
                        <div class="select_img"><img src="" /></div>
					</c:when>
					<c:when test="${writingProject.projectMainImage ne ''}">
						<input type="hidden" name="projectMainImage" value="${writingProject.projectMainImage }">
						<input type="file" name="uploadImage"
							class="form-control-file select-project-image"
							id="projectMainImageFile">
						<div class="select_img m-3"><img style="width: 300px; height: auto;" src="${writingProject.projectMainImage }" /></div>					
					</c:when>
				</c:choose>
				
				<script>
	            	$("#projectMainImageFile").change(function(){
	            		if(this.files && this.files[0]){
	            			var reader = new FileReader;
	            			reader.onload = function(data){
	            				$(".select_img img").attr("src", data.target.result).width(300);
	            			}
	            			reader.readAsDataURL(this.files[0]);
	            		}
	            	})
			    </script>
			    
			</div>
		</div>
	</div>
	
	<div class="p-2 bd-highlight mb-2">
		<span>프로젝트 분류[카테고리]</span>
			
			<script>
				$(document).ready(function(){		
					$("#categorySelectBox").val("${writingProject.category }").prop("selected", true);
				});
			</script>
			<select id="categorySelectBox" name="category" class="custom-select" >
				<!-- <option value="book">도서</option>
				<option value="publish">출판</option>
				<option value="performance">공연</option>
				<option value="art">예술</option> -->
				<c:forEach var="category" items="${categoryList}">
					<option value="${category.categoryName}">${category.categoryName}</option>
				</c:forEach>
			</select>
	</div>
	
	<div class="p-2 bd-highlight mb-2">
		<span>프로젝트 기간 설정</span>
		<div class="row">
			<c:choose>
				<c:when test="${writingProject.endDate eq null }">
					<div class="col-xl-6">
			            <input type="text" name="endDate" id="endDate" class="datepicker-here" data-language='ko' data-position='right top' required>
			            <i class="far fa-calendar-alt"></i>
			            <p id="afterSelectDate"></p>				
	        		</div>
				</c:when>
				<c:when test="${writingProject.endDate ne null }">
					<div class="col-xl-6">

						<!--<fmt:formatDate var="getEndDate" pattern="yyyy-MM-dd" value="${writingProject.endDate }" />-->
						
						<input type="text" id="endDate" value="${writingProject.endDate}" class="datepicker-here" data-language='ko' data-position='right top'>
						<p id="afterSelectDate">
							펀딩 결제일 &nbsp;
							<strong><span style="color: #2980b9">${writingProject.endDate }</span></strong>
							펀딩이 성공 종료 된 후 결제가 +4 영업일 동안 진행됩니다.<br /> 정산금 지급예정일 보름에서 정산은 최대
							한달&nbsp;이내에 시작될 예정이며, 정산금 지급까지는 종료일 기준 최대 +20 영업일이 소요됩니다.&nbsp;
						</p>
					</div>
				</c:when>
			</c:choose>

        </div>
	</div>
	
	<script>
	
		$("#endDate").on("change", function(){
			var end = $("#endDate").val();
			$("#endDate").attr("name", "endDate");
			$("#afterSelectDate").empty();
			$("#afterSelectDate").append(
					"펀딩 결제일 &nbsp;<strong><span style='color:#2980b9'> "+ end +"</span></strong>"
					+ "펀딩이 성공 종료 된 후 결제가 +4 영업일 동안 진행됩니다.<br />"
					+ "정산금 지급예정일 보름에서 정산은 최대 한달&nbsp;이내에 시작될 예정이며, 정산금 지급까지는 종료일 기준 최대 +20 영업일이 소요됩니다.&nbsp");
		});
		
		
		
	</script>
	
	<div class="p-2 bd-highlight mb-2">
	
		 <script>
			 
			    $(document).on("click","#addKeywordBtn",function(){
			    	const no = 1;
		        	var toAddKeyword = $("input[name=projectKeyword]").val();
		        	if(toAddKeyword != ""){
		        		$("#addedKeywords").append(
		        				"<li id='keyword" + no + "' class='btn-lg btn-bd-keyword d-none d-lg-inline-block m-1' onclick='$('li#keyword" + no + "').remove()'>" + '#' + toAddKeyword + "<input type='hidden' name='keywords' value='" + '#' + toAddKeyword + "'></li>");
						no++
		        	}
		        	
		       	 });
	         
		         $(function (){
		        	 $(".addedKeyword").removeAttr("href")
		      
			     })
			    
			    
		</script>
	
	
		<span>검색용 태그*</span>
		<div class="row d-flex align-items-center mb-5">
		
			<div class="col-xl-6">
				<input type="text" id="keyword" name="projectKeyword" placeholder="#검색 키워드를 입력해주세요." onfocus="this.placeholder = ''" class="single-input">
			</div>
			
			<a href="javascript:void(0);" id="addKeywordBtn"><i class="fas fa-plus fa-2x"></i></a>
			
		</div>
		

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
									<a href="javascript:void(0);" class="addedKeyword">${tag }${addedKeyword.keyword }</a>
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