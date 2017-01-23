package com.example.usuario.weatherworld;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.weatherworld.managers.WeatherAPI;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherDetailsFragment extends Fragment {
    TextView cityNameText;
    TextView temperatureText;
    ImageView icon;



    public WeatherDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather_details, container, false);
        cityNameText = (TextView) view.findViewById(R.id.fragment_weather_details_city_name);
        temperatureText = (TextView) view.findViewById(R.id.fragment_weather_details_temperature);
        icon = (ImageView) view.findViewById(R.id.fragment_weather_details_icon);
        return view;
    }

    public void showWeather(String cityName, String lang) {
        WeatherAPI api = new WeatherAPI();
        api.getCurrentWeatherConditions(getContext(), cityName, lang);

        api.setOnWeatherDownLoadDataFinished(new WeatherAPI.WeatherDownloadDatafinished() {
            @Override
            public void newWeatherData(String cityName, float temperature) {
                cityNameText.setText(cityName);
                temperatureText.setText(temperature + "ºC");
            }
        });

    }
}
