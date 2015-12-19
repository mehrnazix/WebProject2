<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Class Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/class/save">
        <input type="hidden" name="teacher_id" value="${class.getId()}">

        <fieldset>
            <legend>Add New Class</legend>

            <label>
                <span class="required">Class Number : </span>
                <input type="number" name="code" value="${class.getClassNumber()}">
            </label>

            <label>
                <span class="required">Date :</span>
                <input type="text" name="name" value="${class.getClassDateTime()}">
            </label>

            <label>
                <span class="required">Course : </span>
                <input type="number" name="coefficient" value="${class.getCourseId()}">
            </label>

            <label>
                <span class="required">Teacher :</span>
                <select name="teacherId">
                    <option selected value="${class.getTeacherId()}">${class.getTeacher()}</option>
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.getId()}">${teacher}</option>
                </c:forEach>

                </select>
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/class'">

            </label>
        </fieldset>
    </form>
</div>
</body>
</html>