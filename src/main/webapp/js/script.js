$(document).ready(function(){
	/**
	 * check to input box - login page 
	 */
	$('#loginform').submit(function(){
		var regx_id =/^[a-zA-Z0-9]+\@[a-zA-Z0-9]+\.[a-zA-Z]{2,3}(?:\.[a-zA-Z]{2})?$/;   
		var regx_pwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}$/;
		var $id = $('.loginid');
		var $pwd = $('.loginpwd');
		
		if($id.val()=='' || $pwd.val()==''){
			alert("빈칸을 확인해 주세요.");
			if($id.val()==''){
				$id.focus();
			}else{
				$pwd.focus();
			}
			return false;
		}
		
		if(!regx_id.test($id.val())){
			alert("이메일 주소 형식이 올바르지 않습니다.");
			$id.val('');
			$id.focus();
			return false;
		}
		
		if(!regx_pwd.test($pwd.val()) || ($pwd.val().length<6 || $pwd.val().length>12) ){
			if(!regx_pwd.test($pwd.val())){
				alert("비밀번호 입력 형식이 올바르지 않습니다.(패스워드는 영문/숫자/특수문자 포함되어야 함.)");
			}else{
				alert("비밀번호는 6 ~ 12자리 이내로 입력하세요.");
			}	
			$pwd.val('');
			$pwd.focus();
			return false;
		}
	});
});

$(document).ready(function(){
	/**
	 * check to authentication - update page
	 */
	if($(".userrole").val() == "ROLE_ADMIN"){
		$("#slt option:eq(1)").attr("selected","selected");
	}
});

$(document).ready(function(){
	/**
	 * collect to password form - join page
	 */
	$("#joinform").submit(function(){
		var regx_pwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}$/;
		$pwd1=$('.joinpwd1');
		$pwd2=$('.joinpwd2');
		
		if($pwd1.val()=='' || $pwd2.val()==''){
			alert("빈칸을 확인해 주세요.");
			if($pwd1.val()==''){
				$pwd1.focus();
			}else{
				$pwd2.focus();
			}
			return false;
		}
		
		if(!regx_pwd.test($pwd1.val()) || ($pwd1.val().length<6 || $pwd1.val().length>12) ){
			if(!regx_pwd.test($pwd1.val())){
				alert("비밀번호 입력 형식이 올바르지 않습니다.(패스워드는 영문/숫자/특수문자 포함되어야 함.)");
			}else{
				alert("비밀번호는 6 ~ 12자리 이내로 입력하세요.");
			}	
			$pwd1.val('');
			$pwd2.val('');
			$pwd1.focus();
			return false;
		}
		
		if($pwd1.val() != $pwd2.val()){
			alert("입력한 비밀번호가 일치하지 않습니다.");
			$pwd1.val('');
			$pwd2.val('');
			$pwd1.focus();
			return false;
		}
	});	
});
// var regx_id =/^[a-zA-Z0-9]+\@[a-zA-Z0-9]+\.[a-zA-Z]{2,3}(?:\.[a-zA-Z]{2})?$/;   
// var regx_pwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}$/;
// var regx_name = /^[가-힣a-zA-Z]+$/;


	/* 
	 * 이름은 한글/영문만 입력
	 */

	
	/* 
	 * 아이디는 이메일 형식만 입력
	 */

	
	/* 
	 * 패스워드는 영문/숫자/특수문자 포함
	 * 6 ~ 12자리 이내 입력
	 * pwd 
	 */

	/* 
	 * 패스워드 일치 여부 확인
	 * pwd 
	 */
