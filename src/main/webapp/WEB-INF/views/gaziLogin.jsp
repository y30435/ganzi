<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%
/**
 * JSP : 웹 브라우저에 회원 로그인 가능하도록 출력되는 화면
 * @author victoria
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ganzi Project</title>
<script language="javascript" src="/ganzi/js/jquery-1.11.0.js" ></script>
<script language="javascript" src="/ganzi/js/script.js" ></script>

</head>
<body>
<c:if test="${'fail' eq auth}">
	<div style="color:red">
		로그인에 실패 하였습니다.<br />
		원인 : 
		<c:if test="${'User Not Found' eq ErrorMsg}">
			사용자를 찾을 수 없습니다.
		</c:if>
		
		<c:if test="${'Bad credentials' eq ErrorMsg}">
			비밀번호가 맞지 않습니다.
		</c:if>
	</div>
</c:if>
        
<form id='loginform' action="/ganzi/j_spring_security_check" method='POST'>
 		<table>
 		 	<tr>
 				<td align='center'><b>= login =</b></td>
 			</tr>
			<tr>
				<td>아이디:</td>
				<td><input type='text' size="50" name='j_username' class="loginid"/></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type='password' size="50" name='j_password' class="loginpwd"/></td>
			</tr>
			<tr>
				<td align='center' colspan='50'><input type="submit" value="login" class="loginchk" />
				<a href="<c:url value="/join.do" />"><input type="button" value="회원가입" /></a></td>
			</tr>
		</table>
 </form>
</body>
</html>
