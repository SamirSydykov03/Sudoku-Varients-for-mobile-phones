package com.example.sudokuvarients.sudokux16.ButtonsGrid;

import com.example.sudokuvarients.sudokux16.Game;
import androidx.appcompat.widget.AppCompatTextView;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

public class NumberButton extends AppCompatTextView implements OnClickListener{

    private int number;

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Game.getInstance().setNumber(number);
    }

    public void setNumber(int number){
        this.number = number;
    }
}