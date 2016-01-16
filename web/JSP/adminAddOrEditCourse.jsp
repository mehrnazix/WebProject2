<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Course Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/admin/saveCourse">
        <input type="hidden" name="id" value="${course.getCourseId()}">

        <fieldset>
            <legend>Add New Course</legend>

            <label>
                <span class="required">Course Code : </span>
                <input type="number" name="code" value="${course.getCode()}">
            </label>

            <label>
                <span class="required">Course Name :</span>
                <input type="text" name="name" value="${course.getName()}">
            </label>

            <label>
                <span class="required">Coefficient : </span>
                <input type="number" name="coefficient" value="${course.getCoefficient()}">
            </label>

            <label>
                <span class="required">Teacher :</span>
                <select name="teacherId">
                    <option selected value="${course.getTeacherId()}">${course.getTeacher()}</option>
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.getTeacherId()}">${teacher}</option>
                </c:forEach>

                </select>
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/admin/viewCourses'">

            </label>
        </fieldset>
    </form>
</div>
<script type="text/javascript" src="/JS/courseValidation.js"></script>
</body>
</html>