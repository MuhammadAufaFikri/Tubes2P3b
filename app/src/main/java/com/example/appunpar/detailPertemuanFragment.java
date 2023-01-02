package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentDetailPertemuanBinding;

public class detailPertemuanFragment  extends Fragment {
    private FragmentDetailPertemuanBinding binding;
    public static detailPertemuanFragment newInstance(String title){
        detailPertemuanFragment fragment = new detailPertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentDetailPertemuanBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        return view;
    }
}
