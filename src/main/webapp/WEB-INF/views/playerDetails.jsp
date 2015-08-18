<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title><c:out value="Details about ${player.firstName} ${player.lastName}" /></title>
</head>
<body>
	<h2><c:out value="${player.firstName} ${player.lastName}" /></h2>
    <span>
      <b>Country of Birth: </b><c:out value="${player.countryOfBirth}" /><br/>
      <b>Age: </b><c:out value="${player.age}" /><br/>
      <b>Salary: </b><c:out value="${player.annualSalary}" /><br/>
      <b>Position: </b><c:out value="${player.position}"/><br/>
      <b>Stats</b><br/>
      <b>Number of Goals: </b><c:out value="${player.statistics.numberOfGoals}" /><br/>
      <b>Number of Goals: </b><c:out value="${player.statistics.numberOfBookings}" /><br/>
    </span>
	<br/>
	<form action="/">
		<input type="submit" value="Back To Home">
	</form>
</body>
</html>
