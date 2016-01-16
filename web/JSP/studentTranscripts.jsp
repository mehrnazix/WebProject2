<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Grade List</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>

<body>

<div class="list-view">
    <fieldset>
        <legend>Student's Course List View</legend>
        <table id="studentCourseMark">
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Teacher Code</th>
                <th>Teacher Name</th>
                <th>Score</th>
            </tr>

            <c:set var="sum" value="${0}"/>
            <c:forEach var="transcript" items="${transcripts}">
                <c:set var="sum" value="${sum+studentCourseItem.getScore()}"/>
                <tr class="pure-table-odd">
                    <td>${transcript.getCourse().getCode()}</td>
                    <td>${transcript.getCourse().getName()}</td>
                    <td>${transcript.getCourse().getTeacher().getCode()}</td>
                    <td>${transcript.getCourse().getTeacher().toString()}</td>
                    <td>${transcript.getScore()}</td>
                </tr>
            </c:forEach>

            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th>${sum}</th>
            </tr>
        </table>
    </fieldset>
</div>

<div>
    <a href="/student">Home</a>
</div>

<script type="text/javascript" src="/JS/studentValidation.js"></script>
</body>
</html>
