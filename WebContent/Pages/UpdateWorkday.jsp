<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add workday</title>
</head>
<body>
  <h1>Create/update a workday</h1>
  
  <form action="/TimeKeeper/AddModel">
    <input type="text" name="model" value="workday" style="visibility:hidden">
    <br>
    <label for="Worker">Worker id:</label>
    <input type="number" name="worker">
    <br>
    <label for="Project">Project id:</label>
    <input type="number" name="Project">
    <br>
    <label for="StartHour">Start hour:</label>
    <input type="datetime-local" name="StartHour">
    <br>
    <label for="StopHour">Stop hour:</label>
    <input type="datetime-local" name="StopHour">
    <br>
    <button type="submit">CREATE/UPDATE WORKDAY</button>
  </form>
</body>
</html>