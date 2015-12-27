<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link href="/CSS/formsStyle.css" type="text/css" rel="stylesheet">
</head>

<body>
<div class="start_panel">
    <fieldset>
        <legend>Admin Panel</legend>

        <input type="button" class="button_in_start_page" value="Teacher List View" onclick="window.location.href='/admin/viewTeachers'">
        <input type="button" class="button_in_start_page" value="Student List View" onclick="window.location.href='/admin/viewStudents'">
        <input type="button" class="button_in_start_page" value="Course List View" onclick="window.location.href='/admin/viewCourses'">
        <input type="button" class="adminButton" value="Logout" onclick="window.location.href='/index/destroy'">

    </fieldset>
</div>
</body>
</html>