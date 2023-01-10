package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.appunpar.databinding.FragmentHomeAdminBinding;
import com.example.appunpar.databinding.FragmentHomeLectureBinding;

public class homeLectureFragment extends Fragment implements View.OnClickListener{
    FragmentHomeLectureBinding binding;
    protected String token;
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
        getParentFragmentManager().setFragmentResultListener("saveToken", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                token = result.getString("token");
                getToken(token);
            }
        });
        return view;
    }
    private void getToken(String token) {
        this.token=token;
    }
    @Override
    public void onClick(View view) {
        if(this.binding.keFramePengumuman == view){
            Bundle result = new Bundle();
            result.putInt("page",3);//pindah ke lihat pengumuman
            result.putString("token", token);
            this.getParentFragmentManager().setFragmentResult("saveToken", result);
            this.getParentFragmentManager().setFragmentResult("Fragment Buat Pengumuman", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.keFramePertemuan == view){
            Bundle result = new Bundle();
            result.putInt("page",6);//pindah ke lihat pertemuan
            result.putString("token", token);
            this.getParentFragmentManager().setFragmentResult("saveToken", result);
            this.getParentFragmentManager().setFragmentResult("Fragment Tambah User", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.exitAdmin == view){
            Bundle result = new Bundle();
            result.putInt("page",1);//pindah ke Login
            result.putString("token", token);
            this.getParentFragmentManager().setFragmentResult("saveToken", result);
            this.getParentFragmentManager().setFragmentResult("Fragment Login", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }

    }
}


