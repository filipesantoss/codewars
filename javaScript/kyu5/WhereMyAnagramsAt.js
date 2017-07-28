/*
What is an anagram?
Well, two words are anagrams of each other if they both contain the same letters.
For example:

'abba' & 'baab' == true
'abba' & 'bbaa' == true
'abba' & 'abbba' == false

Write a function that will find all the anagrams of a word from a list.
You will be given two inputs a word and an array with words.
You should return an array of all the anagrams or an empty array if there are none.
*/
console.log(anagrams('abba', ['aabb', 'abcd', 'bbaa', 'dada']));

function anagrams(word, words) {

  //Sort character in string.
  word = word.split('').sort().join('');
  var matches = [];

  for (var i = 0; i < words.length; i++) {
    //Sort and compare.
    if (words[i].split('').sort().join('') == word) {
      matches.push(words[i]);
    }
  }

  return matches;
}
