package hexlet.code.games;

import java.util.Scanner;
import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS;

public class Prime {

    public static void primeGame(String username) {
        RandomGenerator rnd = RandomGenerator.getDefault();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int round = 1; round <= ROUNDS; round++) {
            int number = rnd.nextInt(0, 300);

            System.out.printf("Question: %d", number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals("yes") && isPrime(number)) {
                System.out.println("Correct!");
            } else if (userAnswer.equals("no") && !isPrime(number)) {
                System.out.println("Correct!");
            } else if (userAnswer.equals("yes")) {
                System.out.printf("'yes' is wrong answer ;(. Correct answer was 'no'.%nLet's try again, %s!", username);
                return;
            } else if (userAnswer.equals("no")) {
                System.out.printf("'no' is wrong answer ;(. Correct answer was 'yes'.%nLet's try again, %s!", username);
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
