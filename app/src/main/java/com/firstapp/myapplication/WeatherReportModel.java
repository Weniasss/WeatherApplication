package com.firstapp.myapplication;

class WeatherReportModel {


    String weather_state_name;
    String applicable_date;
    String the_temp;


    public WeatherReportModel(String weather_state_name, String applicable_date,String the_temp) {
        this.weather_state_name = weather_state_name;
        this.applicable_date = applicable_date;
        this.the_temp = the_temp;
    }

    public WeatherReportModel() {
    }

    @Override
    public String toString() {
        return  "State: " + weather_state_name + '\''  +"Date: " + applicable_date + '\'' +
                "Temp:" + the_temp;
    }



    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }



    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public String getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(String the_temp) {
        this.the_temp = the_temp;
    }

}