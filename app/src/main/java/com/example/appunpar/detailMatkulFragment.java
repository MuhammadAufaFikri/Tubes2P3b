package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentDetailMatkulBinding;

public class detailMatkulFragment extends Fragment{
    private FragmentDetailMatkulBinding binding;
    public static detailMatkulFragment newInstance(String title){
        detailMatkulFragment fragment = new detailMatkulFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentDetailMatkulBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
