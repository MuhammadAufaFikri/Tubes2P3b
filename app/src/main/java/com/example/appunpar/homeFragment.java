package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.appunpar.databinding.FragmentHomeMahasiswaBinding;

public class homeFragment  extends Fragment implements View.OnClickListener{
    private FragmentHomeMahasiswaBinding binding;
    protected String token;
    public static homeFragment newInstance(String title){
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentHomeMahasiswaBinding.inflate(inflater,container,false);
        this.binding.keFramePengumuman.setOnClickListener(this);
        this.binding.keFrameFRS.setOnClickListener(this);
        this.binding.keFramePertemuan.setOnClickListener(this);
        getParentFragmentManager().setFragmentResultListener("saveToken", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                token = result.getString("token");
                getToken(token);
            }
        });
        View view = this.binding.getRoot();
        return view;
    }
    private void getToken(String token) {
        this.token=token;
    }
    @Override
    public void onClick(View view) {
        if(this.binding.keFramePengumuman== view){
            Bundle result = new Bundle();
            result.putInt("page",3);//pindah ke pengumuman
            this.getParentFragmentManager().setFragmentResult("Fragment Pengumuman", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.keFrameFRS == view){
            Bundle result = new Bundle();
            result.putInt("page",10);//pindah ke FRS
            this.getParentFragmentManager().setFragmentResult("Fragment FRS", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.keFramePertemuan == view){
            Bundle result = new Bundle();
            result.putInt("page",6);//pindah ke FRS
            this.getParentFragmentManager().setFragmentResult("Fragment FRS", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.exit == view){
            Bundle result = new Bundle();
            result.putInt("page",1);//pindah ke FRS
            this.getParentFragmentManager().setFragmentResult("Fragment FRS", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
    }
}
