<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${ctx }/stu/save" method="post">
姓名：<input type="text" name="stuName" /><br/>
年龄：<input type="text" name="age" /><br/>
<input type="submit" value="新增"/>
</form>
<hr/>

<form action="${ctx }/stu/save2" method="post">
姓名：<input type="text" name="stuName" /><br/>
年龄：<input type="text" name="age" /><br/>
城市：<input type="text" name="addr.city" /><br/>
详细地址：<input type="text" name="addr.detail" /><br/>
<input type="submit" value="新增"/>
</form>

</body>
</html>