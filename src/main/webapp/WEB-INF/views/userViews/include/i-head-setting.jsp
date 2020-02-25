<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>FunThing</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/jquery.gpopover.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/nice-select.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/slicknav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/style.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">

    <!-- Include jQuery and the jquery.gpopover plugin -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.gpopover.js"></script>
    <script src="https://kit.fontawesome.com/7a424ad03a.js" crossorigin="anonymous"></script>
    
   <!-- CKEditor4 -->
    <script src="${pageContext.request.contextPath}/resources/common/ckeditor/ckeditor.js"></script>
    
    <!-- DatePicker -->
    <script src="${pageContext.request.contextPath}/resources/user/js/datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/i18n/datepicker.ko.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/datepicker.min.css">
  	
    
    <script>
    
    
        $(function () {
            // Use custom options for the right button
            $('#mypage-btn').gpopover({
                width: 360,
                preventHide: true,
                onShow: function () {
                    if (console && console.log) console.log("Popover shown.");
                },
                onHide: function () {
                    if (console && console.log) console.log("Popover hidden.");
                }
            });
        });
        

    </script>
    
    
