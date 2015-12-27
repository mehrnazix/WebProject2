<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Grade Student</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>

<div class="form-add-new">
    <form name="gradeForm">
        <fieldset>
            <legend>Grade Profile</legend>

            <label>
                <span>Course Name :</span>
                <input type="text"  id="courseName" name="courseName" value="${grade.getFirstName()}"/>
            </label>

            <label>
                <span>Teacher Name : </span>
                <input type="text" readonly name="teacherName" value="${grade.getCourse().getTeacher()}"/>
            </label>

        </fieldset>
    </form>
</div>

<div>
    <a href="\JSP\studentPage.jsp">First Page</a>
</div>

</body>
</html>