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

    var requiredField = document.getElementsByClassName("required");
    var star = document.getElementsByClassName("required_star");
    var validationPresentation = document.getElementsByClassName("requiredField");

    for (var i = 0; i < requiredField.length; i++) {
        if (!requiredField[i].value) {
            star[i].style.visibility = "visible";
            validationPresentation[0].style.visibility = "visible";
        }
        else if (requiredField[i].value && star[i].style.visibility == "visible") {
            star[i].style.visibility = "hidden";
            validationPresentation[0].style.visibility = "hidden";
        }
    }
    return true;

}