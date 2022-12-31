package com.example.appunpar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class adminListUserFragment extends Fragment {
    public static adminListUserFragment newInstance(String title){
        adminListUserFragment fragment = new adminListUserFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
