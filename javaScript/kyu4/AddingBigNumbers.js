/*
We need to sum big numbers and we require your help.

Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.

Example

add("123", "321"); -> "444"
add("11", "99"); -> "110"
Notes

The input numbers are big.
The input is a string of only digits
The numbers are positives
*/

function add(a, b) {

    a = a.toString().split('').reverse(); //from right to left
    b = b.toString().split('').reverse();

    var max = a.length > b.length ? a.length : b.length; //bigger number
    var result = [];
    var goesOne = 0; //remaining dozens

    for (var i = 0; i < max; i++) {

        a[i] = a[i] == undefined ? 0 : a[i]; //sum with 0 if digit doesn't exist
        b[i] = b[i] == undefined ? 0 : b[i];

        var sum = parseInt(a[i]) + parseInt(b[i]) + goesOne; 
        result[i] = sum % 10; //units
        goesOne = (sum - result[i]) / 10; //dozens
    }

    if (goesOne != 0) {
        result.push(goesOne); //possible remaining dozen in last sum
    }

    return result.reverse().join('');
}