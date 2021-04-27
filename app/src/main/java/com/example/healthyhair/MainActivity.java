package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccount = findViewById(R.id.inCreateAccount);

        createAccount.setOnClickListener(view -> {
            Intent intent
                    = new Intent(MainActivity.this,
                    SignUpActivity.class);
            startActivity(intent);
        });
    }
}