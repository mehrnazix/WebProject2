/**
 * Created by 931664 on 11/28/2015.
 */

function updateRow(classId) {

    window.location.href = '/class/update/' + classId;
}

function deleteRow(classId) {


    var confirmation = confirm("Do you really want to delete this row?");

    if (confirmation == true) {
        window.location.href = '/class/delete/' + classId;
        return true;
    }
    else {
        return false;
    }
}