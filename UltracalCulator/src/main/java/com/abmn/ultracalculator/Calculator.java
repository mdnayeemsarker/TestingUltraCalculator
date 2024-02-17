package com.abmn.ultracalculator;

import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Calculator extends AppCompatActivity {

    public void showSnackbar(FrameLayout rootFL, String s) {
        Snackbar.make(rootFL, s, Snackbar.LENGTH_SHORT).setAction("Ok", v -> {}).show();
    }

    public int plus (int first, int second){
        return first + second;
    }
    public int minus (int first, int second){
        int result;
        if (first > second)
            result = first - second;
        else
            result = second - first;
        return result;
    }
    public int multiple (int first, int second){
        return first * second;
    }
    public int divided (int first, int second){
        int result;
        if (first > second)
            result = first / second;
        else
            result = second / first;
        return result;
    }

}
