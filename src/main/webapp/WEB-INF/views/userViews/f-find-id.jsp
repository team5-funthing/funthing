<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>

<html class="no-js" lang="zxx">


<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
	
</head>

<body>
 
 <script>
 
 ///  이 페이지는   사용하지 않는 기능을 버리고    메일로 인증번호 발송할 떄 콜백페이지로 사용중 입니다. 
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
   window.sessionStorage
   self.close();

   
   </script> 
   
   
   
      
</body>

</html>