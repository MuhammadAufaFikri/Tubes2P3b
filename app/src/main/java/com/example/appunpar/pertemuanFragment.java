package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentLoginBinding;
import com.example.appunpar.databinding.FragmentPertemuanBinding;

public class pertemuanFragment extends Fragment{
    private FragmentPertemuanBinding binding;
    public static pertemuanFragment newInstance(String title){
        pertemuanFragment fragment = new pertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentPertemuanBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
