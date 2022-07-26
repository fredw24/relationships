<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
    <%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
<h1>Create New License</h1>
<form:form action="/licenses" method="post" modelAttribute="license">
<p>
        <form:label path="expirationDate">Expiration Date: </form:label>
        <form:errors path="expirationDate"/>
        <form:input type="Date" path="expirationDate"/>
    </p>
    <p>
        <form:label path="state">State: </form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="person">Unregistered Person: </form:label>
        <form:errors path="person"/>
        <form:select path="person">
        	<c:forEach items="${people}" var="person">
        		<option value="${person.getId()}">${person.firstName} ${person.lastName}</option>
        	</c:forEach>
        	</form:select>
    </p>
    
    <button>Submit</button>

</form:form>


</body>
</html>