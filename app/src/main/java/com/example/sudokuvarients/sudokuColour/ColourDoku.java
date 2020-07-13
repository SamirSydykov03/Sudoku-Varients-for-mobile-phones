package com.example.sudokuvarients.sudokuColour;

import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sudokuvarients.MainActivity;
import com.example.sudokuvarients.R;

public class ColourDoku extends AppCompatActivity {
    public static int diff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_doku);
        Intent intent= getIntent();
        diff = intent.getIntExtra(MainActivity.DiffSet, 0);
        Game.getInstance().createGrid(this);
        if (diff == 0) {
            Toast.makeText(this,
                    "The game difficulty is easy!", Toast.LENGTH_SHORT).show();
        }
        else if (diff == 1) {
            Toast.makeText(this,
                    "The game difficulty is medium!", Toast.LENGTH_SHORT).show();
        }
        else if (diff == 2) {
            Toast.makeText(this,
                    "The game difficulty is hard!", Toast.LENGTH_SHORT).show();
        }
    }
}
