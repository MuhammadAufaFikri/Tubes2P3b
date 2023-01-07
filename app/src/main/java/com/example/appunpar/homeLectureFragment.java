package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentHomeAdminBinding;
import com.example.appunpar.databinding.FragmentHomeLectureBinding;

public class homeLectureFragment extends Fragment implements View.OnClickListener{
    FragmentHomeLectureBinding binding;
    public static homeLectureFragment newInstance(String title){
        homeLectureFragment fragment = new homeLectureFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentHomeLectureBinding.inflate(inflater,container,false);
        this.binding.keFramePengumuman.setOnClickListener(this);
        this.binding.keFramePertemuan.setOnClickListener(this);
        this.binding.exitAdmin.setOnClickListener(this);
        View view = this.binding.getRoot();
        return view;
    }

    @Override
    public void onClick(View view) {
        if(this.binding.keFramePengumuman == view){
            Bundle result = new Bundle();
            result.putInt("page",5);//pindah ke buat pengumuman
            this.getParentFragmentManager().setFragmentResult("Fragment Buat Pengumuman", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.keFramePertemuan == view){
            Bundle result = new Bundle();
            result.putInt("page",6);//pindah ke Tambah User
            this.getParentFragmentManager().setFragmentResult("Fragment Tambah User", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.exitAdmin == view){
            Bundle result = new Bundle();
            result.putInt("page",1);//pindah ke Login
            this.getParentFragmentManager().setFragmentResult("Fragment Login", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }

    }
}


