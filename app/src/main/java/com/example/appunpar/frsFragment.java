package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentFrsBinding;

public class frsFragment  extends Fragment implements View.OnClickListener{
    private FragmentFrsBinding binding;
    public static frsFragment newInstance(String title){
        frsFragment fragment = new frsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentFrsBinding.inflate(inflater,container,false);
        this.binding.keHistoryFrs.setOnClickListener(this);
        View view = this.binding.getRoot();
        return view;
    }

    @Override
    public void onClick(View view) {
        if(this.binding.keHistoryFrs == view){
            Bundle result = new Bundle();
            result.putInt("page",11);//pindah ke history frs
            this.getParentFragmentManager().setFragmentResult("Fragment History FRS", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
    }
}
