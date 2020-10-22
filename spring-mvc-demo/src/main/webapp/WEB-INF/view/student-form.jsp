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
    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    <form:select path="country">
        <form:options items="${theCountryOptions}"/>

    </form:select>
    <br><br>
    <input type="submit" value="Submit">

</form:form>

</body>
</html>
