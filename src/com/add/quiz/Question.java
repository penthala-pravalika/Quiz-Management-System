
package com.add.quiz;


public class Question {

    private int id;
    private String question;
    private String[] options;
    private int correctAnswer;

    // Constructor
    public Question(int id, String question,
                    String[] options, int correctAnswer) {

        this.id = id;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
