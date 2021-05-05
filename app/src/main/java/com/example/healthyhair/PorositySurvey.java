package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PorositySurvey extends AppCompatActivity {

    private PorositySurveyQuestions porositySurveyQuestions = new PorositySurveyQuestions();
    private TextView questionView;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private ProgressBar progressBar;
    private int score = 0;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porosity_survey);

        questionView = findViewById(R.id.tvQuestionPorosity);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        progressBar = findViewById(R.id.progressBarSurvey);

        choice1.setOnClickListener(view -> {
            if (questionNumber == 0 | questionNumber == 6)
                score += 3;
            else
                score++;
            updateQuestion();

            progressBar.incrementProgressBy((int) ((double) 100 / 11));
        });

        choice2.setOnClickListener(view -> {
            score += 2;
            updateQuestion();

            progressBar.incrementProgressBy((int) ((double) 100 / 11));
        });

        choice3.setOnClickListener(view -> {
            if (questionNumber == 0 | questionNumber == 6)
                score++;
            else
                score += 3;
            updateQuestion();

            progressBar.incrementProgressBy((int) ((double) 100 / 11));
        });
    }

    private void updateQuestion() {
        if (questionNumber < porositySurveyQuestions.questionsNumber()) {
            questionView.setText(porositySurveyQuestions.getQuestion(questionNumber));
            choice1.setText(porositySurveyQuestions.getChoice1(questionNumber));
            choice2.setText(porositySurveyQuestions.getChoice2(questionNumber));
            choice3.setText(porositySurveyQuestions.getChoice3(questionNumber));

            questionNumber++;
        } else {
            Intent intent = new Intent(PorositySurvey.this, SurveyActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }
}