package com.firstapp.myapplication;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_WEATHER_BY_ID = "https://api.openweathermap.org/data/2.5/forecast?q=Berlin&appid=a6f41d947e0542a26580bcd5c3fb90ef&units=metric";

    Context context;
    String cityID = "";

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String cityID);
    }

    public interface ForeCastByIDResponse {
        void onError(String message);

        void onResponse(List<WeatherReportModel> weatherReportModels);
    }

    public void getCityForecstByID(String cityID , ForeCastByIDResponse foreCastByIDResponse) {
        List<WeatherReportModel> weatherReportModels = new ArrayList<>();

        String url = QUERY_FOR_CITY_WEATHER_BY_ID;

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    int i = 0;
                    double temp = 0;
                    String desc = "";
                    String time = "";

                    JSONObject cityInfo = new JSONObject(response);
                    JSONArray weatherArray = cityInfo.getJSONArray("list");

                    for(i=0;i<weatherArray.length();i++){
                        JSONObject day = weatherArray.getJSONObject(i);

                        time = day.getString("dt_txt");

                        JSONObject main = day.getJSONObject("main");
                        temp = main.getDouble("temp");

                        JSONObject weather = day.getJSONArray("weather").getJSONObject(0);

                        desc = weather.getString("description");
                        String temps = temp + "°C";

                        WeatherReportModel one_day_weather = new WeatherReportModel();

                        one_day_weather.setWeather_state_name(desc);
                        one_day_weather.setApplicable_date(time);
                        one_day_weather.setThe_temp(temps);

                        weatherReportModels.add(one_day_weather);
                    }
                    foreCastByIDResponse.onResponse(weatherReportModels);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}