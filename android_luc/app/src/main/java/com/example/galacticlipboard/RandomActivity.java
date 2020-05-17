package com.example.galacticlipboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Intent intent = getIntent();
        String message = intent.getStringExtra("TheMessage");

        View view = findViewById(R.id.random_text_view);
        TextView textView = (TextView)view;
        textView.setText(message);
    }
}
