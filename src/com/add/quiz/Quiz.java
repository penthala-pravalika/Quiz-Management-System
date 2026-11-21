
package com.add.quiz;


import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions;
    private Scanner sc;

    // Constructor
    public Quiz(ArrayList<Question> questions, Scanner sc) {

        this.questions = questions;
        this.sc = sc;
    }

    // Start quiz and assign score
    public void startQuiz() {

        int score = 0;

        if (questions.isEmpty()) {

            System.out.println("No questions available!");
            return;
        }

        System.out.println("\n===== QUIZ STARTED =====");

        for (Question question : questions) {

            System.out.println("\n" + question.getQuestion());

            // Display options
            String[] options = question.getOptions();

            for (int i = 0; i < options.length; i++) {

                System.out.println((i + 1) + ". " + options[i]);
            }

            // Get user answer
            System.out.println("Choose correct option (1-4):");

            int answer = sc.nextInt();

            while (answer < 1 || answer > 4) {

                System.out.println("Invalid choice! Enter 1-4:");
                answer = sc.nextInt();
            }

            // Check answer
            if (answer == question.getCorrectAnswer()) {

                System.out.println("Correct Answer!");
                score++;

            } else {

                System.out.println("Wrong Answer!");

                System.out.println("Correct Answer: "
                    + options[question.getCorrectAnswer() - 1]);
            }
        }

        // Display final result
        System.out.println("\n===== QUIZ COMPLETED =====");

        System.out.println("Total Questions: " + questions.size());

        System.out.println("Correct Answers: " + score);

        System.out.println("Wrong Answers: " + (questions.size() - score));

        System.out.println("Final Score: " + score + "/" + questions.size());
    }
}
