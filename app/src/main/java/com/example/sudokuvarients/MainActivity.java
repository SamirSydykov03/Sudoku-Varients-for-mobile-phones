package com.example.sudokuvarients;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.sudokuvarients.sudokux4.Sudokux4;
import com.example.sudokuvarients.normalsudoku9x9.NormalSudoku;
import com.example.sudokuvarients.sudokux16.sudokux16;
import com.example.sudokuvarients.sudokuColour.ColourDoku;
import android.app.AlertDialog;
import android.content.DialogInterface;
public class MainActivity extends AppCompatActivity {
    private Button buttonx9, buttonx4, buttonx16, buttonxCol;
    public static final String DiffSet = "com.example.sudokuvarients.diff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonx9 = findViewById(R.id.normalsudoku);
        buttonx9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGameDialogx9();
            }
        });
        buttonx4 = findViewById(R.id.sudokux4);
        buttonx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Sudokux4.class));
            }
        });
        buttonxCol = findViewById(R.id.sudokuColour);
        buttonxCol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openNewGameDialogCol();
            }
        });
        buttonx16 = findViewById(R.id.sudokux16);
        buttonx16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGameDialogx16();
            }
        });
    }
    private void openNewGameDialogx9() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface,
                                                int i) {
                                startGamex9(i);
                            }
                        })
                .show();
    }
    private void startGamex9(int i) {
        Intent intent = new Intent(this, NormalSudoku.class);
        int diff = i;
        intent.putExtra(DiffSet,diff);
        startActivity(intent);
    }
    private void openNewGameDialogx16() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface,
                                                int i) {
                                startGamex16(i);
                            }
                        })
                .show();
    }
    private void startGamex16(int i) {
        Intent intent = new Intent(this, sudokux16.class);
        int diff = i;
        intent.putExtra(DiffSet,diff);
        startActivity(intent);
    }
    private void openNewGameDialogCol() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface,
                                                int i) {
                                startGameCol(i);
                            }
                        })
                .show();
    }
    private void startGameCol(int i) {
        Intent intent = new Intent(this, ColourDoku.class);
        int diff = i;
        intent.putExtra(DiffSet,diff);
        startActivity(intent);
    }


}