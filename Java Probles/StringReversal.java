import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
         System.out.print("Enter a string: ");
        String strInput = input.nextLine();

        do{
            System.out.println("No input detected try again!");
             System.out.print("Enter a string: ");
            strInput = input.nextLine();
        } while (strInput == "");
        String strReverse = "";  

        
        for (int i = strInput.length() - 1; i >= 0; i--) {
            strReverse += strInput.charAt(i);
        }

        System.out.println("Reversed string: " + strReverse);
    }
}
