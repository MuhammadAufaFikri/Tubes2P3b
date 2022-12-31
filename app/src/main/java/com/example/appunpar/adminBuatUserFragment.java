package com.example.appunpar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class adminBuatUserFragment extends Fragment{
    public static adminBuatUserFragment newInstance(String title){
        adminBuatUserFragment fragment = new adminBuatUserFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
