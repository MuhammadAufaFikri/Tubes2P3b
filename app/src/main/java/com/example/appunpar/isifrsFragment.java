package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentIsiFrsBinding;

import org.json.JSONObject;

public class isifrsFragment  extends Fragment{
    private FragmentIsiFrsBinding binding;
    protected String token;
    private Spinner semesterSpinner;
    private adapterListPraSyarat adapterPraSyarat;

    public static isifrsFragment newInstance(String title){
        isifrsFragment fragment = new isifrsFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.binding = FragmentIsiFrsBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        semesterSpinner = this.binding.spinnersemester;
        String[] Item = {"semua","semester 1","semester 2","semester 3","semester 4","semester 5","semester 6","semester 7","semester 8"};
        ArrayAdapter<String> adapterSemesterSpinner = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,Item);
        //Memasukan Adapter pada Spinner
        semesterSpinner.setAdapter(adapterSemesterSpinner);
        String[] matkul={};
        ArrayAdapter<String> adapterMatkul = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, matkul);
        AutoCompleteTextView acttextView = this.binding.actvMatkul;
        acttextView.setAdapter(adapterMatkul);




        return view;
    }

    public void loadtDataCourse() {
        String url="https://ifportal.labftis.net/api/v1/courses";
        callVolleyPresent.callVolley(Request.Method.GET, url, null, token, new callVolleyPresent.VolleyCallback() {
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
