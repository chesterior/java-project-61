package hexlet.code.games;

import java.util.Scanner;
import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS;

public class Even {

    public static void evenGame(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < ROUNDS; i++) {
            int randomNumber = RandomGenerator.getDefault().nextInt(101);
            System.out.printf("Question: %d%nYour answer: ", randomNumber);
            Scanner s = new Scanner(System.in);
            String answer = s.nextLine();
            if ((answer.equals("yes") && randomNumber % 2 == 0) || answer.equals("no") && randomNumber % 2 != 0) {
                System.out.println("Correct!");
            } else if (answer.equals("yes")) {
                System.out.printf("'yes' is wrong answer ;(. Correct answer was 'no'.%nLet's try again, %s!", username);
                return;
            } else if (answer.equals("no")) {
                System.out.printf("'no' is wrong answer ;(. Correct answer was 'yes'.%nLet's try again, %s!", username);
                return;
            } else {
                System.out.println("Invalid choice.");
                return;
            }
        }
        System.out.printf("Congratulations, %s!%n", username);
    }
}
