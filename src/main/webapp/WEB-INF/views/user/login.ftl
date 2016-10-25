<%@ page contentType="text/html;charset=UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录</title>
</head>
<body>
	<form:form commandName="user" method="post">
		<table>
			<c:if test="${not empty login_error}">
				<tr>
					<td>
						<div class="alert alert-error">
							<strong>登录出错:</strong>${login_error}
						</div>
					</td>
				</tr>
				<c:remove var="login_error" />
			</c:if>
			<tr>
				<td>
					<div class="input-prepend">
						<span class="add-on"><i class="icon-envelope"></i></span>
						邮箱:<form:input type="text" path="email"/>
					</div>
				</td>
				<td>
					<div class="input-prepend">
						<span class="add-on"><i class="icon-lock"></i></span>
						密码:<form:input type="password" path="password"/>
					</div>
				</td>
				<td><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
