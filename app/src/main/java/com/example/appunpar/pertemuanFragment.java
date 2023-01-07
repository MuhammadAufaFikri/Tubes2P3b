package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentLoginBinding;
import com.example.appunpar.databinding.FragmentPertemuanBinding;

public class pertemuanFragment extends Fragment{
    private FragmentPertemuanBinding binding;
    public static pertemuanFragment newInstance(String title){
        pertemuanFragment fragment = new pertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentPertemuanBinding.inflate(inflater,container,false);
        this.binding.keBuatPertemuan.setOnClickListener(this::onClick);
        View view = this.binding.getRoot();
        return view;
    }

    private void onClick(View view) {
        if(this.binding.keBuatPertemuan==view){
            Bundle result = new Bundle();
            result.putInt("page",8);//pindah ke buat pertemuan
            this.getParentFragmentManager().setFragmentResult("Fragment Buat Pertemuan", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
        else if(this.binding.keLihatJadwalDosen==view){
            Bundle result = new Bundle();
            result.putInt("page",9);//pindah ke lihat jadwal dosen
            this.getParentFragmentManager().setFragmentResult("Fragment Lihat Jadwal Dosen", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
    }
}
