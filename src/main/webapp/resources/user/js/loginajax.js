function logincheckajax() {
	
		$.ajax({
			url:"loginMember.udo",
			type: "POST",
			data: {"email" : $("input#login-id").val()},
			"password" : $("input#login-pw").val()},{
			success: function(){
				document.alert('로그인성공');
				location.reload();
			}, error: function(){
				document.alert('로그인 정보가 올바르지 않습니다.');
			}
		});
	
	
}