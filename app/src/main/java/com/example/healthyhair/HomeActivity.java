package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private Button btnCompleteDailyTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCompleteDailyTest = findViewById(R.id.btnCompleteDailyTest);

        btnCompleteDailyTest.setOnClickListener(view -> {
            Intent intent1 = new Intent(HomeActivity.this, DailyPEHSurveyActivity.class);
            startActivity(intent1);
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.porosityNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    item.setChecked(true);
                    break;

                case R.id.cosmetics:
                    Intent intent2 = new Intent(HomeActivity.this, CosmeticsActivity.class);
                    startActivity(intent2);
                    item.setChecked(true);
                    break;

                case R.id.product:
                    Intent intent3 = new Intent(HomeActivity.this, ProductsActivity.class);
                    startActivity(intent3);
                    item.setChecked(true);
                    break;

                case R.id.survey:
                    Intent intent4 = new Intent(HomeActivity.this, SurveyActivity.class);
                    startActivity(intent4);
                    item.setChecked(true);
                    break;

                case R.id.settings:
                    Intent intent5 = new Intent(HomeActivity.this, SettingsActivity.class);
                    startActivity(intent5);
                    item.setChecked(true);
                    break;
            }

            return false;
        });
    }
}