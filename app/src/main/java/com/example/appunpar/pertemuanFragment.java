package com.example.appunpar;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentPertemuanBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class pertemuanFragment extends Fragment{
    private FragmentPertemuanBinding binding;
    protected String token;
    protected List<modelPertemuan> pertemuanList;
    private ListView listView;
    private adapterListPertemuan adapter;
    public static pertemuanFragment newInstance(String title){
        pertemuanFragment fragment = new pertemuanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.token=saveToken.getToken();
        this.binding = FragmentPertemuanBinding.inflate(inflater,container,false);
        this.binding.keBuatPertemuan.setOnClickListener(this::onClick);
        this.binding.keLihatJadwalDosen.setOnClickListener(this::onClick);
        View view = this.binding.getRoot();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        String today= year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d",day );
        c.add(Calendar.DATE, 7);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        String next_week= year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d",day );

        loadData(today,next_week);

        return view;
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
    public void loadData(String today,String next_week) {
        Log.d("hari",today+" / "+next_week);
        String url="https://ifportal.labftis.net/api/v1/appointments/start-date/"+today+"/end-date/"+next_week;
        Log.d("url = ",url);

        callVolleyPresent callvolleyPresent = callVolleyPresent.getInstance(getActivity().getApplicationContext());
        callvolleyPresent.callVolley(Request.Method.GET, url, null, this.token, new callVolleyPresent.VolleyCallback() {
            @Override
            public void onSuccessResponse(JSONObject result) {

                try {
                    JSONObject json = new JSONObject(result.toString());
                    Log.d("ada resphon",json.toString());
                    JSONArray jsonArray = new JSONArray(result.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");
                        String start_datetime = jsonObject.getString("start_datetime");
                        String end_datetime = jsonObject.getString("end_datetime");
                        String organizer_id = jsonObject.getString("organizer_id");
                        String organizer_name = jsonObject.getString("organizer_name");
                        modelPertemuan model = new modelPertemuan(id, title, description, start_datetime, end_datetime, organizer_id, organizer_name);
                        pertemuanList.add(model);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

// Tambahkan data ke announcements dan panggil adapter.notifyDataSetChanged()
                Log.d("diload",pertemuanList.toString());
                adapter = new adapterListPertemuan(getActivity(), pertemuanList);
                listView = binding.listPertemuan;
                listView.setAdapter(adapter);

            }

            @Override
            public void onErrorResponse(JSONObject error) {
                // Do something with the error
                Log.d("error","ini error");
                Toast toast = Toast.makeText(getActivity(), "belum ada pertemuan minggu ini", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });
    }
}
