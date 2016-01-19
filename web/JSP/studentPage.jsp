<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>Student Panel</title>
    <link href="/CSS/formsStyle.css" type="text/css" rel="stylesheet">
</head>

<body>
<div class="start_panel">
    <fieldset>
        <legend>Student Panel</legend>

        <input type="button" class="button_in_start_page" value="Profile" onclick="window.location.href='/student/profile'">
        <input type="button" class="button_in_start_page" value="Transcripts" onclick="window.location.href='/student/transcripts'">
        <input type="button" class="button_in_start_page" value="Choose Courses" onclick="window.location.href='/student/chooseCourses'">
        <input type="button" class="button_in_start_page" value="Change Password" onclick="window.location.href='/student/changePassword'">
        <input type="button" class="button_in_start_page" value="Logout" onclick="window.location.href='/Index/logout'">

    </fieldset>
</div>
</body>
</html>