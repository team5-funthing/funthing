<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   
<!doctype html>

<html class="no-js" lang="zxx">

<head>

	<jsp:include page="../include/i-head-setting.jsp"/>
  
</head>

<body>
  	
    <jsp:include page="../include/i-popupover-mypage.jsp"/> 
    <jsp:include page="../include/i-header.jsp"/> 
      
      
    <!-- 회원가입 선택 폼 양식 start -->
    <div class="wrap">
        <div class="container ">
            <div class="row ">
                <div class="col">
                </div>
                <div class="col align-self-center">
                    <form action="uploadTest.tdo" method="POST" enctype="multipart/form-data">
                        <hr>
                        <input type="file" name="uploadFile" id="gdsImg">
                        <div class="col-xl-12 mt-10 d-flex justify-content-center">
                            <button type="submit" class="btn btn-secondary btn-lg btn-block mt-5">업로드하기</button>
                        </div>
                        <hr>
                        <div class="select_img"><img src="" /></div>
                    </form>
                    
                    <script>
                    	$("#gdsImg").change(function(){
                    		if(this.files && this.files[0]){
                    			var reader = new FileReader;
                    			reader.onload = function(data){
                    				$(".select_img img").attr("src", data.target);
                    			}
                    			reader.readAsDataURL(this.files[0]);
                    		}
                    	})
                    </script>
                    
                    <%= request.getRealPath("/") %>
                    
                    
                    
                    

                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
    <!-- 회원가입 폼 end -->


    <footer class="footer">
    </footer>
    
     <jsp:include page="../include/i-popup-login.jsp"></jsp:include> 
	 <jsp:include page="../include/i-popup-search.jsp"></jsp:include> 
     <jsp:include page="../include/i-body-js.jsp"></jsp:include> 
    
</body>
</html>