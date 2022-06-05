<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Virtual Gallery</title>
</head>

<body>
    <h1>Virtual Gallery</h1>
    <br>
    <div id="arts">
        <c:forEach items="${lists}" var="entry">
            ------------------------------------------------------------------------
            <h5 id="image">"src/test/java/A4/G2/model/artwork/testImage${entry.title.split(" ")[1]}.png"</h5>
            <h5 id="title">${entry.title}</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>
</body>

</html>