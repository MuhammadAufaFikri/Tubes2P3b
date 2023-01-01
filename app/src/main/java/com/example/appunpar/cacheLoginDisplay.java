package com.example.appunpar;

import android.content.Context;
import android.content.SharedPreferences;

public class cacheLoginDisplay {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF = "sp_login_display";
    protected final static String KEY_EMAIL = "EMAIL";
    protected final static String KEY_PASSWORD = "PASSWORD";
    protected Context context;

    public cacheLoginDisplay(Context context) {
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF, 0);
        this.context = context;
    }

    public void saveEmail(String email) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public void savePassword(String password) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public String getEmail(){
        return sharedPref.getString(KEY_EMAIL, "");
    }

    public String getPassword(){ return sharedPref.getString(KEY_PASSWORD, "");
    }
}
