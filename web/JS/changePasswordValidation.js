/**
 * Created by 931664 on 11/28/2015.
 */

function validateChangePasswordForm() {

    var oldPassword = document.getElementById("oldPassword");
    var newPassword = document.getElementById("newPassword");
    var confirmPassword = document.getElementById("confirmPassword");

    if(newPassword.value !== confirmPassword.value){

        alert("false");
        return false;
    }
    return true;
}
