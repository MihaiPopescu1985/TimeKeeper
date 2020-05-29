<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Devices</title>
</head>
<body>
  <h1>Devices</h1>
  <a href="/TimeKeeper/Pages/UpdateDevice.jsp">Add a device.</a>
  <br>
  <table id="devicesTable" border="1">
  	<tr>
  	  <th>Id</th>
  	  <th>Description</th>
  	  <th>Ip</th>
  	  <th>Project id</th>
  	</tr>
  	<c:forEach items="${Devices }" var="device">
  	  <tr>
  	    <td>${device.getId() }</td>
  	    <td>${device.getDeviceDescription() }</td>
  	    <td>${device.getDeviceIp() }</td>
  	    <td>${device.getProjectId() }</td>
  	  </tr>
  	</c:forEach>
  </table>
</body>
</html>