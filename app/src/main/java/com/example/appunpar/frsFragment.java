package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class frsFragment  extends Fragment{
    public static frsFragment newInstance(String title){
        frsFragment fragment = new frsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
