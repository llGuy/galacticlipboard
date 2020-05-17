package com.example.galacticlipboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoginAttempt(View view) {
        Button button = (Button)view;
        button.setClickable(true);
        button.setBackgroundColor(Color.GREEN);

    }
}