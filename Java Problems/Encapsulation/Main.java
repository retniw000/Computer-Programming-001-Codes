import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = input.nextLine();
        account.set_strAccountHolder(name);

        System.out.print("Enter account number: ");
        String accNum = input.nextLine();
        account.set_strAccountNumber(accNum);

        System.out.print("Enter initial balance: ");
        double initialBalance = input.nextDouble();
        account.set_dblBalance(initialBalance);

        System.out.print("\n"); // for formatting purpose only
        account.displayAccountInfo();

        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = input.nextDouble();
        account.Deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = input.nextDouble();
        account.Withdraw(withdrawAmount);
        System.out.print("\n"); // for formatting purpose only
        account.displayAccountInfo();

        input.close();
    }
}