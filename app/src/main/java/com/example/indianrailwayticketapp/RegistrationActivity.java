package com.example.indianrailwayticketapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner spinnerBerthChoice;
    private RadioGroup radioGroupDestination;
    private CheckBox checkBoxVeg, checkBoxNonVeg;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        spinnerBerthChoice = findViewById(R.id.spinnerBerthChoice);
        radioGroupDestination = findViewById(R.id.radioGroupDestination);
        checkBoxVeg = findViewById(R.id.checkBoxVeg);
        checkBoxNonVeg = findViewById(R.id.checkBoxNonVeg);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populate the spinner with berth choices
        ArrayAdapter<CharSequence> berthAdapter = ArrayAdapter.createFromResource(this,
                R.array.berth_choices_array, android.R.layout.simple_spinner_item);
        berthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBerthChoice.setAdapter(berthAdapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedBerthChoice = spinnerBerthChoice.getSelectedItem().toString();
                int selectedDestinationId = radioGroupDestination.getCheckedRadioButtonId();
                RadioButton selectedDestination = findViewById(selectedDestinationId);
                boolean isVegChecked = checkBoxVeg.isChecked();
                boolean isNonVegChecked = checkBoxNonVeg.isChecked();

                Intent intent = new Intent(RegistrationActivity.this, DisplayActivity.class);
                intent.putExtra("selectedBerthChoice", selectedBerthChoice);
                intent.putExtra("selectedDestination", selectedDestination.getText().toString());
                intent.putExtra("isVegChecked", isVegChecked);
                intent.putExtra("isNonVegChecked", isNonVegChecked);
                startActivity(intent);
            }
        });
    }
}
