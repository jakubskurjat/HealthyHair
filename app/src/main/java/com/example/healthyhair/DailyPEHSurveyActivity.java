package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DailyPEHSurveyActivity extends AppCompatActivity {

    private DailyPEHSurveyQuestions dailyPEHSurveyQuestions = new DailyPEHSurveyQuestions();
    private TextView tvQuestionPEH;
    private ProgressBar progressBarPEH;
    private Button btnYes;
    private Button btnNo;
    private int pScore = 0;
    private int eScore = 0;
    private int hScore = 0;
    private int questionNumber = 0;
    int[] pPoints = {-1, -1, 0, 1, 0, 0, -1, -1, -1};
    int[] ePoints = {1, 1, -1, 0, -1, -1, -1, 1, 1};
    int[] hPoints = {-1, -1, 1, 0, 1, 0, 1, 1, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_peh_survey);

        progressBarPEH = findViewById(R.id.progressBarPEH);
        tvQuestionPEH = findViewById(R.id.tvQuestionPEH);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(view -> {
            pScore += pPoints[questionNumber];
            eScore += ePoints[questionNumber];
            hScore += hPoints[questionNumber];

            updateQuestion();

            progressBarPEH.incrementProgressBy((int) ((double) 100 / 9));
        });

        btnNo.setOnClickListener(view -> {
            updateQuestion();

            progressBarPEH.incrementProgressBy((int) ((double) 100 / 9));
        });
    }

    private void updateQuestion() {
        if (questionNumber < dailyPEHSurveyQuestions.questionsNumber()) {
            tvQuestionPEH.setText(dailyPEHSurveyQuestions.getQuestion(questionNumber));
            questionNumber++;
        } else {
            Intent intent = new Intent(DailyPEHSurveyActivity.this, HomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("yourResult", createResultWithAdvice());
            bundle.putBoolean("isDailySurveyDone", true);

            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    private String createResultWithAdvice() {
        String proteinsLevel;
        String emollientsLevel;
        String humectantsLevel;

        if (pScore < 0) {
            proteinsLevel = "deficiency";
        } else if (pScore == 0) {
            proteinsLevel = "in balanced";
        } else {
            proteinsLevel = "excess";
        }

        if (eScore < 0) {
            emollientsLevel = "deficiency";
        } else if (eScore == 0) {
            emollientsLevel = "in balanced";
        } else {
            emollientsLevel = "excess";
        }

        if (hScore < 0) {
            humectantsLevel = "deficiency";
        } else if (hScore == 0) {
            humectantsLevel = "in balanced";
        } else {
            humectantsLevel = "excess";
        }

        return "Your result:\n" + "Proteins: " + proteinsLevel + "\nEmullients: " + emollientsLevel + "\nHumectants: " + humectantsLevel;
    }
}