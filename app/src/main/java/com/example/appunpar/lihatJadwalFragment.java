package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class lihatJadwalFragment  extends Fragment{
    public static lihatJadwalFragment newInstance(String title){
        lihatJadwalFragment fragment = new lihatJadwalFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
