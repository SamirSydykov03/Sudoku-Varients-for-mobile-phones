package com.example.sudokuvarients.sudokux16;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class SudokuGenerator {
    private static SudokuGenerator instance;

    private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();

    private final Random rand = new Random();

    private SudokuGenerator(){}

    public static SudokuGenerator getInstance(){
        if( instance == null ){
            instance = new SudokuGenerator();
        }
        return instance;
    }

    public int[][] generateGrid(){
        int[][] Sudoku = new int[16][16];

        int currentPos = 0;


        while( currentPos < 256 ){
            if( currentPos == 0 ){
                clearGrid(Sudoku);
            }

            if( Available.get(currentPos).size() != 0 ){
                int i = rand.nextInt(Available.get(currentPos).size());
                int number = Available.get(currentPos).get(i);

                if( !checkConflict(Sudoku, currentPos , number)){
                    int xPos = currentPos % 16;
                    int yPos = currentPos / 16;

                    Sudoku[xPos][yPos] = number;

                    Available.get(currentPos).remove(i);

                    currentPos++;
                }else{
                    Available.get(currentPos).remove(i);
                }

            }else{
                for( int i = 1 ; i <= 16 ; i++ ){
                    Available.get(currentPos).add(i);
                }
                currentPos--;
            }
        }


        return Sudoku;
    }

    public int[][] removeElements( int[][] Sudoku ){
        int i = 0;
        int temp =  sudokux16.diff;

        int cleanse =0;
        if(temp ==0){
            cleanse = new Random().nextInt(40) + 25;

        }else if(temp == 1){
            cleanse = new Random().nextInt(65) + 55;
        }
        else if(temp == 2){
            cleanse = new Random().nextInt(50) + 120;
        }
        while( i < cleanse ){
            int x = rand.nextInt(16);
            int y = rand.nextInt(16);

            if( Sudoku[x][y] != 0 ){
                Sudoku[x][y] = 0;
                i++;
            }
        }
        return Sudoku;

    }

    private void clearGrid(int [][] Sudoku){
        Available.clear();

        for( int y =  0; y < 16 ; y++ ){
            for( int x = 0 ; x < 16 ; x++ ){
                Sudoku[x][y] = -1;
            }
        }

        for( int x = 0 ; x < 256 ; x++ ){
            Available.add(new ArrayList<Integer>());
            for( int i = 1 ; i <= 16 ; i++){
                Available.get(x).add(i);
            }
        }
    }

    private boolean checkConflict( int[][] Sudoku , int currentPos , final int number){
        int xPos = currentPos % 16;
        int yPos = currentPos / 16;

        if( checkHorizontalConflict(Sudoku, xPos, yPos, number) || checkVerticalConflict(Sudoku, xPos, yPos, number) || checkRegionConflict(Sudoku, xPos, yPos, number) ){
            return true;
        }

        return false;
    }

    private boolean checkHorizontalConflict( final int[][] Sudoku , final int xPos , final int yPos , final int number ){
        for( int x = xPos - 1; x >= 0 ; x-- ){
            if( number == Sudoku[x][yPos]){
                return true;
            }
        }

        return false;
    }

    private boolean checkVerticalConflict( final int[][] Sudoku , final int xPos , final int yPos , final int number ){
        for( int y = yPos - 1; y >= 0 ; y-- ){
            if( number == Sudoku[xPos][y] ){
                return true;
            }
        }

        return false;
    }

    private boolean checkRegionConflict( final int[][] Sudoku , final int xPos , final int yPos , final int number ){
        int xRegion = xPos / 4;
        int yRegion = yPos / 4;

        for( int x = xRegion * 4 ; x < xRegion * 4 + 4; x++ ){
            for( int y = yRegion * 4 ; y < yRegion * 4 + 4 ; y++ ){
                if( ( x != xPos || y != yPos ) && number == Sudoku[x][y] ){
                    return true;
                }
            }
        }

        return false;
    }
}