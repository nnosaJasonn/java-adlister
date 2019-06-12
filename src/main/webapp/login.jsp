<%--
  Created by IntelliJ IDEA.
  User: jasonlindsey
  Date: 2019-06-11
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="partials/header.jsp" %>
<form method="post" action="/profile.jsp">
    <div class="form-group">
        <label for="exampleInputEmail1">username</label>
        <input required type="text" name="username"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone els...</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input required type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>




<%--<c:if test="${param.username != 'admin' && param.password != 'password'}">--%>
    <%--<c:redirect url = "/login.jsp"/>--%>
<%--</c:if>--%>

<c:if test="${param.access == 'no'}">
    <script> alert("you do not have access!") </script>
</c:if>


<%@include file="partials/footlinks.jsp"%>
</body>
</html>
<%--
<c:if test="${param.username != 'admin' && param.password != 'password'}">

    <c:redirect url = "/login.jsp?access=no"/>
</c:if>
--%>