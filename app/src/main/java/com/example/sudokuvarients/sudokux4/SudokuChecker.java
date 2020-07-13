package com.example.sudokuvarients.sudokux4;


public class SudokuChecker {
    private static com.example.sudokuvarients.sudokux4.SudokuChecker instance;

    private SudokuChecker(){}

    public static com.example.sudokuvarients.sudokux4.SudokuChecker getInstance(){
        if( instance == null ){
            instance = new com.example.sudokuvarients.sudokux4.SudokuChecker();
        }
        return instance;
    }

    public boolean checkSudoku( int[][] Sudoku){
        return (checkHorizontal(Sudoku) ||
                checkVertical(Sudoku) ||
                checkRegions(Sudoku));
    }

    private boolean checkHorizontal(int[][] Sudoku) {
        for( int y = 0 ; y < 4 ; y++ ){
            for( int xPos = 0 ; xPos < 4 ; xPos++ ){

                if( Sudoku[xPos][y] == 0 ){
                    return false;
                }
                for( int x = xPos + 1 ; x < 4; x++ ){
                    if( Sudoku[xPos][y] == Sudoku[x][y] || Sudoku[x][y] == 0 ){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkVertical(int[][] Sudoku) {
        for( int x = 0 ; x < 4 ; x++ ){
            for( int yPos = 0 ; yPos < 4 ; yPos++ ){
                if( Sudoku[x][yPos] == 0 ){
                    return false;
                }
                for( int y = yPos + 1 ; y < 4 ; y++ ){
                    if( Sudoku[x][yPos] == Sudoku[x][y] || Sudoku[x][y] == 0 ){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkRegions(int[][] Sudoku) {
        for( int xRegion = 0; xRegion < 2; xRegion++ ){
            for( int yRegion = 0; yRegion < 2 ; yRegion++ ){
                if( !checkRegion(Sudoku, xRegion, yRegion) ){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRegion(int[][] Sudoku , int xRegion , int yRegion){
        for( int xPos = xRegion * 2; xPos < xRegion * 2 + 2 ; xPos++ ){
            for( int yPos = yRegion * 2 ; yPos < yRegion * 2 + 2 ; yPos++ ){
                for( int x = xPos ; x < xRegion * 2 + 2 ; x++ ){
                    for( int y = yPos ; y < yRegion * 2 + 2 ; y++ ){
                        if( (( x != xPos || y != yPos) && Sudoku[xPos][yPos] == Sudoku[x][y] ) || Sudoku[x][y] == 0 ){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}