import java.util.Scanner;

abstract class Employee {
    String strName;

    abstract double CalculateSalary();
    abstract void displayInfo();

    void companyPolicy() {
        System.out.println("Company Policy: All employees must submit attendance before payroll processing.");
    }
}

class FullTimeEmployee extends Employee {
    double dbldailyRate;
    int intdaysWorked;

    FullTimeEmployee(String strName, double dbldailyRate, int intdaysWorked) {
        this.strName = strName;
        this.dbldailyRate = dbldailyRate;
        this.intdaysWorked = intdaysWorked;
    }

    @Override
    public double CalculateSalary() {
        return intdaysWorked * dbldailyRate;
    }

    @Override
    void displayInfo() {
        System.out.println("Salary: \u20B1" + CalculateSalary());
        companyPolicy();
    }
}

class PartTimeEmployee extends Employee {
    int inthoursWorked;
    double dblhourlyRate;

    PartTimeEmployee(String strName, double dblhourlyRate, int inthoursWorked) {
        this.strName = strName;
        this.dblhourlyRate = dblhourlyRate;
        this.inthoursWorked = inthoursWorked;
    }

    @Override
    public double CalculateSalary() {
        return inthoursWorked * dblhourlyRate;
    }

    @Override
    void displayInfo() {
        System.out.println("Salary: \u20B1" + CalculateSalary());
        companyPolicy();
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int intCounter = 0;
do{
        System.out.print("Enter employee type: ");
        String strType = input.nextLine();

        System.out.print("Enter name: ");
        String strName = input.nextLine();

        if (strType.equalsIgnoreCase("Full-Time")) {
            System.out.print("Enter daily rate: ");
            double dbldailyRate = input.nextDouble();

            System.out.print("Enter days worked: ");
            int intdaysWorked = input.nextInt();
            input.nextLine(); // for consuming next line

            FullTimeEmployee ftEmployee = new FullTimeEmployee(strName, dbldailyRate, intdaysWorked);
            ftEmployee.displayInfo();

        } else if (strType.equalsIgnoreCase("Part-Time")) {
            System.out.print("Enter hourly rate: ");
            double dblhourlyRate = input.nextDouble();

            System.out.print("Enter hours worked: ");
            int inthoursWorked = input.nextInt();
            input.nextLine(); // for consuming next line

            PartTimeEmployee ptEmployee = new PartTimeEmployee(strName, dblhourlyRate, inthoursWorked);
            ptEmployee.displayInfo();

        } 
        intCounter++;
    }while(intCounter < 2);

        input.close();
    }
}
