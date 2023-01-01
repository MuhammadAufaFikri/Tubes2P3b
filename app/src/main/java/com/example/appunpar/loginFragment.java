package com.example.appunpar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appunpar.databinding.FragmentLoginBinding;
import com.google.gson.Gson;

import org.json.JSONException;
public class loginFragment extends Fragment implements View.OnClickListener, loginPresenterPost.LoginInterface{
    protected FragmentLoginBinding binding;
    protected loginPresenterPost presenter;
    private String email;
    private cacheLoginDisplay pencatat;

    public static loginFragment newInstance(String title){
        loginFragment fragment = new loginFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        this.binding = FragmentLoginBinding.inflate(inflater,container,false);
        this.binding.btnLogin.setOnClickListener(this);
        this.binding.btnAcount.setOnClickListener(this);
        View view = this.binding.getRoot();
        this.presenter = new loginPresenterPost(this.getContext(),this);
        this.pencatat = new cacheLoginDisplay(this.getContext());
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        this.pencatat.saveEmail(this.binding.etAcount.getText().toString());
        this.pencatat.savePassword(this.binding.etPass.getText().toString());
    }

    @Override
    public void onResume() {
        super.onResume();
        this.binding.etAcount.setText(this.pencatat.getEmail());
        this.binding.etPass.setText(this.pencatat.getPassword());
    }

    @Override
    public void onClick(View view) {
        if(this.binding.etAcount.getText().length() == 0 || this.binding.etPass.getText().length() == 0){
            // AlertDialog nanti
        }else if(this.binding.btnLogin==view){
            this.email = this.binding.etAcount.getText().toString();
            String password = this.binding.etPass.getText().toString();
            String role= "student";
            try {
                presenter.execute(email, password,role);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        else if(this.binding.btnAcount==view){
            String email = "default.admin@domain.local";
            String password = "mu8XyUogLi6Dk7";
            String role = "admin";
            try {
                presenter.execute(email, password,role);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void validateStudent(String token, String message) {
        Bundle result = new Bundle();
        result.putInt("page",2);//pindah ke home
        result.putString("token", token);
        result.putString("email", this.email);
        this.getParentFragmentManager().setFragmentResult("homePage", result);
        this.getParentFragmentManager().setFragmentResult("changePage",result);
    }

    @Override
    public void validateAdmin(String token, String message) {
        Bundle result = new Bundle();
        result.putInt("page",13);//pindah ke home
        result.putString("token", token);
        result.putString("email", this.email);
        this.getParentFragmentManager().setFragmentResult("listUserPage", result);
        this.getParentFragmentManager().setFragmentResult("changePage",result);
    }

    public void failed(){
        //alert
    }
}