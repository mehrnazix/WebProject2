<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Teacher Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>

<div class="form-add-new">
    <form name="changePassword" method="post" action="/student/saveChangePassword" onsubmit="return validateChangePasswordForm();">
        <input type="hidden" name="userId" value="${user.getUserId()}">

        <fieldset>
            <legend>Change Password</legend>

            <label>
                <span>Username :</span>
                <input type="text" readonly id="username" name="username" value="${user.getUsername()}"/>
            </label>

            <label>
                <span>Old Password : </span>
                <input type="password" name="oldPassword" id="oldPassword"/>
            </label>

            <label>
                <span>New Password : </span>
                <input type="password" name="newPassword" id="newPassword"/>
            </label>

            <label>
                <span>Confirm Password : </span>
                <input type="password" name="confirmPassword" id="confirmPassword"/>
            </label>

            <label>
                <input type="submit" value="Save" >
                <input type="button" value="Cancel" >
            </label>
            <label>
                <div class="requiredField">* Fields are required!</div>
            </label>
        </fieldset>
    </form>
</div>

<script type="text/javascript" src="/JS/changePasswordValidation.js"></script>
</body>
</html>