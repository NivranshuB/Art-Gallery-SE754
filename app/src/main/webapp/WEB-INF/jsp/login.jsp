<html>

<head>
	<title>G2-Gallery</title>
</head>

<body>
	<h1>Login</h1>
	<label><a id="home" href="/">Click here</a> to go back to home</label>
	<h3 id="error" color="red">${errorMessage}</h3>
	<h2>Insert username and password</h2>
	<form method="post">
		Name : <input type="text" name="name" id="name" />
		Password : <input type="password" name="password" id="password"/>
		<input type="submit" id="submitbtn" />
	</form>
</body>

</html>