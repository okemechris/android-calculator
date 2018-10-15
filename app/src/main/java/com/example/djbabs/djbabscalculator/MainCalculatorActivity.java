package com.example.djbabs.djbabscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class MainCalculatorActivity extends AppCompatActivity {

    public boolean equaltoclick = false;
    public boolean percentclick = false;
    public boolean plusclick = false;
    public boolean divisionclick = false;
    public boolean minusclick = false;
    public boolean multclick = false;
    public boolean deletepressed = false;
    public  boolean squareClick = false;
    public  boolean numberPressed = false;
    Drawer drawer;
    double calc = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        drawer();
        Button square =(Button)findViewById(R.id.btn_square);
        Button raiseToPower =(Button)findViewById(R.id.btn_raiseToPower);
        square.setText(Html.fromHtml("X<sup><small>2</small></sup>"));
        raiseToPower.setText(Html.fromHtml("X<sup><small>n</small></sup>"));

    }

    ArrayList<String> arraylist = new ArrayList<String>();
    String string = "";
    String string1 = "";


    public void multplication(View view) {

        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);

        if (!maincalculator.getText().toString().isEmpty()) {
            int lastindex = arraylist.size()-1;
                if (!arraylist.get(lastindex).contains("-") && !arraylist.get(lastindex).contains("+") && !arraylist.get(lastindex).contains("/") && !arraylist.get(lastindex).contains("×") && !arraylist.get(lastindex).contains("^")) {
                    if (!multclick) {
                        minusclick = true;
                        divisionclick = true;
                        multclick = true;
                        plusclick = true;
                        squareClick = true;
                        percentclick = true;
                        numberPressed = false;
                        Button button = (Button) view;
                        string = (String) button.getText().toString();

//                        arraylist.add(string);
                        arraylist.add(string);
                        string1 = "";
                        //maincalculator.setText(arraylist.toString());
                        if (equaltoclick) {
                            maincalculator.setText( Double.toString( calc) + string);
                            equaltoclick=false;
                        }else{
                            maincalculator.setText(maincalculator.getText().toString() + string);
                            equaltoclick = false;
                        }
                    }
                }
            }

    }

    public void addition(View view) {
        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        int lastindex = arraylist.size() - 1;
        if (!maincalculator.getText().toString().isEmpty()) {
                if (!arraylist.get(lastindex).contains("-") && !arraylist.get(lastindex).contains("+") && !arraylist.get(lastindex).contains("/") && !arraylist.get(lastindex).contains("×") && !arraylist.get(lastindex).contains("^")) {
                    if (!plusclick) {

                        minusclick = true;
                        divisionclick = true;
                        multclick = true;
                        percentclick = true;
                        plusclick = true;
                        squareClick = true;
                        numberPressed = false;
                        Button button = (Button) view;
                        string = (String) button.getText().toString();
                        Button delete = (Button) findViewById(R.id.delete);
                        delete.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_backspace_black_24dp,0);
//                        arraylist.add(string);
                        arraylist.add(string);
                        string1 = "";

                        //maincalculator.setText(arraylist.toString());

                        if (equaltoclick) {
                            maincalculator.setText(Double.toString(calc) + string);
                            equaltoclick = false;
                        } else {
                            maincalculator.setText(maincalculator.getText().toString() + string);
                            equaltoclick = false;
                        }
                    }
                }
            }

    }

    public void substraction(View view) {
        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        int lastindex = arraylist.size() - 1;
          if (!minusclick) {
                    minusclick = true;
                    divisionclick = false;
                    multclick = false;
                    plusclick = false;
                    squareClick = false;
                    percentclick = false;
                    numberPressed = false;
                    Button button = (Button) view;
                    string = (String) button.getText().toString();
                    Button delete = (Button) findViewById(R.id.delete);
                    delete.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_backspace_black_24dp,0);
                    if (string.contains("-") && arraylist.size() == 0) {


                        string1 = string1 + string;


                    } else {
//                        arraylist.add(string);
                        arraylist.add(string);
                        string1 = "";
                    }
                    //maincalculator.setText(arraylist.toString());
                    if (equaltoclick) {
                        maincalculator.setText(Double.toString(calc) + string);
                        equaltoclick = false;
                    } else {
                        maincalculator.setText(maincalculator.getText().toString() + string);
                        equaltoclick = false;
                    }

        }
        }


    public void divide(View view) {

        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        int lastindex = arraylist.size() - 1;
        if (!maincalculator.getText().toString().isEmpty()) {
            if (!arraylist.get(lastindex).contains("-") && !arraylist.get(lastindex).contains("+") && !arraylist.get(lastindex).contains("/") && !arraylist.get(lastindex).contains("×") && !arraylist.get(lastindex).contains("^")) {
                if (!divisionclick) {
                    minusclick = true;
                    divisionclick = true;
                    multclick = true;
                    plusclick = true;
                    percentclick = true;
                    squareClick =true;
                    numberPressed = false;
                    Button button = (Button) view;
                    string = (String)button.getText().toString();
                    Button delete = (Button) findViewById(R.id.delete);
                    delete.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_backspace_black_24dp,0);
                    String stringToShow = "/";
//                    arraylist.add(string);
                    arraylist.add(stringToShow);
                    string1 = "";

                    //maincalculator.setText(arraylist.toString());

                    if (equaltoclick) {
                        maincalculator.setText(Double.toString(calc) + string);
                        equaltoclick = false;
                    } else {
                        maincalculator.setText(maincalculator.getText().toString() + string);
                        equaltoclick = false;
                    }
                }
            }
        }
    }

    public void raiseToPower(View view) {

        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        int lastindex = arraylist.size() - 1;
        if (!maincalculator.getText().toString().isEmpty()) {
            if (!arraylist.get(lastindex).contains("-") && !arraylist.get(lastindex).contains("+") && !arraylist.get(lastindex).contains("/") && !arraylist.get(lastindex).contains("×") && !arraylist.get(lastindex).contains("^")) {
                if (!divisionclick) {
                    minusclick = true;
                    divisionclick = true;
                    multclick = true;
                    plusclick = true;
                    squareClick = true;
                    percentclick = true;
                    numberPressed = false;
                    Button button = (Button) view;
                    string = "^";
//                    arraylist.add(string);
                    arraylist.add(string);
                    string1 = "";

                    //maincalculator.setText(arraylist.toString());

                    if (equaltoclick) {
                        maincalculator.setText(Double.toString(calc) + string);
                        equaltoclick = false;
                    } else {
                        maincalculator.setText(maincalculator.getText().toString() + string);
                        equaltoclick = false;
                    }
                }
            }
        }
    }



    public void onClick1(View view) {
        multclick = false;
        divisionclick = false;
        minusclick = false;
        plusclick = false;
        squareClick = false;
        percentclick = false;
        TextView hiddencalculator = (TextView) findViewById(R.id.actualcalculator);
        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        Button button = (Button) view;
        string = (String) button.getText().toString();

        string1 = string1 + string;
        if (arraylist.size() > 0) {
            if (deletepressed == false && !arraylist.get(arraylist.size() - 1).contains("-") && !arraylist.get(arraylist.size() - 1).contains("+") && !arraylist.get(arraylist.size() - 1).contains("/") && !arraylist.get(arraylist.size() - 1).contains("×") && !arraylist.get(arraylist.size() - 1).contains("^")) {
                arraylist.remove((arraylist.size() - 1));

            } else {
                if (!arraylist.get(arraylist.size() - 1).contains("-") && !arraylist.get(arraylist.size() - 1).contains("+") && !arraylist.get(arraylist.size() - 1).contains("/") && !arraylist.get(arraylist.size() - 1).contains("×") && !arraylist.get(arraylist.size() - 1).contains("^")) {
                    string1 = arraylist.get(arraylist.size() - 1).toString() + string;
                    arraylist.remove((arraylist.size() - 1));
                    deletepressed = false;
                }else{
                    deletepressed = false;
                }
            }
        }
        arraylist.add(string1);
        maincalculator.setText(maincalculator.getText().toString() + string);

        Toast.makeText(getBaseContext(), "arraylist:" + arraylist, Toast.LENGTH_SHORT).show();

        //maincalculator.setText(arraylist.toString());
        if (equaltoclick == true) {
            maincalculator.setText(string);
            string1 = string;
            //string = string;
            hiddencalculator.setText("0");
            Button delete = (Button) findViewById(R.id.delete);
            delete.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_backspace_black_24dp,0);
            arraylist.clear();
            arraylist.add(string);
            equaltoclick = false;
            deletepressed = false;
        }
    }

    public void point(View view) {
        multclick = false;
        divisionclick = false;
        minusclick = false;
        plusclick = false;
        percentclick = false;
        squareClick = false;
        TextView hiddencalculator = (TextView) findViewById(R.id.actualcalculator);
        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        Button button = (Button) view;
        string = (String) button.getText().toString();
        if (!string1.contains(".")) {
            string1 = string1 + string;
            if (arraylist.size() > 0) {
                if (deletepressed == false && !arraylist.get(arraylist.size() - 1).contains("-") && !arraylist.get(arraylist.size() - 1).contains("+") && !arraylist.get(arraylist.size() - 1).contains("/") && !arraylist.get(arraylist.size() - 1).contains("×") && !arraylist.get(arraylist.size() - 1).contains("^")) {
                    arraylist.remove((arraylist.size() - 1));

                } else {
                    if (!arraylist.get(arraylist.size() - 1).contains("-") && !arraylist.get(arraylist.size() - 1).contains("+") && !arraylist.get(arraylist.size() - 1).contains("/") && !arraylist.get(arraylist.size() - 1).contains("×") && !arraylist.get(arraylist.size() - 1).contains("^")) {
                        string1 = arraylist.get(arraylist.size() - 1).toString() + string;
                        arraylist.remove((arraylist.size() - 1));
                        deletepressed = false;
                    } else {
                        deletepressed = false;
                    }
                }
            }
            arraylist.add(string1);
            maincalculator.setText(maincalculator.getText().toString() + string);

            Toast.makeText(getBaseContext(), "arraylist:" + arraylist, Toast.LENGTH_SHORT).show();

            //maincalculator.setText(arraylist.toString());
            if (equaltoclick == true) {
                maincalculator.setText(string);
                string1 = string;
                //string = string;
                hiddencalculator.setText("0");
                Button delete = (Button) findViewById(R.id.delete);
                delete.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_backspace_black_24dp,0);
                arraylist.clear();
                arraylist.add(string);
                equaltoclick = false;
                deletepressed = false;
            }
        }
    }

    public void onClick(View view) {
        TextView hiddencalculator = (TextView) findViewById(R.id.actualcalculator);
        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        int lastindex = arraylist.size() - 1;
        if (!maincalculator.getText().toString().isEmpty()) {
            if (arraylist.size() > 1) {
                if (!arraylist.get(lastindex).contains("-") && !arraylist.get(lastindex).contains("+") && !arraylist.get(lastindex).contains("/") && !arraylist.get(lastindex).contains("×") && !arraylist.get(lastindex).contains("^")) {
                    equaltoclick = true;
                    Button clear = (Button) findViewById(R.id.delete);
                    clear.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_clear_white_24dp,0);
                    int c = arraylist.size();
                    //eg: array(2,+,3,*,4,-,3) size = 7, so(2,+,3,*,4,-,3)
                    while (c != 1) {
                        if (c > 3) {
                            if (arraylist.get(3).contains("×") || arraylist.get(3).contains("/") || arraylist.get(3).contains("^")) {
                                if (arraylist.get(3).contains("×")) {
                                    calc = Double.parseDouble(arraylist.get(2)) * Double.parseDouble(arraylist.get(4));
                                }
                                if (arraylist.get(3).contains("/")) {
                                    calc = Double.parseDouble(arraylist.get(2)) / Double.parseDouble(arraylist.get(4));
                                }
                                if (arraylist.get(3).contains("^")) {
                                    calc = Math.pow(Double.parseDouble(arraylist.get(2)), Double.parseDouble(arraylist.get(4)));
                                }
                                //calc=12 ; array= (2,+,3,*,4,-,3)
                                arraylist.remove(2);//(2,+,*,4,-,3)
                                arraylist.remove(2);//(2,+,4,-,3)
                                arraylist.remove(2);//(2,+,-,3)
                                arraylist.add(2, Double.toString(calc));//(2,+,12,-,3)
                                c = arraylist.size();//size 5
                            } else {
                                //(2,+,12,-,3)

                                if (arraylist.get(1).contains("+")) {
                                    calc = Double.parseDouble(arraylist.get(0)) + Double.parseDouble(arraylist.get(2));
                                }
                                if (arraylist.get(1).contains("-")) {
                                    calc = Double.parseDouble(arraylist.get(0)) - Double.parseDouble(arraylist.get(2));
                                }
                                if (arraylist.get(1).contains("×")) {
                                    calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(2));
                                }
                                if (arraylist.get(1).contains("/")) {
                                    calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(arraylist.get(2));
                                }
                                if (arraylist.get(1).contains("^")) {
                                    calc = Math.pow(Double.parseDouble(arraylist.get(0)), Double.parseDouble(arraylist.get(2)));
                                }
                                // calc=14
                                arraylist.remove(0);//(+,12,-,3)
                                arraylist.remove(0);//(12,-,3)
                                arraylist.remove(0);//(-,3)
                                arraylist.add(0, Double.toString(calc));//(14-,3)
                                c = arraylist.size();//size=3
                            }
                        }
                        //size<=3
                        else {
                            if (arraylist.get(1).contains("+")) {
                                calc = Double.parseDouble(arraylist.get(0)) + Double.parseDouble(arraylist.get(2));
                            }
                            if (arraylist.get(1).contains("-")) {
                                calc = Double.parseDouble(arraylist.get(0)) - Double.parseDouble(arraylist.get(2));
                            }
                            if (arraylist.get(1).contains("×")) {
                                calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(2));
                            }
                            if (arraylist.get(1).contains("/")) {
                                calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(arraylist.get(2));
                            }
                            if (arraylist.get(1).contains("^")) {
                                calc = Math.pow(Double.parseDouble(arraylist.get(0)), Double.parseDouble(arraylist.get(2)));
                            }
                            //calc=9
                            arraylist.remove(0);//(-,3)
                            arraylist.remove(0);//(3)
                            arraylist.remove(0);//()
                            arraylist.add(0, Double.toString(calc));//(11)
                            c = arraylist.size();//size=1 since size is 1 loops ends here
                        }

                    }
                    hiddencalculator.setText(Double.toString(calc));

                }
            }
        }
    }


    public void percentage(View view) {

        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        if (!maincalculator.getText().toString().isEmpty()) {
            if (!percentclick) {
                Button button = (Button) view;
                string = (String) button.getText().toString();
                arraylist.add(string);
                arraylist.add(string);
                string1 = "";
                percentclick = true;
                if (squareClick) {
                    maincalculator.setText(Double.toString(calc) + string);
                    squareClick = false;
                } else {
                    maincalculator.setText(maincalculator.getText().toString() + string);
                    squareClick = false;
                }
                doPercent();


            }

        }


    }

    public void square(View view) {

        TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
        if (!maincalculator.getText().toString().isEmpty()) {

            if (!squareClick) {
                Button button = (Button) view;
                string = "s";
                arraylist.add(string);
                arraylist.add(string);
                string1 = "";
                squareClick = true;
                if (percentclick) {
                    maincalculator.setText(Html.fromHtml(Double.toString(calc)+"<sup><small>2</small></sup>"));
                    percentclick = false;
                } else {
                    maincalculator.setText(Html.fromHtml(maincalculator.getText().toString()+"<sup><small>2</small></sup>"));
                    percentclick = false;
                }
                doSquare();



            }

        }


    }

    private void doSquare() {

        String per = "100";
        TextView hiddencalculator = (TextView) findViewById(R.id.actualcalculator);
        int lastindex = arraylist.size() - 1;

        Button clear = (Button) findViewById(R.id.delete);
        clear.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_clear_white_24dp,0);
        equaltoclick = true;
        int c = arraylist.size();
        //eg: array(2,+,3,*,4,-,3) size = 7, so(2,+,3,*,4,-,3)
        while (c != 1) {
            if (c > 3) {
                if (arraylist.get(3).contains("×") || arraylist.get(3).contains("/")|| arraylist.get(3).contains("%")||arraylist.get(3).contains("s")) {
                    if (arraylist.get(3).contains("×")) {
                        calc = Double.parseDouble(arraylist.get(2)) * Double.parseDouble(arraylist.get(4));
                    }
                    if (arraylist.get(3).contains("/")) {
                        calc = Double.parseDouble(arraylist.get(2)) / Double.parseDouble(arraylist.get(4));
                    }
                    if (arraylist.get(3).contains("%") ) {
                        calc = Double.parseDouble(arraylist.get(2)) / Double.parseDouble(per);
                    }
                    if (arraylist.get(3).contains("s") ) {
                        calc = Double.parseDouble(arraylist.get(2)) * Double.parseDouble(arraylist.get(2));
                    }
                    //calc=12 ; array= (2,+,3,*,4,-,3)
                    arraylist.remove(2);//(2,+,*,4,-,3)
                    arraylist.remove(2);//(2,+,4,-,3)
                    arraylist.remove(2);//(2,+,-,3)
                    arraylist.add(2, Double.toString(calc));//(2,+,12,-,3)
                    c = arraylist.size();//size 5
                } else {
                    //(2,+,12,-,3)

                    if (arraylist.get(1).contains("+")) {
                        calc = Double.parseDouble(arraylist.get(0)) + Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("-")) {
                        calc = Double.parseDouble(arraylist.get(0)) - Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("×")) {
                        calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("/")) {
                        calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("%")) {
                        calc = Double.parseDouble(arraylist.get(0)) /Double.parseDouble(per);
                    }
                    if (arraylist.get(1).contains("s")) {
                        calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(0));
                    }
                    // calc=14
                    arraylist.remove(0);//(+,12,-,3)
                    arraylist.remove(0);//(12,-,3)
                    arraylist.remove(0);//(-,3)
                    arraylist.add(0, Double.toString(calc));//(14-,3)
                    c = arraylist.size();//size=3
                }
            }
            //size<=3
            else {
                if (arraylist.get(1).contains("+")) {
                    calc = Double.parseDouble(arraylist.get(0)) + Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("-")) {
                    calc = Double.parseDouble(arraylist.get(0)) - Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("×")) {
                    calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("/")) {
                    calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("%")) {
                    calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(per);
                }

                if (arraylist.get(1).contains(Html.fromHtml("s"))) {
                    calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(0));
                }
                //calc=9
                arraylist.remove(0);//(-,3)
                arraylist.remove(0);//(3)
                arraylist.remove(0);//()
                arraylist.add(0, Double.toString(calc));//(11)
                c = arraylist.size();//size=1 since size is 1 loops ends here
            }

        }
        hiddencalculator.setText(Double.toString(calc));


    }

    public void doPercent() {
        String per = "100";
        TextView hiddencalculator = (TextView) findViewById(R.id.actualcalculator);
        int lastindex = arraylist.size() - 1;

            Button clear = (Button) findViewById(R.id.delete);
            clear.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_clear_white_24dp,0);
            int c = arraylist.size();
        equaltoclick = true;
            //eg: array(2,+,3,*,4,-,3) size = 7, so(2,+,3,*,4,-,3)
            while (c != 1) {
                if (c > 3) {
                if (arraylist.get(3).contains("×") || arraylist.get(3).contains("/")|| arraylist.get(3).contains("%") ) {
                    if (arraylist.get(3).contains("×")) {
                        calc = Double.parseDouble(arraylist.get(2)) * Double.parseDouble(arraylist.get(4));
                    }
                    if (arraylist.get(3).contains("/")) {
                        calc = Double.parseDouble(arraylist.get(2)) / Double.parseDouble(arraylist.get(4));
                    }
                    if (arraylist.get(3).contains("%") ) {
                        calc = Double.parseDouble(arraylist.get(2)) / Double.parseDouble(per);
                    }
                    //calc=12 ; array= (2,+,3,*,4,-,3)
                    arraylist.remove(2);//(2,+,*,4,-,3)
                    arraylist.remove(2);//(2,+,4,-,3)
                    arraylist.remove(2);//(2,+,-,3)
                    arraylist.add(2, Double.toString(calc));//(2,+,12,-,3)
                    c = arraylist.size();//size 5
                } else {
                    //(2,+,12,-,3)

                    if (arraylist.get(1).contains("+")) {
                        calc = Double.parseDouble(arraylist.get(0)) + Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("-")) {
                        calc = Double.parseDouble(arraylist.get(0)) - Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("×")) {
                        calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("/")) {
                        calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(arraylist.get(2));
                    }
                    if (arraylist.get(1).contains("%")) {
                        calc = Double.parseDouble(arraylist.get(0)) /Double.parseDouble(per);
                    }
                    // calc=14
                    arraylist.remove(0);//(+,12,-,3)
                    arraylist.remove(0);//(12,-,3)
                    arraylist.remove(0);//(-,3)
                    arraylist.add(0, Double.toString(calc));//(14-,3)
                    c = arraylist.size();//size=3
                }
            }
            //size<=3
            else {
                if (arraylist.get(1).contains("+")) {
                    calc = Double.parseDouble(arraylist.get(0)) + Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("-")) {
                    calc = Double.parseDouble(arraylist.get(0)) - Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("×")) {
                    calc = Double.parseDouble(arraylist.get(0)) * Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("/")) {
                    calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(arraylist.get(2));
                }
                if (arraylist.get(1).contains("%")) {
                    calc = Double.parseDouble(arraylist.get(0)) / Double.parseDouble(per);
                }
                //calc=9
                arraylist.remove(0);//(-,3)
                arraylist.remove(0);//(3)
                arraylist.remove(0);//()
                arraylist.add(0, Double.toString(calc));//(11)
                c = arraylist.size();//size=1 since size is 1 loops ends here
            }

        }
        hiddencalculator.setText(Double.toString(calc));


    }








   public void clear(View view) {
       plusclick=false;
       divisionclick=false;
       minusclick=false;
       squareClick = false;
       multclick=false;
       percentclick=false;
       int c = arraylist.size();
       Button button=(Button)view;
       TextView hiddencalculator = (TextView) findViewById(R.id.actualcalculator);
       TextView maincalculator = (TextView) findViewById(R.id.maincalculator);
       if (equaltoclick) {
           string1 = "";
           string = "";
           maincalculator.setText("");
           hiddencalculator.setText("0");
           arraylist.clear();
           button.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_backspace_black_24dp,0);
           equaltoclick=false;
       }else{

           String s;
               int s1;
               s= maincalculator.getText().toString();
               s1 = maincalculator.getText().toString().length();
           if(!arraylist.isEmpty()) {
               if (c >= 0) {
                   s = s.substring(0, s1 - 1);
                   maincalculator.setText(s);
                   String str = arraylist.get(c - 1);
                   String stry = str.substring(0, str.length() - 1);
                   if (str.length() <= 1) {
                       arraylist.remove(c - 1);
                       deletepressed = true;
                       string1 = "" ;
                       if(arraylist.isEmpty()){
                          deletepressed=false;
                       }


                   } else {
                           arraylist.set(c - 1, stry);
                           string1 = stry;

                   }
                   Toast.makeText(getBaseContext(), "arraylist:" + arraylist, Toast.LENGTH_SHORT).show();

               }
           }



       }

   }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main_calculator, menu);
//        menubuttonstate(menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()){
//
//            case R.id.action_converter:
//                startCurrencyActivity();
//                return  true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//
//    }

    public void menubuttonstate(Menu menu){
        if(menu==null)
            return;
        menu.findItem(R.id.action_standard).setVisible(false);



    }

    public  void startCurrencyActivity(){
        Intent launchCurrencyIntent = new Intent(MainCalculatorActivity.this,GridMenu.class);
        startActivityForResult(launchCurrencyIntent,0);
    }



    public  void drawer(){
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Simple equations");

//create the drawer and remember the `Drawer` result object
        drawer = new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(
                        item1,
                        item2

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        int id = (int)drawerItem.getIdentifier();
                        switch (id) {
                            case 1:
                                return true;
                            case 2:
                                startCurrencyActivity();
                                return true;

                        }
                        return  true;
                    }
                })
                .build();
    }


    public void menu(View view) {

        ImageButton menu = (ImageButton)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer();
            }
        });
    }

}





