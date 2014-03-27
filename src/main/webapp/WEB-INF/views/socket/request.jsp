<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix ="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ganzi/css/ganzi.css" />
<style type="text/css">
.item {
	border-width: 2px;
	border-color: #1E90FF;
	border-style: solid;
	padding-left: 5px;
	padding-top: 10px;
	padding-right: 10px;
	padding-bottom: 10px;
	margin-top : 10px;
	margin-left: 10px;
	width:95%;
}


</style>
<title>네이버 검색 오픈 API 접속</title>
</head>
<body>
<h2>검색 결과</h2>
<c:out value="${strRslt}" escapeXml="false"></c:out>
</body>
</html>
