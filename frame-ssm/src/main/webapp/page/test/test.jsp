<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
<table width="600px" style="border-color: blue; border-collapse: collapse;">
	<tr>
		<td>empNo</td>
		<td>empName</td>
		<td>empSalary</td>
		<td>empDate</td>
	</tr>
	<s:iterator value="empList">
	<tr>
		<td><s:property value="empNo"/></td>
		<td><s:property value="empName"/></td>
		<td><s:property value="empSalary"/></td>
		<td><s:property value="hiredate"/></td>
	</tr>
	</s:iterator>
</table>
</body>
</html>