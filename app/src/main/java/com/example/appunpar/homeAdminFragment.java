package com.example.appunpar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.appunpar.databinding.FragmentHomeAdminBinding;

public class homeAdminFragment  extends Fragment implements View.OnClickListener{
    private FragmentHomeAdminBinding binding;
    protected String token;
    public static homeAdminFragment newInstance(String title){
        homeAdminFragment fragment = new homeAdminFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentHomeAdminBinding.inflate(inflater,container,false);
        this.binding.keFramePengumumanAdmin.setOnClickListener(this);
        this.binding.keTambahUser.setOnClickListener(this);
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
        if(this.binding.keFramePengumumanAdmin == view){
            Bundle result = new Bundle();

            result.putInt("page",5);//pindah ke buat pengumuman
            this.getParentFragmentManager().setFragmentResult("Fragment Buat Pengumuman", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.keTambahUser == view){
            Bundle result = new Bundle();
            result.putInt("page",13);//pindah ke Tambah User
            this.getParentFragmentManager().setFragmentResult("Fragment Tambah User", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.exitAdmin == view){
            Bundle result = new Bundle();
            result.putInt("page",1);//pindah ke Login
            saveToken saveToken = new saveToken(null,null,null,null);
            this.getParentFragmentManager().setFragmentResult("Fragment Login", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }

    }
}
