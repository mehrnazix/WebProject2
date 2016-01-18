<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>
<div class="form-add-new">
    <form method="post" action="/admin/saveStudent" onsubmit="return validateForm();">
        <input type="hidden" name="studentId" value="${student.getStudentId()}">
        <input type="hidden" name="userId" value="${student.getUserId()}">

        <fieldset>
            <legend>Add New Student</legend>

            <label>
                <span>First Name :</span>
                <input class="required" type="text" id="firstName" name="firstName" value="${student.getFirstName()}">

                <div class="required_star">*</div>
            </label>

            <label>
                <span>Last Name : </span>
                <input class="required" type="text" name="lastName" value="${student.getLastName()}">

                <div class="required_star">*</div>
            </label>

            <label>
                <span>National Code : </span>
                <input class="required" type="number" name="nationalCode" id="nationalCode"
                       placeholder="Enter a valid 10 digit national code " value="${student.getNationalCode()}">

                <div class="required_star">*</div>
                <div class="requiredField" id="validNationalCode">National Code must be equal 10 digit</div>
            </label>

            <label>
                <span>Student Code : </span>
                <input class="required" type="number" name="code" value="${student.getCode()}" id="studentCode">

                <div class="required_star">*</div>
                <div class="requiredField" id="validStudentCode">Student Code must be equal 6 digit</div>
            </label>

            <label>
                <span>Email : </span>
                <input type="text" name="email"
                       placeholder="Enter a valid email address" value="${student.getEmail()}">
            </label>

            <label>
                <span>Phone Number : </span>
                <input type="number" name="phoneNumber" value="${student.getPhoneNumber()}" id="phoneNumber">

                <div class="requiredField" id="validPhone">Phone number must be equal 8 digit</div>
            </label>

            <label>
                <span>Mobile Number : </span>
                <input class="required" type="number" name="mobileNumber" value="${student.getMobileNumber()}"
                       id="mobileNumber">

                <div class="required_star">*</div>
                <div class="requiredField" id="validMobileNumber">Mobile number must be equal 10 digit and start with
                    0
                </div>
            </label>

            <label>
                <span>Address : </span>
                <textarea name="address" rows="5">${student.getAddress()}</textarea>
            </label>

            <label>
                <input type="submit" value="Save">
                <input type="button" value="Cancel" onclick="window.location.href='/admin/viewStudents'">
            </label>
            <label>
                <div class="requiredField" id="fieldIsRequired">* Fields are required!</div>
            </label>
        </fieldset>
    </form>
</div>
<script type="text/javascript" src="/JS/studentValidation.js"></script>
</body>
</html>