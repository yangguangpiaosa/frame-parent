<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User List</title>
</head>
<body>
	<div style="padding:10px;">
		<a href="${pageContext.request.contextPath }/user/toAdd">NEW</a>
	</div>
	<table border="1" style="border-color: red;border-collapse: collapse;" bordercolor="red">
		<tr>
		    <td>name</td>
		    <td>age</td>
		    <td>email</td>
		    <td>action</td>
		</tr>
		
		<c:forEach items="${userList }" var="user">
		<tr>
		    <td><a href="${pageContext.request.contextPath }/user/${user.id }">${user.name }</a></td>
		    <td>${user.age }</td>
		    <td>${user.email }</td>
		    <td><a href="${pageContext.request.contextPath }/user/del?userId=${user.id }">delete</a></td>
		</tr>
		</c:forEach>
	
	</table>
	${message }
</body>
</html>