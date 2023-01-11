package com.example.appunpar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

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
    private homeAdminFragment homeAdmin;
    private homeLectureFragment homeLecture;
    private isifrsFragment isifrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.login = loginFragment.newInstance("Fragment login"); //1
        this.home = homeFragment.newInstance("Fragment home"); //2
        this.pengumuman= pengumumanFragment.newInstance("Fragment Pengumuman");//3
        this.detailPengumuman = detailPengumumanFragment.newInstance("Fragment detail pengumuman");//4
        this.buatPengumuman = buatPengumumanFragment.newInstance("Fragment buat pengumuman");//5
        this.pertemuan = pertemuanFragment.newInstance("Fragment pertemuan");//6
        this.detailPertemuan= detailPertemuanFragment.newInstance("Fragment detail pertemuan");//7
        this.buatPertemuan= buatPertemuanFragment.newInstance("Fragment buat pertemuan");//8
        this.lihatJadwalDosen = lihatJadwalDosenFragment.newInstance("Fragment lihat jadwal dosen");//9
        this.frs= frsFragment.newInstance("Fragment frs");//10
        this.hitoryFRS= hitoryFRSfragment.newInstance("Fragment history frs");//11
        this.detailMatkul= detailMatkulFragment.newInstance("Fragment detail matkul");//12
        this.isifrs= isifrsFragment.newInstance("Fragment isi Frs");//16

        // khusus admin
        this.adminBuatUser= adminBuatUserFragment.newInstance("Fragment buat user");//13
        this.homeAdmin = homeAdminFragment.newInstance("Fragment home admin"); //14

        //khusus lecture
        this.homeLecture = homeLectureFragment.newInstance("Fragment home lecture"); //15

        this.fragmentManager = this.getSupportFragmentManager();

        this.fragmentManager.beginTransaction().add(R.id.fragment_container, homeAdmin).commit();

        this.fragmentManager.setFragmentResultListener("changePage", this, this);

        this.fragmentManager.setFragmentResultListener("closeApplication", this, this);
    }

    @Override
    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
        if(requestKey.equals("changePage")){
            int page = result.getInt("page");
            changePage(page);
        }else if(requestKey.equals("closeApplication")){
            closeApplication();
        }
    }
    private void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        //1.login halaman
        if (page==1){
            if(this.login.isAdded()){
                ft.show(this.login);
            } else {
                ft.add(R.id.fragment_container, this.login).addToBackStack(null);;
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //2.home mahasiswa
        else if (page==2){
            if(this.home.isAdded()){
                ft.show(this.home);
            } else {
                ft.add(R.id.fragment_container, this.home).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //3. pengumuman
        else if (page==3){
            if(this.pengumuman.isAdded()){
                ft.show(this.pengumuman);
            } else {
                ft.add(R.id.fragment_container, this.pengumuman).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //4. detail pengumuman
        else if (page==4){
            if(this.detailPengumuman.isAdded()){
                ft.show(this.detailPengumuman);
            } else {
                ft.add(R.id.fragment_container, this.detailPengumuman).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //5.buat pengumuman
        else if (page==5){
            if(this.buatPengumuman.isAdded()){
                ft.show(this.buatPengumuman);
            } else {
                ft.add(R.id.fragment_container, this.buatPengumuman).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //6.petemuan
        else if (page==6){
            if(this.pertemuan.isAdded()){
                ft.show(this.pertemuan);
            } else {
                ft.add(R.id.fragment_container, this.pertemuan).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //7.detail pertemuan
        else if (page==7){
            if(this.detailPertemuan.isAdded()){
                ft.show(this.detailPertemuan);
            } else {
                ft.add(R.id.fragment_container, this.detailPertemuan).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //8.buat pertemuan
        else if (page==8){
            if(this.buatPertemuan.isAdded()){
                ft.show(this.buatPertemuan);
            } else {
                ft.add(R.id.fragment_container, this.buatPertemuan).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //9. lihat jadwal dosen
        else if (page==9){
            if(this.lihatJadwalDosen.isAdded()){
                ft.show(this.lihatJadwalDosen);
            } else {
                ft.add(R.id.fragment_container, this.lihatJadwalDosen).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //10.frs
        else if (page==10){
            if(this.frs.isAdded()){
                ft.show(this.frs);
            } else {
                ft.add(R.id.fragment_container, this.frs).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //11.history frs
        else if (page==11){
            if(this.hitoryFRS.isAdded()){
                ft.show(this.hitoryFRS);
            } else {
                ft.add(R.id.fragment_container, this.hitoryFRS).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //12.detail matkul
        else if (page==12){
            if(this.detailMatkul.isAdded()){
                ft.show(this.detailMatkul);
            } else {
                ft.add(R.id.fragment_container, this.detailMatkul).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }

            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //13. admin buat user
        else if (page==13){
            if(this.adminBuatUser.isAdded()){
                ft.show(this.adminBuatUser);
            } else {
                ft.add(R.id.fragment_container, this.adminBuatUser).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //14.homeAdmin
        else if (page==14){
            if(this.homeAdmin.isAdded()){
                ft.show(this.homeAdmin);
            } else {
                ft.add(R.id.fragment_container, this.homeAdmin).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }

        }
        //15.homeDosen
        else if (page==15){
            if(this.homeLecture.isAdded()){
                ft.show(this.homeLecture);
            } else {
                ft.add(R.id.fragment_container, this.homeLecture).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.isifrs.isAdded()){
                ft.hide(this.isifrs);
            }
        }
        //isi frs
        else if (page==16){
            if(this.isifrs.isAdded()){
                ft.show(this.isifrs);
            } else {
                ft.add(R.id.fragment_container, this.isifrs).addToBackStack(null);
            }
            if(this.login.isAdded()){
                ft.hide(this.login);
            }
            if(this.home.isAdded()){
                ft.hide(this.home);
            }
            if(this.pengumuman.isAdded()){
                ft.hide(this.pengumuman);
            }
            if(this.detailPengumuman.isAdded()){
                ft.hide(this.detailPengumuman);
            }
            if(this.buatPengumuman.isAdded()){
                ft.hide(this.buatPengumuman);
            }
            if(this.pertemuan.isAdded()){
                ft.hide(this.pertemuan);
            }
            if(this.detailPertemuan.isAdded()){
                ft.hide(this.detailPertemuan);
            }
            if(this.buatPertemuan.isAdded()){
                ft.hide(this.buatPertemuan);
            }
            if(this.lihatJadwalDosen.isAdded()){
                ft.hide(this.lihatJadwalDosen);
            }
            if(this.frs.isAdded()){
                ft.hide(this.frs);
            }
            if(this.hitoryFRS.isAdded()){
                ft.hide(this.hitoryFRS);
            }
            if(this.detailMatkul.isAdded()){
                ft.hide(this.detailMatkul);
            }
            //khusus admin
            if(this.adminBuatUser.isAdded()){
                ft.hide(this.adminBuatUser);
            }
            if(this.homeAdmin.isAdded()){
                ft.hide(this.homeAdmin);
            }
            if(this.homeLecture.isAdded()){
                ft.hide(this.homeLecture);
            }
        }
        ft.commit();
    }
    private void closeApplication(){
        this.moveTaskToBack(true);
        this.finish();
    }
}