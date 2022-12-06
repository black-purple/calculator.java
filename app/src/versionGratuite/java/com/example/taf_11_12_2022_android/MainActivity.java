package com.example.taf_11_12_2022_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView operationTV, resTV;
    MaterialButton oneB, twoB, threeB, fourB, fiveB, sixB, sevenB, eightB, nineB, zeroB, dotB;
    MaterialButton plusB, timesB, minusB, equalsB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operationTV = findViewById(R.id.ope);
        resTV = findViewById(R.id.res);
        equalsB = findViewById(R.id.bequals);

        oneB = findViewById(R.id.b1);
        twoB = findViewById(R.id.b2);
        threeB = findViewById(R.id.b3);
        fourB = findViewById(R.id.b4);
        fiveB = findViewById(R.id.b5);
        sixB = findViewById(R.id.b6);
        sevenB = findViewById(R.id.b7);
        eightB = findViewById(R.id.b8);
        nineB = findViewById(R.id.b9);
        zeroB = findViewById(R.id.b0);
        dotB = findViewById(R.id.bdot);

        plusB = findViewById(R.id.plus);
        minusB = findViewById(R.id.minus);
        timesB = findViewById(R.id.times);

        ArrayList<MaterialButton> buttons = new ArrayList<MaterialButton>();
        // Number buttons
        buttons.add(oneB);
        buttons.add(twoB);
        buttons.add(threeB);
        buttons.add(fourB);
        buttons.add(fiveB);
        buttons.add(sixB);
        buttons.add(sevenB);
        buttons.add(eightB);
        buttons.add(nineB);
        buttons.add(zeroB);
        buttons.add(dotB);
        // Functionality buttons
        buttons.add(plusB);
        buttons.add(minusB);
        buttons.add(timesB);
        buttons.add(equalsB);

        for (View btn: buttons) btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton btn = (MaterialButton) view;
        String btnText = btn.getText().toString();
        btnText = btnText.equals("mod") ? "#" : btnText;
        String operationText = operationTV.getText().toString();

        if (!btnText.equals("=") && !btnText.equals("AC")) {
            operationText = operationText.equals("0") ? "" + btnText : operationText + btnText;
            operationTV.setText(operationText);
        } else {
            if (btnText.equals("AC")) {
                operationTV.setText("0");
                resTV.setText("0");
            } else {
                try {
                    Expression e = new Expression(operationText);
                    double result = e.calculate();
                    resTV.setText(String.format("%s", result));
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        }
    }
}