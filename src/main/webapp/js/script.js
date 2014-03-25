/**
 * 
 */

function loginChk(){
	var regx_id =/@./;
	var regx_pwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;
	var id = document.f.userid.value;
	var pwd = document.f.userpwd.value;
	
	/* 아이디는 이메일 형식만 입력가능한가
	 */
	if((id.length) == 0 || (id == null)){
		alert("ID를 입력하세요.");
		document.f.userid.value = "";
		document.f.userid.focus();
	}else if(!regx_id.test(id)){
		alert("ID는 이메일 형식으로 입력하세요.");
		document.f.userpwd.value = "";
		document.f.userpwd.focus();
	}
	
	/* 패스워드는 영문/숫자/특수문자를 포함하는가
	   6자리 ~ 12자리 이내를 만족하는가 
	 */
	if((pwd.length) == 0 || (pwd == null)){
		alert("Password를 입력하세요.");
		document.f.userpwd.value = "";
		document.f.userpwd.focus();
	}else if((pwd.length) < 6 || (pwd.length) > 12){
		alert("Password는 6 ~ 12자리로 입력하세요.");
	}else if(!regx_pwd.test(pwd)){
		alert("Password는 문자,숫자,특수문자의 조합으로 입력하세요.");
		document.f.userpwd.value = "";
		document.f.userpwd.focus();
	}

	document.f.submit();
}