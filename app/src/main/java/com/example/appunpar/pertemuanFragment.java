package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class pertemuanFragment extends Fragment{
    public static pertemuanFragment newInstance(String title){
        pertemuanFragment fragment = new pertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
