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
			//'추가하기' 버튼을 누르면 모든 입력하는 곳들을 초기화 해준다.
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
			
			//리워드 선택 옵션조건에 따라서 input태그를 추가하는 부분이다.
			$("select[name=rewardOption]").click(function(){
				option = $("#categorySelectBox").val();
				console.log(option);
				if(option === "옵션 없음"){
					//'옵션없음'을 선택한 경우 '옵션조건 드롭다운 바' 밑의 공간을 비운다.
					$("#appendTag").empty();
					$("#appendBtn").empty();
				}else if(option === "선택 옵션"){			
					//'선택옵션'을 선택한 경우 '옵션조건 드롭다운 바' 밑의 공간을 비운후에 '항목','값'을 입력하는 공간을 만든다.
					$("#appendTag").empty();
					$("#appendBtn").empty();
					$("#appendTag").append(appendTag);
					$("#appendBtn").append(appendAddBtn);
					//'추가'버튼을 누를때 마다 새로 입력할 수 있는 창을 만든다.
					$(".add").click(function(){
						$("#appendTag").append(appendTag);
						return;
					});
				}else if(option === '직접 입력 옵션'){
					//'옵션없음'을 선택한 경우 '옵션조건 드롭다운 바' 밑의 공간을 비운후 textarea입력창을 추가한다.
					$("#appendTag").empty();
					$("#appendBtn").empty();
					$("#appendTag").append("<textarea name='rewardoptionvalue' rows='4' cols='40'></textarea>");
					return;
				}
			});
			$("li").click(function(){
				//해당 리워드의 편집링크 또는 칸을 누르면
				var index = $(this).attr('id');
				//해당 li태그의 id값(리워드 번호)을 저장한다.
				var sendData = {indexData : index};
				//ajax로 보내기 위해서 key:value형태로 만들어준다.
				$.ajax({
					//post방식으로 sendData를 getReward.udo주소를 요청하여 보낸다.
					type:"POST",
					url:"getReward.udo",
					data:sendData,
					success:function(data){
						//controller를 거쳐 jsp페이지로부터 받아온 데이터를 가지고 값을 처리한다.
						//JSON문자열을 javascript객체로 변환 후에 각입력창에 이전에 입력한 값을 세팅한다.
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
						$("select[name=rewardDay]").val(rewardVO.rewardDay).prop("selected",true);
						$("select[name=rewardMonth]").val(rewardVO.rewardMonth).prop("selected",true);

						$("#appendTag").empty();
						$("#appendBtn").empty();
						$("#appendBtn").append(appendAddBtn);
						//입력시에 설정한 선택 옵션들을 보여주는 부분이다.
						if(rewardVO.rewardOption=='옵션 없음'){
							$("#addOptionIndex").empty();
							$("#appendTag").empty();
							$("#appendBtn").empty();
						}else if(rewardVO.rewardOption=='선택 옵션'){
							$("#addOptionIndex").empty();
							$("#appendTag").empty();
							$("#appendBtn").empty();
							console.log(rewardVO.rewardOptionList.length);
							for(var i = 0;i<rewardVO.rewardOptionList.length;i++){
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
							$("#addOptionIndex").empty();
							$("#appendTag").append("<textarea name='rewardoptionvalue' rows='4' cols='40'></textarea>");
							$("#addOptionIndex").append("<input type='hidden' id='rewardOptionNum' name='rewardOptionNo' size='3px' readonly>");
							$("#rewardOptionNum").val(rewardVO.rewardOptionList[0].rewardOptionNo);
							$("textarea[name=rewardoptionvalue]").val(rewardVO.rewardOptionList[0].rewardOptionValue);
						}
						//입력당시의 '배송조건'에 대한 입력값을 입력폼에 설정해주는 부분이다.
						if(rewardVO.shippingNeed=="배송 필요"){
							$("#primary-radio1").prop("checked", true);
							$("input[name=shippingFee]").show();
							$("input[name=shippingFee]").removeAttr("disabled");
							$(".aa").show();
						}else if(rewardVO.shippingNeed="배송 불필요"){
							$("#primary-radio3").prop("checked", true);
							$("input[name=shippingFee]").hide();
							$("input[name=shippingFee]").attr("disabled",true);
							$(".aa").hide();
						}
						$(".add").click(function(){
							$("#appendTag").append(appendTag);
							return;
						});
						
					}
				});
			});
			
			//리워딩 입력시에 배송필요 라디오버튼을 누르면 배송료 입력창을 보여준다.
			//리워딩 입력시에 배송불필요 라디오버튼을 누르면 배송료 입력창을 숨긴다.
			$("input:radio[name=shippingNeed]").click(function(){
				if($(this).val()=="배송 필요"){
					console.log('aaa');
					$("input[name=shippingFee]").show();
					$("input[name=shippingFee]").removeAttr("disabled");
					$(".aa").show();
				}else{
					$("input[name=shippingFee]").hide();
					$("input[name=shippingFee]").attr("disabled",true);
					$(".aa").hide();
				}
			});
			
		});
		
		
	</script>
   <!-- ${writingProject.projectNo}를 문자열에서 숫자로 형변환 -->
   <form action="insertReward.udo" method="post" id="reward-popup" class="white-popup-block mfp-hide">
   		
   		<input type="hidden" name="projectNo" value="${writingProject.projectNo}">

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
                   <!-- 배송조건 -->
                   <div class="row p-3">
                        <div class="col-4" style="font-weight: bold; color: darkslateblue;">배송조건</div>
                       <div class="col-7">
                           <div class="row d-flex align-items-center">
                               <div class="p-2 bd-highlight">
                                   <div class="form-check primary-radio ">
                                       <input class="form-check-input primary-radio checkbox" type="radio" name="shippingNeed"
                                           id="primary-radio1" value="배송 필요" checked>
                                       <label for="primary-radio1"></label>
                                   </div>
                               </div>
                           		<div class="d-flex p-2 bd-highlight">배송이 필요한 리워드입니다.</div>
                           </div>
                           <div class="row d-flex align-items-center" id="shipping">
                               <div class="col-3 aa" >
                                   <label for="formGroupExampleInput">배송료</label>
                               </div>
                               <!-- String인 shippingFee를 number로 바꾸어주는 코드 -->
                               <div class="col-7 p-1">
                                   <input type="text" name="shippingFee" class="form-control">
                               </div>
                               <div class="col-2 aa" >원</div>
                           </div>
                           <div class="row d-flex align-items-center">
                               <div class="p-2 bd-highlight">
                                   <div class="form-check primary-radio ">
                                       <input class="form-check-input primary-radio checkbox" type="radio" name="shippingNeed"
                                           id="primary-radio3" value="배송 불필요">
                                       <label for="primary-radio3"></label>
                                   </div>
                               </div>
                               <div class="d-flex p-2 bd-highlight">배송이 필요 없는 리워드입니다.</div>
                           </div>

                       </div>
                       <div class="col-1"></div>
                   </div>
                   <!-- 배송조건 끝 -->
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
                           <select class="rewardSendDate" name="rewardMonth" class="custom-select">
                               <option selected="selected">월별 선택</option>
                               <c:forEach var="i" begin="1" end="12" step="1">
                               		<option value="${i}월">${i} 월</option>
                               </c:forEach>
                           </select>
                       </div>
                       <div class="col-4">

                           <select class="rewardSendTime" name="rewardDay" class="custom-select">
                               <option selected="selected">일자 선택</option>
                               <c:forEach var="i" begin="1" end="31" step="1">
                               		<option value="${i}일">${i} 일</option>
                               </c:forEach>
                           </select>

                       </div>
                   </div>
                   <div class="row d-flex justify-content-end">
                   	   <div>
                           <input type="submit" formaction="updateReward.udo?projectNo=${projectNo}" value="수정">
                       </div>
                       <div>
                           <a id="cancleBtn" class="btn btn-lg btn-report-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                               href="javaScript:return(0);" >취소</a>
                       </div>
                       <div>
                           <a class="btn btn-lg btn-report-submit d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                               href="javaScript: return(0);" onclick="document.getElementById('reward-popup').submit();">등록하기</a>
                       </div>
                   </div>
               </div>   
           </div>
       </div>
   </form>
   <!-- ---------- -->
  