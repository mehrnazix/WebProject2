<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>

<div class="form-add-new">
    <form name="studentForm">
        <fieldset>
            <legend>Student Profile</legend>

            <label>
                <span>First Name :</span>
                <input type="text" readonly id="firstName" name="firstName" value="${student.getFirstName()}"/>
            </label>

            <label>
                <span>Last Name : </span>
                <input type="text" readonly name="lastName" value="${student.getLastName()}"/>
            </label>

            <label>
                <span>National Code : </span>
                <input type="text" readonly name="nationalCode" value="${student.getNationalCode()}"/>
            </label>

            <label>
                <span>Student Code : </span>
                <input type="text" readonly name="code" value="${student.getCode()}"/>
            </label>

            <label>
                <span>Email : </span>
                <input type="text" readonly name="email" value="${student.getEmail()}"/>
            </label>

            <label>
                <span>Phone Number : </span>
                <input type="text" readonly name="phoneNumber" value="${student.getPhoneNumber()}"/>
            </label>

            <label>
                <span>Mobile Number : </span>
                <input type="text" readonly name="mobileNumber" value="${student.getMobileNumber()}"/>
            </label>

            <label>
                <span>Address : </span>
                <textarea readonly name="address" rows="5">${student.getAddress()}</textarea>
            </label>

        </fieldset>
    </form>
</div>

<div>
    <a href="\JSP\studentPage.jsp">First Page</a>
</div>

</body>
</html>