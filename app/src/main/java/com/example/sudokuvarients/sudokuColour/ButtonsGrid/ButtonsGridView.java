package com.example.sudokuvarients.sudokuColour.ButtonsGrid;

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
                views = inflater.inflate(R.layout.button4,parent, false);

                NumberButton but;
                but = (NumberButton)views;
                but.setTextSize(20);
                but.setId(position);

                if(position !=9){
                    if(position == 0){
                        but.setBackgroundColor(Color.CYAN);
                    }
                    else if(position == 1){
                        but.setBackgroundColor(Color.BLUE);
                    }
                    else if(position == 2){
                        but.setBackgroundColor(Color.GREEN);
                    }
                    else if(position == 3){
                        but.setBackgroundColor(Color.rgb(100,8,205));
                    }
                    else if(position == 4){
                        but.setBackgroundColor(Color.RED);
                    }else if(position == 5){
                        but.setBackgroundColor(Color.YELLOW);
                    }else if(position == 6){
                        but.setBackgroundColor(Color.WHITE);
                    }else if(position == 7){
                        but.setBackgroundColor(Color.rgb(243,147,22));
                    }else if(position == 8){
                        but.setBackgroundColor(Color.MAGENTA);
                    }
                    but.setNumber(position+1);
                }else{
                    but.setText("       DEL");
                    but.setBackgroundColor(Color.DKGRAY);
                    but.setNumber(0);
                }

                return but;
            }

            return views;
        }
    }

}
