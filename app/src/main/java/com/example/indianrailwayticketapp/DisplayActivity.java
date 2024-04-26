package com.example.indianrailwayticketapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewDisplay = findViewById(R.id.textViewDisplay);

        String selectedBerthChoice = getIntent().getStringExtra("selectedBerthChoice");
        String selectedDestination = getIntent().getStringExtra("selectedDestination");
        boolean isVegChecked = getIntent().getBooleanExtra("isVegChecked", false);
        boolean isNonVegChecked = getIntent().getBooleanExtra("isNonVegChecked", false);

        String mealPreference = "";
        if (isVegChecked) {
            mealPreference = "Vegetarian";
        } else if (isNonVegChecked) {
            mealPreference = "Non-Vegetarian";
        } else {
            mealPreference = "No Preference";
        }

        String displayText = "Berth Choice: " + selectedBerthChoice + "\n" +
                "Destination City: " + selectedDestination + "\n" +
                "Meal Preference: " + mealPreference;

        textViewDisplay.setText(displayText);
    }
}
