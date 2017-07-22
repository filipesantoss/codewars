/*
Sudoku is a game played on a 9x9 grid.
The goal of the game is to fill all cells of the grid with digits from 1 to 9, so that each column,
  each row, and each of the nine 3x3 sub-grids (also known as blocks) contain all of the digits from 1 to 9.
(More info at: http://en.wikipedia.org/wiki/Sudoku)

###Sudoku Solution Validator Write a function validSolution that accepts a 2D array representing a Sudoku board,
  and returns true if it is a valid solution, or false otherwise.
The cells of the sudoku board may also contain 0's, which will represent empty cells.
Boards containing one or more zeroes are considered to be invalid solutions.
*/

//TODO ugly code, need to refactor

console.log(validSolution([
    [5, 3, 4, 6, 7, 8, 9, 1, 2],
    [6, 7, 2, 1, 9, 5, 3, 4, 8],
    [1, 9, 8, 3, 4, 2, 5, 6, 7],
    [8, 5, 9, 7, 6, 1, 4, 2, 3],
    [4, 2, 6, 8, 5, 3, 7, 9, 1],
    [7, 1, 3, 9, 2, 4, 8, 5, 6],
    [9, 6, 1, 5, 3, 7, 2, 8, 4],
    [2, 8, 7, 4, 1, 9, 6, 3, 5],
    [3, 4, 5, 2, 8, 6, 1, 7, 9]]));

function validSolution(board){

  var row = [];
  var column = [];
  var box = [];
  var j;
  for (var i = 0; i < board.length; i++) {

    //ROW
    //clone row and sort it.
    row = [].concat(board[i]).sort();
    for (j = 0; j < row.length; j++) {
      if (row[j] == row[j + 1]) {
        return false;
      }
    }

    //COLUMN
    for (j = 0; j < board.length; j++) {
      column.push(board[j][i]);
    }
    column.sort();
    for (j = 0; j < column.length; j++) {
      if (column[j] == column[j + 1]) {
        return false;
      }
    }
    column = [];

  }

  //BOX
  for (i = 0; i < board.length; i += 3) {
    for (var l = 0; l < board.length; l += 3) {

      for (j = 0; j < board.length / 3; j++) {
        for (var k = 0; k < board.length / 3; k++) {
          box.push(board[j + i][k + l]);
        }
      }
      box.sort();
      for (j = 0; j < box.length; j++) {
        if (box[j] == box[j + 1]) {
          return false;
        }
      }
      box = [];
    }
  }

  return true;
}
