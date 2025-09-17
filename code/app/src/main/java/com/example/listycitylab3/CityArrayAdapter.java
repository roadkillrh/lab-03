package com.example.listycitylab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {
    public CityArrayAdapter(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull android.view.ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);
        } else {
            view = convertView;
        }
        City city = getItem(position);
        assert city != null;
        // Populate the data into the template view using the data object
        TextView cityName = view.findViewById(R.id.city_name);
        TextView cityProvince = view.findViewById(R.id.city_province);
        cityName.setText(city.getName());
        cityProvince.setText(city.getProvince());
        return view;

    }
}
