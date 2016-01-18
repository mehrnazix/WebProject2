/**
 * Created by 931664 on 11/28/2015.
 */

function updateRow(courseId) {

    window.location.href = '/admin/updateCourse/' + courseId;
}

function deleteRow(courseId) {


    var confirmation = confirm("Do you really want to delete this row?");

    if (confirmation == true) {
        window.location.href = '/admin/deleteCourse/' + courseId;
        return true;
    }
    else {
        return false;
    }
}

function formValidation(){

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

    return true;
}