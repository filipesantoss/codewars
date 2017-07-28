/*
Greed is a dice game played with five six-sided dice.
Your mission, should you choose to accept it, is to score a throw according to these rules.
You will always be given an array with five six-sided dice values.

 Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point
A single die can only be counted once in each roll. 
For example, a "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
*/

function score(dice) {

    var rolls = {};

    for (var i in dice) {
        //if key doesn't exist, create it
        if (rolls[dice[i]] === undefined) {
            rolls[dice[i]] = 1;
            continue;
        }
        rolls[dice[i]]++;
    }

    var score = 0;

    for (var key in rolls) {

        if (rolls[key] >= 3) {
            switch (key) {
                case '1':
                    score += 1000 + (rolls[key] > 3 ? 100 : 0);
                    break;
                case '2':
                    score += 200;
                    break;
                case '3':
                    score += 300;
                    break;
                case '4':
                    score += 400;
                    break;
                case '5':
                    score += 500 + (rolls[key] > 3 ? 50 : 0);;
                    break;
                case '6':
                    score += 600;
                    break;
            }
            continue;
        }

        if (key == '1') {
            score += 100 * rolls[key];
        }
        if (key == '5') {
            score += 50 * rolls[key];
        }
    }

    return score;
}