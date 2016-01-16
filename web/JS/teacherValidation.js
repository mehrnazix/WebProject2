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
        if (!requiredField[i].value || requiredField[i].value != 0) {
            star[i].style.visibility = "visible";
            counter++;
        }
        else if (requiredField[i].value && star[i].style.visibility == "visible") {
            star[i].style.visibility = "hidden";
        }
    }

    var nationalCode = document.getElementById("nationalCode");
    if (nationalCode && (nationalCode.value.length < 6 || nationalCode.value.length > 6)) {

        var nationalCodeRequired = document.getElementById("nationalCodeRequired");
        nationalCodeRequired.style.visibility = "visible";
        return false;
    }

    if (counter > 0) {
        fieldIsRequired.style.visibility = "visible";
        return false;
    }
    else {
        fieldIsRequired.style.visibility = "hidden";
        return true;
    }
}

function giveUpeScore(gradeId) {

    window.location.href = '/teacher/giveUpScore/' + gradeId;
}