package com.example.appunpar;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class loginPresenterPost {
    final String BASE_URL = "https://ifportal.labftis.net/api/v1/authenticate";
    private Context context;
    private Gson gson;
    private String role;
    private LoginInterface ui;

    public loginPresenterPost(Context context, LoginInterface ui) {
        this.context = context;
        this.ui = ui;
    }

    public void execute(String email, String password, String role) throws JSONException{
        Log.d("execute","tereksekusicode");
        this.gson = new Gson();
        this.role= role;
        loginInput input = new loginInput(email, password,role);
        JSONObject objJSON = new JSONObject(gson.toJson(input));
        this.callVolley(objJSON);

    }

    private void callVolley(JSONObject toJson) {
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL, toJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        processResult(response.toString());
                        Log.d("tokenuserpost", "token dibuat");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ui.failed();
                Log.d("tokengagal", error.toString());
            }
        });

        requestQueue.add(jsonRequest);
    }

    private void processResult(String json){
        loginResult result =  gson.fromJson(json, loginResult.class);
        String res = result.getPesan();
        String token =result.getToken();
        if(this.role=="student"){
            this.ui.validateStudent(token, res);
        }
        else {
            this.ui.validateAdmin(token, res);
        }

    }

    interface LoginInterface {
        public void validateStudent(String token, String message);
        public void validateAdmin(String token, String message);
        public void failed();
    }
}
