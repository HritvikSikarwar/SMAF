package com.instant.hritvik.smaf;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefrenceManager {
    private Context context;
    private SharedPreferences sharedPreferences;
    public PrefrenceManager(Context context)
    {
        this.context = context;
        getSharedPreference();
    }

    private void getSharedPreference(){

        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_preference),Context.MODE_PRIVATE);

    }
    public void writepreference()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_preference_key),"init_Ok");
        editor.commit();
    }

    public boolean checkpreference()
    {
        boolean status = false;
        if(sharedPreferences.getString(context.getString(R.string.my_preference_key),"null").equals("null")){
            status = false;
        }
        else
        {
            status = true;
        }
        return status;
    }
    public void clesrpreference()
    {
        sharedPreferences.edit().commit();
    }

}
