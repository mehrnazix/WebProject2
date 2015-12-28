<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Change Score</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/teacher/saveGrade">
        <input type="hidden" name="id" value="${grade.getStudentCourseMarkId()}">

        <fieldset>
            <legend>Edit Grade</legend>

            <label>
                <span class="required">Grade Code : </span>
                <input type="number" readonly name="code" value="${grade.getCourse().getCode()}">
            </label>

            <label>
                <span class="required">Grade Name :</span>
                <input type="text" readonly name="name" value="${grade.getCourse().getName()}">
            </label>

            <label>
                <span class="required">Student : </span>
                <input type="text" readonly name="coefficient" value="${grade.getStudent()}">
            </label>

            <label>
                <span class="required">Score : </span>
                <input type="number" name="score" value="${grade.getScore()}">
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/teacher/teacherGrades'">
            </label>
        </fieldset>
    </form>
</div>
<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>