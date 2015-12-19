<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Class List</title>
  <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">

  <input type="button" value="Add Class" class="init-button" onclick="window.location.href='/class/create'">
</head>

<body>

<div class="list-view">
  <fieldset>
    <legend>Class List View</legend>
    <table id="classTableId">
      <tr>
        <th>Class Number</th>
        <th>Date</th>
        <th>Course</th>
        <th>Teacher</th>
        <th></th>
      </tr>

      <c:forEach var="classItem" items="${classList}">
        <tr class="pure-table-odd">
          <td>${classItem.getClassNumber()}</td>
          <td>${classItem.getDate()}</td>
          <td>${classItem.getTime()}</td>
          <td>${classItem.getCourseId()}</td>
          <td>${classItem.getTeacherId()}</td>
          <td>
            <input type="button" value="Edit" onclick="updateRow(${classItem.getId()})">
            <input type="submit" value="Delete" onclick="deleteRow(${classItem.getId()})">
          </td>
        </tr>
      </c:forEach>
    </table>
  </fieldset>
</div>

<div>
  <a href="\HTML\adminPage.html">First Page</a>
</div>

<script type="text/javascript" src="/JS/classValidation.js"></script>
</body>
</html>
