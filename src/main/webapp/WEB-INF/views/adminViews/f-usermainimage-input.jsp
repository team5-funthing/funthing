<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="${pageContext.request.contextPath }/resources/admin/assets/images/favicon.png">
<title>Matrix Template - The Ultimate Multipurpose admin
	template</title>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/multicheck/multicheck.css">
<link
	href="${pageContext.request.contextPath }/resources/admin/assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css"
	rel="stylesheet">
	
	

<link
	href="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/css/float-chart.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath }/resources/admin/dist/css/style.min.css"
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<jsp:include page="include/i-topbar-header.jsp" />
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="include/i-left-sidebar.jsp" />
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">image</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="#C:\Users\pjh\Desktop\5jo\matrix-admin-master\index.html">Home</a></li>
									<!--
                                    <li class="breadcrumb-item active" aria-current="page"></li>
                                    -->
								</ol>
							</nav>
						</div>
					</div>
				</div>

				<!-- ============================================================== -->
				<!-- End Bread crumb and right sidebar toggle -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Container fluid  -->
				<!-- ============================================================== -->



				<!-- 여기에 들어갈거-->
				<div class="card">
					<div class="p-20">
						<div class="row">
						
							<div class="col-12">
								<div class="card">
									<div class="card-body">

										<h5 class="card-title m-b-0">이미지파일 업로드</h5>
										<hr>
										<div class="table-responsive">
								

				<!-- projectIntroduceImage -->
				
				
				<form action="userMainImageChange.ado"
												id="userMainImageChangSetting" method="post"
												enctype="multipart/form-data">
				<div id="userMainImage">
				<c:choose>
					<c:when test="${userMainImageList eq null}">
						
						<input type="file" class="form-control-file select-project-image userMainImage">
						<hr>
			           	<ul id="projectIntroduceImageUl">
						</ul>
			                
					</c:when>
					
					<c:when test="${userMainImageList ne null}">
						<input type="file" class="form-control-file select-project-image userMainImage">
						<ul id="projectIntroduceImageUl">
			
							<c:forEach var="userMainImage" items="${userMainImageList }" varStatus="step">
							
								<li id="projectIntroduceImageLi">
									<div class="select_introduce_img m-3">
											<input class="imageNo1" type="hidden" value="${userMainImage.imageNo }">
											<input class="imageNo2" type="hidden" value="${userMainImage.imageNo }">
											<img style="width: 200px; height: auto;" src="${userMainImage.imagePath }" />
											<a href="javaScript: return(0);" class='btn fas fa-times fa-2x imgRemoveBtn' type='button' ></a>
										<textarea class="imageContentC" style=" width: 40%; height: 75px; overflow: auto; padding: 10px; white-space:pre-wrap; resize: none;">${userMainImage.imageContent }</textarea>		
									</div>
									<hr>
								</li>
							
							</c:forEach>
							
					
							
						</ul>
					</c:when>
					
				</c:choose>
				</div>
				</form>
				<script>
				
	            	$(document).on("change",".userMainImage", function(){
	            		var fileVal = $(this).val();
	            		
	            		if(fileVal != ""){
	            			
	            			$("#userMainImage").prepend("<input type='file' class='form-control-file select-project-image userMainImage'>");
	            			$(this).attr('name', 'userMainUploadImage');
	            			$(this).css('display', 'none');
	            			
	            	       	
	            			var idx = $('#projectIntroduceImageUl li').length;
	            			
	            			$(this).attr('id', "ho"+idx);
	            			
	            	       	alert(fileVal);
							if(this.files && this.files[0]){
			           			var reader = new FileReader;
			           			reader.onload = function(data){
			           				$("#projectIntroduceImageUl").append("<li id='projectIntroduceImageLi'>"
			           						+	"<div class='select_introduce_img'>"
			    							+	"<img id='img" + idx + "' style='width: 100%; height:100px;' src='' />"
			    							+	"<a class='btn fas fa-times fa-2x imgRemoveBtn2' id='"+idx+"' type='button' ></a>"
			    							+	"<textarea class='imageContentC2' style='width: 40%; height: 75px; overflow: auto; padding: 10px; white-space:pre-wrap; resize: none;'></textarea>"
			    							+	"</div>"
			    							+	"</li>");
			           						
			           				$("img[id='img" + idx + "']").attr("src", data.target.result).width(200);
			           				
			           			}; 
			           			reader.readAsDataURL(this.files[0]);
			           		}
	            		}
	            		
	         
	            	});
	            	
					
					$(document).on("click", ".imgRemoveBtn", function(){
						
						$(this).siblings(".imageNo1").attr("name", "userMainImageNo");
						
						$(this).siblings(".imageContentC").attr("name", "a");
						
						$(this).closest("li").css('display', 'none');
						
	
					})
					
					$(document).on("keydown", ".imageContentC", function(){
						
						$(this).siblings(".imageNo2").attr("name", "userMainImageNo2");
						
						$(this).attr("name", "userMainImageContent");
						
					})
					
					$(document).on("keydown", ".imageContentC2", function(){
						
						$(this).attr("name", "userMainImageContent2");
						
					})

					
					$(document).on("click", ".imgRemoveBtn2", function(){
							
						
						var ida = $(this).attr("id");
						var ho1 = "ho"+ida ;
						
						
						var te2 = document.getElementById(ho1).getAttribute('id');
						
						$(this).closest("li").css('display', 'none');
						$(("#"+te2)).remove();
										
						
						$(this).siblings(".imageContentC").attr("name", "a");
						

					})

			    </script>		
		  </div>
			
											
												<a
												class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
												href="javaScript:return(0);"
												onclick="document.getElementById('userMainImageChangSetting').submit();">적용하기</a>
										</div>


									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<jsp:include page="include/i-footer.jsp" />
		</div>
		<!-- ============================================================== -->
		<!-- End footer -->
		<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script>
            /****************************************
             *       Basic Table                   *
             ****************************************/
            $('#zero_config').DataTable();
        </script>
        
   <script src="https://kit.fontawesome.com/7a424ad03a.js" crossorigin="anonymous"></script>


        
</body>

</html>