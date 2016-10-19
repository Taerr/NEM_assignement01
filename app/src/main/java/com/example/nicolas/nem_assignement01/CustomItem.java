package com.example.nicolas.nem_assignement01;

import android.util.Log;
import android.view.View;

/**
 * Created by nicolas on 18/10/16.
 */

public class CustomItem {

    private String name;
    private boolean check;

    CustomItem(String name, boolean check)
    {
        this.name = name;
        this.check = check;
    }

    public String getName () {
        return this.name;
    }

    public boolean getCheck (){
        return this.check;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck (boolean check){
        this.check = check;
    }

}
