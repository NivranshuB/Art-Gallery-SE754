<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>G2-Gallery</title>
</head>

<body>
    <h1>G2 - Gallery Web App!</h1>
    <c:choose>
        <c:when test="${loggedInUser.equals('')}">
            <label><a id="login" href="/login">Click here</a> to login to an account.</label>
            <br>
            <label><a id="signup" href="/signup">Click here</a> to sign up for an account.</label>
        </c:when>
        <c:otherwise>
            <label><a id="logout" href="/logout">Click here</a> to logout of your account.</label>
            <br>
            <h3 id="message">Welcome ${loggedInUser.getUsername()}!</h3>
        </c:otherwise>
    </c:choose>
</body>

</html>