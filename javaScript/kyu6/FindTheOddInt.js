/*
Given an array, find the int that appears an odd number of times.
There will always be only one integer that appears an odd number of times.
*/
console.log(findOdd([20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5]));

function findOdd(array) {

  var numbers = { };
  for (var i in array) {
    //if key doesn't exist, create it
    if (numbers[array[i]] === undefined) {
      numbers[array[i]] = 1;
      continue;
    }
    numbers[array[i]]++;
  }

  //value - object[key]

  var oddNumber;
  for(var key in numbers) {
    if (numbers[key] % 2 !== 0) {
      oddNumber = key;
    }
  }
  //key is string
  return parseInt(oddNumber);
}
