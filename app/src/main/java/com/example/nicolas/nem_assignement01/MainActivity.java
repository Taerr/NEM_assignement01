package com.example.nicolas.nem_assignement01;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter_listView;
    ArrayAdapter <CharSequence> adapter_spinner;
    private EditText editText;
    private TypedArray convert_values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert_values = getResources().obtainTypedArray(R.array.convert_values);
        //init the editText
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("1");

        //init the spinner with the currency strings
        spinner = (Spinner) findViewById(R.id.spinner_currencies);
        adapter_spinner =  ArrayAdapter.createFromResource(
                this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter_spinner);
        int posEUR = adapter_spinner.getPosition("EUR");
        spinner.setSelection(posEUR);

        //init the listView
        listView = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList<> ();
        adapter_listView = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter_listView);
        setListView();
    }


    public void buttonPress (View arg0){
        setListView();
    }

    private void setListView(){
        int spinnerPos = spinner.getSelectedItemPosition();
        int nbAdapter = adapter_spinner.getCount();
        double valueToConvert = Double.parseDouble(editText.getText().toString());

        arrayList.clear();

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for (int i = 0; i < nbAdapter; i++)
        {
            if (i != spinnerPos) {
                String to = adapter_spinner.getItem(i).toString();
                double value = processCurrency(spinnerPos, i, valueToConvert);

                arrayList.add(to + ": " + df.format(value));
            }
        }
    }

    private double processCurrency(int from, int to, double valueToConvert){
        Log.i("lolo", "pldsopqjdipq");
        double res;
        double from_val = convert_values.getFloat(from, 0);
        double to_val = convert_values.getFloat(to, 0);

        if (adapter_spinner.getItem(from).toString().equals("EUR"))
        {
            res = from_val * to_val * valueToConvert;
        }else
        {
            //produit en croix
            res = 0.01;
        }

        return res;
    }
}
