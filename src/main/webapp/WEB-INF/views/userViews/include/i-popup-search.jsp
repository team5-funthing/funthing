<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- 검색 폼 -->
	<form action="getSearchKeywordList.udo" method="GET" id="search-popup"
		class="white-popup-block mfp-hide">
		<div class="search_popup_box">
			<div class="popup_inner ">
			
				<div class="row d-flex justify-content-center ">
				
					<div class="form-group w-75">
						<div class="input-group">
							<input type="text" class="form-control" name="searchKeywordStr"
								placeholder='찾으시는 프로젝트가 있으신가요?' onfocus="this.placeholder = ''"
								onblur="this.placeholder = '검색어를 입력해 주세요.'">
							<div class="input-group-append">
								<button
									onclick="document.getElementById('search-popup').submit()"
									class="btn" type="button">
									<i class="ti-search"></i>
								</button>
							</div>
						</div>
						<hr>
					</div>
					
				</div>
				<div class="row" style="height: 480px;">
					<div class="col-7">
						
						<div class="row">
							<div class="col-2">
							</div>
							<div class="col-8 d-flex justify-content-center">
								<div class="h5 pt-1 pb-2 mb-2">관련 검색어</div>
							</div>
							<div class="col-2">
							</div>
						</div>
						<div class="row">
							<div class="col-3">
							</div>
							<div class="col-8 justify-content-center" id="suggestList">

							</div>
							<div class="col-1">
							</div>
						</div>
					</div>
					<div class="col-4 d-flex flex-column bd-highlight mb-3"
						style="border-left-style: solid; border-left-color: whitesmoke;">
						<div class="row">
							<div class="col-1">
							</div>
							<div class="col-11 d-flex justify-content-center">
								<div class="h5 ml-2 mb-4">인기 검색어</div>
							</div>
						</div>
						<div class="row">
							<div class="col-2">
							</div>
							<div class="col-11">
								<ul id="keywordFiveList" class="list-group list-group-flush flex-column bd-highlight">
										
								
								</ul>
							</div>
						</div>
	
						
					</div>
				</div>
			</div>
		</div>
	</form>
	
<script>


	$(document)
			.on(
					"change keyup",
					"input[name='searchKeywordStr']",
					function() {

						var jsonData = $("form[id='search-popup']")
								.serializeObject();

						$
								.ajax({
									url : "getSearchKeyword.udo",
									type : "get",
									data : jsonData,
									contentType : "application/json",
									success : function(data) {
										$("#suggestList").empty();
										console.log(data);
										var result = JSON.parse(data);
										console.log(result);

										if (result) {
											for (var i = 0; i < 10; i++) {
												$("#suggestList")
														.append(
																"<a href='projectDetails.udo?projectNo="
																		+ result[i].projectNo
																		+ "'>"
																		+ result[i].projectTitle
																		+ "</a>"
																		+ "<br>");

											}
											for (var i = 0; i < result.length; i++) {
												$("#suggestList")
														.append(
																"<input type='hidden' name='projectNoList' value='"+result[i].projectNo+"'> ");

											}
										}

									},
									error : function(errorThrown) {
										alert(errorThrown.statusText);
									}
								});

					});
</script>
    <!-- 검색폼 end -->