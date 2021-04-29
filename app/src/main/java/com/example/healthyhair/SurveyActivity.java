package com.example.healthyhair;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.atomic.AtomicBoolean;

import static android.widget.Toast.LENGTH_LONG;

public class SurveyActivity extends AppCompatActivity {

    TextView tvPorosity;
    Button btnCheckPorosity;
    AtomicBoolean btnClicked = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        tvPorosity = findViewById(R.id.tvPorosity);
        btnCheckPorosity = findViewById(R.id.btnCheckPorosity);

        Intent intent = getIntent();

        int score = intent.getIntExtra("score", 0);

        btnCheckPorosity.setOnClickListener(view -> {
            Intent intent1 = new Intent(SurveyActivity.this, StartingSurvey.class);
            startActivity(intent1);
            btnClicked.set(true);
        });


        if (score <= 18) {
            tvPorosity.setText("HIGH POROSITY");
        } else if (score <= 26) {
            tvPorosity.setText("AVERAGE POROSITY");
        } else tvPorosity.setText("LOW POROSITY");


        BottomNavigationView bottomNavigationView = findViewById(R.id.porosityNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Toast.makeText(SurveyActivity.this, "Arrow", LENGTH_LONG).show();
                    item.setChecked(true);
                    break;

                case R.id.cosmetics:
                    Intent intent1 = new Intent(SurveyActivity.this, SignUpActivity.class);
                    startActivity(intent1);
                    item.setChecked(true);
                    break;

                case R.id.products:
                    Toast.makeText(SurveyActivity.this, "Books", LENGTH_LONG);
                    item.setChecked(true);
                    break;

                case R.id.survey:
                    Toast.makeText(SurveyActivity.this, "Center Focus", LENGTH_LONG).show();
                    item.setChecked(true);
                    break;

                case R.id.settings:
                    Toast.makeText(SurveyActivity.this, "Settings", LENGTH_LONG).show();
                    item.setChecked(true);
                    break;
            }

            return false;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        if (btnClicked.get()) {
            tvPorosity.setText(sh.getString("tvPorosity", tvPorosity.getText().toString()));
            myEdit.putString("tvPorosity", tvPorosity.getText().toString());
            myEdit.apply();
        } else {
            myEdit.clear();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("tvPorosity", tvPorosity.getText().toString());
        myEdit.apply();
    }
}