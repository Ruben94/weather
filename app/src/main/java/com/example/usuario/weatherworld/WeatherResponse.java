package com.example.usuario.weatherworld;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    public @SerializedName("main") Main main;
    public  @SerializedName("coord") Coord coord;
    public  @SerializedName("weather") List<Weather> weather;
    public @SerializedName("name") String name;


    public class Main{
        public  @SerializedName("temp") float temperature;

        public float getTemperature() {
            return temperature;
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }
    }

    public Main getMain() {
            return main;
    }

    public void setMain(Main main) {
            this.main = main;
    }






    public class Weather{
        @SerializedName("main") String main;
        @SerializedName("description") String description;
        @SerializedName("icon") String icon;


        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }







    public class Coord{
        @SerializedName("lon") private float longitude;
        @SerializedName("lat") private float latitude;

        public float getLongitude() {
            return longitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public float getLatitude() {
            return latitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
