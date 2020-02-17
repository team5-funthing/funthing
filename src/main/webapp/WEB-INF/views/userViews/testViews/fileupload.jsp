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
                    				$(".select_img img").attr("src", data.target.result).width(500);
                    			}
                    			reader.readAsDataURL(this.files[0]);
                    		}
                    	})
                    </script>
                
                    <%= request.getRealPath("/") %>
                    
					<textarea class="mt-1" name="projectStory" class="form-control" id="editor" rows="10">
						<h2>TEST 글이에요.</h2>
						<p>
							This may be the first time you hear about this made-up disorder but
							it actually isn’t so far from the truth. Even the studies that were conducted almost half a century show that
							<strong>the language you speak has more effects on you than you realise</strong>.
						</p>
						<p>
							One of the very first experiments conducted on this topic dates back to 1964.
							<a href="https://www.researchgate.net/publication/9440038_Language_and_TAT_content_in_bilinguals">In the experiment</a>
							designed by linguist Ervin-Tripp who is an authority expert in psycholinguistic and sociolinguistic studies,
							adults who are bilingual in English in French were showed series of pictures and were asked to create 3-minute stories.
							In the end participants emphasized drastically different dynamics for stories in English and French.
						</p>
						<p>
							Another ground-breaking experiment which included bilingual Japanese women married to American men in San Francisco were
							asked to complete sentences. The goal of the experiment was to investigate whether or not human feelings and thoughts
							are expressed differently in <strong>different language mindsets</strong>.
							<Here>is a sample from the the experiment:</Here>
						</p>
						<p>
							More recent <a href="https://books.google.pl/books?id=1LMhWGHGkRUC">studies</a> show, the language a person speaks affects
							their cognition, behaviour, emotions and hence <strong>their personality</strong>.
							This shouldn’t come as a surprise
							<a href="https://en.wikipedia.org/wiki/Lateralization_of_brain_function">since we already know</a> that different regions
							of the brain become more active depending on the person’s activity at hand. Since structure, information and especially
							<strong>the culture</strong> of languages varies substantially and the language a person speaks is an essential element of daily life.
						</p>
					</textarea>

					<script src="${pageContext.request.contextPath}/resources/common/ckeditor5/js/ckeditor.js"></script>                    

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