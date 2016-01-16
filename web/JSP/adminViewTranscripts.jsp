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
        <label>
            <span class="required">Course :</span>
            <form action="/admin/viewStudentsOfSelectedCourse" method="POST">
            <select name="courseId" id="courseId" onchange=viewStudentsOfSelectedCourse()>
                <option selected >${transcriptList[0].getCourse()}</option>
                <c:forEach var="course" items="${courseList}">
                    <option value="${course.getCourseId()}">${course}</option>
                </c:forEach>

            </select>
            </form>
        </label>

        <lable>${transcriptList[0].getCourse().getCode()}</lable>
        <lable>${transcriptList[0].getCourse().getName()}</lable>
        <lable>${transcriptList[0].getCourse().getTeacher().getCode()}</lable>
        <lable>${transcriptList[0].getCourse().getTeacher().toString()}</lable>

        <legend>Student's Course List View</legend>
        <table id="studentCourseMark">
            <tr>
                <th>Student Code</th>
                <th>Student Name</th>
                <th>Score</th>
            </tr>

            <c:set var="sum" value="${0}"/>
            <c:forEach var="transcript" items="${transcriptList}">
                <c:set var="sum" />
                <tr class="pure-table-odd">
                    <td>${transcript.getStudent().getCode()}</td>
                    <td>${transcript.getStudent().toString()}</td>
                    <td>${transcript.getScore()}</td>
                </tr>
            </c:forEach>

            <tr>

                <th></th>
                <th></th>
                <th>${sum}</th>
            </tr>
        </table>
    </fieldset>
</div>

<div>
    <a href="/admin">Home</a>
</div>

<script type="text/javascript" src="/JS/adminValidation.js"></script>
</body>
</html>
