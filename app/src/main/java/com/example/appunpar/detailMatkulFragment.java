package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;import androidx.fragment.app.Fragment;
public class detailMatkulFragment extends Fragment{
    public static detailMatkulFragment newInstance(String title){
        detailMatkulFragment fragment = new detailMatkulFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
