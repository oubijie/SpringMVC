<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生列表</title>
</head>
<body>
<h1>学生列表</h1>
<p>param.msg: ${param.msg }</p>
<p>msg: ${msg }</p>
<table border="1">
<tr><th>ID</th><th>name</th><th>age</th></tr>

<c:forEach items="${list }" var="s">
<tr><td>${s.sid }</td><td>${s.stuName }</td><td>${s.age }</td></tr>
</c:forEach>

</table>

</body>
</html>