package com.example.nicolas.nem_assignement01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by nicolas on 18/10/16.
 */

public class CustomArrayAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CustomItem> al_items;

    static class ViewHolder {
        public TextView tv;
        public CheckBox cb;
    }

    CustomArrayAdapter (Context c, ArrayList<CustomItem> al){
        context = c;
        al_items = al;
    }

    public View getView (int position, View convert_view, ViewGroup parent) {
        ViewHolder holder;

        if (convert_view == null){
            holder = new ViewHolder();

            LayoutInflater inflator = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convert_view = inflator.inflate(R.layout.custom_item_layout, parent, false);

            holder.tv = (TextView) convert_view.findViewById(R.id.tv);
            holder.cb = (CheckBox) convert_view.findViewById(R.id.cb);


            convert_view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convert_view.getTag();
        }

        holder.tv.setText(al_items.get(position).getName());
        holder.cb.setChecked(al_items.get(position).getCheck());
        holder.cb.setTag(position);

        return convert_view;
    }

    public int getCount(){
        return al_items.size();
    }

    public long getItemId (int position){
        return position;
    }

    public CustomItem getItem (int position){
        return al_items.get(position);
    }
}
