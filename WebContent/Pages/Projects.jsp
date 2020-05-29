<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projects</title>
</head>
<body>
  <h1>Projects</h1>
  <a href="/TimeKeeper/Pages/UpdateProject.jsp">Add a project.</a>
  <br>
  <table id="projectsTable" border="1">
    <tr>
      <th>Id</th>
      <th>Ro number</th>
      <th>Ge number</th>
      <th>Description</th>
      <th>Device ip</th>
    </tr>
    <c:forEach items="${Projects }" var="project">
      <tr>
        <td>${project.getId() }</td>
        <td>${project.getRoNumber() }</td>
        <td>${project.getGeNumber() }</td>
        <td>${project.getDescription() }</td>
        <td>${project.getDeviceIp() }</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>