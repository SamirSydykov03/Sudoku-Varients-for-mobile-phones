package com.example.sudokuvarients.normalsudoku9x9.SudokuGrid;

import android.content.Context;
import android.view.View;

public class BaseSudokuCell extends View {

    private boolean modify = true;
    private int value;


    public BaseSudokuCell(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
    public void setNotModify(){
        modify = false;
    }
    public void setInitialValue(int value){
        this.value = value;
        invalidate();
    }

    public void setValue(int value){
        if(modify){
            this.value = value;
        }
        invalidate();
    }
    public int getValue(){
        return  value;
    }
}
