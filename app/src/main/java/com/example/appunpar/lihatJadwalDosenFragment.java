package com.example.appunpar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
public class lihatJadwalDosenFragment extends Fragment{
    public static lihatJadwalDosenFragment newInstance(String title){
        lihatJadwalDosenFragment fragment = new lihatJadwalDosenFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
}
