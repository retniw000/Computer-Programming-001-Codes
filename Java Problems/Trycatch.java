import java.util.InputMismatchException;
import java.util.Scanner;

public class Trycatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int integer = 0; // declare outside try

        try {
            System.out.print("Enter an integer: ");
            integer = input.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Enter a valid integer only, try again");
        }

        System.out.println("You entered: " + integer);
        input.close();
    }
}
