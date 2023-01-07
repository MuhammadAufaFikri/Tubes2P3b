package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentHomeMahasiswaBinding;

public class homeFragment  extends Fragment implements View.OnClickListener{
    private FragmentHomeMahasiswaBinding binding;
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
        View view = this.binding.getRoot();
        return view;
    }

    @Override
    public void onClick(View view) {
        if(this.binding.keFramePengumuman== view){
            Bundle result = new Bundle();
            result.putInt("page",3);//pindah ke pengumuman
            this.getParentFragmentManager().setFragmentResult("Fragment Pengumuman", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
    }
}
