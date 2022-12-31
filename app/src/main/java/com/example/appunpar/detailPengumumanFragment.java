package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class detailPengumumanFragment  extends Fragment{
    public static detailPengumumanFragment newInstance(String title){
        detailPengumumanFragment fragment = new detailPengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
