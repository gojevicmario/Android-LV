package com.example.lv2.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lv2.R;

public class WeatherDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        TextView _tViewCityName = findViewById(R.id.tViewCityName);
        TextView _tViewTemperature = findViewById(R.id.tViewTemperature);
        TextView _tviewWeatherDescription = findViewById(R.id.tViewWeatherDescription);


        _tViewCityName.setText(getIntent().getStringExtra("cityName"));
        _tviewWeatherDescription.setText("Dost dobro");
        _tViewTemperature.setText("15");

    }
}
