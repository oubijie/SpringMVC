<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>出错了!</title>
</head>

<body>
<div style="width: 300px; margin: 0px auto; text-align: center; color:#5c5c5c">
<h1>o(╥﹏╥)o</h1>
<h1>error</h1>
<h1>出错了！又有一位程序猿要加班咯~</h1>
${exception }
</div>
</body>
</html>
