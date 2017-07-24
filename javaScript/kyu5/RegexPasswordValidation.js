/*
You need to write regex that will validate a password to make sure it meets the following criteria:

At least six characters long
contains a lowercase letter
contains an uppercase letter
contains a number
Valid passwords will only be alphanumeric characters.
*/

console.log(validate('JHD5FJ53'));

function validate(password) {

    //is not alphanumeric
    var regex = /\W/gi;
    if (regex.test(password)) {
        return false;
    }

    //has uppercase - [A-Z]
    //has digit - [0-9]
    //has lowercase - [a-z]
    //is at leat 6 chars - {6,}
    console.log('upper', /(?=.*[A-Z])/g.test(password));
    console.log('digit', /(?=.*[0-9])/g.test(password));
    console.log('lower', /(?=.*[a-z])/g.test(password));

    regex = /^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{6,}$/g;
    return regex.test(password);
}