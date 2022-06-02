package com.firstapp.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class Fragment3 extends Fragment {
    private TextView text;

    ListView listView3;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = (ViewGroup)inflater.inflate(R.layout.fragment3,container,false);

        listView3 = v.findViewById(R.id.lv_weatherReport);

        final WeatherDataService weatherDataService = new WeatherDataService(getActivity());

//        text = v.findViewById(R.id.textViewFragment3);
//
//        text.setText("cos");


        return v;
    }

    public void updateEditText2(String newText) {

        final WeatherDataService weatherDataService = new WeatherDataService(getActivity());

        weatherDataService.getCityForecstByID("London", new WeatherDataService.ForeCastByIDResponse() {
            @Override
            public void onError(String message) {
                Toast.makeText(getActivity(), "wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<WeatherReportModel> weatherReportModels) {
                ListAdapter listAdapter = new ListAdapter(getActivity(),weatherReportModels);
                listView3.setAdapter(listAdapter);
            }
        });
    }

}
