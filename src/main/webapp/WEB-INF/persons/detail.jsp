<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person and License</title>
</head>
<body>
<h1>Info</h1>
<h1>${person.firstName} ${person.lastName}</h1>

<h2>State: ${person.license.state}</h2>

<h2>Number: ${person.license.number}</h2>

<h2>Expiration Date: ${person.license.expirationDate}</h2>
</body>
</html>