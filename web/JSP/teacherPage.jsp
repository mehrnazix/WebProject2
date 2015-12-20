<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>Teacher Panel</title>
    <link href="/CSS/formsStyle.css" type="text/css" rel="stylesheet">
</head>

<body>
<div class="start_panel">
    <fieldset>
        <legend>Teacher Panel</legend>

        <input type="button" class="button_in_start_page" value="Profile" onclick="window.location.href='/teacher/profile'">
        <input type="button" class="button_in_start_page" value="Grade" onclick="window.location.href='/teacher/grade'">
        <input type="button" class="button_in_start_page" value="Change Password" onclick="window.location.href='/teacher/changePassword'">

    </fieldset>
</div>
</body>
</html>