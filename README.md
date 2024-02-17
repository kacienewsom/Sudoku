# Sudoku
## Description

This project is an implementation of the logic puzzle game Sudoku

You can read about the rules of Sudoku [here](https://en.wikipedia.org/wiki/Sudoku).

## How to run

To get started, download the code, and open up a terminal. Then, navigate to the Sudoku folder and type
`javac Sudoku.java`. This command will compile the source code. To then run the program, type `java Sudoku`.

##How to play

When the program is run, you may start to play the game. Start by click on an unoccupied cell. Note that the
cell is highlighted. This is the cell whose value is being updated. Type in any number to update the cell.
If a cell was occupied during initialization, the value cannot be changed. If you've made a mistake, you
can backspace to remove the value. 

## Implementation

Once the program is started, a file will be read to initialize the grid. The starting grids should be located
in a folder called StartingGrids and each file in the folder is named Grid### where the ### symbolizes some
number. As it stands now, the program reads in a file in the StartingGrids directory called Grid24. If you 
would like to run this program without and modifications to the source code, ensure that that file exists.

Once the file is read and grid is rendered, play can begin.
