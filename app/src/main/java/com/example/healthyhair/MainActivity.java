package com.example.healthyhair;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText tvEmail, tvPassword;
    private TextView createAccount;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        tvEmail = findViewById(R.id.inEmail);
        tvPassword = findViewById(R.id.inPassword);
        btnLogin = findViewById(R.id.btnLogIn);
        createAccount = findViewById(R.id.inCreateAccount);

        btnLogin.setOnClickListener(v -> loginUserAccount());

        createAccount.setOnClickListener(view -> {
            Intent intent
                    = new Intent(MainActivity.this,
                    SignUpActivity.class);
            startActivity(intent);
        });
    }

    private void loginUserAccount() {

        String email, password;
        email = tvEmail.getText().toString();
        password = tvPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),
                                        "Login successful!",
                                        Toast.LENGTH_LONG)
                                        .show();

                                SharedPreferences preferences = getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);

                                if (preferences.getBoolean("PREFERENCES", false)) {

                                    // Here the connectivity between Main and User Interface will be implemented
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);

                                } else {
                                    SharedPreferences pref = getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = pref.edit();
                                    editor.putBoolean("PREFERENCES", true);
                                    editor.commit();

                                    Intent intent = new Intent(MainActivity.this, PorositySurvey.class);
                                    startActivity(intent);
                                }
                            } else {

                                Toast.makeText(getApplicationContext(),
                                        "Login failed!",
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });
    }
}