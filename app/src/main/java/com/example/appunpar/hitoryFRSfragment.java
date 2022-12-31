package com.example.appunpar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class hitoryFRSfragment  extends Fragment{
    public static hitoryFRSfragment newInstance(String title){
        hitoryFRSfragment fragment = new hitoryFRSfragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}

