<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <div>Login status:</div>
        <div id="loginStatus">Not logged in</div>
        <button id="shareButton">Share</button>
        <p id="generatedLink"></p>
        <input id="ageField"></input>
        <button id="buyNowButton">Buy Now</div>
        <div id="loginNotification"></div>
        <div id="ageNotification"></div>
    </body>

    <script>
        $(document).ready(function(){
            $("#shareButton").click(function(){
               $('#generatedLink').html(window.location.href);
           });
            $("#buyNowButton").click(function(){
                if(document.getElementById('loginStatus').innerHTML=="Not logged in") {
                    $('#loginNotification').html("Please sign up or log in.");
                } else {
                    $('#loginNotification').html("Placeholder - success");
                }
                if(parseInt($("#ageField").val())<16) {
                    $('#ageNotification').html("You are too young to purchase art.");
                } else {
                    $('#ageNotification').html("Placeholder - old enough");
                }
           });
        });
    </script>

</html>