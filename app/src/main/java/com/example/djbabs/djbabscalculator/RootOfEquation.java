package com.example.djbabs.djbabscalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class RootOfEquation extends AppCompatActivity {

    TextView fromFullText, toFullText;
    String fromspinnerItem, toSpinnerItem;
    EditText editText2;
    TextView editText;
    String string = "";
    String string1 = "";
    double convertionRate = 0;
    String con ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_layout);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.massUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        Spinner toSpinner = (Spinner) findViewById(R.id.toSpinner);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);


        fromFullText = (TextView) findViewById(R.id.fromFullText);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               setLabelText(parent.getItemAtPosition(position).toString());
                fromspinnerItem = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),""+fromspinnerItem,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setLabelToText(parent.getItemAtPosition(position).toString());
                toSpinnerItem = parent.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(),""+toSpinnerItem,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        editText2 = (EditText)findViewById(R.id.editTexty);
        editText2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });





    }



    public void onClick1(View view) {
       editText = (EditText) findViewById(R.id.editTexty);
        Button button = (Button) view;
        string = (String) button.getText().toString();

        if( editText2.isFocused()){
            editText2.setText(editText2.getText() + string);
            editText2.setSelection(editText2.getText().length());

            convertion(fromspinnerItem,toSpinnerItem);
            Toast.makeText(getApplicationContext(),""+convertionRate,Toast.LENGTH_LONG).show();
        }

    }
    public  void  setLabelText(String s){
        fromFullText = (TextView) findViewById(R.id.fromFullText);

        switch (s) {

            case "Km":
                fromFullText.setText("Kilometer");
                break;
            case "M":
                fromFullText.setText("Metre");
                break;
            case "Cm":
                fromFullText.setText("Centimeter");
                break;
            case "Micro-m":
                fromFullText.setText("Micrometer");
                break;
            case "Mm":
                fromFullText.setText("Millimeter");
                break;
            case "Inch":
                fromFullText.setText("Inch");
                break;
            case "Foot":
                fromFullText.setText("Foot");
                break;
            case "Yard":
                fromFullText.setText("Yard");
                break;

            case "Mi":
                fromFullText.setText("Mile");
                break;
            case "Nano-m":
                fromFullText.setText("Nanometer");
                break;

            case "Nautical mile":
                fromFullText.setText("Nautical mile");
                break;


        }


    }

    public  void  setLabelToText(String s) {
        toFullText = (TextView) findViewById(R.id.toFullText);
        switch (s) {

            case "Km":
                toFullText.setText("Kilometer");
                break;
            case "M":
                toFullText.setText("Metre");
                break;
            case "Cm":
                toFullText.setText("Centimeter");
                break;
            case "Micro-m":
                toFullText.setText("Micrometer");
                break;
            case "Mm":
                toFullText.setText("Millimeter");
                break;
            case "Inch":
                toFullText.setText("Inch");
                break;
            case "Foot":
                toFullText.setText("Foot");
                break;
            case "Yard":
                toFullText.setText("Yard");
                break;

            case "Mi":
                toFullText.setText("Mile");
                break;
            case "Nano-m":
                toFullText.setText("Nanometer");
                break;

            case "Nautical mile":
                toFullText.setText("Nautical mile");
                break;


        }

    }


    public  void delete(View v){

        editText2 = (EditText)findViewById(R.id.editTexty);

        String s;
        int s1;

        if (editText2.isFocused()){

            s= editText2.getText().toString();
            s1 = editText2.getText().toString().length();

            if (s1 > 1){

                s = s.substring(0, s1 - 1);
                editText2.setText(s);
                editText2.setSelection(editText2.getText().length());
            }else{
                editText2.setText("");
            }
        }


    }

    public void convertion(String s, String si) {


        switch(s){

            case "Km":
                if(si.contains("Km")){
                    convertionRate= 1.0;
                }else if(si.contains("Cm")){
                    convertionRate=100000.0;
                }
                else if(si.contains("Inch")){
                    convertionRate=39370.1;
                }
                else if(si.contains("Foot")){
                    convertionRate=3280.84;
                }
                else if(si.contains("Yard")){
                    convertionRate=1093.61;
                }
                else if(si.contains("M")){
                    convertionRate=1000;
                }
                else if(si.contains("Mi")){
                    convertionRate=0.621371;
                }
                else if(si.contains("Micro-m")){
                    convertionRate=1*Math.exp(9);
                }
                else if(si.contains("Nano-m")){
                    convertionRate=1*Math.exp(12);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=0.539957;
                }
                break;

            case"Inch":

                if(si.contains("Km")){
                    convertionRate= 2.54*Math.exp(-5);
                }else if(si.contains("Cm")){
                    convertionRate=2.54;
                }
                else if(si.contains("Inch")){
                    convertionRate=1;
                }
                else if(si.contains("Foot")){
                    convertionRate=0.0833333;
                }
                else if(si.contains("Yard")){
                    convertionRate=0.0277778;
                }
                else if(si.contains("M")){
                    convertionRate=0.0254;
                }
                else if(si.contains("Mi")){
                    convertionRate=1.5783*Math.exp(-5);
                }
                else if(si.contains("Micro-m")){
                    convertionRate=25400;
                }
                else if(si.contains("Nano-m")){
                    convertionRate=2.54*Math.exp(7);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=1.3715*Math.exp(-5);
                }
                break;

            case"Foot":
                if(si.contains("Km")){
                    convertionRate= 0.0003048;
                }else if(si.contains("Cm")){
                    convertionRate=30.48;
                }
                else if(si.contains("Inch")){
                    convertionRate=12;
                }
                else if(si.contains("Foot")){
                    convertionRate=0.0833333;
                }
                else if(si.contains("Yard")){
                    convertionRate=0.0277778;
                }
                else if(si.contains("M")){
                    convertionRate=0.3048;
                }
                else if(si.contains("Mi")){
                    convertionRate=1.5783*Math.exp(-5);
                }
                else if(si.contains("Micro-m")){
                    convertionRate=25400;
                }
                else if(si.contains("Nano-m")){
                    convertionRate=2.54*Math.exp(7);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=1.3715*Math.exp(-5);
                }
                break;
            case "Yard":
                if(si.contains("Km")){
                    convertionRate= 0.0009144;
                }else if(si.contains("Cm")){
                    convertionRate=91.44;
                }
                else if(si.contains("Inch")){
                    convertionRate=36;
                }
                else if(si.contains("Foot")){
                    convertionRate=3;
                }
                else if(si.contains("Yard")){
                    convertionRate=1;
                }
                else if(si.contains("M")){
                    convertionRate=0.9144;
                }
                else if(si.contains("Mi")){
                    convertionRate=0.000568182;
                }
                else if(si.contains("Micro-m")){
                    convertionRate=914400;
                }
                else if(si.contains("Nano-m")){
                    convertionRate=9.144*Math.exp(8);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=0.000493737;
                }
                break;
            case"M":
                if(si.contains("Km")){
                    convertionRate= 0.001;
                }else if(si.contains("Cm")){
                    convertionRate=100;
                }
                else if(si.contains("Inch")){
                    convertionRate=39.3701;
                }
                else if(si.contains("Foot")){
                    convertionRate=3.28084;
                }
                else if(si.contains("Yard")){
                    convertionRate=1.09361;
                }
                else if(si.contains("M")){
                    convertionRate=1;
                }
                else if(si.contains("Mi")){
                    convertionRate=0.000621371;
                }
                else if(si.contains("Micro-m")){
                    convertionRate=1*Math.exp(6);
                }
                else if(si.contains("Nano-m")){
                    convertionRate=1*Math.exp(9);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=0.000539957;
                }
                break;
            case "cm":
                if(si.contains("Km")){
                    convertionRate= 1*Math.exp(-5);
                }else if(si.contains("Cm")){
                    convertionRate=1;
                }
                else if(si.contains("Inch")){
                    convertionRate=0.393701;
                }
                else if(si.contains("Foot")){
                    convertionRate=0.0328084;
                }
                else if(si.contains("Yard")){
                    convertionRate=0.0109361;
                }
                else if(si.contains("M")){
                    convertionRate=0.01;
                }
                else if(si.contains("Mi")){
                    convertionRate=6.2137*Math.exp(-6);
                }
                else if(si.contains("Micro-m")){
                    convertionRate=1000;
                }
                else if(si.contains("Nano-m")){
                    convertionRate=1*Math.exp(7);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=5.3996*Math.exp(-6);
                }
                break;
            case "Mi":
                if(si.contains("Km")){
                    convertionRate= 1.0;
                }else if(si.contains("Cm")){
                    convertionRate=100000.0;
                }
                else if(si.contains("Inch")){
                    convertionRate=39370.1;
                }
                else if(si.contains("Foot")){
                    convertionRate=3280.84;
                }
                else if(si.contains("Yard")){
                    convertionRate=1093.61;
                }
                else if(si.contains("M")){
                    convertionRate=1000;
                }
                else if(si.contains("Mi")){
                    convertionRate=0.621371;
                }
                else if(si.contains("Micro-m")){
                    convertionRate=1*Math.exp(9);
                }
                else if(si.contains("Nano-m")){
                    convertionRate=1*Math.exp(12);
                }
                else if(si.contains("Nautical mile")){
                    convertionRate=0.539957;
                }
                break;

        }

    }



}
