<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
/**
 * JSP : 웹 브라우저에 회원 등록 가능하도록 출력되는 화면
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
<body onload='document.getElementsByName("username")[0].focus()'>
<sf:form id='joinform' action="/ganzi/joinPro.do" method='POST' commandName="ganziUserDto">
 		<table>
 		 	<tr bgcolor="skyblue">
 		 		<td/>
 				<td align='center'><b>회원가입 페이지</b></td>
 			</tr>
 			<tr>
				<td>이름:</td>
				<td><input type="text" size="50" name='username' value="${username}" /><sf:errors path="username" style="color:red" cssClass="error"/></td>
			</tr>
			<tr>
				<td>ID(email):</td>
				<td><input type="text" size="50" name='userid' value="${userid}"/><sf:errors path="userid" style="color:red" cssClass="error"/></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" size="50" name='userpwd' class="joinpwd1"/><sf:errors path="userpwd" style="color:red" cssClass="error"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type="password" size="50" class="joinpwd2"/></td>
			</tr>
			<tr>
				<td align='center' colspan='50'><input type="submit" value="가입신청" /><input type="button" value="가입취소" onclick="window.location.href='login.do'" /></td>
			</tr>
		</table>
 </sf:form>
</body>
</html>
