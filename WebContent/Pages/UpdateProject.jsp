<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update project</title>
</head>
<body>
  <h1>Create/update a project</h1>
  <form action="/TimeKeeper/AddModel">
    <input type="text" name="model" value="project" style="visibility:hidden">
    <br>
    <label for="RoNumber">Romanian number:</label>
    <input type="text" name="RoNumber">
    <br>
    <label for="GeNumber">German number:</label>
    <input type="text" name="GeNumber">
    <br>
    <label for="Description">Description:</label>
    <input type="text" name="Description">
    <br>
    <label for="DeviceIp">Device ip:</label>
    <input type="text" name="DeviceIp">
    <br>
    <button type="submit">CREATE/UPDATE PROJECT</button>
  </form>
</body>
</html>