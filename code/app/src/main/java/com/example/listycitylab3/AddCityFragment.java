package com.example.listycitylab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddCityFragment extends DialogFragment {


    private static final String cityDefault = "city";
    private static final String provinceDefault = "province";
    private static final String positionDefault = "position";
    private EditText cityText;
    private EditText provinceText;

    public static AddCityFragment newInstance(String city, String province, int position) {
        AddCityFragment fragment = new AddCityFragment();
        Bundle args = new Bundle();
        args.putString(cityDefault, city);
        args.putString(provinceDefault, province);
        args.putInt(positionDefault, position);
        fragment.setArguments(args);
        return fragment;
    }
    interface AddCityDialogListener {
        void onCitySaved(City city, int position);
    }
    private AddCityDialogListener listener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AddCityDialogListener) {
            listener = (AddCityDialogListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement AddCityDialogListener");
        }
    }
    @NonNull
    //@Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view =
                LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_city, null);

        cityText = view.findViewById(R.id.edit_text_city_text);
        provinceText = view.findViewById(R.id.edit_text_province_text);

        Bundle args = getArguments();
        int position = -1;
        if (args != null) {
            cityText.setText(args.getString(cityDefault));
            provinceText.setText(args.getString(provinceDefault));
            position = args.getInt(positionDefault, -1);

        }
        int finalPostion = position;

        if (savedInstanceState != null) {
            cityText.setText(savedInstanceState.getString("city"));
            provinceText.setText(savedInstanceState.getString("province"));
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        return builder
                .setView(view)
                .setTitle("Add City")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", (dialog, which) -> {
                    String cityName = cityText.getText().toString();
                    String provinceName = provinceText.getText().toString();
                    City city = new City(cityName, provinceName);
                    listener.onCitySaved(city, finalPostion);

                })
                .create();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (cityText != null) {
            outState.putString("city", cityText.getText().toString());
            outState.putString("province", provinceText.getText().toString());
        }
    }

}

