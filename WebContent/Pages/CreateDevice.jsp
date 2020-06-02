<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add device</title>
</head>
<body>
  <h1>Create a device</h1>
  <form action="/TimeKeeper/AddModel">
    <input type="text" name="model" value="device" style="visibility:hidden">
    <br>
    <label for="DeviceDescription">Description:</label>
    <input type="text" name="DeviceDescription">
    <br>
    <label for="DeviceIp">Device ip:</label>
    <input type="text" name="DeviceIp">
    <br>
    <label for="ProjectId">Project id:</label>
    <input type="number" name="ProjectId">
    <br>
    <button type="submit">CREATE DEVICE</button>
    <br>
  </form>
</body>
</html>