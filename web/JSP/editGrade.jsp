<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Change Score</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/grade/update">
        <input type="hidden" name="id" value="${grade.getGradeId()}">

        <fieldset>
            <legend>Add New Grade</legend>

            <label>
                <span class="required">Grade Code : </span>
                <input type="number" name="code" value="${grade.getCourse().getCode()}">
            </label>

            <label>
                <span class="required">Grade Name :</span>
                <input type="text" name="name" value="${grade.getCourse().getName()}">
            </label>

            <label>
                <span class="required">Student : </span>
                <input type="text" name="coefficient" value="${grade.getStudent()}">
            </label>

            <label>
                <span class="required">Score : </span>
                <input type="number" name="score" value="${grade.getScore()}">
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/grade/gradesOfTeacher'">
            </label>
        </fieldset>
    </form>
</div>
<script type="text/javascript" src="/JS/gradeValidation.js"></script>
</body>
</html>