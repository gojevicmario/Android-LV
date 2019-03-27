package com.example.lv2.helpers;

import android.content.Context;

import com.example.lv2.objects.City;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class CityHelper {


    private static CityHelper instance;
    private Context context;

    private List<City> cityList;

    private CityHelper(Context context){
        this.context = context;
        parseCities();
    }

    public static CityHelper getInstance(Context context) {

        if(instance == null)
            instance = new CityHelper(context);

        return instance;
    }

    public List<City> getCityList(){

        return cityList;
    }

    public String[] getCityNames(){

        if(cityList == null)
            return null;

        String[] cityNames = new String[cityList.size()];
        for (int i = 0; i < cityList.size(); i++){
            cityNames[i] = cityList.get(i).getName();
        }

        return cityNames;
    }

    private void parseCities(){

        String tContents;

        try {
            InputStream stream = context.getAssets().open("cities.json");

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);


            if(tContents != null && !tContents.isEmpty()) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                cityList = Arrays.asList(gson.fromJson(tContents, City[].class));

            }
        } catch (IOException e) {
        // Handle exceptions here
        }

    }
}
