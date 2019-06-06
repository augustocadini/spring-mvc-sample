<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Employee</title>
</head>
<body>
	<h2>Employee Home - Record a new Employee</h2>
	<form:form method="post" action="addEmployee" modelAttribute="employee">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"/></td>				
			</tr>
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
                <td><form:label path="contactNumber">Contact Number</form:label></td>
                <td><form:input path="contactNumber"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
		</table>
	</form:form>
</body>
</html>