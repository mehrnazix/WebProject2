<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Course List</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
    <input type="button" value="Select Course" class="init-button" onclick="window.location.href='/student/selectCourse'">
</head>

<body>

<div class="list-view">
    <fieldset>
        <legend>Student's Course List View</legend>
        <table id="studentCourseMark">
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Course Coefficient</th>
                <th>Teacher Name</th>
                <th></th>
            </tr>

            <c:set var="sum" value="${0}"/>
            <c:forEach var="courseOfStudent" items="${courseListOfStudent}">
                <c:set var="sum" value="${sum + courseOfStudent.getCourse().getCoefficient()}"/>

                <tr class="pure-table-odd">
                    <td>${courseOfStudent.getCourse().getCode()}</td>
                    <td>${courseOfStudent.getCourse().getName()}</td>
                    <td>${courseOfStudentcourseOfStudent.getCourse().getCoefficient()}</td>
                    <td>${studentCourse.getCourse().getTeacher().toString()}</td>
                    <td>
                        <input type="button" value="Remove"
                               onclick="deleteCourse(${courseOfStudent.getStudentCourseMarkId()})">
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <th></th>
                <th></th>
                <th>${sum}</th>
                <th></th>
                <th></th>
            </tr>
        </table>
    </fieldset>
</div>

<a href="/student">Home</a>

<script type="text/javascript" src="/JS/studentValidation.js"></script>

</body>
</html>
