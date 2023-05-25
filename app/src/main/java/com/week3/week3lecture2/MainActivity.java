package com.week3.week3lecture2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    CheckBox checkBox;

    Spinner spinner;

    Switch aSwitch;

    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButton = findViewById(checkedId);
                String selectedOption = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, "You selected "+selectedOption, Toast.LENGTH_LONG).show();

            }
        });


        checkBox = findViewById(R.id.check_box);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = checkBox.isChecked();
                String message = isChecked ? "CheckBox Checked" : "CheckBox Unchecked";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });


        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_data, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_layout);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selecteValue = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "You selected "+selecteValue+position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        aSwitch = findViewById(R.id.switch_btn);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this, "You turned on", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this, "You turned off", Toast.LENGTH_LONG).show();

            }
        });


        toggleButton = findViewById(R.id.toggle_button);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    Toast.makeText(MainActivity.this, "You toggled on", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this, "You toggled off", Toast.LENGTH_LONG).show();


            }
        });


    }
}