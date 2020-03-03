<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 검색 폼 -->
    <form action="#" method="POST" id="search-popup" class="white-popup-block mfp-hide">
        <div class="popup_box ">
            <div class="popup_inner">
                <aside class="single_sidebar_widget search_widget">
                        <div class="form-group">
                            <div class="input-group mb-3">
                               	 	<input type="text" class="form-control" name="searchKeywordStr" placeholder='찾으시는 프로젝트가 있으신가요?'
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '검색어를 입력해 주세요.'">
                                <div class="input-group-append">
                                    <button onclick="document.getElementById('search-popup').submit()" class="btn" type="button"><i class="ti-search"></i></button>
                                </div>
                            </div>
                            <hr>
						
							<div class="row" id="suggest">
									<div><h4>관련검색어</h4></div>
									<div class="single_sidebar_widget post_category_widget" id="suggestList">
										
									</div>
							</div>
						</div>
                </aside>
            </div>
        </div>
    </form>
    
    <script>
	
	    jQuery.fn.serializeObject = function() { 
	        var obj = null; 
	        try { 
	            if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
	                var arr = this.serializeArray(); 
	                if(arr){ obj = {}; 
	                jQuery.each(arr, function() { 
	                    obj[this.name] = this.value; }); 
	                } 
	            } 
	        }catch(e) { 
	            alert(e.message); 
	        }finally {} 
	        return obj; 
	    }

	   $(document).on("change keyup", "input[name='searchKeywordStr']",function() {
	
	      var jsonData = $("form[id='search-popup']").serializeObject();
	      //var sendData = {key:jsonData};
	
	      $.ajax({
	         url : "getSearchKeyword.udo",
	         type : "get",
	         data : jsonData,
	         contentType : "application/json",
	         success : function(data) {
	        	$("#suggestList").empty();
	        	console.log(data);
	        	var result = JSON.parse(data);
	        	console.log(result); 
	        	
	        	if(result){
	        		 for( var i = 0; i < 10; i++ ) {
	        			 $("#suggestList").append("<a href='projectDetails.udo?projectNo="+result[i].projectNo+"'>"+result[i].projectTitle+"</a><br>"); 
	        			 
	        		 }
	        		 for( var i = 0; i < result.length; i++ ) {
	        			 $("#suggestList").append("<input type='hidden' name='projectNoList' value='"+result[i].projectNo+"'> ");
	        			 
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