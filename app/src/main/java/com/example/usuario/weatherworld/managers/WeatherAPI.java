package com.example.usuario.weatherworld.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.usuario.weatherworld.R;
import com.example.usuario.weatherworld.WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;


public class WeatherAPI {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String METHOD_CURRENT_WEATHER = "weather";

    public interface WeatherDownloadDatafinished{
        public void newWeatherData(String cityName, float temperature);
    }

    private WeatherDownloadDatafinished listener;

    public void setOnWeatherDownLoadDataFinished(WeatherDownloadDatafinished listener){
        this.listener = listener;
    }




    public void getCurrentWeatherConditions(Context context, String city, String langCode){

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + METHOD_CURRENT_WEATHER + "?q=" + city + "&units=metric" +
                "&lang=" + langCode +
                "&appid=" + context.getString(R.string.token);

        Log.d("URL", url);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE", response);
                parseJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HORROR", "Connection went to shit to the trcks");
            }
        });
        queue.add(request);
    }
    private void parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        Reader reader = new StringReader(response);
        WeatherResponse weatherResponse = gson.fromJson(reader, WeatherResponse.class);
        Log.d("response", weatherResponse.toString());

        if (listener != null){
            listener.newWeatherData(weatherResponse.getName(), weatherResponse.getMain().getTemperature());
        }
    }
}
