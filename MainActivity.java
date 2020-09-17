package com.pandopia.assignment2;


import android.icu.lang.UCharacter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonAdd, buttonSub, buttonMult, buttonDiv, buttonEqls, buttonDel,
            buttonAC, buttonSqrt, buttonPerc, buttonPI, buttonSquare,
            buttonDot, buttonAns;

    private TextView textIn, textOut;

    public double answer;
    private String output = new String();

    boolean firstNumber = false;
    boolean firstUse = true;
    boolean secondOperation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "0");
                firstNumber = true;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "1");
                firstNumber = true;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "2");
                firstNumber = true;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "3");
                firstNumber = true;
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "4");
                firstNumber = true;
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "5");
                firstNumber = true;
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "6");
                firstNumber = true;
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "7");
                firstNumber = true;
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "8");
                firstNumber = true;
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "9");
                firstNumber = true;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + ".");
                firstNumber = true;
            }
        });

        buttonPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "\u03C0");
                firstNumber = true;
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!secondOperation) {
                    if (firstNumber == true) {
                        textIn.setText(textIn.getText().toString() + " x ");
                    } else {
                        textIn.setText("Ans x ");
                    }
                    secondOperation = true;
                }
                else{
                    calculator(textIn.getText().toString());
                    output = formatOutput(output);
                    textIn.setText(output + " x ");
                    firstNumber = false;
                    firstUse = false;
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!secondOperation) {
                    if (firstNumber == true) {
                        textIn.setText(textIn.getText().toString() + " / ");
                    } else {
                        textIn.setText("Ans / ");
                    }
                    secondOperation = true;
                }
                else{
                    calculator(textIn.getText().toString());
                    output = formatOutput(output);
                    textIn.setText(output + " / ");
                    firstNumber = false;
                    firstUse = false;
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNumber == true) {
                    textIn.setText(textIn.getText().toString() + " - ");
                }
                else{
                    textIn.setText("Ans - ");
                }

            }

        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstNumber == true) {
                    textIn.setText(textIn.getText().toString() + " + ");
                }
                else{
                    textIn.setText("Ans + ");
                }

            }
        });


        buttonPerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
                        String temp = textIn.getText().toString();
                        textIn.setText(percentage(temp));
                    }
                    catch (Exception e){
                        textOut.setText("Error");
                    }
                }
        });

        buttonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String temp = textIn.getText().toString();
                    textIn.setText(square(temp));
                }
                catch (Exception e){
                    textOut.setText("Error");
                }
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String temp = textIn.getText().toString();
                    textIn.setText(sqrt(temp));
                }
                catch (Exception e){
                    textOut.setText("Error");
                }
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText("");
                textOut.setText("0");
                firstNumber = false;
            }
        });

        buttonAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.setText(textIn.getText().toString() + "Ans");
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = textIn.getText().toString();
                textIn.setText(delete(temp));
            }
        });

        buttonEqls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculator(textIn.getText().toString());
                    answer = Double.parseDouble(output);
                    textIn.setText("");
                    output = formatOutput(output);
                    textOut.setText(output);
                    firstNumber = false;
                    firstUse = false;
                    secondOperation = false;
                }
                catch (Exception e){
                    textOut.setText("Error");
                    textIn.setText("");
                }
            }
        });

    }


    private void setupUIViews() {
        button0 = (Button) findViewById(R.id.but_zero);
        button1 = (Button) findViewById(R.id.but_one);
        button2 = (Button) findViewById(R.id.but_two);
        button3 = (Button) findViewById(R.id.but_three);
        button4 = (Button) findViewById(R.id.but_four);
        button5 = (Button) findViewById(R.id.but_five);
        button6 = (Button) findViewById(R.id.but_six);
        button7 = (Button) findViewById(R.id.but_seven);
        button8 = (Button) findViewById(R.id.but_eight);
        button9 = (Button) findViewById(R.id.but_nine);
        buttonAC = (Button) findViewById(R.id.AC);
        buttonAdd = (Button) findViewById(R.id.addition);
        buttonSub = (Button) findViewById(R.id.subtraction);
        buttonMult = (Button) findViewById(R.id.multiplication);
        buttonDiv = (Button) findViewById(R.id.division);
        buttonEqls = (Button) findViewById(R.id.equals);
        buttonDel = (Button) findViewById(R.id.delete);
        buttonSqrt = (Button) findViewById(R.id.sqrt);
        buttonPerc = (Button) findViewById(R.id.percentage);
        buttonPI = (Button) findViewById(R.id.pi);
        buttonAns = (Button) findViewById(R.id.answer);
        buttonDot = (Button) findViewById(R.id.dot);
        buttonSquare = (Button) findViewById(R.id.square);
        textIn = (TextView) findViewById(R.id.input);
        textOut = (TextView) findViewById(R.id.output);

    }


    private String formatOutput (String s){

        Double d = Double.parseDouble(s);
        DecimalFormat format = new DecimalFormat("#.###########");
        return format.format(d);

    }

    private String percentage (String s){
        double numToConvert;

        if(s.equals("")){
            numToConvert = answer;
            numToConvert = Math.sqrt(numToConvert);
            return Double.toString(numToConvert);
        }
        else {

            String[] tokens = s.split(" ");
            StringBuffer temp = new StringBuffer();

            if (tokens[(tokens.length) - 1].contains("Ans")) {
                numToConvert = answer;
            } else {
                numToConvert = Double.parseDouble(tokens[(tokens.length) - 1]);
            }
            numToConvert = numToConvert / 100;
            tokens[(tokens.length) - 1] = Double.toString(numToConvert);
            for (int i = 0; i < tokens.length; i++) {
                temp.append(tokens[i]);
                temp.append(" ");
            }
            return temp.toString();
        }
    }

    private String square (String s){

        double numToSquare;

        if(s.equals("")) {
            numToSquare = answer;
            numToSquare = numToSquare * numToSquare;
            return Double.toString(numToSquare);
        }
        else if (s.equals("\u03C0")){
                numToSquare = 3.14159265359;
                numToSquare = numToSquare * numToSquare;
                return Double.toString(numToSquare);
        }
        else {
            String[] tokens = s.split(" ");
            StringBuffer temp = new StringBuffer();

            if (tokens[(tokens.length) - 1].contains("Ans")) {
                numToSquare = answer;
            }
            else if (tokens[(tokens.length) - 1].contains("\u03C0")) {
                numToSquare = 3.14159265359;
            }
            else {
                numToSquare = Double.parseDouble(tokens[(tokens.length) - 1]);
            }
            numToSquare = numToSquare * numToSquare;
            tokens[(tokens.length) - 1] = Double.toString(numToSquare);
            for (int i = 0; i < tokens.length; i++) {
                temp.append(tokens[i]);
                temp.append(" ");
            }
            return temp.toString();
        }
    }

    private String sqrt (String s){
        double numToSqrt;

        if(s.equals("")){
            numToSqrt = answer;
            numToSqrt = Math.sqrt(numToSqrt);
            return Double.toString(numToSqrt);
        }
        else if (s.equals("\u03C0")){
            numToSqrt = 3.14159265359;
            numToSqrt = Math.sqrt(numToSqrt);
            return Double.toString(numToSqrt);
        }
            else {
            String[] tokens = s.split(" ");
            StringBuffer temp = new StringBuffer();

            if (tokens[(tokens.length) - 1].contains("Ans")) {
                numToSqrt = answer;
            }
            else if (tokens[(tokens.length) - 1].contains("\u03C0")) {
                numToSqrt = 3.14159265359;
            }
            else {
                numToSqrt = Double.parseDouble(tokens[(tokens.length) - 1]);
            }
            numToSqrt = Math.sqrt(numToSqrt);

            tokens[(tokens.length) - 1] = Double.toString(numToSqrt);
            for (int i = 0; i < tokens.length; i++) {
                temp.append(tokens[i]);
                temp.append(" ");
            }
            return temp.toString();
        }
    }

    private String delete (String s){
        String[]tokens = s.split("");
        StringBuffer temp = new StringBuffer();
        if(tokens[(tokens.length)-1].contains("s") || tokens[(tokens.length)-1].contains(" ")) {
            for (int i = 0; i < tokens.length - 3; i++) {
                temp.append(tokens[i]);
            }
        }
        else {
            for (int i = 0; i < tokens.length - 1; i++) {
                temp.append(tokens[i]);
            }
        }
        return temp.toString();
    }


    private void calculator(String s) {

        double result = 0;
        double[] nums = new double[20];


        String[] tokens = s.split("\\s+");

        if (isNumeric(s)) {
            result = Double.parseDouble(s);
        } else if (s.equals("Ans")) {
            result = answer;
        } else if (s.equals("\u03C0")) {
            result = 3.14159265359;
        } else{
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].contains("Ans")) {
                    tokens[i] = Double.toString(answer);
                } else if (tokens[i].contains("\u03C0")) {
                    tokens[i] = Double.toString(3.14159265359);
                }
            }

        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                nums[i] = Double.parseDouble(tokens[i]);
            }
        }


        if (s.contains("+")) {
            result = nums[0] + nums[2];
        } else if (s.contains("-")) {
            result = nums[0] - nums[2];
        } else if (s.contains("x")) {
            result = nums[0] * nums[2];
        } else if (s.contains("/")) {
            result = nums[0] / nums[2];
        } else {
            result = Double.parseDouble(s);
        }
    }

        output = Double.toString(result);
    }



    static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}


