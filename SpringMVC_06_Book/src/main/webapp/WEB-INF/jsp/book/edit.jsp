<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增图书</title>
</head>
<body>
<h3>新增图书</h3>
<form action="${ctx }/book/save" method="post">
<input type="hidden" name="id" value="${book.id }"/>
书名：<input type="text" name="name" value="${book.name }"/><br/>
作者：<input type="text" name="author" value="${book.author }"/><br/>
出版日期：<input type="date" name="publishDate" value="${book.publishDate }"/><br/>
<input type="submit" value="保存"/>
</form>
</body>
</html>