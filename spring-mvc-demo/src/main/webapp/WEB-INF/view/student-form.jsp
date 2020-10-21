<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

<%--@elvariable id="student" type=""--%>
<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName" />
    Last name: <form:input path="lastName"/>

    <br><br>
    <input type="submit" value="Submit">

</form:form>

</body>
</html>
