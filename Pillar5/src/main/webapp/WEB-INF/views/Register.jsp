<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
form {
	margin-left: 30%;
	margin-right: 30%;
	width: 20%;
}

div.groove {
	border-style: groove;
}
input

 

.{
border-style


:


solid
;


}
</style>
</head>
<body>
	<form action="register" method="post">
		<div
			style="text-align: center; height: 150%; width: 200%; background-color: #CC0033;"
			class="groove">
			<h2>Register</h2>
		</div>

		<div
			style="align: center; height: 150%; width: 200%; background-color: #FFFFCC"
			class="groove">
			<br> <b>First Name: </b> <input type="text" name="firstname"
				id="firstname" style="width: 80%; height: 50%;" class="solid"><br>
			<br> <b>Last Name: </b> <input type="text" name="lastname"
				id="lastname" style="width: 80%; height: 50%;" class="solid"><br>
			<br> <b>Mobile:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b> <input
				type="text" name="mobile" id="mobile"
				style="width: 80%; height: 50%;" class="solid"><br> <br>
			<b>Email: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="email" id="email"
				style="width: 80%; height: 50%;" class="solid"><br>
			<br>
		</div>
		<div align="center"
			style="align: center; background-color: #FFCCCC; height: 150%; width: 200%;"
			class="groove">
			<input type="submit" value="Register">
		</div>
	</form>
</body>
</html>