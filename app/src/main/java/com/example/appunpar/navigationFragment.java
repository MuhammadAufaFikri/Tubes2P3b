package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class navigationFragment  extends Fragment{
    public static navigationFragment newInstance(String title){
        navigationFragment fragment = new navigationFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
