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
    <link href="${pageContext.request.contextPath }/resources/admin/dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style>
.categoryArea{
	float:left;
	width:50%;
}
.categoryArea ul{
	list-style:none;
}
.categoryArea ul li{
		margin-bottom:10px;
}

</style>
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
        <jsp:include page="include/i-left-sidebar.jsp"/>
        <div class="page-wrapper">
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                     <h4 class="page-title">카테고리 관리</h4>
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
<!-- Tabs -->
<div class="card">
    <!-- Tab panes -->
    <div class="tab-content tabcontent-border"> 
        <div class="tab-pane active" id="home" role="tabpanel">
            <div class="p-20" style="padding:20px 20px 0 20px;height:509.5px;">
                <!-- 여기에 들어갈거-->
            	<div class="row">
            		<div class="card">
			            <div class="card-body">
			                <h4 class="card-title m-b-0"></h4>
			            </div>    
            		</div>
    			</div>
    			<div class="categoryArea">
    				<h5>카테고리 입력란</h5>
    				<form method="post" action="insertCategory.ado">
    					<div>
	    					<p class="alert alert-secondary" style="display:flex;"><input type="text" readonly value="  입력할 카테고리  :" class="form-control" style="width:45%;background-color:#E2E3E5;" >&nbsp;
	    					<input type="text" name="categoryName" class="form-control" id="inputCategory" style="width:35%;background-color:white;">
	    					&nbsp;<input class="btn btn-outline-dark" id="inputCategoryButton" type="submit" value="입력">
	    					</p>				
    					</div>
    					<div id="CategoryDuplicateCheck"></div>
    					
    				</form>
    				<script>
    					$(document).ready(function(){
    						$("input[name='categoryName']").blur(function(){
    							$.ajax({
    								url:"checkDuplicateCategory.ado",
    								data:{ inputCategory : $(this).val()},
    								type:"get",
    								success:function(data){
    									console.log(data);
    									$("#inputCategoryButton").removeAttr("disabled");
    									$("#CategoryDuplicateCheck").empty();
    									$("#CategoryDuplicateCheck").append(data).css('font-size','90%');
    									if(data.trim()=="중복된 카테고리가 있습니다."){
    										$("#inputCategoryButton").attr("disabled",true);
    									}
    								},
    								error:function(){
    									console.log('apple');
    								}
    							});
    						});
    					});
    				</script>
    			</div>
    			<div class="categoryArea">
    				<h5>현재 카테고리 목록</h5>
    				<div style="overflow-x:hidden;height:400px;">
    				<ul>
    					<c:forEach var="category" items="${CategoryList}">
    						<li class="alert alert-secondary">${category.categoryName}<a href="deleteCategory.ado?categoryName=${category.categoryName}" class="badge badge-dark" style="float:right;height:auto;" >삭제</a></li>
    					</c:forEach>
    				</ul>
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
      
</body>

</html>