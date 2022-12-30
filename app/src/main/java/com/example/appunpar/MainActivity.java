package com.example.appunpar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;

import com.example.appunpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentResultListener {
    private ActivityMainBinding binding;
    private loginFragment LoginFragment;
    private homeFragment HomeFragment;
    private pengumumanFragment PengumumanFragment;
    private detailPengumumanFragment DetailPengumumanFragment;
    private buatPengumumanfragment buatPengumumanfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

    }
}