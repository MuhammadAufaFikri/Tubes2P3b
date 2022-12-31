package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class detailPertemuanFragment  extends Fragment {
    public static detailPertemuanFragment newInstance(String title){
        detailPertemuanFragment fragment = new detailPertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
