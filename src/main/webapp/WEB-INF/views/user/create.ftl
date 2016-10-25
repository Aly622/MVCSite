<%@ page contentType="text/html;charset=UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>注册</title>
</head>
<body>
	<form:form commandName="user" method="post">
		<table>
			<c:if test="${not empty create_error}">
				<tr>
					<td>
						<div class="alert alert-error">
							<strong>注册出错:</strong>${create_error}
						</div>
					</td>
				</tr>
				<c:remove var="create_error" />
			</c:if>
			<tr>
				<td>
					<div>
						用户名:
						<form:input type="text" path="name" />
					</div>
				</td>
				<td>
					<div>
						邮箱:
						<form:input type="text" path="email" />
					</div>
				</td>
				<td>
					<div>
						密码:
						<form:input type="password" path="password" />
					</div>
				</td>
				<td><input type="submit" id="login-btn" value="注册" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
