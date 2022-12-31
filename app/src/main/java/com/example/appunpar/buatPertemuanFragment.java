package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class buatPertemuanFragment  extends Fragment{
    public static buatPertemuanFragment newInstance(String title){
        buatPertemuanFragment fragment = new buatPertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
