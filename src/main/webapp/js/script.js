/**
 * 
 */
var regx_id =/^[a-zA-Z0-9]+\@[a-zA-Z0-9]+\.[a-zA-Z]{2,3}(?:\.[a-zA-Z]{2})?$/;   
var regx_pwd = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}$/;
var regx_name = /^[가-힣a-zA-Z]+$/;
/* var regx = /^[a-zA-Z]{4}+\_[a-zA-Z]$/;*/

function loginChk(){
	
	var id = document.getElementsByName("j_username")[0].value;
	var pwd = document.getElementsByName("j_password")[0].value; 

	/* 
	 * 아이디는 이메일 형식만 입력 
	 */
	if((id.length) == 0 || (id == null)){
		alert("아이디를 입력하세요.");
		document.getElementsByName("j_username")[0].value="";
		document.getElementsByName("j_username")[0].focus();
		return false;
	}else if(!regx_id.test(id)){
		alert("아이디는 이메일 형식으로 입력하세요.");
		document.getElementsByName("j_username")[0].value="";
		document.getElementsByName("j_username")[0].focus();
		return false;
	}
	
	/* 
	 * 패스워드는 영문/숫자/특수문자 포함
	 * 6 ~ 12자리 이내 입력 
	 */
	if((pwd.length) == 0 || (pwd == null)){
		alert("비밀번호를 입력하세요.");
		document.getElementsByName("j_password")[0].value="";
		document.getElementsByName("j_password")[0].focus();
		return false;
	}else if((pwd.length) < 6 || (pwd.length) > 12){
		alert("비밀번호는 6 ~ 12자리로 입력하세요.");
		document.getElementsByName("j_password")[0].value="";
		document.getElementsByName("j_password")[0].focus();
		return false;
	}else if(!regx_pwd.test(pwd)){
		alert("비밀번호는 문자,숫자,특수문자의 조합으로 입력하세요.");
		document.getElementsByName("j_password")[0].value="";
		document.getElementsByName("j_password")[0].focus();
		return false;
	}
	document.getElementById("loginform").submit();
}

function joinChk(){
	
	var name = document.getElementsByName("username")[0].value;
	var id = document.getElementsByName("userid")[0].value;
	var pwd = document.getElementsByName("userpwd")[0].value; 
	var pwd2 = document.getElementsByName("userpwd")[1].value;
	
	/* 
	 * 이름은 한글/영문만 입력
	 */
	if((name.length) == 0 || (name == null)){
		alert("이름을 입력하세요.");
		document.getElementsByName("username")[0].value="";
		document.getElementsByName("username")[0].focus();
		return false;
	}else if(!regx_name.test(name)){
		alert("이름은 한글,영문으로 입력하세요.");
		document.getElementsByName("username")[0].value="";
		document.getElementsByName("username")[0].focus();
		return false;
	}
	
	/* 
	 * 아이디는 이메일 형식만 입력
	 */
	if((id.length) == 0 || (id == null)){
		alert("아이디를 입력하세요.");
		document.getElementsByName("userid")[0].value="";
		document.getElementsByName("userid")[0].focus();
		return false;
	}else if(!regx_id.test(id)){
		alert("아이디는 이메일 형식으로 입력하세요.");
		document.getElementsByName("userid")[0].value="";
		document.getElementsByName("userid")[0].focus();
		return false;
	}
	
	/* 
	 * 패스워드는 영문/숫자/특수문자 포함
	 * 6 ~ 12자리 이내 입력
	 * pwd 
	 */
	if((pwd.length) == 0 || (pwd == null)){
		alert("비밀번호를 입력하세요.");
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}else if((pwd.length) < 6 || (pwd.length) > 12){
		alert("비밀번호는 6 ~ 12자리로 입력하세요.");
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}else if(!regx_pwd.test(pwd)){
		alert("비밀번호는 문자,숫자,특수문자의 조합으로 입력하세요.");
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}else if(pwd != pwd2){
		alert("입력된 비밀번호가 같지 않습니다.")
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}
	document.getElementById("joinform").submit();
}

function updateChk(){
	
	var name = document.getElementsByName("username")[0].value;
	var id = document.getElementsByName("userid")[0].value;
	var pwd = document.getElementsByName("userpwd")[0].value; 
	var pwd2 = document.getElementsByName("userpwd")[1].value;
	/* var role = document.getElementsByName("userrole")[0].value; */
	
	/* 
	 * 이름은 한글/영문만 입력
	 */
	if((name.length) == 0 || (name == null)){
		alert("이름을 입력하세요.");
		document.getElementsByName("username")[0].value="";
		document.getElementsByName("username")[0].focus();
		return false;
	}
	
	/* 
	 * 아이디는 이메일 형식만 입력
	 */
	if((id.length) == 0 || (id == null)){
		alert("아이디를 입력하세요.");
		document.getElementsByName("userid")[0].value="";
		document.getElementsByName("userid")[0].focus();
		return false;
	}else if(!regx_id.test(id)){
		alert("아이디는 이메일 형식으로 입력하세요.");
		document.getElementsByName("userid")[0].value="";
		document.getElementsByName("userid")[0].focus();
		return false;
	}
	
	/* 
	 * 패스워드는 영문/숫자/특수문자 포함
	 * 6 ~ 12자리 이내 입력
	 * pwd 
	 */
	if((pwd.length) == 0 || (pwd == null)){
		alert("비밀번호를 입력하세요.");
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}else if((pwd.length) < 6 || (pwd.length) > 12){
		alert("비밀번호는 6 ~ 12자리로 입력하세요.");
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}else if(!regx_pwd.test(pwd)){
		alert("비밀번호는 문자,숫자,특수문자의 조합으로 입력하세요.");
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}else if(pwd != pwd2){
		alert("입력된 비밀번호가 같지 않습니다.")
		document.getElementsByName("userpwd")[0].value="";
		document.getElementsByName("userpwd")[1].value="";
		document.getElementsByName("userpwd")[0].focus();
		return false;
	}
	
	/* 
	 * 권한은 영문만 입력
	 */

	document.getElementById("updateform").submit();
}