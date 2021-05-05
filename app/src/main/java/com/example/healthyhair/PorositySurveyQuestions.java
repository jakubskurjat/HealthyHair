package com.example.healthyhair;

public class PorositySurveyQuestions {

    private String quetions[] = {
            "How long does your hair dry?",
            "Does your hair glow in low light?",
            "What if you flip a strand of hair to the other side?",
            "Are they susceptible?",
            "What happens when you comb your hair?",
            "How does your hair feel?",
            "Is your hair getting tangled?",
            "Does your hair get frizzy often?",
            "Does your hair get damaged easily?",
            "Do you sometimes lighten or straighten/curl your hair with a curler?",
    };


    private String choices[][] = {
            {"Short (less than 1.5 hours)", "Medium (1.5 to 3 hours)", "Long (more than 3 hours)"},
            {"No", "They shine a little", "They definitely shine"},
            {"It will stay in this place", "It will slowly return to its side", "It will quickly return to its site"},
            {"Curls or waves are visible on them for a long time", "Curls or waves last for a while", "Curls or waves do not get out at all or straighten out very quickly"},
            {"They take on volume", "The volume does not change", "They are losing volume"},
            {"Smooth and soft", "Relatively smooth", "Rigid and rough"},
            {"Yes", "Sometimes", "No"},
            {"Yes, they are almost always frizzed", "Sometimes they frizz", "They never frizz"},
            {"Yes, I have to trim split ends frequently", "On average - I just need to cut my hair once every few months", "No, I hardly ever see split ends"},
            {"Yes, regularly", "Occasionally", "No"}
    };

    public String getQuestion(int a) {
        String question = quetions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = choices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = choices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = choices[a][2];
        return choice2;
    }

    public int questionsNumber() {
        return quetions.length;
    }
}
