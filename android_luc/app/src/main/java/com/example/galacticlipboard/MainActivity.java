package com.example.galacticlipboard;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Socket socket;

    private static String SERVER_ADDRESS = "www.llguy.fun";
    private static int SERVER_PORT = 6499;

    private class ClientThread implements Runnable {
        @Override
        public void run() {
            try {
                InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
                socket = new Socket(serverAddress, SERVER_PORT);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new ClientThread()).start();

        EditText textBox = (EditText)findViewById(R.id.editText);
        textBox.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Button button = (Button)findViewById(R.id.button);
                button.setText(s.toString());

                // Send to the server any changes!
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    out.println(s.toString());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onClickButton(View view) {
        Button button = (Button)view;
        button.setClickable(false);
        button.setText("Not profanity");
        button.setBackgroundColor(Color.RED);

        // Get text from the edit text widget
        EditText editText = (EditText)findViewById(R.id.editText);
        String message = editText.getText().toString();

        // Launch intent
        Intent intent = new Intent(this, RandomActivity.class);
        intent.putExtra("TheMessage", message);
        startActivity(intent);
    }

    public void onClickClear(View view) {
        ((EditText)findViewById(R.id.editText)).setText("");
    }
}
