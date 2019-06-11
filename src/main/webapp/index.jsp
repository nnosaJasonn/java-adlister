<%--
  Created by IntelliJ IDEA.
  User: jasonlindsey
  Date: 2019-06-11
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! int counter = 0; %>
<% counter++;%>

<% if (counter == 36){
    counter= counter -5;
};%>

<html>
<head>
    <title>Title</title>

</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<%@ include file="partials/header.jsp" %>
<h1>Current count is <%= counter%></h1>



<%@ include file="partials/FooterLinks.jsp"%>
</body>
</html>
