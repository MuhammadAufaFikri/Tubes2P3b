package com.example.appunpar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.os.Bundle;

import com.example.appunpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentResultListener {
    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private loginFragment login;
    private homeFragment home;
    private pengumumanFragment pengumuman;
    private detailPengumumanFragment detailPengumuman;
    private buatPengumumanfragment buatPengumuman;
    private pertemuanFragment pertemuan;
    private detailPertemuanFragment detailPertemuan;
    private buatPertemuanFragment buatPertemuan;
    private lihatJadwalFragment lihatJadwal;
    private frsFragment frs;
    private hitoryFRSfragment hitoryFRS;
    private detailMatkulFragment detailMatkul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.login = loginFragment.newInstance("Fragment login");


        this.fragmentManager = this.getSupportFragmentManager();

        this.fragmentManager.beginTransaction().add(R.id.fragment_container, login).addToBackStack(null).commit();

        this.fragmentManager.setFragmentResultListener("changePage", this, this);

        this.fragmentManager.setFragmentResultListener("closeApplication", this, this);
    }

    @Override
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

    }
}