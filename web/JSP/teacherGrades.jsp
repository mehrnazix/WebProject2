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
        <legend>Teacher's Course List View</legend>
        <table id="studentCourseMark">
            <tr>
                <th>Student Name</th>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Score</th>
                <th></th>
            </tr>

            <c:set var="sum" value="${0}"/>
            <c:forEach var="transcript" items="${transcripts}">
                <c:set var="sum" value="${sum + transcript.getScore()}"/>
                <tr class="pure-table-odd">
                    <td>${transcript.getStudent().toString()}</td>
                    <td>${transcript.getCourse().getCode()}</td>
                    <td>${transcript.getCourse().getName()}</td>
                    <td>${transcript.getScore()}</td>
                    <td>
                        <input type="button" value="Give up Score" onclick="giveUpeScore(${transcript.getStudentCourseMarkId()})">
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th>${sum}</th>
                <th></th>
            </tr>
        </table>
    </fieldset>
</div>

<div>
    <a href="\JSP\teacherPage.jsp">Home</a>
</div>

<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>
