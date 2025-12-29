import java.util.Scanner;

abstract class Shape {
  abstract double calculateArea();
  abstract void displayArea();
}

class Circle extends Shape {
  double dblRadius;

  Circle(double dblRadius) {
    this.dblRadius = dblRadius;
  }

  @Override
  double calculateArea() {
    return Math.PI * dblRadius * dblRadius;
  }

  @Override
  void displayArea() {
    System.out.printf("Area of Circle: %.2f%n", calculateArea());
  }
}

class Rectangle extends Shape {
  double dblWidth, dblHeight;

  Rectangle(double dblWidth, double dblHeight) {
    this.dblWidth = dblWidth;
    this.dblHeight = dblHeight;
  }

  @Override
  double calculateArea() {
    return dblWidth * dblHeight;
  }

  @Override
  void displayArea() {
    System.out.println("Area of Rectangle: " + calculateArea());
  }
}

class Triangle extends Shape {
  double dblBase, dblHeight;

  Triangle(double dblBase, double dblHeight) {
    this.dblBase = dblBase;
    this.dblHeight = dblHeight;
  }

  @Override
  double calculateArea() {
    return 0.5 * dblBase * dblHeight;
  }

  @Override
  void displayArea() {
    System.out.println("Area of Triangle: " + calculateArea());
  }
}

// Main class
public class Polymorphism {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Shape[] shapes = new Shape[3];

    System.out.print("Enter shape type: Circle\nEnter radius: ");
    double dblRadius = input.nextDouble();
    shapes[0] = new Circle(dblRadius);

    // Rectangle
    System.out.print("\nEnter shape type: Rectangle\nEnter width: ");
    double dblWidth = input.nextDouble();
    System.out.print("Enter height: ");
    double dblHeight = input.nextDouble();
    shapes[1] = new Rectangle(dblWidth, dblHeight);

    // Triangle
    System.out.print("\nEnter shape type: Triangle\nEnter base: ");
    double dblBase = input.nextDouble();
    System.out.print("Enter height: ");
    double dblTriHeight = input.nextDouble();
    shapes[2] = new Triangle(dblBase, dblTriHeight);

    System.out.println();

    for (int i = 0; i < shapes.length; i++) {
      shapes[i].displayArea();
    }

    input.close();
  }
}