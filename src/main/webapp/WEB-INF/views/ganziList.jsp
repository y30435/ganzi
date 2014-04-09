<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.ganzi.dto.GanziUserDto" %>
<%
/**
 * JSP : 웹 브라우저에 등록된 회원 리스트가 출력되는 화면
 * @author victoria
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Ganzi Project</title>
<script language="javascript" src="/ganzi/js/jquery-1.11.0.js" ></script>
<script language="javascript" src="/ganzi/js/script.js" ></script>

</head>
<body>
<table border="1" summary="회원 전체목록">
		<div><a href="<c:url value="/logout.do" />">로그아웃</a></div>
		<caption> = 회원정보 = </caption>
		<colgroup>
			<col width="100" />
			<col width="300" />
		</colgroup>
		<thead>
			<tr>
				<th>NO.</th>
				<th>ID(email)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${data}" var="list" varStatus="status">
				<tr>
					<td align="center"><c:out value="${status.count}"></c:out></td>
					<td align="center"><a href="<c:url value="/detail.do?id=${list.userid}" />"><c:out value="${list.userid}" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>