<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Workdays</title>
</head>
<body>
  <h1>Workdays</h1>
  <a href="/TimeKeeper/Pages/CreateWorkday.jsp">Add workday</a>
  <br>
  <table id="workdaysTable" border="1">
    <tr>
      <th>Id</th>
      <th>Worker id</th>
      <th>Project id</th>
      <th>Time started</th>
      <th>Time stopped</th>
    </tr>
    <c:forEach items="${Workdays }" var="workday">
      <tr>
        <td>${workday.getId() }</td>
        <td>${workday.getWorker() }</td>
        <td>${workday.getProject() }</td>
        <td>${workday.getStartHour() }</td>
        <td>${workday.getStopHour() }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>