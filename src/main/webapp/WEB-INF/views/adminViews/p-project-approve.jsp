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
                        <h4 class="page-title">project_approve</h4>
                        <div class="ml-auto text-right">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="admindex.ado">Home</a></li>
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
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item"> <a class="nav-link active" data-toggle="tab" href="#home" role="tab"><span
                                    class="hidden-sm-up"></span> <span class="hidden-xs-down">프로젝트</span></a> </li>
                        <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#home2" role="tab"><span
                                    class="hidden-sm-up"></span> <span class="hidden-xs-down">창작자</span></a> </li>
                        <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#home3" role="tab"><span
                                    class="hidden-sm-up"></span> <span class="hidden-xs-down">스토리</span></a> </li>
                        <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#home4" role="tab"><span
                                    class="hidden-sm-up"></span> <span class="hidden-xs-down">리워드</span></a> </li>
                        <li class="nav-item"> <a class="nav-link" data-toggle="tab" href="#home5" role="tab"><span
                                    class="hidden-sm-up"></span> <span class="hidden-xs-down">계좌</span></a> </li>

                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content tabcontent-border">
                        <div class="tab-pane active" id="home" role="tabpanel">
                            <div class="p-20">
                                <!-- 여기에 들어갈거-->
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title m-b-0">프로젝트 탭</h5>
                                               
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\return_cause_input.html"><input type="button" value="반려" style="float: right;"></a>
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\project_list.html"> <input type="button" value="승인" style="float: right;"></a>
                                            </div>
                                          
                                            <div align="center">
                                                <p></p>
                                                <table >
                                                    <tr>
                                                        <th style="padding: 10px;">프로젝트 명</th>
                                                        <td><input type="text" readonly ></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th>프로젝트 분류</th>
                                                        <td><input type="text" readonly></td>
                                                        <th style="padding: 10px;">프로젝트 기간</th>
                                                        <td><input type="text" readonly></td>
                                                    </tr>
                                                </table>
                                                <label style="padding-top: 20%;">프로젝트 이미지</label>
                                                <input type="image" style="padding: 10px;">
                                                <input type="button" value="파일다운">

                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane  p-20" id="home2" role="tabpanel">
                            <div>
                                <!-- 여기에 들어갈거-->
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title m-b-0">창작자 탭</h5>
                                                
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\return_cause_input.html"><input type="button" value="반려" style="float: right;"></a>
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\project_list.html"> <input type="button" value="승인" style="float: right;"></a>
                                            </div>
                                            
                                            <table style="width: 80%;">
                                                <tr >
                                                    <th style="text-align: right; padding: 10px;" >업체명</th>
                                                    <td ><input type="text" style="width: 100%;" readonly ></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <th style="text-align: right; right; padding: 10px;">창작자명</th>
                                                    <td><input type="text" type="text" style="width: 100%;" readonly></td>
                                                    <th style="text-align: right; right; padding: 10px;">창작자 이메일</th>
                                                    <td><input type="text"type="text" style="width: 100%;" readonly></td>
                                                </tr>
                                                <tr>
                                                    <th style="text-align: right; right; padding: 10px;">창작자 H·P</th>
                                                    <td><input type="text" type="text" style="width: 100%;" readonly></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                            </table>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane  p-20" id="home3" role="tabpanel">
                            <div>
                                <!-- 여기에 들어갈거-->
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title m-b-0">스토리 탭</h5>
                                                
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\return_cause_input.html"><input type="button" value="반려" style="float: right;"></a>
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\project_list.html"><input type="button" value="승인" style="float: right;"></a>
                                            </div>

                                            <p></p>
                                        <label>소개 컨텐츠</label></dr>
                                        <div style="border:1px dotted; height: 100px;">영상 또는 이미지 넣는 곳</div>
                                        <p></p>
                                        <label>스토리</label></dr>
                                        <form>
                                            <textarea style="width: 100%; height: 250px; overflow: auto; padding: 10px; white-space:pre-wrap; resize: none;"  readonly>
                                            </textarea>
                                        </form>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="tab-pane  p-20" id="home4" role="tabpanel">
                            <div>
                                <!-- 여기에 들어갈거-->
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title m-b-0">리워드 탭</h5>
                                                
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\return_cause_input.html"><input type="button" value="반려" style="float: right;"></a>
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\project_list.html"><input type="button" value="승인" style="float: right;"></a>
                                            </div>
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

                        <div class="tab-pane  p-20" id="home5" role="tabpanel">
                            <div>
                                <!-- 여기에 들어갈거-->
                                <div class="row">
                                    <div class="col-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <h5 class="card-title m-b-0">계좌 탭</h5>
                                                
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\return_cause_input.html"><input type="button" value="반려" style="float: right;"></a>
                                                <a href="C:\Users\pjh\Desktop\5jo\matrix-admin-master\project_list.html"><input type="button" value="승인" style="float: right;"></a>
                                            </div>
                                         
                                            <div align="center" style="padding:5% ;">
                                                <label style="padding: 5px;">은행</label>
                                                <input type="text" style="width: 100px;" readonly>
                                                &nbsp&nbsp&nbsp&nbsp&nbsp
                                                <label style="padding: 5px;">예금주</label>
                                                <input type="text" style="width: 150px;" readonly>
                                                
                                            </br>
                                                <label style="padding: 10px;">계좌번호</label>
                                                <input type="text" style="width: 300px;" readonly ">
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