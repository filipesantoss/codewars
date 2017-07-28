/*
Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.

Rules for a smiling face:
-Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
-A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
-Every smiling face must have a smiling mouth that should be marked with either ) or D.
No additional characters are allowed except for those mentioned.

Example cases:
countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;

Note: In case of an empty array return 0. You will not be tested with invalid input (input will always be an array)
*/

console.log(countSmileys([':D',':~)',';~D',':)']));

function countSmileys(arr) {

  var smileyCount = 0;
  var regex = new RegExp('[:;][~-]?[)D]');

  for (var i = 0; i < arr.length; i++) {
    if (regex.test(arr[i])) {
      smileyCount++;
    }
  }

  return smileyCount;
}
