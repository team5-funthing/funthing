<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!-- 리워드 추가하기 폼  -->
	<script type="text/javascript">
		var rewardNo  =2;
	//	alert(writingProject.projectNo);
	//	var tt = writingProject.projectNo;
		
		//f-create-project-reward의 
	//	if(rewardNo !== null){
	//		alert("실행된당.");
	//	}
		$(document).ready(function(){
			var option;
			var appendTag = "<br> 항목  : <input type='text' name='rewardoptionkey' size='4px'>&nbsp;&nbsp;&nbsp; 값 : <input type='text' name='rewardoptionvalue' size='4px'>";
			var appendAddBtn = "<input type='button' value='추가' class='add'>";
			console.log(appendTag);
			$("#addBtn").click(function(){
				$("#rewardNum").remove();
				$("#addOptionIndex").remove();
				$("input[name=rewardPrice]").val("");
				$("input[name=rewardName]").val("");
				$("textarea[name=rewardContent]").val("");
				$("#categorySelectBox").val("옵션 선택").prop("selected",true);
				$("input[name=shippingFee]").val("");
				$("input[name=rewardAmount]").val("");
				$("input[name=rewardNo]").val("");
				$("#appendTag").empty();
				$("#appendBtn").empty();	
			});
			$("select[name=rewardOption]").click(function(){
				option = $("#categorySelectBox").val();
				console.log(option);
				if(option === "옵션 없음"){
					$("#appendTag").empty();
					$("#appendBtn").empty();
				}else if(option === "선택 옵션"){
					$("#appendTag").empty();
					$("#appendBtn").empty();
					$("#appendTag").append(appendTag);
					$("#appendBtn").append(appendAddBtn);
					$(".add").click(function(){
						$("#appendTag").append(appendTag);
						return;
					});
				}else if(option === '직접 입력 옵션'){
					$("#appendTag").empty();
					$("#appendBtn").empty();
					$("#appendTag").append("<textarea name='rewardoptionvalue' rows='4' cols='40'></textarea>");
					return;
				}
			});
			$("li").click(function(){
				var index = $(this).attr('id');
				var sendData = {indexData : index};
				$.ajax({
					type:"POST",
					url:"getReward.udo",
					data:sendData,
					success:function(data){
						$("<input type='hidden' id='rewardNum' name='rewardNo' readonly>").insertBefore("input[name=rewardPrice]");
						var rewardVO = JSON.parse(data);
						console.log(rewardVO);
						$("input[name=rewardPrice]").val(rewardVO.rewardPrice);
						$("input[name=rewardName]").val(rewardVO.rewardName);
						$("textarea[name=rewardContent]").val(rewardVO.rewardContent);
						$("#categorySelectBox").val(rewardVO.rewardOption).prop("selected",true);
						$("input[name=shippingFee]").val(rewardVO.shippingFee);
						$("input[name=rewardAmount]").val(rewardVO.rewardAmount);
						$("input[name=rewardNo]").val(rewardVO.rewardNo);

						$("#appendTag").empty();
						$("#appendBtn").empty();
						$("#appendBtn").append(appendAddBtn);
						if(rewardVO.rewardOption=='선택 옵션'){
							$("#appendTag").empty();
							$("#appendBtn").empty();
							for(var i = 0;i<rewardVO.rewardOptionList.length;i++){
								$("#addOptionIndex").empty();
								$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum"+i+"' name='rewardOptionNo' size='3px' readonly>");
								$("#appendTag").append("<br> 항목  : <input type='text' id='optionkey"+i+"' name='rewardoptionkey' size='4px'>&nbsp;&nbsp;&nbsp; 값 : <input type='text' id='optionvalue"+i+"' name='rewardoptionvalue' size='4px'>");
								$("#rewardOptionNum"+i+"").val(rewardVO.rewardOptionList[i].rewardOptionNo);
								$("#optionkey"+i+"").val(rewardVO.rewardOptionList[i].rewardOptionKey);
								$("#optionvalue"+i+"").val(rewardVO.rewardOptionList[i].rewardOptionValue);
							}
							$("#appendBtn").append(appendAddBtn);
						}else if(rewardVO.rewardOption=='직접 입력 옵션'){
							$("#appendTag").empty();
							$("#appendBtn").empty();
							$("#appendTag").append("<textarea name='rewardoptionvalue' rows='4' cols='40'></textarea>");
							$("#addOptionIndex").empty();
							$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum' name='rewardOptionNo' size='3px' readonly>");
							$("#rewardOptionNum").val(rewardVO.rewardOptionList[0].rewardOptionNo);
							$("textarea[name=rewardoptionvalue]").val(rewardVO.rewardOptionList[0].rewardOptionValue);
						}
						$(".add").click(function(){
							$("#appendTag").append(appendTag);
							return;
						});
					},
					error:function(){
						alert('실패');
					}
				});
			});
		});
		
		
	</script>
   <!-- ${writingProject.projectNo}를 문자열에서 숫자로 형변환 -->
   <form action="insertReward.udo" method="post" id="reward-popup" class="white-popup-block mfp-hide">
   		<input type="hidden" name="projectNo" value="${projectNo}">

       	<div class="addReward_popup_box">
           <div class="popup_inner">
               <div class="container">
                   <div class="row p-2">
                       <div class="col-1"></div>
                       <div class="col-7 h3" style="color:black; font-weight: bold;">
                           	리워드 추가 
                       </div>
                       <div class="col-3"></div>
                       <div class="col-1"></div>
                   </div>
		
                   <div class="row p-3">
                       <div class="col-4" style="font-weight: bold; color: darkslateblue">금액</div>
                       <div class="col-5">                
                           <input type="text" name="rewardPrice" class="form-control">
                       </div>
                       <div class="col-2">원</div>
                       <div class="col-1"></div>
                   </div>
                   <div class="row p-3">
                       <div class="col-4" style="font-weight: bold; color: darkslateblue">리워드이름</div>
                       <div class="col-7">
                           <input type="text" name="rewardName" class="form-control" id="formGroupExampleInput"
                           placeholder="Example input placeholder">
                       </div>
                       <div class="col-1"></div>
                   </div>
                   <div class="row p-3">
                       <div class="col-4" style="font-weight: bold; color: darkslateblue">상세설명</div>
                       <div class="col-7">
                           <textarea class="form-control" name="rewardContent" id="exampleFormControlTextarea1" rows="3"></textarea>
                       </div>
                       <div class="col-1"></div>
                   </div>
                   <div class="row p-3">
                       <div class="col-4" style="font-weight: bold; color: darkslateblue">옵션조건</div>
                       <div class="col-7">
                       		<div id="addOptionIndex"></div>
                           <select id="categorySelectBox" name="rewardOption" class="custom-select">
                               <option value="옵션 선택" selected="selected">옵션 선택</option>
                               <option value="옵션 없음">옵션 없음</option>
                               <option value="선택 옵션">선택 옵션(사이즈, 색상 등)</option>
                               <option value="직접 입력 옵션">직접 입력 옵션(각인, 메시지 등)</option>
                           </select>
                           <div id="appendTag"></div>
                           <div id="appendBtn"></div>
                       </div>
                       <div class="col-1"></div>
                   </div>
                   <div class="row p-3">
                        <div class="col-4" style="font-weight: bold; color: darkslateblue;">배송조건</div>
                       <div class="col-7">
                           <div class="row d-flex align-items-center">
                               <div class="p-2 bd-highlight">
                                   <div class="form-check primary-radio ">
                                       <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                           id="primary-radio1" value="option1" checked>
                                       <label for="primary-radio1"></label>
                                   </div>
                               </div>
                           <div class="d-flex p-2 bd-highlight">배송이 필요한 리워드입니다.</div>
                           </div>
                           <div class="row d-flex align-items-center">
                               <div class="col-3">
                                   <label for="formGroupExampleInput">배송료</label>
                               </div>
                               <!-- String인 shippingFee를 number로 바꾸어주는 코드 -->
                               <div class="col-7 p-1">
                                   <input type="text" name="shippingFee" class="form-control">
                               </div>
                               <div class="col-2">원</div>
                           </div>
                           <div class="row d-flex align-items-center">
                               <div class="p-2 bd-highlight">
                                   <div class="form-check primary-radio ">
                                       <input class="form-check-input primary-radio checkbox" type="radio" name="exampleRadios"
                                           id="primary-radio3" value="option1" checked>
                                       <label for="primary-radio3"></label>
                                   </div>
                               </div>
                               <div class="d-flex p-2 bd-highlight">배송이 필요 없는 리워드입니다.</div>
                           </div>

                       </div>
                       <div class="col-1"></div>
                   </div>
                   <div class="row p-3">
                        <div class="col-4" style="font-weight: bold; color: darkslateblue">제한수량</div>
                       <div class="col-5">
                           <input type="text" name="rewardAmount" class="form-control">
                       </div>
                       <div class="col-2">개</div>
                       <div class="col-1"></div>
                   </div>
                   <div class="row p-3">
                        <div class="col-4" style="font-weight: bold; color: darkslateblue">발송시작일</div>
                        <div class="col-4 pr-1">
                           <select class="rewardSendDate" name="category" class="custom-select">
                               <option selected="selected">연도/월</option>
                               <option value=""></option>
                               <option value=""></option>
                               <option value=""></option>
                           </select>
                       </div>
                       <div class="col-4">

                           <select class="rewardSendTime" name="category" class="custom-select">
                               <option selected="selected">시기</option>
                               <option value=""></option>
                               <option value=""></option>
                               <option value=""></option>
                           </select>

                       </div>
                   </div>
                   <div class="row d-flex justify-content-end">
                   	   <div>
                           <input type="submit" formaction="updateReward.udo" value="수정" >
                       </div>
                       <div>
                           <a id="cancleBtn" class="btn btn-lg btn-report-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                               href="showReward.udo?projectNo=${projectNo}" >취소</a>
                       </div>
                       <div>
                           <a class="btn btn-lg btn-report-submit d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                               href="#" onclick="document.getElementById('reward-popup').submit();">등록하기</a>
                       </div>
                   </div>
               </div>   
           </div>
       </div>
   </form>
   <!-- ---------- -->
  