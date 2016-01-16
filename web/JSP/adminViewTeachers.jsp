<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Teacher List</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">

    <input type="button" value="Add Teacher" class="init-button" onclick="window.location.href='/admin/createTeacher'">


</head>

<body>

<div class="list-view">
    <fieldset>
        <legend>Teacher List View</legend>
        <table id="teacherTableId">
            <tr>
                <th>National Code</th>
                <th>Teacher Code</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Mobile Number</th>
                <th>Address</th>
                <th></th>
            </tr>

            <c:forEach var="teacherItem" items="${teacherList}">
                <tr class="pure-table-odd">
                    <td>${teacherItem.getNationalCode()}</td>
                    <td>${teacherItem.getCode()}</td>
                    <td>${teacherItem.getFirstName()}</td>
                    <td>${teacherItem.getLastName()}</td>
                    <td>${teacherItem.getEmail()}</td>
                    <td>${teacherItem.getPhoneNumber()}</td>
                    <td>${teacherItem.getMobileNumber()}</td>
                    <td>${teacherItem.getAddress()}</td>
                    <td>
                        <input type="button" value="Edit" onclick="updateRow(${teacherItem.getTeacherId()})">
                        <input type="submit" value="Delete" onclick="deleteRow(${teacherItem.getTeacherId()})">
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>

<div>
    <a href="\JSP\adminPage.jsp">Home</a>
</div>

<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>
