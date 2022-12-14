package com.example.appunpar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appunpar.databinding.FragmentIsiFrsBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class isifrsFragment  extends Fragment{
    private FragmentIsiFrsBinding binding;
    protected String token;
    private Spinner semesterSpinner;
    protected List<modelMatkul> coursesList;
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
        fetchCourses();
        this.binding = FragmentIsiFrsBinding.inflate(inflater,container,false);
        View view = this.binding.getRoot();
        semesterSpinner = this.binding.spinnersemester;
        String[] Item = {"semua","semester 1","semester 2","semester 3","semester 4","semester 5","semester 6","semester 7","semester 8"};

        ArrayAdapter<String> adapterSemesterSpinner = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,Item);
        //Memasukan Adapter pada Spinner
        semesterSpinner.setAdapter(adapterSemesterSpinner);
        semesterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Code to run when an item is selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Code to run when nothing is selected
            }
        });
        String[] matkul={};
        fetchCourses();
        ArrayAdapter<String> adapterMatkul = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, matkul);
        AutoCompleteTextView acttextView = this.binding.actvMatkul;
        acttextView.setAdapter(adapterMatkul);
        acttextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Code to run when an item is selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Code to run when nothing is selected
            }
        });




        return view;
    }

    public void loadtDataCourse() {
        String url="";
        callVolleyPresent.callVolley(Request.Method.GET, url, null,this.token, new callVolleyPresent.VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {

            }

            @Override
            public void onErrorResponse(JSONObject error) {
                // Do something with the error
            }
        });
    }
    private void fetchCourses() {
        int limit = 10;
        int offset = 0;
        String url = "https://ifportal.labftis.net/api/v1/courses?limit=" + limit + "&offset=" + offset;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject course = response.getJSONObject(i);
                                String id = course.getString("id");
                                String code = course.getString("code");
                                String name = course.getString("name");
                                int semester = course.getInt("semester");
                                coursesList.add(new modelMatkul(id, code, name, semester));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if(response.length() >= limit) {
                            //offset += limit;
                            fetchCourses();
                        } else {
                            populateAutoComplete();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonArrayRequest);
    }

    private void populateAutoComplete() {
        // logic to populate the AutoCompleteTextView with the retrieved data
    }
}

