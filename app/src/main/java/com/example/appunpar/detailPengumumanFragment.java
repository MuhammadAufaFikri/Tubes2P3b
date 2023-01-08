package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.appunpar.databinding.FragmentDetailPengumumanBinding;

public class detailPengumumanFragment  extends Fragment{
    private FragmentDetailPengumumanBinding binding;
    protected String token;
    public static detailPengumumanFragment newInstance(String title){
        detailPengumumanFragment fragment = new detailPengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentDetailPengumumanBinding.inflate(inflater,container,false);
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
