package com.example.healthyhair;

public class DailyPEHSurveyQuestions {

    String [] question = {
            "Is your hair spinning?",
            "Is your hair dull?",
            "Is your hair dry?",
            "Does your hair break?",
            "Does your hair get static?",
            "Is your hair frizzy?",
            "Did you notice the straightening of the twist?",
            "Does your hair get greasy quickly?"
    };

    public String getQuestion(int a) {
        return question[a];
    }
}
