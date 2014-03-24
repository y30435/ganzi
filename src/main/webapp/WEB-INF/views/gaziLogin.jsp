<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<script language="javascript" src="../js/script.js" ></script>
</head>
<body onload='document.f.userid.focus();'>
<form name='f' action="ganziList.jsp" method='POST'>
 		<table>
			<tr>
				<td>Username:</td>
				<td><input type='text' size="20" name='userid' class="loginid"/>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' size="20" name='userpwd' class="loginpwd"/>
				</td>
			</tr>
			<tr>
				<td colspan='5'><input type="button" value="login" name="javascript:document.f.loginChk();" /></td>
			</tr>
		</table>
 	</form>
</body>
</html>