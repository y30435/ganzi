<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ganzi.dto.GanziUserDto" %>
<%
/**
 * JSP : 웹 브라우저에 회원 상세정보가 출력되는 화면
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
<table border="1" summary="회원 상세정보">
		<caption> = 회원정보 = </caption>
		<colgroup>
			<col width="300" />
			<col width="100" />
		</colgroup>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center">${userid}</td>
				<td align="center">${username}</td>
			</tr>
		</tbody>
	</table>
			<tr>
				<td colspan='50'><a href="<c:url value="/update.do?id=${userid}" />"><input type="button" value="수정하기" /></a></td> 		
			</tr>
</body>
</html>