package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentBuatPengumumanBinding;

public class buatPengumumanFragment extends Fragment{
    private FragmentBuatPengumumanBinding binding;
    public static buatPengumumanFragment newInstance(String title){
        buatPengumumanFragment fragment = new buatPengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentBuatPengumumanBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
