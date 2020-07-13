package com.example.sudokuvarients.sudokux4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sudokuvarients.R;

public class Sudokux4 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudokux4);
        Game.getInstance().createGrid(this);
    }


}
