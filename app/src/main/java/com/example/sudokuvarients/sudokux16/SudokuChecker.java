package com.example.sudokuvarients.sudokux16;



public class SudokuChecker {
    private static SudokuChecker instance;

    private SudokuChecker(){}

    public static SudokuChecker getInstance(){
        if( instance == null ){
            instance = new SudokuChecker();
        }
        return instance;
    }

    public boolean checkSudoku( int[][] Sudoku){
        return (checkHorizontal(Sudoku) || checkVertical(Sudoku) || checkRegions(Sudoku));
    }

    private boolean checkHorizontal(int[][] Sudoku) {
        for( int y = 0 ; y < 16 ; y++ ){
            for( int xPos = 0 ; xPos < 16 ; xPos++ ){

                if( Sudoku[xPos][y] == 0 ){
                    return false;
                }
                for( int x = xPos + 1 ; x < 16; x++ ){
                    if( Sudoku[xPos][y] == Sudoku[x][y] || Sudoku[x][y] == 0 ){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkVertical(int[][] Sudoku) {
        for( int x = 0 ; x < 16 ; x++ ){
            for( int yPos = 0 ; yPos < 16 ; yPos++ ){

                if( Sudoku[x][yPos] == 0 ){
                    return false;
                }
                for( int y = yPos + 1 ; y < 16 ; y++ ){
                    if( Sudoku[x][yPos] == Sudoku[x][y] || Sudoku[x][y] == 0 ){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkRegions(int[][] Sudoku) {
        for( int xRegion = 0; xRegion < 4; xRegion++ ){
            for( int yRegion = 0; yRegion < 4 ; yRegion++ ){
                if( !checkRegion(Sudoku, xRegion, yRegion) ){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRegion(int[][] Sudoku , int xRegion , int yRegion){
        for( int xPos = xRegion * 4; xPos < xRegion * 4 + 4 ; xPos++ ){
            for( int yPos = yRegion * 4 ; yPos < yRegion * 4 + 4 ; yPos++ ){
                for( int x = xPos ; x < xRegion * 4 + 4 ; x++ ){
                    for( int y = yPos ; y < yRegion * 4 + 4 ; y++ ){
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