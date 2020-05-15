<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>front/memberUpdate.jsp</title>
</head>
<body>
<h3>회원 정보 수정</h3>
<form action="../MemberUpdate.do" method="post">
	ID : <input type="text" name="id" id="id"
			readonly= "readonly" value="${member.id}"/><br/>
	비밀번호 : <input type="password" name="pwd" id="pwd" value="${member.pwd}"/><br/>
	이름 : <input type="text" name="name" id="name" value="${member.name}"/><br/>
	취미 :
		<input type="checkbox" name="hobby" id="hobby1" value="h01"
				<c:if test="${fn:contains(member.hobby,'h01')}">checked="checked" </c:if> /> 등산
		<input type="checkbox" name="hobby" id="hobby2" value="h02" 
				<c:if test="${fn:contains(member.hobby,'h02')}">checked="checked" </c:if> /> 운동
		<input type="checkbox" name="hobby" id="hobby3" value="h03" 
				<c:if test="${fn:contains(member.hobby,'h03')}">checked="checked" </c:if> /> 독서
		<input type="checkbox" name="hobby" id="hobby4" value="h04" 
				<c:if test="${fn:contains(member.hobby,'h04')}">checked="checked" </c:if> /> 여행 <br/>
	성별 :
		<input type="radio" name="gender" value="m" 
				<c:if test="${fn:contains(member.gender,'m')}">checked="checked" </c:if> /> 남자
		<input type="radio" name="gender" value="f" 
				<c:if test="${fn:contains(member.gender,'f')}">checked="checked" </c:if> /> 여자 <br/>
	종교 :
		<select name="religion" id="religion">
			<option value="r01" 
				<c:if test="${fn:contains(member.religion,'r01')}">selected="selected" </c:if>> 기독교</option>
			<option value="r02" 
				<c:if test="${fn:contains(member.religion,'r02')}">selected="selected" </c:if>> 불교</option>
			<option value="r03" 
				<c:if test="${fn:contains(member.religion,'r03')}">selected="selected" </c:if>> 천주교</option>
			<option value="r04" 
				<c:if test="${fn:contains(member.religion,'r04')}">selected="selected" </c:if>> 무교</option>
		</select> <br/>
	자기소개: <br/>
		<textarea rows="10" cols="30" name="introduction" id="introduction">${member.introduction}</textarea><br/>
		
	<input type="submit" value="전송" />
	<input type="reset" value="지우기" />

</form>

</body>
</html>