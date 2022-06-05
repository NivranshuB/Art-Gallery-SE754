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
            <h5>"src/test/java/A4/G2/model/artwork/testImage${entry.title.split(" ")[1]}.png"</h5>
            <h5>${entry.title}</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>

    Art currently displayed on sale : <br/>
    <div id="sales">
        <c:forEach items="${saleLists}" var="entry">
            ------------------------------------------------------------------------
            <h5>"src/test/java/A4/G2/model/artwork/testImage${entry.artPiece.title.split(" ")[1]}.png"</h5>
            <h5>${entry.artPiece.title}</h5>
            <h5>${entry.getSaleType()}</h5>
            <h5>${entry.price}</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>

    Display section : <br/>
    <div id="display">
        <c:forEach items="${imageLists}" var="entry">
            ------------------------------------------------------------------------
            <h5>"src/test/java/A4/G2/model/artwork/testImage${entry.title.split(" ")[1]}.png"</h5>
            ------------------------------------------------------------------------
        </c:forEach>
    </div>

</body>

</html>