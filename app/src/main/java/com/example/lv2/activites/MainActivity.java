package com.example.lv2.activites;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Spinner;

import com.example.lv2.R;
import com.example.lv2.helpers.CityHelper;
import com.example.lv2.objects.City;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cityNames = CityHelper.getInstance(this).getCityNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cityNames);
        final Spinner spinner = findViewById(R.id.spinner);

        spinner.setAdapter(adapter);
        Button button =  findViewById(R.id.btnGetForecast);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , WeatherDetailsActivity.class);
                startActivity(intent);
                City cityDto = new City();
                intent.putExtra("cityName", spinner.getSelectedItem().toString());
            }
        });
    }
}
