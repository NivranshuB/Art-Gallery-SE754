<html>

<head>
    <title>G2-Gallery</title>
</head>

<body>
    <h1>Manage Account</h1>
    <label><a id="home" href="/">Click here</a> to go back to home</label>
    <h2>Make changes to your account</h2>
    <form method="post" action="/manage-account/username">
        <div style="border:1px solid black; width: 25%; padding: 1%">
            <h4 id="usernameError" style="color: red">${usernameErrorMessage}</h4>
            New Username : <input type="text" name="newUsername" id="newUsername"/>
            <br><br>
            <label id="currentUsername">[Current username: ${loggedInUser.getUsername()}]<label/>
                <br><br>
                <input type="submit" id="submitUsernamebtn"/>
        </div>
    </form>
</body>

</html>