package com.example.sudokuvarients.sudokuColour.SudokuGrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.example.sudokuvarients.sudokuColour.Game;

public class SudokuGridView extends GridView {

    private final Context context;

    public SudokuGridView(final Context context, AttributeSet attr) {
        super(context, attr);
        this.context = context;

        SudokuGridViewAdap gridViewAdap = new SudokuGridViewAdap(context);

        setAdapter(gridViewAdap);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int x = position % 9;
                int y = position /9;
              //  Toast.makeText(context, "Selected item -x: " +x + " y: " + y, Toast.LENGTH_SHORT).show();
                Game.getInstance().setSelectedPos(x,y);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class SudokuGridViewAdap extends BaseAdapter {
        private Context context;
        public SudokuGridViewAdap(Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int pos) {
            return null;
        }

        @Override
        public long getItemId(int pos) {
            return 0;
        }

        @Override
        public View getView(int pos, View Convertview, ViewGroup parent) {

            return Game.getInstance().getGrid().getItem(pos);
        }
    }
}

