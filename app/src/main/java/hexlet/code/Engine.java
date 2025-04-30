package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;

    public static void engineForGames(String username, String gameDescription, String[][] roundsData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(gameDescription);

        for (int i = 0; i < ROUNDS; i++) {
            String question = roundsData[i][0];
            String correctAnswer = roundsData[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%nLet's try again, %s!%n",
                        userAnswer, correctAnswer, username);
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", username);
    }
}
