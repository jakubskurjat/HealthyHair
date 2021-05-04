package com.example.healthyhair;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DailyPEHSurveyActivity extends AppCompatActivity {

    private TextView tvQuestionPEH;
    private Button btnYes;
    private Button btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_peh_survey);

        tvQuestionPEH = findViewById(R.id.tvQuestionPEH);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
    }
}