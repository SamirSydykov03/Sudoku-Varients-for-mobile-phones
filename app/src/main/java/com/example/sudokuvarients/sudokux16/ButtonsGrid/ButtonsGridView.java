package com.example.sudokuvarients.sudokux16.ButtonsGrid;


import android.graphics.Color;
import com.example.sudokuvarients.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class ButtonsGridView extends GridView{


    public ButtonsGridView( Context context , AttributeSet attrs ){
        super(context , attrs);

        ButtonsGridViewAdapter gridViewAdapter = new ButtonsGridViewAdapter(context);

        setAdapter(gridViewAdapter);
    }

    class ButtonsGridViewAdapter extends BaseAdapter {

        private Context context;

        public ButtonsGridViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 17;
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
                v = inflater.inflate(R.layout.button2, parent , false);

                NumberButton btn;
                btn = (NumberButton)v;
                btn.setTextSize(20);
                btn.setId(position);
                btn.setBackgroundColor(Color.DKGRAY);

                if( position != 16 ){
                    if(position + 1 <= 9){
                    btn.setText(String.valueOf("       " + (position + 1)));
                    btn.setNumber(position + 1);}
                    else {
                        btn.setText(String.valueOf("      " + (position + 1)));
                        btn.setNumber(position + 1);
                    }

                }else{
                    btn.setText("    DEL");
                    btn.setNumber(0);
                }
                return btn;
            }

            return v;
        }

    }
}