package com.example.healthyhair;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartingSurvey extends AppCompatActivity {

    private StartingSurveyQuestions startingSurveyQuestions = new StartingSurveyQuestions();
    private TextView questionView;
    private TextView scoreView;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private int score = 0;
    private int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_survey);

        questionView = (TextView) findViewById(R.id.question);
        scoreView = (TextView) findViewById(R.id.score);
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        choice3 = (Button) findViewById(R.id.choice3);

        choice1.setOnClickListener(view -> {
            score++;
            updateScore(score);
            updateQuestion();

        });

        choice2.setOnClickListener(view -> {
            score += 2;
            updateScore(score);
            updateQuestion();

        });

        choice3.setOnClickListener(view -> {
            score += 3;
            updateScore(score);
            updateQuestion();

        });
    }

    private void updateQuestion() {
        if (questionNumber < startingSurveyQuestions.questionsNumber()) {
            questionView.setText(startingSurveyQuestions.getQuestion(questionNumber));
            choice1.setText(startingSurveyQuestions.getChoice1(questionNumber));
            choice2.setText(startingSurveyQuestions.getChoice2(questionNumber));
            choice3.setText(startingSurveyQuestions.getChoice3(questionNumber));

            questionNumber++;
        } else {
            // Here the connectivity between Starting Survey and UserInterface will be implemented
        }
    }

    private void updateScore(int points) {
        scoreView.setText("" + points);
    }
}