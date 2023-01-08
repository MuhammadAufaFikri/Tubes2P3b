package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.appunpar.databinding.FragmentLihatJadwalDosenBinding;

public class lihatJadwalDosenFragment extends Fragment{
    private FragmentLihatJadwalDosenBinding binding;
    protected String token;
    public static lihatJadwalDosenFragment newInstance(String title){
        lihatJadwalDosenFragment fragment = new lihatJadwalDosenFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentLihatJadwalDosenBinding.inflate(inflater,container,false);
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
}
