package hexlet.code.games;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Prime {

    public static void primeGame(String username) {
        final int ROUNDS = 3;
        RandomGenerator rnd = RandomGenerator.getDefault();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int round = 1; round <= ROUNDS; round++) {
            int number = rnd.nextInt(0, 300);

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals("yes") && isPrime(number)) {
                System.out.println("Correct!");
            } else if (userAnswer.equals("no") && !isPrime(number)) {
                System.out.println("Correct!");
            } else if (userAnswer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\n" +
                        "Let's try again, " + username + "!");
                return;
            } else if (userAnswer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.\n" +
                        "Let's try again, " + username + "!");
                return;
            } else {
                System.out.println("Invalid choice.");
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", username);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
