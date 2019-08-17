<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册</title>
<script type="text/javascript" src="${ctx }/static/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	/* $(function(){
		$("input[name='username']").blur(function(){
			var url = "${ctx}/exists";
			$.get(url, {username: $(this).val()}, function(result){
				console.debug(result);
				if(result.exists){
					$("#user_err").html("该用户名已被注册！");
				}else{
					$("#user_err").html("");
				}
			});
		});
	}); */
	
	$(function(){
		$("input[name='username']").blur(function(){
			$.ajax({
				type: "POST",
				url: "${ctx}/exists2",
				dataType: "json",
				data: "{username: "+ $(this).val() +"}", 
				success: function(result){
					console.debug(result);
					if(result.exists){
						$("#user_err").html("该用户名已被注册！");
					}else{
						$("#user_err").html("");
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<div>
		<form action="${ctx }/register" method="post">
			用户名：<input name="username" type="text" placeholder="用户名" /><span id="user_err"></span> <br/>
			密码：<input name="password" type="password" placeholder="密码" /> <br/>
			密码确认：<input name="password2" type="password" placeholder="密码确认" /><br/>
			<input type="submit" value="注册" />
		</form>
	</div>
</body>
</html>
