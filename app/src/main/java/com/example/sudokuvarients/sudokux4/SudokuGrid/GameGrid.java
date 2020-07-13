package com.example.sudokuvarients.sudokux4.SudokuGrid;

import android.content.Context;
import android.widget.Toast;
import com.example.sudokuvarients.sudokux4.SudokuChecker;
public class GameGrid {

    private SudokuCell[][] Sudoku = new SudokuCell[4][4];
    public long startTime= System.currentTimeMillis();
    private Context context;

    public GameGrid( Context context ){
        this.context = context;
        for( int x = 0 ; x < 4 ; x++ ){
            for( int y = 0 ; y < 4 ; y++){
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid( int[][] grid ){
        for( int x = 0 ; x < 4 ; x++ ){
            for( int y = 0 ; y < 4 ; y++){
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
        int x = position % 4;
        int y = position / 4;

        return Sudoku[x][y];
    }

    public void setItem( int x , int y , int number ){
        Sudoku[x][y].setValue(number);
    }

    public void checkGame(){
        int [][] sudGrid = new int[4][4];
        for( int x = 0 ; x < 4 ; x++ ){
            for( int y = 0 ; y < 4 ; y++ ){
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
