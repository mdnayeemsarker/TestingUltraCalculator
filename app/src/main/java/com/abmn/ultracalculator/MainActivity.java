package com.abmn.ultracalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Activity activity;
    private FrameLayout rootFL;
    private EditText firstEdt, secondEdt;
    private Button plusBtn, minusBtn, multiplicationBtn, dividedBtn;

    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        define();
    }
    private void define() {
        activity = this;
        rootFL = findViewById(R.id.rootFL);
        firstEdt = findViewById(R.id.firstEdt);
        secondEdt = findViewById(R.id.secondEdt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiplicationBtn = findViewById(R.id.multiplicationBtn);
        dividedBtn = findViewById(R.id.dividedBtn);
        calculator = new Calculator();
        work();
    }

    private void work() {
        plusBtn.setOnClickListener(v->{
            hideKeyboard(activity, v);
            String first = firstEdt.getText().toString();
            String second = secondEdt.getText().toString();
            plusMethode(first, second);
        });
        minusBtn.setOnClickListener(v->{
            hideKeyboard(activity, v);
            String first = firstEdt.getText().toString();
            String second = secondEdt.getText().toString();
            minusMethode(first, second);
        });
        multiplicationBtn.setOnClickListener(v->{
            hideKeyboard(activity, v);
            String first = firstEdt.getText().toString();
            String second = secondEdt.getText().toString();
            multiplicationMethode(first, second);
        });
        dividedBtn.setOnClickListener(v->{
            hideKeyboard(activity, v);
            String first = firstEdt.getText().toString();
            String second = secondEdt.getText().toString();
            dividedMethode(first, second);
        });
    }

    private void plusMethode(String first, String second) {
//        int result = Integer.parseInt(first) + Integer.parseInt(second);
        int result = calculator.plus(Integer.parseInt(first), Integer.parseInt(second));
        calculator.showSnackbar(rootFL, "Addition Result is : " + result);
    }
    private void minusMethode(String first, String second) {
//        int result = Integer.parseInt(first) - Integer.parseInt(second);
        int result = calculator.minus(Integer.parseInt(first), Integer.parseInt(second));
        calculator.showSnackbar(rootFL, "Subtraction Result is : " + result);
    }
    private void multiplicationMethode(String first, String second) {
        int result = calculator.multiple(Integer.parseInt(first), Integer.parseInt(second));
        calculator.showSnackbar(rootFL, "multiplication Result is : " + result);
    }
    private void dividedMethode(String first, String second) {
        int result = calculator.divided(Integer.parseInt(first),Integer.parseInt(second));
        calculator.showSnackbar(rootFL, "multiplication Result is : " + result);
    }
    public static void hideKeyboard(Activity activity, View root) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            inputMethodManager.hideSoftInputFromWindow(root.getApplicationWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}