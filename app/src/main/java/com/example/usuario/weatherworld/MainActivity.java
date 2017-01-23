package com.example.usuario.weatherworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WeatherDetailsFragment fragment = (WeatherDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_weather_details);
        fragment.showWeather("Torremolinos", "es");

    }
}
