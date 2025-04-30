package hexlet.code.games;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Gcd {

    public static void gcdGame(String username) {
        RandomGenerator rnd = RandomGenerator.getDefault();
        Scanner scanner = new Scanner(System.in);
        final int ROUNDS = 3;

        System.out.println("Find the greatest common divisor of given numbers.");

        for (int round = 1; round <= ROUNDS; round++) {
            int a = rnd.nextInt(1, 101);
            int b = rnd.nextInt(1, 101);

            int correctAnswer = gcd(a, b);

            System.out.printf("Question: %d %d%nYour answer: ", a, b);
            String input = scanner.nextLine().trim();

            int userAnswer;
            try {
                userAnswer = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.printf(
                        "'%s' is not a valid number.%nLet's try again, %s!%n",
                        input, username
                );
                return;
            }

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
            } else {
                System.out.printf(
                        "'%s' is wrong answer ;(. Correct answer was '%d'.%n" +
                                "Let's try again, %s!%n",
                        input, correctAnswer, username
                );
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", username);
    }

    private static int gcd(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
