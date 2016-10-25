package com.example.nicolas.nem_assignement01;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<CustomItem> arrayList;
    private EditText editText;
    private CustomArrayAdapter caa;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the editText
        editText = (EditText) findViewById(R.id.editText);

        //init the listView
        listView = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList<CustomItem>();
        caa = new CustomArrayAdapter(this, arrayList);
        listView.setAdapter(caa);


        //retrieve objects in memory
        sp = getSharedPreferences("com.example.nicolas.nem_assignement01", Activity.MODE_PRIVATE);
        int number = sp.getInt("numberVal", 0);
        for (int i = 0; i < number; i++){
            String key = Integer.toString(i);
            String name = sp.getString(key, "");
            Boolean check = sp.getBoolean("b" + key, false);

            arrayList.add(new CustomItem(name, check));
        }
        caa.notifyDataSetChanged();


        //set the listener
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();
                arrayList.remove(arrayList.get(position));
                caa.notifyDataSetChanged();
                return true;
            }
        });

        //doesn't work ???
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item clicked", Toast.LENGTH_LONG).show();
                Log.d("oinj","oubn");
            }
        });*/

    }


    public void buttonPress (View arg0){
        Log.d("ButtonPress", "Add new item");
        String name = editText.getText().toString();

        if (name.compareTo("") != 0){
            editText.setText("");

            arrayList.add(new CustomItem(name, false));
            caa.notifyDataSetChanged();
        }
    }

    protected void onStop(){
        super.onStop();

        SharedPreferences.Editor editor = sp.edit();

        editor.putInt("numberVal", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++)
        {
            CustomItem ci = arrayList.get(i);
            String key = Integer.toString(i);

            editor.putString(key, ci.getName());
            editor.putBoolean("b" + key, ci.getCheck());
        }

        editor.apply();
    }

    public void onClick(View view){
        CheckBox cb = (CheckBox) view;
        int tag = (int) cb.getTag();

        CustomItem item = caa.getItem(tag);
        item.setCheck(!item.getCheck());
    }
}
