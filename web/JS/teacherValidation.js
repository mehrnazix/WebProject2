/**
 * Created by 931664 on 11/28/2015.
 */
function updateRow(teacherId) {

    window.location.href = '/admin/updateTeacher/' + teacherId;
}

function deleteRow(teacherId) {


    var confirmation = confirm("Do you really want to delete this row?");

    if (confirmation == true) {
        window.location.href = '/admin/deleteTeacher/' + teacherId;
        return true;
    }
    else {
        return false;
    }
}

function validate() {

    var requiredField = document.getElementsByClassName("required");
    var star = document.getElementsByClassName("required_star");
    var fieldIsRequired = document.getElementById("fieldIsRequired");
    var counter = 0;

    for (var i = 0; i < requiredField.length; i++) {
        if (!requiredField[i].value || requiredField[i].value == 0) {
            star[i].style.visibility = "visible";
            counter++;
        }
        else if (requiredField[i].value && star[i].style.visibility == "visible") {
            star[i].style.visibility = "hidden";
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

    var teacherCode = document.getElementById("teacherCode").value;
    var validTeacherCode = document.getElementById("validTeacherCode");
    if (teacherCode.length != 6) {

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

function giveUpeScore(gradeId) {

    window.location.href = '/teacher/giveUpScore/' + gradeId;
}