<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><c:out value="Details about ${trainer.firstName} ${trainer.lastName}" /></title>
</head>
<body>
<div class="trainerView">
  <div class="trainerName"><h1><c:out value="${trainer.firstName} ${trainer.lastName}" /></h1></div>
  <div>
    <span class="trainerInfo">
      <b>Age: </b><c:out value="${trainer.age}" /><br/>
      <b>Salary: </b><c:out value="${trainer.annualSalary}" /><br/>
    </span>
  </div>
  <br/>
  <form action="/">
    <input type="submit" value="Back To Home">
  </form>
</div>
</body>
</html>
