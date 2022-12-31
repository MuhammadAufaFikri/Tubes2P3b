package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class buatPengumumanFragment extends Fragment{
    public static buatPengumumanFragment newInstance(String title){
        buatPengumumanFragment fragment = new buatPengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
