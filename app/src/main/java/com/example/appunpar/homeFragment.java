package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentHomeMahasiswaBinding;

public class homeFragment  extends Fragment{
    private FragmentHomeMahasiswaBinding binding;
    public static homeFragment newInstance(String title){
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentHomeMahasiswaBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
