package com.example.galacticlipboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {
        Button button = (Button)view;
        button.setClickable(false);
        button.setText("Bitch");
        button.setBackgroundColor(Color.RED);

        // Get text from the edit text widget
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();

        // Launch intent
        Intent intent = new Intent(this, RandomActivity.class);
        intent.putExtra("TheMessage", message);
        startActivity(intent);
    }
}
