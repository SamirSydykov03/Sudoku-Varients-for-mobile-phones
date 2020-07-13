package com.example.sudokuvarients.normalsudoku9x9.SudokuGrid;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.Toast;
import com.example.sudokuvarients.normalsudoku9x9.SudokuChecker;

public class GameGrid {
    private final Context context;

    public long startTime= System.currentTimeMillis();

    private final SudokuCell[][] Sudoku = new SudokuCell[9][9];
    public GameGrid(Context context){
        this.context= context;
        for(int x =0; x<9;x++){
            for(int y =0; y<9;y++){
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }
    public void setGrid(int[][] grid){
        for(int x =0; x<9;x++){
            for(int y =0; y<9;y++){
                Sudoku[x][y].setInitialValue(grid[x][y]);
                if(grid[x][y] !=0){
                    Sudoku[x][y].setNotModify();
                }
            }
        }
    }

    public SudokuCell[][] getGrid(){
        return Sudoku;
    }

    public SudokuCell getItem(int x, int y){
        //returns only one cell
        return Sudoku[x][y];

    }

    public SudokuCell getItem(int posit){
        int x = posit % 9;
        int y = posit / 9;
        return Sudoku[x][y];
    }

    public void setItem(int x, int y, int number){
        Sudoku[x][y].setValue(number);
    }

    public void checkGame(){
        int[][] sudokuGrid = new int[9][9];
        for(int x =0;x<9;x++){
            for (int y =0; y<9;y++){
                sudokuGrid[x][y] = getItem(x,y).getValue();
            }
        }
        if(SudokuChecker.getInstance().checkSudoku(sudokuGrid)){
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
