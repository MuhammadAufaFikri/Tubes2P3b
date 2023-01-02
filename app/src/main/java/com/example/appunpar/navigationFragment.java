package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentNavigationBinding;

public class navigationFragment  extends Fragment{
    private FragmentNavigationBinding binding;
    public static navigationFragment newInstance(String title){
        navigationFragment fragment = new navigationFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentNavigationBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
