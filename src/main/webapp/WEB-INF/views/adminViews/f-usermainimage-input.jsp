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


											<form action="userMainImageChange.ado"
												id="userMainImageChangSetting" method="post"
												enctype="multipart/form-data">
												<c:forEach var="mainImageList"
													items="${getUserMainImageChangeList}">
												</c:forEach>
											</form>
<!-- 코드 추가 시작00 -->


/

		  
				<!-- projectIntroduceImage -->
				<c:choose>
					<c:when test="${projectIntroduceImageList eq null}">
					
						<input type="file" class="form-control-file select-project-image projectIntroduceImage">
						<hr>
			           	<ul id="projectIntroduceImageUl">
						</ul>
			                
					</c:when>
					
					<c:when test="${projectIntroduceImageList ne null}">
						<input type="file" class="form-control-file select-project-image projectIntroduceImage">
						<ul id="projectIntroduceImageUl">
				
							<c:forEach var="projectIntroduceImage" items="${getUserMainImageChangeList }" varStatus="step">
							
								<li id="projectIntroduceImageLi">
									<div class="select_introduce_img m-3">
										<input type="hidden" value="${projectIntroduceImage.imageNo }">
										<img style="width: 200px; height: auto;" src="${projectIntroduceImage.imagePath }" />
										<a href="javaScript: return(0);" class='btn fas fa-times fa-2x imgRemoveBtn' type='button' ></a>
									</div>
									
								</li>
							</c:forEach>
						</ul>
					</c:when>
					
				</c:choose>
				
				<script>
				
	            	$(document).on("change",".projectIntroduceImage", function(){
	            		var fileVal = $(this).val();
	            		
	            		if(fileVal != ""){
	            			
	            			$("#nav-images").prepend("<input type='file' class='form-control-file select-project-image projectIntroduceImage'>");
	            			$(this).attr('name', 'projectIntroduceImageUpload'); 
	            			$(this).css('display', 'none');
	            	       	
	            			var idx = $('#projectIntroduceImageUl li').length;

	            	       	alert(fileVal);
							if(this.files && this.files[0]){
			           			var reader = new FileReader;
			           			reader.onload = function(data){
			           				$("#projectIntroduceImageUl").append("<li id='projectIntroduceImageLi'>"
			           						+	"<div class='select_introduce_img'>"
			    							+	"<img id='img" + idx + "' style='width: 400px; height: auto;' src='' />"
			    							+	"<a class='btn fas fa-times fa-2x imgRemoveBtn' type='button' ></a>"
			    							+	"</div>"
			    							+	"</li>");
			           				
			           				$("img[id='img" + idx + "']").attr("src", data.target.result).width(200);
			           				
			           				
			           			}; 
			           			reader.readAsDataURL(this.files[0]);
			           		}
	            		}
	            		
	            	});
	            	
					$(document).on("click", ".imgRemoveBtn", function(){
						

						$(this).siblings("input").attr("name", "projectIntroduceImageNo");
						$(this).closest("li").css('display', 'none');
						
					})

	            	
			    </script>		
		  </div>

<!-- 코드 추가 끝 00 -->







													<!-- 첫번째 시작 
													<div class="mt-30">
														<div class="input-group mt-2 mb-3">
															<div class="form-group">
																<label for="creatorProfile">이미지를 선택해주세요.</label> <input
																	type="file" id="userMainImageBt"
																	name="userMainUploadImage" class="form-control-file">
															</div>
															<div class="userMain_select_img">
																<img src="" />
															</div>
														</div>
														<script>
					            	$("#userMainImageBt").change(function(){
					            		if(this.files && this.files[0]){
					            			var reader = new FileReader;
					            			reader.onload = function(data){
					            				$(".userMain_select_img img").attr("src", data.target.result).width(200);
					            			}
					            			reader.readAsDataURL(this.files[0]);
					            		}
					            	})
								</script>
													</div>
													 첫번째 끝 -->

											
											

											<a
												class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
												href="javaScript:return(0);"
												onclick="document.getElementById('userMainImageChangSetting').submit();">바꾸기</a>
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
	</div>
	<!-- ============================================================== -->
	<!-- End Page wrapper  -->
	<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/sparkline/sparkline.js"></script>
	<!--Wave Effects -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/waves.js"></script>
	<!--Menu sidebar -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/custom.min.js"></script>
	<!--This page JavaScript -->
	<!-- <script src="dist/js/pages/dashboards/dashboard1.js"></script> -->
	<!-- Charts js Files -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/excanvas.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.pie.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.time.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.stack.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.crosshair.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/dist/js/pages/chart/chart-page-init.js"></script>


	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/multicheck/datatable-checkbox-init.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/multicheck/jquery.multicheck.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/DataTables/datatables.min.js"></script>
	<script>
            /****************************************
             *       Basic Table                   *
             ****************************************/
            $('#zero_config').DataTable();
        </script>
</body>

</html>