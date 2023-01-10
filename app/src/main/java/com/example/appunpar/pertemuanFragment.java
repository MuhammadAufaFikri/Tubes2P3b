package com.example.appunpar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentLoginBinding;
import com.example.appunpar.databinding.FragmentPertemuanBinding;

import org.json.JSONObject;

public class pertemuanFragment extends Fragment{
    private FragmentPertemuanBinding binding;
    protected String token;
    public static pertemuanFragment newInstance(String title){
        pertemuanFragment fragment = new pertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentPertemuanBinding.inflate(inflater,container,false);
        this.binding.keBuatPertemuan.setOnClickListener(this::onClick);
        this.binding.keLihatJadwalDosen.setOnClickListener(this::onClick);
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
    public void loadData() {
        callVolleyPresent.callVolley(Request.Method.GET, "https://ifportal.labftis.net/api/v1/announcements", null, "YOUR_TOKEN", new callVolleyPresent.VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {

            }

            @Override
            public void onErrorResponse(JSONObject error) {
                // Do something with the error
            }
        });
    }
}
