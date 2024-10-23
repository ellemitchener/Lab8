package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;
    }

    /**
     * Get the number of cities in the list.
     *
     * @return the size of the city list.
     */
    public int getCount() {
        return cities.size();
    }

    /**
     * Adds a city to the list.
     *
     * @param city the city to add.
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * Checks if a given city exists in the list.
     *
     * @param city the city to check.
     * @return true if the city exists, false otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list.
     *
     * @param city the city to delete.
     * @throws IllegalArgumentException if the city is not found in the list.
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list.");
        }
        cities.remove(city);
    }

    /**
     * Returns the total number of cities in the list.
     *
     * @return the count of cities.
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Gets the list of cities.
     *
     * @return the list of cities.
     */
    public ArrayList<City> getCities() {
        return cities;
    }
}


