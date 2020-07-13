package com.example.sudokuvarients.sudokuColour;

import android.content.Context;
import com.example.sudokuvarients.sudokuColour.SudokuGrid.GameGrid;

public class Game {
    private static Game instance;
    private GameGrid grid = null;
    private int selectedX = -1;
    private int selectedY = -1;
    private Game(){}
    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }
    public void createGrid(Context context){
        int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
        Sudoku = SudokuGenerator.getInstance().removal(Sudoku);
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);
    }

    public GameGrid getGrid(){
        return grid;
    }

    public void setSelectedPos(int x, int y){
        selectedX = x;
        selectedY = y;
    }

    public void setNumber(int number){
        if(selectedY != -1 && selectedX != -1){
            grid.setItem(selectedX,selectedY,number);
        }
        grid.checkGame();
    }
}