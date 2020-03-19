<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="h4" style="color: black; font-weight: bolder;">리워드 설계</div>

			<script>
				$(document).ready(function(){
					
					var shippingFee = ${writingProject.shippingFee }
					
					if( shippingFee == 0){
						$("#deliverySelectBox").val("noNeedForDelivery").prop("selected", true);
						$("#shippingFeeInput").css("display", "none");
						
					}else{
						$("#deliverySelectBox").val("NeedForDelivery").prop("selected", true);
					}
				});
			</script>


<div class="p-2 bd-highlight">

	<div class="col w-75">
		<div class="col align-self-center">
			<div class="mt-30">
				<div class="form-group">
					<label for="deliverySelectBox"><h5>배송비</h5></label>
					<p>배송이 필요한 리워드일 경우 배송비를 입력하여 주시기 바랍니다.</p>
					<select class="form-control form-control-lg" id="deliverySelectBox">
						<option value="noNeedForDelivery">배송이 필요 없는 리워드 입니다.</option>
						<option value="NeedForDelivery">배송이 필요한 리워드 입니다.</option>
					</select>
				</div>
			</div>
			<div class="mt-30" id="shippingFeeInput">
		          <input name="shippingFee" id="shippingFee" class="form-control form-control-lg inputMoney" type="text"
		             placeholder="배송비를 입력해 주세요." onfocus="this.placeholder = ''"
		             onblur="this.placeholder = '배송비를 입력해 주세요.'" value = "${writingProject.shippingFee }"
		             class="single-input" required>
		          <p id="creatorInputMsg" style="color:navy; font-weight: 600"></p>
		    </div>
		</div>
		
	</div>
	
    <script>
    	$(document).on("change", "#deliverySelectBox", function(){
    		
    		var val = $(this).val();
    		
    		if(val == 'noNeedForDelivery'){
    			
    			$("#shippingFeeInput").css("display", "none");
    			$("#shippingFee").attr("value", "");
    			$("#shippingFee").attr("value", "0");
    			
    		}else{
    			
    			$("#shippingFeeInput").css("display", "");
    			
    			
    		}
    		
    	})
    </script>
	
	<a id="addBtn" class="popup-with-form btn btn-lg btn-spon-prj d-none d-lg-inline-block mt-3 ml-4 pr-5 pl-5 mb-2"
		href="#reward-popup">리워드 추가하기</a>

	<hr>
			
	<ul id="rewardUl">
		<c:choose>
			<c:when test="${rewardList eq null }">
			</c:when>
			<c:when test="${rewardList ne null }">
				<c:forEach var="addedReward" items="${rewardList}">
					<li id="${addedReward.rewardNo}">
						<input type="hidden" name="rewardNo" value="${addedReward.rewardNo}">
						<input type="hidden" name="projectNo" value="${addedReward.projectNo}">
						<div class="card m-4" style="width: 25rem;">
							<div class="card-body">
								<h5 class="price">${addedReward.rewardPrice}원</h5>
								<h6 class="rewardname">${addedReward.rewardName}</h6>
								<p class="rewardContent">${addedReward.rewardContent}</p>
								<a href="#reward-popup" class="popup-with-form editReward">편집</a>
								<a href="deleteReward.udo?projectNo=${writingProject.projectNo}&rewardNo=${addedReward.rewardNo}&creator=${writingCreator.creator}">삭제</a>
							</div>
						</div>
					</li>
				</c:forEach>
			</c:when>
		</c:choose>
	</ul>
	
</div>