package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentFrsBinding;

public class hitoryFRSfragment  extends Fragment{
    private FragmentFrsBinding binding;
    public static hitoryFRSfragment newInstance(String title){
        hitoryFRSfragment fragment = new hitoryFRSfragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentFrsBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}

