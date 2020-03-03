<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- mypage popupOver -->
       <div id="popover-mypage-menu" class="gpopover">
           <div class="container">
               <div>
                   <div>
                    <form id="imgform" action="saveimage.udo" method="post" enctype="multipart/form-data">
                       <div class="row d-flex justify-content-between ml-2 mr-2 mt-4 pb-4">
                       		<label for="image" >
                           <div id="profile-img" style="background: #BDBDBD;">
                       		<input  type="file"  id="image" name="imgname" accept="image/*" style="display: none; ">
                              <img id="gogoimage" class="profile" src="${sessionScope.memberSession.myImage }">
                           </div>
                           </label>
                           <div><input type="button" onclick="clickedBtn()" value="저장" class="genric-btn success small"></div>
                           <div>${sessionScope.memberSession.name} 님 환영합니다.</div>
                       </div>
                       </form>
                    <script>
                    	$("#image").change(function(){
                    		if(this==$('#image')[0]){	}
                    		
	            		if(this.files && this.files[0]){
	            			var reader = new FileReader;
	            			reader.onload = function(data){
	            				$("#gogoimage").attr("src", data.target.result);
	            				$("#gogoimage2").attr("src", data.target.result);
	            				$("#gogoimage3").attr("src", data.target.result);
	            			}
	            			reader.readAsDataURL(this.files[0]);
	            		}
	            	}) 
	            	
					  function clickedBtn(){
						    
                       var form = new FormData(document.getElementById("imgform"));
                       $.ajax({
                    	   url:"saveimage.udo",
                    	   data:form,
                    	   type:"POST",
                    	   cache:false,
                    	   processData:false,
                    	   contentType:false,
                    	   success:function(data){
                        	if(data=="1"){
                        		alert("이미지가 저장되었습니다.");
                        	}
                    	   },
                    	   error : function() {
                   			alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.");
                   		}
                       });
					  }
                       </script> 
                       
                   </div>
                   <div>
                       <div class="d-flex justify-content-around bd-highlight">
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight ">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="fas fa-shapes fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">창작한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight ">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="fas fa-hand-holding-usd fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">후원한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="far fa-surprise fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">반응한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                           <div class="p-2 bd-highlight">
                               <div class="d-flex flex-column bd-highlight ">
                                   <div class="p-2 bd-highlight">
                                       <div class="justify-content-center">
                                           <div class="p-2 bd-highlight">
                                               <i class="fas fa-heart fa-3x"></i>
                                           </div>
                                           <div class="p-2 bd-highlight">
                                               <a href="show-filteredProjects.html">
                                                   <div class="h6">좋아한</div>
                                               </a>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </div>
                   </div>
                   <div class="row align-items-end">
                       <div class="list-group">
                           <a href="#" class="list-group-item list-group-item-action active">
                               <div class="d-flex w-100 justify-content-between">
                                   <h5 class="mb-1">보안 인증 하시면 좋데요</h5>
                                   <small>3 days ago</small>
                               </div>
                               <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget
                                   risus varius blandit.</p>
                               <small></small>
                           </a>
                       </div>
                   </div>
                   <div class="d-flex flex-column bd-highlight mb-3">
                       <ul class="list-group list-group-flush">
                           <li class="list-group-item"><a href="mypage.udo">
                                   <div class="h6">마이페이지</div>
                               </a></li>
                           <li class="list-group-item"><a href="#">
                                   <div class="h6">후원 결제내역</div>
                               </a></li>
                           <li class="list-group-item"><a href="#">
                                   <div class="h6">수입내역</div>
                               </a></li>
                           <li class="list-group-item"><a href="logout.udo">
                                   <div class="h6">로그아웃 하기</div>
                               </a>
                           </li>
                       </ul>
                   </div>
               </div>
           </div>
       </div>
       <!-- mypage popupOver end -->