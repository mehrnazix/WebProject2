<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Course List</title>
  <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>

<body>

<div class="list-view">
  <fieldset>
    <legend>Course List View</legend>
    <table id="courseTableId">
      <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Coefficient</th>
        <th>Teacher</th>
        <th></th>
      </tr>

      <c:forEach var="courseItem" items="${courseList}">
        <tr class="pure-table-odd">
          <td>${courseItem.getCode()}</td>
          <td>${courseItem.getName()}</td>
          <td>${courseItem.getCoefficient()}</td>
          <td>${courseItem.getTeacher()}</td>
          <td>
            <input type="submit" value="Select" onclick="selectCourse(${courseItem.getCourseId()})">
          </td>
        </tr>
      </c:forEach>
    </table>
  </fieldset>
</div>

<div>
  <a href="/student">Home</a>
</div>

<script type="text/javascript" src="/JS/studentValidation.js"></script>
</body>
</html>
