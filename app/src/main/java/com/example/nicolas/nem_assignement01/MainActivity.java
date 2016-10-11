package com.example.nicolas.nem_assignement01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter_listView;
    ArrayAdapter <CharSequence> adapter_spinner;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the editText
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("1");

        //init the spinner with the currency strings
        spinner = (Spinner) findViewById(R.id.spinner_currencies);
        ArrayAdapter <CharSequence> adapter_spinner =  ArrayAdapter.createFromResource(
                this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter_spinner);
        int posEUR = adapter_spinner.getPosition("EUR");
        spinner.setSelection(posEUR);

        //init the listView
        listView = (ListView) findViewById(R.id.listview);
        arrayList = extractCurrencies();
        adapter_listView = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter_listView);
    }


    private ArrayList<String> extractCurrencies(){
        int spinnerPos = spinner.getSelectedItemPosition();
        arrayList = new ArrayList<> ();
        int nbAdapter = adapter_spinner.getCount();

        for (int i = 0; i < nbAdapter; i++)
        {
            if (i != spinnerPos)
                arrayList.add(adapter_spinner.getItem(i).toString());
        }

        return arrayList;
    }
}
