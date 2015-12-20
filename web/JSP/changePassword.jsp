<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Teacher Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>

<div class="form-add-new">
    <form name="changePassword" method="post" action="/changePassword" onsubmit="return validateForm();">
        <input type="hidden" name="userId" value="${user.getUserId()}">

        <fieldset>
            <legend>Change Password</legend>

            <label>
                <span>Username :</span>
                <input type="text"  id="username" name="username" value="${user.getUsername()}"/>
            </label>

            <label>
                <span>Password : </span>
                <input type="text" name="password" value="${user.getPassword()}"/>
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/admin/viewTeachers'">
            </label>
            <label>
                <div class="requiredField">* Fields are required!</div>
            </label>
        </fieldset>
    </form>
</div>

<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>