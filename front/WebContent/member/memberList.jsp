<%@page import="co.yedam.app.member.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.mailbg {
	background-color: yellowgreen
};
</style>
<title>front/memberList.jsp</title>
</head>
<body>
	<h3>회원목록</h3>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>등록날짜</td>
			<td>취미</td>
			<td>성별</td>
			<td>종교</td>
			<td>수정</td>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.regdt}</td>
				<td>${vo.hobby}</td>
				<td>${vo.gender}</td>
				<td>${vo.religion}</td>
				<td><a href="MemberUpdateForm.do" ?id=${vo.id}>수정</a></td>
			</tr>
		</c:forEach>
</body>
</html>