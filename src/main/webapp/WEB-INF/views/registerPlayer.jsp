<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Player Registration Form</title>
</head>
<body>
<h1>Register Player</h1>
<table>
	<form method="POST">
		<tr>
			<td>First Name: </td><td><input type="text" name="firstName" /></td>
		</tr><tr>
		<td>Last Name: </td><td><input type="text" name="lastName" /></td>
	</tr><tr>
		<td>Age: </td><td><input type="text" name="age" /></td>
	</tr><tr>
		<td>Country Of Birth: </td><td>
		<select id="countries" name="countryOfBirth">
				<option value="Canada">Canada</option>
				<option value="Colombia">Colombia</option>
				<option value="Brazil">Brazil</option>
				<option value="Venezuela">Venezuela</option>
				<option value="France">France</option>
				<option value="Germany">Germany</option>
				<option value="Chine">Chine</option>
				<option value="Congo">Congo</option>
		</select>
	</td>
	</tr><tr>
		<td>Position:</td><td>
		<select name="position" style="width:100%">
			<option value="Goalkeeper">Goalkeeper</option>
			<option value="Defender">Defender</option>
			<option value="Midfielder">Midfielder</option>
			<option value="Forward">Forward</option>
		</select></td>
	</tr><tr>
		<td>Salary: </td><td><input type="text" name="salary" /></td>
	</tr><tr>
		<td colspan="2">Stats</td>
	</tr><tr>
		<td>Number of Goals:</td><td><input type="text" name="goals" /></td>
	</tr><tr>
		<td>Number of Bookins:</td><td><input type="text" name="bookings" /></td>
	</tr><tr>
		<td ><input type="submit" value="Register" /></td>
	</form>
	<form action="/">
		<td><input type="submit" value="Cancel" /></td>
	</form>
	</tr>
</table>

</body>
</html>