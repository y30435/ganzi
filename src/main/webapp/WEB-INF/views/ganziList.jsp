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
 List<GanziUserDto> newList = (List<GanziUserDto>) request.getAttribute("data");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Ganzi Project</title>
<script language="javascript" src="/ganzi/js/script.js" ></script>

</head>
<body>
<table border="1" summary="회원 전체목록">
		<caption> = 회원정보 = </caption>
		<colgroup>
			<col width="100" />
			<col width="300" />
		</colgroup>
		<thead>
			<tr>
				<th>NO.</th>
				<th>아이디</th>
			</tr>
		</thead>
		<tbody>
			<%
				if(null != newList) {
					int newListSize = newList.size();
					
					if(newListSize > 0) {
						for(int i = 0; newListSize > i; i++ ) {
							GanziUserDto testVO = newList.get(i);
			%>
			<tr>
				<td align="center"><%=i%></td>
				<td align="center"><a href="<c:url value="/detail.do?id=" /><%=testVO.getUserid() %>"><%=testVO.getUserid() %></a></td>
			</tr>
			<%
						}
					}
				}else{
				}
			%>	
		</tbody>
	</table>

</body>
</html>