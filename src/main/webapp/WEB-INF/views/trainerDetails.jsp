<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title><c:out value="Details about ${trainer.firstName} ${trainer.lastName}" /></title>
</head>
<body>
<h2><c:out value="${trainer.firstName} ${trainer.lastName}" /></h2>
    <span>
      <b>Age: </b><c:out value="${trainer.age}" /><br/>
      <b>Salary: </b><c:out value="${trainer.annualSalary}" /><br/>
    </span>
  <br/>
  <form action="/">
    <input type="submit" value="Back To Home">
  </form>
</body>
</html>
