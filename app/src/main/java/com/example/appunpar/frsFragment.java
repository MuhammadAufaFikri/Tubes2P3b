package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentFrsBinding;

import org.json.JSONObject;

public class frsFragment  extends Fragment implements View.OnClickListener{
    private FragmentFrsBinding binding;
    protected String token;
    public static frsFragment newInstance(String title){
        frsFragment fragment = new frsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentFrsBinding.inflate(inflater,container,false);
        this.binding.keHistoryFrs.setOnClickListener(this);
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
        if(this.binding.keHistoryFrs == view){
            Bundle result = new Bundle();
            result.putInt("page",11);//pindah ke history frs
            this.getParentFragmentManager().setFragmentResult("Fragment History FRS", result);
            this.getParentFragmentManager().setFragmentResult("changePage",result);
        }
    }

}
