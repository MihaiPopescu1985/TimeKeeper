<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Workers</title>
</head>
<body>
  <h1>Workers</h1>
  <a href="/TimeKeeper/Pages/UpdateWorker.jsp">Add new worker.</a>
  <br>
  <table id="workersTable" border="1">
    <tr>
      <th>Id</th>
      <th>First name</th>
      <th>Last name</th>
      <th>Department</th>
      <th>Tag id</th>
    </tr>
    <c:forEach items="${Workers }" var="worker">
      <tr>
        <td>${worker.getId() }</td>
        <td>${worker.getFirstName() }</td>
        <td>${worker.getLastName() }</td>
        <td>${worker.getDepartment() }</td>
        <td>${worker.getTagId() }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>