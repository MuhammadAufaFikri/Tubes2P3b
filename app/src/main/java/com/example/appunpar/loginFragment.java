package com.example.appunpar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.appunpar.databinding.FragmentLoginBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class loginFragment extends Fragment implements View.OnClickListener, loginPresenterPost.LoginInterface, AdapterView.OnItemSelectedListener {
    protected FragmentLoginBinding binding;
    protected loginPresenterPost presenter;
    private Spinner mSpinner;
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
        super.onCreate(savedInstanceState);
        this.binding = FragmentLoginBinding.inflate(inflater,container,false);
        this.binding.btnLogin.setOnClickListener(this);
        View view = this.binding.getRoot();
        this.presenter = new loginPresenterPost(this.getContext(),this);
        this.pencatat = new cacheLoginDisplay(this.getContext());
        // In the onCreate method of your activity
        mSpinner = this.binding.spinnerRole;
        String[] Item = {"admin","lecturer","student"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,Item);

        //Memasukan Adapter pada Spinner

        mSpinner.setAdapter(adapter);

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
        if((this.binding.etAcount.getText().length() == 0 || this.binding.etPass.getText().length() == 0)&& view==this.binding.btnLogin){
            // AlertDialog
            AlertDialog.Builder peringatanBelumIsi = new AlertDialog.Builder(getActivity());
            peringatanBelumIsi.setTitle("Peringatan");
            peringatanBelumIsi.setMessage("email atau password belum dimasukan");
            peringatanBelumIsi.setNeutralButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog dialog = peringatanBelumIsi.create();
            dialog.show();
        }else if(this.binding.btnLogin==view){
            this.email = this.binding.etAcount.getText().toString();
            String password = this.binding.etPass.getText().toString();
            String role= mSpinner.getSelectedItem().toString();

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
        simpanTokenData(token);
        this.getParentFragmentManager().setFragmentResult("Fragment home", result);
        this.getParentFragmentManager().setFragmentResult("changePage",result);
    }

    @Override
    public void validateAdmin(String token, String message) {
        Log.d("pindah","ke home admin");
        Bundle result = new Bundle();
        result.putInt("page",14);//pindah ke home admin
        simpanTokenData(token);
        this.getParentFragmentManager().setFragmentResult("Fragment home admin", result);
        this.getParentFragmentManager().setFragmentResult("changePage",result);
    }

    @Override
    public void validateLecture(String token, String message) {
        Bundle result = new Bundle();
        result.putInt("page",15);//pindah ke home dosen
        simpanTokenData(token);
        this.getParentFragmentManager().setFragmentResult("Fragment home lecture", result);
        this.getParentFragmentManager().setFragmentResult("changePage",result);
    }

    public void failed(VolleyError error){

        // AlertDialog
        AlertDialog.Builder peringatanSalahIsian = new AlertDialog.Builder(getActivity());
        peringatanSalahIsian.setTitle("Peringatan");
        peringatanSalahIsian.setMessage("email atau password salah");
        peringatanSalahIsian.setNeutralButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog dialog = peringatanSalahIsian.create();
        dialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void simpanTokenData(String token) {
        callVolleyPresent callvolleyPresent = callVolleyPresent.getInstance(getActivity().getApplicationContext());
        callvolleyPresent.callVolley(Request.Method.GET, "https://ifportal.labftis.net/api/v1/users/self", null, token, new callVolleyPresent.VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {
                try {
                    JSONObject json = new JSONObject(result.toString()); // jsonString adalah string yang berisi data JSON
                    String id = json.getString("id");
                    String name = json.getString("name");
                    String email = json.getString("email");
                    saveToken saveToken = new saveToken(id, name, email,token);
                } catch (JSONException e) {
                    // Tambahkan kode untuk menangani kesalahan
                }
            }

            @Override
            public void onErrorResponse(JSONObject error) {
                // Do something with the error
            }
        });
    }
}