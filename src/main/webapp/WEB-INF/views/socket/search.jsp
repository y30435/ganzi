<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검색어 입력 화면</title>
</head>
<body>
	<h1>검색어 입력</h1>
	<form id="inputform" action="request.do" method="post">
		<input type="text" name="searchKey" size="30">
		<input type="text" name="searchTarget" size="30" value="blog">
		<input type="submit" value="검색">
	</form>
</body>
</html>