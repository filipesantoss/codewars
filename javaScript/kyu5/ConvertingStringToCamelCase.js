/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized.

Examples:

// returns "theStealthWarrior"
toCamelCase("the-stealth-warrior") 

// returns "TheStealthWarrior"
toCamelCase("The_Stealth_Warrior")
*/

console.log(toCamelCase('the-stealth-warrior'));

function toCamelCase(str){

    var words = str.split(/[-_]/);

    for (var index = 1; index < words.length; index++) {
        words[index] = words[index].substring(0,1).toUpperCase() + words[index].substring(1);
    }

    return words.join('');
}