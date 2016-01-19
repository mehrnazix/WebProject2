<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Course Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/admin/saveCourse" onsubmit="return formValidation()">
        <input type="hidden" name="id" value="${course.getCourseId()}">

        <fieldset>
            <legend>Add New Course</legend>

            <label>
                <span>Course Code : </span>
                <input class="required" type="number" name="code" value="${course.getCode()}" id="courseCode">

                <div class="requiredField" id="courseCodeRange">Length of Course Code must be 3 digit</div>
                <div class="required_star">*</div>
            </label>

            <label>
                <span>Course Name :</span>
                <input class="required" type="text" name="name" value="${course.getName()}">

                <div class="required_star">*</div>
            </label>

            <label>
                <span>Coefficient : </span>
                <input class="required" type="number" name="coefficient" value="${course.getCoefficient()}"
                       id="coefficient">

                <div class="requiredField" id="coefficientValidation" hidden>Coefficient must be less than 4</div>
                <div class="required_star">*</div>
            </label>

            <label>
                <span>Teacher :</span>
                <select name="teacherId" class="required">
                    <option selected value="${course.getTeacherId()}">${course.getTeacher()}</option>
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher.getTeacherId()}">${teacher}</option>
                    </c:forEach>

                </select>

                <div class="required_star">*</div>
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/admin/viewCourses'">

            </label>

            <label>
                <div class="requiredField" id="fieldIsRequired">All the fields are required!</div>
            </label>

        </fieldset>
    </form>
</div>
<script type="text/javascript" src="/JS/courseValidation.js"></script>
</body>
</html>