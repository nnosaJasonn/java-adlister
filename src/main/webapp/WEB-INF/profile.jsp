<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user}!</h1>
    </div>


    <div class="container">
        <h1>Here Are all ${sessionScope.user}'s ads!</h1>

        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2><c:out value = "${ad.title}"/></h2>
                <p><c:out value="${ad.description}"/></p>
                <form action="/profile" method="post">
                    <input name="title" value="${ad.id}"type="hidden">
                <button>Delete this ad</button>
                </form>
            </div>
        </c:forEach>

    <a href="/ads/create">click here to create a new ad</a>
    </div>

    <div class="container">
        <h3>Delete account <small style="color:red">warning: this action cannot be undone!</small></h3>
        <a href="/delete-account">Delete my account</a>
    </div>

</body>
</html>
