package com.assignment.picsumbrowser;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.assignment.picsumbrowser.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * Instance of ActivityMainBinding
     */
    private ActivityMainBinding activityMainBinding;
    /**
     * Instance of ActivityMainBinding
     */
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.rvDisplayContent.setLayoutManager(new GridLayoutManager(this, 2));
        final String url = "https://picsum.photos/list";
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final Type listType = new TypeToken<List<PicsumPojo>>() {
        }.getType();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = fetchData(url, gson, listType);
        requestQueue.add(jsonArrayRequest);
    }

    /**
     * Method to fetch the data the from url
     */
    private JsonArrayRequest fetchData(String url, final Gson gson, final Type listType) {
        return new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<PicsumPojo> picsumPojos = gson.fromJson(response.toString(), listType);
                recyclerViewAdapter = new RecyclerViewAdapter(picsumPojos);
                activityMainBinding.rvDisplayContent.setAdapter(recyclerViewAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "Error message " + error);
            }
        });
    }
}