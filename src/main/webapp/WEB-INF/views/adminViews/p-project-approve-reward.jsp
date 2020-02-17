<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <h4 class="page-title">project_approve_reward</h4>
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

                <!-- Tabs -->
                <div class="card">
                    <div class="p-20">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title m-b-0"></h5>

                                        <div align="center" style="padding:5% ;">
                                            <label>목표금액</label>
                                            <input type="text" style="width: 100px;" readonly>
                                            &nbsp&nbsp&nbsp&nbsp&nbsp
                                            <label>프로젝트 마감일</label>
                                            <input type="text" style="width: 150px;" readonly>
                                            &nbsp&nbsp&nbsp&nbsp&nbsp
                                        
                                <p></p>
                                            <label>선물구성</label>
                                    </dr>
                                            <table border="1" style="width: 80%;">
                                                <tr>
                                                    <th>1만원</th>
                                                    <th>ggg</th>
                                                    <th>ggg</th>
                                                </tr>
                                                <tr>
                                                    <th>3만원</th>
                                                    <th>ggg</th>
                                                    <th>ggg</th>
                                                </tr>
                                                <tr>
                                                    <th>5만원</th>
                                                    <th>ggg</th>
                                                    <th>ggg</th>
                                                </tr>
                                                <tr>
                                                    <th>10만원</th>
                                                    <th>ggg</th>
                                                    <th>ggg</th>
                                                </tr>
                                            </table>
                                            <p></p>
                                            <label>펀딩안내</label></br>
                                            <form>
                                                <textarea style="width: 80%; height: 150px; overflow: auto; padding: 10px; white-space:pre-wrap; resize: none;"  readonly>
                                                </textarea>
                                            </form>
                                            <p></p>
                                            <label>인증서류 목록</label></br>
                                            <ui style="list-style-type: none;">
                                                <li>인증서류1&nbsp&nbsp<input type="button" value="다운"></li>
                                                <li style="padding:10px;">인증서류2&nbsp&nbsp<input type="button" value="다운"></li>
                                                <li>인증서류3&nbsp&nbsp<input type="button" value="다운"></li>
                                            </ui>


                                            


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

</body>

</html>