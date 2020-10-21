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
        <form:option value="Brazil" label="Brazil"/>
        <form:option value="France" label="France"/>
        <form:option value="Germany" label="Germany"/>
        <form:option value="India" label="India"/>

    </form:select>
    <br><br>
    <input type="submit" value="Submit">

</form:form>

</body>
</html>
