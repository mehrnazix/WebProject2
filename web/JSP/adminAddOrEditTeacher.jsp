<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Teacher Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>

<div class="form-add-new">
    <form name="teacherForm" method="post" action="/admin/saveTeacher" onsubmit="return validate();">
        <input type="hidden" name="teacherId" value="${teacher.getTeacherId()}">
        <input type="hidden" name="userId" value="${teacher.getUserId()}">

        <fieldset>
            <legend>Add New Teacher</legend>

            <label>
                <span>First Name :</span>
                <input class="required" type="text" id="firstName" name="firstName" value="${teacher.getFirstName()}">

                <div class="required_star">*</div>
            </label>

            <label>
                <span>Last Name : </span>
                <input class="required" type="text" name="lastName" value="${teacher.getLastName()}">

                <div class="required_star">*</div>
            </label>

            <label>
                <span>National Code : </span>
                <input class="required" type="number" name="nationalCode" id="nationalCode"
                       placeholder="Enter a valid 10 digit national code " value="${teacher.getNationalCode()}">

                <div class="required_star">*</div>
                <div class ="requiredField" id="validNationalCode">National Code must be equal 10 digit</div>
            </label>

            <label>
                <span>Teacher Code : </span>
                <input class="required" type="number" name="code" value="${teacher.getCode()}" id="teacherCode">

                <div class="required_star">*</div>
                <div class ="requiredField" id="validTeacherCode">Teacher Code must be equal 6 digit</div>
            </label>

            <label>
                <span>Email : </span>
                <input type="text" name="email"
                       placeholder="Enter a valid email address" value="${teacher.getEmail()}">
            </label>

            <label>
                <span>Phone Number : </span>
                <input type="number" name="phoneNumber" value="${teacher.getPhoneNumber()}" id="phoneNumber">
                <div class ="requiredField" id="validPhone">Phone number must be equal 8 digit</div>

            </label>

            <label>
                <span>Mobile Number : </span>
                <input class="required" type="text" name="mobileNumber" value="${teacher.getMobileNumber()}" id="mobileNumber">

                <div class="required_star">*</div>
                <div class ="requiredField" id="validMobileNumber">Mobile number must be equal 10 digit and start with 0</div>

            </label>

            <label>
                <span>Address : </span>
                <textarea name="address" rows="5">${teacher.getAddress()}</textarea>
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/admin/viewTeachers'">
            </label>
            <label>
                <div class ="requiredField" id="fieldIsRequired">* Fields are required!</div>
            </label>
        </fieldset>
    </form>
</div>

<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>