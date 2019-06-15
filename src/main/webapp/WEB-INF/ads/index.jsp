<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">${ad.title}</h3>
            </div>
            <div class="panel-body">
                ${ad.description}
            </div>
        </div>
    </c:forEach>
<a href="/ads/create">Click here to create a new ad</a>
</div>




</body>
</html>
