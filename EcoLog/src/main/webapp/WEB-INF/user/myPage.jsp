<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<form method="post" action="UpdateServlet" name="frm">
		<table align="center" width="600">
			<tr>
				<td colspan="2">My Page</td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${user.id }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="name" value="${user.name }"></td>
			</tr>
			<tr>
				<td>NICKNAME</td>
				<td><input type="text" name="name" value="${user.nickName }"></td>
			</tr>
			<tr>
				<td>BIRTH</td>
				<td><input type="text" name="birth" value="${user.birth }"></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="text" name="email" value="${user.email }"></td>
			</tr>
			<tr>
				<td>PHONENUMBER</td>
				<td><input type="text" name="phoneNumber" value="${user.phoneNumber }"></td>
			</tr>
			<tr align="center">
			<td colspan="2"><input type="submit" value="modify"> &nbsp; <input type="reset" value="cancle"></td></tr>
		</table>
	</form>
</body>
</html>