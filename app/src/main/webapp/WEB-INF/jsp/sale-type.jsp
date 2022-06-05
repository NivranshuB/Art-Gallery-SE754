<html>

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Art gallery</title>
</head>

<body>
<h1>Art gallery</h1> - ${saleType} items
<br><br>
<div id="sales">
    <c:forEach items="${saleList}" var="entry">
        ------------------------------------------------------------------------
        <h5>Image: "src/test/java/A4/G2/model/artwork/testImage${entry.artPiece.title.split(" ")[1]}.png"</h5>
        <h5>Title: ${entry.artPiece.title}</h5>
        <h5>Sale type: ${entry.getSaleType()}</h5>
        <h5>Price: $${entry.price}</h5>
        ------------------------------------------------------------------------
    </c:forEach>
</div>

</body>

</html>