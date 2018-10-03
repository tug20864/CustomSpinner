package edu.temple.customspinner;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorAdapter extends ArrayAdapter<ColorItem> {

    public ColorAdapter(Context context, ArrayList<ColorItem> colorList){
        super(context, 0, colorList);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.color_spinner_row, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.colorName);


        ColorItem currentItem = getItem(position);
        if(currentItem != null){
            textView.setText(currentItem.getColor());
        }
        //SET THE BACKGROUND COLOR OF THE THIS SPINNER ROW ITEM BASED ON THE STRING NAME
        convertView.setBackgroundColor(Color.parseColor(currentItem.getColor()));

        return convertView;
    }
}
