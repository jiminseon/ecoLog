<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div align="center">
    <h2>랭킹</h2>
    <c:forEach var="rankList" items="${rankList}" varStatus="i">
         		${rankList.nickname} ${rankList.point} <br> 
     </c:forEach>
     </div>