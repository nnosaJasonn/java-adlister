<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <%@include file="/WEB-INF/partials/head.jsp"%>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${user}!</h1>
    </div>
    <form action="${pageContext.request.contextPath}profile" method="post">
        <input type="hidden">
        <button type="submit">Click here to logout!</button>
    </form>

</body>
</html>
