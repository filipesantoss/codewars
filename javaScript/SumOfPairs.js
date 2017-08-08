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

console.log(sumOfPairs([ 1, 4, 8, 7, 3, 15 ], 8));

//TODO code is timing out - need to have better performance.

function sumOfPairs(array, result) {
  
  var pair = {  };

  for (var i = 0; i < array.length; i++) {
    for (var j = i + 1; j < array.length; j++) {
      if ((array[i] + array[j] == result) && (j - i < pair.range || pair.range == undefined)) {
        pair.firstIndex = array[i];
        pair.lastIndex = array[j];
        pair.range = j - i;
        break;
      }
    }
    if (pair.range == 1) {
      return [pair.firstIndex, pair.lastIndex];
    }
  }

  if (pair.range == undefined) {
    return undefined;
  }
  return [pair.firstIndex, pair.lastIndex];
}
