<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Student List</title>
  <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">

  <input type="button" value="Add Student" class="init-button" onclick="window.location.href='/admin/createStudent'">


</head>

<body>

<div class="list-view">
  <fieldset>
    <legend>Student List View</legend>
    <table id="studentTableId">
      <tr>
        <th>National Code</th>
        <th>Student Code</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Mobile Number</th>
        <th>Address</th>
        <th></th>
      </tr>

      <c:forEach var="studentItem" items="${studentList}">
        <tr class="pure-table-odd">
          <td>${studentItem.getNationalCode()}</td>
          <td>${studentItem.getCode()}</td>
          <td>${studentItem.getFirstName()}</td>
          <td>${studentItem.getLastName()}</td>
          <td>${studentItem.getEmail()}</td>
          <td>${studentItem.getPhoneNumber()}</td>
          <td>${studentItem.getMobileNumber()}</td>
          <td>${studentItem.getAddress()}</td>
          <td>
            <input type="button" value="Edit" onclick="updateRow(${studentItem.getStudentId()})">
            <input type="submit" value="Delete" onclick="deleteRow(${studentItem.getStudentId()})">
          </td>
        </tr>
      </c:forEach>
    </table>
  </fieldset>
</div>

<div>
  <a href="\JSP\adminPage.jsp">First Page</a>
</div>

<script type="text/javascript" src="/JS/studentValidation.js"></script>
</body>
</html>
