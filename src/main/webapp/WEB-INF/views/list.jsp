<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ganzi.dto.GanziUserDto" %>
<% List<GanziUserDto> data = (List<GanziUserDto>) request.getAttribute("data"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>목록</h1>
<table border="1">
<tr>
	<th>아이디</th>
</tr>

<%
	if(null != data) {
		int dataSize = data.size();
		
		if(dataSize > 0) {
			for(int i = 0; dataSize > i; i++ ) {
				GanziUserDto ganziUserDto = data.get(i);
%>
				<tr>
					<td><%=ganziUserDto.getUserid() %></td>
				</tr>
<%
			}
		}
	}
%>
</table>
</body>
</html>