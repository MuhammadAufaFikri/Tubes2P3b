package com.example.appunpar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class isifrsFragment  extends Fragment{
    public static isifrsFragment newInstance(String title){
        isifrsFragment fragment = new isifrsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
