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
    private buatPengumumanFragment buatPengumuman;
    private pertemuanFragment pertemuan;
    private detailPertemuanFragment detailPertemuan;
    private buatPertemuanFragment buatPertemuan;
    private lihatJadwalDosenFragment lihatJadwalDosen;
    private frsFragment frs;
    private hitoryFRSfragment hitoryFRS;
    private detailMatkulFragment detailMatkul;
    private adminBuatUserFragment adminBuatUser;
    private adminListUserFragment adminListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.login = loginFragment.newInstance("Fragment login");
        this.home = homeFragment.newInstance("Fragment home");
        this.pengumuman= pengumumanFragment.newInstance("Fragment Pengumuman");
        this.detailPengumuman = detailPengumumanFragment.newInstance("Fragment detail pengumuman");
        this.buatPengumuman = buatPengumumanFragment.newInstance("Fragment buat pengumuman");
        this.pertemuan = pertemuanFragment.newInstance("Fragment pertemuan");
        this.detailPertemuan= detailPertemuanFragment.newInstance("Fragment detail pertemuan");
        this.buatPertemuan= buatPertemuanFragment.newInstance("Fragment buat pertemuan");
        this.lihatJadwalDosen = lihatJadwalDosenFragment.newInstance("Fragment lihat jadwal dosen");
        this.frs= frsFragment.newInstance("Fragment frs");
        this.hitoryFRS= hitoryFRSfragment.newInstance("Fragment history frs");
        this.detailMatkul= detailMatkulFragment.newInstance("Fragment detail matkul");

        // khusus admin
        this.adminListUser= adminListUserFragment.newInstance("Fragment list user");
        this.adminBuatUser= adminBuatUserFragment.newInstance("Fragment buat user");


        this.fragmentManager = this.getSupportFragmentManager();

        this.fragmentManager.beginTransaction().add(R.id.fragment_container, login).addToBackStack(null).commit();

        this.fragmentManager.setFragmentResultListener("changePage", this, this);

        this.fragmentManager.setFragmentResultListener("closeApplication", this, this);
    }

    @Override
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

    }
}