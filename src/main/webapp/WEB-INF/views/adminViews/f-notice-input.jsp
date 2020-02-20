<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath }/resources/admin/assets/images/favicon.png">
    <title>Matrix Template - The Ultimate Multipurpose admin template</title>
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/css/float-chart.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/admin/assets/libs/select2/dist/css/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery-minicolors/jquery.minicolors.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/admin/assets/libs/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/admin/assets/libs/quill/dist/quill.snow.css">
    <link href="${pageContext.request.contextPath }/resources/admin/dist/css/style.min.css" rel="stylesheet">
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
       	<jsp:include page="include/i-topbar-header.jsp"/>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <jsp:include page="include/i-left-sidebar.jsp"/>
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
                        <h4 class="page-title">공지 글</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#C:\Users\pjh\Desktop\5jo\matrix-admin-master\index.html">Home</a></li>
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



           <!-- editor -->
           <div class="card">
            <div class="p-20">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title m-b-0" style="padding:20px;">공지사항</h4>
                        <!-- Create the editor container -->
                   	<form action="insertAdminNoticeBoard.ado">
                        <div style="padding-bottom: 5px;" >
                            <label style="padding-right: 5px;"> 제목 </label>
                            <input type="text" size="50%" name = "noticeTitle" value="${vo.noticeTitle}">
                   			<input type="hidden" name="noticeNo" value="${vo.noticeNo }">
                            <select name="noticeCategory">
                                <option value="공지" <c:if test="${vo.noticeCategory eq '공지'}">selected</c:if>>공지</option>
                                <option value="이벤트"<c:if test="${vo.noticeCategory eq '이벤트'}">selected</c:if>>이벤트</option>
                            </select>
                        </div>                       
                        <textarea name="editor1" rows = "7" cols = "50">${vo.noticeContents}</textarea>
                        <!-- <div id="editor" style="height: 300px;">
                            <p></p>
                            <p><strong></strong> </p>
                            <p>
                                <br>
                            </p>
                        </div> -->
                        <div align="center" style="padding-top: 15px;">
							<c:choose>
								<c:when test="${vo.noticeNo ne null}">
									<input type="submit" formaction="updateAdminNoticeBoard.ado" value="수정">							
								</c:when>
							</c:choose>                  		
                            <input type="submit" value="등록" >
                            <input type="submit" formaction="deleteAdminNoticeBoard.ado" value="삭제">
                            <a href="adminNoticeInput.ado"><input type="button" value="뒤로" ></a>
                        </div>
					</form>
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
                <jsp:include page="include/i-footer.jsp"/>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Page wrapper  -->
            <!-- ============================================================== -->
        </div>
    </div>
        <!-- ============================================================== -->
        <!-- End Wrapper -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- All Jquery -->
        <!-- ============================================================== -->
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/popper.js/dist/umd/popper.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/extra-libs/sparkline/sparkline.js"></script>
        <!--Wave Effects -->
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/custom.min.js"></script>
        <!--This page JavaScript -->
        <!-- <script src="dist/js/pages/dashboards/dashboard1.js"></script> -->
        <!-- Charts js Files -->
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/excanvas.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.pie.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.time.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.stack.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot/jquery.flot.crosshair.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
        <script src="${pageContext.request.contextPath }/resources/admin/dist/js/pages/chart/chart-page-init.js"></script>



        <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/dist/js/pages/mask/mask.init.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/select2/dist/js/select2.full.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/select2/dist/js/select2.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery-asColor/dist/jquery-asColor.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery-asGradient/dist/jquery-asGradient.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery-asColorPicker/dist/jquery-asColorPicker.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/jquery-minicolors/jquery.minicolors.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/admin/assets/libs/quill/dist/quill.min.js"></script>
    <!-- CKEditor 전용 라이브러리 -->
    <script src="https://cdn.ckeditor.com/4.13.1/standard/ckeditor.js"></script>
    <script>
        //***********************************//
        // For select 2
        //***********************************//
        $(".select2").select2();

        /*colorpicker*/
        $('.demo').each(function() {
        //
        // Dear reader, it's actually very easy to initialize MiniColors. For example:
        //
        //  $(selector).minicolors();
        //
        // The way I've done it below is just for the demo, so don't get confused
        // by it. Also, data- attributes aren't supported at this time...they're
        // only used for this demo.
        //
        $(this).minicolors({
                control: $(this).attr('data-control') || 'hue',
                position: $(this).attr('data-position') || 'bottom left',

                change: function(value, opacity) {
                    if (!value) return;
                    if (opacity) value += ', ' + opacity;
                    if (typeof console === 'object') {
                        console.log(value);
                    }
                },
                theme: 'bootstrap'
            });

        });
        /*datwpicker*/
        jQuery('.mydatepicker').datepicker();
        jQuery('#datepicker-autoclose').datepicker({
            autoclose: true,
            todayHighlight: true
        });
        var quill = new Quill('#editor', {
            theme: 'snow'
        });

    </script>
    <script>
           CKEDITOR.replace( 'editor1' );
    </script>
</body>

</html>