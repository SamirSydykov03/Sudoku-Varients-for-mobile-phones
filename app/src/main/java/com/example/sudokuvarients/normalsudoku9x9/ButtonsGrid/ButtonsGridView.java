package com.example.sudokuvarients.normalsudoku9x9.ButtonsGrid;

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
    public ButtonsGridView(Context context, AttributeSet attrs){
        super(context,attrs);
        ButtonsGridViewAdapter gridViewAdapter = new ButtonsGridViewAdapter(context);
        setAdapter(gridViewAdapter);

    }
    class ButtonsGridViewAdapter extends BaseAdapter{
        private Context context;
        public  ButtonsGridViewAdapter(Context context){
            this.context = context;
        }
        @Override
        public int getCount() {
            return 10;
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
            View views = convertView;
            if(views == null){
                LayoutInflater inflater =((Activity) context).getLayoutInflater();
                views = inflater.inflate(R.layout.button1,parent, false);
                NumberButton but;
                but = (NumberButton)views;
                but.setTextSize(25);
                but.setBackgroundColor(Color.DKGRAY);
                but.setId(position);
                if(position !=9){
                    but.setText(String.valueOf("        " +(position +1)));
                    but.setNumber(position+1);
                }else{
                    but.setText("     DEL");
                    but.setNumber(0);
                }

                return but;
            }

            return views;
        }
    }


}
