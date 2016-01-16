<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link href="/CSS/formsStyle.css" type="text/css" rel="stylesheet">
    <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>

<body style="background-image: url(Icon/training.jpg);">

<style>
    body {
        padding: 100px;
    }
</style>

<jsp:include page="sharedLayout.jsp"></jsp:include>

<div class="jumbotron">
    <div class="container" >
        <div class="row">
            <div class="col-md-4">
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='/admin/viewTeachers'">Teacher List View</button>
            </div>
        </div>


        <div class="row">
            <div class="col-md-3 col-md-offset-3">
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='/admin/viewStudents'">Student List View</button>
            </div>
            </div>
        </div>

    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <button class="btn btn-lg btn-primary btn-block" type="button" onclick="window.location.href='/admin/viewCourses'">Course List View</button>
        </div>
    </div>
</div>

    </div>
</div>



</body>

</body>
</html>