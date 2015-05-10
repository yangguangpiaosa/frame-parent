<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Detail</title>
</head>
<body>
	name:${user.name }<br>
	age:${user.age }<br>
	email:${user.email }<br>
	<a href="${pageContext.request.contextPath }/user/${user.id }/toEdit">edit</a>
</body>
</html>