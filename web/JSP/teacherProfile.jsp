<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Teacher Update Information</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>
<body>

<div class="form-add-new">
    <form name="teacherForm">
        <fieldset>
            <legend>Teacher Profile</legend>

            <label>
                <span>First Name :</span>
                <input type="text" readonly id="firstName" name="firstName" value="${teacher.getFirstName()}"/>
            </label>

            <label>
                <span>Last Name : </span>
                <input type="text" readonly name="lastName" value="${teacher.getLastName()}"/>
            </label>

            <label>
                <span>National Code : </span>
                <input type="text" readonly name="nationalCode" value="${teacher.getNationalCode()}"/>
            </label>

            <label>
                <span>Teacher Code : </span>
                <input type="text" readonly name="code" value="${teacher.getCode()}"/>
            </label>

            <label>
                <span>Email : </span>
                <input type="text" readonly name="email" value="${teacher.getEmail()}"/>
            </label>

            <label>
                <span>Phone Number : </span>
                <input type="text" readonly name="phoneNumber" value="${teacher.getPhoneNumber()}"/>
            </label>

            <label>
                <span>Mobile Number : </span>
                <input type="text" readonly name="mobileNumber" value="${teacher.getMobileNumber()}"/>
            </label>

            <label>
                <span>Address : </span>
                <textarea readonly name="address" rows="5">${teacher.getAddress()}</textarea>
            </label>

        </fieldset>
    </form>
</div>

<div>
    <a href="\JSP\teacherPage.jsp">Home</a>
</div>

</body>
</html>