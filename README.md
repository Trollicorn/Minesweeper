# Minesweeper 
AP CS final project 1st semester   
Team: Da Wae
Group Members: Mohammed Uddin,  Emily Lee

--------------------------------------------------

Starting up the game: 

1. Type "javac *.java" in the terminal to compile all java files
2. Type "java MineGame" in the terminal to open up the game 
3. Choose your difficulty level from "New Game" button in the top left (default is medium)
4. Left click a square to uncover it and generate the board

--------------------------------------------------

Objective: 

Victory is achieved by uncovering every square that is not a mine
Uncovering a mine will result in a loss

--------------------------------------------------

Playing the game:

- Left click a square to uncover it
  - Uncovering a mine ends the game = loss
  - Uncover all non-mines to win, without uncovering any mines 
  - If you left click a square with no mines around it, the surrounding squares will also be uncovered 
  - If you click a square with a number on it and the number of flags around the square is equal to the number on the square, the unflagged squares around the square will be uncovered 
    - If the mine wasn't flagged, the user loses the game.
- Right click a square to flag/unflag it 
    - Flags are optional and are used by players to keep track of mines (flagged squares cannot be uncovered unless they are unflagged)
- The number on a square shows how many mines are around the square (out of the eight squares that surround it).
- The total number of mines on the board is shown at the top (left)
- The total number of flags currently placed on the board is shown at the top (right)
- When the game ends
  - User receives either a victory or defeat end page.
  - The whole board is revealed, showing all the numbers and mines, which are all unclickable.
  - you can play again by clicking "New Game" (top left)
    - There are three options from there:
       - Easy: 25 square board
       - Medium: 100 square board
       - Hard: 400 square board


