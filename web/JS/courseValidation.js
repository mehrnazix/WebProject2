/**
 * Created by 931664 on 11/28/2015...
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