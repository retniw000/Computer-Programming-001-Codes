import java.util.Scanner;

public class TwinPrime {
    public static boolean checkPrime(int Number) {
        if (Number <= 1) {
            return false;  // 0 and 1 are not prime
        }

        for (int i = 2; i <= Math.sqrt(Number); i++) {
            if (Number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Range = 0;

        // Error handler for input
        System.out.print("Enter a range: ");
        while (!input.hasNextInt()) {   // check if input is not integer
            System.out.println("Invalid input! Please enter an integer.");
            input.next(); // discard the invalid input
            System.out.print("Enter a range: ");
        }
        Range = input.nextInt();

        // Display twin primes
        for (int i = 2; i < Range; i++) {
            if (checkPrime(i) && checkPrime(i + 2)) {
                System.out.print("(" + i + "," + (i + 2) + ") ");
            }
        }
    }
}
