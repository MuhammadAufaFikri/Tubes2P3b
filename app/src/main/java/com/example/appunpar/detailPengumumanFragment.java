package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentDetailPengumumanBinding;

public class detailPengumumanFragment  extends Fragment{
    private FragmentDetailPengumumanBinding binding;
    public static detailPengumumanFragment newInstance(String title){
        detailPengumumanFragment fragment = new detailPengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentDetailPengumumanBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
