<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Art gallery</title>
</head>

<body>
    <h1>Art gallery</h1>

    Art currently displayed in the gallery : <br/>
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