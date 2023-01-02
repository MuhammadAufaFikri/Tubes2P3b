package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentBuatPertemuanBinding;

public class buatPertemuanFragment  extends Fragment{
    private FragmentBuatPertemuanBinding binding;
    public static buatPertemuanFragment newInstance(String title){
        buatPertemuanFragment fragment = new buatPertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentBuatPertemuanBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
