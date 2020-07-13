package com.example.sudokuvarients.sudokux16.SudokuGrid;

import com.example.sudokuvarients.sudokux16.SudokuChecker;

import android.content.Context;
import android.widget.Toast;

public class GameGrid {
    private final SudokuCell[][] Sudoku = new SudokuCell[16][16];
    public long startTime= System.currentTimeMillis();
    private final Context context;

    public GameGrid( Context context ){
        this.context = context;
        for( int x = 0 ; x < 16 ; x++ ){
            for( int y = 0 ; y < 16 ; y++){
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid( int[][] grid ){
        for( int x = 0 ; x < 16 ; x++ ){
            for( int y = 0 ; y < 16 ; y++){
                Sudoku[x][y].setInitValue(grid[x][y]);
                if( grid[x][y] != 0 ){
                    Sudoku[x][y].setNotModifiable();
                }
            }
        }
    }

    public SudokuCell[][] getGrid(){
        return Sudoku;
    }

    public SudokuCell getItem(int x , int y ){
        return Sudoku[x][y];
    }

    public SudokuCell getItem( int position ){
        int x = position % 16;
        int y = position / 16;

        return Sudoku[x][y];
    }

    public void setItem( int x , int y , int number ){
        Sudoku[x][y].setValue(number);
    }

    public void checkGame(){
        int [][] sudGrid = new int[16][16];
        for( int x = 0 ; x < 16 ; x++ ){
            for( int y = 0 ; y < 16 ; y++ ){
                sudGrid[x][y] = getItem(x,y).getValue();
            }
        }

        if( SudokuChecker.getInstance().checkSudoku(sudGrid)){
            long endTime = System.currentTimeMillis();
            long timeEleapsed = (endTime - startTime)/1000;
            if (timeEleapsed >59){
                long timeTImer2 = timeEleapsed %60;
                long timeMinute = timeEleapsed /60;
                Toast.makeText(context, "You solved the sudoku in " + timeMinute + " minutes and " + timeTImer2 + " seconds!", Toast.LENGTH_LONG).show();
            }
            Toast.makeText(context, "You solved the sudoku in " + timeEleapsed + " seconds!", Toast.LENGTH_LONG).show();
        }
    }
}
