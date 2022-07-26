<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of People</title>
</head>
<body>
<h1>List of People</h1>

<tbody>
        <c:forEach items="${people}" var="person">
        <tr>
            <a href="/persons/${person.id }">
            <td><c:out value="${person.firstName}"/></td>
            <td><c:out value="${person.lastName}"/></td>
            </a>
        </tr><br>
        </c:forEach>
    </tbody>

</body>
</html>