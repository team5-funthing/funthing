<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>

<form method="POST">
			<!-- ���̵� -->
			<div class="form-group">
				<label for="user_id">���̵�</label>
					<input type="text" class="form-control" id="user_id" name="user_id" placeholder="ID" required>
				<div class="check_font" id="id_check"></div>
	
			</div>
			<!-- ��й�ȣ -->
			<div class="form-group">
				<label for="user_pw">��й�ȣ</label>
					<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="PASSWORD" required>
				<div class="check_font" id="pw_check"></div>
			</div>
			<!-- ��й�ȣ ��Ȯ�� -->
			<div class="form-group">
				<label for="user_pw2">��й�ȣ Ȯ��</label>
					<input type="password" class="form-control" id="user_pw2" name="user_pw2" placeholder="Confirm Password" required>
				<div class="check_font" id="pw2_check"></div>
			</div>
			<!-- �̸� -->
			<div class="form-group">
				<label for="user_name">�̸�</label>
					<input type="text" class="form-control" id="user_name" name="user_name" placeholder="Name" required>
				<div class="check_font" id="name_check"></div>
			</div>
			<!-- ������� -->
			<div class="form-group required">
				<label for="user_birth">�������</label>
					<input type="text" class="form-control" id="user_birth" name="user_birth" placeholder="ex) 19990415" required>
				<div class="check_font" id="birth_check"></div>
			</div>
			<!-- ����Ȯ�� �̸��� -->
			<div class="form-group">
				<label for="user_email">�̸���</label>
					<input type="text" class="form-control" name="user_email" id="user_email" placeholder="E-mail" required>
					<!-- <input type="text" style="margin-top: 5px;"class="email_form" name="email_confirm" id="email_confirm" placeholder="������ȣ�� �Է����ּ���!" required>
						<button type="button" class="btn btn-outline-danger btn-sm px-3" onclick="confirm_email()">
							<i class="fa fa-envelope"></i>&nbsp;����
						</button>&nbsp;
						<button type="button" class="btn btn-outline-info btn-sm px-3">
							<i class="fa fa-envelope"></i>&nbsp;Ȯ��
						</button>&nbsp; -->
					<div class="check_font" id="email_check"></div>
			</div>
			<!-- �޴���ȭ -->
			<div class="form-group">
				<label for="user_phone">�޴���ȭ ('-' ���� ��ȣ�� �Է����ּ���)</label>
				<input type="text" class="form-control" id="user_phone" name="user_phone" placeholder="Phone Number" required>
				<div class="check_font" id="phone_check"></div>
			</div>
			<div class="reg_button">
				<a class="btn btn-danger px-3" href="${pageContext.request.contextPath}">
					<i class="fa fa-rotate-right pr-2" aria-hidden="true"></i>����ϱ�
				</a>&emsp;&emsp;
				<button class="btn btn-primary px-3" id="reg_submit">
					<i class="fa fa-heart pr-2" aria-hidden="true"></i>�����ϱ�
				</button>
			</div>
		</form>
		
		<script>
// ���̵� ��ȿ�� �˻�(1 = �ߺ� / 0 != �ߺ�)
	$("#user_id").blur(function() {
		// id = "id_reg" / name = "userId"
		var user_id = $('#user_id').val();
		$.ajax({
			url : 'http://localhost:8080/funthing/emailjoin2.udo?id=?'+ user_id,
			type : 'get',
			success : function(data) {
				console.log("1 = �ߺ�o / 0 = �ߺ�x : "+ data);							
				
				if (data == 1) {
						// 1 : ���̵� �ߺ��Ǵ� ����
						$("#id_check").text("������� ���̵��Դϴ� :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_id)){
							// 0 : ���̵� ���� / ���ڿ� �˻�
							$("#id_check").text("");
							$("#reg_submit").attr("disabled", false);
				
						} else if(user_id == ""){
							
							$('#id_check').text('���̵� �Է����ּ��� :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							$('#id_check').text("���̵�� �ҹ��ڿ� ���� 4~12�ڸ��� �����մϴ� :) :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("����");
				}
			});
		});
</script>


	
</body>
</html>