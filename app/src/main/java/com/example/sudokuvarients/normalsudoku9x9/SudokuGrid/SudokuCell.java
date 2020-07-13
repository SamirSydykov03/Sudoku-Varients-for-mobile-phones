package com.example.sudokuvarients.normalsudoku9x9.SudokuGrid;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SudokuCell extends BaseSudokuCell{

    private Paint mPaint;


    public SudokuCell(Context context){
        super(context);
        mPaint =new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawNumber(canvas);
        drawLines(canvas);
    }

    private void drawLines(Canvas canvas) {
        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.STROKE);
         mPaint.setStrokeWidth(5);
        canvas.drawRect(0,0,getWidth(), getHeight(), mPaint);
    }

    private void drawNumber(Canvas canvas) {
        mPaint.setColor(Color.CYAN);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);
        Rect bounds = new Rect();
        mPaint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);
        if (getValue() != 0) {
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width()) / 2, (getHeight() + bounds.height()) / 2, mPaint);
        }
    }



}
