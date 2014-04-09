<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/ganzi/css/ganzi.css" />
<title>검색어 입력 화면</title>
</head>
<body>
<script language="javascript" src="/ganzi/js/jquery-1.11.0.js" ></script>
<script>
$(document).ready(function(){
	$(".opt").hide();
	if($("#searchSite").val() == "naver")
		$(".naver").show();
	else if($("#searchSite").val() == "daum")
		$(".daum").show();

	$("#searchSite").change(function(){
		$(".opt").hide();
		if($("#searchSite").val() == "naver")
			$(".naver").show();
		else if($("#searchSite").val() == "daum")
			$(".daum").show();
	});
});
</script>
	<h1>검색어 입력</h1>
	<form id="inputform" action="request.do" method="post">
		<select id="searchSite" name="searchSite">
			<option value="naver" ${searchSite == 'naver' ? 'selected' : ''}>네이버</option>
			<option value="daum" ${searchSite == 'daum' ? 'selected' : ''}>다음</option>
		</select>
		<input type="text" name="searchKey" size="30" value="${searchKey}">
		<!-- <input type="text" name="searchTarget" size="30" value="blog"> -->
		<select name="searchTargetNaver" class="opt naver">
			<option value="kin" ${searchTarget == 'kin' ? 'selected' : ''}>지식인</option>
			<option value="blog" ${searchTarget == 'blog' ? 'selected' : ''}>블로그</option>
			<option value="news" ${searchTarget == 'news' ? 'selected' : ''}>뉴스</option>
			<option value="book" ${searchTarget == 'book' ? 'selected' : ''}>책</option>
			<option value="cafe" ${searchTarget == 'cafe' ? 'selected' : ''}>카페</option>
			<option value="encyc" ${searchTarget == 'encyc' ? 'selected' : ''}>백과사전</option>
			<option value="movie" ${searchTarget == 'movie' ? 'selected' : ''}>영화</option>
			<option value="car" ${searchTarget == 'car' ? 'selected' : ''}>자동차</option>
			<option value="image" ${searchTarget == 'image' ? 'selected' : ''}>이미지</option>
			<option value="shop" ${searchTarget == 'shop' ? 'selected' : ''}>쇼핑</option>
			<option value="doc" ${searchTarget == 'doc' ? 'selected' : ''}>전문자료</option>
			<option value="error" ${searchTarget == 'error' ? 'selected' : ''}>에러</option>
		</select>
		<select name="searchSortNaver" class="opt naver">
			<option value="sim">정확도</option>
			<option value="date">최신순</option>
		</select>
		<select name="searchTargetDaum" class="opt daum">
			<option value="blog" ${searchTarget == 'blog' ? 'selected' : ''}>블로그</option>
			<option value="cafe" ${searchTarget == 'cafe' ? 'selected' : ''}>카페</option>
			<option value="board" ${searchTarget == 'board' ? 'selected' : ''}>게시판</option>
			<option value="vclip" ${searchTarget == 'vclip' ? 'selected' : ''}>동영상</option>
			<option value="web" ${searchTarget == 'web' ? 'selected' : ''}>웹</option>
			<option value="image" ${searchTarget == 'image' ? 'selected' : ''}>이미지</option>
			<option value="knowledge" ${searchTarget == 'knowledge' ? 'selected' : ''}>지식</option>
			<option value="book" ${searchTarget == 'book' ? 'selected' : ''}>책</option>
		</select>
		<input type="submit" value="검색">
	</form>
	
<h2>검색 결과</h2>
<c:out value="${strRslt}" escapeXml="false"></c:out>
</body>
</html>