<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add workday</title>
</head>
<body>
  <h1>Create a workday</h1>
  
  <form action="/TimeKeeper/AddModel?model=workday">
    <input type="text" name="model" value="workday" style="visibility:hidden">
    <br>
    <label for="WorkerId">Worker id:</label>
    <input type="number" name="WorkerId">
    <br>
    <label for="ProjectId">Project id:</label>
    <input type="number" name="ProjectId">
    <br>
    <label for="StartHour">Start hour (YYYY-MM-DD HH:MM:SS):</label>
    <input type="datetime-local" name="StartHour">
    <br>
    <label for="StopHour">Stop hour (YYYY-MM-DD HH:MM:SS):</label>
    <input type="datetime-local" name="StopHour">
    <br>
    <button type="submit">CREATE WORKDAY</button>
  </form>
</body>
</html>