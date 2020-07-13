package com.example.sudokuvarients.sudokuColour.SudokuGrid;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


public class SudokuCell extends BaseSudokuCell {

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
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0,0,getWidth(), getHeight(), mPaint);
    }

    private void drawNumber(Canvas canvas) {

        if(getValue() == 1){
            mPaint.setColor(Color.CYAN);}
        else if(getValue() == 2){
            mPaint.setColor(Color.BLUE);
        }
        else if(getValue() == 3){
            mPaint.setColor(Color.GREEN);
        }
        else if(getValue() == 4){
            mPaint.setColor(Color.rgb(100,8,205));
        }
        else if(getValue() == 5){
            mPaint.setColor(Color.RED);}
        else if(getValue() == 6){
            mPaint.setColor(Color.YELLOW);
        }
        else if(getValue() == 7){
            mPaint.setColor(Color.WHITE);
        }
        else if(getValue() == 8){
            mPaint.setColor(Color.rgb(243,147,22));
        }
        else if(getValue() == 9){
            mPaint.setColor(Color.MAGENTA);
        }

        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        Rect bounds = new Rect();
        mPaint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if (getValue() != 0) {

            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width()) / 2, (getHeight() + bounds.height()) / 2, mPaint);
            canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        }
    }

}
