<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ //taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/**
 * JSP : 웹 브라우저에 회원 등록 가능하도록 출력되는 화면
 * @author victoria
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Ganzi Project</title>
<script language="javascript" src="/ganzi/js/script.js" ></script>

</head>
<body onload='document.joinform.username.focus();'>
<form id='joinform' action="/list" method='POST'>
 		<table>
 			<tr>
 				<td align='center'><b>= 회원가입 =</b></td>
 			</tr>
 			<tr>
				<td>이름:</td>
				<td><input type='text' size="50" name='username' class="joinname"/></td>
			</tr>
			<tr>
				<td>아이디:</td>
				<td><input type='text' size="50" name='userid' class="joinid"/></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type='password' size="50" name='userpwd' class="joinpwd1"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type='password' size="50" name='userpwd' class="joinpwd2"/></td>
			</tr>
			<tr>
				<td colspan='50'><input type="button" value="가입신청" onclick="joinChk();" /></td>
			</tr>
			<tr>
				<td colspan='50'><input type="button" value="가입취소" onclick="window.location.href='login.do'" /></td>
			</tr>
		</table>
 </form>
</body>
</html>
