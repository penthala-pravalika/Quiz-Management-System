package com.add.quiz;






import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuizManager qm = new QuizManager(sc);

        int choice = 0;

        // Menu-driven application
        while (choice != 5) {

            System.out.println("\n===== QUIZ APPLICATION =====");

            System.out.println("1. Add Question");
            System.out.println("2. Delete Question");
            System.out.println("3. Start Quiz");
            System.out.println("4. Display Questions");
            System.out.println("5. Terminate");

            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    qm.addQuestion();
                    break;

                case 2:
                    qm.deleteQuestion();
                    break;

                case 3:
                    qm.startQuiz();
                    break;

                case 4:
                    qm.displayQuestions();
                    break;

                case 5:
                    System.out.println("Quiz Application Terminated!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
