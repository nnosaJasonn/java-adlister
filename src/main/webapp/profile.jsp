<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: jasonlindsey
  Date: 2019-06-11
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%@include file="partials/nav.jsp"%>
<%@include file="partials/header.jsp"%>
</head>
<body>


<c:if test="${param.username != 'admin' && param.password != 'password'}">

    <c:redirect url = "/login.jsp?access=no"/>
</c:if>

<p>Welcome, ${param.username}!</p>
<p>your password is: ${param.password}!</p>


<%@include file="partials/footlinks.jsp"%>
</body>
</html>
