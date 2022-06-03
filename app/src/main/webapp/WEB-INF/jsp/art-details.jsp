<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <button id="shareButton">Share</button>
        <p id="generatedLink"></p>
    </body>

    <script>
        $(document).ready(function(){
            $("#shareButton").click(function(){
               $('#generatedLink').html(window.location.href);
           });
        });
    </script>

</html>