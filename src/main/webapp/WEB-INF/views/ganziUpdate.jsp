<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ganzi.dto.GanziUserDto" %>

<%
/**
 * JSP : 웹 브라우저에 회원 상세정보를 수정 가능하도록 출력되는 화면
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
<body>
<form id='updateform' action="/ganzi/updateProc.do" method='POST'>
 		<table>
 			<tr>
 				<td align='center'><b>= 회원정보 수정 =</b></td>
 			</tr>
 			<tr>
				<td>이름:</td>
				<td><input type='text' size="50" name='username' class="joinname" value="${username}"/></td>
			</tr>
			<tr>
				<td>아이디:</td>
				<td><input type='text' size="50" name='userid' class="joinid" value="${userid}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type='password' size="50" name='userpwd' class="joinpwd1" value="${userpwd}"/></td>
			</tr>
			<tr>
				<td>비밀번호 확인:</td>
				<td><input type='password' size="50" name='userpwd' class="joinpwd2" value="${userpwd}"/></td>
			</tr>
			<tr>
				<td>권한 설정:</td>
			<td><input type='text' size="50" name='userrole' class="userrole" value="${userrole}"/></td>
			</tr>
			<tr>
				<td colspan='50'><input type="button" value="수정확인" onclick="updateChk();" /></td>
			</tr>
			<tr>
				<td colspan='50'><a href="<c:url value="/deleteProc.do?id=${userid}" />"><input type="button" value="회원탈퇴" /></a></td>
			</tr>    
		</table>
</form>
</body>
</html>