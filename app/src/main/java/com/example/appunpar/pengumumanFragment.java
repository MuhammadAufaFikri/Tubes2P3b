package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class pengumumanFragment  extends Fragment{
    public static pengumumanFragment newInstance(String title){
        pengumumanFragment fragment = new pengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
