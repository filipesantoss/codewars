/*
Write simple .camelcase method (camel_case function in PHP) for strings. All words must have their first letter capitalized without spaces.

For instance:

"hello case".camelCase() => HelloCase
"camel case word".camelCase() => CamelCaseWord
*/


String.prototype.camelCase = function() {

  var words = this.split(" ");

  for (var i = 0; i < words.length; i++) {
    words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
  }

  //Join array elements with empty string in between.
  return words.join("");
};

console.log("hello world method".camelCase());
