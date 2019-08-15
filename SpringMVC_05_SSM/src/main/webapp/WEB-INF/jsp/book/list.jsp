<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表</title>
</head>
<body>
<a href="${ctx}/book/add">新增图书</a>
<table>
<tr><th>ID</th><th>书名</th><th>作者</th></tr>
<c:forEach items="${list }" var="book">
<tr><td>${book.id }</td><td>${book.name }</td><td>${book.author }</td></tr>
</c:forEach>
</table>
</body>
</html>