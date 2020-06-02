<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add worker</title>
</head>
<body>
  <h1>Create a worker</h1>
  <form action="/TimeKeeper/AddModel">
    <input type="text" name="model" value="worker" style="visibility:hidden">
    <br>
    <label for="FirstName">First name:</label>
    <input type="text" name="FirstName">
    <br>
    <label for="LastName">Last name:</label>
    <input type="text" name="LastName">
    <br>
    <label for="TagId">Tag id:</label>
    <input type="text" name="TagId">
    <br>
    <label for="Department">Department</label>
    <br>
    <input type="radio" id="electricDepartment" name="Department" value="ELECTRIC">
    <label for="electricDepartment">Electric</label>
    <br>
    <input type="radio" id="mechanicDepartment" name="Department" value="MECHANIC">
    <label for="mechanicDepartment">Mechanic</label>
    <br>
    <input type="radio" id="softwareDevelopment" name="Department" value="SOFTWARE_DEVELOPMENT">
    <label for="softwareDevelopment">Software development</label>
    <br>
    <input type="radio" id="purchasing" name="Department" value="PURCHASING">
    <label for="purchasing">Purchasing</label>
    <br>
    <input type="radio" id="mechanicalProjecting" name="Department" value="MECHANICAL_PROJECTING">
    <label for="mechanicalProjecting">Mechanical projecting</label>
    <br>
    <button type="submit">CREATE WORKER</button>
    <br>
  </form>
</body>
</html>