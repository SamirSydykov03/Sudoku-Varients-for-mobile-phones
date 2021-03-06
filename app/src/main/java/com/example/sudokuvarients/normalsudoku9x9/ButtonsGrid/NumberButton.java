package com.example.sudokuvarients.normalsudoku9x9.ButtonsGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.sudokuvarients.normalsudoku9x9.Game;

public class NumberButton extends AppCompatTextView implements View.OnClickListener {
    private int number;

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View views) {

        Game.getInstance().setNumber(number);
    }
    public void setNumber(int number)
    {
        this.number = number;
    }
}
