package com.example.nicolas.nem_assignement01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<CustomItem> arrayList;
    private EditText editText;
    private CustomArrayAdapter caa;


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

        //doesn't work ???
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item clicked", Toast.LENGTH_LONG).show();
                Log.d("oinj","oubn");
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();
                arrayList.remove(arrayList.get(position));
                caa.notifyDataSetChanged();
                return true;
            }
        });

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

    public void click (View v){
        Log.d("Click", "activity");
    }
}
