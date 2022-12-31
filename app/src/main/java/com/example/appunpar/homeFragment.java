package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class homeFragment  extends Fragment{
    public static homeFragment newInstance(String title){
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
