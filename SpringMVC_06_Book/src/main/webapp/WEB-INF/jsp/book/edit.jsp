<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增图书</title>
</head>
<body>
<h3>新增图书</h3>
<sf:form action="${ctx }/book/save" method="post" enctype="multipart/form-data" modelAttribute="book">
<input type="hidden" name="id" value="${book.id }"/>
书名：<input type="text" name="name" value="${book.name }"/><span><sf:errors path="name"></sf:errors></span><br/>
作者：<input type="text" name="author" value="${book.author }"/><span><sf:errors path="author"></sf:errors></span><br/>
出版日期：<input type="date" name="publishDate" value="${book.publishDate }"/><span><sf:errors path="publishDate"></sf:errors></span><br/>
封面：<input type="file" name="picFile" /><br/>
<input type="submit" value="保存"/>
</sf:form>
</body>
</html>