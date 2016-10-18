package com.example.nicolas.nem_assignement01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter_listView;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the editText
        editText = (EditText) findViewById(R.id.editText);

        //init the listView
        listView = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList<> ();
        adapter_listView = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter_listView);
    }


    public void buttonPress (View arg0){
        //setListView();
        Log.d("ButtonPress", "plop");
    }

    private void setListView(){
        adapter_listView.clear();

        //add items to arrayList;

    }
}
