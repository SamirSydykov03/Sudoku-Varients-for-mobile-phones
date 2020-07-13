package com.example.sudokuvarients.sudokux4.ButtonsGrid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.example.sudokuvarients.R;

    public class ButtonsGridView extends GridView {


        public ButtonsGridView(Context context , AttributeSet attrs ){
            super(context , attrs);

            ButtonsGridViewAdapter gridViewAdapter = new ButtonsGridViewAdapter(context);

            setAdapter(gridViewAdapter);
        }

        static class ButtonsGridViewAdapter extends BaseAdapter {

            private Context context;

            public ButtonsGridViewAdapter(Context context) {
                this.context = context;
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if( v == null ){
                    LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                    v = inflater.inflate(R.layout.button3, parent , false);

                    NumberButton btn;
                    btn = (NumberButton)v;
                    btn.setTextSize(30);
                    btn.setId(position);

                    btn.setBackgroundColor(Color.DKGRAY);

                    if( position != 4 ){
                        btn.setText(String.valueOf("    " + (position + 1)));
                        btn.setNumber(position + 1);
                    }else{
                        btn.setText("  DEL");
                        btn.setNumber(0);
                    }
                    return btn;
                }

                return v;
            }

        }
    }