package com.example.appunpar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentLihatJadwalDosenBinding;

import org.json.JSONObject;

import java.util.Calendar;

public class lihatJadwalDosenFragment extends Fragment{
    private FragmentLihatJadwalDosenBinding binding;
    protected String token;
    private TextView tglStart;
    private TextView tglEnd;
    private Spinner mSpinner;

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


        //spinner
        mSpinner = this.binding.spinnerRole2;
        String[] Item = {"admin","lecturer","student"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,Item);

        //Memasukan Adapter pada Spinner

        mSpinner.setAdapter(adapter);

        //datepicker

        tglStart = this.binding.tglStart;
        tglEnd = this.binding.tglEnd;


        this.binding.tglStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDateTime1();
            }
        });
        this.binding.tglEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDateTime2();
            }
        });

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

    //timepicker
    void getDateTime1(){
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // on below line we are setting date to our text view.
                        tglStart.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth );

                    }
                },
                year, month, day);
        datePickerDialog.show();
    }
    void getDateTime2(){
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // on below line we are setting date to our text view.
                        tglEnd.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth );

                    }
                },
                year, month, day);
        datePickerDialog.show();
    }




    
    private void getToken(String token) {
        this.token=token;
    }
    public void loadDataJadwal() {
        callVolleyPresent.callVolley(Request.Method.GET, "https://ifportal.labftis.net/api/v1/appointments/users/<user_id>/start-date/<start_date>/end-date/<end_date>", null, "YOUR_TOKEN", new callVolleyPresent.VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {

            }

            @Override
            public void onErrorResponse(JSONObject error) {
                // Do something with the error
            }
        });
    }
    public void loadDosen() {
        callVolleyPresent.callVolley(Request.Method.GET, "https://ifportal.labftis.net/api/v1/users?filter=<filter>&order=<order>&limit=<limit>&offset=<offset>", null, "YOUR_TOKEN", new callVolleyPresent.VolleyCallback() {
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
