package com.example.sudokuvarients.sudokux16;
import android.content.Context;
import com.example.sudokuvarients.sudokux16.SudokuGrid.GameGrid;

public class Game {
    private static Game instance;
    private GameGrid grid = null;
    private int selectedPosX = -1, selectedPosY = -1;
    private Game(){}

    public static Game getInstance(){
        if( instance == null ){
            instance = new Game();
        }
        return instance;
    }

    public void createGrid( Context context ){
        int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
        Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku);
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);
    }

    public GameGrid getGrid(){
        return grid;
    }

    public void setSelectedPosition( int x , int y ){
        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNumber( int number ){
        if( selectedPosX != -1 && selectedPosY != -1 ){
            grid.setItem(selectedPosX,selectedPosY,number);
        }
        grid.checkGame();
    }
}