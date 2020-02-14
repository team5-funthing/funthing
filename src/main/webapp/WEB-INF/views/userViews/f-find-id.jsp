<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Montana</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/nice-select.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/gijgo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/slicknav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/style.css">
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/responsive.css"> -->
</head>

<body>

   <div class="mt-30">  
   <script>
   function getParam(sname) {
	    var params = location.search.substr(location.search.indexOf("?") + 1);
	    var sval = "";
	    params = params.split("&");
	    for (var i = 0; i < params.length; i++) {
	        temp = params[i].split("=");
	        if ([temp[0]] == sname) { sval = temp[1]; }
	    }
	    return sval;
	} 
   alert(getParam('email'));
   self.close();

   
   </script>      
    </div>
 
 
    <!-- JS here -->
    <script src="${pageContext.request.contextPath}/resources/user/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/isotope.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/ajax-form.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/imagesloaded.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/scrollIt.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.scrollUp.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.slicknav.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.magnific-popup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/gijgo.min.js"></script>

    <!--contact js-->
    <script src="${pageContext.request.contextPath}/resources/user/js/contact.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.ajaxchimp.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/mail-script.js"></script>

    <script src="${pageContext.request.contextPath}/resources/user/js/main.js"></script>
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }

        });
    </script>



</body>

</html>