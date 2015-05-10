<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Edit</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/user/${userId }/edit" method="POST" commandName="user">
		id:<form:input path="id" value="${id }" readonly="readonly"/><br>
		name:<form:input path="name" value="${name }"/><br>
		age:<form:input path="age" value="${age }"/><br>
		email:<form:input path="email" value="${email }"/><br>
		<input type="submit"/><br>
		<form:errors path="*"/>
	</form:form>
</body>
</html>