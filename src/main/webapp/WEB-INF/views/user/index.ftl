<#setting classic_compatible=true>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionUser==null||sessionUser.id==null}">
			<form action="/user/login.action" method="post">
				邮箱:
				<input type="text" name="email" value="" />
				密码:
				<input type="text" name="password" value="" />
				<input type="submit" value="登陆" />
			</form>
			<a href="/user/create.action">注册</a>
		</c:when>
		<c:otherwise>
		${sessionUser.name}已登陆,<a href="/user/logout.action">注销</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
