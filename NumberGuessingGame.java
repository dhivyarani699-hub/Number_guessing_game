import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int rounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            rounds++;
            int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean hasWon = false;

            System.out.println("\nRound " + rounds + " started!");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                    hasWon = true;

                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;

                    System.out.println(" You earned " + points + " points.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasWon) {
                System.out.println(" You've used all attempts!");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.println("Total Score: " + totalScore);

            // Ask for another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}