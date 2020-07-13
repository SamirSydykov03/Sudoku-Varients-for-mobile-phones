package com.example.sudokuvarients.sudokux4.SudokuGrid;

import android.content.Context;
import android.hardware.camera2.params.BlackLevelPattern;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.example.sudokuvarients.sudokux4.Game;

public class SudokuGridView extends GridView{

    private final Context context;

    public SudokuGridView(final Context context , AttributeSet attrs) {
        super(context,attrs);

        this.context = context;

        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);

        setAdapter(gridViewAdapter);

        setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 4;
                int y = position / 4;

                Game.getInstance().setSelectedPosition(x, y);
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class SudokuGridViewAdapter extends BaseAdapter{

        private Context context;

        public SudokuGridViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 16;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return Game.getInstance().getGrid().getItem(position);
        }
    }
}

