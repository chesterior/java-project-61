package hexlet.code.games;

import java.util.Scanner;
import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS;

public class Calc {

    private static final int ROUNDS_COUNT = 3;

    public static void calcGame(String username) {
        RandomGenerator rnd = RandomGenerator.getDefault();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the result of the expression?");

        for (int round = 1; round <= ROUNDS; round++) {
            int a = rnd.nextInt(0, 101);
            int b = rnd.nextInt(0, 101);

            char op;
            int correctAnswer;
            switch (rnd.nextInt(3)) {
                case 0 -> {
                    op = '+';
                    correctAnswer = a + b;
                }
                case 1 -> {
                    op = '-';
                    correctAnswer = a - b;
                }
                default -> {
                    op = '*';
                    correctAnswer = a * b;
                }
            }

            System.out.printf("Question: %d %c %d%nYour answer: ", a, op, b);
            String input = scanner.nextLine().trim();

            int userAnswer;
            try {
                userAnswer = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.printf("'%s' is not a valid number.%nLet's try again, %s!%n",
                        input, username);
                return;
            }

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.printf(
                        "'%s' is wrong answer ;(. Correct answer was '%d'.%nLet's try again, %s!%n",
                        input, correctAnswer, username
                );
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", username);
    }
}
