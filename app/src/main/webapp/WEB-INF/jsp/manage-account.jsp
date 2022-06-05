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
    <form method="post" action="/manage-account/password">
        <div style="border:1px solid black; width: 25%; padding: 1%">
            <i>Password must contain a digit, a capital letter and at least 6 chars</i>
            <h4 id="passwordError" style="color: red">${passwordErrorMessage}</h4>
            <h4 id="passwordSuccess" style="color: forestgreen">${passwordSuccessMessage}</h4>
            Current Password : <input type="text" name="currentPassword" id="currentPassword"/>
            <br><br>
            New Password : <input type="text" name="newPassword" id="newPassword"/>
            <br><br>
            Retype New Password : <input type="text" name="retypedPassword" id="retypedPassword"/>
            <br><br>
            <input type="submit" id="submitPasswordbtn"/>
        </div>
    </form>
    <div>
        <div style="border:1px solid black; width: 25%; padding: 1%; display: inline-block">\
            <form method="post" action="/manage-account/shipping">
                Shipping address : <input type="text" name="address" id="address"/>
                <br><br>
                Shipping preferences : <input type="text" name="preferences" id="preferences"/>
                <br><br>
                <input type="submit" id="submitShippingbtn"/>
            </form>
        </div>
        <div style="border:1px solid black; width: 25%; padding: 1%; display: inline-block; margin-left: 4%">
            <label id="currentAddress">Current Shipping address : ${loggedInUser.getShippingDetails().getAddress()}<label/>
            <br><br>
            <label id="currentPreferences">Current Shipping preferences : ${loggedInUser.getShippingDetails().getPreferences()}<label/>
            <br><br>
            <button id="deleteShippingbtn">Delete</button>
        </div>
    </div>
</body>

</html>