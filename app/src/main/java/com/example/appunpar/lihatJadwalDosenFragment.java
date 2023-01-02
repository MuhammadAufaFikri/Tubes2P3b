package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentLihatJadwalDosenBinding;

public class lihatJadwalDosenFragment extends Fragment{
    private FragmentLihatJadwalDosenBinding binding;
    public static lihatJadwalDosenFragment newInstance(String title){
        lihatJadwalDosenFragment fragment = new lihatJadwalDosenFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentLihatJadwalDosenBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
