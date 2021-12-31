package com.cricket.info;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    {
        unitConvertProcessor = new UnitConvertProcessor();
        adapterFactory = new AdapterFactory();
    }

    UnitConvertProcessor unitConvertProcessor;
    AdapterFactory adapterFactory;

    static boolean flag = false;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner unitFrom=findViewById(R.id.spinnerFrom);
        Spinner unitTo=findViewById(R.id.spinnerTo);
        EditText fromValueEditText = findViewById(R.id.editTextNumber);
        EditText toValueEditText = findViewById(R.id.editTextNumber2);

        Spinner unitTypeSpinner = findViewById(R.id.spinnerUnitType);
        unitTypeSpinner.setAdapter(new ArrayAdapter<Unit>(this, android.R.layout.simple_spinner_item, Unit.values()));
        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = unitTypeSpinner.getSelectedItem().toString();
                toValueEditText.setText(fromValueEditText.getText().toString());
                if(Unit.Length.name().equalsIgnoreCase(selectedItem)) {
                    unitFrom.setAdapter(adapterFactory.getArrayAdapterForLength(context));
                    unitTo.setAdapter(adapterFactory.getArrayAdapterForLength(context));
                }
                else if(Unit.Mass.name().equalsIgnoreCase(selectedItem)) {
                    unitFrom.setAdapter(adapterFactory.getArrayAdapterForMass(context));
                    unitTo.setAdapter(adapterFactory.getArrayAdapterForMass(context));
                }
                else if(Unit.Time.name().equalsIgnoreCase(selectedItem)) {
                    unitFrom.setAdapter(adapterFactory.getArrayAdapterForTime(context));
                    unitTo.setAdapter(adapterFactory.getArrayAdapterForTime(context));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fromValueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(!flag) {
                    flag = true;
                    try {
                        double fromValue = Double.parseDouble(fromValueEditText.getText().toString().equalsIgnoreCase("") ? "0" : fromValueEditText.getText().toString());
                        String fromUnit = unitFrom.getSelectedItem().toString();
                        String toUnit = unitTo.getSelectedItem().toString();
                        double convertedValue = unitConvertProcessor.convert(fromValue, fromUnit, toUnit);
                        int integerPart = (int) convertedValue;
                        if (convertedValue - integerPart == 0)
                            toValueEditText.setText(String.valueOf(integerPart));
                        else
                            toValueEditText.setText(String.valueOf(convertedValue));
                    } catch (Exception ignored){

                    }
                }
                else
                    flag = false;
            }
        });

        toValueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(!flag) {
                    flag = true;
                    try {
                        double fromValue = Double.parseDouble(toValueEditText.getText().toString().equalsIgnoreCase("") ? "0" : toValueEditText.getText().toString());
                        String fromUnit = unitFrom.getSelectedItem().toString();
                        String toUnit = unitTo.getSelectedItem().toString();
                        double convertedValue = unitConvertProcessor.convert(fromValue, toUnit, fromUnit);
                        int integerPart = (int) convertedValue;
                        if (convertedValue - integerPart == 0)
                            fromValueEditText.setText(String.valueOf(integerPart));
                        else
                            fromValueEditText.setText(String.valueOf(convertedValue));
                    } catch (Exception ignored){

                    }
                }
                else
                    flag = false;
            }
        });

        unitFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    double fromValue = Double.parseDouble(toValueEditText.getText().toString().equalsIgnoreCase("") ? "0" : toValueEditText.getText().toString());
                    String fromUnit = unitFrom.getSelectedItem().toString();
                    String toUnit = unitTo.getSelectedItem().toString();
                    double convertedValue = unitConvertProcessor.convert(fromValue, toUnit, fromUnit);
                    int integerPart = (int) convertedValue;
                    if (convertedValue - integerPart == 0)
                        fromValueEditText.setText(String.valueOf(integerPart));
                    else
                        fromValueEditText.setText(String.valueOf(convertedValue));
                } catch (Exception ignored){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        unitTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    double fromValue = Double.parseDouble(fromValueEditText.getText().toString().equalsIgnoreCase("") ? "0" : fromValueEditText.getText().toString());
                    String fromUnit = unitFrom.getSelectedItem().toString();
                    String toUnit = unitTo.getSelectedItem().toString();
                    double convertedValue = unitConvertProcessor.convert(fromValue, fromUnit, toUnit);
                    int integerPart = (int) convertedValue;
                    if (convertedValue - integerPart == 0)
                        toValueEditText.setText(String.valueOf(integerPart));
                    else
                        toValueEditText.setText(String.valueOf(convertedValue));
                } catch (Exception ignored){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}