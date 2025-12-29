import java.util.Scanner;

public class Inheritance {
  public static void main(String[] args) {
    Car myCar = new Car();
    Motorcycle myMotorcycle = new Motorcycle();
    Scanner input = new Scanner(System.in);
    int intCounter = 0;

    do {
      System.out.print("Enter vehicle type: ");
      String strType = input.nextLine();

      if (strType.equalsIgnoreCase("Car")) {
        System.out.print("Enter brand: ");
        myCar.strBrand = input.nextLine();
        System.out.print("Enter model: ");
        myCar.strModel = input.nextLine();
        System.out.print("Enter year: ");
        myCar.intYear = input.nextInt();
        System.out.print("Enter number of doors: ");
        myCar.intAmtDoor = input.nextInt();
        input.nextLine(); // for consuming next line

        myCar.displayDetails();
      } else if (strType.equalsIgnoreCase("Motorcycle")) {
        System.out.print("Enter brand: ");
        myMotorcycle.strBrand = input.nextLine();
        System.out.print("Enter model: ");
        myMotorcycle.strModel = input.nextLine();
        System.out.print("Enter year: ");
        myMotorcycle.intYear = input.nextInt();
        input.nextLine(); // for consuming next line
        System.out.print("Enter Engine Type: ");
        myMotorcycle.strEngineType = input.nextLine();

        myMotorcycle.displayDetails();
      }

      intCounter++;
    } while (intCounter < 2);

    input.close();
  }
}

class Vehicle {
  String strBrand;
  String strModel;
  int intYear;

  void displayDetails() {
    System.out.println("--- Vehicle Details --- ");
    System.out.println("Brand:" + strBrand + "| Model:" + strModel + "| Year:" + intYear);
  }
}

class Car extends Vehicle {
  int intAmtDoor;

  @Override
  void displayDetails() {
    System.out.println("--- Vehicle Details --- ");
    System.out.println("Brand: " + strBrand + " | Model: " + strModel + " | Year: " + intYear + " | Doors: " + intAmtDoor);
  }
}

class Motorcycle extends Vehicle {
  String strEngineType;

  @Override
  void displayDetails() {
    System.out.println("--- Vehicle Details --- ");
    System.out.println("Brand: " + strBrand + " | Model: " + strModel + " | Year: " + intYear + " | Engine: " + strEngineType);
  }
}