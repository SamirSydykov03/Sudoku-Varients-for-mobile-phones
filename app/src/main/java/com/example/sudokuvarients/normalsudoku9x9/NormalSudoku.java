package com.example.sudokuvarients.normalsudoku9x9;
import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sudokuvarients.MainActivity;
import com.example.sudokuvarients.R;



public class NormalSudoku extends AppCompatActivity  {
    public static int diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent= getIntent();
        diff = intent.getIntExtra(MainActivity.DiffSet, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_sudoku);
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
