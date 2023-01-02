package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentPengumumanBinding;

public class pengumumanFragment  extends Fragment{
    private FragmentPengumumanBinding binding;
    public static pengumumanFragment newInstance(String title){
        pengumumanFragment fragment = new pengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentPengumumanBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
