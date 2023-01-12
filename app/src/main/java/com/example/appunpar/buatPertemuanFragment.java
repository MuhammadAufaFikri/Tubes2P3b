package com.example.appunpar;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentBuatPertemuanBinding;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class buatPertemuanFragment  extends Fragment implements View.OnClickListener {
    private FragmentBuatPertemuanBinding binding;
    protected String token;
    private TextView date;

    private TextView timeStart;
    private TextView timeEnd;
    private Gson gson;

    public static buatPertemuanFragment newInstance(String title){
        buatPertemuanFragment fragment = new buatPertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);


        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentBuatPertemuanBinding.inflate(inflater,container,false);
        this.token=saveToken.getToken();
        //timepicker
        timeStart = this.binding.jamStart;
        timeEnd = this.binding.jamEnd;

        date = this.binding.tanggalPertemuan;

        this.binding.tanggalPertemuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDatePicker();
            }
        });

        this.binding.jamStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTimePicker1();
            }
        });
        this.binding.jamEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTimePicker2();
            }
        });
        this.binding.btnSimpan.setOnClickListener(this);
        View view = this.binding.getRoot();
        return view;
    }


    void getDatePicker(){
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // on below line we are setting date to our text view.
                        date.setText(year + "-" + String.format("%02d", monthOfYear + 1) + "-" + String.format("%02d",dayOfMonth ));
                    }
                },
                year, month, day);
        datePickerDialog.show();
    }



    void getTimePicker1(){
        final Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

    // on below line we are initializing our Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay,
                                      int minute) {
                    // on below line we are setting selected time
                    // in our text view.
                    timeStart.setText(String.format("%02d:%02d", hourOfDay, minute));

                }
            }, hour, minute, false);
        timePickerDialog.show();
    }
    void getTimePicker2(){
        final Calendar c = Calendar.getInstance();

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // on below line we are initializing our Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // on below line we are setting selected time
                        // in our text view.
                        timeEnd.setText(String.format("%02d:%02d", hourOfDay, minute));


                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }



    public void inputData(JSONObject toJson) {
        callVolleyPresent.callVolley(Request.Method.POST, "https://ifportal.labftis.net/api/v1/appointments", toJson, this.token, new callVolleyPresent.VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {
                Toast toast = Toast.makeText(getActivity(), "pertemuan telah dibuat", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }

            @Override
            public void onErrorResponse(JSONObject error) {
                // Do something with the error
                Toast toast = Toast.makeText(getActivity(), "pertemuan gagal dibuat", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==this.binding.btnSimpan){
            Log.d("jam",this.binding.jamStart.getText().toString());
            String title= this.binding.etTitle.getText().toString();
            String description=this.binding.detail.getText().toString();
            String start_datetime=this.binding.tanggalPertemuan.getText().toString()+" "+this.binding.jamStart.getText().toString()+"+0700";
            String end_datetime=this.binding.tanggalPertemuan.getText().toString()+" "+this.binding.jamEnd.getText().toString()+"+0700";
            this.gson = new Gson();
            Log.d("tgl",start_datetime);
            appointmentInput input = new appointmentInput(title, description,start_datetime,end_datetime);
            try {
                JSONObject objJSON = new JSONObject(gson.toJson(input));
                Log.d("tes",objJSON.toString());
                inputData(objJSON);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
