package com.luizdeveloper.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textField;
    float firstNumber = 0;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (TextView) findViewById(R.id.textViewResult);
        textField.setText("0");
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.clearButton:
                textField.setText("0");
                firstNumber = 0;
                operation = "";
                break;
            case R.id.addButton:
                calcNumbers("+");
                break;
            case R.id.subButton:
                calcNumbers("-");
                break;
            case R.id.multButton:
                calcNumbers("*");
                break;
            case R.id.divButton:
                calcNumbers("/");
                break;
            case R.id.resultButton:
                showResult();
                break;
            default:
                String num;
                num = ((Button) view).getText().toString();
                getKeyboard(num);
                break;
        }
    }

    public void calcNumbers(String operationType) {
        firstNumber = Float.parseFloat(textField.getText().toString());
        operation = operationType;
        textField.setText("0");
    }

    public void getKeyboard(String str) {
        String scrCurrent = textField.getText().toString();
        if(scrCurrent.equals("0")){
            textField.setText(str);
        } else {
            scrCurrent += str;
            textField.setText(scrCurrent);
        }
    }

    public void showResult() {
        float secondNumber = Float.parseFloat(textField.getText().toString());
        float total = 0;
        if (operation.equals("+")) {
            total = secondNumber + firstNumber;
        }
        if (operation.equals("-")) {
            total = firstNumber - secondNumber;
        }
        if (operation.equals("*")) {
            total = firstNumber * secondNumber;
        }
        if (operation.equals("/")) {
            total = firstNumber / secondNumber;
        }
        textField.setText(String.valueOf(total));
    }
}