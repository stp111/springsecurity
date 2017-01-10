<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style type="text/css">
body {
	font-family: "Heiti SC", "Microsoft Yahei", STXihei, Hei, SimSun;
	background-color: #f9f9f2;
	height: 100%;
}

form {
	text-align: center;
	position: absolute;
	top: 100px;
	left: 100px;
}

h2 {
	text-align: center;
}

.div_body {
	width: 60%;
	position:absolute;
	left: 20%;
}

form table label {
	text-align: right;
}
</style>
</head>
<body >

<div class="div_body">
	<h2>My Login Form</h2>
	<form id="loginForm" method="post" action="<c:url value="/j_spring_security_check"/>">
		<table>
			<tr>
				<td><label>id</label></td>
				<td><input type="text" name="j_username"></td>
			</tr>

			<tr>
				<td><label>password</label></td>
				<td><input type="password" name="j_password"></td>
			</tr>

			<tr >
				<td align="right" colspan="2"><input type="submit" name="登录"> <input type="reset"
					name="清除"></td>
			</tr>

		</table>

	</form>
</div>
</body>
</html>