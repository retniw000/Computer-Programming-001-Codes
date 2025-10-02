import java.util.Scanner;
//program is for polishing
public class AutomorphicNumber {
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.println(checkAutomorphic(number) ? "is an automorphic number" : "is not an automorphic number");

    }

    public static boolean checkAutomorphic(int number){
            
        int intSquare = number * number;

        while (number != 0){
            if (number % 10 != intSquare % 10){
                return false;
            }
            number = number /10;
            intSquare = intSquare/10;
        }
        return true;
        
    }
    
}
