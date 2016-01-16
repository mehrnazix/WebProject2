<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Give Up Score</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/teacher/saveTranscript">
        <input type="hidden" name="id" value="${transcript.getStudentCourseMarkId()}">

        <fieldset>
            <legend>Give Up Score</legend>

            <label>
                <span class="required">Grade Code : </span>
                <input type="number" readonly name="code" value="${transcript.getCourse().getCode()}">
            </label>

            <label>
                <span class="required">Grade Name :</span>
                <input type="text" readonly name="name" value="${transcript.getCourse().getName()}">
            </label>

            <label>
                <span class="required">Student : </span>
                <input type="text" readonly name="coefficient" value="${transcript.getStudent()}">
            </label>

            <label>
                <span class="required">Score : </span>
                <input type="number" name="score" value="${transcript.getScore()}">
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/teacher/grades'">
            </label>
        </fieldset>
    </form>
</div>
<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>