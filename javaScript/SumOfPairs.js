/*
Given a list of integers and a single sum value, return the first two values (parse from the left please) in order of appearance that add up to form the sum.
Negative numbers and duplicate numbers can and will appear.

sum_pairs([4, 3, 2, 3, 4],         6)
#          ^-----^         4 + 2 = 6, indices: 0, 2 *
#             ^-----^      3 + 3 = 6, indices: 1, 3
#                ^-----^   2 + 4 = 6, indices: 2, 4
#  * entire pair is earlier, and therefore is the correct answer
== [4, 2]

sum_pairs([10, 5, 2, 3, 7, 5],         10)
#              ^-----------^   5 + 5 = 10, indices: 1, 5
#                    ^--^      3 + 7 = 10, indices: 3, 4 *
#  * entire pair is earlier, and therefore is the correct answer
== [3, 7]
*/

console.log(sumOfPairs([4,-2,3,3,4], 8));

//TODO code is timing out - need to have better performance.

function sumOfPairs(array, result) {

  var pairs = [];

  var i;
  //Search for elements that sum to the wanted result
  for (i = 0; i < array.length; i++) {
    for (var j = i + 1; j < array.length; j++) {
      if (array[i] + array[j] == result) {
        pairs.push([i, j]);
      }
    }
  }

  if (pairs.length === 0) {
    return undefined;
  }

  //Define first pair as the earliest pair
  var min = [array[pairs[0][0]], array[pairs[0][1]]];

  //Look for possible earlier pair
  for (i = 1; i < pairs.length; i++) {
    if (pairs[i][1] - pairs[i][0] < min[1]) {
      min = [array[pairs[i][0]], array[pairs[i][1]]];
    }
  }

  return min;
}
