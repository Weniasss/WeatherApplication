package com.firstapp.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class Fragment2 extends Fragment {

    private TextView editText;
    private TextView editText2;
    private TextView editText3;
    private TextView editText4;
    private TextView data;
    private TextView weatherDesc;

    ImageView view_weather;


    CharSequence city ="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v = (ViewGroup)inflater.inflate(R.layout.fragment2,container,false);

        editText = v.findViewById(R.id.edit_text);

        view_weather = v.findViewById(R.id.wheather_image);

        view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d11d));


        editText.setText("London");

        data = v.findViewById(R.id.data);
        data.setText("Information :");

        weatherDesc = v.findViewById(R.id.weatherDescription);
        weatherDesc.setText("Description : ");

        editText2 = v.findViewById(R.id.edit_text2);

        editText2.setText("Temperature : ");

        editText3 = v.findViewById(R.id.weatherDescription2);
        editText3.setText("Wind speed : ");

        editText4 = v.findViewById(R.id.weatherDescription3);
        editText4.setText("Humidity : ");


        city = "London";
        editText.setText(city);

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        String url = "https://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=a6f41d947e0542a26580bcd5c3fb90ef&units=metric";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject cityInfo = null;
                        try {
                            cityInfo = new JSONObject(response);

                            JSONObject main = cityInfo.getJSONObject("main");

                            JSONObject wind = cityInfo.getJSONObject("wind");

                            double windSpeed = wind.getDouble("speed");

                            double temp = main.getDouble("temp");

                            int humidity = main.getInt("humidity");

                            JSONArray weather = cityInfo.getJSONArray("weather");
                            JSONObject IDweather = weather.getJSONObject(0);
                            String cityID = IDweather.getString("description");

                            String iconID = IDweather.getString("icon");

                            switch(iconID){
                                case "01d":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d01d));
                                    break;
                                case "01n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d01d));
                                    break;
                                case "02d":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d02d));
                                    break;
                                case "02n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d02d));
                                    break;
                                case "03d":
                                case "03n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d03d));
                                    break;
                                case "04d":
                                case "04n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d04d));
                                    break;
                                case "09d":
                                case "09n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d09d));
                                    break;
                                case "10d":
                                case "10n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d10d));
                                    break;
                                case "11d":
                                case "11n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d11d));
                                    break;
                                case "13d":
                                case "13n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d13d));
                                    break;
                            }

                            editText2.setText("temperature : " + temp + " °C");

                            weatherDesc.setText("Description : " + cityID);

                            editText3.setText("Wind speed : " + windSpeed);

                            editText4.setText("Humidity : " + humidity);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext() , "error" , Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(stringRequest);

        return v;
    }



    public void updateEditText(CharSequence newText){


        city = newText;
        editText.setText(city);

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + newText + " &appid=a6f41d947e0542a26580bcd5c3fb90ef&units=metric";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject cityInfo = null;
                        try {
                            cityInfo = new JSONObject(response);

                            JSONObject main = cityInfo.getJSONObject("main");

                            JSONObject wind = cityInfo.getJSONObject("wind");

                            double windSpeed = wind.getDouble("speed");

                            double temp = main.getDouble("temp");

                            int humidity = main.getInt("humidity");

                            JSONArray weather = cityInfo.getJSONArray("weather");
                            JSONObject IDweather = weather.getJSONObject(0);
                            String cityID = IDweather.getString("description");

                            String iconID = IDweather.getString("icon");

                            switch(iconID){
                                case "01d":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d01d));
                                    break;
                                case "01n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d01d));
                                    break;
                                case "02d":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d02d));
                                    break;
                                case "02n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d02d));
                                    break;
                                case "03d":
                                case "03n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d03d));
                                    break;
                                case "04d":
                                case "04n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d04d));
                                    break;
                                case "09d":
                                case "09n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d09d));
                                    break;
                                case "10d":
                                case "10n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d10d));
                                    break;
                                case "11d":
                                case "11n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d11d));
                                    break;
                                case "13d":
                                case "13n":
                                    view_weather.setImageDrawable(getResources().getDrawable(R.drawable.d13d));
                                    break;
                            }

                            editText2.setText("temperature : " + temp + " °C");

                            weatherDesc.setText("Description : " + cityID);

                            editText3.setText("Wind speed : " + windSpeed);

                            editText4.setText("Humidity : " + humidity);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext() , "error" , Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
