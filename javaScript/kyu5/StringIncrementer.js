/*
Your job is to write a function which increments a string, to create a new string.
If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number the number 1 should be appended to the new string.

Examples:
foo -> foo1
foobar23 -> foobar24
foo0042 -> foo0043
foo9 -> foo10
foo099 -> foo100
Attention: If the number has leading zeros the amount of digits should be considered.
*/

console.log(incrementString('foo00'));

function incrementString (strng) {

  var regex = new RegExp('[0-9]+');

  if(!regex.test(strng)) {
    return strng + 1;
  }

  var match = regex.exec(strng);
  var length = match[0].length;
  var number = parseInt(match[0]) + 1;
  strng = strng.substring(0, strng.indexOf(match[0])) + pad(number, length);

  return strng;
}

function pad(number, length) {
  var difference = length - number.toString().length;
  number = '' + number;
    for (var i = 0; i < difference; i++) {
      number = '0' + number;
    }
  return number;
}
