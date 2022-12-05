<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="org.slf4j.Logger" %>
<%@page import="org.slf4j.LoggerFactory" %>
<%-- <%@page import="java.util.*, model.*" %> --%>
<!DOCTYPE html>
<%--private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

	@SuppressWarnings("unchecked") 
	User user = (User)request.getAttribute("user1");
	log.debug("joimm" + user1.toString());
--%>
<html>
<head>
<meta charset="UTF-8">
<title>가입폼</title>
</head>
<body>
    <h2>모임 가입하기</h2>
    <table border="2" width=250 bordercolor="green" cellspacing="2"
        bordercolor="green">
        <form action="userInfoTable.jsp" method="post">
            <tr>
                <td>이름 :</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>전화번호 :</td>
                <td>${user.phoneNumber}</td>
            </tr>
            <tr>
                <td>이메일 :</td>
                <td><input type="text" name="email">@ <select name="email">
                        <option value="1">naver.com</option>
                        <option value="2">dongduk.co.kr</option>
                        <option value="3">gmail.com</option>
                </select></td>
            </tr>
            <tr>
                <td>생년월일 :</td>
                <td>${user.birth}</td>
            </tr>
            <tr>
                <td>활동명 :</td>
                <td><input type="text" name="meetName"></td>
            </tr>
            <tr>
                <td>동기 :</td>
                <td><input type="text" name="motive"></td>
            </tr>
            <tr>
                <td align="center" colspan=2><input type="submit" value="입력">
                    <input type="reset" value="취소"></td>
                    </tr>
                    </form>
    </table>
</body>
</html>
