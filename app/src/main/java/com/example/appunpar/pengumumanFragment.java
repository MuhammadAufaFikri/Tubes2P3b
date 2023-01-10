package com.example.appunpar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.android.volley.Request;
import com.example.appunpar.databinding.FragmentPengumumanBinding;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pengumumanFragment  extends Fragment{
    private FragmentPengumumanBinding binding;
    protected String token;
    protected List<modelPengumuman> pengumumanList;
    private ListView listView;
    private adapterListPengumuman adapter;

    public static pengumumanFragment newInstance(String title) {
        pengumumanFragment fragment = new pengumumanFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = FragmentPengumumanBinding.inflate(inflater, container, false);
        View view = this.binding.getRoot();

        this.token=saveToken.getToken();
        Log.d("tokenCuy",this.token);
        pengumumanList = new ArrayList<>();
        loadDataAwal();
        return view;
    }



    public void loadDataAwal() {
        callVolleyPresent callvolleyPresent = callVolleyPresent.getInstance(getActivity().getApplicationContext());
        int offset = 0;
        int limit = 10;
        final boolean[] isDataAvailable = {true};
        while(isDataAvailable[0]) {
            // Membuat parameter untuk request API
            Map<String, String> params = new HashMap<>();
            params.put("offset", String.valueOf(offset));
            params.put("limit", String.valueOf(limit));

            // Membuat request ke API
            callvolleyPresent.callVolley(Request.Method.GET, "https://ifportal.labftis.net/api/v1/announcements", params, this.token, new callVolleyPresent.VolleyCallback() {
                @Override
                public void onSuccessResponse(JSONObject result) {
                    try {
                        JSONObject json = new JSONObject(result.toString());
                        JSONArray jsonArray = json.getJSONArray("data");
                        if (jsonArray.length() == 0) {
                            isDataAvailable = false;
                        } else {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String id = jsonObject.getString("id");
                                String title = jsonObject.getString("title");
                                JSONArray tagsJsonArray = jsonObject.getJSONArray("tags");
                                List<String> tags = new ArrayList<>();
                                for (int j = 0; j < tagsJsonArray.length(); j++) {
                                    JSONObject tagsJsonObject = tagsJsonArray.getJSONObject(j);
                                    String tag = tagsJsonObject.getString("tag");
                                    tags.add(tag);
                                }
                                modelPengumuman model = new modelPengumuman(id, title, tags);
                                pengumumanList.add(model);
                            }
                            // Tambahkan data ke announcements dan panggil adapter.notifyDataSetChanged()
                            adapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        // Tambahkan kode untuk menangani kesalahan
                    }
                }

                @Override
                public void onErrorResponse(JSONObject error) {
                    // Do something with the error
                }
            });
            offset += limit;
        }
    }
}
