package com.example.sudokuvarients.normalsudoku9x9;

import java.util.ArrayList;
import java.util.Random;
public class SudokuGenerator {
    private static SudokuGenerator instance;
    private final Random ran = new Random();
    private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();

    private SudokuGenerator(){

    }

    public static SudokuGenerator getInstance(){
        if(instance == null){
            instance = new SudokuGenerator();
        }
        return instance;
    }
    public int[][] generateGrid(){
        int[][] Sudoku = new int[9][9];

        int currentPos = 0;
        while(currentPos < 81){
            if(currentPos == 0) {
                cleargrid(Sudoku);
            }
            if(Available.get(currentPos).size() != 0){
                int i = ran.nextInt(Available.get(currentPos).size());
                int number = Available.get(currentPos).get(i);
                if(!Conflict(Sudoku, currentPos, number)){
                    int xPos = currentPos % 9;
                    int yPos = currentPos /9;
                    Sudoku[xPos][yPos] = number;
                    Available.get(currentPos).remove(i);
                    currentPos++;
                }else{
                    Available.get(currentPos).remove(i);
                }
            }else{
                for(int i = 1; i <=9; i++){
                    Available.get(currentPos).add(i);
                }
                currentPos--;
            }
        }
        return Sudoku;
    }


    public int[][] removal(int[][] Sudoku){
        int temp =  NormalSudoku.diff;
        int i = 0;
        int cleanse =0;
        if(temp == 0){
            cleanse = new Random().nextInt(10) + 20;
        }else if(temp == 1){
            cleanse = new Random().nextInt(20) + 25;
        }
        else if(temp == 2){
            cleanse = new Random().nextInt(11) + 45;
        }
        while(i< cleanse){
            int x = ran.nextInt(9);
            int y = ran.nextInt(9);
            if(Sudoku[x][y] != 0){
                Sudoku[x][y] =0;
                i++;
            }
        }

        return Sudoku;
    }

    private void cleargrid(int[][] Sudoku){
        Available.clear();
        for (int x = 0; x<9;x++ ){
            for(int y=0;y<9;y++){
                Sudoku[x][y]= -1;
            }
        }
        for(int x = 0; x<81; x++){
            Available.add(new ArrayList<Integer>());
            for(int i = 1; i <=9;i++){
                Available.get(x).add(i);

            }
        }
    }

    private boolean Conflict(int[][] Sudoku, int currentPos, final int number){
        int xPos = currentPos % 9;
        int yPos = currentPos /9;
        if(hozConflict(Sudoku,  xPos, yPos, number) || verConflict(Sudoku,  xPos, yPos, number) || regConflict(Sudoku,  xPos, yPos, number) ){
            return true;
        }

        return false;
    }
    private boolean hozConflict(final int [][] Sudoku, final int xPos, final int yPos, final int number){
        for(int x = xPos -1; x>=0;x--){
            if(number == Sudoku[x][yPos]){
                return true;
            }
        }
        return false;
    }
    private boolean verConflict(final int [][] Sudoku, final int xPos, final int yPos, final int number){
        for(int y = yPos -1; y>=0;y--){
            if(number == Sudoku[xPos][y]){
                return true;
            }
        }
        return false;
    }
    private boolean regConflict(final int[][] Sudoku, final int xPos, final int yPos, final int number){
        int xReg = xPos /3;
        int yReg = yPos /3;
        for(int x =xReg *3;x<xReg *3 +3; x++ ){
            for(int y = yReg *3; y <yReg *3 +3; y++){
                if((x != xPos || y != yPos) && number == Sudoku[x][y]){
                    return true;
                }
            }
        }
        return false;
    }


}
