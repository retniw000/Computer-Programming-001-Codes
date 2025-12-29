public class BankAccount {
  private String strAccountNumber;
  private String strAccountHolder;
  private double dblBalance;

  public void Deposit(double dblAddAmount) {
    if (dblAddAmount > 0) {
      this.dblBalance += dblAddAmount;
      System.out.println("Successfully deposited \u20B1" + dblAddAmount);
    } else System.out.println("Enter Positive Amount Only!");

  }

  public void Withdraw(double dblDeductAmount) {

    if (dblDeductAmount <= 0) {
      System.out.println("Error: Invalid withdrawal amount.");

    } else if (dblDeductAmount > this.dblBalance) {
      System.out.println("Error: Insufficient funds.");

    } else {
      this.dblBalance -= dblDeductAmount;
      System.out.println("Successfully withdrawn \u20B1" + dblDeductAmount);
    }
  }

  public void set_strAccountNumber(String strAccountNumber) {
    this.strAccountNumber = strAccountNumber;
  }

  public void set_strAccountHolder(String strAccountHolder) {
    this.strAccountHolder = strAccountHolder;
  }

  public void set_dblBalance(double dblBalance) {
    if (dblBalance >= 0) {
      this.dblBalance = dblBalance;
    } else System.err.println("Error: Balance cannot be negative.");
  }

  public String get_strAccountNumber() {
    return strAccountNumber;
  }

  public String get_strAccountHolder() {
    return strAccountHolder;
  }

  public double get_dblBalance() {
    return dblBalance;
  }

  public void displayAccountInfo() {
    System.out.println("--- Account Information ---");
    System.out.println("Account Holder: " + get_strAccountHolder());
    System.out.println("Account Number: " + get_strAccountNumber());
    System.out.println("Current Balance: \u20B1" + get_dblBalance());
  }
}
