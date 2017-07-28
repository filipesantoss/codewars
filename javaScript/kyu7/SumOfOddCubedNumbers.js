/*
Find the sum of the odd numbers within an array, after cubing the initial integers.
This function will return undefined (NULL in PHP) if any of the values aren't numbers.
*/

console.log(cubeOdd([1, 2, 3, 4]));

function cubeOdd(arr) {

  var result = 0;

  for (var i = 0; i < arr.length; i++) {

    if (typeof arr[i] !== 'number') {
      return undefined;
    }

    arr[i] = Math.pow(arr[i], 3);
    if (arr[i] % 2 !== 0) {
      result += arr[i];
    }
  }
  return result;
}
