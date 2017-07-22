/*
Bob is preparing to pass IQ test.
The most frequent task in this test is to find out which one of the given numbers differs from the others.
Bob observed that one number usually differs from the others in evenness.
Help Bob — to check his answers, he needs a program that among the given numbers finds one that is different in evenness, and return a position of this number.
! Keep in mind that your task is to help Bob solve a real IQ test, which means indexes of the elements start from 1 (not 0)
*/
console.log(iqTest("79 27 77 57 37 45 27 49 65 33 57 21 71 19 75 85 65 61 23 97 85 9 23 1 9 3 99 77 77 21 79 69 15 37 15 7 93 81 13 89 91 31 45 93 15 97 55 80 85 83"));

function iqTest(numbers) {

  var array = numbers.split(" ");
  var odd = [];
  var even = [];

  for (var i = 0; i < array.length; i++) {

    if (odd.length > 1 && even.length > 0 || odd.length > 0 && even.length > 1) {
      break;
    }

    if (array[i] % 2 === 0) {
      even.push(i + 1);
      continue;
    }

    odd.push(i + 1);
  }

  return odd.length > even.length ? even[0] : odd[0];
}
