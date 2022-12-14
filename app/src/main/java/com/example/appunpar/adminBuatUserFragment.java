package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentAdminBuatUserBinding;

import org.json.JSONObject;

public class adminBuatUserFragment extends Fragment{
    private FragmentAdminBuatUserBinding binding;
    protected String token;
    public static adminBuatUserFragment newInstance(String title){
        adminBuatUserFragment fragment = new adminBuatUserFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentAdminBuatUserBinding.inflate(inflater,container,false);
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
    public void inputData(JSONObject toJson) {
        callVolleyPresent.callVolley(Request.Method.POST, "https://ifportal.labftis.net/api/v1/users", toJson, this.token, new callVolleyPresent.VolleyCallback() {
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
