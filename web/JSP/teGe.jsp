<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Grade List</title>
    <link rel="stylesheet" type="text/css" href="/CSS/formsStyle.css">
</head>

<body>

<div class="list-view">
    <fieldset>
        <legend>Grade List View</legend>
        <table id="gradeTableId">
            <tr>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Student Name</th>
                <th>Score</th>
                <th></th>
            </tr>

            <c:set var="sum" value="${0}"/>
            <c:forEach var="gradeItem" items="${gradeList}">
                <c:set var="sum" value="${sum+gradeItem.getScore()}"/>
                <tr class="pure-table-odd">
                    <td>${gradeItem.getCourse().getCode()}</td>
                    <td>${gradeItem.getCourse().getName()}</td>
                    <td>${gradeItem.getCourse().getStudent().toString()}</td>
                    <td>${gradeItem.getScore()}</td>
                    <td>
                        <input type="submit" value="Set Score" onclick="updateRow(${gradeItem.getGradeId()})">
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th>${sum}</th>
                <th></th>
            </tr>
        </table>
    </fieldset>
</div>

<div>
    <a href="\JSP\teacherPage.jsp">First Page</a>
</div>

<script type="text/javascript" src="/JS/teacherValidation.js"></script>
</body>
</html>
