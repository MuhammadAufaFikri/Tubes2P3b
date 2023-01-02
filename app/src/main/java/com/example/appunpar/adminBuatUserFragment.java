package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentAdminBuatUserBinding;

public class adminBuatUserFragment extends Fragment{
    private FragmentAdminBuatUserBinding binding;
    public static adminBuatUserFragment newInstance(String title){
        adminBuatUserFragment fragment = new adminBuatUserFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentAdminBuatUserBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
