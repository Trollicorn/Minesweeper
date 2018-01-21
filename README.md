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

- The number on a square shows how many mines of the 8 mines around the square are mines 
- Left click a square to uncover it 
- Right click a square to flag/unflag it 
- The total number of mines on the board is shown at the top 
- The total number of flags currently placed on the board is shown at the top
- If you left click a square with no mines around it, the surrounding squares will also be uncovered 
- Flags are optional and are used by players to keep track of mines (flagged squares cannot be uncovered until they are unflagged)
- If you click a square with a number on it and the number of flags around the square is equal to the number on the square, the unflagged squares around the square will be uncovered 
- Uncovering a mine ends the game 
- Uncover all non-mines to win 
- When the game ends, you can play again by click "New Game" 


