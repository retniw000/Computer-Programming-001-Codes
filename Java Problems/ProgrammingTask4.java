import java.util.Scanner;
public class ProgrammingTask4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int exit;
        int start, interval;

        do { 
            System.out.print("Start : ");
            start = input.nextInt();
            System.out.print("Interval: ");
            interval = input.nextInt();
            System.out.print("Do you want to exit? 1: Yes 0: No  ");
            exit = input.nextInt();
        } while (exit != 1);




        input.close();
    }
}
