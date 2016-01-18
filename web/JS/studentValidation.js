/**
 * Created by 931664 on 11/28/2015.
 */

function updateRow(studentId) {

    window.location.href = '/admin/updateStudent/' + studentId;
}

function deleteRow(studentId) {


    var confirmation = confirm("Do you really want to delete this row?");

    if (confirmation == true) {
        window.location.href = '/admin/deleteStudent/' + studentId;
        return true;
    }
    else {
        return false;
    }
}

function validateForm() {

    var requiredFields = document.getElementsByClassName("required");
    var stars = document.getElementsByClassName("required_star");
    var fieldIsRequired = document.getElementById("fieldIsRequired");
    var counter = 0;

    for (var i = 0; i < requiredFields.length; i++) {
        if (!requiredFields[i].value || requiredFields[i].value == 0) {
            stars[i].style.visibility = "visible";
            counter++;
        }
        else if (requiredFields[i].value && stars[i].style.visibility == "visible") {
            stars[i].style.visibility = "hidden";
        }
    }

    if (counter > 0) {
        fieldIsRequired.style.visibility = "visible";
        return false;
    }

    var nationalCode = document.getElementById("nationalCode").value;
    var validNationalCode = document.getElementById("validNationalCode");
    if (nationalCode && nationalCode.charAt(0) != 0 && (nationalCode.length != 10)) {

        validNationalCode.style.visibility = "visible";
        counter++;
    } else {
        validNationalCode.style.visibility = "hidden";
    }

    var studentCode = document.getElementById("studentCode").value;
    var validTeacherCode = document.getElementById("validStudentCode");
    if (studentCode.length != 6) {

        validTeacherCode.style.visibility = "visible";
        counter++;
    } else {
        validTeacherCode.style.visibility = "hidden"
    }

    var phoneNumber = document.getElementById("phoneNumber").value;
    var validPhone = document.getElementById("validPhone");
    if (phoneNumber.length != 8) {

        validPhone.style.visibility = "visible";
        counter++;
    }
    else {
        validPhone.style.visibility = "hidden";
    }

    var mobileNumber = document.getElementById("mobileNumber").value;
    var validMobileNumber = document.getElementById("validMobileNumber");
    if (mobileNumber.length != 11 || mobileNumber.charAt(0) != 0) {

        validMobileNumber.style.visibility = "visible";
        counter++;
    }
    else {
        validMobileNumber.style.visibility = "hidden"
    }

    if (counter > 0) {
        return false;
    }
    return true;
}

function deleteCourse(gradeId) {


    var confirmation = confirm("Do you really want to delete this row?");

    if (confirmation == true) {
        window.location.href = '/student/deleteCourse/' + gradeId;
        return true;
    }
    else {
        return false;
    }
}

function selectCourse(courseId) {

    window.location.href = "/student/addStudentCourse/" + courseId;
}
