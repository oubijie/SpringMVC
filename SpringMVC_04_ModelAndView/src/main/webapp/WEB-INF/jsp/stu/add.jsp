<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增学生</title>
</head>
<body>
<h1>新增学生</h1>

<form action="save" method="post">
学生姓名：<input type="text" name="stuName1" /><br/>
学生年龄：<input type="text" name="age" /><br/>
<input type="submit" value="submit"/>
</form>

<hr/>

<form action="save2" method="post">
学生姓名：<input type="text" name="stuName" /><br/>
学生年龄：<input type="text" name="age" /><br/>
学生city：<input type="text" name="addr.city" /><br/>
学生detail：<input type="text" name="addr.detail" /><br/>
<input type="submit" value="submit"/>
</form>
</body>
</html>