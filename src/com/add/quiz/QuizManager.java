
package com.add.quiz;




import java.util.ArrayList;
import java.util.Scanner;

public class QuizManager {

    private ArrayList<Question> questions = new ArrayList<>();

    private int id = 1;

    private Scanner sc;

    // Constructor
    public QuizManager(Scanner sc) {
        this.sc = sc;
    }

    // 1. Add Question
    public void addQuestion() {

        System.out.println("Enter the question:");
        String question = sc.nextLine();

        // Read four options
        String[] options = new String[4];

        for (int i = 0; i < options.length; i++) {

            System.out.println("Enter Option " + (i + 1) + ":");
            options[i] = sc.nextLine();
        }

        // Read correct answer
        System.out.println("Enter correct answer (1-4):");

        int correctAnswer = sc.nextInt();
        sc.nextLine();

        // Validate answer
        if (correctAnswer < 1 || correctAnswer > 4) {

            System.out.println("Invalid answer! Question not added.");
            return;
        }

        // Create Question object
        Question q = new Question(
            id, question, options, correctAnswer
        );

        // Add question to ArrayList
        questions.add(q);

        id++;

        System.out.println("Question added successfully!");
    }

    // 2. Delete Question
    public void deleteQuestion() {

        if (questions.isEmpty()) {

            System.out.println("No questions available!");
            return;
        }

        System.out.println("Enter Question ID to delete:");

        int deleteId = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (int i = 0; i < questions.size(); i++) {

            if (questions.get(i).getId() == deleteId) {

                questions.remove(i);

                found = true;

                System.out.println("Question deleted successfully!");

                break;
            }
        }

        if (!found) {

            System.out.println("Question not found!");
        }
    }

    // 3. Start Quiz
    public void startQuiz() {

        if (questions.isEmpty()) {

            System.out.println("No questions available! Add questions first.");
            return;
        }

        Quiz quiz = new Quiz(questions, sc);

        quiz.startQuiz();
    }

    // 4. Display Questions
    public void displayQuestions() {

        if (questions.isEmpty()) {

            System.out.println("No questions available!");
            return;
        }

        System.out.println("\n===== ALL QUESTIONS =====");

        for (Question q : questions) {

            System.out.println("\nQuestion ID: " + q.getId());

            System.out.println("Question: " + q.getQuestion());

            String[] options = q.getOptions();

            for (int i = 0; i < options.length; i++) {

                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }

    // Get Questions
    public ArrayList<Question> getQuestions() {

        return questions;
    }
}
