package com.abmn.ultracalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Activity activity;
    private FrameLayout rootFL;
    private EditText firstEdt, secondEdt;
    private Button plusBtn, minusBtn, multiplicationBtn, dividedBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        define();
    }
//check
    private void define() {
        activity = this;
        rootFL = findViewById(R.id.rootFL);
        firstEdt = findViewById(R.id.firstEdt);
        secondEdt = findViewById(R.id.secondEdt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        multiplicationBtn = findViewById(R.id.multiplicationBtn);
        dividedBtn = findViewById(R.id.dividedBtn);

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
        int result = Integer.parseInt(first) + Integer.parseInt(second);
        showSnackbar(rootFL, "Addition Result is : " + result);
    }
    private void minusMethode(String first, String second) {
        int result = Integer.parseInt(first) - Integer.parseInt(second);
        showSnackbar(rootFL, "Subtraction Result is : " + result);
    }
    private void multiplicationMethode(String first, String second) {
        int result = Integer.parseInt(first) * Integer.parseInt(second);
        showSnackbar(rootFL, "multiplication Result is : " + result);
    }
    private void dividedMethode(String first, String second) {
        int result = Integer.parseInt(first) / Integer.parseInt(second);
        showSnackbar(rootFL, "multiplication Result is : " + result);
    }
    private void showSnackbar(FrameLayout rootFL, String s) {
        Snackbar.make(rootFL, "Addition Result is : " + s, Snackbar.LENGTH_SHORT).show();
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