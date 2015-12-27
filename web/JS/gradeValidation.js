/**
 * Created by 931664 on 11/28/2015.
 */
function deleteRow(gradeId) {


    var confirmation = confirm("Do you really want to delete this row?");

    if (confirmation == true) {
        window.location.href = '/grade/deleteGrade/' + gradeId;
        return true;
    }
    else {
        return false;
    }
}

function create(courseId) {

    window.location.href = "/grade/create/" + courseId;
}

function updateRow(gradeId) {

    window.location.href = '/grade/update' + gradeId;
}
